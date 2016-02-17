package com.github.rayedchan;

import static org.junit.Assert.*;
import org.junit.Test;
import com.github.rayedchan.datastructures.LinkedList;

public class LinkedListTest
{
	@Test
	public void testAddFirst1() 
	{
		// Empty List
		LinkedList<Integer> l = new LinkedList<Integer>();
		//System.out.println(l);
		assertEquals("[]", l.toString());
	}
	
	@Test
	public void testAddFirst2() 
	{
		// Single item
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.addFirst(5);
		//System.out.println(l);
		assertEquals("[5]", l.toString());
	}

	@Test
	public void testAddFirst3() 
	{
		// More than 1 item
		LinkedList<String> l = new LinkedList<String>();
		l.addFirst("a");
		l.addFirst("b");
		//System.out.println(l);
		assertEquals("[b, a]", l.toString());
	}
	
	@Test
	public void testAddLast1() 
	{
		// first node
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		//System.out.println(l);
		assertEquals("[a]", l.toString());
	}
	
	@Test
	public void testAddLast2() 
	{
	    // More than 1 item in list
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		//System.out.println(l);
		assertEquals("[a, b, c]", l.toString());
	}
	
	@Test
	public void testInsertAfter1() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.insertAfter("b", "x");
		//System.out.println(l);
		assertEquals("[a, b, x, c]", l.toString());
	}
	
	@Test
	public void testInsertAfter2() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.insertAfter("c", "x");
		//System.out.println(l);
		assertEquals("[a, b, c, x]", l.toString());
	}
	
	@Test
	public void testInsertAfter3() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.insertAfter("N", "x");
		//System.out.println(l);
		assertEquals("[a, b, c]", l.toString());
	}
}
