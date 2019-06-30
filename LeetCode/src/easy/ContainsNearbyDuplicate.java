package easy;

import java.util.HashMap;
import java.util.HashSet;

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
	 * 
	 * Time Limit Exceeded lol
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
	 * 
	 * Runtime: 8 ms, faster than 79.41%
	 * <p>
	 * Memory Usage: 43.2 MB, less than 64.27%
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
	 * HashSet
	 * 
	 * Runtime: 6 ms, faster than 97.48%
	 * <p>
	 * Memory Usage: 42.6 MB, less than 76.08%
	 * 
	 */
	public static boolean v3(int[] nums, int k) {
		HashSet<Integer> checked = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!checked.add(nums[i])) {
				return true;
			}
			if (i - k >= 0) {
				checked.remove(nums[i - k]);
			}
		}
		return false;
	}
}