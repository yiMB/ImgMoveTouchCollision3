package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class ImgMoveTouchCollision3 extends ApplicationAdapter {
	SpriteBatch batch;
	TextureBugControl textureBugControl;
	TextureDroplet textureDroplet;
	TextureCookieControl textureCookieControl;
	long lastTimeCookie;
	int score, maxScore;
	FontText fontText;
	int gameState;
	Texture background;
	float increaseVelocity;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureBugControl = new TextureBugControl();
		textureBugControl.addNTextureBug(5);
		textureDroplet = new TextureDroplet();
		textureCookieControl = new TextureCookieControl();
		lastTimeCookie = TimeUtils.nanoTime();
		score = 0;
		maxScore = 10;
		fontText = new FontText();
		gameState = 1;
		background = new Texture("daytime.png");
		increaseVelocity = 1;
	}

	@Override
	public void dispose() {
		batch.dispose();
		for(int i=0; i < textureBugControl.arrTextureBugs.size; i++){
			textureBugControl.arrTextureBugs.get(i).textureBug.dispose();
		}
		textureDroplet.textureDroplet.dispose();
		for(int i=0; i < textureCookieControl.arrTextureCookies.size; i++){
			textureCookieControl.arrTextureCookies.get(i).textureCookie.dispose();
		}
		background.dispose();
		fontText.bitmapFontScore.dispose();
	}

	@Override
	public void render() {
		update();
		draw();
	}

	public void resetGame(){
		gameState = 2;
		textureCookieControl.arrTextureCookies.clear();
		textureBugControl.arrTextureBugs.clear();
		textureBugControl.addNTextureBug(5);
		textureDroplet.reset();
		score=0;
		increaseVelocity=1;
	}

	public void respawnBugs(){
		textureBugControl.arrTextureBugs.clear();
		textureBugControl.addNTextureBug(5, increaseVelocity);
	}

	public void update() {
		if(gameState == 1){
			if (Gdx.input.justTouched()){
				resetGame();
			}
		}
		else if(gameState == 2){
//			background = new Texture("Starry_sky.png");

			Gdx.input.setInputProcessor(new InputProcessor() {
				@Override
				public boolean touchDown(int screenX, int screenY, int pointer, int button) {
					textureDroplet.positionUpdate(screenX, Gdx.graphics.getDeltaTime() * 2);
					return true;
				}
				@Override
				public boolean touchUp(int screenX, int screenY, int pointer, int button) {
					if(TimeUtils.nanoTime() - lastTimeCookie > 200000000l){
						lastTimeCookie = TimeUtils.nanoTime();
						textureCookieControl.addTextureCookie(
								new Vector2(textureDroplet.rectDropletBorder.x + textureDroplet.rectDropletBorder.width/2 - TextureCookie.textureCookie.getWidth()/2,
										textureDroplet.rectDropletBorder.y + textureDroplet.rectDropletBorder.height));
					}
					return true;
				}
				@Override
				public boolean touchDragged(int screenX, int screenY, int pointer) {
					textureDroplet.positionUpdate(screenX, Gdx.graphics.getDeltaTime());
					return true;
				}
				@Override
				public boolean keyDown(int keycode) {
					return false;
				}
				@Override
				public boolean keyUp(int keycode) {
					return false;
				}
				@Override
				public boolean keyTyped(char character) {
					return false;
				}
				@Override
				public boolean mouseMoved(int screenX, int screenY) {
					return false;
				}
				@Override
				public boolean scrolled(int amount) {
					return false;
				}
			});

			if(textureBugControl.arrTextureBugs.size == 0){
				respawnBugs();
			}
			textureCookieControl.update();
			textureBugControl.update();

			if(score == maxScore){
				gameState = 3;
			}
		}
		else if(gameState == 3){
			background = new Texture("sunset.png");
			if (Gdx.input.justTouched()){
				background = new Texture("daytime.png");
				gameState = 1;
			}
		}
	}

	public void draw(){
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(gameState == 1){
			batch.begin();
			batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			fontText.draw(batch, "This is start page", Gdx.graphics.getWidth() / 2 - 200, Gdx.graphics.getHeight() / 2);
			fontText.draw(batch, "Touch screen to game page", Gdx.graphics.getWidth() / 2 - 200, Gdx.graphics.getHeight() / 2 - 200);
			batch.end();
		}
		else if(gameState == 2){
			batch.begin();

//			batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

			fontText.draw(batch, "Score="+score, Gdx.graphics.getWidth() - 200, Gdx.graphics.getHeight() - 50);

			for(TextureCookie textureCookie : textureCookieControl.arrTextureCookies){
				batch.draw(textureCookie.textureCookie, textureCookie.rectCookieBorder.x, textureCookie.rectCookieBorder.y);
			}
			for(TextureBug textureBug : textureBugControl.arrTextureBugs){
				batch.draw(textureBug.textureBug, textureBug.rectBugBorder.x, textureBug.rectBugBorder.y,
						textureBug.rectBugBorder.width, textureBug.rectBugBorder.height);
				for(TextureCookie textureCookie : textureCookieControl.arrTextureCookies){
					if(textureCookie.rectCookieBorder.overlaps(textureBug.rectBugBorder)){
						textureCookieControl.arrTextureCookies.removeValue(textureCookie, true);
						textureBugControl.arrTextureBugs.removeValue(textureBug, true);
						score++;
						increaseVelocity+=0.2;
					}
				}
				if(textureBug.rectBugBorder.overlaps(new Rectangle(textureDroplet.rectDropletBorder.x, textureDroplet.rectDropletBorder.y,
						textureDroplet.rectDropletBorder.width, textureDroplet.rectDropletBorder.height))){
					resetGame();
					gameState = 3;
				}
			}

			batch.draw(textureDroplet.textureDroplet, textureDroplet.rectDropletBorder.x, textureDroplet.rectDropletBorder.y);

			batch.end();
		}
		else if(gameState == 3){
			batch.begin();
			batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			fontText.draw(batch, "This is game over page", Gdx.graphics.getWidth() / 2 - 200, Gdx.graphics.getHeight() / 2);
			fontText.draw(batch, "Touch screen to start page", Gdx.graphics.getWidth() / 2 - 200, Gdx.graphics.getHeight() / 2 - 200);
			batch.end();
		}
	}
}
