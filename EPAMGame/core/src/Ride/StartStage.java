package Ride;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class StartStage extends Stage {

	public StartStage(){
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false);
		setViewport(new ScreenViewport(camera));
	}
	
	public void init(){
		BackgroundImage background = new BackgroundImage(0);	
		StartStage.this.addActor(background);
	}
}
