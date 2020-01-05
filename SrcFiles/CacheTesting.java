import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CacheTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		Scanner input = new Scanner(System.in);
		boolean goFlag =true;
		ThreeWayAssociativeCache runningThree;
		TwoWayAssociativeCache runningTwo;
		DirectMappedCache running;
		FourWayAssociativeCache runningFour;
		FullyAssociative runningFully;
		while(goFlag) {
			
			int cacheInput;
			int assType;
			Integer currentBlock;
			System.out.print("Number of cache blocks?: ");
			cacheInput = inputStuff(input);
			FourWayAssociativeCache dCache = new FourWayAssociativeCache(cacheInput);
			System.out.print("Set associativity option : 1 for Simple, 2 for 2/way associative, 3 for 3/way associative, 4 for 4/way associative, 5 for fully associative, -1 to end program");
			assType = inputStuff(input);
			switch(assType) {
				case 1:
					running = new DirectMappedCache(cacheInput);
					System.out.println("Direct Cache Selected:");
					System.out.println("Please input Block Addresses, input -1 when done");
					cacheInput = inputStuff(input);
					while(cacheInput!=-1) {
						running.add(cacheInput);
						System.out.println("Block Address ["+cacheInput+"] entered, Input another Block Address, or -1 when done");
						cacheInput = inputStuff(input);
						
					}
					running.print();
					break;
				case 2:
					runningTwo = new TwoWayAssociativeCache(cacheInput);
					System.out.println("Two Way Associative Cache Selected:");
					System.out.println("Please input Block Addresses, input -1 when done");
					cacheInput = inputStuff(input);
					while(cacheInput!=-1) {
						runningTwo.add(cacheInput);
						System.out.println("Block Address ["+cacheInput+"] entered, Input another Block Address, or -1 when done");
						cacheInput = inputStuff(input);
						
					}
					runningTwo.print();
					break;
				case 3:
					runningThree = new ThreeWayAssociativeCache(cacheInput);
					System.out.println("Three Way Associative Cache Selected:");
					System.out.println("Please input Block Addresses, input -1 when done");
					cacheInput = inputStuff(input);
					while(cacheInput!=-1) {
						runningThree.add(cacheInput);
						System.out.println("Block Address ["+cacheInput+"] entered, Input another Block Address, or -1 when done");
						cacheInput = inputStuff(input);
						
					}
					runningThree.print();
					break;
				case 4:
				    runningFour = new FourWayAssociativeCache(cacheInput);
					System.out.println("Four Way Associative Cache Selected:");
					System.out.println("Please input Block Addresses, input -1 when done");
					cacheInput = inputStuff(input);
					while(cacheInput!=-1) {
						runningFour.add(cacheInput);
						System.out.println("Block Address ["+cacheInput+"] entered, Input another Block Address, or -1 when done");
						cacheInput = inputStuff(input);
						
					}
					runningFour.print();
					
					break;
				default:
					 runningFully = new FullyAssociative(cacheInput);
						System.out.println("Fully Associative Cache Selected:");
						System.out.println("Please input Block Addresses, input -1 when done");
						cacheInput = inputStuff(input);
						while(cacheInput!=-1) {
							runningFully.add(cacheInput);
							System.out.println("Block Address ["+cacheInput+"] entered, Input another Block Address, or -1 when done");
							cacheInput = inputStuff(input);
							
						}
						runningFully.print();
						
					break;		
			}
			System.out.println("\nReset\n ");
	
		}
		System.out.println("PROGRAM ENDED");
	}
	
	public static int inputStuff(Scanner input) {
		boolean flag =true;
		int value=0;
		do {
			try {
				value = input.nextInt();
				flag = false;
			}
			catch(InputMismatchException ex) {
				System.out.println("Input Type Mismatch");
				input.nextLine();
			}
		}while(flag);
		
		return value;
		
	}

}
	


