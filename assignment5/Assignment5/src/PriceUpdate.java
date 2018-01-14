import java.util.Date;

public class PriceUpdate implements Check {

	String symbol;
	double bid;
	double ask;
	double high;
	double low;
	double direction;
	Date last;
	static int count=0;
	int number;
	private Utlity update;
	public PriceUpdate(Utlity update)
	{
		this.update=update;
		this.number=++count;
		update.add(this);
	}
	@Override
	public void refresh(String symbol,double bid, double ask, double high, double low, double direction, Date last)
	{
		this.symbol=symbol;
		this.bid=bid;
		this.ask=ask;
		this.high=high;
		this.low=low;
		this.direction=direction;
		this.last=last;
		System.out.println(number + "\nsymbol:" + symbol + "\nBid: " + bid + "\nask: " + ask + "\nhigh: " + high +
				"\nlow" + low + "\ndir" + direction + "\nlast" + last+ "\n");
	}
}
