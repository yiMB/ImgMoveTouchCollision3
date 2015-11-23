package com.yi.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * this class contain all data of a boss bullet,<br>
 * bullet y vector is going down because boss shot downward.
 */
public class TextureMoon {
    static Texture textureMoon = new Texture(Gdx.files.internal("moon.png"));
    Rectangle rectMoonBorder;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    Vector2 vector2MoonXY;
    float velocity;
    static float spriteMoonWidth = 20;
    static float spriteMoonHeight = 20;
    // when use Sprite to draw instead of SpriteBatch change the control's update sync with Rectangle and add draw
    Sprite spriteMoon;

    public TextureMoon(Vector2 location){
        rectMoonBorder = new Rectangle();
        rectMoonBorder.x = location.x;
        rectMoonBorder.y = location.y;
        rectMoonBorder.width = spriteMoonWidth;
        rectMoonBorder.height = spriteMoonHeight;

        vector2MoonXY = new Vector2(0, 0);
        velocity = 600f;
        vector2MoonXY.x = 0;
        vector2MoonXY.y = -velocity;

        spriteMoon = new Sprite(textureMoon);
        spriteMoon.setPosition(rectMoonBorder.x, rectMoonBorder.y);
        spriteMoon.setSize(spriteMoonWidth, spriteMoonHeight);
    }
}
