package br.com.netodevel.core;

import java.io.IOException;

/**
 * @author NetoDevel
 */
public abstract class Generator extends AbstractGenerator {
	
	private String nameModel;
	private String parameters;
	private String javaStrings;
	
	public Generator(String nameModel, String parameters) {
		this.nameModel = nameModel;
		this.parameters = parameters;
	}
	
	public Generator(String nameModel) {
		this.nameModel = nameModel;
	}
	
	public Generator(){
	}
	
	protected abstract String operationGenerate(String javaStrings, String nameClass, String parameters);
	
	public Generator generate() {
		try {
			this.javaStrings = loadTemplateFile(templateFile()); 
			String replaceStrings = operationGenerate(this.javaStrings, this.nameModel, this.parameters);
			createNewFile(replaceStrings, this.nameModel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

}
