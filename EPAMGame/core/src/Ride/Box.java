package Ride;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Box  extends Actor{
	
	protected static final int SIZE = 30;

	private Texture _texture;
	
	public Box(int colorIndex){
    	switch (colorIndex){
    	case 4:
    		_texture = new Texture("bonus.png");
    		break;
    	default:
    		_texture = new Texture("block.png");
    	}
	}

	@Override
	public void draw(Batch batch, float parentAlpha){
		batch.draw(_texture, this.getX(), this.getY(), SIZE, SIZE);
	}

	public void setColor(int colorIndex) {
    	switch (colorIndex){
	    	case 4:
	    		_texture = new Texture("bonus.png");
	    		break;
	    	default:
	    		_texture = new Texture("block.png");
    	}
	}

}
