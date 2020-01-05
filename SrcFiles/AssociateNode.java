import java.util.ArrayList;
import java.util.LinkedList;

class AssociateNode{
  public Integer value;  
  public int location;
  public int associationMax;


  AssociateNode(int input, int ass){
	  value = input;
	  location = ass;
  }

    @Override
  public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof AssociateNode){
           if(((AssociateNode) v).value == this.value) {
        	  retVal = true;
           }
        }
     return retVal;
  }

    @Override
    public int hashCode() {
        return value;
    }
}