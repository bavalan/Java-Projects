import java.util.*;
public class Cards 
{

	public static void main(String[] args)
	{
		Stack stk= new Stack();
		
		for (int x=2;x<11;x++)
		{
			stk.add(x+" of Clubs");
			stk.add(x+" of Spades");
			stk.add(x+" of Hearts");
			stk.add(x+" of Diamonds");
		}
		
		stk.add("Jack of Clubs");
		stk.add("Jack of Spades");
		stk.add("Jack of Hearts");
		stk.add("Jack of Diamonds");
		
		stk.add("Queen of Clubs");
		stk.add("Queen of Spades");
		stk.add("Queen of Hearts");
		stk.add("Queen of Diamonds");
		
		stk.add("King of Clubs");
		stk.add("King of Spades");
		stk.add("King of Hearts");
		stk.add("King of Diamonds");
		
		stk.add("Ace of Clubs");
		stk.add("Ace of Spades");
		stk.add("Ace of Hearts");
		stk.add("Ace of Diamonds");
		
		
		for (int x=0;x<52;x++)
		{
			System.out.println(stk.peek());
		}
		
	}

}
