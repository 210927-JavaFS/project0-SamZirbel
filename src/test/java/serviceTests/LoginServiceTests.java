package serviceTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.services.LoginService;

public class LoginServiceTests {

	String username = "UserTester";
	String password = "PassTest";
	String firstname = "Gilgamesh";
	String lastname = "Ishmael";
	
	LoginService loginservice = new LoginService();
	

	/* Cannot Delete User With Just Login Service - Affects Other Tests
	@Test
	public void t001_UsersCreateable() {

		boolean one = loginservice.createAccount(username, password, firstname, lastname);
		assertTrue(one);

	}
	*/
	
	
	@Test
	public void t001_UserNotInDatabase() {
	
		boolean one = loginservice.logIn(username, password);
		assertFalse(one);
	
	}
	
	@Test
	public void t002_UserInDatabase() {
	
		boolean one = loginservice.logIn("User001", "Pass001");
		assertTrue(one);
	
	}
	
	@Test
	public void t003_BadPassword() {
	
		boolean one = loginservice.logIn("User001", "JIOJ");
		assertFalse(one);
	
	}
	
	@Test
	public void t004_AccountNumberCreated() {
	
		int one = 0;
		one = loginservice.getAccount("User001");
		assertNotNull(one);
	
	}
	
	@Test
	public void t005_Functional() {
	
		assertNotNull(loginservice.listAllUsers());
	
	}

}
