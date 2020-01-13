//Driver class outputs info 
import java.io.*;
public class Driver
{
	
	

	public static void main(String[] args) throws IOException
	{
		//Variables
		String strNameP;
		String strTeamP;
		
		String strNameM;
		String strTeamM;
		
		String strNameG;
		String strTeamG;
		
		//Reads the soccer players name and team
		System.out.println("Please enter the Soccer Player's Name and Team.");
		BufferedReader myInput=new BufferedReader (new InputStreamReader(System.in));
		strNameP=myInput.readLine();
		
		BufferedReader Input=new BufferedReader (new InputStreamReader(System.in));
		strTeamP=Input.readLine();
		
		//Reads the Goalies name and team
		System.out.println("Please enter the Goalie's Name and Team.");
		BufferedReader myInputG=new BufferedReader (new InputStreamReader(System.in));
		strNameG=myInputG.readLine();
		
		BufferedReader InputG=new BufferedReader (new InputStreamReader(System.in));
		strTeamG=InputG.readLine();
		
		//Reads the Mangers name and team
		System.out.println("Please enter the Manger's Name and Team.");
		BufferedReader myInputM=new BufferedReader (new InputStreamReader(System.in));
		strNameM=myInputM.readLine();
		
		BufferedReader InputM=new BufferedReader (new InputStreamReader(System.in));
		strTeamM=InputM.readLine();
	

		
		//Outputs Player Class

		
		System.out.println("Soccer Player:");
		Player play=new Player(strNameP, strTeamP);
		System.out.println(play + "Stamina:" + play.getStamina()+ " \nGoals Scored:" + play.getGoals() + "\nAvergae Goals per Game:" + play.getAverage());

		//Outputs Goalie Class
		System.out.println("\n\nGoalie:");
		Goalie Goal=new Goalie(strNameG, strTeamG);
		System.out.println(Goal + "Reflex:" + Goal.getReflex()+ "\nSaves Made:" + Goal.getSaves()+ "\nAvergae Saves per Game:" + Goal.getSavAverage() + "\nGoals Scored:" + Goal.getGoals()+ "\nAvergae Goals per Game:" + Goal.getAverage());
			
		//Outputs Manager Class
		System.out.println("\n\nManager:");
		Manager manage=new Manager(strNameM, strTeamM);
		System.out.println(manage + "Short Temper(Rage):" + manage.getRage()+ "\nNice:" + manage.getNice());
		
	}

}
