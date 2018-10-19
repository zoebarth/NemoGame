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
 * Launches the finding nemo game
 */
public class OceanLauncher
{
	public static void main (String[] args) 
	{
		OceanFrame frame = new OceanFrame();
	}
	
}

/**
 * Creates the frame to launch the game
 */
class OceanFrame extends JFrame implements MouseListener
{
	private JPanel menuPanel;
	private Image background;
	private JLabel startLabel;
	private JLabel helpLabel;
	private JLabel loadLabel;
	private JLabel nemoLabel;
	boolean clicked = false;
	
	/**
	 * Creates an OceanFrame with different menu options
	 */
	public OceanFrame()
	{
		setSize(900,600);
		setResizable(false);
		setTitle("Finding Nemo");
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
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(0,1));
		nemoLabel = new JLabel("FINDING NEMO", SwingConstants.CENTER);
		startLabel = new JLabel("Start", SwingConstants.CENTER);
		loadLabel = new JLabel("Load Level", SwingConstants.CENTER);
		helpLabel = new JLabel("Help", SwingConstants.CENTER);
		menuPanel.add(new JLabel());
		menuPanel.add(nemoLabel);
		menuPanel.add(startLabel);
		menuPanel.add(loadLabel);
		menuPanel.add(helpLabel);
		menuPanel.add(new JLabel());
		startLabel.addMouseListener(this);
		helpLabel.addMouseListener(this);
		loadLabel.addMouseListener(this);

		nemoLabel.setForeground(Color.blue);
		helpLabel.setForeground(Color.black);
		startLabel.setForeground(Color.black);
		loadLabel.setForeground(Color.black);
		
		nemoLabel.setFont(new Font("Arial",Font.BOLD,75));
		startLabel.setFont(new Font("Arial",Font.BOLD,45));
		loadLabel.setFont(new Font("Arial",Font.BOLD,45));
		helpLabel.setFont(new Font("Arial",Font.BOLD,45));
	
		add(menuPanel);
		menuPanel.setOpaque(false);
	
		setVisible(true);
	}
	
	/**
	 * Closes the window
	 */
	public void close()
	{
		setVisible(false);
	}
	
	
		/**
		 * required by the MouseListener interface.  Invoked when the mouse is clicked.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseClicked(MouseEvent e)
		{
		}
		/**
		 * required by the MouseListener interface.  Invoked when the mouse is released.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseReleased(MouseEvent e)
		{
		}
		/**
		 * required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
		 * the mouse pointer enters a particular gui element.  In this implementation, if the mouse
		 * pointer enters one of the menu labels, the label is set to blue.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseEntered(MouseEvent e)
		{
			JLabel label = (JLabel) e.getSource();
			label.setForeground(Color.RED);
		}
		/**
		 * required by the MouseListener interface.  Invoked when no mouse buttons are clicked and 
		 * the mouse pointer leaves a particular gui element. 
		 * @param e the MouseEvent that triggered the method
		 */
		public void mouseExited(MouseEvent e)
		{
			JLabel label = (JLabel) e.getSource();
			label.setForeground(Color.black);
		}
		/**
		 * required by the MouseListener interface.  Invoked when the left mouse button is pressed.
		 * @param e the MouseEvent that triggered the method
		 */
		public void mousePressed(MouseEvent e) 
		{
			JLabel label = (JLabel) e.getSource();
			if(!clicked)
			{
				if(label.equals(startLabel))
				{
					close();
					StartingAnimation s = new StartingAnimation();
				}
				else if (label.equals(helpLabel))
				{
					HelpMenu h = new HelpMenu();
				}
				else if(label.equals(loadLabel))
				{
					nemoLabel.setText("Load Level");
					startLabel.setText("Level 1");
					loadLabel.setText("Level 2");
					helpLabel.setText("Level 3");
					clicked = true;
				}
			}
			else
			{
				if(label.equals(startLabel))
				{
					close();
					StartingAnimation s = new StartingAnimation();
				}
				else if (label.equals(helpLabel))
				{
					close();
					Level3Launcher l = new Level3Launcher();
				}
				else if(label.equals(loadLabel))
				{
					close();
					Level2Launcher l = new Level2Launcher();
				}
			}
		}
}