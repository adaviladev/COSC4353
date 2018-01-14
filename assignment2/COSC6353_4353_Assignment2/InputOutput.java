import java.util.Scanner;

public class InputOutput {
	String input;
	// This constructor takes the input and stores in local variable.
	public InputOutput(String input)
	{
		this.input=input;
	}
	public InputOutput()
	{
		
	}
	public String getInputTest()
	{
		return input;
	}
	// This module takes the input from console
	public String getInput()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        return sc.nextLine();
	}
}
