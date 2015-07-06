package race;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Model {
	
	Logic _logic;
	
	public static final int ROWS = 15;
	public static final int COLUMS = 5;	
	
	public Model() {
		Field field = new Field(15, 5);
		State state = new State();
		Racer rider = new Racer();
		state.setField(field);
		
		Queue<Figure> blocks = new ArrayDeque<Figure>();
		state.setFigure(Figure.T);
		state.setFigure(Bonus.N);
		state.setFigure(Bonus.N);
		state.setFigure(Figure.randomFigure());
		state.setFigure(Bonus.randomBonus());
		state.setFigure(Bonus.randomBonus());
		state.setFigure(Figure.randomFigure());
		state.setFigure(Bonus.randomBonus());
		state.setFigure(Bonus.randomBonus());
		state.setFigure(Figure.randomFigure());
		state.setFigure(Bonus.randomBonus());
		state.setFigure(Bonus.randomBonus());
		state.setFigure(Figure.randomFigure());
		state.setFigure(Bonus.randomBonus());
		state.setFigure(Bonus.randomBonus());

		state.col = 2;
		state.countOfBlocks = 0;
		
		_logic = new Logic(state);
	}
	

	List<ModelListener> _listeners = new ArrayList<ModelListener>();
	
	public void addListener(final ModelListener listener) {
		_listeners.add(listener);
	}
	
	public void removeListener(final ModelListener listener) {
		_listeners.remove(listener);
	}
	
	void fireChangedEvent() {
		for (ModelListener modelListener : _listeners) {
			modelListener.onChange(_logic.getState());
		}
	}

	public void moveLeft() {
		if (_logic.moveLeft()) {
			fireChangedEvent();
		}
	}
	
	public void moveRight() {
		if (_logic.moveRight()) {
			fireChangedEvent();
		}
	}
	
	public void moveDown(boolean flag) {
		if (_logic.moveDown(flag)) {
			fireChangedEvent();
		}
	}
	
}