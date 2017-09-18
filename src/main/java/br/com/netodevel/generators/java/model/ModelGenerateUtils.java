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

	private final static String TAB = " ";

	public static String generateImports(String parameters) {
		String[] separator = parameters.split(" ");
		List<String> parametersList = new ArrayList<String>(Arrays.asList(separator));

		String result = parametersList.stream()
						.map(ModelGenerateUtils::getTypeParam)
						.collect(Collectors.joining("\n"));
		return result;
	}
	
	public static String getTypeParam(String param) {
		String [] type = param.split(":");
		return VariableTypeImport.valueOf(type[1].toUpperCase()).path();
	}

	public static String generateGettersAndSetters(String parameters) {
		String[] separator = parameters.split(" ");
		String gettersAndSetters = "";
		for (int i = 0; i < separator.length; i++) {
			String [] nameAndType = separator[i].split(":");
			String name = nameAndType[0];
			String type = nameAndType[1];

			//SETTER
			gettersAndSetters += TAB + "public void set" + StringUtils.capitalize(name) + "(" + type + " " + name + ") {" ;
			gettersAndSetters += "this." + name + " = " + name + ";";
			gettersAndSetters += "}";

			gettersAndSetters += GeneratorConstants.BREAK_LINE;

			//GETTER
			gettersAndSetters += TAB + "public " + type + " get" + StringUtils.capitalize(name) + "() {" ;
			gettersAndSetters += "return " + name + ";";
			gettersAndSetters += "}";

			gettersAndSetters += GeneratorConstants.BREAK_LINE;
		}
		return gettersAndSetters;
	}


	public static String generateParams(String params) {
		String[] variablesSplits = params.split(" ");
		String finalParameters = "";
		for (int i = 0; i < variablesSplits.length; i++) {

			String [] typeAndNameVars = variablesSplits[i].split(":");

			String column = "    @Column(name = \"" + typeAndNameVars[0] + "\")";
			String lineVariables = "    private " + typeAndNameVars[1] + " " + typeAndNameVars[0] + ";";
			String lineClean = GeneratorConstants.BREAK_LINE;

			finalParameters += lineClean;
			finalParameters += column;
			finalParameters += lineClean;
			finalParameters += lineVariables;
			finalParameters += lineClean;
		}
		return finalParameters;
	}

}