package Ride;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GOStage extends Stage {
	public GOStage(){
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false);
		setViewport(new ScreenViewport(camera));
	}
	
	public void init(){
		BackgroundImage background = new BackgroundImage(2);	
		GOStage.this.addActor(background);
	}
}
