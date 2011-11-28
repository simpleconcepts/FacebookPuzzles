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

	    if(K == 3){

		int minimumSteps = (int)Math.pow(2,N) - 1;
		
		System.out.println(minimumSteps);
		hanoi(N,1,2,3);


	    }
	    else if(K >= 4){

	     



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