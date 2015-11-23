package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * this class contain all data of a player,<br>
 * this class control and manage player itself,<br>
 * update player position base on finger touch position on the left or right of the player.
 */
public class TextureDroplet {
    static Texture textureDroplet = new Texture(Gdx.files.internal("droplet.png"));
    Rectangle rectDropletBorder;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    Vector2 vector2DropletXY;
    float velocity;
    int numberOFLife;
    long lastTimeLoseLife;
    SoundMusic soundMusic;
    static float spriteDropletWidth = 60;
    static float spriteDropletHeight = 260;
    // when use Sprite to draw instead of SpriteBatch change the control's update sync with Rectangle and add draw
    Sprite spriteDroplet;

    public TextureDroplet(){
        rectDropletBorder = new Rectangle();
        rectDropletBorder.x = screenWidth / 2 - spriteDropletWidth / 2;
        rectDropletBorder.y = 1;
        rectDropletBorder.width = spriteDropletWidth;
        rectDropletBorder.height = spriteDropletHeight;

        vector2DropletXY = new Vector2(0, 0);
        velocity = 500f;
        numberOFLife = 3;
        lastTimeLoseLife = TimeUtils.nanoTime();
        soundMusic = new SoundMusic();

        spriteDroplet = new Sprite(textureDroplet);
        spriteDroplet.setPosition(rectDropletBorder.x, rectDropletBorder.y);
        spriteDroplet.setSize(spriteDropletWidth, spriteDropletHeight);
    }

    /**
     * move boss on each update call base on finger touch position on the left or right of the player
     */
    public void positionUpdate(int touchX, float deltaTime){
        if(touchX < rectDropletBorder.x + spriteDropletWidth/2){
            rectDropletBorder.x += -velocity * deltaTime;
        }
        else if(touchX > rectDropletBorder.x + spriteDropletWidth/2){
            rectDropletBorder.x += velocity * deltaTime;
        }
        spriteDroplet.setPosition(rectDropletBorder.x, rectDropletBorder.y);
    }

    /**
     * draw player Sprite
     */
    public void draw(SpriteBatch batch){
        spriteDroplet.draw(batch);
    }

    /**
     * reset player start position and life
     */
    public void reset(){
        rectDropletBorder.x = screenWidth / 2 - spriteDropletWidth / 2;
        rectDropletBorder.y = 1;
        spriteDroplet.setPosition(rectDropletBorder.x, rectDropletBorder.y);
        numberOFLife = 3;
    }

    /**
     * I think there are 2 ways of dealing with losing life,
     * 1). on collision lose 1 life and wait (become invulnerable) for 2 seconds,
     * 2). on collision lose 1 life and enemy will destroy, so will not farther collide.
     */
    public void loseLife(){
        if(TimeUtils.nanoTime() - lastTimeLoseLife > 2000000000l){
            lastTimeLoseLife = TimeUtils.nanoTime();
            soundMusic.playSoundPlayerHit();
            numberOFLife--;
        }
    }
}
