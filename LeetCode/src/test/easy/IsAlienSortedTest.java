package test.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import easy.IsAlienSorted;

/**
 * @author Cedric Mariage
 *
 */
class IsAlienSortedTest {

	@Test
	void v1Example01() {
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		assertEquals(IsAlienSorted.v1(words, order), true);
	}
	
	@Test
	void v1Example02() {
		String[] words = {"word","world","row"};
		String order = "worldabcefghijkmnpqstuvxyz";
		assertEquals(IsAlienSorted.v1(words, order), false);
	}
	
	@Test
	void v1Example03() {
		String[] words = {"apple","app"};
		String order = "abcdefghijklmnopqrstuvwxyz";
		assertEquals(IsAlienSorted.v1(words, order), false);
	}
	
	@Test
	void v1AllSame() {
		String[] words = {"app","app","app"};
		String order = "abcdefghijklmnopqrstuvwxyz";
		assertEquals(IsAlienSorted.v1(words, order), true);
	}
	
	@Test
	void v2Example01() {
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		assertEquals(IsAlienSorted.v2(words, order), true);
	}
	
	@Test
	void v2Example02() {
		String[] words = {"word","world","row"};
		String order = "worldabcefghijkmnpqstuvxyz";
		assertEquals(IsAlienSorted.v2(words, order), false);
	}
	
	@Test
	void v2Example03() {
		String[] words = {"apple","app"};
		String order = "abcdefghijklmnopqrstuvwxyz";
		assertEquals(IsAlienSorted.v2(words, order), false);
	}
	
	@Test
	void v2AllSame() {
		String[] words = {"app","app","app"};
		String order = "abcdefghijklmnopqrstuvwxyz";
		assertEquals(IsAlienSorted.v2(words, order), true);
	}
}
