package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * this class control and manage bosses in an Array,<br>
 * add multiple bosses at once, option for change of speed,<br>
 * use Sprite for image, so it can set size and animation later,<br>
 * update and design boss auto movement,<br>
 * draw boss to screen.
 */
public class TextureCheesecakeControl {
    Array<TextureCheesecake> arrTextureCheesecakes;

    public TextureCheesecakeControl(){
        arrTextureCheesecakes = new Array<TextureCheesecake>();
    }

    public void addTextureCheesecake(){
        TextureCheesecake textureCheesecake = new TextureCheesecake();
        arrTextureCheesecakes.add(textureCheesecake);
    }

    /**
     * add n default bosses
     */
    public void addNTextureCheesecake(int n){
        while(n > 0){
            addTextureCheesecake();
            n--;
        }
    }

//    public void addTextureCheesecake(float increaseVelocity){
//        TextureCheesecake textureCheesecake = new TextureCheesecake(increaseVelocity);
//        arrTextureCheesecakes.add(textureCheesecake);
//    }
//
//    public void addNTextureCheesecake(int n, float increaseVelocity){
//        while(n > 0){
//            addTextureCheesecake(increaseVelocity);
//            n--;
//        }
//    }

    /**
     * dispose all boss Texture
     */
    public void disposeCheesecakes(){
        for(TextureCheesecake textureCheesecake : arrTextureCheesecakes){
            textureCheesecake.textureCheesecake.dispose();
        }
    }

    /**
     * move boss on each update call base on movement design inside this method and TextureCheesecake setup,<br>
     * bounce left, right, top, and 1/4 of bottom.
     */
    public void update() {
        for (TextureCheesecake textureCheesecake : arrTextureCheesecakes) {
            if (textureCheesecake.rectCheesecakeBorder.x <= 0) {
                textureCheesecake.vector2CheesecakeXY.x = -textureCheesecake.vector2CheesecakeXY.x;
            }
            if (textureCheesecake.rectCheesecakeBorder.x + textureCheesecake.spriteCheesecake.getWidth() >= textureCheesecake.screenWidth) {
                textureCheesecake.vector2CheesecakeXY.x = -textureCheesecake.vector2CheesecakeXY.x;
            }
            // I set boss bounce back at 1/4 of the bottom screen
            if (textureCheesecake.rectCheesecakeBorder.y <= textureCheesecake.screenHeight / 4) {
                textureCheesecake.vector2CheesecakeXY.y = -textureCheesecake.vector2CheesecakeXY.y;
            }
            if (textureCheesecake.rectCheesecakeBorder.y + textureCheesecake.spriteCheesecake.getHeight() >= textureCheesecake.screenHeight) {
                textureCheesecake.vector2CheesecakeXY.y = -textureCheesecake.vector2CheesecakeXY.y;
            }
            textureCheesecake.rectCheesecakeBorder.x += textureCheesecake.vector2CheesecakeXY.x * Gdx.graphics.getDeltaTime();
            textureCheesecake.rectCheesecakeBorder.y += textureCheesecake.vector2CheesecakeXY.y * Gdx.graphics.getDeltaTime();

            textureCheesecake.spriteCheesecake.setPosition(textureCheesecake.rectCheesecakeBorder.x, textureCheesecake.rectCheesecakeBorder.y);
        }
    }

    /**
     * draw each bosses Sprite
     */
    public void draw(SpriteBatch batch){
        for(TextureCheesecake textureCheesecake : arrTextureCheesecakes){
            textureCheesecake.spriteCheesecake.draw(batch);
        }
    }
}
