package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class TextureCookieControl {
    Array<TextureCookie> arrTextureCookies;

    public TextureCookieControl(){
        arrTextureCookies = new Array<TextureCookie>();
    }

    public void addTextureCookie(Vector2 location){
        TextureCookie textureCookie = new TextureCookie(location);
        arrTextureCookies.add(textureCookie);
    }

//    public void addNTextureCookie(Vector2 location, int n){
//        while(n > 0){
//            addTextureCookie(location);
//            n--;
//        }
//    }

    public void update(){
        for(TextureCookie textureCookie : arrTextureCookies){
//            if(textureCookie.rectCookieBorder.x <= 0){
//                arrTextureCookies.removeValue(textureCookie, true);
//            }
//            if(textureCookie.rectCookieBorder.x + textureCookie.textureWidth >= textureCookie.screenWidth){
//                arrTextureCookies.removeValue(textureCookie, true);
//            }
//            if(textureCookie.rectCookieBorder.y <= 0){
//                arrTextureCookies.removeValue(textureCookie, true);
//            }
            if(textureCookie.rectCookieBorder.y + textureCookie.textureHeight >= textureCookie.screenHeight){
                arrTextureCookies.removeValue(textureCookie, true);
            }
//            textureCookie.rectCookieBorder.x += textureCookie.vector2CookieXY.x * Gdx.graphics.getDeltaTime();
            textureCookie.rectCookieBorder.y += textureCookie.vector2CookieXY.y * Gdx.graphics.getDeltaTime();
        }
    }
}

