package br.com.netodevel.core;

/**
 * @author neto
 */
public class GeneratorOptions {

	private String database;
	private String orm;
	private String server;

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
	
}
