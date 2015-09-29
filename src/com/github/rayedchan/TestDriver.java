package com.github.rayedchan;

import java.util.Arrays;
import org.junit.Test;
import com.github.rayedchan.algorithm.SortUtils;

public class TestDriver 
{
	/*public static void main(String[] args)
	{
		int[] array = {64,25,12,22,11};
		SortUtils.selectionSort(array);
	}*/
	
	@Test  
	public void selectionSort1() 
	{
		int[] array = {64,25,12,22,11};
	    SortUtils.selectionSort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {11,12,22,25,64}), Arrays.toString(array)); 
	}
	
	@Test  
	public void selectionSort2() 
	{
		int[] array = {9,2,5,7,4,8};
	    SortUtils.selectionSort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {2,4,5,7,8,9}), Arrays.toString(array)); 
	}
	
	@Test  
	public void selectionSort3() 
	{
		int[] array = {100};
	    SortUtils.selectionSort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {100}), Arrays.toString(array)); 
	}
	
	@Test(expected = NullPointerException.class)
	public void selectionSort4() 
	{
		int[] array = null;
	    SortUtils.selectionSort(array);
	}
	
	@Test
	public void selectionSort5() 
	{
		int[] array = {};
	    SortUtils.selectionSort(array);
	    org.junit.Assert.assertEquals(Arrays.toString(new int[] {}), Arrays.toString(array)); 
	}
}
