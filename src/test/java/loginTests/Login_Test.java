package loginTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.revature.models.Login;

// VV Test Class For com.revature.models.Login
public class Login_Test {

	@Test
	public void t001_isCreateable() {

		Login one = new Login("a", "b");
		assertNotNull(one);

	}

	@Test
	void t002_usernameSet() {

		Login one = new Login("a", "b");
		assertEquals("a", one.getUsername());

	}
	
	@Test
	void t003_passwordSet() {
		
		Login one = new Login("a", "b");
		assertEquals("b", one.getPassword());
		
	}
	
	@Test
	void t004_resetPassword() {
		
		Login one = new Login("a", "b");
		one.setPassword("Green");
		assertEquals("Green", one.getPassword());
		
	}
	
	@Test
	void t005_resetUsername() {
		
		Login one = new Login("a", "b");
		one.setUsername("Tiramisu");
		assertEquals("Tiramisu", one.getUsername());
		
	}

}
