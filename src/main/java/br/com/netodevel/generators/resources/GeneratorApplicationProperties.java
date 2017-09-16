package br.com.netodevel.generators.resources;

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
		System.out.println("ORM: " + this.generatorOptions.getOrm());
		return null;
	}
	
	public static void main(String[] args) {
		GeneratorOptions options = new GeneratorOptions()
				.setDatabase("mysql")
				.setOrm("jpa")
				.setServer("tomcat");
		new GeneratorApplicationProperties(options).generate("application.properties");
	}
	
}
