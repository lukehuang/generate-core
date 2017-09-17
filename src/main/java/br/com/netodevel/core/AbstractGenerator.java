package br.com.netodevel.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author NetoDevel
 */
public abstract class AbstractGenerator extends ReadScaffoldInfo implements GeneratorBase {
	
	public static final String LANGUAGE_DEFAULT = "java";
	
	public String language() {
		return LANGUAGE_DEFAULT;
	}
	
	public String loadTemplateFile(String fileName) throws IOException {
		InputStream in = getClass().getResourceAsStream("/templates/java/" + layer() + GeneratorConstants.SEPARATOR_DIR + fileName);
		String theString = IOUtils.toString(in, "UTF-8"); 
		return theString;
	}

	public void createNewFile(String javaStrings, String fileOutPutName) throws IOException {
		fileOutPutName = nameFileToGenerate(fileOutPutName);

		File newJavaFile = new File(fileOutPutName);
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("created");
	}
	
	private String nameFileToGenerate(String fileOutPutName) {
		fileOutPutName = getPathPackage() + packageName() 
					+ GeneratorConstants.SEPARATOR_DIR + fileOutPutName 
					+ StringUtils.capitalize(layer()) + GeneratorConstants.SEPARATOR_PACKAGE 
					+ language();
		
		return fileOutPutName;
	}
}
