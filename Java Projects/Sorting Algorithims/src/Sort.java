/*Name:Bavalan Thangarajah
 *Title:Sort
 *Purpose:To learn how to use GUI and different sorting algorithms
 */

//Helps utilizes some functions
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;;
public class Sort 
{
	//Variables
	
		//Labels
		static JLabel lblAlgorithm;
		static JLabel lblAmount; 
		static JLabel lblSwapCount; 
		static JLabel lblSearch;
		static JLabel lblFound;
		static JLabel lblOrder;
		
		//Text boxes 
		static JTextField txtAmount; 
		static JTextField txtSearch;
		
		//Buttons 
		static JButton btnGenRandoms;
		static JButton btnSort; 
		static JButton btnSearch;
		
		//Lists 
		static DefaultListModel lstRandom;
		static DefaultListModel lstSorted; 
		static JList lstRandomList;
		static JList lstSortedList;
		
		//Radio Button Groups
		static ButtonGroup SortGroup;//Button Group for sorting
		static ButtonGroup SearchGroup;//Button Group for searching values
		static ButtonGroup OrderGroup;//Button Group for the order you would like it to be sorted
		
		//Radio Buttons 
		static JRadioButton radBubbleSort;
		static JRadioButton radSelectionSort;
		static JRadioButton radInsertionSort;
		static JRadioButton radQuickSort;
		static JRadioButton radShellSort;
		static JRadioButton radHeapSort;
		static JRadioButton radBinarySearch; 
		static JRadioButton radAscending;
		static JRadioButton radDescending; 
		
		//other Panels
		static JPanel Panel; //main Panel 
		static JPanel SearchPanel;//Search Panel
		static JPanel GenPanel;//Random Number Generating Panel
		static JPanel SortPanel;//Sorting Panel
		
		public static void main(String[] args) //Runs the GUI
		{
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() 
			{
				public void run()
				{
					runGUI();
				}
			});
		}
		
		static void runGUI()
		{
			//Create the Main Frame 
			JFrame Frame = new JFrame("");
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Allows the program to close
			
			Frame.setTitle("Sorting Routines");//Title of the frame
			
			//Create the Panels 				
			//Boundaries of main panel
			Panel = new JPanel(); 
			Panel.setLayout(new GridLayout(5, 2));
			Panel.setLayout(new BoxLayout(Panel, 1));
			
			//Boundaries of Sorting panel
			SortPanel = new JPanel();
			SortPanel.setLayout(new GridLayout(7,0));
			
			//Boundaries of Generating panel
			GenPanel = new JPanel();
			GenPanel.setLayout(new GridLayout(1,0,5,5));
			
			//Create of Search panel
			SearchPanel = new JPanel();
			
			
			//Create the controls 
			//Buttons 
			btnGenRandoms = new JButton("Generate Random Numbers");
			btnGenRandoms.setActionCommand("Create");//Allows users to use this button
			
			btnSort = new JButton("Sort Numbers");
			btnSort.setActionCommand("Sort");//Allows users to use this button
			
			btnSearch = new JButton("Search");
			btnSearch.setActionCommand("Search");//Allows users to use this button
			
			//Labels
			lblAlgorithm = new JLabel("Sorting Algorithm:");
			lblAmount = new JLabel("Amount of numbers Created and Sorted: ");
			lblSwapCount = new JLabel("Swap Count: 0");
			lblSearch = new JLabel("Search: ");
			lblFound = new JLabel("");
			lblOrder = new JLabel("Order:");
			
			//Textbox
			txtAmount = new JTextField();
			txtAmount.setColumns(10);//Helps set the number of columns in these textboxes
			txtSearch = new JTextField();
			txtSearch.setColumns(10);//Helps set the number of columns in these textboxes
			
			//ListBox
			lstRandom = new DefaultListModel();
			lstSorted = new DefaultListModel();
			lstRandomList = new JList(lstRandom);
			lstSortedList = new JList(lstSorted);
			lstRandomList.setVisibleRowCount(10);//Allows users to see the Lists
			lstSortedList.setVisibleRowCount(10);//Allows users to see the Lists
			
			
			//Radio Buttons 
			radBubbleSort = new JRadioButton("Bubble Sort", true);//This button is pre-selected rest are false
			radInsertionSort = new JRadioButton("Insertion Sort", false);
			radSelectionSort = new JRadioButton("Selection Sort", false);
			radShellSort = new JRadioButton("Shell Sort", false);
			radHeapSort = new JRadioButton("Heap Sort", false);
			radQuickSort = new JRadioButton("Quick Sort", false);
			
			radBinarySearch = new JRadioButton("Binary Search", false);
			
			radAscending=new JRadioButton("Ascending",true);//This button is pre-selected rest are false
			radDescending=new JRadioButton("Descending",false);
			
			//Setup Event handlers 
			ButtonHandler btnHandler = new ButtonHandler();
			btnGenRandoms.addActionListener(btnHandler);//If user chooses this button got to the button handler function
			btnSort.addActionListener(btnHandler);//If user chooses this button got to the button handler function
			btnSearch.addActionListener(btnHandler);//If user chooses this button got to the button handler function
			
			//Setup sub Panels
			//Button Group for search
			SearchGroup = new ButtonGroup();
			SearchGroup.add(radBinarySearch);
			
			//Button Group for sort
			SortGroup = new ButtonGroup();
			SortGroup.add(radBubbleSort);
			SortGroup.add(radInsertionSort);
			SortGroup.add(radSelectionSort);
			SortGroup.add(radShellSort);
			SortGroup.add(radQuickSort);
			SortGroup.add(radHeapSort);
			
			//Button Group for order
			OrderGroup = new ButtonGroup();
			OrderGroup.add(radAscending);
			OrderGroup.add(radDescending);
			
			//Add these to the sort panel
			SortPanel.add(lblAlgorithm);			
			SortPanel.add(new JPanel());
			SortPanel.add(new JPanel());
			SortPanel.add(radBubbleSort);
			SortPanel.add(radInsertionSort);
			SortPanel.add(radSelectionSort);
			SortPanel.add(radShellSort);
			SortPanel.add(radHeapSort);
			SortPanel.add(radQuickSort);
		
			SortPanel.add(lblOrder);
			SortPanel.add(new JPanel());
			SortPanel.add(new JPanel());
			SortPanel.add(radAscending);
			SortPanel.add(radDescending);
			SortPanel.add(new JPanel());
			
			SortPanel.add(lblAmount);
			SortPanel.add(txtAmount);
			SortPanel.add(new JPanel());
			SortPanel.add(btnGenRandoms);
			SortPanel.add(btnSort);
		
			//Add this to Search Panel
			SearchPanel.add(lblSearch);
			SearchPanel.add(txtSearch);
			SearchPanel.add(lblFound);
			SearchPanel.add(btnSearch);
			SearchPanel.add(radBinarySearch);
			SortPanel.add(SearchPanel);//Add search Panel to Sort Panel
			
			//Add to generation Panel	
			GenPanel.add(new JPanel());
			GenPanel.add(lblSwapCount);
			
			JPanel[] lstPanel = { new JPanel(), new JPanel() };
			lstPanel[0].add(lstRandomList);//Add Random list to list panel[0]
			lstPanel[1].add(lstSortedList);//Add Sort list to list panel[1]
			
			lstPanel[0].setLayout(new GridLayout(1, 1));//Dimensions of panel
			lstPanel[1].setLayout(new GridLayout(1, 1));//Dimensions of panel
			
			//Create a scroll for both panels
			JScrollPane listScroll = new JScrollPane(lstRandomList);
			JScrollPane listScroll2 = new JScrollPane(lstSortedList);
			
			//Add list to generation panel
			GenPanel.add(listScroll);
			GenPanel.add(listScroll2);
			GenPanel.add(lstPanel[0]);
			GenPanel.add(lstPanel[1]);
			
			//Add sub-panels to main panel
			Panel.add(SortPanel);
			Panel.add(GenPanel);
			
			//Finish Frame / Panels
			Frame.add(Panel);
			Frame.setSize(748, 680);
			Frame.setVisible(true);
		}
//*******************************************************************************************************************************************		
		static class ButtonHandler implements ActionListener//If user enters a button
		{
			public void actionPerformed(ActionEvent e)
			{
				String strAction = e.getActionCommand();
				
				if(strAction.equals("Create"))//If user clicks button to create a random number
				{
					int intRandom=0;
					int intInput=Integer.parseInt(txtAmount.getText());//Get users input for the numbers they would like to be generated
					
					//Clear Both Lists
					lstRandom.clear();
					lstSorted.clear();
					
					for(int x=0; x<intInput; x++)//Loops until it reaches user entry
					{
						intRandom=((int)(Math.random() * 2000) - 1000);//Randomizes numbers between -1000 to 1000
						lstRandom.addElement(intRandom);	
					}
				}
				
				else if(strAction.equals("Sort"))//If user clicks sort button
				{
					if(lstRandom.getSize()>0)//If the Random List has more than 0 numbers
					{
						lstSorted.clear();//Clear sort list
						int[] intUnSorted = new int[lstRandom.getSize()];
						
						for(int x = 0; x < lstRandom.getSize(); x++)//Displays the same numbers in Random List
						intUnSorted[x] = Integer.parseInt(lstRandom.get(x) + "");//Converts numbers to string
						
						//If the user chooses a sorting style and Ascending Option Displays it sorted ascending
						if(radBubbleSort.isSelected()&&radAscending.isSelected())
						{
							Styles.BubbleSort(intUnSorted);//Gets it from Style Class
						}
						
						else if(radInsertionSort.isSelected()&&radAscending.isSelected())
						{
							Styles.InsertionSort(intUnSorted);//Gets it from Style Class
						}
						
						
						else if(radSelectionSort.isSelected()&&radAscending.isSelected())
						{
							Styles.SelectionSort(intUnSorted);//Gets it from Style Class
						}
					
						
						else if(radShellSort.isSelected()&&radAscending.isSelected())
						{
							Styles.ShellSort(intUnSorted);//Gets it from Style Class
						}
						
						else if(radHeapSort.isSelected()&&radAscending.isSelected())
						{
							Styles.HeapSort(intUnSorted);//Gets it from Style Class
						}
						
						else if(radQuickSort.isSelected()&&radAscending.isSelected())
						{
							Styles.QuickSort(intUnSorted);//Gets it from Style Class
						}
//******************************************************************************************************************************************						
						//If the user chooses a sorting style and Descending Option Displays it sorted descending

						else if(radBubbleSort.isSelected()&&radDescending.isSelected())
						{
							Styles.BubbleSortD(intUnSorted);//Gets it from Style Class
						}
						
						else if(radInsertionSort.isSelected()&&radDescending.isSelected())
						{
							Styles.InsertionSortD(intUnSorted);//Gets it from Style Class
						}
						
						else if(radSelectionSort.isSelected()&&radDescending.isSelected())
						{
							Styles.SelectionSortD(intUnSorted);//Gets it from Style Class
						}
						
						
						else if(radShellSort.isSelected()&&radDescending.isSelected())
						{
							Styles.ShellSortD(intUnSorted);//Gets it from Style Class
						}
						
						else if(radHeapSort.isSelected()&&radDescending.isSelected())
						{
							Styles.HeapSortD(intUnSorted);//Gets it from Style Class
						}
						
						else if(radQuickSort.isSelected()&&radDescending.isSelected())
						{
							Styles.QuickSortD(intUnSorted);//Gets it from Style Class
						}
						
						for(int x = 0; x < intUnSorted.length; x++)
						{	
							lstSorted.addElement(intUnSorted[x]);
							lblSwapCount.setText("Swap Count: " + Styles.intSwapCounter);
						}
						
					}	
					
				}
				else if (strAction.equals("Search"))//If user chooses the search button
				{
					if(lstSorted.getSize() > 0)//If the list is greater than 0
					{ 
						int[] intSearch = new int[lstSorted.getSize()];
						for(int x = 0; x < lstSorted.getSize(); x++)
							intSearch[x] = Integer.parseInt(lstSorted.get(x) + "");
						
						int intIndex = -1;
						
						if(radBinarySearch.isSelected()&&radAscending.isSelected()) //If radBinary is selected
						{
							intIndex = Search.BinarySearch(intSearch, Integer.parseInt(txtSearch.getText()));	//Display information from the search class
					
							if(intIndex == -1)
							{
								lblFound.setText("NOT FOUND");
							}
							
							else
							{
								lblFound.setText("INDEX: " + intIndex);//Shows the index
								
							}
						}
						
						else if(radBinarySearch.isSelected()&&radDescending.isSelected()) //If radBinary is selected
						{
							lblFound.setText("Ascending Searches Only!!");//Display message when user chooses descending
						}
						
					}	
					
				}
			}
		}
	}
	