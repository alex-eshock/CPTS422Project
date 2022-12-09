package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import testEnginePackage.TestEngine;
import halsteadPackage.HalsteadVolume;

public class HalsteadVolumeTests {
	
	@Test
	void volumeTest() throws IOException, CheckstyleException, ParseException {
		HalsteadVolume check = new HalsteadVolume();
		String filePath = "src/main/java/blackBoxTests/HalsteadVolumeCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(233, check.count);
	}
	
	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadVolume check = new HalsteadVolume();
		String filePath = "src/main/java/blackBoxTests/HalsteadLengthCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(461, check.count);

	}

}
