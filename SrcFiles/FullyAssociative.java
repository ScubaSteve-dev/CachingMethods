import java.util.Comparator;
import java.util.LinkedList;

public class FullyAssociative implements Comparator<AssociateNode> {
	final static int CacheBlocks = 1;
	LinkedList<AssociateNode> Cache = new LinkedList<AssociateNode>();
	double missRate;
	double hitRate;
	double missTotal = 0;
	double hitTotal=0;
	double bTotal=0;
	int AssLevel ;
	//Fill 
	FullyAssociative(){
		//Default Value is 8
		AssLevel = 8;
			for(int j =0; j<AssLevel;j++) {
				Cache.add(new AssociateNode(-1,j));
			}
	}
	FullyAssociative(int input){
		AssLevel = input;
			for(int j =0; j<AssLevel;j++) 
				Cache.add(new AssociateNode(-1,AssLevel-1-j));
	}
	public void add(int numberToAdd) {
		++bTotal;
		boolean nodeFound=false;
		int index=0;
		int location=-1;
		for(AssociateNode e: Cache) {
			
			if(numberToAdd==e.value) {
				nodeFound = true;
				location = e.location;
				break;
			}
			index++;
		}
		if(nodeFound==true) {
			hitTotal++;
			Cache.remove(index);
			Cache.addFirst(new AssociateNode(numberToAdd,location));
		}
		else {
			missTotal++;
			location = Cache.getLast().location;
			Cache.removeLast();
			Cache.addFirst(new AssociateNode(numberToAdd,location));
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
			System.out.println("----------------------------------------------------------------");
			for(int j =0;j<AssLevel;j++) {
				for(AssociateNode e: Cache) {
					if(e.location == j) {
					System.out.println(" Set  "+j+" Block Address : "+e.value);
					break;
					}
				}
			}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("The miss ratio is : "+missRate());
		System.out.println("----------------------------------------------------------------");
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


