import java.util.ArrayList;

public class Foo {
	public static int IsBuyerWinner(ArrayList<String> codeList, ArrayList<String> shoppingCart){
		//time complexity: O(n*m)
		//if the secret code list is empty, buyer wins
		if (codeList.size()==0) return 1;
		ArrayList<ArrayList<String>> copy = new ArrayList<ArrayList<String>>();
		for(int i = 0; i<codeList.size(); i++) {
			String[] row = codeList.get(i).split(" ");
			ArrayList<String> rowList = new ArrayList<String>();
			
	        for (String element : row) {
	            rowList.add(element);
	        }
			copy.add(rowList);
		}
		
		int shoppingCartSize=shoppingCart.size();
		int j=0, k=0, reset=-1;

		//here we go through the shopping cart
		for(int i=0;i<shoppingCartSize;i++){
			int groupSize=copy.get(j).size();
		    //if its a match...
		    if(shoppingCart.get(i).equals(copy.get(j).get(k)) || copy.get(j).get(k).equals("anything")){
		    	//we made a variable reset so that we can go back to an item if our current streak is broken
		        //we only need the reset to set to an i once, so thats why we have an if statement here
		        if (reset==-1) reset=i+1;
		        	k++;
		            if (k==groupSize){
		            	j++;
		                k=0;
		                //if we passed all the groups, we return true as the code has a perfect match
		                if (copy.size()==j) return 1;
		            }
		            continue;
		        }
		        else{
		        	k=0;
		            //sort of a failsafe, so it never gets caught in an infinite loop
		            if (i==shoppingCartSize-1) break;
		            //here we reset the i to "reset", if our current streak breaks, so it picks up right after the point the current streak started
		            if (reset!=-1){
		                i=reset;
		                reset=-1;
		            }
		        }
		    }
		    return 0;
		}
}
