import java.util.*;
import java.lang.*;
import java.io.*;

public class LiarLiar {

    
    public static void main(String[] args){


	String filename = args[0];

	int n = 0;


	try{


	    FileInputStream fstream = new FileInputStream(filename);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine;
	    int counter = 0;
	    
	    while ((strLine = br.readLine()) != null){
		
		if (counter == 0){
		    n = Integer.parseInt(strLine);
		}
		else
		    System.out.println(strLine);   


		    }// end while 
	
	    catch(Exception e){


	    }




    }


    






} 