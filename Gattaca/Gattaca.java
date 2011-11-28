import java.io.*;
import java.util.*;
import java.lang.*;

public class Gattaca{
    
    static int maxindex;
    
    public static int[] highestP(Interval1D[] intervals){
		
		int[] p = new int[intervals.length];
		p[0] = 0;
        
		for(int i = 1; i < p.length; i++){
			for(int j = i-1; j >= 0; j--){
				if(!intervals[i].contains(intervals[j].right())){	
                    p[i] = j;	
                    break;
				}		
                
				
			}
            
			
		}
		
        return p;
	}
    
    // return the maximum of two entries
    private static int max(int x, int y) {
        if (x > y)
            return x;
        return y;
    }
    
    public static int[] getWeights(Interval1D[] intervals){
        Arrays.sort(intervals, Interval1D.RIGHT_ENDPOINT_ORDER);
        int[] v = new int[intervals.length];
        Interval1D local;
        for(int i = 0; i < v.length; i++){
            local = intervals[i];
            v[i] = (int)local.weight();
            
        }
        
        return v;
    }
    
    public static int maxscore(int[] v, int[] p){
        
        int[] M = new int[v.length];
        // algorithm run by dynamic programming
        M[0] = 0;
        for (int i = 1; i < 8; i++) {
            M[i] = max(v[i] + M[p[i]], M[i - 1]);
        }
        
        
        int i, sum = 0;
        
        for (i = 7; i > 0;)
            if (v[i] + M[p[i]] >= M[i - 1]) {
                sum += v[i];
                i = p[i];
            } else
                i--;

        return sum;
        
    }
    
    public static void main(String[] args){
	
	String filename = args[0];
	InputParser parser = new InputParser();
	Interval1D[] intervals = parser.generateIntervalsFromFile(filename);
    
        int[] p = highestP(intervals);
        int[] v = getWeights(intervals);
        
        int score = maxscore(v,p);
        
        System.out.println("Score is: "+score);

    }








}