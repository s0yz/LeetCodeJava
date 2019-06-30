package medium;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * <strong>Note:</strong>
 * <ul>
 * <li>Only the space character <code>' '</code> is considered as whitespace
 * character.</li>
 * <li>Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2<sup>31</sup>,&nbsp;
 * 2<sup>31&nbsp;</sup>− 1]. If the numerical value is out of the range of
 * representable values, INT_MAX (2<sup>31&nbsp;</sup>− 1) or INT_MIN
 * (−2<sup>31</sup>) is returned.</li>
 * </ul>
 * 
 * @see <a href= "https://leetcode.com/problems/string-to-integer-atoi/"> String
 *      to Integer (atoi)</a>
 */
public class MyAtoi {

	/**
	 * indices and substring
	 * 
	 * Runtime: 2 ms, faster than 60.16%
	 * <p>
	 * Memory Usage: 36.3 MB, less than 99.91%
	 */
	public static int v1(String str) {
		boolean started = false;
		int start = 0;
		int end = 0;
		for (int i = 0; i < str.length(); ++i) {
			char it = str.charAt(i);
			if ((it > 47 && it < 58) || (it == '-' || it == '+') && !started) {
				started = true;
				++end;
			} else if (it == ' ' && !started) {
				++start;
				++end;
			} else {
				return v1$parse(str, start, end);
			}
		}
		return v1$parse(str, start, end);
	}

	public static int v1$parse(String str, int start, int end) {
		if (start == end || end - start == 1 && (str.charAt(start) < 48 || str.charAt(start) > 57)) {
			return 0;
		}
		String number = str.substring(start, end);
		try {
			return (int) Integer.parseInt(number);
		} catch (NumberFormatException e) {
			if (number.charAt(0) == '-') {
				return Integer.MIN_VALUE;
			}
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * Long
	 * 
	 * Runtime: 1 ms, faster than 100.00%
	 * <p>
	 * Memory Usage: 36 MB, less than 99.91%
	 */
	public static int v2(String str) {
		long value = 0;
		int factor = 1;
		boolean started = false;
		for (int i = 0; i < str.length(); ++i) {
			char it = str.charAt(i);
			if (it > 47 && it < 58) {
				started = true;
				value = value * 10 + (it - 48) * factor;
				if (value > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if (value < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			} else if (it == '-') {
				if (!started) {
					started = true;
					factor = -1;
				} else {
					break;
				}
			} else if (it == '+') {
				if (!started) {
					started = true;
				} else {
					break;
				}
			} else {
				if (started) {
					break;
				}
				if (it != ' ') {
					return 0;
				}
			}
		}
		return (int) value;
	}
}
