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
 * Level1Part3 is the third part of the tutorial level in which Nemo learns how to swim toward a blue arrow
 */
public class Level1Part3 extends JFrame implements KeyListener
{
	
	private Image background;
	private NemoComponent comp;
	private boolean[] keys;

	/**
	 * Creates Level1Part3
	 */
	public Level1Part3()
	{
		setSize(800,600);
		setResizable(false);
		setTitle("Level 1");
		keys = new boolean[4];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			URL url = getClass().getResource("oceanwithboat.jpg");
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
		comp = new NemoComponent(50,200);
		add(comp);
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
   		if(comp.getNemo().getX()> 370 && comp.getNemo().getX()< 420 && comp.getNemo().getY() <40 )
   		{
   				close();
   				StartingAnimation5 an = new StartingAnimation5();
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

   	   comp.repaint();
   		
//   		if(comp.getY()< 40 && comp.getX()> 200 && comp.getX() < 300) 
//   		{
//   			close();
//   			StartingAnimation5 an = new StartingAnimation5();
//   		}
//   		if(keys[0] && comp.getY()>0)
//   		{
//   	 		comp.move("u");
//   		}
//   		if(keys[1]&& comp.getX()<355)
//   		{
// 			comp.move("r");
//   		}
//   	    if(keys[2]&& comp.getY()<245){
//   			comp.move("d");
//   		}
//   		if(keys[3]&& comp.getX()>0){
//   			comp.move("l");
//   		}
//   	   comp.repaint();
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
