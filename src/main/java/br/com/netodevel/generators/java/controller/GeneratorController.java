package br.com.netodevel.generators.java.controller;

import br.com.netodevel.core.Generator;

public class GeneratorController extends Generator {

	public GeneratorController(String nameModel) {
		super(nameModel);
	}

	public String layer() {
		return "controller";
	}

	public String packageName() {
		return "controller";
	}

	public String templateFile() {
		return "template-controller.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_service}", getPackage() + ".service")
				.replace("${className}", nameClass)
				.replace("${paramClassName}", nameClass.toLowerCase())
				.replace("${url_path}", nameClass.toLowerCase() + "s");
	}

}
