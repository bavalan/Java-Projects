//Manager Class(Sub Class)
public class Goalie extends Player//Gets all the data from Player(Sub Class),which gets its data from Soccer(Parent Class)
{
	//Variables
	double dblSaves;
	double dblRoundSaves;
	int intReflexes;
	double dblRoundSavAvg;
	
	public Goalie (String strName, String strTeam) 
	{
		super (strName, strTeam);
		
		this.intAge=(int)(Math.random()*28)+17;//Randomizes goalie's age from 17-45
		this.intReflexes=(int)(Math.random()*10)+1;//Randomizes goalie's reflexes from 1-10
		
	
		if (intAge<=25) //If the age is less than 25
		{
			intStamina=(int)((Math.random()*4)+6);//Randomizes Stamina level between 6-10
		}
		
		else
		{
			intStamina=(int)(Math.random()*5)+1;//Randomizes Stamina level between 1-5
		}
		
		//Goals
		dblGoals=(double)((Math.random()*20)+1);//Number goals a goalie can score 1-20
		dblRoundGoal=Math.round(dblGoals*1)/1.0;//Rounds value of goals to ZERO decimal places
		
		//Calculations to determine the average goals scored per game
		dblAverage=dblGoals/dblPlayed;//Number of goals divided by the number of matches played
		dblRoundAvg=Math.round(dblAverage*100)/100.0;////Rounds value of average goals per game to TWO decimal places 
								
		//Saves
		dblSaves=(double)((Math.random()*1000)+5000);//Number saves a goalie can make 5000-6000
		dblRoundSaves=Math.round(dblSaves*1)/1.0;//Rounds value of goals to ZERO decimal places
		
		//Calculations for average saves
		dblAverage=dblSaves/dblPlayed;
		dblRoundSavAvg=Math.round(dblAverage*100)/100.0;//Rounds value of average saves per game to TWO decimal places	
		
	}
	//Getters
	public int getStamina()
	{
		return this.intStamina;
	}
	
	public double getSaves()
	{
		return this.dblRoundSaves;
	}
	
	public double getGoals()
	{
		return this.dblRoundGoal;
	}
	
	public int getReflex()
	{
		return this.intReflexes;
	}
	
	
	public double getAverage()
	{
		return this.dblRoundAvg;
	}
	
	public double getSavAverage()
	{
		return this.dblRoundSavAvg;
	}
	
	

}
