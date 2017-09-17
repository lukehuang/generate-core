package br.com.netodevel.generators.java.repository;

import br.com.netodevel.core.Generator;
import br.com.netodevel.core.GeneratorOptions;

public class GeneratorCleanRepository extends Generator {

	public GeneratorCleanRepository(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public String layer() {
		return "repository";
	}

	public String packageName() {
		return "repository";
	}

	public String templateFile() {
		return "template-clean-repository.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", getPackage() + ".repository")
				.replace("${className}", generatorOptions.getNameModel());
	}

}
