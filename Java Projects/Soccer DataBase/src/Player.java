//Player (Sub Class)
public class Player extends Soccer//Gets all the data from Soccer(Parent Class)
{
	//New Variables used in Player Class
	double dblGoals;
	int intStamina;
	double dblAverage;
	double dblRoundAvg;
	double dblRoundGoal;

	//Gets Player Name and Team
	public Player (String strName, String strTeam) 
	{
		super (strName, strTeam);
		
		//Randomizes age from 17-40
		this.intAge=(int)(Math.random()*23)+17;
		
		if (intAge<=28) //If the age is below 28
		{
			intStamina=(int)((Math.random()*4)+6);//Randomizes Stamina level between 6-10
		}
		
		else
		{
			intStamina=(int)(Math.random()*5)+1;//Randomizes Stamina level between 1-5
		}
		
		//Goals
		dblGoals=(double)((Math.random()*250)+1);//Randomizes goals from 1-250
		dblRoundGoal=Math.round(dblGoals*1)/1.0;//Rounds value of goals to  ZERO decimal places
		
		//Calculations to determine the average goals scored per game
		dblAverage=dblGoals/dblPlayed;//Number of goals divided by the number of matches played
		dblRoundAvg=Math.round(dblAverage*100)/100.0;////Rounds value of average goals per game to TWO decimal places 
				
	}
	
	//Returns values to driver class
	public int getStamina()
	{
		return this.intStamina;
	}
	
	public double getGoals()
	{
		return this.dblRoundGoal;
	}
	
	public double getAverage()
	{
		return this.dblRoundAvg;
	}
	
}
