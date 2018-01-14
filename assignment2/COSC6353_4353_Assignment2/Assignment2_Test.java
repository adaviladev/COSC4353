import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Test;

public class Assignment2_Test {

	//This test checks whether user input is fetching correctly or not.
	@Test
	public void shouldTakeUserInputTest() 
	{
		String input = "08/10/1989";
	    InputOutput inputOutput= new InputOutput(input);
	    assertEquals("08/10/1989", inputOutput.getInputTest());
	}
	// This test checks whether User input from console is fetching correctly or not.
	@Test
	public void shouldTakeUserInputTestForConsole() 
	{
	    InputOutput inputOutput= new InputOutput();

	    String input = "08/10/1990";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

	    assertEquals("08/10/1990", inputOutput.getInput());
	}
	//This test check a valid date format
	@Test
	public void validDateFormatMMDDYYYYTest()
	{
		ValidDate valid= new ValidDate("08/10/1989");
		assertEquals("True",valid.IsValidDate());
	}
	//This test checks an invalid date format.
	@Test
	public void invalidDateFormatMMDDYYYYTest()
	{
		ValidDate valid= new ValidDate("08?10?1989");
		assertEquals("False",valid.IsValidDate());
	}
	//This test checks an invalid month.
	@Test
	public void InvalidMonthTest()
	{
		ValidDate valid= new ValidDate("13/10/1989");
		assertEquals("False",valid.IsValidDate());
	}
	//This test checks a valid month
	@Test
	public void ValidMonthTest()
	{
		ValidDate valid= new ValidDate("12/10/1989");
		assertEquals("True",valid.IsValidDate());
	}
	//This test checks an invalid date
	@Test
	public void InvalidDateTest()
	{
		ValidDate valid= new ValidDate("10/32/1989");
		assertEquals("False",valid.IsValidDate());
	}
	//This test checks a valid date
	@Test
	public void ValidDateTest()
	{
		ValidDate valid= new ValidDate("10/31/1989");
		assertEquals("True",valid.IsValidDate());
	}
	//This test checks an invalid year.
	@Test
	public void InValidDYearTest()
	{
		ValidDate valid= new ValidDate("10/31/198");
		assertEquals("False",valid.IsValidDate());
	}
	//This test checks an invalid Leap year
	@Test
	public void InValidLeapYearTest()
	{
		ValidDate valid= new ValidDate("02/29/2001");
		assertEquals("False",valid.IsValidDate());
	}
	//This test checks a valid Leap year
	@Test
	public void ValidLeapYearTest()
	{
		ValidDate valid= new ValidDate("02/29/2000");
		assertEquals("True",valid.IsValidDate());
	}
	//This test checks for Sunday
	@Test
	public void DayWeekTestSunday()
	{
		WeekDay weekday= new WeekDay("02/19/2017");
		assertEquals("Sunday",weekday.getDay());
	}
	//This test checks for Monday
	@Test
	public void DayWeekTestMonday()
	{
		WeekDay weekday= new WeekDay("02/20/2017");
		assertEquals("Monday",weekday.getDay());
	}
	//This test checks for Tuesday
	@Test
	public void DayWeekTestTuesday()
	{
		WeekDay weekday= new WeekDay("02/21/2017");
		assertEquals("Tuesday",weekday.getDay());
	}
	//This test checks for Wednesday
	@Test
	public void DayWeekTestWednesday()
	{
		WeekDay weekday= new WeekDay("02/22/2017");
		assertEquals("Wednesday",weekday.getDay());
	}
	//This test checks for Thursday
	@Test
	public void DayWeekTestThursday()
	{
		WeekDay weekday= new WeekDay("02/23/2017");
		assertEquals("Thursday",weekday.getDay());
	}
	//This test checks for Friday
	@Test
	public void DayWeekTestFriday()
	{
		WeekDay weekday= new WeekDay("02/24/2017");
		assertEquals("Friday",weekday.getDay());
	}
	//This test checks for Saturday
	@Test
	public void DayWeekTestSaturday()
	{
		WeekDay weekday= new WeekDay("02/25/2017");
		assertEquals("Saturday",weekday.getDay());
	}
	// This test is for Capricorn Zodiac sign
	@Test
	public void zodiacSignCapricornTest()
	{
		Zodiac zodiac= new Zodiac("12/23/2017");
		assertEquals("Capricorn",zodiac.getZodiac());
	}
	// This test is for Aquarius Zodiac sign
	@Test
	public void zodiacSignAquariusTest()
	{
		Zodiac zodiac= new Zodiac("01/23/2017");
		assertEquals("Aquarius",zodiac.getZodiac());
	}
	// This test is for Pisces Zodiac sign
	@Test
	public void zodiacSignPiscesTest()
	{
		Zodiac zodiac= new Zodiac("02/23/2017");
		assertEquals("Pisces",zodiac.getZodiac());
	}
	// This test is for Aries Zodiac sign
	@Test
	public void zodiacSignAriesTest()
	{
		Zodiac zodiac= new Zodiac("03/23/2017");
		assertEquals("Aries",zodiac.getZodiac());
	}
	// This test is for Taurus Zodiac sign
	@Test
	public void zodiacSignTaurusTest()
	{
		Zodiac zodiac= new Zodiac("04/23/2017");
		assertEquals("Taurus",zodiac.getZodiac());
	}
	// This test is for Gemini Zodiac sign
	@Test
	public void zodiacSignGeminiTest()
	{
		Zodiac zodiac= new Zodiac("05/23/2017");
		assertEquals("Gemini",zodiac.getZodiac());
	}
	// This test is for Cancer Zodiac sign
	@Test
	public void zodiacSignCancerTest()
	{
		Zodiac zodiac= new Zodiac("06/23/2017");
		assertEquals("Cancer",zodiac.getZodiac());
	}
	// This test is for Leo Zodiac sign
	@Test
	public void zodiacSignLeoTest()
	{
		Zodiac zodiac= new Zodiac("07/23/2017");
		assertEquals("Leo",zodiac.getZodiac());
	}
	// This test is for Virgo Zodiac sign
	@Test
	public void zodiacSignVirgoTest()
	{
		Zodiac zodiac= new Zodiac("08/23/2017");
		assertEquals("Virgo",zodiac.getZodiac());
	}
	// This test is for Libra Zodiac sign
	@Test
	public void zodiacSignLibraTest()
	{
		Zodiac zodiac= new Zodiac("09/23/2017");
		assertEquals("Libra",zodiac.getZodiac());
	}
	// This test is for Scorpio Zodiac sign
	@Test
	public void zodiacSignScorpioTest()
	{
		Zodiac zodiac= new Zodiac("10/23/2017");
		assertEquals("Scorpio",zodiac.getZodiac());
	}
	// This test is for Sagittarius Zodiac sign
	@Test
	public void zodiacSignSagittariusTest()
	{
		Zodiac zodiac= new Zodiac("11/23/2017");
		assertEquals("Sagittarius",zodiac.getZodiac());
	}
	// This test is for one valid date input
	@Test
	public void oneValidInputTest()
	{
		Input.counter=0;
		Input.inputDate="12/12/2000";
		assertEquals("Valid",Input.checkInput());
	}
	// This test is for one valid date  and one invalid date input
	@Test
	public void oneInValidOneValidInputTest()
	{
		Input.counter=0;
		Input.inputDate="13/12/2000";
		assertEquals("Invalid",Input.checkInput());
		Input.inputDate="12/12/2000";
		assertEquals("Valid",Input.checkInput());
	}
	// This test is for two valid date  and one invalid date input
	@Test
	public void twoInValidOneValidInputTest()
	{
		Input.counter=0;
		Input.inputDate="13/12/2000";
		assertEquals("Invalid",Input.checkInput());
		Input.inputDate="11/31/2000";
		assertEquals("Invalid",Input.checkInput());
		Input.inputDate="12/12/2000";
		assertEquals("Valid",Input.checkInput());
	}
	// This test is for three invalid date input
	@Test
	public void threeInvalidInputTest()
	{
		Input.counter=0;
		Input.inputDate="13/12/2000";
		assertEquals("Invalid",Input.checkInput());
		Input.inputDate="11/31/2000";
		assertEquals("Invalid",Input.checkInput());
		Input.inputDate="12/32/2000";
		assertEquals("3 Invalid inputs",Input.checkInput());
	}
}
