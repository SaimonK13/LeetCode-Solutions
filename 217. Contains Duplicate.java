/* Name: Contains Duplicate (LeetCode Problem #217)
 * Description: Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 */

import java.util.*;

public class ContainsDuplicate {
	
	//solution 1: traverse through the array
	static boolean containsDuplicate1(int[] nums) {
		
		if(nums==null || nums.length==0)
			   return false;
		
		for (int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] == nums[j]){ 
	                    return true;
	                }
	            }
	        }
		return false;
	        
	    }
		
	//solution 2: traverse through sorted array
	static boolean containsDuplicate2(int[] nums) {
		
		if(nums==null || nums.length==0)
			   return false;
	    
	    	Arrays.sort(nums);
			
		for(int i = 0; i < nums.length - 1; i++) {
				
			for(int j = i+1; j < nums.length; j++ ) {
					
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
			
		return false;
	     
	 }
	
	//solution 3 (optimized): use hash set
	 static boolean containsDuplicate3(int[] nums) {
	        
	   	if(nums==null || nums.length==0)
			return false;
	 
	    	HashSet<Integer> set = new HashSet<Integer>();
	    	for(int i: nums){
	        	if(!set.add(i)){
	            		return true;
			}
		}
	 
	    	return false;
	        
	    }

	//main method
	public static void main(String[] args) {
		
		int[] arr = new int[] {2,1,3,41,2};
		System.out.println(containsDuplicate1(arr));
		System.out.println(containsDuplicate2(arr));
		System.out.println(containsDuplicate3(arr));

	}

}
