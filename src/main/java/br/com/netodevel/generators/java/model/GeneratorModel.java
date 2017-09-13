package br.com.netodevel.generators.java.model;

import br.com.netodevel.core.Generator;

/**
 * @author NetoDevel
 */
public class GeneratorModel extends Generator {

	public GeneratorModel(String nameModel, String parameters) {
		super(nameModel, parameters);
	}

	public String layer() {
		return "model";
	}

	public String packageName() {
		return "model";
	}

	public String templateFile() {
		return "template-model.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, String nameClass, String parameters) {
		return javaStrings.replace("${package}", getPackage() + ".model")
				.replace("${imports}", ModelGenerateUtils.generateImports(parameters))
				.replace("${className}", nameClass)
				.replace("${name_table}", nameClass.toLowerCase() + "s")
				.replace("${parameters}", ModelGenerateUtils.generateParams(parameters))
				.replace("${getters}", ModelGenerateUtils.generateGettersAndSetters(parameters));
	}

}
