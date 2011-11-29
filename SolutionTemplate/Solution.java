import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution{


    public static void solve(){

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

	try{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s = br.readLine();
	    

	}catch(Exception e){

	    System.err.println("Error: " + e.getMessage());



	}



    }












}