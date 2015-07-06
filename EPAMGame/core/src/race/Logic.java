package race;

import java.util.Random;

public class Logic {

	private State _state;
	final static int ROW_COUNT = 15;
	final static int COL_COUNT = 5;

	public Logic(final State state) {
		_state = state;
	}

	public boolean moveLeft() {
		_state.col--;
		if (!isRiderFitsField()) {
			_state.col++;
			return false;
		}
		return true;
	}

	public boolean moveRight() {
		_state.col++;
		if (!isRiderFitsField()) {
			_state.col--;
			return false;
		}
		return true;
	}


	  
	public boolean moveDown() {
		if (_state.countOfBlocks % 3==0){
			_state.setFigure(Figure.randomFigure());
		} else{
			_state.setFigure(Bonus.randomBonus());	
		}
		_state.delFigure();
		_state.countOfBlocks++;
		return true;
	}

	
	public boolean isRiderFitsField() {
		if(_state.col > COL_COUNT - 1 || _state.col < 0){
			return false;}
		return true;
	}
	

	public State getState() {
		try {
			return (State) _state.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}