package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * this class contain all data of a player bullet,<br>
 * bullet y vector is going up because player shot upward.
 */
public class TextureCookie {
    static Texture textureCookie = new Texture(Gdx.files.internal("cookie.png"));
    Rectangle rectCookieBorder;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    Vector2 vector2CookieXY;
    float velocity;
    static float spriteCookieWidth = 20;
    static float spriteCookieHeight = 20;
    // when use Sprite to draw instead of SpriteBatch change the control's update sync with Rectangle and add draw
    Sprite spriteCookie;

    public TextureCookie(Vector2 location){
        rectCookieBorder = new Rectangle();
        rectCookieBorder.x = location.x;
        rectCookieBorder.y = location.y;
        rectCookieBorder.width = spriteCookieWidth;
        rectCookieBorder.height = spriteCookieHeight;

        vector2CookieXY = new Vector2(0, 0);
        velocity = 600f;
        vector2CookieXY.x = 0;
        vector2CookieXY.y = velocity;

        spriteCookie = new Sprite(textureCookie);
        spriteCookie.setPosition(rectCookieBorder.x, rectCookieBorder.y);
        spriteCookie.setSize(spriteCookieWidth, spriteCookieHeight);
    }
}
