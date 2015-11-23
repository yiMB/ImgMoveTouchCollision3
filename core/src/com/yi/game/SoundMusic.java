package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

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

        // background music will play forever, I did not implement stop
        musicBackground = Gdx.audio.newMusic(Gdx.files.internal("music_sad_toys_factory.mp3"));
        musicBackground.setVolume(0.8f);
        musicBackground.setLooping(true);
        musicBackground.play();
    }

    // call this method in main's dispose to dispose all audio
    public void disposeAllAudios(){
        soundPlayerShot.dispose();
        soundBossShot.dispose();
        soundExplosion.dispose();
        soundPlayerHit.dispose();
        soundBossHit.dispose();
        musicBackground.dispose();
    }

    public void playSoundPlayerShot(){
        soundPlayerShot.play();
    }

    public void playSoundBossShot(){
        soundBossShot.play();
    }

    public void playSoundExplosion(){
        soundExplosion.play();
    }

    public void playSoundPlayerHit(){
        soundPlayerHit.play();
    }

    public void playSoundBossHit(){
        soundBossHit.play();
    }
}
