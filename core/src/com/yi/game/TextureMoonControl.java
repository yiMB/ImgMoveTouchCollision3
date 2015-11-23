package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * this class control and manage boss bullets in an Array,<br>
 * add multiple boss bullets at once, option for change of speed,<br>
 * use Sprite for image, so it can set size and animation later,<br>
 * update and design boss bullets auto movement,<br>
 * draw boss bullets to screen.
 */
public class TextureMoonControl {
    Array<TextureMoon> arrTextureMoons;

    public TextureMoonControl(){
        arrTextureMoons = new Array<TextureMoon>();
    }

    /**
     * this method add 1 boss bullet, vector is 90 degree
     */
    public void addTextureMoon(Vector2 location){
        TextureMoon textureMoon = new TextureMoon(location);
        arrTextureMoons.add(textureMoon);
    }

    /**
     * this method add 3 boss bullets at once each vectors are 120, 90, 60 degree.<br>
     * velocity is -600f by default so:<br>
     * textureMoon1 set y vector to 600 pixel (don't need to set already set as default)<br>
     * textureMoon2 set x vector to 600 / 3 pixel, same y<br>
     * textureMoon3 set x vector to 600 / -3 pixel, same y
     */
    public void add3TextureMoons(Vector2 location){
        TextureMoon textureMoon1 = new TextureMoon(location);
        TextureMoon textureMoon2 = new TextureMoon(location);
        textureMoon2.vector2MoonXY.x = textureMoon2.velocity / 3;
        TextureMoon textureMoon3 = new TextureMoon(location);
        textureMoon3.vector2MoonXY.x = textureMoon3.velocity / -3;
        TextureMoon textureMoon4 = new TextureMoon(location);
        textureMoon4.vector2MoonXY.x = textureMoon2.velocity / 2;
        TextureMoon textureMoon5 = new TextureMoon(location);
        textureMoon5.vector2MoonXY.x = textureMoon2.velocity / -2;
//        TextureMoon textureMoon6 = new TextureMoon(location);
//        textureMoon6.vector2MoonXY.x = textureMoon2.velocity / 6;
//        TextureMoon textureMoon7 = new TextureMoon(location);
//        textureMoon7.vector2MoonXY.x = textureMoon2.velocity / -6;

        arrTextureMoons.add(textureMoon1);
        arrTextureMoons.add(textureMoon2);
        arrTextureMoons.add(textureMoon3);
        arrTextureMoons.add(textureMoon4);
        arrTextureMoons.add(textureMoon5);
//        arrTextureMoons.add(textureMoon6);
//        arrTextureMoons.add(textureMoon7);
    }

    /**
     * dispose all boss bullets Texture
     */
    public void disposeMoons(){
        for(TextureMoon textureMoon : arrTextureMoons){
            textureMoon.textureMoon.dispose();
        }
    }

    /**
     * move boss bullet on each update call base on movement design inside this method and TextureMoon setup,<br>
     * remove when reach edge of screen.
     */
    public void update(){
        for(TextureMoon textureMoon : arrTextureMoons){
            if(textureMoon.rectMoonBorder.x <= 0){
                arrTextureMoons.removeValue(textureMoon, true);
            }
            if(textureMoon.rectMoonBorder.x + textureMoon.spriteMoon.getWidth() >= textureMoon.screenWidth){
                arrTextureMoons.removeValue(textureMoon, true);
            }
            if(textureMoon.rectMoonBorder.y <= 0){
                arrTextureMoons.removeValue(textureMoon, true);
            }
//            if(textureMoon.rectMoonBorder.y + textureMoon.spriteMoon.getHeight() >= textureMoon.screenHeight){
//                arrTextureMoons.removeValue(textureMoon, true);
//            }
            textureMoon.rectMoonBorder.x += textureMoon.vector2MoonXY.x * Gdx.graphics.getDeltaTime();
            textureMoon.rectMoonBorder.y += textureMoon.vector2MoonXY.y * Gdx.graphics.getDeltaTime();

            textureMoon.spriteMoon.setPosition(textureMoon.rectMoonBorder.x, textureMoon.rectMoonBorder.y);
        }
    }

    /**
     * draw each boss bullets Sprite
     */
    public void draw(SpriteBatch batch){
        for(TextureMoon textureMoon : arrTextureMoons){
            textureMoon.spriteMoon.draw(batch);
        }
    }
}
