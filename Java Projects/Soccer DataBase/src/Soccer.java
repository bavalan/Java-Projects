/*Name:Bavalan Thangarajah
 *Title: Soccer Data Base
 *Purpose:To learn on how to use object oriented programming
 */

//Parent Class
public class Soccer 
{
	//Variables for characters
		String strName;
		String strTeam;
		double dblDraw;
		double dblWin;
		double dblLoss;
		double dblPlayed;
		int intAge;
		double dblWinPercent;
		double dblRoundWin;
	
		
		
		
		
		//constructors - creates objects
		public Soccer(String SoccerName, String SoccerTeam, int SoccerDraw , int SoccerWin, int SoccerLoss,int SoccerAge)
		{
			this.strName=SoccerName; 
			this.strTeam=SoccerTeam;
			this.dblDraw=SoccerDraw;
			this.dblWin=SoccerWin;
			this.dblLoss=SoccerLoss;
			this.intAge=SoccerAge;					
		}
		
		//alternate constructor
		public Soccer(String SoccerName, String SoccerTeam)
		{
			this.strName=SoccerName;
			this.strTeam=SoccerTeam;
			this.dblWin=(int)(Math.random()*500)+1;
			this.dblLoss=(int)(Math.random()*500)+1;
			this.dblDraw=(int)(Math.random()*500)+1;
			
			//Calculation to get the total number of games played
			dblPlayed=  dblWin+dblLoss+dblDraw;//Adds up the number of Wins,Loss and Draws to get total
			
			//Calculation to get the Win percentage
			dblWinPercent=(dblWin/dblPlayed);//Total Wins divided by the number of games played		
			
			//Rounds the Win Percentage to TWO decimal places
			dblRoundWin=Math.round(dblWinPercent*100)/100.0;//Shortens decimals			
		}

		//Methods to access characteristics
		//Setters
		public void setDraw(int intFactor)
		{
			this.dblDraw=intFactor;		
		}
		
		public void setWin(int intFactor)
		{
			this.dblWin=intFactor;
		}
		
		public void setLoss(int intFactor)
		{
			this.dblLoss=intFactor;
		}
		
		public void setPlayed(int intFactor)
		{
			this.dblPlayed=intFactor;
		}
		
		public void setPercent(int intFactor)
		{
			this.dblRoundWin=intFactor;
		}
		
		public void setAge(int intFactor)
		{
			this.intAge=intFactor;
		}
		
		//Getters and returns value to driver class
		public String getName()
		{
			return this.strName;
		}
		
		public String getTeam()
		{
			return this.strTeam;
		}		
		
		//Method that converts value to be string
		public String toString()
		{
			//Variable that hold all data
			String strSoccerData;
			
			//Displays/Uses all these information in each sub class
			strSoccerData="Name: "+this.strName+"\nTeam:"+this.strTeam+"\n"; //Name & Team
			strSoccerData=strSoccerData+"Age: "+this.intAge+"\n";//Age
			strSoccerData=strSoccerData+"Games Played/Managed: "+this.dblPlayed+"\n";//Games played/managed
			strSoccerData=strSoccerData+"Games Won: "+this.dblWin+"\n";//Games Won
			strSoccerData=strSoccerData+"Games Lost: "+this.dblLoss+"\n";//Games Lost
			strSoccerData=strSoccerData+"Games Drawn: "+this.dblDraw+"\n";//Games Drawn
			strSoccerData=strSoccerData+"Win Percentage: "+this.dblRoundWin+"\n"; //Win percentage
			return strSoccerData;//Returns value to driver class
		}
}





