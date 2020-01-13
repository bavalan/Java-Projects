//Name:Bavalan Thangarajah 
//Title: Assignment 1 Review


import java.io.*; //Helps the user to input values 
public class Assignment1_BavalanThangarajah 

{
	public static void main(String[] args) throws IOException  
	{
		
				//Variables
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
					BingoCard(); 
					
				}
				
				else if (intProgram==2)
				{
					ObjectHeight();
				}
				
				else if (intProgram==3)
				{
					
					StartEnd();
					
				}
				
				else if (intProgram==4)
				{
					
					WordLength();
					
				}
				
				else if (intProgram==5)
				{
					
					QuadraticEquation();
					
				}
				
				else if (intProgram==6)
				{
					
					ManyTickets();
					
				}
				
				else if (intProgram==7)
				{
					
					RandomInt();
					
				}
				
				else if (intProgram==8)
				{
					
					DiceGame();
					
				}
				
				else if (intProgram==9)
				{
					
					Adder();
					
				}
				
				else if (intProgram==10)
				{
					
					CompundInt();
					
				}
				
				
				else if(intProgram==11)
				{
					intCount++;
					EOP();//Ends program 
					
				}
				
				else 
				{
					//If user chooses a number other than 1-11 message will appear and menu will reappear
					System.out.println("Please try again, but this time choose numbers 1-11");
					intCount=0;
				}
				
			}
				
			
		}
			public static void Menu() //Menu displays program options
			{
				System.out.println("\nWhich program would you like to use?"); 
				System.out.println("1.Bingo Card");
				System.out.println("2.Object Height");
				System.out.println("3.Start to End");
				System.out.println("4.Word Length");
				System.out.println("5.Quadratic Equation");
				System.out.println("6.Many Tickets");
				System.out.println("7.Random Interger");
				System.out.println("8.Dice Game");
				System.out.println("9.Adder");
				System.out.println("10.Compund Interger");
				System.out.println("11.Exit");
			}
			
			public static void BingoCard() throws IOException //Bingo Card
			{
				System.out.println("B \t I \t N \t G \t O");
				//Variables
				int intB;
				int intI;
				int intN;
				int intG;
				int intO;
				
				 for(int i=1; i<=5; i++)//Loops 5 times
				{
						intB=(int)(Math.random()*15)+1; //Randomizes numbers 1-15
						
						intI=(int)(Math.random()*15)+16; //Randomizes numbers 16-30
						
						intN=(int)(Math.random()*15)+31; //Randomizes numbers 31-45
						 
						intG=(int)(Math.random()*15)+46;//Randomizes numbers 46-60
						
						intO=(int)(Math.random()*15)+61;//Randomizes numbers 61-75
						
						//Outputs 5 values in each row.
						System.out.println(intB + "\t "+ intI +"\t" + intN + "\t"+ intG + "\t "+ intO);
						
						
						 if(i==3)//For the third loop(row)
						 {
							 intN=i; //Value for N will be replaced with "Free"
							 System.out.println(intB + "\t "+ intI +"\tFree\t" + intG + "\t "+ intO);
						 }
				}				 
			}
			
			public static void ObjectHeight() throws IOException // Object Height
			{
				//Variables
				String strTime;
				double dblTime;
				double dblHeight=0;
				
				//Helps user input values
				BufferedReader Input = new BufferedReader (new InputStreamReader(System.in));
				
				//Displays instructions
				System.out.println("Please enter a time less than 4.5 seconds:");

				strTime=Input.readLine();//Reads users input
				dblTime=Double.parseDouble(strTime);//Converts to a double

				if (dblTime < 4.5)// If time is less than 4.5
				{
					dblHeight = 100 - 4.9*dblTime*dblTime;//Calculation for height
					//Output Answer
					System.out.println("The height at: " + dblTime + " seconds" +  " is "+ dblHeight);

				}

				else //If user enters any other values
				{
					//Display message
					System.out.println("Please enter a number lower then 4.5 seconds");

				}
			}
			
			public static void StartEnd() throws IOException //Start to End application
			{
				//Variables
				String strNum;
				int intNum1;
				int intNum2;

				//Helps user enter values
				BufferedReader Input = new BufferedReader (new InputStreamReader(System.in));
				
				//Instructions to enter 1st Number
				System.out.println("Enter a starting number");
				strNum=Input.readLine();//Reads user input for first number
				intNum1=Integer.parseInt(strNum);//Converts to a integer
				
				//Instructions to enter 2nd Number
				System.out.println("Enter an ending number");
				strNum=Input.readLine();//Reads user input for first number
				intNum2=Integer.parseInt(strNum);//Converts to a integer

				System.out.println("The values in between " + intNum1 + " and " + intNum2 + " are:");
				for(int i = intNum1; i <=intNum2; i++)//Will loops as many times, in between the numbers entered
				{
					System.out.println(i);//Displays the values in between the two numbers entered
				}
				
			}
			
			public static void WordLength() throws IOException// Word Length
			{
				//Variables
				String strWords;
				int intLetters;
				
				BufferedReader Input = new BufferedReader (new InputStreamReader(System.in));
				
				//Instructions
				System.out.println("Enter a word");

				strWords=Input.readLine();//Reads users entry
				intLetters=strWords.length();//intLetters is equal to the length of the word entered

					for (int i=0; i <intLetters;i++)//Will loop accordingly to length of the word
					{
						System.out.println(strWords);//Displays the word as many times of the letter it contains
					}
			}
			
			public static void QuadraticEquation() throws IOException//Quadratic Equation
			{
				//Variables
				String strValues;
				double dblA;
				double dblB;
				double dblC;
				
				
				BufferedReader Input = new BufferedReader (new InputStreamReader(System.in));

				//Instructions
				System.out.println("The equation is viewed as (Ax^2 + Bx + C = 0) \n Please enter the value of A ");
				strValues=Input.readLine();//Reads users input
				dblA=Double.parseDouble(strValues);//Converts to a double

				System.out.println("Please enter the value of B");
				strValues=Input.readLine();//Reads users input
				dblB=Double.parseDouble(strValues);//Converts to a double

				System.out.println("Please enter the value of C");
				strValues=Input.readLine();//Reads users input
				dblC=Double.parseDouble(strValues);//Converts to a double
				
				//Displays the two roots from the functions
				System.out.println("The roots are " + QuadraticCalcOne (dblA,dblB,dblC) + " and " + QuadraticCalcTwo (dblA,dblB,dblC));
			}
			
			public static double QuadraticCalcOne (double dblA, double dblB, double dblC)//Function for one root
			{
				//Variables
				double dblFinal=0;
				double dblSquare=0;
				double dblDivide=0;
				
				//Calculations
				dblSquare= (Math.sqrt(dblB*dblB - 4*dblA*dblC));//Calculation on numerator
				dblDivide= (2*dblA);//Calculation on denominator

				dblFinal= (-dblB + dblSquare)/dblDivide; //All calculations combined
				double dblRound1=Math.round(dblFinal*100)/100.0;//Shortens decimals
				return dblRound1;//Return the final root back to method	
			}
			
			public static double QuadraticCalcTwo (double dblA, double dblB, double dblC)//Function for second root
			{
				//Variables
				double dblFinal2=0;
				double dblSquare=0;
				double dblDivide=0;
				//Calculations
				dblSquare= (Math.sqrt(dblB*dblB - 4*dblA*dblC));//Calculation on numerator
				dblDivide= (2*dblA);//Calculation on denominator
				dblFinal2=(-dblB - dblSquare)/dblDivide;//All calculations combined
				double dblRound=Math.round(dblFinal2*100)/100.0;//Shortens decimals
				return dblRound;//Return the second final root back to method				
			}
			
			
			
			
			
			public static void ManyTickets()throws IOException//Many Tickets
			{
				//Variables
				String strNum;  
				int intAge=0;
				int intPrice=0;
				int intTotal=0;
				
				BufferedReader Input = new BufferedReader (new InputStreamReader(System.in));
				
				for(int i=0;i<=intAge;i++)//Will loop until user stop entering an age
				{	
					//Instructions
					System.out.println("\nPlease enter your age, enter '999' to exit?");
					strNum=Input.readLine();//Reads input
					intAge=Integer.parseInt(strNum);//Converts input to integer
					
					if(intAge <= 12)//If the age is less than or equal to 12 
				{
					intPrice=6;//Price 6$
				}
				else if(intAge > 13 && intAge <= 64 )//If the age is between 13 and 64 
				{
					intPrice=11;//Price 11$
				}
				
				else if(intAge >= 65 && intAge!=999)//If the age is greater than 65 and does not equal 999
				{
					intPrice=8;//Price 11$
				}
				
				else if (intAge==999)//If user enters 999
				{
					//Display Message
					System.out.println("\nThank you and please come again");
					break;//Loop will break
				}
					intTotal+=intPrice;//Continuously add the prices until loop is broken
					
					//Output final value
					System.out.println("The price of the ticket currently is $ " +intTotal);
			}
		}
			
			public static void RandomInt()throws IOException //Random Integer
			{
				//Variables
				String strNum;
				int intInput;
				int intA;
				int intB;

				BufferedReader Input = new BufferedReader (new InputStreamReader(System.in));
				
				//Instructions
				System.out.println("\n1.For Integers\n2.For Real Numbers\nEnter any other number to exit");//displays options
				strNum=Input.readLine();//Read input
				intInput=Integer.parseInt(strNum);//Convert to integer
				if(intInput==1)//If user inputs 1
				{
					System.out.println("A)");
					for (int i=1;i<=10;i++)//Loops 10 times
					{
						intA=(int)(Math.random()*10)+1;//Randomizes numbers form 1-10
						System.out.println(intA);//Displays numbers
					}
					
					System.out.println("\nB)");
					for (int i=1;i<=10;i++)//Loops 10 times
					{
						intB=(int)(Math.random()*10)+21;//Randomizes numbers form 20-30
						System.out.println(intB);//Displays numbers
					}
					
					RandomInt();//Shows options again
				}
				
				else if(intInput==2)//If user chooses 2
				{
					RandomReal(); //Goes to RandomReal method
				}
				
		   }
			
		public static void RandomReal() throws IOException//(Random Int part 2)
		{
			//Variables
			double dblA;
			double dblB;
			
			System.out.println("A)");
			for (int i=1;i<=10;i++)//Loops 10 times
			{
				
				dblA=(double)(Math.random()*10);//Randomizes numbers form 1-10 (decimals)
				double dblRound1=Math.round(dblA*100)/100.0;
				System.out.println(dblRound1);//Displays numbers
			}
			
			System.out.println("\nB)");
			for (int i=1;i<=10;i++)//Loops 10 times
			{
				dblB=(double)(Math.random()*10)+20;//Randomizes numbers form 20-30(decimals)
				double dblRound=Math.round(dblB*100)/100.0;//Shortens decimalsl
				System.out.println(dblRound);//Displays numbers
			}
			
			RandomInt();// Goes back to RandomInt method
		}
			
		public static void DiceGame()throws IOException//Dice game
		{
			System.out.println("Welcome to the dice game\n");
			BufferedReader Input = new BufferedReader (new InputStreamReader(System.in));
			
			//Variables
			String strYN;
			int intCounter=0;
			int intCounter2=0;
			int intDice;
			int intDiceCount;
			int intRolls=1;
			
			while (intCounter==0)//Loop
			{
				intDice=(int)(Math.random()*6)+1; //Randomizes between 1-6
				System.out.println("The point to match is " + intDice);//Displays point
				
				while (intCounter2==0)
				{
					intDiceCount=(int)(Math.random()*6)+1;//Randomizes between 1-6
					System.out.println("Your roll is " + intDiceCount);//Displays rolls
					
					if(intDice==intDiceCount)
					{
						System.out.println("\nIt took the computer "+intRolls+" times to reach the point.");
						break;//Rolls will stop when the point finally reaches the same number when rolled
					}
					
					else
					{
						intRolls++;//If not equal,will continue to roll
					}
				}
				
				System.out.println("\nWould you like to continue? Y/y (yes) or N/n (No)");//Asks user if they want to play again
				strYN=Input.readLine();
				
				if (strYN.equals("Y")||strYN.equals("y"))
				{
					DiceGame();
					break;//If yes loop breaks and restarts
				}
				
				else if (strYN.equals("N")||strYN.equals("n"))
				{
					System.out.println("Goodbye");
					break;//If no loop breaks and exits game
				}
				
				intRolls=1;//Number of rolls resets to 1
			}
			
		}
		
		public static void Adder()throws IOException//Adder
		{
			//Variable Declaration
			String strUser;
			int intNum1;
			int intNum2;
			int intAns;
			int intUser;
			int intScore=5;
			int intTotal=0;
			int intCounter1=0;
			int intCounter2=0;
			
			BufferedReader Input= new BufferedReader(new InputStreamReader(System.in));//used to read input
			System.out.println("Hello please try to answer the following questions correctly.\nIn order to exit please enter 999\n");
			
			while (intCounter1==0)//Loops and asks question
			{
	
				intNum1=(int)(Math.random()*20)+1;//randomizes first number from 1-20
				intNum2=(int)(Math.random()*20)+1;//randomizes second number from 1-20
				
				//Calculation
				intAns=intNum1+intNum2;//Answer to sum
				
				System.out.print(intNum1+"+"+intNum2+"= ");//Question Displayed			
				while (intCounter2==0)//Loop to count score
				{
					strUser=Input.readLine();//Reads input
					intUser=Integer.parseInt(strUser);//converts input
					
					if (intUser==999)
					{
						intCounter1=1;
						System.out.println("Your score is: "+intTotal+"\n\n");
						break;//Loop ends when user enters 999
					}
					
					 if (intUser==intAns)
					{
						intTotal=intTotal+intScore;
						break;//If users answer is right the adds to score and loop ends and asks another question
					}
					else if (intScore>1)
					{
						System.out.println("Wrong Answer. Enter another Answer: ");
						intScore-=2;//If the user answer is wrong than and the score is greater than 5 the score should decrease by 2
					}
					
					
					else 
					{
						System.out.println("Wrong Answer. The write answer is "+intAns+".");
						break;//Loop ends when the user gets the question wrong 3 times the correct answer will display
					}
				}	
				intScore=5;//Resets to original score of 5  
			}		
		}

		
		public static void CompundInt()throws IOException//Compound Integer
		{
			
			//Variable Declaration
			String strUser;
			double dblDeposit;
			double dblRate;
			int intYears;
			
			BufferedReader Input=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("How much money was deposited?");//Asks Deposit
			strUser=Input.readLine();//Reads input
			dblDeposit=Double.parseDouble(strUser);//Converts to double
			
			System.out.println("What is the annual compounded interest rate?");//Asks Rate
			strUser=Input.readLine();//Reads input
			dblRate=Double.parseDouble(strUser);//Converts to double
			
			System.out.println("Number of years?");//Asks Years
			strUser=Input.readLine();//Reads input
			intYears=Integer.parseInt(strUser);//Converts to integer
			
			//Displays final balance(from the function)
			System.out.println("\nThe ending balance will be $"+(double)CompoundIntCalc(dblDeposit,dblRate,intYears));
			
		}
		
		public static double CompoundIntCalc(double dblDeposit,double dblRate,int intYears)//Function for CoumpundInt
		{
			//Variable Declaration
			double dblBalance;
			
			//Calculations for interest rates
			dblBalance= (1+dblRate);
			dblBalance=Math.pow(dblBalance, intYears);
			dblBalance=dblBalance*dblDeposit;
	
			return dblBalance;//Returns the final answer to the Compound Integer method
		}
		
		public static void EOP()throws IOException//Exit
		{
			System.out.println("Thank you!");//Displays message when exiting the program
		}
}	
			

	



	




