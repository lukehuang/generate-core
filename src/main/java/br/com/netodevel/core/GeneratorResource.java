package br.com.netodevel.core;

import java.io.IOException;

public abstract class GeneratorResource extends AbstractGenerator implements GeneratorResourceBase {

	protected GeneratorOptions generatorOptions;
	
	public GeneratorResource(GeneratorOptions generatorOptions) {
		this.generatorOptions = generatorOptions;
	}
	
	protected abstract String operationGenerate(String javaStrings, 
				String database, String orm, String server);
	
	public void generate(String resourceName) {
		try {
			String javaStrings = loadTemplateFile(templateFile());
			String replaceStrings = operationGenerate(javaStrings, this.generatorOptions.getDatabase(),
					this.generatorOptions.getOrm(), this.generatorOptions.getServer());
			
			createNewResource(replaceStrings, resourceName, folder());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
