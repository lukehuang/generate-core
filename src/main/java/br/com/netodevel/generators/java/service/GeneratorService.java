package br.com.netodevel.generators.java.service;

import br.com.netodevel.core.Generator;
import br.com.netodevel.core.GeneratorOptions;

public class GeneratorService extends Generator {
	
	public GeneratorService(GeneratorOptions generatorOptions) {
		super(generatorOptions);
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
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", getPackage() + ".service")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${package_repository}", getPackage() + ".repository")
				.replace("${className}", generatorOptions.getNameModel())
				.replace("${paramClassName}", generatorOptions.getNameModel().toLowerCase());
	}

}
