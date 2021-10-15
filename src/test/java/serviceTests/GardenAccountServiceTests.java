package serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.models.FullJoin;
import com.revature.services.GardenAccountService;
import com.revature.util.encryptDecryptUtil;

public class GardenAccountServiceTests {

	GardenAccountService gardenaccountservice = new GardenAccountService();

	@Test
	public void t001_ObtainAccountType() {

		String type = gardenaccountservice.getAccountType(1);
		assertEquals(type, "Owner");

	}
	
	@Test 
	public void t002_AccoutTypeChange() {
	
		boolean one = gardenaccountservice.updateAccountType(1, "Test");
		
		assertTrue(one);
	
	}
	
	@Test
	public void t003_AccountTypeChange() {
	
		gardenaccountservice.updateAccountType(1, "Owner");
		String type = gardenaccountservice.getAccountType(1);
		assertEquals(type, "Owner");
		
	}
	
	@Test
	public void t004_FullJoinFunctioning() {
	
		assertNotNull(gardenaccountservice.getAccountFullJoin(1));
	
	}
	
	@Test
	public void t005_FullJoinReturningCOntent() {
	
		FullJoin one = gardenaccountservice.getAccountFullJoin(1);
		assertEquals(one.getAccounttype(), "Owner");
		
	}
	
	@Test
	public void t006_AccountsAreReturing() {
	
		List<FullJoin> one = gardenaccountservice.getAllAccounts();
		assertTrue(one.size() > 0);
		
	}
	
	@Test
	public void t007_UsernameUpdateable() {
	
		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		fulljoin.setUsername("Test007");
		Boolean one = gardenaccountservice.updateUsername(fulljoin);
		assertTrue(one);
	
	}
	
	@Test
	public void t008_UsernameReset() {
	
		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		fulljoin.setUsername("User001");
		Boolean one = gardenaccountservice.updateUsername(fulljoin);
		String name = fulljoin.getUsername();
		assertEquals(name, "User001");
		
	}
	
	@Test
	public void t009_PasswordUpdatedAndEncrypted() {
	
		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		fulljoin.setUserpassword("User001");
		Boolean one = gardenaccountservice.updatePassword(fulljoin);
		String pass = fulljoin.getUserpassword();
		assertEquals(pass, encryptDecryptUtil.encryptDecrypt("User001"));
		
	}
	
	@Test
	public void t010_PasswordUpdateAndDecrypt() {

		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		fulljoin.setUserpassword("Pass001");
		Boolean one = gardenaccountservice.updatePassword(fulljoin);
		String pass = fulljoin.getUserpassword();
		assertEquals(encryptDecryptUtil.encryptDecrypt(pass), "Pass001");
		
	}
	
	@Test
	public void t011_UpdateFirstName() {

		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		fulljoin.setFirstname("Conroy");
		Boolean one = gardenaccountservice.updateFirstName(fulljoin);
		String fname = fulljoin.getFirstname();
		assertEquals(fname, "Conroy");
		
	}
	
	@Test
	public void t012_UpdateLastName() {

		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		fulljoin.setLastname("Stern");
		Boolean one = gardenaccountservice.updateLastName(fulljoin);
		String lname = fulljoin.getLastname();
		assertEquals(lname, "Stern");
		
	}
	
	@Test
	public void t013_AddFeeders() {
		
		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		
		int newfeeders = 5;
		int oldfeeders = fulljoin.getBirdfeeders();
		
		gardenaccountservice.addBirdFeeders(fulljoin, newfeeders);
		
		int result = fulljoin.getBirdfeeders();
		
		assertEquals(newfeeders + oldfeeders, result);
		
	}
	
	@Test
	public void t014_RemoveFeeders() {

		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);


		int newfeeders = 5;
		int oldfeeders = fulljoin.getBirdfeeders();
		
		gardenaccountservice.addBirdFeeders(fulljoin, newfeeders);

		
		int toremove = 1;
		int oldsum = fulljoin.getBirdfeeders();
		
		gardenaccountservice.removeBirdFeeders(fulljoin, toremove);
		
		int result = fulljoin.getBirdfeeders();
		
		assertEquals(oldsum - toremove, result);
		
	}
	
	@Test
	public void t015_RemoveAllFeeders() {

		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(1);
		
		int toremove = 999;
		int oldsum = fulljoin.getBirdfeeders();
		
		gardenaccountservice.removeBirdFeeders(fulljoin, toremove);
		
		int result = fulljoin.getBirdfeeders();
		
		assertEquals(0, result);
		
	}
	
	@Test
	public void t016_AllAccountsGrabbableAndNotReturningEmpty() {
	
		List<FullJoin> all = gardenaccountservice.getAllAccounts();
		
		assertTrue(all.size() > 0);
		
	}
	
	
	
		

}
