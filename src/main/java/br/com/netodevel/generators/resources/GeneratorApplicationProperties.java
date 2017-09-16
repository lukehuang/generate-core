package br.com.netodevel.generators.resources;

import java.io.IOException;

import br.com.netodevel.core.GeneratorOptions;
import br.com.netodevel.core.GeneratorResource;

public class GeneratorApplicationProperties extends GeneratorResource {

	public GeneratorApplicationProperties(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public String folder() {
		return ROOT;
	}

	public String layer() {
		return "spring";
	}

	public String templateFile() {
		return "template-application-props.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String database, String orm, String server) {
		/**
		 * TODO: factory to all orms supported
		 */
		if(orm.equals("jpa")) {
			javaStrings = javaStrings.replace("${jpa_config}", ConfigProps.JPA_CONFIG);
		}
		
		/**
		 * TODO: factory to all server supported
		 */
		if (server.equals("tomcat")) {
			javaStrings = javaStrings.replace("${server_config}", ConfigProps.TOMCAT_CONFIG);
		}
		
		try {
			javaStrings = javaStrings.replace("${database_name}", getNameDatabase())
					.replace("${database}", database)
					.replace("${user_database}", getUserDatabase())
					.replace("${password_database}", getPassWordDatabase());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return javaStrings;
	}
	
	public static void main(String[] args) {
		GeneratorOptions options = new GeneratorOptions()
				.setDatabase("mysql")
				.setOrm("jpa")
				.setServer("tomcat");
		
		new GeneratorApplicationProperties(options).generate("application.properties");
	}
	
}
