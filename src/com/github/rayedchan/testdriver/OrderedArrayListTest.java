package com.github.rayedchan.testdriver;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;
import com.github.rayedchan.datastructures.OrderedArrayList;

public class OrderedArrayListTest
{
	@Test
	public void testAdd() 
	{
		OrderedArrayList<String> l = new OrderedArrayList<String>(5);
		l.add("Bobby");
		l.add("Amanda");
		l.add("Jim");
		l.add("Zack");
		l.add("Kyle");
		//System.out.println(l);
		assertEquals("[Amanda, Bobby, Jim, Kyle, Zack]", l.toString());		
	}

	@Test
	public void testAdd2() 
	{
		OrderedArrayList<Integer> l = new OrderedArrayList<Integer>(7);
		l.add(5);
		l.add(20);
		l.add(1);
		l.add(15);
		l.add(50);
		l.add(42);
		l.add(2);
		//System.out.println(l);
		assertEquals("[1, 2, 5, 15, 20, 42, 50]", l.toString());		
	}
	
	@Test
	public void testSequentialSearch() 
	{
		OrderedArrayList<Integer> l = new OrderedArrayList<Integer>(7);
		l.add(5);
		l.add(20);
		l.add(1);
		l.add(15);
		l.add(50);
		l.add(42);
		l.add(2);
		int index = l.sequentialSearch(15);
		//System.out.println(index);
		assertEquals(3, index);		
	}
	
	@Test
	public void testSequentialSearch2() 
	{
		OrderedArrayList<Integer> l = new OrderedArrayList<Integer>(7);
		l.add(5);
		l.add(20);
		l.add(1);
		l.add(15);
		l.add(50);
		l.add(42);
		l.add(2);
		int index = l.sequentialSearch(1500);
		//System.out.println(index);
		assertEquals(-1, index);		
	}
	
	@Test
	public void testRemove() 
	{
		OrderedArrayList<String> l = new OrderedArrayList<String>(5);
		l.add("Bobby");
		l.add("Amanda");
		l.add("Jim");
		l.add("Zack");
		l.add("Kyle");
		l.remove("Kyle");
		//System.out.println(l);
		assertEquals("[Amanda, Bobby, Jim, Zack, null]", l.toString());		
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemove2() 
	{
		OrderedArrayList<String> l = new OrderedArrayList<String>(5);
		l.add("Bobby");
		l.add("Amanda");
		l.add("Jim");
		l.add("Zack");
		l.add("Kyle");
		l.remove("Jack");	
	}
	
	@Test
	public void testRemove3() 
	{
		OrderedArrayList<String> l = new OrderedArrayList<String>(5);
		l.add("Bobby");
		l.add("Amanda");
		l.add("Jim");
		l.add("Zack");
		l.add("Kyle");
		l.remove("Amanda");
		l.remove("Jim");
		//System.out.println(l);
		assertEquals("[Bobby, Kyle, Zack, null, null]", l.toString());		
	}
	
	@Test
	public void testBinarySearch() 
	{
		OrderedArrayList<Integer> l = new OrderedArrayList<Integer>(7);
		l.add(5);
		l.add(20);
		l.add(1);
		l.add(15);
		l.add(50);
		l.add(42);
		l.add(2);
		int index = l.binarySearch(15);
		//System.out.println(l);
		//System.out.println(index);
		assertEquals(3, index);		
	}
	
	@Test
	public void testBinarySearch2() 
	{
		OrderedArrayList<Integer> l = new OrderedArrayList<Integer>(7);
		l.add(5);
		l.add(20);
		l.add(1);
		l.add(15);
		l.add(50);
		l.add(42);
		l.add(2);
		int index = l.binarySearch(100);
		//System.out.println(l);
		//System.out.println(index);
		assertEquals(-1, index);		
	}
	
	@Test
	public void testBinarySearch3() 
	{
		OrderedArrayList<Integer> l = new OrderedArrayList<Integer>(7);
		l.add(5);
		l.add(20);
		l.add(1);
		l.add(15);
		l.add(50);
		l.add(42);
		l.add(2);
		int index = l.binarySearch(1);
		//System.out.println(l);
		//System.out.println(index);
		assertEquals(0, index);		
	}
}
