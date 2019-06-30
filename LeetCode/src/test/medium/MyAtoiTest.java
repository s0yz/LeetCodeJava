package test.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import medium.MyAtoi;

class MyAtoiTest {

	@Test
	void v1$0() {
		assertEquals(MyAtoi.v1(""), 0);
		assertEquals(MyAtoi.v1("  "), 0);
		assertEquals(MyAtoi.v1("words and 987"), 0);
		assertEquals(MyAtoi.v1("-"), 0);
		assertEquals(MyAtoi.v1("+"), 0);
		assertEquals(MyAtoi.v1("-+14"), 0);
		assertEquals(MyAtoi.v1("-      23"), 0);
	}
	
	@Test
	void v1() {
		assertEquals(MyAtoi.v1("42"), 42);
		assertEquals(MyAtoi.v1("+666"), 666);
		assertEquals(MyAtoi.v1("-33"), -33);
		assertEquals(MyAtoi.v1("   -12"), -12);
		assertEquals(MyAtoi.v1("   +24"), 24);
		assertEquals(MyAtoi.v1("4193 with words"), 4193);
		assertEquals(MyAtoi.v1("-91283472332"), Integer.MIN_VALUE);
		assertEquals(MyAtoi.v1("91283472332"), Integer.MAX_VALUE);
		assertEquals(MyAtoi.v1("3.14159"), 3);
		assertEquals(MyAtoi.v1("5-"), 5);
		assertEquals(MyAtoi.v1("5+"), 5);
		assertEquals(MyAtoi.v1("-5-"), -5);
		assertEquals(MyAtoi.v1("-5+"), -5);
		assertEquals(MyAtoi.v1("+5+"), 5);
		assertEquals(MyAtoi.v1("+5-"), 5);
	}
	
	@Test
	void v2$0() {
		assertEquals(MyAtoi.v2(""), 0);
		assertEquals(MyAtoi.v2("  "), 0);
		assertEquals(MyAtoi.v2("words and 987"), 0);
		assertEquals(MyAtoi.v2("-"), 0);
		assertEquals(MyAtoi.v2("+"), 0);
		assertEquals(MyAtoi.v2("-+14"), 0);
		assertEquals(MyAtoi.v2("-      23"), 0);
	}
	
	@Test
	void v2() {
		assertEquals(MyAtoi.v2("42"), 42);
		assertEquals(MyAtoi.v2("+666"), 666);
		assertEquals(MyAtoi.v2("-33"), -33);
		assertEquals(MyAtoi.v2("   -12"), -12);
		assertEquals(MyAtoi.v2("   +24"), 24);
		assertEquals(MyAtoi.v2("4193 with words"), 4193);
		assertEquals(MyAtoi.v2("-91283472332"), Integer.MIN_VALUE);
		assertEquals(MyAtoi.v2("91283472332"), Integer.MAX_VALUE);
		assertEquals(MyAtoi.v2("3.14159"), 3);
		assertEquals(MyAtoi.v2("5-"), 5);
		assertEquals(MyAtoi.v2("5+"), 5);
		assertEquals(MyAtoi.v2("-5-"), -5);
		assertEquals(MyAtoi.v2("-5+"), -5);
		assertEquals(MyAtoi.v2("+5+"), 5);
		assertEquals(MyAtoi.v2("+5-"), 5);
	}
}
