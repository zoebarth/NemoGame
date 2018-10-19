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
 *StartingAnimation3 is at the beginning of the game when Nemo's dad is talking to Nemo about the first day of school.
 */
public class StartingAnimation3 extends JFrame implements KeyListener
{
	
	private Image background;
	
	/**
	 *Creates the starting animation with a background and a MarvinAnimation
	 */
	public StartingAnimation3()
	{
		setSize(800,600);
		setResizable(false);
		setTitle("Level 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			URL url = getClass().getResource("schoolan.jpg");
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
		MarlinAnimation a = new MarlinAnimation(100,200);
		add(a);
		addKeyListener(this);
		setVisible(true);
	}
	
	/**
	 *Closes the window so that part 2 of level1 can start
	 */
	public void close()
	{
		setVisible(false);
	}
	
	 /**
    *Invoked when a key has been pressed.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void keyPressed(KeyEvent e)
   {
   		if(e.getKeyCode() == KeyEvent.VK_ENTER)
   		{
	   		close();
	   		Level1Part2 l1p2 = new Level1Part2();
   		}
   }

   /**
    *Invoked when a key has been released.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void	keyReleased(KeyEvent e)
   {
   }
   
   /**
    *Invoked when a key has been typed.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void keyTyped(KeyEvent e)
   {
   }

}


