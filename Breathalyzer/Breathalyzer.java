import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Breathalyzer {

	/**
	 * @param args
	 */
	public static String[] dict;
	public static int nwords;
	
	public Breathalyzer(String[] dictionary){
		dict = new String[dictionary.length];
		dict = dictionary;
		nwords = dict.length;
		
	}
	
	

	public static boolean check(String word,String[] dictionary){
	    	/**
	    	 * * Implement a capitalization-insensitive spellcheck here.
	    	 * */
	    	
	    	int low = 0;
	    	int high = dictionary.length-1;
	    	

	    	while (low <= high){
	    		
	    		int mid = (low + high)/2;
	    		if(dictionary[mid].compareToIgnoreCase(word) < 0)
	    			low = mid + 1;
	    		else if(dictionary[mid].compareToIgnoreCase(word) > 0)
	    			high = mid - 1;
	    		else if (dictionary[mid].compareToIgnoreCase(word) == 0)
	    			return true;
	    	}
	    	
	    			return false;
	    		
	}
	    
	public static String[] make(String filename){
		
		/* Read Text File From File */
	     
		System.out.println("Reading dictionary from: "+filename);
		String[] dictionary = null;
		int numwords = 0;

		try{
	            /* Open File   */                                                                                   
                                                                                            
	            FileInputStream fstream = new FileInputStream(filename);

	            /* Get The Object of DataInputStream   */                                                           
	                                                                                                               
	            DataInputStream in = new DataInputStream(fstream);
	            BufferedReader br = new BufferedReader(new InputStreamReader(in));
	            
	            while(br.readLine() != null)
	            	numwords++;
	            System.out.println(numwords + " in dictionary");
	            dictionary = new String[89345];
	            in.close();

 
	      }
	      
	      catch(Exception e){//Catch exception if any                                                           \
            
	    	  if(e != null){
	          //  System.err.println("Error: " + e.getMessage());
	    	  }
	        }
		
		
		try{
            FileInputStream fstream2 = new FileInputStream(filename);
            DataInputStream in2 = new DataInputStream(fstream2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            
            int i = 0;
            while(br2.readLine() != null){
            	dictionary[i] = br2.readLine().trim().toLowerCase();
            	i++;
            }
            
            dict = dictionary;
            
            in2.close();
            
            return dictionary;


		}catch(Exception e){
			
            //System.err.println("Error: " + e.getMessage());

		}
		
		return dictionary;

	}
	
	
	
	public static void printWords(){
		
		for(int i = 0; i < 10; i++){
			System.out.println(dict[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dictionary = args[0];
	 
		String[] words = make(dictionary);
		System.out.println("The Dictionary Contains The Word Hello: "+check("forte",words));
	
				
	}

}
