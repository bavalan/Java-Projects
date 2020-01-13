
public class Styles //Styles class
{
public static int intSwapCounter = 0;//The Swap counter is set to 0
	
	//Sorting Styles for Ascending
	public static int[] BubbleSort(int[] Array) //Bubble Sort
	{
		//Variables
		intSwapCounter = 0;
		int intSwap = 0;
		
		//Bubble sort function
		for(int x = 0; x < Array.length; x++)
		{
			for(int i = 0; i < Array.length - 1; i++)
			{
				if(Array[i] > Array[i + 1])
				{
					intSwap = Array[i];
					Array[i] = Array[i + 1];
					Array[i + 1] = intSwap; 
					intSwapCounter++;
				}
			}
		}
		
		return Array; //Return Sorted Array
	}
	
	public static int[] InsertionSort(int[] Array)//Insertion Sort
	{
		//Variables
		int intSwap=0;
		int x=0;
		intSwapCounter=0;
		
		//Function for Insertion Sort
		for(int i=0;i<Array.length;i++)
		{
			x=i;
			
			while(x>0 && Array[x-1]>Array[x])
			{
				intSwap=Array[x];
				Array[x]=Array[x-1];
				Array[x-1]=intSwap;
				
				x--;
				intSwapCounter++;
			}
			
		}
	
		return Array;//Return Sorted array
	}
	
	
	
	public static int[] SelectionSort(int[] Array)//Selection Sort
	{
		//Variables
		int intSwap = 0;
		intSwapCounter = 0;
		
		//Function for selection sort
		for (int x=0; x<Array.length;x++)
		{
			for (int i= x+1;i<Array.length;i++)
			{
				if(Array[i]<Array[x])
				{
					intSwap=Array[x];
					Array[x]=Array[i];
					Array[i]=intSwap;
					intSwapCounter++;
				}
			}
		}
		
		return Array;//Return sorted array
	}
	
	
	public static int[] ShellSort(int[] Array)//Shell Sort 
	{
		//Variables
		int intTemp = 0;
		int j = 0;
		intSwapCounter = 0;
		
		//Function for Shell Sort
		for(int n = 0; n < Array.length; n++)
		{
			for(int i = n; i < Array.length; i++)
			{
				intTemp = Array[i]; 
				
				for(j = i; j >= n && Array[j - n] > intTemp; j-= n)
				{
					Array[j] = Array[j - n];
					intSwapCounter++;
				}
				
				Array[j] = intTemp;
				intSwapCounter++;
			}
		}
		
		return Array;
	}
	
	public static int[] HeapSort(int[] Array) //Heap Sort Array
	{
		//Variables
		int intLength = Array.length;
		intSwapCounter = 0;
		
		for(int k = intLength / 2; k > 0; k--) 
		{
			Array = downHeap(Array, k, intLength);//Calls DownHeap method
		}
		
		do
		{
			int T = Array[0];
			Array[0] = Array[intLength - 1];
			Array[intLength - 1] = T;
			intLength = intLength - 1;
			intSwapCounter++;
			Array = downHeap(Array, 1, intLength);
		}
		
		while(intLength > 1);
		{
			return Array;//Return Heap Sort array
		}
	}
	
	private static int[] downHeap(int[] Array, int k, int n) //Heap Sort Method
	{
		//Variables
		int z = Array[k - 1];
		
		while(k <= n / 2) 
		{
			int j = k + k;
			
			if((j < n) && (Array[j - 1] < Array[j]))
			{
				j++;
			}
			if(z >= Array[j - 1])
			{
				break;
			}
			else 
			{
				Array[k - 1] = Array[j - 1];
				k = j;
			}
		}
		
		Array[k - 1] = z;
		
		return Array;
	}
	
	public static int[] QuickSort(int[] Array)//Quick Sort Fuction
	{
		intSwapCounter=0;
		return QuickSort(Array,0,Array.length-1);
	}
	
	public static int[] QuickSort(int[] Array, int intLow, int intHigh)
	{
		//Variables
		int x=intLow;
		int i=intHigh;
		int j=Array[intLow+(intHigh-intLow)/2];
		int intTemp=0;
		
		while(x<=i)
		{
			while(Array[x]<j)
			{
				x++;
			}
			
			while(Array[i]>j)
			{
				i--;
			}
			
			if(x <= i) 
			{
				intTemp = Array[x];
				Array[x] = Array[i];
				Array[i] = intTemp;
				
				i--;
				x++;
				
				intSwapCounter++;
			}
		}
		
		if(intLow < i)
		{
			QuickSort(Array, intLow, i);
		}
		if(x < intHigh)
		{
			QuickSort(Array, x, intHigh);
		}
		return Array;
				
	}	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Sorting Styles for Descending
	
	public static int[] BubbleSortD(int[] Array) //Bubble Sort
	{
		//Variables
		intSwapCounter = 0;
		int intSwap = 0;
		
		//Function For Bubble Sort
		for(int x = 0; x < Array.length; x++)
		{
			for(int i = 0; i < Array.length - 1; i++)
			{
				if(Array[i] < Array[i + 1])//Change Arrow for Descending
				{
					intSwap = Array[i];
					Array[i] = Array[i + 1];
					Array[i + 1] = intSwap; 
					intSwapCounter++;
				}
			}
		}
		
		return Array; 
	}
	
	
	
	public static int[] SelectionSortD(int[] Array)//Selection Sort
	{
		//Variables
		int intSwap = 0;
		intSwapCounter = 0;
		
		for (int x=0; x<Array.length;x++)
		{
			for (int i= x+1;i<Array.length;i++)
			{
				if(Array[i]>Array[x])//change arrow for descending
				{
					intSwap=Array[x];
					Array[x]=Array[i];
					Array[i]=intSwap;
					intSwapCounter++;
				}
			}
		}
		
		return Array;
	}
	
	public static int[] InsertionSortD(int[] Array)//Insertion Sort
	{
		//Variables
		int intSwap=0;
		int x=0;
		intSwapCounter=0;
		
		for(int i=0;i<Array.length;i++)
		{
			x=i;
			
			while(x>0 && Array[x-1]<Array[x])//change arrow for descending
			{
				intSwap=Array[x];
				Array[x]=Array[x-1];
				Array[x-1]=intSwap;
				
				x--;
				intSwapCounter++;
			}
			
		}
	
		return Array;
	}
	
	
	public static int[] ShellSortD(int[] Array)//Shell Sort
	{
		//Variables
		int intTemp = 0;
		int j = 0;
		intSwapCounter = 0;
		
		for(int n = 0; n < Array.length; n++)
		{
			for(int i = n; i < Array.length; i++)
			{
				intTemp = Array[i]; 
				
				for(j = i; j >= n && Array[j - n] < intTemp; j-= n)//Change direction of second arrow for descending
				{
					Array[j] = Array[j - n];
					intSwapCounter++;
				}
				
				Array[j] = intTemp;
				intSwapCounter++;
			}
		}
		
		return Array;
	}
	
	public static int[] HeapSortD(int[] Array)//Heap Sort 
	{
		//Variables
		int intLength = Array.length;
		intSwapCounter = 0;
		
		for(int k = intLength / 2; k > 0; k--) 
		{
			Array = downHeapD(Array, k, intLength);
		}
		
		do 
		{
			int z = Array[0];
			Array[0] = Array[intLength - 1];
			Array[intLength - 1] = z;
			intLength = intLength - 1;
			intSwapCounter++;
			Array = downHeapD(Array, 1, intLength);
		} 
		while(intLength > 1);
		{
			return Array;
		}
	}
	
	private static int[] downHeapD(int[] Array, int k, int n) //Heap Sort Method
	{
		int z = Array[k - 1];
		
		while(k <= n / 2) 
		{
			int j = k + k;
			
			if((j < n) && (Array[j - 1] > Array[j]))//Changed direction of arrow for descending
			{
				j++;
			}
			if(z <= Array[j - 1])//Change
			{
				break;
			}
			else 
			{
				Array[k - 1] = Array[j - 1];
				k = j;
			}
		}
		
		Array[k - 1] = z;
		
		return Array;
	}
	
	public static int[] QuickSortD(int[] Array)//Quick Sort
	{
		intSwapCounter=0;
		return QuickSortD(Array,0,Array.length-1);
	}
	
	public static int[] QuickSortD(int[] Array, int intLow, int intHigh)//Quick Sort
	{
		//Variables
		int x=intLow;
		int i=intHigh;
		int j=Array[intLow+(intHigh-intLow)/2];
		int intintTemp=0;
		
		while(x<=i)
		{
			while(Array[x]>j)
			{
				x++;
			}
			
			while(Array[i]<j)///Changed arrow signs for descending
			{
				i--;
			}
			
			if(x <= i) 
			{
				intintTemp = Array[x];
				Array[x] = Array[i];
				Array[i] = intintTemp;
				
				i--;
				x++;
				
				intSwapCounter++;
			}
		}
		
		if(intLow < i)
		{
			QuickSortD(Array, intLow, i);
		}
		if(x < intHigh)
		{
			QuickSortD(Array, x, intHigh);
		}
		return Array;
				
	}	
	
	
}


