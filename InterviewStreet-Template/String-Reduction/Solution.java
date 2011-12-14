import java.io.*;
import java.util.*;

public class Solution{


    //    public static void solve(BufferedReader br){
    public static void solve(String filename){
	try{
	    
	    FileInputStream fstream = new FileInputStream(filename);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    

	    String[] parameters = br.readLine().trim().split("\\s+");

	    final int N = Integer.parseInt(parameters[0]);

	    final int K = Integer.parseInt(parameters[1]);

	    int[] initialPosition = new int[N+1];

	    String[] initialPositionStringArray = br.readLine().trim().split("\\s+");
	    
	    initialPosition[0] = 0;
	    
	    for(int i = 1; i <= initialPositionStringArray.length; i++){
		initialPosition[i] = Integer.parseInt(initialPositionStringArray[i-1]);
	    }
	  
	    int[] finalPosition = new int[N+1];
	    String[] finalPositionStringArray = br.readLine().trim().split("\\s+");

	    finalPosition[0] = 0;
	    
	    for(int i = 1; i <= finalPositionStringArray.length; i++){

		finalPosition[i] = Integer.parseInt(finalPositionStringArray[i-1]);

	    }

		
		/*
		  Aha! Moment: In the question they state that there is always a solution less than
		  7 steps. For 3-peg M(n,3) = 2^n - 1 mimimum steps, with k(n,3) = K(n,3) = n - 1 For All n>= 1

		  M = 2^3 - 1 = 7
		  M = 2^2 - 1 = 3

		  This implies for n = 1,2 for all 3-peg problems
		  k = 0, 1.



		 */



	    }

	    


	}catch(Exception e){
	    
	    System.err.println("Error: "+ e.getMessage());


	}


    }


    }





    public static void main(String[] args){

	try{
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    // solve(br);
	    solve(args[0]);
	}catch(Exception e){
	    
	    System.err.println("Error: "+ e.getMessage());

	}

    }


}
