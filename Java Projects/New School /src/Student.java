import java.io.*;

//Student Class
public class Student implements Serializable//Serialization
{
	//Variables
	private String strName; 
	private String strAddress; 
	private int intCourses; 
	private String[] strCourses; 
	private int[] intGrades;
	
	public Student(String name, String address) 
	{

		this.strName = name;
		this.strAddress = address; 
		intCourses = 0; //Course value set to 0
		
		//Array for courses and grades
		strCourses = new String[8];
		intGrades = new int[8];
		
		//Loops 8 times because there are 8 courses
		for(int i = 0; i < 8; i++)
		{
			strCourses[i] = "";
			intGrades[i] = 0;
		}
	}
	
	//Gets name and address value of user and returns them to the driver
	public String getName() 
	{ 
		return strName; 
	}
	public String getAddress() 
	{ 
		return strAddress; 
	}
	
	//sets the address value for future changes
	public void setAddress(String address) 
	{
		strAddress = address;
	}
	
	//If user is adding a course
	public boolean addCourseGrade(String course, int Grade)
	{
		if(intCourses == 8)//Will not allow to enter 9 courses {array[8]}
			return false; 
		
		for(int i = 0; i < strCourses.length; i++)//Loops until user is done adding entries
		{
			if(strCourses[i].equals(""))
			{
				strCourses[i] = course;
				intGrades[i] = Grade;
				intCourses++;//Continue to add course
				return true;
			}
		}
		return true;
	}
	
	public boolean removeCourseGrade(String course, int Grade)//Removing courses
	{
		if(intCourses == 0)//Will not allow user to remove courses when they are no courses to remove
			return false; 
		else
		{
		 for(int i = 0; i < strCourses.length; i++)//Loops until user is done adding entries
		 {
			if(strCourses[i].equals(course))
			{
				intGrades[i] = Grade;
				intGrades[i]--;//Will remove the grade
				strCourses[i] = "";
				intCourses--;//Will remove the course
				return true;
			}
		 }
	   }
		
		return false;
	}
	
	public void printGrades() //Void to print the grades
	{
		for(int i = 0; i < strCourses.length; i++)
		{
			if(!strCourses[i].equals(""))
			{
				System.out.println(strCourses[i] + ": " + intGrades[i]);//prints grade and courses
			}
		}
	}
	public double getAverageGrade() //void to get the GPA
	{
		double dblTotal = 0;
		for(int i = 0; i < intCourses; i++)
			dblTotal += (double)intGrades[i];//Add all the grades together and divides by the number of courses entered
		
		return dblTotal / (double)intCourses;
	}
	
	public String toString()//Converts Values to a string
	{
		return  "Name: " + strName +  "\nAddress: " + strAddress +"\nAverage: " + getAverageGrade() + "\nTotal Courses: " + intCourses; 
		
	}
}

