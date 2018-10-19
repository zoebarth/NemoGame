import java.awt.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Level2Part2 extends Level2
{
	
	public Level2Part2()
	{
		super();
		setTitle("part 2");
		LinkedList<Algae> alg = new LinkedList<>();
		for(int i =0; i<5; i++){
			alg.add(new Algae(i*100,50,50,5));
		}
		for(int i =0; i<5; i++){
			alg.add(new Algae(50,i*100,50,5));
		}
		
		comp = new Level2Component(nemo, chest, alg, this);
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
   		 if(keys[1]&&nemo.getX()<355){
   			nemo.move("r");
   		}
   		 if(keys[2]&&nemo.getY()<250){
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
   
   public void close()
	{
		setVisible(false);
	}

}