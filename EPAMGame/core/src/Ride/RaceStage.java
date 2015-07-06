package Ride;

import java.util.Queue;

import race.Controller;
import race.Figure;
import race.Model;
import race.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class RaceStage extends Stage {
	
	protected static final int SIZE = 30;
	Rider rider;
	public boolean flag = false;
	
	
	public RaceStage(){
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(true);
		setViewport(new ScreenViewport(camera));
	}
	
	public void init(){
		Model model = new Model();
		final Controller controller = new Controller();

		model.addListener(controller);
		final BackgroundImage background = new BackgroundImage(1);
		RaceStage.this.addActor(background);

		rider = new Rider();
		RaceStage.this.addActor(rider);

		View view = new View() {
			
			private Box[][] _boxes = new Box[Model.ROWS][Model.COLUMS];
			
		
			@Override
			protected void drawBox(int colorIndex, int row, int col){
				if (row < ROW_COUNT && row >= 0 && col < COL_COUNT && col >= 0){
						Box box = new Box(colorIndex, row, col);
						_boxes[row][col] = box;
						RaceStage.this.addActor(box);
						box.setBounds(col * Box.SIZE, row * Box.SIZE, Box.SIZE, Box.SIZE);
					}
				
				if ((row == Model.ROWS - 1)&& (col == (rider.actorX/SIZE))){
					RaceScreen.GO = true;
					}
				}

			
			@Override
			protected void drawRider(final int col){
			}
			
			@Override
			protected void drawField(){
				for(int i = 0; i < ROW_COUNT; i++){
					for(int j = 0; j < COL_COUNT; j++){
						if (_boxes[i][j] != null)
						_boxes[i][j].remove();
						_boxes[i][j] = null;
						}
					}
			}
		
		};
	
		controller.setView(view);
		controller.setModel(model);

		Timer.schedule(new Timer.Task() {
			@Override
			public void run(){
				controller.moveDown(true);
			}

		}, 0.6f, 0.6f);
		
		
		Gdx.input.setInputProcessor(this);
		addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				switch(keycode){
				case Input.Keys.LEFT:
					if (rider.actorX > 0)
					rider.actorX-=30;
					break;
				case Input.Keys.RIGHT:
					if (rider.actorX < Gdx.graphics.getWidth() - SIZE)
					rider.actorX+=30;
					break;	
				}
				return true;
			}
		});
	}
	
}
