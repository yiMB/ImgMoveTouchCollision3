package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * this class control and manage player bullets in an Array,<br>
 * add multiple player bullets at once, option for change of speed,<br>
 * use Sprite for image, so it can set size and animation later,<br>
 * update and design player bullets auto movement,<br>
 * draw player bullets to screen.
 */
public class TextureCookieControl {
    Array<TextureCookie> arrTextureCookies;

    public TextureCookieControl(){
        arrTextureCookies = new Array<TextureCookie>();
    }

    /**
     * this method add 1 player bullet, vector is 90 degree
     */
    public void addTextureCookie(Vector2 location){
        TextureCookie textureCookie = new TextureCookie(location);
        arrTextureCookies.add(textureCookie);
    }

    /**
     * this method add 3 player bullets at once each vectors are 120, 90, 60 degree.<br>
     * velocity is 600f by default so:<br>
     * textureCookie1 set y vector to 600 pixel (don't need to set already set as default)<br>
     * textureCookie2 set x vector to 600 / 3 pixel, same y<br>
     * textureCookie3 set x vector to 600 / -3 pixel, same y
     */
//    public void add3TextureCookies(Vector2 location){
//        TextureCookie textureCookie1 = new TextureCookie(location);
//        TextureCookie textureCookie2 = new TextureCookie(location);
//        textureCookie2.vector2CookieXY.x = textureCookie2.velocity / 3;
//        TextureCookie textureCookie3 = new TextureCookie(location);
//        textureCookie3.vector2CookieXY.x = textureCookie3.velocity / -3;
//
//        arrTextureCookies.add(textureCookie1);
//        arrTextureCookies.add(textureCookie2);
//        arrTextureCookies.add(textureCookie3);
//    }

    /**
     * dispose all player bullets Texture
     */
    public void disposeCookies(){
        for(TextureCookie textureCookie : arrTextureCookies){
            textureCookie.textureCookie.dispose();
        }
    }

    /**
     * move player bullet on each update call base on movement design inside this method and TextureCookie setup,<br>
     * remove when reach edge of screen.
     */
    public void update(){
        for(TextureCookie textureCookie : arrTextureCookies){
            if(textureCookie.rectCookieBorder.x <= 0){
                arrTextureCookies.removeValue(textureCookie, true);
            }
            if(textureCookie.rectCookieBorder.x + textureCookie.spriteCookie.getWidth() >= textureCookie.screenWidth){
                arrTextureCookies.removeValue(textureCookie, true);
            }
//            if(textureCookie.rectCookieBorder.y <= 0){
//                arrTextureCookies.removeValue(textureCookie, true);
//            }
            if(textureCookie.rectCookieBorder.y + textureCookie.spriteCookie.getHeight() >= textureCookie.screenHeight){
                arrTextureCookies.removeValue(textureCookie, true);
            }
            textureCookie.rectCookieBorder.x += textureCookie.vector2CookieXY.x * Gdx.graphics.getDeltaTime();
            textureCookie.rectCookieBorder.y += textureCookie.vector2CookieXY.y * Gdx.graphics.getDeltaTime();

            textureCookie.spriteCookie.setPosition(textureCookie.rectCookieBorder.x, textureCookie.rectCookieBorder.y);
        }
    }

    /**
     * draw each player bullets Sprite
     */
    public void draw(SpriteBatch batch){
        for(TextureCookie textureCookie : arrTextureCookies){
            textureCookie.spriteCookie.draw(batch);
        }
    }
}
