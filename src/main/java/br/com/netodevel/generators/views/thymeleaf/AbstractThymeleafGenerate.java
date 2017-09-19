package br.com.netodevel.generators.views.thymeleaf;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import br.com.netodevel.core.ReadScaffoldInfo;
import br.com.netodevel.helpers.ParametersHelper;

/**
 * @author NetoDevel
 */
public class AbstractThymeleafGenerate extends ReadScaffoldInfo {
	
	private static final String TABS_INDEX = "					";
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
	
	public String generateTh(String param) {
		String[] paramSplit = param.split(":");
		String name = StringUtils.capitalize(paramSplit[0]);

		String code = "\t\t\t <th>" + name + "</th> \n";
		return code;
	}
	
	public String generateTdParameters(String className, String parameters) {
		String [] params = parameters.split(" ");
		String tdParameters = "";
		for (int i = 0; i < params.length; i++) {
			String [] nameAndType = params[i].split(":");
			tdParameters += TABS_INDEX + "<td th:text=\"${" + className.toLowerCase() + "." + nameAndType[0] + "}\"></td> \n";
		}
		
		tdParameters += TABS_INDEX + "<td>\n";
		tdParameters += TABS_INDEX + "		<a th:href=\"@{/"+ className.toLowerCase() + "s/{id}(id = " + "${" + className.toLowerCase() + ".id}" + ")}\">Show</a> \n";
		tdParameters += TABS_INDEX + " 		<a th:href=\"@{/"+ className.toLowerCase() + "s/{id}/edit(id = " + "${" + className.toLowerCase() + ".id}" + ")}\">Edit</a> \n";
		tdParameters += TABS_INDEX + "		<a href=\"#\">Destroy</a> \n";
		tdParameters += TABS_INDEX + "</td>";
		return tdParameters;
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
		System.out.println(g.generateThParameters("name:String idade:Integer date:Date"));
	}
	
}