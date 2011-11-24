import java.io.*;
import java.util.*;
import java.lang.*;



public class HoppityHop{

    public static void main(String[] args){

	if(args.length == 0){
	    System.out.println("Please Enter Filename as Command Line Argument");
	}

	String filename = args[0];
	int numLines = 0;

       System.out.println("Reading Inputs From File: " + filename);
       try{

	    FileInputStream fstream = new FileInputStream(filename);

	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine;

	    int counter = 0;
	
	    while((strLine = br.readLine()) != null){

		if(counter == 0){
		    numLines = Integer.parseInt(strLine);
		}

	    }// end while

	    in.close();

	}

	catch(Exception e){

	    System.err.println("Error: "+ e.getMessage());
	    
	}

	System.out.println("The input integer: "+ numLines );
	
	
	for(int i = 1; i <= numLines; i++){


	    if(i%3 == 0 && i%5 != 0 ){
		
		System.out.println("Hoppity");
	    }
	    
	    if(i%5 == 0 && i%3 != 0){
		
		System.out.println("Hophop");

	    }

	    if(i%3 == 0 && i%5 == 0){
		
		System.out.println("Hop");

	    }

		



	}

	
    

    }



}