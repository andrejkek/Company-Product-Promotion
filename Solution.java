import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int codeListCount = Integer.parseInt(in.nextLine());

		ArrayList<String> codeList = new ArrayList<String>();
        for(int i =0; i<codeListCount; i++) {
	        String codeListItem = in.nextLine();
		    codeList.add(codeListItem);
	        
        }
 
        int shoppingCartCount = Integer.parseInt(in.nextLine());

        ArrayList<String> shoppingCart = new ArrayList<String>();

        for (int i = 0; i < shoppingCartCount; i++)
        {
            String shoppingCartItem = in.next();
            shoppingCart.add(shoppingCartItem);
        }

        int foo = Foo.IsBuyerWinner(codeList, shoppingCart);

        System.out.println(foo);

	}

}
