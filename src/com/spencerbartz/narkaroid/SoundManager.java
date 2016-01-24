package com.spencerbartz.narkaroid;

import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/******************************************************
 * Class SoundManager
 * @author pavlvsmaximvs
 * Handles music and sound effects for the game
 */

public class SoundManager
{
	String soundEffects[] = {};
	ArrayList<SoundFile> bgmList = new ArrayList<SoundFile>();
	
	public final static SoundManager INSTANCE = new SoundManager();
	private SoundManager() 
	{
		// Exists only to defeat instantiation.
	}
	
	public void loadSounds()
	{	
		for(int i = 0; i < LevelManager.NUM_LEVELS; i++)
		{
			try 
			{
				InputStream is = SoundManager.class.getClassLoader().getResourceAsStream("level" + i + ".mp3");
				BufferedInputStream bis = new BufferedInputStream(is);
				Player player = new Player(bis);
				SoundFile file = new SoundFile(player);
				bgmList.add(file);
			} 
			catch(JavaLayerException e) 
			{
				e.printStackTrace();
			}
		}	
	}
				
	public void startLevelBGM(int levelIndex)
	{
		bgmList.get(levelIndex).playSound();
	}
	
	public void stopLevelBGM(int levelIndex)
	{
		bgmList.get(levelIndex).stopSound();
	}
}