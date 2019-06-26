import java.util.Scanner;

public class Simpletron 
{
	private int accumulator; 
	private int [] memory;
	private int instructionRegister;
	private int instructionCounter;
	private int operationCode;	//指令左邊兩位
	private int operand;	//指令右邊兩位
	
	public Simpletron ( ) 
	{
		System.out.printf ("%s\n%s\n%s\n%s\n%s\n%s\n", 
			"*** Welcome to Simpletron! ***",
			"*** Please enter your program one instruction   ***",
			"*** (or data word) at a time. I will display    ***",
			"*** the location number and a question mark(?). ***",
			"*** You then type the word for that location.   ***",
			"*** Type -99999 to stop entering your program.  ***");
		memory = new int [100];	// initialise the array to hold the program's data 
		instructionCounter = 0;	// make the instruction pointer referrence the first data item
	}
	public void runSimulator () 
	{
		int submittedInstruction = 0;	// to hold the current instruction given by the user
		int memoryPointer = 0;	// to help us fill the contents of the memory well

		Scanner input = new Scanner ( System.in );
		do
		{
			System.out.printf ("%d %s  ", memoryPointer, "?" );
			submittedInstruction = input.nextInt ();
			if ( submittedInstruction != -99999 ) 
				memory [ memoryPointer ] = submittedInstruction;
			memoryPointer++;
			
		} while ( submittedInstruction != -99999 );
	    System.out.printf ("\n%s%s", "*** Program loading completed ***\n", 
				"*** Program excecution begins  ***\n");	
		
		// loop through the hundred instructions loading and executing each at a time
		while(1==1)
		{
			// System.out.println ("The value of memory location one is "+ code.getData () );
			// int sentinel = code.getData ();
			//if ( code != 0 )	// skip all the null instructions 
			//{
				//	dumpTheCore();
					instructionRegister=memory[instructionCounter];
					operationCode = instructionRegister/100;
					operand = instructionRegister%100;
					execute ( operand, operationCode );
					//dumpTheCore();
			//}
		}
	}
	public void execute (int operands, int operation ) 
	{
		//System.out.printf("exe\n");	
		switch ( operation ) 
		{
			case 10: // read
				Scanner input = new Scanner ( System.in );
				System.out.print ("Enter an integer: ");
				memory [ operands ] = input.nextInt ();
				break;
			case 11:	// write
				System.out.println ("result: " + memory [ operands] );
				break;
			case 20: // load
				accumulator = memory [ operands ];
				break;
			case 21: 	// store
				memory [ operands ] = accumulator;
				break;
			case 30: // add 
				accumulator += memory [ operands ];
				break;
			case 31: // sub
				accumulator -= memory [ operands ];
				break;
			case 32:	// divide
				accumulator /=  memory [ operands ];
				break;
			case 33: // multiply
				accumulator *= memory [ operands ];
				break;
			case 40:	// branch
				instructionCounter = operands;
				instructionCounter--;
				break;
			case 41:	// branchneg 
				if ( accumulator < 0 )
				{
					instructionCounter = operands;
					instructionCounter--;
				}
				break;
			case 42:	// branchzero
				if ( accumulator == 0 )
				{
					instructionCounter = operands;
					instructionCounter--;
				}
				break;
			case 43: 	// halt
				dumpTheCore();
				System.out.printf ("\n%s\n", "program ended");
				System.exit ( 0 );
				break;
		}
		instructionCounter++;
	}
	public void dumpTheCore ( )
	{
		System.out.printf ("\n%30s\n%30s\t%4d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n\n%30s\n", "REGISTERS:", 
				"accumulator", accumulator, "instruction counter", instructionCounter, "instruction register",
			       	instructionRegister, "operation code", operationCode, "operand", operand, "MEMORY:" );

		// display numbering for the memory cells in a horizontal order
		for ( int i = 0; i < 10; i++ )
		{
			System.out.printf ( "%6d", i);
		}

		System.out.println ();
		int counter = 0;	// counter to ensure that we go through the whole loop

		// display the memory cells themselves in both vertical and horizontal order
		for (int i = 0; i < 10; i++ ) 
		{
			if ( counter %10 == 0 )
				System.out.printf ("%2d ", counter);
			for (int j = 0; j < 10; j++) 
			{	
				// Lets apply some formatting to improve the display
				if ( memory [ counter ] == 0 )
					System.out.printf ( "%s%s", "+", "0000 ");
				else 
					System.out.printf ("%s%4d ", "+", memory [counter]);
				counter++;

			}
		System.out.println ();	
		}
	}
	public static void main ( String args [] ) 
	{
		Simpletron simulator = new Simpletron ( );
		simulator.runSimulator ();
	}
}
