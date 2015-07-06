package Ride;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RideGame extends Game {
	
	public StartScreen startScreen;
	public  RaceScreen  raceScreen;
	public GOScreen  goScreen;

    public static RideGame game = new RideGame();
	
    public RideGame() {
    }
    
   
	@Override
    public void create() {    
	      startScreen = new StartScreen(this);
	      raceScreen = new RaceScreen(this);	      

	      setScreen(startScreen);
    }
	
}
