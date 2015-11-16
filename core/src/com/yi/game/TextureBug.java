package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class TextureBug {
    static Texture textureBug = new Texture(Gdx.files.internal("bug.png"));
    Rectangle rectBugBorder;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    static int textureWidth = textureBug.getWidth();
    static int textureHeight = textureBug.getHeight();
    Vector2 vector2BugXY;
    float velocity;

    public TextureBug(){
        rectBugBorder = new Rectangle();
        rectBugBorder.x = MathUtils.random(1, screenWidth - textureWidth - 1);
        rectBugBorder.y = screenHeight - textureHeight - 1;
        rectBugBorder.width = textureWidth;
        rectBugBorder.height = textureHeight;

        vector2BugXY = new Vector2(0, 0);
        velocity = 200f;
        vector2BugXY.x = MathUtils.random(-velocity, velocity)*2;
        vector2BugXY.y = MathUtils.random(-velocity / 2, -velocity);
    }

    public TextureBug(float increaseVelocity){
        rectBugBorder = new Rectangle();
        rectBugBorder.x = MathUtils.random(1, screenWidth - textureWidth - 1);
        rectBugBorder.y = screenHeight - textureHeight - 1;
        rectBugBorder.width = textureWidth;
        rectBugBorder.height = textureHeight;

        vector2BugXY = new Vector2(0, 0);
        velocity = 200f;
        vector2BugXY.x = MathUtils.random(-velocity, velocity)*2*increaseVelocity;
        vector2BugXY.y = MathUtils.random(-velocity / 2, -velocity)*increaseVelocity;
    }
}
