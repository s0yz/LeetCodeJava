package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * In a array A of size 2N, there are N+1 <b>unique</b> elements, and exactly
 * one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 * 
 * @see <a href=
 *      "https://leetcode.com/problems/n-repeated-element-in-size-2n-array/">
 *      N-Repeated Element in Size 2N Array</a>
 */
public class ReapeatedNTimes {

	/**
	 * 2 iterations
	 * 
	 * 20 ms, faster than 23.51%
	 * <p>
	 * Memory Usage: 39.2 MB, less than 98.68%
	 */
	public static int v1(int[] A) {
		int n = A.length >> 1;
		HashMap<Integer, Integer> counts = new HashMap<>();
		for (int i = 0; i < A.length; ++i) {
			if (counts.containsKey(A[i]))
				counts.put(A[i], counts.get(A[i]) + 1);
			else
				counts.put(A[i], 1);
		}
		for (Map.Entry<Integer, Integer> e : counts.entrySet())
			if (e.getValue() == n)
				return e.getKey();
		return 0;
	}

	/**
	 * Map & Set
	 * 
	 * Runtime: 19 ms, faster than 26.64%
	 * <p>
	 * Memory Usage: 39.1 MB, less than 98.79%
	 */
	public static int v2(int[] A) {
		int n = A.length >> 1;
		int count;
		HashMap<Integer, Integer> counts = new HashMap<>();
		HashSet<Integer> results = new HashSet<>();
		for (int i = 0; i < A.length; ++i) {
			if (counts.containsKey(A[i])) {
				count = counts.get(A[i]) + 1;
				counts.put(A[i], count);
				if (count == n) {
					results.add(A[i]);
				} else if (count > n) {
					results.remove(A[i]);
				}
			} else {
				counts.put(A[i], 1);
			}
		}
		return results.iterator().next();
	}

	/**
	 * HashSet
	 * 
	 * Runtime: 0 ms, faster than 100.00%
	 * <p>
	 * Memory Usage: 39.1 MB, less than 98.74%
	 */
	public static int v3(int[] A) {
		HashSet<Integer> uniques = new HashSet<>();
		for (int i = 0; i < A.length; ++i) {
			if (!uniques.add(A[i]))
				return A[i];
		}
		throw null;
	}

	/**
	 * Divide to conquer - Solution
	 */
	public static int v4(int[] A) {
		for (int k = 1; k <= 3; ++k)
			for (int i = 0; i < A.length - k; ++i)
				if (A[i] == A[i + k])
					return A[i];
		throw null;
	}
}
