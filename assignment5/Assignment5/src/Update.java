import java.util.ArrayList;
import java.util.Date;

public class Update implements Utlity 
{
	String symbol;
	double bid;
	double ask;
	double high;
	double low;
	double direction;
	Date last;
	private ArrayList<Check> checkPrice;
	public Update()
	{
		checkPrice=new ArrayList<Check>();
	}
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
		updateValue();
	}
	/**
	 * @return the bid
	 */
	public double getBid() {
		return bid;
	}
	/**
	 * @param bid the bid to set
	 */
	public void setBid(double bid) {
		this.bid = bid;
		updateValue();
	}
	/**
	 * @return the ask
	 */
	public double getAsk() {
		return ask;
	}
	/**
	 * @param ask the ask to set
	 */
	public void setAsk(double ask) {
		this.ask = ask;
		updateValue();
	}
	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(double high) {
		this.high = high;
		updateValue();
	}
	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}
	/**
	 * @param low the low to set
	 */
	public void setLow(double low) {
		this.low = low;
		updateValue();
	}
	/**
	 * @return the direction
	 */
	public double getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(double direction) {
		this.direction = direction;
		updateValue();
	}
	/**
	 * @return the last
	 */
	public Date getLast() {
		return last;
	}
	/**
	 * @param last the last to set
	 */
	public void setLast(Date last) {
		this.last = last;
		updateValue();
	}
	@Override
	public void updateValue()
	{
		for(Check checks:checkPrice)
		{
			checks.refresh(symbol, bid, ask, high, low, direction, last);
		}
	}
	@Override
	public void add(Check c)
	{
		checkPrice.add(c);
	}
	@Override
	public void delete(Check c)
	{
		checkPrice.remove(c);
	}
 
}
