import java.awt.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Level2Part3 extends JFrame implements KeyListener
{
	
	private Image background;
	private NemoComponent nemo;
	private boolean[] keys;
	private AlgaeComponent alg;
	private AlgaeComponent alg2;
	private ArrayList<AlgaeComponent> algae;
	private TreasureChestComponent chest;
	public Level2Part3()
	{
		setSize(800,600);
		setResizable(false);
		setTitle("Level 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keys = new boolean[4];
		algae = new ArrayList<AlgaeComponent>();
		try
		{
			URL url = getClass().getResource("fishtank.jpg");
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
		nemo = new NemoComponent(new Nemo(0,0, 80,80,5));
		chest = new TreasureChestComponent(350,240, 50,50);
		add(chest);
		for(int i =0; i<10; i++){
			algae.add(new AlgaeComponent(new Algae((i+2)*25,50,50,5), nemo.getNemo(), 0,i+1));
			add(algae.get(i));
			Thread t = new Thread(algae.get(i));
			t.start();
		}
		for(int i =0; i<10; i++){
			algae.add(new AlgaeComponent(new Algae(50,(i+2)*25,50,5), nemo.getNemo(), i+1,0));
			add(algae.get(i+5));
			Thread t = new Thread(algae.get(i +5));
			t.start();
		}
		
		//alg2 = new AlgaeComponent(new Algae(100,100,50,5), nemo.getNemo(), 3,0);
//		alg = new AlgaeComponent(new Algae(200,200,50,5), nemo.getNemo(), 3,0);
		//add(alg2);
//		add(alg);
//		Thread t1 = new Thread(alg);
//		t1.start();
		add(nemo);
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
   		System.out.println(nemo.getX() + " " + nemo.getY());
   	   nemo.repaint();
   	   if(nemo.getBounds().intersects(chest.getBounds())){
   	   	System.out.println("You won!");
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