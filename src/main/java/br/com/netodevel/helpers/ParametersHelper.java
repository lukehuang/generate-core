package br.com.netodevel.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.netodevel.core.GeneratorConstants;

public class ParametersHelper {

	public static String[] extractParameter(String parameters) {
		String[] separator = parameters.split(GeneratorConstants.SPACE);
		return separator;
	}
	
	public static List<String> convertToList(String[] parameters) {
		return new ArrayList<String>(Arrays.asList(parameters));
	}
	
	public static String[] extractNameAndType(String param) {
		String [] nameAndType = param.split(":");
		return nameAndType;
	}
	
}
