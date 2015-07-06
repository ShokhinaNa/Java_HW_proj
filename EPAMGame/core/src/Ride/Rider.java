package Ride;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Rider extends Actor{
	protected static final int SIZE = 30;

	private Texture _texture;
	
	public Rider(){
		_texture = new Texture("rider.png");
	}

	@Override
	public void draw(Batch batch, float parentAlpha){
		batch.draw(_texture, this.getX(), this.getY(), SIZE, SIZE);
	}
}
