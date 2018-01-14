import java.util.Scanner;
import java.util.Timer;

public class mainModule {
	static String key = "";
	private static double target = 0;
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Pair value you wish to bid");
		key = sc.next();
		System.out.println("Please enter the target value");
		target = sc.nextDouble();
		sc.close();
		Timer time = new Timer ();
		ScheduleRun sch = new ScheduleRun();		
		time.scheduleAtFixedRate(sch, 0, 2000);		
	}
/*	public static String getKey() {
		return key;
	}
	public static void setKey(String key) {
		mainModule.key = key;
	}*/
	public static double getTarget() {
		return target;
	}
	public static void setTarget(double target) {
		mainModule.target = target;
	}
}