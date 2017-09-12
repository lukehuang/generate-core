package br.com.netodevel.generators.java.service;

import br.com.netodevel.core.Generator;

public class GeneratorService extends Generator {
	
	public GeneratorService(String nameModel) {
		super(nameModel);
	}

	public String layer() {
		return "service";
	}

	public String packageName() {
		return "service";
	}

	public String templateFile() {
		return "template-service.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase());

	}

}
