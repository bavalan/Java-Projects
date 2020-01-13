//Manager Class(Sub Class)
public class Manager extends Soccer//Gets all the data from Soccer(Parent Class)
{
	//Variables
	int intRage;
	int intNice;
	
	public Manager (String strName, String strTeam) //Gets Manager Name and Team
	{
		super (strName, strTeam);
		
		this.intAge=(int)(Math.random()*35)+45;//Randomizes age from 45-70
		this.intRage=(int)((Math.random()*10)+1);//Randomizes Rage level from 1-10
		this.intNice=(int)(Math.random()*10)+1;//Randomizes Kindness level from 1-10	
		
	}
	
	//Returns values to driver class
	public int getRage()
	{
		return this.intRage;
	}
	
	public int getNice()
	{
		return this.intNice;
	}
}
