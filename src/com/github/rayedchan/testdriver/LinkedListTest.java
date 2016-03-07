package com.github.rayedchan.testdriver;

import static org.junit.Assert.*;

import java.util.Iterator;

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
	
	@Test
	public void testInsertBefore1() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.insertBefore("b", "x");
		//System.out.println(l);
		assertEquals("[a, x, b, c]", l.toString());
	}
	
	@Test
	public void testInsertBefore2() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.insertBefore("a", "x");
		//System.out.println(l);
		assertEquals("[x, a, b, c]", l.toString());
	}
	
	@Test
	public void testInsertBefore3() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.insertBefore("a", "x");
		//System.out.println(l);
		assertEquals("[]", l.toString());
	}
	
	@Test(expected=RuntimeException.class)
	public void testRemove1() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.remove("x");
		//System.out.println(l);
		assertEquals("[]", l.toString());
	}
	
	@Test(expected=RuntimeException.class)
	public void testRemove2() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.remove("x");
	}
	
	@Test
	public void testRemove3() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.remove("a");
		//System.out.println(l);
		assertEquals("[b, c]", l.toString());
	}
	
	@Test
	public void testRemove4() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.remove("a");
		//System.out.println(l);
		assertEquals("[]", l.toString());
	}
	
	@Test
	public void testRemove5() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.remove("b");
		//System.out.println(l);
		assertEquals("[a, c]", l.toString());
	}
	
	@Test
	public void testRemove6() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		l.remove("c");
		//System.out.println(l);
		assertEquals("[a, b]", l.toString());
	}
	
	@Test
	public void testIterator1() 
	{
		LinkedList<String> l = new LinkedList<String>();
		l.addLast("a");
		l.addLast("b");
		l.addLast("c");
		System.out.println(l);
		
		Iterator<String> it = l.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
}
