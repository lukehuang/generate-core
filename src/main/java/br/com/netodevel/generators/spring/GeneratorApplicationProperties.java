package br.com.netodevel.generators.spring;

import br.com.netodevel.core.GeneratorOptions;
import br.com.netodevel.core.GeneratorResource;

public class GeneratorApplicationProperties extends GeneratorResource {

	public GeneratorApplicationProperties(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public String folder() {
		return "";
	}

	public String layer() {
		return "spring";
	}

	public String templateFile() {
		return "template-application-props.txt";
	}

	public String packageName() {
		return "";
	}

	@Override
	protected String operationGenerate(String javaStrings, String database, String orm, String server) {
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
