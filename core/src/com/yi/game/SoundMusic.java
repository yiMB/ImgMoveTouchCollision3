package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * this class create and setup Sound and Music for all audio.<br>
 * use this class object to play and dispose audio.<br>
 * after this class object created background music will play forever.
 */
public class SoundMusic {
    Sound soundPlayerShot;
    Sound soundBossShot;
    Sound soundExplosion;
    Sound soundPlayerHit;
    Sound soundBossHit;
    Music musicBackground;

    public SoundMusic(){
        soundPlayerShot = Gdx.audio.newSound(Gdx.files.internal("sound_player_weapon_shot.wav"));
        soundBossShot = Gdx.audio.newSound(Gdx.files.internal("sound_boss_weapon_shot.wav"));
        soundExplosion = Gdx.audio.newSound(Gdx.files.internal("sound_explosion.wav"));
        soundPlayerHit = Gdx.audio.newSound(Gdx.files.internal("sound_player_hit.wav"));
        soundBossHit = Gdx.audio.newSound(Gdx.files.internal("sound_boss_hit.wav"));

        musicBackground = Gdx.audio.newMusic(Gdx.files.internal("music_sad_toys_factory.mp3"));

        playAndLoopBackgroundMusic();
    }

    /**
     * call this method in main's dispose to dispose all audio
     */
    public void disposeAllAudios(){
        soundPlayerShot.dispose();
        soundBossShot.dispose();
        soundExplosion.dispose();
        soundPlayerHit.dispose();
        soundBossHit.dispose();
        musicBackground.dispose();
    }

    /**
     * play player fire a shot sound
     */
    public void playSoundPlayerShot(){
        soundPlayerShot.play();
    }

    /**
     * play boss fire a shot sound
     */
    public void playSoundBossShot(){
        soundBossShot.play();
    }

    /**
     * play explosion sound
     */
    public void playSoundExplosion(){
        soundExplosion.play();
    }

    /**
     * play player got hit sound
     */
    public void playSoundPlayerHit(){
        soundPlayerHit.play();
    }

    /**
     * play boss got hit sound
     */
    public void playSoundBossHit(){
        soundBossHit.play();
    }

    /**
     * background music will play forever, I did not implement stop
     */
    public void playAndLoopBackgroundMusic(){
        musicBackground.setVolume(0.8f);
        musicBackground.setLooping(true);
        musicBackground.play();
    }
}
