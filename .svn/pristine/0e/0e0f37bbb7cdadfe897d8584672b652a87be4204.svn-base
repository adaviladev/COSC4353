
public class Zodiac {

	String inputDate;
	public Zodiac(String inputDate)
	{
		this.inputDate=inputDate;
	}
	public String getZodiac()
	{
		//Split the date into day,month and year and find the zodiac sign
		String zodiac;
		String dateParts[]=inputDate.split("/");
		int month=Integer.parseInt(dateParts[0]);
		int day = Integer.parseInt(dateParts[1]);
		zodiac="";
		if      ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
            zodiac="Capricorn";
		else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17))
            zodiac="Aquarius";
        else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19))
            zodiac="Pisces";
        else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19))
            zodiac="Aries";
        else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20))
            zodiac="Taurus";
        else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20))
            zodiac="Gemini";
        else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22))
            zodiac="Cancer";
        else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22))
            zodiac="Leo";
        else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22))
            zodiac="Virgo";
        else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
            zodiac="Libra";
        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
            zodiac="Scorpio";
        else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
            zodiac="Sagittarius";
		return zodiac;
	}
}
