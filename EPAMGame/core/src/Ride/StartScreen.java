package Ride;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class StartScreen implements Screen{

        RideGame _game;
        
       
        public StartScreen(RideGame game) {
        	_game = game;
        }
 
    	StartStage _stage;

        @Override
        public void show() {
    		_stage = new StartStage();
    		_stage.init();
        }
    	
        @Override
        public void render(float delta) {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);   	
            if (Gdx.input.justTouched()) 
                _game.setScreen(_game.raceScreen);
            
            _stage.act(delta);
            _stage.draw();
        }

        @Override
        public void resize(int width, int height) {
    		_stage.getViewport().update(width, height, true);
        }
        

        @Override
        public void hide() {}
        @Override
        public void pause() {}
        @Override
        public void resume() {}
        @Override
        public void dispose() {}
    }

