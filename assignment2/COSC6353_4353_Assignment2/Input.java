
public class Input {
	static String inputDate;
	static int counter;
	// This constructor takes the input and stores in local variable.
	public Input(String inputDate_input)
	{
		inputDate=inputDate_input;
	}
	// This module checks the validity of the input
	public static String checkInput()
	{
		if (new ValidDate(inputDate).IsValidDate()=="True")
		{
			return "Valid";
		}
		else
		{
			counter+=1;
			if (counter<3)
			{
				return "Invalid";
			}
			else
			{
				return "3 Invalid inputs";
			}
		}
	}
}
