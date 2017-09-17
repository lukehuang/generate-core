package br.com.netodevel.core;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class GeneratorResource extends AbstractGeneratorResource implements GeneratorResourceBase {
	
	public static final String ROOT = "";
	protected GeneratorOptions generatorOptions;
	
	public GeneratorResource() {
	}
	
	public GeneratorResource(GeneratorOptions generatorOptions) {
		this.generatorOptions = generatorOptions;
	}
	
	protected abstract String operationGenerate(String javaStrings, GeneratorOptions generateOptions);
	
	public void generate(String resourceName) {
		try {
			String javaStrings = loadTemplateFileResources(templateFile());
			String replaceStrings = operationGenerate(javaStrings, this.generatorOptions);
			
			createNewResource(replaceStrings, resourceName, folder());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
