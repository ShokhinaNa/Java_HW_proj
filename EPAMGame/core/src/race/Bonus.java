package race;

import java.util.Random;

public class Bonus extends Figure {

	public static final Bonus N;
	static {
		N = new Bonus();
		N._data = new int[] {0,0,0,0,0};
	}
	
	private static int[] b1 = 
		{0,0,0,0,4};
	
	private static int[] b2 = 
		{0,4,0,0,0};
	
	private static int[] b3 = 
		{0,0,4,0,0};
	
	private static int[] b4 = 
		{0,0,0,4,0};
	
	private static int[] b5 = 
		{0,0,0,0,4};
	
	private static int[] b6 = 
		{0,0,0,0,0};
	
	private static int[] b7 = 
		{0,0,0,0,0};
	
	private static int[] b8 = 
		{0,0,0,0,0};
	
	private static int[] b9 = 
		{0,0,0,0,0};

	
	public static int[][] BONUSES = {
		b1, b2, b3, b4, b5, b6, b7, b8 ,b9
	};

	private static Random random = new Random();
	
	int[] _data;

	public Bonus() {
		super();
	}
	public int[] getData() {
		return _data;
	}

	public static Bonus randomBonus() {
		Bonus bonus = new Bonus();
		bonus._data = BONUSES[random.nextInt(BONUSES.length)];
		return bonus;
	}
}
