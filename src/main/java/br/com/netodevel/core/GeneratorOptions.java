package br.com.netodevel.core;

/**
 * @author neto
 */
public class GeneratorOptions {

	private String database;
	private String orm;
	private String server;
	private String packageName;
	private String userDatabase;
	private String passwordDatabase;

	public GeneratorOptions setDatabase(String database) {
		this.database = database;
		return this;
	}
	
	public GeneratorOptions setOrm(String orm) {
		this.orm = orm;
		return this;
	}
	
	public GeneratorOptions setServer(String server) {
		this.server = server;
		return this;
	}

	public String getDatabase() {
		return database;
	}

	public String getOrm() {
		return orm;
	}

	public String getServer() {
		return server;
	}

	public String getPackageName() {
		return packageName;
	}

	public GeneratorOptions setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	public String getUserDatabase() {
		return userDatabase;
	}

	public GeneratorOptions setUserDatabase(String userDatabase) {
		this.userDatabase = userDatabase;
		return this;
	}

	public String getPasswordDatabase() {
		return passwordDatabase;
	}

	public GeneratorOptions setPasswordDatabase(String passwordDatabase) {
		this.passwordDatabase = passwordDatabase;
		return this;
	}
	
}
