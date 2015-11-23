package com.yi.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class TextureMoonControl {
    Array<TextureMoon> arrTextureMoons;

    public TextureMoonControl(){
        arrTextureMoons = new Array<TextureMoon>();
    }

    public void addTextureMoon(Vector2 location){
        TextureMoon textureMoon = new TextureMoon(location);
        arrTextureMoons.add(textureMoon);
    }

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

    public void disposeMoons(){
        for(TextureMoon textureMoon : arrTextureMoons){
            textureMoon.textureMoon.dispose();
        }
    }

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

    public void draw(SpriteBatch batch){
        for(TextureMoon textureMoon : arrTextureMoons){
            textureMoon.spriteMoon.draw(batch);
        }
    }
}
