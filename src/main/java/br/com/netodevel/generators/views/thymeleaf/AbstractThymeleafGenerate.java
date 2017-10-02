package br.com.netodevel.generators.views.thymeleaf;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import br.com.netodevel.core.Attribute;
import br.com.netodevel.core.ReadScaffoldInfo;
import br.com.netodevel.helpers.ParametersHelper;

/**
 * @author NetoDevel
 */
public class AbstractThymeleafGenerate extends ReadScaffoldInfo {
	
	private static final String TABS_FORM = "				";
	private static final String TABS_SHOW = "		";
	
	public String generateThParameters(String parameters) {
		String [] params = ParametersHelper.extractParameter(parameters);
		List<String> listParameters = ParametersHelper.convertToList(params);
		
		String result = listParameters.stream()
					  .map(this::generateTh)
					  .collect(Collectors.joining());
		
		String thAction = "\t\t\t <th>Action</th>";
		return result + thAction;
	}
	
	/**
	 * Code Result:
	 *   <th> Name </th>
	 * @param param
	 * @return
	 */
	public String generateTh(String param) {
		String[] paramSplit = param.split(":");
		String name = StringUtils.capitalize(paramSplit[0]);

		String code = "\t\t\t <th>" + name + "</th> \n";
		return code;
	}
	
	public String generateTdParameters(String className, String parameters) {
		String [] params = ParametersHelper.extractParameter(parameters);
		List<String> listParameters = ParametersHelper.convertToList(params);

		String result = listParameters.stream()
				  .map(param -> generateTd(className, param))
				  .collect(Collectors.joining());
		
		return result + generateTdLinks(className);
	}
	
	/**
	 * Code Result:
	 * 	 <td th:text="${user.name}"></td> 
	 * @param className
	 * @param parameters
	 * @return
	 */
	public static String generateTd(String className, String parameters) {
		Attribute attribute = ParametersHelper.extractNameAndType(parameters);
		String code = "<td th:text=\"${" + className.toLowerCase() + "." + attribute.getName() + "}\"></td> \n";
		return code;
	}
	
	/**
	 * Code Result:
	 * 	<td>
	 * 		 <a th:href="@{/users/{id}(id = ${user.id})}">Show</a> 
     *		 <a th:href="@{/users/{id}/edit(id = ${user.id})}">Edit</a> 
     *		 <a href="#">Destroy</a> 
     *	</td>
	 * @param className
	 * @return
	 */
	public static String generateTdLinks(String className) {
		String code = "<td>\n"
							+ "  <a th:href=\"@{/"+ className.toLowerCase() + "s/{id}(id = " + "${" + className.toLowerCase() + ".id}" + ")}\">Show</a> \n"
							+ "  <a th:href=\"@{/"+ className.toLowerCase() + "s/{id}/edit(id = " + "${" + className.toLowerCase() + ".id}" + ")}\">Edit</a> \n"
							+ "  <a href=\"#\">Destroy</a> \n"
					+ "</td>";
		return code;
	}

	public static String generateInputParameters(String parameters) {
		String inputParameters = "";
		String [] params = parameters.split(" ");
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			
			inputParameters += TABS_FORM + "<div class=\"form-group\"> \n";
			inputParameters += TABS_FORM + "	<label for=\""+ nameAndType[0] +"\">"+ StringUtils.capitalize(nameAndType[0]) +"</label>  \n";
			inputParameters += TABS_FORM + "	<input id=\""+ nameAndType[0] +"\" name=\"" + nameAndType[0] + "\" type=\"text\" class=\"form-control\" th:field=\"*{"+ nameAndType[0] +"}\" />  \n";
			inputParameters += TABS_FORM + "</div> \n";
		}
		
		return inputParameters;
	}
	
	public String generateShowParameters(String paramClassName, String parameters) {
		String inputParameters = "";
		String [] params = parameters.split(" ");
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			inputParameters += TABS_SHOW + "<div class=\"form-group\"> \n";
			inputParameters += TABS_SHOW + "	<label for=\""+ nameAndType[0] +"\">"+ StringUtils.capitalize(nameAndType[0]) +": </label>  \n";
			inputParameters += TABS_SHOW + "	<span th:text=\"${" + paramClassName + "." + nameAndType[0] + "}\"></span> \n";
			inputParameters += TABS_SHOW + "</div> \n";
		}
		return inputParameters;
	}
	
	public static void main(String[] args) {
		AbstractThymeleafGenerate g = new AbstractThymeleafGenerate();
		System.out.println(g.generateTdParameters("User", "name:String email:String"));
	}
	
}