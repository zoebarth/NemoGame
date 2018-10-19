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
 * Provides the user with instructions on the game
 */
public class HelpMenu extends JFrame
{
	private JTextArea display;
	
	/**
	 * Launches the HelpMenu to provide the user with instructions
	 */
	public HelpMenu()
	{
		setSize(670, 425);
      	setTitle("Help");
      	setResizable(false);
      	display = new JTextArea();
 	  	display.setFont(new Font("Courier",Font.BOLD,20));
 	  	display.setBackground(Color.cyan);
 	  	display.setEditable(false);
      	JScrollPane scroller = new JScrollPane(display);
      	display.setText("HELP: \n\nLevel 1:\nPress Enter when prompted and use the arrow keys to\nguide Nemo toward the big blue arrows.\n\nLevel 2:\nUse the arrow keys"
      		+ " to help Nemo avoid the algae and get\nto the treasure chest. \n\nLevel 3: Click (but do not hold) the space bar to shoot\nbubbles out of Nemo's gills to attack the Jellyfish.");
      	add(display);
      	setVisible(true);
	}
}