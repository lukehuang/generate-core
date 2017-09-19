package br.com.netodevel.generators.java.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import br.com.netodevel.core.GeneratorConstants;
import br.com.netodevel.helpers.ParametersHelper;

/**
 * @author NetoDevel
 * @author IvanMarreta
 */
public class ModelGenerateUtils {

	public static String generateImports(String parameters) {
		String[] separator = ParametersHelper.extractParameter(parameters);
		List<String> parametersList = ParametersHelper.convertToList(separator);

		String result = parametersList.stream()
						.map(ModelGenerateUtils::getTypeParam)
						.collect(Collectors.joining("\n"));
		return result;
	}

	public static String generateGettersAndSetters(String parameters) {
		String[] separator = ParametersHelper.extractParameter(parameters);
		List<String> parametersList = ParametersHelper.convertToList(separator);
		
		String result = parametersList.stream()
						.map(ModelGenerateUtils::generateGetterAndSetters)
						.collect(Collectors.joining());
		return result;
	}
	
	public static String generateParams(String params) {
		String[] variablesSplits = ParametersHelper.extractParameter(params);
		List<String> parametersList = ParametersHelper.convertToList(variablesSplits);
			
		String result = parametersList.stream()
						.map(ModelGenerateUtils::generateAttribute)
						.collect(Collectors.joining(GeneratorConstants.BREAK_LINE));
		return result;
	}
	
	
	
	public static String generateGetterAndSetters(String param) {
		String[] nameAndType = ParametersHelper.extractNameAndType(param);

		String name = nameAndType[0];
		String type = nameAndType[1];

		String setter = buildSetter(name, type);
		String getter = buildGetter(name, type);
		
		return setter + getter;
	}

	public static String getTypeParam(String param) {
		String[] type = ParametersHelper.extractNameAndType(param);
		return VariableTypeImport.valueOf(type[1].toUpperCase()).path();
	}

	private static String buildGetter(String name, String type) {
		String attribute = StringUtils.capitalize(name);

		String code = "\n\t public " + type + " get" + attribute + "() {\n" 
				      + "\t\t return this." + name + ";\n"
				      + "\t }\n";
		return code;
	}

	private static String buildSetter(String name, String type) {
		String attribute = StringUtils.capitalize(name);

		String code = "\n\t public void set" + attribute + "(" + type + " " + name + ") {\n"
					  + "\t\t this." + name + " = " + name + ";\n"
					  + "\t }\n";
		return code;
	}
	
	public static String generateAttribute(String param) {
		String[] splitParam = ParametersHelper.extractNameAndType(param);
		
		String name = splitParam[0];
		String type = splitParam[1];

		String column = buildColumn(name);
		String attribute = buildAttribute(name, type);
		
		String result = column + attribute;
		return result;
	}

	private static String buildAttribute(String name, String type) {
		String code = "\t private " + type + GeneratorConstants.SPACE + name + ";\n";
		return code;
	}

	private static String buildColumn(String name) {
		String code = "\t @column(name=\"" + name + "\")\n";
		return code;
	}
	
	public static void main(String[] args) {
		System.out.println(ModelGenerateUtils.generateGetterAndSetters("name:String idade:Integer date:Date"));
	}
	
}