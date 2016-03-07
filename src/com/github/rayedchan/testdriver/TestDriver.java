package com.github.rayedchan.testdriver;

import java.util.Arrays;
import org.junit.Test;
import com.github.rayedchan.algorithm.SortUtils;

public class TestDriver 
{
	public static void main(String[] args)
	{
		int num = 15;
		int newCap = num + (num >> 1);
		System.out.println(num >> 1);
		System.out.println(newCap);
		
		//int[] array = {64,25,12,22,11};
		//sort(array);
	}
	
	// Wrapper method
	public static void sort(int[] array)
	{
		//SortUtils.selectionSort(array);
		SortUtils.bubbleSort(array);
	}
	
	@Test  
	public void sort1() 
	{
		int[] array = {64,25,12,22,11};
		sort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {11,12,22,25,64}), Arrays.toString(array)); 
	}
	
	@Test  
	public void sort2() 
	{
		int[] array = {9,2,5,7,4,8};
	    sort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {2,4,5,7,8,9}), Arrays.toString(array)); 
	}
	
	@Test  
	public void sort3() 
	{
		int[] array = {100};
	    sort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {100}), Arrays.toString(array)); 
	}
	
	@Test(expected = NullPointerException.class)
	public void sort4() 
	{
		int[] array = null;
	    sort(array);
	}
	
	@Test
	public void sort5() 
	{
		int[] array = {};
	    sort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {}), Arrays.toString(array)); 
	}
	
	@Test
	public void sort6() 
	{
		int[] array = {5,1,4,2,8,5};
	    sort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {1,2,4,5,5,8}), Arrays.toString(array)); 
	}
}
