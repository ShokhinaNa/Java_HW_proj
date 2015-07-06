package race;


import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class View {
	
	final static int BOX_SIZE = 30;
	final static int ORIGIN_X = 50;
	final static int ORIGIN_Y = 50;
	protected final static int ROW_COUNT = 15;
	protected final static int COL_COUNT = 5;
	
	private Graphics _graphics;
	
	public void setGraphics(final Graphics graphics) {
		_graphics = graphics;
	}

	public void draw(final State state) {
		drawField();
		drawFigure(state.blocks);
		drawRider(state.col);
	}

	protected void drawRider( final int col) {
		_graphics.fillRect(ORIGIN_X + col * BOX_SIZE, ORIGIN_Y + (ROW_COUNT-1) * BOX_SIZE, BOX_SIZE, BOX_SIZE, 5);
	}

	protected void drawFigure(final Queue<Figure> blocks) {
		int count = ROW_COUNT-1;
		for(Figure block : blocks) {
			for (int i = 0; i < COL_COUNT; i++) {
				if (block.getData()[i] == 0) {
					continue;
				}
				drawBox(block.getData()[i], count, i);
			}
			count--;
		}
	}
		
	protected void drawField() {
		for(int i = 0; i < ROW_COUNT; i++ ){
			for(int j = 0; j < COL_COUNT; j++ ){
				drawBox(0, i, j);				
			}
		}

	}

	protected void drawBox(final int colorIndex, final int row, final int col) {
		_graphics.fillRect(ORIGIN_X + col * BOX_SIZE, ORIGIN_Y + row * BOX_SIZE, BOX_SIZE, BOX_SIZE, colorIndex);
	}

}