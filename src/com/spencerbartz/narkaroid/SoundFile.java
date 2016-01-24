package com.spencerbartz.narkaroid;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SoundFile implements Runnable 
{
	Player player = null;
	Thread playerThread;
	AtomicBoolean pause = new AtomicBoolean(false);
	boolean started = false;
	
	public SoundFile(Player p)
	{
		player = p;
	}
	
	public void playSound()
	{
		if(player != null)
		{
			playerThread = new Thread(this);
			playerThread.start();
		}
	}
	
	public void stopSound()
	{
		if(!pause.get()) 
		{
			pause.set(true);
		}
	}
	
	public void run() 
	{
		if(!started)
		{
			started = true; 
			try 
			{
				while(player.play(1)) 
				{
					if(pause.get()) 
					{
						LockSupport.park();
						System.out.println("PAUSED");
						break;
					}
				}
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}