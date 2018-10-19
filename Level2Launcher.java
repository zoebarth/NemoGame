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
 * Launches level 2 for after you finish level 1 or die on level 2
 */
public class Level2Launcher extends JFrame implements MouseListener
{
	private JPanel menuPanel;
	private Image background;
	private JLabel levelLabel;
	private JLabel continueLabel;
	private JLabel saveandquitLabel;
	private JLabel helpLabel;
	
	/**
	 *Creates a JFrame to start level2
	 */
    public Level2Launcher() 
    {
    	setSize(900,600);
		setResizable(false);
		setTitle("Level 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			URL url = getClass().getResource("blue.jpg");
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
		levelLabel = new JLabel("LEVEL 2", SwingConstants.CENTER);
		continueLabel = new JLabel("Continue", SwingConstants.CENTER);
		helpLabel = new JLabel("Help", SwingConstants.CENTER);
		saveandquitLabel = new JLabel("Main Menu", SwingConstants.CENTER);
		menuPanel.add(new JLabel());
		menuPanel.add(levelLabel);
		menuPanel.add(continueLabel);
		menuPanel.add(saveandquitLabel);
		menuPanel.add(helpLabel);
		menuPanel.add(new JLabel());
		saveandquitLabel.addMouseListener(this);
		continueLabel.addMouseListener(this);
		helpLabel.addMouseListener(this);

		levelLabel.setForeground(Color.blue);
		saveandquitLabel.setForeground(Color.black);
		continueLabel.setForeground(Color.black);
		helpLabel.setForeground(Color.black);
		
		levelLabel.setFont(new Font("Arial",Font.BOLD,75));
		saveandquitLabel.setFont(new Font("Arial",Font.BOLD,45));
		continueLabel.setFont(new Font("Arial",Font.BOLD,45));
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
			if (label.equals(saveandquitLabel))
			{
				OceanFrame l = new OceanFrame();
				close();
			}
			else if (label.equals(continueLabel))
			{
				
				Level2 l = new Level2();
				close();	
			}
			else if(label.equals(helpLabel))
			{
				HelpMenu h = new HelpMenu();
			}
		}
    
    
}