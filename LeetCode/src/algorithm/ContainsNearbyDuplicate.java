package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between <b>i</b> and <b>j</b> is at most k.
 *
 * @see <a href= "https://leetcode.com/problems/contains-duplicate-ii/">
 *      Contains Duplicate II</a>
 */
public class ContainsNearbyDuplicate {

	/**
	 * Naive implementation
	 * <p>
	 * Time Limit Exceeded
	 */
	public static boolean v1(int[] nums, int k) {
		for (int i = 0; i < nums.length - 1; ++i) {
			for (int j = 1; j < nums.length; ++j) {
				if (i != j && nums[i] == nums[j] && Math.abs(i - j) <= k) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * HashMap
	 * <p>
	 * Runtime: 8 ms, faster than 79.41% Memory Usage: 43.2 MB, less than 64.27%
	 */
	public static boolean v2(int[] nums, int k) {
		HashMap<Integer, Integer> indices = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (indices.containsKey(nums[i]) && Math.abs(indices.get(nums[i]) - i) <= k) {
				return true;
			}
			indices.put(nums[i], i);
		}
		return false;
	}
	
	/**
	 * Divide to conquer
	 * <p>
	 * 
	 */
	public static boolean v3(int[] nums, int k) {
		HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i < nums.length; i++){
            if(!hs.add(nums[i]))
                return true;
            if(i - k >= 0)
                hs.remove(nums[i-k]);
        }
        return false;
	}
}