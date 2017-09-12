package br.com.netodevel.core;

import br.com.netodevel.generators.java.repository.GeneratorCleanRepository;

public class Main {

	public static void main(String[] args) {
		System.out.println("-------------------");
		System.out.println("---GENERATE CORE---");
		System.out.println("-------------------");
		
		new GeneratorCleanRepository("User").generate();
	}
	
}
