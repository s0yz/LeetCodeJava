package easy;

import java.util.HashMap;

/**
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly&nbsp;in a different <code>order</code>.
 * The&nbsp;<code>order</code> of the alphabet&nbsp;is some permutation&nbsp;of
 * lowercase letters.
 * <p>
 * Given a sequence of <code>words</code>&nbsp;written in the alien
 * language,&nbsp;and the <code>order</code> of the alphabet,&nbsp;return
 * <code>true</code> if and only if the given <code>words</code>&nbsp;are sorted
 * lexicographicaly in this alien language.
 * <p>
 * <strong>Note:</strong>
 * <ol>
 * <li><code>1 &lt;= words.length &lt;= 100</code></li>
 * <li><code>1 &lt;= words[i].length &lt;= 20</code></li>
 * <li><code>order.length == 26</code></li>
 * <li>All characters in <code>words[i]</code> and <code>order</code> are
 * english lowercase letters.</li>
 * </ol>
 * 
 */
public class IsAlienSorted {

	/**
	 * HashMap
	 * 
	 * Runtime: 1 ms, faster than 45.41%
	 * <p>
	 * Memory Usage: 35.6 MB, less than 99.01%
	 */
	public static boolean v1(String[] words, String order) {
		HashMap<Character, Integer> alphabet = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			alphabet.put(order.charAt(i), i);
		}
		for (int i = 0; i < words.length - 1; i++) {
			String right = words[i + 1];
			for (int j = 0; j < words[i].length(); j++) {
				if (j >= right.length()) {
					return false;
				}
				if (alphabet.get(words[i].charAt(j)) > alphabet.get(right.charAt(j))) {
					return false;
				}
				if (alphabet.get(words[i].charAt(j)) < alphabet.get(right.charAt(j))) {
					break;
				}
			}
		}
		return true;
	}
	
	/**
	 * Array
	 * 
	 * Runtime: 0 ms, faster than 100.00%
	 * <p>
	 * Memory Usage: 35.7 MB, less than 99.01%
	 */
	public static boolean v2(String[] words, String order) {
		int[] indices = new int[26];
		for (int i = 0; i < 26; i++) {
			indices[order.charAt(i) - 'a'] = i;
		}
		for (int i = 0; i < words.length - 1; i++) {
			String right = words[i + 1];
			for (int j = 0; j < words[i].length(); j++) {
				if (j >= right.length()) {
					return false;
				}
				if (indices[words[i].charAt(j) - 'a'] > indices[right.charAt(j) - 'a']) {
					return false;
				}
				if (indices[words[i].charAt(j) - 'a'] < indices[right.charAt(j) - 'a']) {
					break;
				}
			}
		}
		return true;
	}
}



































