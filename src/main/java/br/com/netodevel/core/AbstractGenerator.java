package br.com.netodevel.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public abstract class AbstractGenerator extends ReadScaffoldInfo implements GeneratorBase {
	
	public static final String LANGUAGE_DEFAULT = "java";
	
	public String language() {
		return LANGUAGE_DEFAULT;
	}
	
	public String loadTemplateFile(String fileName) throws IOException {
		InputStream in = getClass().getResourceAsStream("/templates/java/" + fileName);
		String theString = IOUtils.toString(in, "UTF-8"); 
		return theString;
	}

	public void createNewFile(String javaStrings, String fileOutPutName) throws IOException {
		
		fileOutPutName = getPathPackage() + packageName() + "/" + fileOutPutName 
				+ StringUtils.capitalize(layer()) + "." + language();
		
		File newJavaFile = new File(fileOutPutName);
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("created");
	}
	
}
