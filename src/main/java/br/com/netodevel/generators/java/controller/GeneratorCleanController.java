package br.com.netodevel.generators.java.controller;

import br.com.netodevel.core.Generator;
import br.com.netodevel.core.GeneratorOptions;

/**
 * @author NetoDevel
 */
public class GeneratorCleanController extends Generator {

	public GeneratorCleanController(GeneratorOptions generatorOptions) {
		super(generatorOptions);
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
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", getPackage() + ".controller")
				.replace("${path}", generatorOptions.getNameModel().toLowerCase())
				.replace("${className}", generatorOptions.getNameModel());
	}

	public static void main(String[] args) {
		GeneratorOptions options = new GeneratorOptions()
				.setNameModel("User");
		
		new GeneratorCleanController(options).generate();
	}
	
}
