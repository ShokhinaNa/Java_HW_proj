package race;

import java.util.Random;

public class Figure {
	
	public static final Figure T;

	static {
		T = new Figure();
		T._data = new int[] {2,2,0,2,2};
	}
	
	private static int[] b1 = 
		{0,2,2,2,2};
	
	private static int[] b2 = 
		{2,2,0,0,2};
	
	private static int[] b3 = 
		{2,2,0,2,2};
	
	private static int[] b4 = 
		{0,2,2,0,2};
	
	private static int[] b5 = 
		{2,2,0,2,2};
	
	private static int[] b6 = 
		{2,0,2,0,2};
	
	private static int[] b7 = 
		{2,2,2,2,0};
	
	private static int[] b8 = 
		{0,2,2,2,0};
	
	public static int[][] FIGURES = {
		b1, b2, b3, b4, b5, b6, b7, b8
	};

	private static Random random = new Random();
	
	int[] _data;

	public Figure() {
		_data = new int[5];
	}

	public int[] getData() {
		return _data;
	}

	public static Figure randomFigure() {
		Figure figure = new Figure();
		figure._data = FIGURES[random.nextInt(FIGURES.length)];
		return figure;
	}

}