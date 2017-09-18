package br.com.netodevel.generators.java.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import br.com.netodevel.core.GeneratorConstants;

/**
 * @author NetoDevel, IvanMarreta
 */
public class ModelGenerateUtils {

	public static String generateImports(String parameters) {
		String[] separator = parameters.split(GeneratorConstants.SPACE);
		List<String> parametersList = new ArrayList<String>(Arrays.asList(separator));

		String result = parametersList.stream()
						.map(ModelGenerateUtils::getTypeParam)
						.collect(Collectors.joining("\n"));
		return result;
	}

	public static String generateGettersAndSetters(String parameters) {
		String[] separator = parameters.split(GeneratorConstants.SPACE);
		List<String> parametersList = new ArrayList<String>(Arrays.asList(separator));

		String result = parametersList.stream()
					  				  .map(ModelGenerateUtils::generateGetterAndSetters)
					  				  .collect(Collectors.joining());
		return result;
	}
	
	public static String generateParams(String params) {
		String[] variablesSplits = params.split(GeneratorConstants.SPACE);
		List<String> parametersList = new ArrayList<String>(Arrays.asList(variablesSplits));
			
		String result = parametersList.stream()
				.map(ModelGenerateUtils::generateAttribute)
				.collect(Collectors.joining(GeneratorConstants.BREAK_LINE));
		return result;
	}
	
	public static String generateGetterAndSetters(String param) {
		String [] nameAndType = param.split(":");

		String name = nameAndType[0];
		String type = nameAndType[1];

		String setter = buildSetter(name, type);
		String getter = buildGetter(name, type);
		
		return setter + getter;
	}
	
	public static String getTypeParam(String param) {
		String [] type = param.split(":");
		return VariableTypeImport.valueOf(type[1].toUpperCase()).path();
	}

	private static String buildGetter(String name, String type) {
		StringBuilder builderGetter = new StringBuilder();
		builderGetter.append("\t ");
		builderGetter.append("public ");
		builderGetter.append(type);
		builderGetter.append(" get");
		builderGetter.append(StringUtils.capitalize(name));
		builderGetter.append("() {");
		builderGetter.append("return ");
		builderGetter.append(name);
		builderGetter.append(";");
		builderGetter.append("}");
		builderGetter.append(GeneratorConstants.BREAK_LINE);
		return builderGetter.toString();
	}

	private static String buildSetter(String name, String type) {
		StringBuilder builderSetter = new StringBuilder();
		builderSetter.append("\t ");
		builderSetter.append("public void set");
		builderSetter.append(StringUtils.capitalize(name));
		builderSetter.append("(");
		builderSetter.append(type);
		builderSetter.append(GeneratorConstants.SPACE);
		builderSetter.append(name);
		builderSetter.append(") {");
		builderSetter.append("this.");
		builderSetter.append(name);
		builderSetter.append(" = ");
		builderSetter.append(name);
		builderSetter.append(";");
		builderSetter.append("}");
		builderSetter.append(GeneratorConstants.BREAK_LINE);
		return builderSetter.toString();
	}
	
	public static String generateAttribute(String param) {
		String [] splitParam = param.split(":");
		
		String name = splitParam[0];
		String type = splitParam[1];

		String column = buildColumn(name);
		String attribute = buildAttribute(name, type);
		
		String result = column + GeneratorConstants.SPACE 
						+ attribute + GeneratorConstants.BREAK_LINE;
		return result;
	}

	private static String buildAttribute(String name, String type) {
		StringBuilder buildAttribute = new StringBuilder();
		buildAttribute.append("\t private ");
		buildAttribute.append(type);
		buildAttribute.append(GeneratorConstants.SPACE);
		buildAttribute.append(name);
		buildAttribute.append(";");
		return buildAttribute.toString();
	}

	private static String buildColumn(String name) {
		StringBuilder buildColumn = new StringBuilder();
		buildColumn.append("\t @Column(name = \"");
		buildColumn.append(name);
		buildColumn.append("\")");
		buildColumn.append(GeneratorConstants.BREAK_LINE);
		return buildColumn.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(ModelGenerateUtils.generateGetterAndSetters("name:String idade:Integer date:Date"));
	}
	
}