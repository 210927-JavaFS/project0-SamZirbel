package scannerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.scanner.Scanning;

public class ScanningTests {
	
	@Test
	void t000xTestTest() {
		
		assertEquals(1, 1);
		
	}
	
	@Test
	void t001xScannerCreateable() {
		
		Scanning scannerOne = new Scanning();
		
		assertNotNull(scannerOne);
		
	}
	
	@Test
	void t002xScannerString() {
		
		Scanning scannerOne = new Scanning();
		scannerOne.setText("Bender");
		assertNotNull(scannerOne.getText());
		
	}
	
	@Test
	void t003xScannerString() {
		
		Scanning scannerOne = new Scanning();
		scannerOne.setText("Bender");
		assertTrue(scannerOne.getText() == "Bender");
		
	}
	
	@Test
	void t004xScannerString() {
		
		Scanning scannerOne = new Scanning();
		scannerOne.setText("Is Terrible");
		assertFalse(scannerOne.getText() == "Bender");
		
	}
	

}
