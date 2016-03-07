package com.github.rayedchan.testdriver;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.Test;
import com.github.rayedchan.datastructures.ArrayList;

public class ArrayListTest 
{
	@Test
	public void testAdd()
	{
		 ArrayList l = new ArrayList(4);
	 	 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{"a", "b", "c", "d"}), l.toString());
	}
	
	@Test
	public void testExpand()
	{
		 ArrayList l = new ArrayList(2);
	 	 l.add(1);
	 	 l.add(2);
	 	 l.add(3);
	 	 l.add(4);
	 	 l.add(5);
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{1, 2, 3, 4, 5, null}), l.toString());
	}
	
	@Test
	public void testInsertAt()
	{
		 ArrayList l = new ArrayList(5);
		 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 l.insertAt("x", 2);
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{"a", "b", "x", "c", "d"}), l.toString());
	}
	
	@Test
	public void testInsertAtExpand()
	{
		 ArrayList l = new ArrayList(4);
		 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 l.insertAt("x", 0);
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{"x", "a", "b", "c", "d", null}), l.toString());
	}
	
	@Test
	public void testRemove()
	{
		 ArrayList l = new ArrayList(4);
		 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 l.remove();
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{"a", "b", "c", null}), l.toString());
	}
	
	@Test
	public void testIndexOf()
	{
		 ArrayList l = new ArrayList(4);
		 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 int result = l.indexOf("b");
	 	 //System.out.println(result);
	 	 assertEquals(1, result);
	}
	
	@Test
	public void testIndexOfNotFound()
	{
		 ArrayList l = new ArrayList(4);
		 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 int result = l.indexOf("z");
	 	 //System.out.println(result);
	 	 assertEquals(-1, result);
	}
	
	@Test
	public void testRemoveAt()
	{
		 ArrayList l = new ArrayList(4);
		 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 l.removeAt(1);
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{"a","c", "d", null}), l.toString());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveAtException()
	{
		 ArrayList l = new ArrayList(4);
		 l.add("a");
	 	 l.add("b");
	 	 l.add("c");
	 	 l.add("d");
	 	 l.removeAt(20);
	}
	
	@Test
	public void testRemoveElement()
	{
		 ArrayList l = new ArrayList(4);
	 	 l.add(1);
	 	 l.add(2);
	 	 l.add(3);
	 	 l.add(4);
	 	 l.remove(2);
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{1, 3, 4, null}), l.toString());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemoveElementException()
	{
		 ArrayList l = new ArrayList(4);
	 	 l.add(1);
	 	 l.add(2);
	 	 l.add(3);
	 	 l.add(4);
	 	 l.remove(-20);
	}
	
	@Test
	public void testClear()
	{
		 ArrayList l = new ArrayList(4);
	 	 l.add(1);
	 	 l.add(2);
	 	 l.add(3);
	 	 l.add(4);
	 	 l.clear();
	 	 //System.out.println(l);
	 	 assertEquals(Arrays.toString(new Object[]{null, null, null, null}), l.toString());
	 	 assertEquals(0, l.size());
	}
}
