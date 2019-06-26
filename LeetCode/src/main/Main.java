package main;
import algorithm.ReapeatedNTimes;

public class Main {	
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6 };
		System.out.println(ReapeatedNTimes.repeatedNTimesV1(a));
		System.out.println(ReapeatedNTimes.repeatedNTimesV2(a));
		System.out.println(ReapeatedNTimes.repeatedNTimesV3(a));
	}
}