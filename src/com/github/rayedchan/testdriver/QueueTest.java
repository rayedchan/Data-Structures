package com.github.rayedchan.testdriver;

import static org.junit.Assert.*;
import org.junit.Test;
import com.github.rayedchan.datastructures.Queue;
import java.util.NoSuchElementException;

public class QueueTest
{
	@Test
	public void testEnqueue()
	{
		 Queue<String> l = new Queue<String>();
	 	 l.enqueue("a");
	 	 l.enqueue("b");
	 	 l.enqueue("c");
	 	 l.enqueue("d");
	 	 //System.out.println(l);
	 	 assertEquals("[a, b, c, d]", l.toString());
	}
	
	@Test
	public void testDequeue()
	{
		 Queue<String> l = new Queue<String>();
	 	 l.enqueue("a");
	 	 l.enqueue("b");
	 	 l.enqueue("c");
	 	 l.enqueue("d");
	 	 String val = l.dequeue();
	 	 String val2 = l.dequeue();
	 	 
	 	 //System.out.println(l);
	 	 //System.out.println(val);
	 	 //System.out.println(val2);
	 	 
	 	 assertEquals("a", val);
	 	 assertEquals("b", val2);
	 	 assertEquals("[c, d]", l.toString());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDequeue2()
	{
		 Queue<String> l = new Queue<String>();
	 	 l.dequeue();
	}

}
