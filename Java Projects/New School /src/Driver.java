/*Name:Bavalan Thangarajah
 *Title: New School Member
 *Purpose: To learn random access files and serialization 
 */
import java.io.*;
public class Driver 
{
	

		public static void main(String[] args) throws IOException 
		{
			BufferedReader myInput = new BufferedReader(new InputStreamReader(System.in));//Bufferreader helps read users input
			
			//Variables
			String strOption;
			int intProgram=0;
			int intCount=0;
			
			while (intCount==0) //Loop for menu
			{
			Menu();//Method for menu
			strOption=myInput.readLine();//Users input for the application they would like to use
			intProgram=Integer.parseInt(strOption); //Converts users input to integer
			
			//Application choices, user presses the number to choose application.
			if(intProgram==1) 
			{
				Teacher(); 
				
			}
			
			else if (intProgram==2)
			{
				Student();
			}
			
			
			else if(intProgram==3)
			{
				intCount++;
				break;
				
			}
			
			else 
			{
				//If user chooses a number other than 1-11 message will appear and menu will reappear
				System.out.println("Please try again, but this time choose numbers 1-2 or enter 3 to exit");
				intCount=0;
			}
			
		}
	}
		
		public static void Menu() //Menu displays program options
		{
			System.out.println("\nWhich program would you like to use?"); 
			System.out.println("1.Teacher");
			System.out.println("2.Student");
			System.out.println("3.Exit");
		}
			
		
	
		
		
		public static void Teacher()  throws IOException//Teacher void
		{
			//Void
			Teacher teacher;
			String strUser; 
			String[] strInfo; 
			
			BufferedReader myInput = new BufferedReader(new InputStreamReader(System.in));//Bufferreader helps read users input
			
			
		try// Try and catch to find and fix errors
		{
			System.out.println("Please enter your constructors to create a teacher or 3 to exit"); 
			System.out.println("Constructors: Name(First.Last) *enter space* (Room Number)");
			
			strUser = myInput.readLine();//Reads users input
			
			if(!strUser.equals("3"))//If user does not enter 3
			{
				strInfo = strUser.split(" ");//Info is split with [space]
				
				if(strInfo.length >= 2)
				{
					//Teacher can change Room Number
					String room = strUser.substring(strInfo[0].length() + 1, strUser.length());
					teacher = new Teacher(strInfo[0], room);
					
					while(!strUser.equals("3"))
					{
						
						//Menu
						System.out.println("[Teacher]\n" + teacher.toString());
						System.out.println("\nTo edit the room number, please enter \"set room (enter the new room number)\"");
						System.out.println("To add a Student, please enter \"add (Students Name |First.Last|)\"");
						System.out.println("To remove a Class please enter \"remove (Students Name |First.Last|)\"");
						System.out.println("Enter 3 to exit to the main menu");
						
						strUser = myInput.readLine();//Reads users input
						if(!strUser.equals("3"))
						{
							strInfo = strUser.split(" ");
							if(strInfo[0].equals("set"))//If user enters "set"
							{
								if(strInfo[1].equals("room"))//Room number will change if "room" is also entered
								{
									room = strUser.substring(8, strUser.length());
									teacher.setRoom(room);
									
								}

								
								else //Display message
								{
									System.out.println("You cannot edit this property! Press [ENTER] to continue...");
									myInput.readLine();
								}	
							}
							else if (strInfo[0].equals("add"))//If user enters "add"
							{
								if(teacher.addClass(strInfo[1]))//Info array calls add void from teacher class
								{
									System.out.println("Student \"" + strInfo[1] + "\" has been added... press [ENTER] to continue...");
								}
								else //if strInfo[] array too full display message
								{
									System.out.println("Class too full, please remove a Student before adding another one... press [ENTER] to continue.");
								}
								
								myInput.readLine();
							}
							else if(strInfo[0].equals("remove"))//If user enters "remove"
							{
								if(teacher.removeClass(strInfo[1]))//Info array calls remove void from teacher class
								{
									System.out.println("Student removed!... press [ENTER] to continue.");
								}
								else //If added file is not found
								{
									System.out.println("Unable to locate the Student... press [ENTER] to continue.");
								}
								
								myInput.readLine();
							}
						}
					}
				}
				else 
				{
					System.out.println("Invalid contructors, exiting to main menu, press [ENTER] to continue.");
					myInput.readLine(); 
				}
			}
		 }catch(FileNotFoundException err)//Catch message
		{
			 System.out.println("Invalid contructors, exiting to main menu, press [ENTER] to continue."); 
		}
	}
		
		public static void Student() throws IOException//Student void
		{
			//Variables
			Student student;
			String strUser; 
			String[] strInfo; 
			
			BufferedReader myInput = new BufferedReader(new InputStreamReader(System.in));//Bufferreader helps read users input
			
			System.out.println("Please enter your constructors to create a student or 3 to exit"); 
			System.out.println("Constructors: Name(First,Last) *enter space* (Address)");
			
			strUser = myInput.readLine();//Reads users input
			
			if(!strUser.equals("3"))//If user doesn't enter 3
			{
				strInfo = strUser.split(" ");
				if(strInfo.length >= 2)
				{
					//Student can change Address
					String address = strUser.substring(strInfo[0].length() + 1, strUser.length());
					student = new Student(strInfo[0], address);
					
					while(!strUser.equals("3"))
					{
						
						//Menu
						System.out.println("[Student] " + student.toString());
						System.out.println("\nTo edit the address, please enter \"set address (enter in the new address)\"");
						System.out.println("To add a course, please enter \"add (coursename) *press the [spacebar]* (grade value) )\"");
						System.out.println("To add a course, please enter \"remove (coursename) *press the [spacebar]* (grade value) )\"");
						System.out.println("To get all your courses and grades enter \"get grades\"");
						System.out.println("To get your GPA enter \"get gpa\"");
						System.out.println("Enter 3 to exit to the main menu");
						
						strUser = myInput.readLine();
						if(!strUser.equals("3"))
						{
							strInfo = strUser.split(" ");
							if(strInfo[0].equals("set"))//If user enters set and address then change the address
							{
								if(strInfo[1].equals("address"))
								{
									address = strUser.substring(11, strUser.length());
									student.setAddress(address);
								}
								else
								{
									System.out.println("You cannot edit this property! Press [ENTER] to continue...");
									myInput.readLine();
								}	
							}
							
							else if (strInfo[0].equals("add"))//Allows student to enter the course and grade
							{
							  try//Try and catch errors
							  {
								if(student.addCourseGrade(strInfo[1], Integer.parseInt(strInfo[2])))//Student adds course
								{
									System.out.println("Course \"" + strInfo[1] + "\" has been added... press [ENTER] to continue...");
								}
								
								else //If theirs is too much courses
								{
									System.out.println("Courses full, please remove a course before adding another one... press [ENTER] to continue.");
								}
							  }
							  
							  catch (Exception e) //Catch message
							  {
								
								  System.out.println("Invalid contructors, exiting to main menu, press [ENTER] to continue.");
							  } 
								
								
								myInput.readLine();
								
							}
							
							else if(strInfo[0].equals("remove"))//If student chooses to remove
							{
							  try
							  {
								if(student.removeCourseGrade(strInfo[1], Integer.parseInt(strInfo[2])))//Removes course
								{
									System.out.println("Course removed!... press [ENTER] to continue.");
								}
								else //Unable to get course
								{
									System.out.println("Unable to locate the Student... press [ENTER] to continue.");
								}
							   }
								 catch (Exception e) 
								  {
									  System.out.println("\nInvalid contructors, exiting to main menu, press [ENTER] to continue.");
								  } 
								
								myInput.readLine();
							}
							
							else if(strInfo[0].equals("get"))//If user enters "get"
							{
								if(strInfo[1].equals("grades"))//If user enters "grades"
								{
									student.printGrades();//Print all grades
								}
								else if(strInfo[1].equals("gpa"))//If user enter "GPA"
								{
									System.out.println("GPA: " + student.getAverageGrade());//Gets the average
								}
								myInput.readLine();
							}
						}
					}
				}
				else 
				{
					System.out.println("Invalid contructors, exiting to main menu, press [ENTER] to continue.");
					myInput.readLine(); 
				}
			}
		}
		
	}
