package br.com.netodevel.generators.java.service;

import br.com.netodevel.core.Generator;
import br.com.netodevel.core.GeneratorOptions;

public class GeneratorCleanService extends Generator {

	public GeneratorCleanService(GeneratorOptions generatorOptions) {
		super(generatorOptions);
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
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${className}", generatorOptions.getNameModel());
	}

}
