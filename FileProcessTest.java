package filehandle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileProcessTest {
	private static FileProcess example = new FileProcess();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHandlerFile() {
		
		assertEquals("Total count of those floats is2443401Total summary of those floats is7264048.0", example.handlerFile("./test3.txt"));
	}
	@Test
	public void testHandlerFile1() {
		assertEquals("-1",example.handlerFile("./test1.txt"));
	}
	@Test
	public void testHandlerFile2() {
		assertEquals("Total count of those floats is0Total summary of those floats is0.0", example.handlerFile("./test2.txt"));
	}
	@Test
	public void testHandlerFile3() {
		assertEquals("Total count of those floats is3271Total summary of those floats is9730.586", example.handlerFile("./test3.txt"));
	}
}
