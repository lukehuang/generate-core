package br.com.netodevel.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * @author NetoDevel
 */
public abstract class AbstractGeneratorResource extends ReadScaffoldInfo implements GeneratorResourceBase {
	
	public String loadTemplateFileResources(String fileName) throws IOException {
		InputStream in = getClass().getResourceAsStream("/templates/resources/" + layer() + GeneratorConstants.SEPARATOR_DIR + fileName);
		String theString = IOUtils.toString(in, "UTF-8"); 
		return theString;
	}
	
	public void createNewResource(String javaStrings, String fileOutPutName, String folder) throws IOException {
		fileOutPutName = nameResourceToGenerate(fileOutPutName, folder);

		File newJavaFile = new File(fileOutPutName);
		FileUtils.writeStringToFile(newJavaFile, javaStrings);
		System.out.println("created");
	}

	private String nameResourceToGenerate(String fileOutPutName, String folder) {
		fileOutPutName = getPathResources() + GeneratorConstants.SEPARATOR_DIR + folder() + GeneratorConstants.SEPARATOR_DIR + fileOutPutName;
		return fileOutPutName;
	}
	
}
