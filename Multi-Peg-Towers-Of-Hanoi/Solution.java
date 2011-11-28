import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution{


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

	    // Boundary Cases
	    if(N == 0){

		System.out.println(0);
		return;
		

	    }else if(N == 1){

		System.out.println(1);
		//	hanoi(one,start,finish,using);
		return;



	    }
		
		System.out.println("");
		/*
		  Aha! Moment: In the question they state that there is always a solution less than
		  7 steps. For 3-peg M(n,3) = 2^n - 1 mimimum steps, with k(n,3) = K(n,3) = n - 1 For All n>= 1

		  M = 2^3 - 1 = 7
		  M = 2^2 - 1 = 3

		  This implies for n = 1,2 for all 3-peg problems
		  k = 0, 1.



		 */



	    if(K == 3){

		int minimumSteps = (int)Math.pow(2,N) - 1;
		
		System.out.println(minimumSteps);
		hanoi(N,1,2,3);


	    }


	    /*

	      For Complete Solution See:

	      Generalized Multi-Peg Tower of Hanoi Problem
	      By: A. A. K. Majumdar

	      


	     */
	    else if(K >= 4){

		int m;
		/*

		  Hmsubn = (2m-5)(Math.pow(2,n/m-2-1)) if i = 0
		  
		  Hmsubn = (2i-1)(Math.pow(2,n-i/m-2) + (2m-5)(Math.pow(2,(n-i)/(m-2)) -1) i not 0

		  i = n%(m-2)

		  n disks to peg m with H^m sub n.

		  If n < m then HMsubn = 2n - 1


		 */



	    }

	    


	}catch(Exception e){
	    
	    System.err.println("Error: "+ e.getMessage());


	}


    }

    public static void hanoi(int N, int Start, int To, int Using){

	if(N == 1){

      	    System.out.println(Start + " " + To );
	}
	else{

	    hanoi(N-1,Start,Using,To);
	    hanoi(1, Start, To, Using);
	    hanoi(N-1,Using, To, Start);

	}



    }





    public static void main(String[] args){

	String filename = args[0];
	solve(filename);




    }












}