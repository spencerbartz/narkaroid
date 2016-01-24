package com.spencerbartz.narkaroid;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class NarkaroidFrame extends JFrame implements MouseListener, KeyListener
{
	private static final long serialVersionUID = 7898517091639100829L;
	static final int FRAME_WIDTH = 700;
	static final int FRAME_HEIGHT = 600;
	
	private GameManager gameManager;
	private SoundManager soundManager;
	private RenderingPanel rPanel;
	
	public NarkaroidFrame()
	{
		setTitle("Narkaroid");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameManager = new GameManager();
		soundManager = SoundManager.INSTANCE;
		//soundManager.loadSounds();
		
		rPanel = new RenderingPanel(gameManager);
		Container contentPane = getContentPane();
		contentPane.add(rPanel, BorderLayout.CENTER);
		rPanel.start();
		
		rPanel.setPreferredSize(new Dimension(rPanel.getWidth(), rPanel.getHeight()));
	
		setResizable(false);
		pack();
		
		addKeyListener(rPanel);
		rPanel.addMouseListener(this);
		addKeyListener(gameManager.getPaddle());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//rPanel.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//rPanel.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//rPanel.keyTyped(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		rPanel.mouseClicked(e);
		//System.out.println("MouseX: " + e.getX() + " MouseY: " + e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		rPanel.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		rPanel.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		rPanel.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		rPanel.mouseReleased(e);
	}
}
