import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeekDay {
	String InputDate;
	// This constructor takes the input and stores in local variable.
	public WeekDay(String InputDate)
	{
		this.InputDate=InputDate;
	}
	public String getDay() 
	{
		try
		{
		  // Takes the date input and find the day of the week.
		  SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		  Date date=sdf.parse(InputDate);
		  DateFormat df=new SimpleDateFormat("EEEE"); 
		  String weekDay=df.format(date);
		  return weekDay;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
