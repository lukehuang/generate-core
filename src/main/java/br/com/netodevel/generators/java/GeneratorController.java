package br.com.netodevel.generators.java;

import br.com.netodevel.core.Generator;

public class GeneratorController extends Generator {

	public GeneratorController(String nameModel) {
		super(nameModel);
	}

	public String packageName() {
		return "generators";
	}

	public String layer() {
		return "Controller";
	}

	public String templateFile() {
		return "controller-rest.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${name_model}", nameClass)
				.replace("${folder_name}", nameClass.toLowerCase());
	}

}
