package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * this class contain all data of a boss
 */
public class TextureCheesecake {
    static Texture textureCheesecake = new Texture(Gdx.files.internal("cheesecakeTrans.png"));
    Rectangle rectCheesecakeBorder;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    Vector2 vector2CheesecakeXY;
    float velocity;
    int numberOFLife;
    long lastTimeLoseLife;
    static float spriteCheesecakeWidth = 250;
    static float spriteCheesecakeHeight = 200;
    // when use Sprite to draw instead of SpriteBatch change the control's update sync with Rectangle and add draw
    Sprite spriteCheesecake;

    /**
     * default constructor create boss with default setup and speed
     */
    public TextureCheesecake(){
        rectCheesecakeBorder = new Rectangle();
        rectCheesecakeBorder.x = MathUtils.random(1, screenWidth - spriteCheesecakeWidth - 1);
        rectCheesecakeBorder.y = screenHeight - spriteCheesecakeHeight - 1;
        rectCheesecakeBorder.width = spriteCheesecakeWidth;
        rectCheesecakeBorder.height = spriteCheesecakeHeight;

        vector2CheesecakeXY = new Vector2(0, 0);
        velocity = 400f;
        vector2CheesecakeXY.x = MathUtils.random(-velocity, velocity)*2;
        vector2CheesecakeXY.y = MathUtils.random(-velocity / 2, -velocity);

        numberOFLife = 20;
        lastTimeLoseLife = TimeUtils.nanoTime();

        spriteCheesecake = new Sprite(textureCheesecake);
        spriteCheesecake.setPosition(rectCheesecakeBorder.x, rectCheesecakeBorder.y);
        spriteCheesecake.setSize(spriteCheesecakeWidth, spriteCheesecakeHeight);
    }

    /**
     * constructor create boss with change of speed
     */
//    public TextureCheesecake(float increaseVelocity){
//        rectCheesecakeBorder = new Rectangle();
//        rectCheesecakeBorder.x = MathUtils.random(1, screenWidth - textureWidth - 1);
//        rectCheesecakeBorder.y = screenHeight - textureHeight - 1;
//        rectCheesecakeBorder.width = spriteCheesecakeWidthHeight;
//        rectCheesecakeBorder.height = spriteCheesecakeWidthHeight;
//
//        vector2CheesecakeXY = new Vector2(0, 0);
//        velocity = 400f;
//        vector2CheesecakeXY.x = MathUtils.random(-velocity, velocity)*2*increaseVelocity;
//        vector2CheesecakeXY.y = MathUtils.random(-velocity / 2, -velocity)*increaseVelocity;
//
//        numberOFLife = 50;
//        lastTimeLoseLife = TimeUtils.nanoTime();
//
//        spriteCheesecake = new Sprite(textureCheesecake);
//        spriteCheesecake.setPosition(rectCheesecakeBorder.x, rectCheesecakeBorder.y);
//        spriteCheesecake.setSize(spriteCheesecakeWidthHeight, spriteCheesecakeWidthHeight);
//    }

    /**
     * boss life decrease by 1 when call this method
     */
    public void loseLife(){
        numberOFLife--;
    }
}
