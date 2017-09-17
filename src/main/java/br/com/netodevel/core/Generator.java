package br.com.netodevel.core;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class Generator extends AbstractGenerator {
	
	private String javaStrings;
	private GeneratorOptions generateOptions;
	
	public Generator(GeneratorOptions generatorOptions) {
		this.generateOptions = generatorOptions;
	}
	
	protected abstract String operationGenerate(String javaStrings, GeneratorOptions generatorOptions);
	
	public Generator generate() {
		try {
			this.javaStrings = loadTemplateFile(templateFile()); 
			String replaceStrings = operationGenerate(this.javaStrings, this.generateOptions);
			createNewFile(replaceStrings, this.generateOptions.getNameModel());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

}
