import java.io.*;
import java.lang.*;
import java.util.*;

public class InputParser{

    public static Interval1D[] generateIntervalsFromFile(String filename){

	Interval1D[] intervals = null;
	
	/* Read Text File From File */
	
	try{
	    /* Open File */
	    FileInputStream fstream = new FileInputStream(filename);

	    /* Get The Object of DataInputStream   */

	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	   
	    final int lengthOfDNA = Integer.parseInt(br.readLine().trim());
	    System.out.println("Length: "+lengthOfDNA);
	    boolean DNA_STRING_COMPLETE = false;
	    
	    String DNA_STRING;
	    char[] DNA_CHARS = new char[lengthOfDNA];
	    char[] local_DNA_CHARS;
	    DNA_STRING = br.readLine().trim();
	    int linesOfDNA = lengthOfDNA/80;
	    System.out.println("Lines of DNA: "+ linesOfDNA + 1);
	    String localLine;
	    
	    for(int i = 0; i < linesOfDNA; i++){
		localLine = br.readLine().trim();
		DNA_STRING = DNA_STRING + localLine;
	     }
	    System.out.println("Final Length: "+ DNA_STRING.length());
	    System.out.println("DNA: "+DNA_STRING);

	    final int numberOfIntervals = Integer.parseInt(br.readLine().trim());
	    System.out.println("Number of Intervals: "+ numberOfIntervals);
	    intervals = new Interval1D[numberOfIntervals];
	    Interval1D localInterval;
	    String[] triple;
	    String inputString;
	    for(int i = 0; i < numberOfIntervals; i++){
       		inputString = br.readLine().trim();
		triple = inputString.split("\\s+");
		String leftEndPoint = new String(triple[0]);
		String rightEndPoint = new String(triple[1]);
		String weight = new String(triple[2]);
		localInterval = new Interval1D(Double.parseDouble(leftEndPoint),Double.parseDouble(rightEndPoint),Double.parseDouble(weight));
		intervals[i] = localInterval;

		
		}
	    
	    	    StdOut.println("Sort by right endpoint");
	       Arrays.sort(intervals, Interval1D.RIGHT_ENDPOINT_ORDER);
	      for (int i = 0; i < intervals.length; i++)
		StdOut.println(intervals[i]);
	    StdOut.println();
	    

	}

	catch(Exception e){//Catch exception if any
	    
	    System.err.println("Error: " + e.getMessage());

	}





	return intervals;

    }






}