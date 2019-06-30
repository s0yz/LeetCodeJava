package main;

import easy.ContainsNearbyDuplicate;
import easy.ReapeatedNTimes;

public class Main {

	public static void main(String[] args) {
		
	}

	public static void printResult(int version, Object r, Object e) {
		System.out.println("Version " + version + " actual: " + r + ", expected: " + e);
	}

	public static void containsNearbyDuplicate() {
		int[][] inputs = { { 1, 2, 3, 1 }, { 1, 0, 1, 1 }, { 1, 2, 3, 1, 2, 3 }, { 1, 2, 3, 1, 2, 3 } };
		int[] ks = { 3, 1, 2, 2 };
		boolean[] expected = { true, true, false, false };
		for (int i = 0; i < inputs.length; ++i) {
			printResult(1, ContainsNearbyDuplicate.v1(inputs[i], ks[i]), expected[i]);
			printResult(2, ContainsNearbyDuplicate.v2(inputs[i], ks[i]), expected[i]);
			printResult(3, ContainsNearbyDuplicate.v3(inputs[i], ks[i]), expected[i]);
		}
	}
	
	public static void repeatedNTimes() {
		int[][] inputs = { { 1, 2, 3, 3 }, { 2, 1, 2, 5, 3, 2 }, { 5, 1, 5, 2, 5, 3, 5, 4 } };
		int[] expected = { 3, 2, 5 };
		for (int i = 0; i < inputs.length; ++i) {
			printResult(1, ReapeatedNTimes.v1(inputs[i]), expected[i]);
			printResult(2, ReapeatedNTimes.v2(inputs[i]), expected[i]);
			printResult(3, ReapeatedNTimes.v3(inputs[i]), expected[i]);
		}
	}
}