package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.netodevel.generators.java.model.ModelGenerateUtils;

public class ModelGeneratorUtilTest {
	
	@Test
	public void testGetTypeParam() {
		String param = "name:String";
		assertEquals("import java.lang.String;", ModelGenerateUtils.getTypeParam(param));
	}

	@Test
	public void testGenerateImports() {
		String parameters = "name:String idade:Integer data:Date";
		String valueExpected = "import java.lang.String;\n" 
							 + "import java.lang.Integer;\n"
							 + "import java.util.Date;";
		assertEquals(valueExpected, ModelGenerateUtils.generateImports(parameters));
	}
	
}
