package com.github.rayedchan;

import static org.junit.Assert.*;
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
}
