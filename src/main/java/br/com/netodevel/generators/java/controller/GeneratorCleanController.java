package br.com.netodevel.generators.java.controller;

import br.com.netodevel.core.Generator;

/**
 * @author NetoDevel
 */
public class GeneratorCleanController extends Generator {

	public GeneratorCleanController(String nameModel) {
		super(nameModel);
	}

	public String packageName() {
		return "controller";
	}

	public String layer() {
		return "controller";
	}

	public String templateFile() {
		return "template-clean-controller.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${path}", nameClass.toLowerCase())
				.replace("${className}", nameClass);
	}

}
