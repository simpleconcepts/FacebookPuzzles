import java.util.*;
import java.lang.*;
import java.io.*;




public class Recursion {

	public static boolean contains(int[] array, int fromIndex, int toIndex, int target){
		
		if(fromIndex > toIndex)
			return false;
		else{
			return array[fromIndex] == target || contains(array,fromIndex+1,toIndex,target);
		}
	}

	public static boolean binarySearch(int[] array, int low, int hi, int target){
		
		if(low > hi)
			return false;
		
		int middle = (low + hi)/2;
		
		if(array[middle] == target){
			return true;
		}
		
		else if(target < array[middle])
			return binarySearch(array, low, middle-1, target);
		return binarySearch(array,middle+1,hi, target);
		
	}
	
	public static void swap(int[] array, int i, int j)
	{
		
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
		
	}
	
	public static int minLocation(int[] array, int from, int to)
	{
		int min = Integer.MAX_VALUE;
		int minLoc = -1;
		for(int i = from; i <= to; i++){
			if(array[i] < min){
				min = array[i];
				minLoc = i;
				
			}
		}
		
		return minLoc;
		
	}
	
	public static void selectionSort(int[] array, int from, int to)
	{
		if(from > to)
			return;
		int minLoc = minLocation(array, from, to);
		swap(array, from, minLoc);
		System.out.println();
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		selectionSort(array, from+1, to);

	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {64,25,12,22,11};
		
		selectionSort(array,0,4);
	}

}
