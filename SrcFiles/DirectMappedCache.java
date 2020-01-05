import java.util.ArrayList;

public class DirectMappedCache {
	int CacheBlocks;
	int [] Cache;
	double missRate;
	double hitRate;
	double missTotal = 0;
	double hitTotal=0;
	double bTotal=0;
	
	DirectMappedCache(){
		//Default Value is 8
		CacheBlocks = 8;
		Cache = new int[CacheBlocks];
		for(int i =0; i<CacheBlocks;i++) {
			Cache[i]=-1;
		}
	}
	DirectMappedCache(int input){
		CacheBlocks = input;
		Cache = new int[CacheBlocks];
		for(int i =0; i<CacheBlocks;i++) {
			Cache[i]=-1;
		}
	}
	public boolean add(int numberToAdd) {
		++bTotal;
		int remainder = numberToAdd%CacheBlocks;
		if(Cache[remainder]==numberToAdd) {
			++hitTotal;
			return true;
		}
		else {
			++missTotal;
			Cache[remainder]=numberToAdd;
			return true;
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
		for(int i = 0; i<CacheBlocks; i++) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Address of Memory Block "+i+" is: "+Cache[i]);
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("The miss ratio is : "+missRate());
		System.out.println("----------------------------------------------------------------");
		System.out.println("The hit ratio is: "+hitRate());
	}
	
}
