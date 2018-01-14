import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ValidDate {
	String Date;
	// This constructor takes the input and stores in local variable.
	public ValidDate(String Date)
	{
		this.Date=Date;
	}
	//Validate the date
	public String IsValidDate()
	{
		String valid;
		valid="True";
		// Pre-check based on length and regular expression
		if (Date.length()==10 && Date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"))
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date;
            try 
            {
				date = dateFormat.parse(Date);
			} catch (ParseException e) 
            {
				System.out.println(e.getMessage());
				date=null;
				return valid;
			}
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            // Splits the input by '/' delimiter
            String splitInput[] = Date.split("/");
            valid = "True";
            // check the month part with Calendar month system variable
            if (Integer.parseInt(splitInput[0]) != cal.get(Calendar.MONTH) + 1) 
            {
                valid = "False";
            } 
            return valid;
		}
		else
		{
			valid ="False";
			return valid;
		}
		
	}
}
