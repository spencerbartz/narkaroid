package com.spencerbartz.narkaroid;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream; 
import java.util.Vector;

/******************************************************
 * Class SoundManager
 * @author pavlvsmaximvs
 * Handles music and sound effects for the game
 * Sound effects are stored in a vector.  I may choose to add more sound 
 * effects later on so the public static method int indexing of an array
 * didn't sound like a good idea.  On the other hand background music 
 * will (for now) contain a set number of tracks.  The intro to the game,
 * a different track for each level, game over music, and the outro for the game
 * are stored as "extramusic" for now
 */

public class SoundManager
{
	//sound effects stored in a Vector (adding new sounds will be no issue)	
	//background music will always be the number of levels plus 3 (intro, outro, game_over)
	private Vector<Player> soundEffects;
	private Player bgMusic[];
	private Player extraMusic[];
	int extraMusicCount = 3;
	
	public static final int INTRO_MUSIC = 0;
	public static final int GAME_OVER_MUSIC = 1;
	public static final int END_MUSIC = 2;
	
	public final static SoundManager INSTANCE = new SoundManager();
	private SoundManager() 
	{
	         // Exists only to defeat instantiation.
	}
	
	public void loadSounds()
	{
		soundEffects = new Vector<Player>();
		bgMusic = new Player[LevelManager.NUM_LEVELS];
		extraMusic = new Player[extraMusicCount];
		
		
		if(soundEffectFolder.isDirectory())
		{
			int fileCount = soundEffectFolder.list().length;
			
			for(int i = 0; i < fileCount; i++)
			{
				addSoundEffect(soundEffectFolder.list()[i], i);
			}
		}
		
		try
        {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL url = classLoader.getResource("game_over.mp3");
			
			AdvancedPlayer player = new AdvancedPlayer(SoundManager.class.getClassLoader().getResourceAsStream("game_over.mp3"));
			
            player.play();
        }
        catch(Exception e)
        {
            System.out.println("Error while playing audio "+e.getMessage());
        }
			
		/*
			
		if(bgMusicFolder.isDirectory())
		{
			int fileCount = bgMusicFolder.list().length;
	
			for(int i = 0; i < fileCount; i++)
			{
				String filePath = bgMusicFolder.list()[i];
				if(i < bgMusic.length)
					addBackgroundMusic(bgMusicFolder.getPath() + bgMusicFolder.separator + bgMusicFolder.list()[i], i);
			}
		}
		
		
		if(extraMusicFolder.isDirectory())
		{
			int fileCount = extraMusicFolder.list().length;
	
			for(int i = 0; i < fileCount; i++)
			{
				if(i < extraMusic.length)
					addExtraMusic(bgMusicFolder.list()[i], i);
			}
		}
		*/
	}
	
	
	
	public void addBackgroundMusic(String fname, int index)
	{	
		
	}
	
	public void addExtraMusic(String fname, int index)
	{	
		
	}
	
	public void startLevelBGM(int levelIndex)
	{
		try
		{
		//	bgMusic[levelIndex].start();
		}
		catch(Exception e)
		{
			System.err.println("Could not find files");
			e.printStackTrace();
		}
	}
	
	public void stopLevelBGM(int levelIndex)
	{
		//bgMusic[levelIndex].stop();
		//bgMusic[levelIndex].setMediaTime(new Time(0));
	}
}