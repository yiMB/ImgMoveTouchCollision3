package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * this class create and setup BitmapFont for all font.<br>
 * use this class object to draw text to screen.
 */
public class FontText {
    BitmapFont bitmapFontScore;

    public FontText(){
        bitmapFontScore = new BitmapFont(Gdx.files.internal("mylittlepony.fnt"));
//        bitmapFontScore.setColor(Color.GREEN);
    }

    /**
     * dispose BitmapFont
     */
    public void disposeBitmapFont(){
        bitmapFontScore.dispose();
    }

    /**
     * draw text to x y location
     */
    public void draw(SpriteBatch batch, String text, int x, int y){
        bitmapFontScore.draw(batch, text, x, y);
    }
}
