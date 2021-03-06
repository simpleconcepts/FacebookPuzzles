import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Solution {

    public class Balance{
	public int balanceNumber;
	public int leftNeighborWeight;
	public int rightNeighborWeight;
	public int leftNeighbor;
	public int rightNeighbor;
	public boolean hasRightNeighbor;
	public boolean hasLeftNeighbor;
	    
	// empty graph with V vertices
	public Balance() {
	    this.balanceNumber = Integer.MAX_VALUE;
	    this.leftNeighborWeight = 0;
	    this.rightNeighborWeight = 0;
	    this.leftNeighbor = Integer.MAX_VALUE;
	    this.rightNeighbor = Integer.MAX_VALUE;
	    this.hasRightNeighbor = false;
	    this.hasLeftNeighbor = false;
	}
	
	
    }
    
    public static void printBalances(Balance[] balances){
	
	for(int i = 0; i < balances.length; i++){
	    
	    System.out.println(balances[i].balanceNumber);
	}

	
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	try{
	            
	    FileInputStream fstream = new FileInputStream("balances/input00.txt");

	    DataInputStream in = new DataInputStream(fstream);
	            
	    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));

	    int TestCases = Integer.parseInt(br.readLine().trim());
	            
	    System.out.println("Number of Test Cases: "+TestCases);

	    Balance[] balances = new Balance[TestCases];
	        
	    for(int i = 0; i < TestCases; i++){
		balances[i].balanceNumber = i;
		
		for(int j = 0; j < 2; j++){
		    
		    // String[] splitstring = br.readLine().split("\\s+");
		    String str = br.readLine();
		    StringTokenizer splitstring = new StringTokenizer(str);
		    if(splitstring.countTokens() == 1 && j == 0){
			balances[i].leftNeighborWeight = Integer.parseInt(splitstring.nextToken());
		    }
		    else if(splitstring.countTokens() == 1 && j == 1){
			balances[i].rightNeighborWeight = Integer.parseInt(splitstring.nextToken());
			
		    }
		    else if(splitstring.countTokens() == 2 && j == 0){
			balances[i].hasLeftNeighbor = true;
			String dummy = splitstring.nextToken();
			balances[i].leftNeighbor = Integer.parseInt(splitstring.nextToken());

		    }
		    else if(splitstring.countTokens() == 2 && j == 1){
			balances[i].hasRightNeighbor = true;
			String dummy = splitstring.nextToken();
			balances[i].rightNeighbor = Integer.parseInt(splitstring.nextToken());
		    }
		    
		        
		}
		    
		
		
		Solution.printBalances(balances);
		
		
	    }
	       
	}catch(Exception e){

	    System.err.println("Error: " + e.getMessage());

	}
	
	
    }

}
