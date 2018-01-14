import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainModule {
	public static void main(String[] args) {
        String validFormat;
        String zodiacSign;
        String dayOfWeek;
        boolean loopBreak;
        validFormat="false";
        Input.counter=0;
        Input.inputDate="";
        loopBreak=false;
        outerloop:
        // This loop will run till the input in an invalid one or 3 times invalid has been given as input	
		while(loopBreak==false)
        {
			//Read the input from console
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter your Date of Birth(mm/dd/yyyy):");
			try {
				Input.inputDate = br.readLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				loopBreak=true;
				break outerloop;
			}
			// validate the input
	        validFormat=Input.checkInput();
	        if (validFormat=="Valid")
	        {
	        	//if valid then print day and zodiac sign
	        	System.out.println("Enter into system");
	        	zodiacSign=new Zodiac(Input.inputDate).getZodiac();
	        	dayOfWeek=new WeekDay(Input.inputDate).getDay();
	        	System.out.println("You are born on " + dayOfWeek);
	        	System.out.println("Your zodiac sign is " + zodiacSign);
	        	Input.counter=0;
	        	Input.inputDate="";
	        	loopBreak=true;
	        	break outerloop;
	        }
	        // For wrong input format, prompt user to provide input again
	        else if(validFormat=="Invalid")
	        {
	        	System.out.println("Wrong input format. Try again..");
	        }
	        // If user provides input 3 time wrong. 
	        else if (Input.counter==3)
	        {
	        	System.out.println("Wrong date for 3 times. You are redirecting to home page..");
	        	loopBreak=true;
	        	break outerloop;
	        }
	        else
	        {
	        	loopBreak=true;
	        }
        
        }
	}
}
