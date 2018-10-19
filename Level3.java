/* 
 * Zoe Barth and Gretchen Picklesimer
 * Gallatin - 1st period
 * CS III Honors
 * 5/23/2018
 */

import java.awt.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * Level3 is the level in which Nemo has to shoot all the Jellyfish
 */
public class Level3 extends JFrame implements KeyListener
{
	
	private Image background;
	private NemoComponent comp;
	private NemoBubbleComponent bubbs;
	private boolean[] keys;

	/**
	 * Creates Level3
	 */
	public Level3()
	{
		setSize(800,600);
		setResizable(false);
		setTitle("Level 3");
		keys = new boolean[5];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			URL url = getClass().getResource("good.jpg");
			background = ImageIO.read(url);
			setContentPane(new JPanel(new BorderLayout()) 
			{
        		@Override public void paintComponent(Graphics g) {
            g.drawImage(background, 0, 0, null);
        }
			});
		
		}
		catch(Exception e)
		{
		}
		comp = new NemoComponent(100,100);
		bubbs = new NemoBubbleComponent(comp);
		Thread t1= new Thread(bubbs);
		t1.start();
		add(comp);
		add(bubbs);
		addKeyListener(this);
		setVisible(true);
	}
	
	/**
    *Invoked when a key has been pressed.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void keyPressed(KeyEvent e)
   {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
   		{
   			keys[1]=true;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_UP)
   		{
   			keys[0]=true;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
   		{
			keys[3]=true;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
   		{
			keys[2]=true;
   		}
		if(bubbs.isEmpty())
		{
			close();
			Winningscreen m = new Winningscreen();
		}
		if(bubbs.youLose())
		{
			close();
			Level3Launcher l = new Level3Launcher();
		}
		if(keys[0] && comp.getNemo().getY()>0){
   			comp.move("u");
   		}
   		if(keys[1]&& comp.getNemo().getX()<710){

   				comp.move("r");
   			}
   	 if(keys[2]&& comp.getNemo().getY()<490){
   			comp.move("d");
   		}
   		if(keys[3]&& comp.getNemo().getX()>0){
   			comp.move("l");
   		}
   		
   		if(!keys[4] && e.getKeyCode() == KeyEvent.VK_SPACE)
   		{
   				bubbs.add(new Bubble(comp.getNemo().getX()+75,comp.getNemo().getY()+55,10,20));
   				keys[4] = true;
   		}

   	   comp.repaint();
   }

   /**
    *Invoked when a key has been released.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void	keyReleased(KeyEvent e)
   {
   	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
   		{
   				keys[1]=false;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_UP)
   		{
   			keys[0]=false;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
   		{
			keys[3]=false;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
   		{
			keys[2]=false;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_SPACE)
   		{
   			keys[4] = false;
   		}
   }
   
   /**
    *Invoked when a key has been typed.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void keyTyped(KeyEvent e)
   {
   }
   
   /**
    * Closes the window
    */
   public void close()
	{
		setVisible(false);
	}

}

