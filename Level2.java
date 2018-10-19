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
 * Level 2 is the level in which Nemo has to avoid running into algae and try to get to the treasure chest
 */
public class Level2 extends JFrame implements KeyListener
{
	
	protected Image background;
	protected Nemo nemo;
	protected boolean[] keys;
	protected TreasureChest chest;
	protected Level2Component comp;
	protected Thread t;
	
	public Level2()
	{
		setSize(800,600);
		setResizable(false);
		setTitle("Level 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keys = new boolean[4];
		try
		{
			URL url = getClass().getResource("fishtank.jpg");
			background = ImageIO.read(url);
			setContentPane(new JPanel(new BorderLayout()) 
			{
        		public void paintComponent(Graphics g) {
            g.drawImage(background, 0, 0, null);
        }
			});
		
		}
		catch(Exception e)
		{
		}
		LinkedList<Algae> alg = new LinkedList<>();
		for(int i =0; i<5; i++){
			alg.add(new Algae(i*120,50,50,5,0,3));
		}
		for(int i =0; i<5; i++){
			alg.add(new Algae(50,i*120,50,5,3,0));
		}
		nemo = new Nemo(0,0, 80,80,5);
		chest = new TreasureChest(350,240, 50,50);
		comp = new Level2Component(nemo, chest, alg, this);
		add(comp);
		addKeyListener(this);
		setVisible(true);
		t = new Thread(comp);
		t.start();
	}
	public void stop()
	{
		setVisible(false);

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
   		
   		 if(keys[0]&&nemo.getY()>0){
   			nemo.move("u");
   		}
   		 if(keys[1]&&nemo.getX()<800){
   			nemo.move("r");
   		}
   		 if(keys[2]&&nemo.getY()<600){
   			nemo.move("d");
   		}
   		 if(keys[3]&&nemo.getX()>0){
   			nemo.move("l");
   		}
   	   
   	   //alg.repaint();
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
	public static void main (String[] args) {
		new Level2();
	}
}