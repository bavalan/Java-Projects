/*Name:Bavalan Thangarajah
 *Title:SquareVille
 *Date:May/28/2015 
 *Purpose: To Create a Game demonstrating all the skills we learned from this course 
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Game //The driver class of the frame where GUI is created
{

	//Variables
	static Move n=new Move();//Brings Move class here (panel)

	public static void main(String[] args) throws IOException 
	{
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()//Displays the GUI
			{
				runGUI();
			}
		});
	}
	
	
	public static void runGUI()//Runs the GUI
	{
		//Create the Main Frame 
		JFrame Frame = new JFrame();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Allows the program to close
		Frame.setTitle("SQUAREVILLE");//Title of the frame
		

		
		Frame.add(n);//Adds panel to frame
		Frame.setVisible(true);//Visible
		Frame.setSize(485, 520);//Frame size
		
	
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

}


