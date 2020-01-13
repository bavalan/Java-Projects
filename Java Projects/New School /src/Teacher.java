import java.io.*;

//Teacher Class
public class Teacher implements Serializable//Serialization
{
	//Variables
	private String strName; 
	private String strRoom;
	private int intClass; 
	private String[] strClass; 
		
		public Teacher(String name, String room) 
		{
			
			this.strName = name;
			this.strRoom = room;
			intClass = 0;
			strClass = new String[35]; //Array for the maximum number of students
			
			for(int i = 0; i < strClass.length; i++)
				strClass[i] = "";
		}
		
		//Gets name and address value of user and room number them to the driver
		public String getName() 
		{
			return strName; 
		}
		public String getRoom() 
		{
			return strRoom; 
		}
		
		//sets the room value for future changes
		public void setRoom(String room) 
		{
			strRoom = room; 
		}

		
		public boolean addClass(String Class)//Add students
		{
			if(intClass == 35)//Will not allow to enter 35 students
				return false;
			else 
			{
				intClass++;//Continue to add on students
				for(int i = 0; i < strClass.length; i++)//Loops until user is done adding entries
				{
					if(strClass[i] == "")
					{
						strClass[i] = Class;
						return true; 
					}
				}
			}
			return true; 
		}
		
		public boolean removeClass(String Class)//Remove students
		{
			if(intClass == 0)//Will not allow user to remove students when they are no students to remove
				return false; 
			else 
			{
				for(int i = 0 ; i < strClass.length; i++)//Loops until user is done deleting entries
				{
					if(strClass[i].equals(Class))
					{
						strClass[i] = "";
						intClass--;//Deletes the student entered 
						return true;
					}
				}
			}
			return false; 
		}
		
		public String toString()//Converts to string
		{
			String data1 = Integer.toString(intClass);//Parses the number of students to string
			
			String data2 = "\nStudents Name (First,Last): ";//Students name
			for(int i = 0; i < strClass.length; i++)
			{
				if(!strClass[i].equals(""))
				{
					data2 += "\n"+strClass[i];
				}
			}
			return  "Name: " + strName +  "\nRoom Number: " + strRoom + "\nTotal Students: " + data1 +  data2;
		}
	}



