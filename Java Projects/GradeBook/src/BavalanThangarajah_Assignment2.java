/*Name:Bavalan Thangarajah
 *Title:MarkBook
 *Purpose:To learn to use arrays and bubble sorting
 */

//Supports to make code work
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



public class BavalanThangarajah_Assignment2 
{
	//Global Variable
	public static String strData[][];
	public static int intMarkCount;
	
	public static void main(String[] args) throws IOException
	{
		//Variable
		String strOption;
		int intProgram=0;
		int intCount=0;
		
		
		while (intCount==0) //Loop for menu
	{
		Menu();//Method for menu
		BufferedReader myInput=new BufferedReader (new InputStreamReader(System.in));
		strOption=myInput.readLine();//Users input for the application they would like to use
		intProgram=Integer.parseInt(strOption); //Converts users input to integer
		
		//Application choices, user presses the number to choose application.
		if(intProgram==1) 
		{
			RandMarks(); 
			
		}
		
		else if (intProgram==2)
		{
			ICSRankMark();
		}
		
		else if (intProgram==3)
		{
			intCount++;
			EOP();
			
		}
		
		else 
		{
			//If user chooses a number other than 1-3 message will appear and menu will reappear
			System.out.println("Please try again, but this time choose numbers 1-3");
			intCount=0;
		}
	}
}
	
	
	public static void Menu() //Menu
	{
		//Program options
		System.out.println("1) Generate Marks");
		System.out.println("2) Mark Book");
		System.out.println("3) Exit");
	}
	

	
	
	public static void RandMarks() throws IOException 
	{
		// Variable Declaration 
		
		intMarkCount = (int)(Math.random()*100)+100; //Generate between 100 and 200 student #'s
		
		
		
		//Prepare the strData 
		strData = new String[intMarkCount][4];
		
		for (int i=0;i<intMarkCount;i++)//Will loop until the amount of student numbers existing
		{
			if(i<9)//If number less than 10
			{
			//Array for student number
			String strTemp="00";//Add two zeros in front	
			strTemp=strTemp.concat(Integer.toString(i+1));		
			strData[i][0]=strTemp;
			}
			
			else if(i<99)//If number less than 10
			{
			//Array for student number
			String strTemp="0";	//Add one zero in front
			strTemp=strTemp.concat(Integer.toString(i+1));		
			strData[i][0]=strTemp;
			}
			
			else
			{
				//Array for student number
				String strTemp;
				strTemp=Integer.toString(i+1);		
				strData[i][0]=strTemp;
			}
		}
		
		for(int i = 0; i < intMarkCount; i++) //Will loop for the amount of student numbers existing
		{
			//35 to 100 
			int intMark = (int)(Math.random()*65)+35; //generate random between 35 and 100 mark 
			
			//Array for marks
			String strTemp=Integer.toString(intMark);
			strData[i][1]=strTemp;
			
		}
		
		BufferedReader BufferNames = new BufferedReader(new FileReader("names.txt")); //Reads names.txt file
		//Variables
		int intN=0;
		String strTemp="";
		
		while(strTemp != null)//Prevents from displaying null
		{
			strTemp=BufferNames.readLine();//Reads every line in a file
			intN++;
		}
		
		intN--;
		BufferNames.close();//Close files
		
		BufferedReader BufferNames2 = new BufferedReader(new FileReader("names.txt")); //Reads names.txt file
		
		String strNames[]=new String [intMarkCount];//Array hold 50 names
		int intCounter=0;
		
		for(int i = 0; i < intN; i++) 
		{
			strNames[intCounter] = BufferNames2.readLine(); //Reads array for name 
			 intCounter++;
		}
		BufferNames2.close(); //close the names file 
		
		int intCounter2=0;
		for(int i=0;i<intMarkCount;i++)//Names will continue to add on until it reaches the 50th name
		{
			strData[i][2]=strNames[intCounter2];//Array holding names
			intCounter2++;//continue to add on
			if (intCounter2==intN)//If 50th name reached
			{
				intCounter2=0;//reset to first name
			}

			
		}
		
		
	
		
		PrintWriter printwriter = new PrintWriter(new FileWriter("marks.txt"));//Creates marks.txt file
		for(int i=0;i<intMarkCount;i++)
		{	
			//Displays Names,Marks and Student #'s in file
			printwriter.println(strData[i][0]+ "," +strData[i][1]+ "," + strData[i][2]);
		}
		printwriter.close();//Close marks.txt file
		
		
		// return to the main menu 
		System.out.println("Random data has been generated, enter anything to return to the main menu...");
	}
	
	
	
	public static int GenerateMark(int intMin, int intMax) 
	{
		//(max - min) will generate the random between min and max,bottom of range becomes min and top becomes max. 
		//Helps with the bubble sorting
		return (int)((Math.random() * (intMax - intMin)) + intMin);
	}

	
	public static void ICSRankMark() 
	{
		//Variable 
		int intMean= 0;
		int	intMedian = 0;
		int intMode = 0; 
		
		
		//Bubble sort the unranked data using the marks column of the 2D array. 
		for(int i = 0; i < strData.length; i++)
			for(int j = 0; j < strData.length - 1; j++)
			{
				//Converts to integers
				int intTemp;
				intTemp=strData[j][1].length();
				intTemp=Integer.parseInt(strData[j][1].substring(0,intTemp));
				
				int intTemp2;
				intTemp2=strData[j][1].length();
				intTemp2=Integer.parseInt(strData[j+1][1].substring(0,intTemp2));
				
				if (intTemp<intTemp2)
				{
					String[] strTemp = strData[j];
					strData[j] = strData[j + 1];
					strData[j + 1] = strTemp;
				}
			}
		
		//Output the strData data in the specified format, RANK, STUDENT #, NAME, GENDER, MARK; from highest to lowest 
		System.out.println("RANK\t\tSTU # \t\tMARK \t\tNAME/GENDER");
		
		for(int i = 0; i < strData.length; i++)//Loops the data
		{  
			String strStudentNumber = strData[i][0];
			String strMark = strData[i][1];
			String strName = strData[i][2];
			
			//Outputs the data
			System.out.println((i + 1) + "\t\t" + strStudentNumber + "\t\t" + strMark +"\t\t" + strName);
		}
		
		
		//Calculate mean 
		for(int i = 0; i < strData.length; i++)
			intMean += Integer.parseInt(strData[i][1]); //add up all grades 
		
		intMean = intMean / strData.length; //divide by amount of grades 
		
		//Calculate median 
		int intMid1 = (strData.length / 2) - 1; //grab middle 2 numbers 
		int intMid2 = (strData.length / 2);
		
		intMedian = (Integer.parseInt(strData[intMid1][1]) + Integer.parseInt(strData[intMid2][1])) / 2; //add them, then divide by 2 
		
		//Mode 
		
		//Variables
		int intCounter = 0;
		int	intNumber = 0;
		int	intLastCount = 0;
		int	intLastNumber = 0;
		
		for(int i = 0; i < strData.length; i++) //loop through all grades and find which number appears the most 
		{ 
			intNumber = Integer.parseInt(strData[i][1]);
			intCounter = 1;
			
			for(int j = 0; j < strData.length; j++) //for each number we run this loop to find out how many times it appears in the array 
			{ 
				if(Integer.parseInt(strData[j][1]) == intNumber)
				intCounter++;
			}
			
			if(intCounter > intLastCount)
			{
				intLastCount = intCounter;
				intLastNumber = intNumber;
			}
		}
		
		intMode = intLastNumber; //the intLastNumber will be the variable holding the highest count of a certain number 
		
		//output measurements 
		System.out.println("\nMean: " + intMean);
		System.out.println("Median: " + intMedian);
		System.out.println("Mode: " + intMode +"\n");
		
	}
	
	
	public static void EOP()throws IOException//Exit
	{
		System.out.println("Thank you!");//Displays message when exiting the program
	}
	
}

