package br.com.netodevel.generators.java.service;

import br.com.netodevel.core.Generator;

public class GeneratorCleanService extends Generator {

	public GeneratorCleanService(String nameModel) {
		super(nameModel);
	}

	public String layer() {
		return "service";
	}

	public String packageName() {
		return "service";
	}

	public String templateFile() {
		return "template-clean-service.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${className}", nameClass);
	}

}
