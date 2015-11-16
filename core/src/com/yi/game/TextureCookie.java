package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class TextureCookie {
    static Texture textureCookie = new Texture(Gdx.files.internal("cookie.png"));
    Rectangle rectCookieBorder;
    int screenWidth = Gdx.graphics.getWidth();
    int screenHeight = Gdx.graphics.getHeight();
    static int textureWidth = textureCookie.getWidth();
    static int textureHeight = textureCookie.getHeight();
    Vector2 vector2CookieXY;
    float velocity;

    public TextureCookie(Vector2 location){
        rectCookieBorder = new Rectangle();
        rectCookieBorder.x = location.x;
        rectCookieBorder.y = location.y;
        rectCookieBorder.width = textureWidth;
        rectCookieBorder.height = textureHeight;

        vector2CookieXY = new Vector2(0, 0);
        velocity = 600f;
        vector2CookieXY.y = velocity;
    }
}
