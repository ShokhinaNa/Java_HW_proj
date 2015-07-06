package race;


import java.util.ArrayDeque;
import java.util.Queue;

public class State implements Cloneable {

	Field _field;
	Racer _rider;
	Queue<Figure> blocks = new ArrayDeque<Figure>();
	
	int col;
	int countOfBlocks;

	public Figure delFigure() {
		return blocks.poll();
	}
	
	public Figure getFigure() {
		return blocks.peek();
	}

	public void setFigure(final Figure figure) {
		blocks.offer(figure);
	}

	public Field getField() {
		return _field;
	}

	public void setField(final Field field) {
		_field = field;
	}
	
	public Racer getRider(){
		return _rider;
	}
	
	public void setRider(final Racer rider){
		_rider = rider;
		col = 3;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
