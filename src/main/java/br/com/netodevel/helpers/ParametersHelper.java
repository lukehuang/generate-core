package br.com.netodevel.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.netodevel.core.GeneratorConstants;

/**
 * @author NetoDevel
 * @author IvanMarreta
 */
public class ParametersHelper {

	public static List<String> extractParametersList(String parameters) {
		String[] separator = ParametersHelper.extractParameter(parameters);
		List<String> parametersList = ParametersHelper.convertToList(separator);
		return parametersList;
	}
	
	public static String[] extractParameter(String parameters) {
		String[] separator = parameters.split(GeneratorConstants.SPACE);
		return separator;
	}
	
	public static List<String> convertToList(String[] parameters) {
		return new ArrayList<String>(Arrays.asList(parameters));
	}
	
	public static Attribute extractNameAndType(String param) {
		String [] nameAndType = param.split(":");
		return new Attribute(nameAndType[0], nameAndType[1]);
	}
	
	public static class Attribute {
		
		public String name;
		public String type;

		public Attribute(){
		}
		
		public Attribute(String name, String type) {
			super();
			this.name = name;
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
}
