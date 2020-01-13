/*Name:Bavalan Thangarajah
 *Title:SquareVille
 *Date:May/28/2015 
 *Purpose: To Create a Game demonstrating all the skills we learned from this course 
 */
import java.awt.event.ActionEvent;

public class TimeClass extends Move//Time Class used to activate timer
{

		int intCounter;
		
		public TimeClass(int intCounter)
		{
			this.intCounter=intCounter;
		}
		
		public void actionPerformed(ActionEvent tc)//Timer function
		{
			//If it is called start the timer and return it
			time.start();
			return;
			
		}
		
	
}
