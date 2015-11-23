package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * this class control and manage enemies in an Array,<br>
 * add multiple enemies at once, option for change of speed,<br>
 * use Sprite for image, so it can set size and animation later,<br>
 * update and design enemy auto movement,<br>
 * draw enemy to screen.
 */
public class TextureBugControl {
    Array<TextureBug> arrTextureBugs;

    public TextureBugControl(){
        arrTextureBugs = new Array<TextureBug>();
    }

    public void addTextureBug(){
        TextureBug textureBug = new TextureBug();
        arrTextureBugs.add(textureBug);
    }

    /**
     * add n default enemies
     */
    public void addNTextureBug(int n){
        while(n > 0){
            addTextureBug();
            n--;
        }
    }

    public void addTextureBug(float increaseVelocity){
        TextureBug textureBug = new TextureBug(increaseVelocity);
        arrTextureBugs.add(textureBug);
    }

    /**
     * add n enemies with given speed change
     */
    public void addNTextureBug(int n, float increaseVelocity){
        while(n > 0){
            addTextureBug(increaseVelocity);
            n--;
        }
    }

    /**
     * dispose all enemy Texture
     */
    public void disposeBugs(){
        for(TextureBug textureBug : arrTextureBugs){
            textureBug.textureBug.dispose();
        }
    }

    /**
     * move enemy on each update call base on movement design inside this method and TextureBug setup,<br>
     * bounce left and right, remove when reach bottom.
     */
    public void update(){
        for(TextureBug textureBug : arrTextureBugs){
            if(textureBug.rectBugBorder.x <= 0){
                textureBug.vector2BugXY.x = -textureBug.vector2BugXY.x;
            }
            if(textureBug.rectBugBorder.x + textureBug.spriteBug.getWidth() >= textureBug.screenWidth){
                textureBug.vector2BugXY.x = -textureBug.vector2BugXY.x;
            }
            if(textureBug.rectBugBorder.y <= 0){
                arrTextureBugs.removeValue(textureBug, true);
            }
            if(textureBug.rectBugBorder.y + textureBug.spriteBug.getHeight() >= textureBug.screenHeight){
                textureBug.vector2BugXY.y = -textureBug.vector2BugXY.y;
            }
            textureBug.rectBugBorder.x += textureBug.vector2BugXY.x * Gdx.graphics.getDeltaTime();
            textureBug.rectBugBorder.y += textureBug.vector2BugXY.y * Gdx.graphics.getDeltaTime();

            textureBug.spriteBug.setPosition(textureBug.rectBugBorder.x, textureBug.rectBugBorder.y);
        }

        // not totally right
        // move zig zag
        // change TextureBug.java to start move on x
//        for(TextureBug textureBug : arrTextureBugs){
//            if(textureBug.rectBugBorder.x <= 10){
//                textureBug.vector2BugXY.x = 0;
//                textureBug.vector2BugXY.y = -textureBug.velocity;
//            }
//            if(textureBug.rectBugBorder.x + textureBug.textureWidth >= textureBug.screenWidth - 10){
//                textureBug.vector2BugXY.x = 0;
//                textureBug.vector2BugXY.y = -textureBug.velocity;
//            }
//            if(textureBug.rectBugBorder.y <= 0){
//                arrTextureBugs.removeValue(textureBug, true);
//            }
//            if(textureBug.rectBugBorder.y <= screenHeight * screenHeightLevel / screenHeightMax){
//                if(screenHeightLevel == 0){
//                    screenHeightLevel = 8;
//                }
//                else{
//                    screenHeightLevel -= 2;
//                }
//                if(textureBug.rectBugBorder.x <= 10){
//                    textureBug.vector2BugXY.x = textureBug.velocity;
//                    textureBug.vector2BugXY.y = 0;
//                }
//                if(textureBug.rectBugBorder.x + textureBug.textureWidth >= textureBug.screenWidth - 10){
//                    textureBug.vector2BugXY.x = -textureBug.velocity;
//                    textureBug.vector2BugXY.y = 0;
//                }
//            }
//            textureBug.rectBugBorder.x += textureBug.vector2BugXY.x * Gdx.graphics.getDeltaTime();
//            textureBug.rectBugBorder.y += textureBug.vector2BugXY.y * Gdx.graphics.getDeltaTime();
//        }

        // just move down and up
        // change TextureBug.java to start move on y
//        for(int i=0; i < arrTextureBugs.size; i++){
//            if(arrTextureBugs.get(i).rectBugBorder.x <= 0){
//                arrTextureBugs.get(i).vector2BugXY.x = -arrTextureBugs.get(i).vector2BugXY.x;
//            }
//            if(arrTextureBugs.get(i).rectBugBorder.x + arrTextureBugs.get(i).textureWidth >= arrTextureBugs.get(i).screenWidth){
//                arrTextureBugs.get(i).vector2BugXY.x = -arrTextureBugs.get(i).vector2BugXY.x;
//            }
//            if(arrTextureBugs.get(i).rectBugBorder.y <= 0){
//                arrTextureBugs.get(i).vector2BugXY.y = -arrTextureBugs.get(i).vector2BugXY.y;
//            }
//            if(arrTextureBugs.get(i).rectBugBorder.y + arrTextureBugs.get(i).textureHeight >= arrTextureBugs.get(i).screenHeight){
//                arrTextureBugs.get(i).vector2BugXY.y = -arrTextureBugs.get(i).vector2BugXY.y;
//            }
//            arrTextureBugs.get(i).rectBugBorder.x += arrTextureBugs.get(i).vector2BugXY.x * Gdx.graphics.getDeltaTime();
//            arrTextureBugs.get(i).rectBugBorder.y += arrTextureBugs.get(i).vector2BugXY.y * Gdx.graphics.getDeltaTime();
//        }
//        for(TextureBug textureBug : arrTextureBugs){
//            if(textureBug.rectBugBorder.x <= 0){
//                textureBug.vector2BugXY.x = -textureBug.vector2BugXY.x;
//            }
//            if(textureBug.rectBugBorder.x + textureBug.textureWidth >= textureBug.screenWidth){
//                textureBug.vector2BugXY.x = -textureBug.vector2BugXY.x;
//            }
//            if(textureBug.rectBugBorder.y <= 0){
//                textureBug.vector2BugXY.y = -textureBug.vector2BugXY.y;
//            }
//            if(textureBug.rectBugBorder.y + textureBug.textureHeight >= textureBug.screenHeight){
//                textureBug.vector2BugXY.y = -textureBug.vector2BugXY.y;
//            }
//            textureBug.rectBugBorder.x += textureBug.vector2BugXY.x * Gdx.graphics.getDeltaTime();
//            textureBug.rectBugBorder.y += textureBug.vector2BugXY.y * Gdx.graphics.getDeltaTime();
//        }
    }

    /**
     * draw each enemies Sprite
     */
    public void draw(SpriteBatch batch){
        for(TextureBug textureBug : arrTextureBugs){
            textureBug.spriteBug.draw(batch);
        }
    }
}
