import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class ThreeWayAssociativeCache implements Comparator<AssociateNode> {
	final static int ASSLEVEL = 3;
	int CacheBlocks;
	ArrayList<LinkedList<AssociateNode>> Cache;
	double missRate;
	double hitRate;
	double missTotal = 0;
	double hitTotal=0;
	double bTotal=0;
	//Fill 
	ThreeWayAssociativeCache(){
		//Default Value is 8
		CacheBlocks = 8;
		Cache = new ArrayList<LinkedList<AssociateNode>>(8);
		for(int i =0; i<CacheBlocks;i++) {
			LinkedList<AssociateNode> temp = new LinkedList<AssociateNode>();
			for(int j =0; j<ASSLEVEL;j++) {
				temp.add(new AssociateNode(-1,j));
			}
			Cache.add(i, temp);
		}
	}
	ThreeWayAssociativeCache(int input){
		CacheBlocks = input;
		Cache = new ArrayList<LinkedList<AssociateNode>>(input);
		for(int i =0; i<CacheBlocks;i++) {
			LinkedList<AssociateNode> temp = new LinkedList<AssociateNode>();
			for(int j =0; j<ASSLEVEL;j++) {
				temp.add(new AssociateNode(-1,ASSLEVEL-1-j));
			}
			Cache.add(i, temp);
		}
	}
	public void add(int numberToAdd) {
		++bTotal;
		int remainder = numberToAdd%CacheBlocks;
		LinkedList<AssociateNode> tempList = Cache.get(remainder);
		boolean nodeFound=false;
		int index=0;
		int location=-1;
		for(AssociateNode e: tempList) {
			
			if(numberToAdd==e.value) {
				nodeFound = true;
				location = e.location;
				break;
			}
			index++;
		}
		if(nodeFound==true) {
			hitTotal++;
			tempList.remove(index);
			tempList.addFirst(new AssociateNode(numberToAdd,location));
		}
		else {
			missTotal++;
			location = tempList.getLast().location;
			tempList.removeLast();
			tempList.addFirst(new AssociateNode(numberToAdd,location));
		}
		
	}
	public double missRate() {
		missRate = missTotal/bTotal;
		return missRate;
	}
	public double hitRate()	{
		hitRate = hitTotal/bTotal;
		return hitRate;
	}
	public void print() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i<CacheBlocks; i++) {
			LinkedList<AssociateNode> printList = Cache.get(i);
			AssociateNode currentNode;

			System.out.print("Cache Block: "+i);
			for(int j =0;j<ASSLEVEL;j++) {
				for(AssociateNode e: printList) {
					if(e.location == j) {
					System.out.print("   Set:  "+j+"   Block Address: "+e.value);
					break;
					}
				}
			}
			System.out.println("\n"+"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The miss ratio is : "+missRate());
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("The hit ratio is: "+hitRate());
	}
	@Override
	public int compare(AssociateNode o1, AssociateNode o2) {
		if(o1.value == o2.value)
			return 0;
		else if (o1.value > o2.value) {
			return 1;
		}
		else return -1;
	}
	
}


