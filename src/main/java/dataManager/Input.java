package dataManager;

public class Input {
	
private String storedInput;
	
	public Input() {
		
		super();
		
	}
	
	protected void passInput(String words) {
		
		storedInput = words;
		
	}
	
	public void echoStorage() {
		
		System.out.println("The Stored Input : ");
		System.out.println(storedInput);
		
		
	}

}
