package thymeleaf;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.netodevel.generators.views.thymeleaf.AbstractThymeleafGenerate;

/**
 * @author NetoDevel
 *
 */
public class AbstractThymeleafTest {

	private AbstractThymeleafGenerate abstractThymeleafGenerate;
	
	@Before
	public void setUp() {
		this.abstractThymeleafGenerate = new AbstractThymeleafGenerate();
	}
	
	@Test
	public void testGenerateThParameters() {
		String outputExpected = "\t\t\t <th>Name</th> \n"
				    + "\t\t\t <th>Email</th> \n"
				    + "\t\t\t <th>Action</th>";
		assertEquals(outputExpected, this.abstractThymeleafGenerate.generateThParameters("name:String email:String"));
	}
	
}
