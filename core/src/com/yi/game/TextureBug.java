package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * this class contain all data of a enemy
 */
public class TextureBug {
    static Texture textureBug = new Texture(Gdx.files.internal("bug.png"));
    Rectangle rectBugBorder;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    Vector2 vector2BugXY;
    float velocity;
    static float spriteBugWidth = 100;
    static float spriteBugHeight = 50;
    // when use Sprite to draw instead of SpriteBatch change the control's update sync with Rectangle and add draw
    Sprite spriteBug;

    /**
     * default constructor create enemy with default setup and speed
     */
    public TextureBug(){
        rectBugBorder = new Rectangle();
        rectBugBorder.x = MathUtils.random(1, screenWidth - spriteBugWidth - 1);
        rectBugBorder.y = screenHeight - spriteBugHeight - 1;
        rectBugBorder.width = spriteBugWidth;
        rectBugBorder.height = spriteBugHeight;

        vector2BugXY = new Vector2(0, 0);
        velocity = 200f;
        vector2BugXY.x = MathUtils.random(-velocity, velocity)*2;
        vector2BugXY.y = MathUtils.random(-velocity / 2, -velocity);

        spriteBug = new Sprite(textureBug);
        spriteBug.setPosition(rectBugBorder.x, rectBugBorder.y);
        spriteBug.setSize(spriteBugWidth, spriteBugHeight);
    }

    /**
     * constructor create enemy with change of speed
     */
    public TextureBug(float increaseVelocity){
        rectBugBorder = new Rectangle();
        rectBugBorder.x = MathUtils.random(1, screenWidth - spriteBugWidth - 1);
        rectBugBorder.y = screenHeight - spriteBugHeight - 1;
        rectBugBorder.width = spriteBugWidth;
        rectBugBorder.height = spriteBugHeight;

        vector2BugXY = new Vector2(0, 0);
        velocity = 200f;
        vector2BugXY.x = MathUtils.random(-velocity, velocity)*2*increaseVelocity;
        vector2BugXY.y = MathUtils.random(-velocity / 2, -velocity)*increaseVelocity;

        spriteBug = new Sprite(textureBug);
        spriteBug.setPosition(rectBugBorder.x, rectBugBorder.y);
        spriteBug.setSize(spriteBugWidth, spriteBugHeight);
    }
}
