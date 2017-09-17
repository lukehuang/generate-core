package br.com.netodevel.generators.resources;

import br.com.netodevel.core.GeneratorOptions;
import br.com.netodevel.core.GeneratorResource;

/**
 * @author NetoDevel
 */
public class GeneratorScaffoldInfo extends GeneratorResource {

	private static final String DEFAULT_ORM = "jpa";
	private static final String DEFAULT_USER_DATABASE = "root";
	private static final String DEFAULT_PASSWORD_DATABASE = "";

	public GeneratorScaffoldInfo(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public String folder() {
		return ROOT;
	}

	public String layer() {
		return "scaffold";
	}

	public String templateFile() {
		return "template-scaffold-info.txt";
	}

	@Override
	protected String operationGenerate(String javaStrings, GeneratorOptions generatorOptions) {
		return javaStrings.replace("${package}", generatorOptions.getPackageName())
				.replace("${database_name}", generatorOptions.getDatabase())
				.replace("${user_database}", generatorOptions.getUserDatabase(DEFAULT_USER_DATABASE))
				.replace("${orm}", generatorOptions.getOrm(DEFAULT_ORM))
				.replace("${password_database}", generatorOptions.getPasswordDatabase(DEFAULT_PASSWORD_DATABASE));
	}
	
	public static void main(String[] args) {
		GeneratorOptions options = new GeneratorOptions()
				.setDatabase("mysql")
				.setPackageName("br.com.netodevel")
				.setUserDatabase("root")
				.setPasswordDatabase("netinho123");
		
		new GeneratorScaffoldInfo(options).generate("scaffold.info");
	}

}
