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

	  

	}catch(Exception e){
	    
	    System.err.println("Error: "+ e.getMessage());


	}


    }





    public static void main(String[] args){

	String filename = args[0];
	solve(filename);




    }












}