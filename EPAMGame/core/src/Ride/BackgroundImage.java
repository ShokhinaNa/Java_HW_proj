package Ride;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackgroundImage extends Actor {
	
    private Texture backgroundTexture;
    private Sprite backgroundSprite;
    
    public BackgroundImage(int i) {
    	switch (i){
    	case 0:
            backgroundTexture = new Texture("road0.png");
            break;
    	case 1:
            backgroundTexture = new Texture("road1.png");
            break;
    	case 2:
            backgroundTexture = new Texture("road2.png");
            break;
    	}
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    

    @Override
    public void draw(Batch batch, float alpha) {
        backgroundSprite.draw(batch);
    }
}
