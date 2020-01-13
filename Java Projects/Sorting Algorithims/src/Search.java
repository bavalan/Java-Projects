
public class Search //Class usd for binary search
{
	public static int BinarySearch(int[]Array , int v) 
	{
		int intHigh = Array.length;
		int intLow = -1;
		int intMiddle = 0;
		
		while(intHigh - intLow > 1) //If the difference between the highest and lowest number is greater than 1
		{
			intMiddle = (intHigh + intLow) / 2;//Value of middle number
			if(Array[intMiddle] > v)
			{
				intHigh = intMiddle;
			}
			else 
			{
				intLow = intMiddle;
			}
		}
		
		if(intLow == -1 || Array[intLow] != v)
			return -1;
		
		return intLow;//Return the index
	}
	
}
