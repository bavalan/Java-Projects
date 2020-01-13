/*Name:Bavalan Thangarajah
 *Title:SquareVille
 */
//Functions that help the game to work
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Move  extends JPanel implements ActionListener,KeyListener//Move Class where the Game takes place, Animation and controls
{
	//Global Variables
	
	//Timer
	Timer time= new Timer(100,this);//Helps the game to start and characters/players to move
	
	//Player:
	static int intX=225;//X Position(Horizontal)
	static int intY=400;//Y Position(Vertical)

	int intVelxPlayer=0;//Horizontal Velocity
	int intVelyPlayer=0;//Vertical Velocity
	
	
	 //Blue Squares:
	static int intYBlue=-100;//Y Position(Vertical) for first square
	static int intYBlue2=-400;//Y Position(Vertical) for second square
	
	int intVelyBlue=1;//Vertical Velocity for first square
	int intVelyBlue2=1;//Vertical Velocity for second square
	
	 //Orange Squares:
	static int intXOrange=-50;//X Position(Horizontal) for first square
	static int intXOrange2=500;//X Position(Horizontal) for second square
	static int intXOrange3=-50;//X Position(Horizontal) for third square
	static int intXOrange4=500;//X Position(Horizontal) for fourth square
	int intVelxOrange=0;//Velocity used for all directions
	
	//Green Squares:
	static int intXGreen=-50;//X Position(Horizontal) for first square
	static int intYGreen=-100;//Y Position(Vertical) for second square
	static int intVelGreen=0;//Velocity in both directions

	//Red Squares:
	//Randomizer, used to Randomize X and Y Location
	static int intRandomxRed=(int)(Math.random()*400);
	static int intRandomyRed=(int)(Math.random()*440);

	//White Squares:
	static int intXWhite=(int)(Math.random()*440);;//X Position(Horizontal)
	static int intYWhite=(int)(Math.random()*440);;//Y Position(Vertical)
	
	//Purple Squares:
	//Randomizer, used to Randomize X and Y Location
	static int intRandomxPurple=(int)(Math.random()*400);
	static int intRandomyPurple=(int)(Math.random()*450);
	
	//Cyan Squares:
	//Randomizer, used to Randomize X and Y Location
	static int intRandomxCyan=600;
	static int intRandomyCyan=700;
	
	//Game Over Screen Locations;
	int intXG=800;
	int intYG=500;
	int intXH=800;
	int intYH=500;
	int intXS=800;
	int intYS=500;
	int intXES=800;
	int intYES=500;
	int intXM=800;
	int intYM=500;
	int intXR=800;
	int intYR=500;

	
	static int intPoint=0;//Score 
	public String strHighscore="";//Used to store highscore using ADT and an Array later on
	public String strName;//Users Name
		
//**********************************************************************************************
	//Creating the Characters(Rectangles) and Screens
	
	//Player:
	public static Rectangle r1 = new Rectangle(intX,intY,50,50);
	
	//Blue Squares:
	public static Rectangle r2 = new Rectangle(0,intYBlue,50,50);
	public static Rectangle r3 = new Rectangle(180,intYBlue2,50,50);
	public static Rectangle r4 = new Rectangle(400,intYBlue,50,50);
	
	//Orange Squares:
	public static Rectangle r5 = new Rectangle(intXOrange,250,50,50);
	public static Rectangle r6 = new Rectangle(intXOrange2,10,50,50);
	public static Rectangle r13 = new Rectangle(intXOrange3,400,50,50);
	public static Rectangle r14 = new Rectangle(intXOrange4,90,50,50);
	
	//Red Squares:
	public static Rectangle r7 = new Rectangle(intRandomxRed,intRandomyRed,20,20);
	
	//Purple Squares:
	public static Rectangle r10 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);//Original square
	public static Rectangle r15 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);
	public static Rectangle r16 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);
	public static Rectangle r17 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);
	public static Rectangle r18 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);
	public static Rectangle r19 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);
	public static Rectangle r20 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);

	//Green Squares:
	public static Rectangle r8 = new Rectangle(50,intYGreen,50,50);
	public static Rectangle r9 = new Rectangle(intXGreen,250,50,50);
	
	//White Squares:
	public static Rectangle r11 = new Rectangle(intXWhite,intYWhite,20,20);
	
	//Cyan Squares
	public static Rectangle r12 = new Rectangle(intRandomxCyan,intRandomyCyan,20,20);

	//Screens
	public boolean blnIsInMenu=true;
	public Image menuImage=null;
	public boolean blnIsInInstructions=false;
	public Image InstructionSortImage=null;
	public boolean blnIsInInstructionsSort=false;
	public boolean blnIsInEnd=false;
	public boolean blnRed=false;
	public boolean blnGreen=false;
	public boolean blnYellow=false;
	public boolean blnBlue=false;
	public boolean blnCyan=false;
	public boolean blnWhite=false;
	public boolean blnPurple=false;
	public boolean blnOrange=false;
	public Image InstructionImage=null;
	

	public Move ()//Activates Action and Key Listener
	{	
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setBackground(Color.BLACK);
	}

	public void paintComponent(Graphics g)//Draws Screens
	{
		if(blnIsInMenu)//If on Menu Screen
		{	
			time.start();//Timer starts
			DrawMenu(g);//Calls Drawn Menu Method
		}
		
		//*****************************************
		//SEARCHES:
		else if(blnIsInInstructions)//If on Instructions Screen
		{
			DrawInstructions(g);//Calls Drawn Instructions Method
			
			if(blnBlue)//If user Chooses Blue Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.BLUE);
				g.drawString("The Blue Square", 25, 350);
				g.drawString("will end your game",25,360);
				g.drawString("right away,it moves",25,370);
				g.drawString("vertically up and down",25,380);
				g.drawString("DO NOT TOUCH!!",25,390);

			}
			
			else if(blnGreen)//If user Chooses Green Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.GREEN);
				g.drawString("The Green Square", 25, 350);
				g.drawString("will teleport you to a",25,360);
				g.drawString("random location when ",25,370);
				g.drawString("you make contact",25,380);
				g.drawString("DO NOT TOUCH!!",25,390);

			}
			
			else if(blnOrange)//If user Chooses Orange Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.ORANGE);
				g.drawString("The Orange Square", 25, 350);
				g.drawString("will end your game",25,360);
				g.drawString("right away,it moves",25,370);
				g.drawString("horizontally",25,380);
				g.drawString("left and right",25,390);
				g.drawString("DO NOT TOUCH!!",25,400);

			}
			
			else if(blnPurple)//If user Chooses Purple Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.MAGENTA);
				g.drawString("The Purple Square", 25, 350);
				g.drawString("will deacrease your",25,360);
				g.drawString("Point by one every",25,370);
				g.drawString("time you make contact",25,380);
				g.drawString("with it",25,390);
				g.drawString("DO NOT TOUCH!!",25,400);
	
			}
			
			
			else if(blnWhite)//If user Chooses White Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.WHITE);
				g.drawString("The White Square", 25, 350);
				g.drawString("will end your game",25,360);
				g.drawString("right away,it moves",25,370);
				g.drawString("in a CRAZY / RANDOM",25,380);
				g.drawString("direction",25,390);
				g.drawString("DO NOT TOUCH!!",25,400);
		
			}
			
			else if(blnCyan)//If user Chooses Cyan Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.CYAN);
				g.drawString("The Cyan Square", 150, 350);;
				g.drawString("will get you",150,360);
				g.drawString("5 intPoints when",150,370);
				g.drawString("you touch it.",150,380);
				g.drawString("However,if you",150,390);
				g.drawString("touch a Purple",150,400);
				g.drawString("or Red Square ",150,410);
				g.drawString("before the Cyan",150,420);
				g.drawString("Square. IT WILL ",150,430);
				g.drawString("DISAPEAR!This",150,440);
				g.drawString("will only appear",150,450);
				g.drawString("TWICE,make",150,460);
				g.drawString("sure to grab it.",150,470);
		
			}
			
			
			else if(blnRed)//If user Chooses Red Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.RED);
				g.drawString("The Red Square", 150, 350);
				g.drawString("is what",150,360);
				g.drawString("determines if",150,370);
				g.drawString("your Square",150,380);
				g.drawString("King or not.",150,390);
				g.drawString("When contact is",150,400);
				g.drawString("made every",150,410);
				g.drawString(" time, you get",150,420);
				g.drawString("ONE Point!!!",150,430);
	
			}
			
			else if(blnYellow)//If user Chooses Yellow Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.YELLOW);
				g.drawString("This is YOU!", 150, 350);
				g.drawString("You must get",150,360);
				g.drawString("alot of Friendly",150,370);
				g.drawString("Squares!!",150,380);
				g.drawString("However,you",150,390);
				g.drawString("must also avoid",150,400);
				g.drawString("Enemy Squares!",150,410);
				g.drawString("Use the arrow",150,430);
				g.drawString("keys to move.",150,440);
				
			}
				
		}
		//**********************************************************
		//SORTING:
		else if(blnIsInInstructionsSort)//If on Instructions Sort Screen
		{
			DrawInstructionsSort(g);//Call Draw Instruction Sort method
			
			if(blnBlue)//If user Chooses Blue Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.BLUE);
				g.drawString("The Blue Square, will end your game", 10, 400);
				g.drawString("right away,it moves vertically up and down",10,410);
				g.drawString("DO NOT TOUCH!!",10,420);

			}
			
			else if(blnGreen)//If user Chooses Green Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.GREEN);
				g.drawString("The Green Square, will teleport you to a", 10, 400);
				g.drawString("random location when you touch it",10,410);

			}
			
			else if(blnOrange)//If user Chooses Orange Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.ORANGE);
				g.drawString("The Orange Square will end your game right ", 0, 400);
				g.drawString("away, it moves horizontally left and right",0,410);
				g.drawString("DO NOT TOUCH!!",0,420);

			}
			
			else if(blnPurple)//If user Chooses Purple Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.MAGENTA);
				g.drawString("The Purple Square,will deacrease your", 10, 400);
				g.drawString("Point by one, every time touch it",10,410);
				g.drawString("DO NOT TOUCH!!",10,420);
	
			}
			
			else if(blnWhite)//If user Chooses White Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.WHITE);
				g.drawString("The White Square,will end your game right", 0, 400);
				g.drawString("away,it moves in a CRAZY / RANDOM direction",0,410);
				g.drawString("DO NOT TOUCH!!",0,420);
	
			}
			
			else if(blnCyan)//If user Chooses Cyan Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.CYAN);
				g.drawString("The Cyan Square.is just like the Red Square,", 0, 400);
				g.drawString("except you get 5 intPoints when you touch it.",0,410);
				g.drawString("However,if you touch a Purple before the ",0,420);
				g.drawString("Cyan Square.IT WILL  DISSAPEAR!! This will",0,430);
				g.drawString("only appear TWICE, make sure to grab it.",0,440);

			}
						
			else if(blnRed)//If user Chooses Red Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.RED);
				g.drawString("The Red Square, is what determines", 0, 400);
				g.drawString("if your Square King or not.When contact is",0,410);
				g.drawString("made every time, you get ONE intPoint!!!",0,420);
						
			}
			
			else if(blnYellow)//If user Chooses Yellow Display Message
			{
				g.setFont(new Font("Arial",Font.BOLD,11));
				g.setColor(Color.YELLOW);
				g.drawString("This is YOU! You must get alot of Friendly", 0, 400);
				g.drawString("Square!However,you must also avoid Enemy",0,410);
				g.drawString("Squares! Use the arrow the keys to move.",0,420);
				
			}
		}
	
		else //If user doesn't choose anything else show game screen
		{
			
		    super.paintComponent(g);//paint built in property
			//Draw Squares on to screen
		    
		    //Player:
		    g.setColor(Color.YELLOW);
		 	r1 = new Rectangle(intX,intY,50,50);		
		 	g.fillRect(r1.x,r1. y,r1.width, r1.height);		
			
		 	//Blue Squares:
		 	g.setColor(Color.BLUE);
		 	r2 = new Rectangle(10,intYBlue,30,30);
			g.fillRect(r2.x,r2. y,r2.width, r2.height);
			
			g.setColor(Color.BLUE);
			r3 = new Rectangle(243,intYBlue2,30,30);
			g.fillRect(r3.x,r3. y,r3.width, r3.height);

			g.setColor(Color.BLUE);
			r4 = new Rectangle(430,intYBlue,30,30);
			g.fillRect(r4.x,r4. y,r4.width, r4.height);
			
			//Orange Squares:
			g.setColor(Color.ORANGE);
			r5 = new Rectangle(intXOrange,250,30,30);
			g.fillRect(r5.x,r5. y,r5.width, r5.height);
			
			g.setColor(Color.ORANGE);
			r6 = new Rectangle(intXOrange2,90,30,30);
			g.fillRect(r6.x,r6. y,r6.width, r6.height);
			
			g.setColor(Color.ORANGE);
			r13 = new Rectangle(intXOrange3,10,30,30);
			g.fillRect(r13.x,r13. y,r13.width, r13.height);
			
			g.setColor(Color.ORANGE);
			r14 = new Rectangle(intXOrange4,400,30,30);
			g.fillRect(r14.x,r14. y,r14.width, r14.height);
			
			//Green Squares:
			g.setColor(Color.GREEN);
			r8 = new Rectangle(50,intYGreen,30,30);
			g.fillRect(r8.x,r8. y,r8.width, r8.height);
			
			g.setColor(Color.GREEN);
			r9 = new Rectangle(intXGreen,250,30,30);
			g.fillRect(r9.x,r9. y,r9.width, r9.height);
			
			//Purple Squares:
			g.setColor(Color.MAGENTA);
			r10 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);
			g.fillRect(r10.x,r10. y,r10.width, r10.height);
		
			//Red Squares:
			g.setColor(Color.RED);
			r7 = new Rectangle(intRandomxRed,intRandomyRed,20,20);
			g.fillRect(r7.x,r7. y,r7.width, r7.height);
			
			//White Squares:
			//Position of White Squares before the game starts
			intXWhite=800;
			intYWhite=600;
			
			g.setColor(Color.WHITE);
			r11 = new Rectangle(intXWhite,intYWhite,20,20);
			g.fillRect(r11.x,r11. y,r11.width, r11.height);
			
			//Display Current Score and Previous HighScore on Game screen
			g.drawString("Points:"+intPoint, 330, 10);
			g.drawString("HighScore:"+strHighscore, 330, 30);
			
			//Game over Screen:
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString("GAME OVER!!!", intXG, intYG);//Game over Screen
			
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString("Highest Score:"+strHighscore, intXH, intYH);
			
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Arial",Font.BOLD,18));
			g.drawString("CONGRATS, " + strName + " YOU'RE THE NEW SQUARE KING!!", intXS, intYS);
			
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,10));
			g.drawString("Press 'ESC' to Close the Game", intXES, intYES);
			
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,10));
			g.drawString("Press 'M' to return to Menu", intXM, intYM);
			
			g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,10));
			g.drawString("Press 'R' to Restart the Game", intXR, intYR);
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			//Special intersections:
			if(r1.intersects(r7))//If Player touches Red Square
			{	
				//Find a new position
				intRandomxRed=(int)(Math.random()*400);
				intRandomyRed=(int)(Math.random()*400);		

				//Draw a new Red Square
				g.setColor(Color.RED);
				r7 = new Rectangle(intRandomxRed,intRandomyRed,20,20);
				g.fillRect(r7.x,r7. y,r7.width, r7.height);
				
				intPoint++;	//Increase the point by one	
			}
			
			if(strHighscore.equals(""))//If the User enters the name after getting a HighScore
			{
				strHighscore=this.Highscore();//Call the HighScore Function
			}
			

			if(r1.intersects(r8)||r1.intersects(r9))//If Player touches Green Square
			{
				//Find a new location(teleport) for the player
				intX=(int)(Math.random()*400);
				intY=(int)(Math.random()*440);
			}
			
			if(r1.intersects(r10)&&intPoint>1)//If Player touches Purple Square and the Score is greater than 1
			{	
				//Find a new location for purple square
				intRandomxPurple=(int)(Math.random()*400);
				intRandomyPurple=(int)(Math.random()*400);		

				//Draw a purple square
				g.setColor(Color.MAGENTA);
				r10 = new Rectangle(intRandomxPurple,intRandomyPurple,20,20);
				g.fillRect(r10.x,r10. y,r10.width, r10.height);
				
				intPoint--;//Decrease the point by one				
						
			}
			
			if(r1.intersects(r12)&&intPoint==13||r1.intersects(r12)&&intPoint==26)//If a player touches the Cyan square
			{	
				//Find a new location off of screen
				intRandomxCyan=600;
				intRandomyCyan=800;		

				g.setColor(Color.CYAN);
				r12 = new Rectangle(intRandomxCyan,intRandomyCyan,20,20);
				g.fillRect(r12.x,r12. y,r12.width, r12.height);;
				
				intPoint=intPoint+=5;//Increase Points by 5	
									
			}
			
			
	//***************************************************************************************************************************************		
			//SCORES:
			//If the Player touches a Purple Square when the score is 23
			if(r1.intersects(r15)&&intPoint==23||r1.intersects(r16)&&intPoint==23||r1.intersects(r17)&&intPoint==23||r1.intersects(r18)&&intPoint==23||r1.intersects(r19)&&intPoint==23||r1.intersects(r20)&&intPoint==23)
			{	
						
				g.setColor(Color.MAGENTA);
				r15 = new Rectangle(800,600,20,20);
				g.fillRect(r15.x,r15.y,r15.width, r15.height);
				
				g.setColor(Color.MAGENTA);
				r16 = new Rectangle(800,600,20,20);
				g.fillRect(r16.x,r16. y,r16.width, r16.height);
				
				g.setColor(Color.MAGENTA);
				r17 = new Rectangle(800,600,20,20);
				g.fillRect(r17.x,r17. y,r17.width, r17.height);
				
				g.setColor(Color.MAGENTA);
				r18 = new Rectangle(800,600,20,20);
				g.fillRect(r18.x,r18. y,r18.width, r18.height);
				g.setColor(Color.MAGENTA);
				
				r19 = new Rectangle(800,600,20,20);
				g.fillRect(r19.x,r19. y,r19.width, r19.height);
				g.setColor(Color.MAGENTA);
				
				r20 = new Rectangle(800,600,20,20);
				g.fillRect(r20.x,r20. y,r20.width, r20.height);
				
				intPoint--;//Score decreases by one				
						
			}
			
			
			if (intPoint>26)//If the Score is greater than 26 display the following
			{
				intVelxOrange=1;
				intVelyBlue=1;
				intVelyBlue2=1;
				intVelGreen=1;
				intXOrange3=intXOrange3+intVelxOrange*10;
				intXOrange4=intXOrange4-intVelxOrange*10;	
				intYBlue=intYBlue+intVelyBlue*20;
				intYBlue2=intYBlue2+intVelyBlue2*20;
				intXGreen=intXGreen+intVelGreen*10;
				intYGreen=intYGreen+intVelGreen*15;
			}
			
			else if(intPoint==26)//if the Score is equal to 26 display the following
			{
				intVelyBlue=1;
				intVelyBlue2=1;
				intVelGreen=1;
				intYBlue=intYBlue+intVelyBlue*20;
				intYBlue2=intYBlue2+intVelyBlue2*20;
				intXGreen=intXGreen+intVelGreen*10;
				intYGreen=intYGreen+intVelGreen*15;
				intRandomxCyan=400;
				intRandomyCyan=400;
				intXOrange3=-50;
				intXOrange4=500;
				intXWhite=600;
				intYWhite=800;
				
				g.setColor(Color.CYAN);
				r12 = new Rectangle(intRandomxCyan,intRandomyCyan,20,20);
				g.fillRect(r12.x,r12. y,r12.width, r12.height);

			}
				
			else if(intPoint==24) //if the Score is equal to 24 display the following
			{
				intVelxOrange=0;
				intVelyBlue=0;
				intVelyBlue2=0;
				intXOrange=-50;
				intXOrange2=-50;
				intXOrange3=-50;
				intXOrange4=500;
				intYBlue=-150;
				intYBlue2=-100;
				intYGreen=-100;
				intXGreen=-50;
				
				intXWhite=0;
				intYWhite=10;
				
				for(int i = 0;i<2;i++)//A for Loop constantly creating 2 White Square
				{
					intXWhite=(int)(Math.random()*400);
					intYWhite=(int)(Math.random()*440);
					
					g.setColor(Color.WHITE);
					r11 = new Rectangle(intXWhite,intYWhite,15,15);
					g.fillRect(r11.x,r11. y,r11.width, r11.height);
					
				
				}
			}
			
				
			else if(intPoint==23) //if the Score is equal to 23 display the following
			{
				
				intVelxOrange=0;
				intVelyBlue=0;
				intVelyBlue2=0;
				intXOrange=-50;
				intXOrange2=-50;
				intXOrange3=500;
				intXOrange4=500;
				intYBlue=-150;
				intYBlue2=-100;
				intYGreen=-100;
				intXGreen=-50;
				
				g.setColor(Color.MAGENTA);
				r15 = new Rectangle(200,100,20,20);
				g.fillRect(r15.x,r15.y,r15.width, r15.height);				
				g.setColor(Color.MAGENTA);
				r16 = new Rectangle(400,400,20,20);
				g.fillRect(r16.x,r16. y,r16.width, r16.height);
				g.setColor(Color.MAGENTA);
				r17 = new Rectangle(16,20,20,20);
				g.fillRect(r17.x,r17. y,r17.width, r17.height);
				g.setColor(Color.MAGENTA);
				r18 = new Rectangle(151,311,20,20);
				g.fillRect(r18.x,r18. y,r18.width, r18.height);
				g.setColor(Color.MAGENTA);
				r19 = new Rectangle(85,90,20,20);
				g.fillRect(r19.x,r19. y,r19.width, r19.height);
				g.setColor(Color.MAGENTA);
				r20 = new Rectangle(285,155,20,20);
				g.fillRect(r20.x,r20. y,r20.width, r20.height);
			}
			else if(intPoint>=20)//if the Score is greater or equal to 20 display the following
			{	
				intVelxOrange=1;
				intVelyBlue=1;
				intVelyBlue2=1;
				intXOrange=intXOrange+intVelxOrange*10;
				intXOrange2=intXOrange2-intVelxOrange*10;
				intXOrange3=intXOrange3+intVelxOrange*10;
				intXOrange4=intXOrange4-intVelxOrange*10;	
				intYBlue=intYBlue+intVelyBlue*20;
				intYBlue2=intYBlue2+intVelyBlue2*20;
				intYGreen=-100;
				intXGreen=-50;
				
			}
			
			else if(intPoint>=14)//if the Score is greater or equal to 14 display the following
			{	
				intVelxOrange=1;
				intXOrange=intXOrange+intVelxOrange*10;
				intXOrange2=intXOrange2-intVelxOrange*10;
				intXOrange3=intXOrange3+intVelxOrange*10;
				intXOrange4=intXOrange4-intVelxOrange*10;
				intYGreen=-100;
				intXGreen=-50;
					
			}
			
			else if(intPoint==13)//if the Score is equal to 13 display the following
			{	
				intVelxOrange=1;
				intVelGreen=1;
				intXOrange=intXOrange+intVelxOrange*10;
				intXOrange2=intXOrange2-intVelxOrange*10;
				intYGreen=intYGreen+intVelGreen*20;
				intXGreen=-50;
				intXOrange3=-50;
				intXOrange4=500;
				intXWhite=800;
				intYWhite=600;
				intRandomxCyan=400;
				intRandomyCyan=400;
				
				g.setColor(Color.CYAN);
				r12 = new Rectangle(intRandomxCyan,intRandomyCyan,20,20);
				g.fillRect(r12.x,r12. y,r12.width, r12.height);
				
				
			}

			
			else if(intPoint==12)//if the Score is equal to 12 display the following
			{	
				
				intXWhite=0;
				intYWhite=10;
				intVelxOrange=0;
				intVelyBlue2=0;
				intVelGreen=0;
				intXGreen=-50;
				intXOrange2=600;
				intYBlue2=-100;
				intYGreen=-100;
				intXGreen=-50;
				
				for(int i = 0;i<1;i++)//A for loop constantly randomizing the location of the White Square
				{
					intXWhite=(int)(Math.random()*400);
					intYWhite=(int)(Math.random()*440);
					g.setColor(Color.WHITE);
					r11 = new Rectangle(intXWhite,intYWhite,15,15);
					g.fillRect(r11.x,r11. y,r11.width, r11.height);	
				
				}
				
			}
			
			
			else if(intPoint>=9)//if the Score is greater or equal to 9 display the following
				{		
					intVelxOrange=1;
					intVelyBlue=0;
					intVelyBlue2=1;
					intVelGreen=1;
					intXOrange2=intXOrange2-intVelxOrange*10;
					intYBlue2=intYBlue2+intVelyBlue2*15;
					intXGreen=intXGreen+intVelGreen*10;
					intYGreen=intYGreen+intVelGreen*15;
					intYBlue=-100;
					intXOrange=-50;
		
				}
				
			else if(intPoint>=6)//if the Score is greater or equal to 6 display the following
			{		
				intVelxOrange=1;
				intVelyBlue=1;
				intXOrange=intXOrange+intVelxOrange*5;
				intXOrange2=intXOrange2-intVelxOrange*5;
				intYBlue=intYBlue+intVelyBlue*10;
				intYBlue2=-100;
				intYGreen=-100;
				intXGreen=-50;
	
			}
			
			 else if (intPoint>=3)//if the Score is greater or equal to 3 display the following
			{
				intVelxOrange=1;
				intVelyBlue=0;
				intVelyBlue2=0;
				intXOrange=intXOrange+intVelxOrange*10;
				intXOrange2=intXOrange2-intVelxOrange*10;
				intYBlue2=-100;
				intYBlue=-150;
				intYGreen=-100;
				intXGreen=-50;
			
			}
			
			 else if (intPoint>=1)//if the Score is greater or equal to 1 display the following
				{
					intVelyBlue=1;
					intVelyBlue2=1;
					intYBlue=intYBlue+intVelyBlue;
					intYBlue2=intYBlue2+intVelyBlue2;
					intXOrange=-50;
					intXOrange2=500;
					intYGreen=-100;
					intXGreen=-50;
				
				}
			 
			
			//Display the following once the game starts
			intX=intX+intVelxPlayer*2;
			intY=intY+intVelyPlayer*2;
			intYBlue=intYBlue+intVelyBlue*20;
			intYBlue2=intYBlue2+intVelyBlue2*20;
		}
								
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void DrawMenu(Graphics g)//Draw Menu Method
	{
		//Try Catch used
		if(this.menuImage==null)
		{
			try
			{
				//Import Image
				URL imagePath=Move.class.getResource("Menu.jpg");
				menuImage=Toolkit.getDefaultToolkit().getImage(imagePath);
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//Draw the Image
		g.drawImage(menuImage, 0, 0, 470,500,this);
	}
	
	public void DrawInstructions(Graphics g)//Draw Instructions Method
	{
		//Try Catch Used
		if(this.InstructionImage==null)
		{
			try
			{	
				//Import Image	
				URL imagePath=Move.class.getResource("InstructionsMain.jpg");
				InstructionImage=Toolkit.getDefaultToolkit().getImage(imagePath);
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			g.drawImage(InstructionImage, 0, 0, 470,500,this);//Draw the Image	
	}
	
	public void DrawInstructionsSort(Graphics g)//Draw Instructions Sort Method
	{
		//Try Catch Used
		if(this.InstructionSortImage==null)
		{
			try
			{
				//Import Image	
				URL imagePath=Move.class.getResource("InstructionsSort.jpg");
				InstructionSortImage=Toolkit.getDefaultToolkit().getImage(imagePath);
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			//Draw the Image
			g.drawImage(InstructionSortImage, 0, 0, 470,500,this);
	}	
//.........................................................................................................................................
	

	public String Highscore()//HighScore Function
	{
		FileReader readFile=null;
		BufferedReader BufferNames=null;
		try
		{
			 readFile=new FileReader("Highscore.txt");
			 BufferNames = new BufferedReader(readFile);
			return BufferNames.readLine();
		}
		catch (Exception m)
		{
			return"Nobody:0";//returns Nobody
		}
		
		finally
		{
			try {
				if(BufferNames!=null)
				{
				BufferNames.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//ACTION PERFORMED WHERE ALL MOVEMENT OF THE GAME HAPPENS
	
	public void actionPerformed(ActionEvent e)
	{
		int intCount=0;
		TimeClass tc = new TimeClass(intCount);//Timer calls timer from the TimeClass Class
		time= new Timer(100,tc);
		
		repaint();//Calls the paint method as soon as possible
		
		//If the Player touches the Orange,Blue or White Square Ends The Game
		if(r1.intersects(r2)||r1.intersects(r3)||r1.intersects(r4)||r1.intersects(r5)||r1.intersects(r6)||r1.intersects(r11)||r1.intersects(r13)||r1.intersects(r14))
		{
			//New Positions: 
			//Method for the HighScore
			Highscore();
			intVelyBlue=0;
			intVelyBlue2=0;
			intVelxOrange=0;
			intVelGreen=0;
			
			
			intXGreen=-50;
			intXOrange=-50;
			intXOrange2=500;
			intXOrange3=-50;
			intXOrange4=500;
			intYGreen=-100;
			intYBlue2=-100;
			intYBlue=-400;
			intRandomxRed=800;
			intRandomyRed=800;
			
			intRandomxPurple=800;
			intRandomyPurple=800;
			
			intXWhite=800;
			intYWhite=800;
			
			intXG=100;
			intYG=200;

			intXH=10;
			intYH=300;
			
			intXES=10;
			intYES=400;
			
			intXM=10;
			intYM=430;
			
			intXR=10;
			intYR=460;
			
			//If the New score is greater than the old one
			if(intPoint>Integer.parseInt((strHighscore.split(":")[1])))//Save it to an ARRAY,and use the ADT (Split) to separate the name and score
			{
				strName=JOptionPane.showInputDialog("CONGRATS!!! You got a new highscore please enter your name!!");//Text Panel asks for name
				strHighscore=strName+":"+intPoint;
				 intXS=5;
				 intYS=350;
			
			File scoreFile=new File("Highscore.txt");//Creates a new txt File called highscores
			if(!scoreFile.exists())//Id the file does not exist use a try catch statement
			{
				try {
					scoreFile.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			FileWriter writeFile=null;//Creates a File Writer to overwrite old data
			BufferedWriter writer=null;//A buffer reader to read old data in txt file
			try
			{
				//Writes the new data into the Scorefile
				writeFile=new FileWriter(scoreFile);
				writer=new BufferedWriter(writeFile);
				writer.write(this.strHighscore);
				
			}
			
			catch (Exception m)
			{
				//A catch not necessary
			}
			
			finally//Finally
			{
				if(writer!=null)//After entering the highscore close the file
				{
					try {
						writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
			
			intPoint=0;//Set Point to Zero		
	}
		
		
//........................................................................................................................................				
		//Movements / Animations
		//BOUNDRIES:
		//When any one of these character/players goes out of bounds it loops it back to it's original starting point 
		 if(intXGreen>510)
			{
				intXGreen=0;
				intXGreen=intXGreen+intVelGreen*15;
				
			}
		 
		 if(intYGreen>510)
			{
				intYGreen=0;
				intYGreen=intYGreen+intVelGreen*15;
				
			}
		 
		 if(intXOrange>510)
		 {
			intXOrange=-50;
			intXOrange=intXOrange+intVelxOrange*10;
			
		 }
		 
		 if(intXOrange2<0)
		 {
			intXOrange2=500;
			intXOrange2=intXOrange2-intVelxOrange*10;

		 }
		 
		 if(intXOrange3>510)
		 {
			 intXOrange3=-50;
			 intXOrange3=intXOrange3+intVelxOrange*10;
				
		 }
			 
		if(intXOrange4<0)
		 {
			intXOrange4=500;
			intXOrange4=intXOrange4-intVelxOrange*10;


		 }
		 
		if(intYBlue>500)
		{		
			intYBlue=-150;
			intYBlue=intYBlue+intVelyBlue*30;
		}
		
		if(intYBlue2>500)
		{		
			intYBlue2=-100;
			intYBlue2=intYBlue2+intVelyBlue*30;
		}
		
		if(intX<0)
		{
			intVelxPlayer=0;
			intX=0;
		}
		
		if(intX>400)
		{
			intVelxPlayer=0;
			intX=400;
		}
		

		if(intY<0)
		{
			intVelyPlayer=0;
			intY=0;
		}
		
		if(intY>430)
		{
			intVelyPlayer=0;
			intY=430;
		}
	
	}
//......................................................................................................................................	
	
	//Methods for players movements
	public void up()
	{
		intVelyPlayer=-10;
		intVelxPlayer=0;	
	}
	
	public void down()
	{
		intVelyPlayer=10;
		intVelxPlayer=0;
	}
	

	public void left()
	{
		intVelxPlayer=-10;
		intVelyPlayer=0;
	}
	

	public void right()
	{
		intVelxPlayer=10;
		intVelyPlayer=0;
	}

	
	public void keyPressed(KeyEvent e)//Player Interactions KeyPressed
	{
		
		int code=e.getKeyCode();
		if(code== KeyEvent.VK_UP)//If use presses up arrow key
		{
			up();//Calls up method
				
		}
		

		else if(code== KeyEvent.VK_DOWN)//If use presses down arrow key
		{
			down();//Calls down method
		}
		

		else if(code== KeyEvent.VK_LEFT)//If use presses left arrow key
		{
			left();//Calls left method
		}
		

		else if(code== KeyEvent.VK_RIGHT)//If use presses right arrow key	
		{
			right();//Calls right method
		}
		
		if(code== KeyEvent.VK_R)//"R" resets the game
		{
			intVelyBlue=1;
			intVelyBlue2=1;
			intXOrange=-50;
			intXOrange2=500;
			intXGreen=-50;
			intYGreen=-100;		
			intPoint=0;
			intRandomxRed=(int)(Math.random()*400);
			intRandomyRed=(int)(Math.random()*500);	
			intRandomxPurple=(int)(Math.random()*400);
			intRandomyPurple=(int)(Math.random()*500);
			intXG=800;
			intYG=500;
			intXH=800;
			intYH=500;
			intXS=800;
			intYS=500;
			intXES=800;
			intYES=500;
			intXM=800;
			intYM=500;
			intXR=800;
			intYR=500;
				
			time.restart(); //time restarts
			
		}
		
		if(code== KeyEvent.VK_ENTER)//Starts the game
		{
			if(blnIsInMenu)
			{
			  blnIsInMenu=false;
			  blnIsInInstructions=false;
			  blnIsInInstructionsSort=false;
			  blnRed=false;
			  blnGreen=false;
			  blnYellow=false;
			  blnBlue=false;
			  blnCyan=false;
			  blnWhite=false;
		   	  blnPurple=false;
			  blnOrange=false;

				repaint();
			}

		}
		
		if(code== KeyEvent.VK_I)//Shows instructions
		{
			if(blnIsInMenu)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnRed=false;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}

		}
		
		//If in instructions screen the following keys will preform the correct functions
		else if(code== KeyEvent.VK_R)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnRed=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnRed=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}

		}
		
		else if(code== KeyEvent.VK_G)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnGreen=true;
				blnRed=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnGreen=true;
				blnRed=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}

		}
		else if(code== KeyEvent.VK_Y)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnYellow=true;
				blnGreen=false;
				blnRed=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnYellow=true;
				blnGreen=false;
				blnRed=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}

		}
		else if(code== KeyEvent.VK_B)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnBlue=true;
				blnGreen=false;
				blnYellow=false;
				blnRed=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnBlue=true;
				blnGreen=false;
				blnYellow=false;
				blnRed=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}

		}
		else if(code== KeyEvent.VK_C)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnCyan=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnRed=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnCyan=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnRed=false;
				blnWhite=false;
			   	blnPurple=false;
				blnOrange=false;
				repaint();
			}

		}
		else if(code== KeyEvent.VK_W)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnWhite=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnRed=false;
			   	blnPurple=false;
				blnOrange=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnWhite=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnRed=false;
			   	blnPurple=false;
				blnOrange=false;
				repaint();
			}

		}
		else if(code== KeyEvent.VK_P)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnPurple=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnRed=false;
				blnOrange=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnPurple=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnRed=false;
				blnOrange=false;
				
				repaint();
			}

		}
		else if(code== KeyEvent.VK_O)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructions=true;
				blnIsInMenu=false;
				blnOrange=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnRed=false;
				
				repaint();
			}
			
			else if(blnIsInInstructionsSort)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnOrange=true;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnRed=false;
				
				repaint();
			}

		}
		
		else if(code== KeyEvent.VK_S)
		{
			if(blnIsInInstructions)
			{
				blnIsInInstructionsSort=true;
				blnIsInInstructions=false;
				blnIsInMenu=false;
				blnOrange=false;
				blnGreen=false;
				blnYellow=false;
				blnBlue=false;
				blnCyan=false;
				blnWhite=false;
			   	blnPurple=false;
				blnRed=false;
				
				repaint();
			}
			
		}
		
		
		else if(code== KeyEvent.VK_M)//Menu
		{
				blnIsInMenu=true;
				blnIsInInstructionsSort=false;
				blnIsInInstructions=false;
				intVelyBlue=1;
				intVelyBlue2=1;
				intXOrange=-50;
				intXOrange2=500;
				intXGreen=-50;
				intYGreen=-100;		
				intPoint=0;
				intRandomxRed=(int)(Math.random()*400);
				intRandomyRed=(int)(Math.random()*500);	
				intRandomxPurple=(int)(Math.random()*400);
				intRandomyPurple=(int)(Math.random()*500);	
				intXG=800;
				intYG=800;
				intXH=800;
				intYH=500;
				intXS=800;
				intYS=500;
				intXES=800;
				intYES=500;
				intXM=800;
				intYM=500;
				intXR=800;
				intYR=500;
				time.restart(); //time restarts
		}
		
		else if(code== KeyEvent.VK_ESCAPE)//Closes the game
		{
			System.exit(0);//Exits GUI
		}
		
		
	}
			
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}	

		
}
