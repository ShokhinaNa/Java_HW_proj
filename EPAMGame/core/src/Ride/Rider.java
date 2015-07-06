package Ride;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Rider extends Actor{
	protected static final int SIZE = 30;
	private Texture _texture;
	float actorX = 60, actorY = 410;
	public static boolean isMoveLeft = false;
	public static boolean isMoveRight = false;
	
	public Rider(){
		_texture = new Texture("rider.png");
		setBounds(actorX, actorY, SIZE, SIZE);
		}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		batch.draw(_texture, actorX, actorY, SIZE, SIZE);
	}
	
}
