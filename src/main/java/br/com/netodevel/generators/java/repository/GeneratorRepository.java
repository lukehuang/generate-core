package br.com.netodevel.generators.java.repository;

import br.com.netodevel.core.Generator;

public class GeneratorRepository extends Generator {

	public GeneratorRepository(String nameModel) {
		super(nameModel);
	}

	public String layer() {
		return "repository";
	}

	public String packageName() {
		return "repository";
	}

	public String templateFile() {
		return "template-repository.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".repository")
				.replace("${package_model}", getPackage() + ".model")
				.replace("${className}", nameClass);
	}

}
