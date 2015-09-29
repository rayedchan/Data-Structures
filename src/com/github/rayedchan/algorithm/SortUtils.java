package com.github.rayedchan.algorithm;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sorting algorithms
 * @author rayedchan
 */
public class SortUtils 
{
	// Logger
	private static final Logger log = Logger.getLogger(SortUtils.class.getName());
	
	// Prevent any object instantiation
	private SortUtils()
	{
		
	}

	/**
	 * The algorithm divides the input list into two parts: the sublist of items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.
	 * Time complexity: O(n^2)
	 * @param array Integer array to sort
	 * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Wiki: Selection Sort</a>
	 */
	public static void selectionSort(int[] array)
	{
		int min; // Keep track of the minimum value
		int minIndex; // Keep track of the index the minimum value is located
		int length = array.length;
		log.log(Level.INFO, "Length of List: {0}", new Object[]{length});
		log.log(Level.INFO, "Initial List: {0}", new Object[]{Arrays.toString(array)});
		
		// Advance the position through entire array
		// Each iteration gets the minimum value on the unsorted sublist
		for(int i = 0; i < length; i++)
		{
			// Assume first element is the minimum
			min = array[i];
			minIndex = i;
			
			for(int j = i + 1; j < length; j++)
			{
				// New minimum found
				if(array[j] < min)
				{
					min = array[j];
					minIndex = j;
				}
			}
			
			// Swap if a new minimum index is found (the assumed first element is not the minimum anymore)
			if(minIndex != i)
			{
				array[minIndex] = array[i];
				array[i] = min;
			}
			
			log.log(Level.INFO, "List at Iteration {0}: {1}", new Object[]{i + 1, Arrays.toString(array)});
		}
		
		log.log(Level.INFO, "Sorted List: {0}", new Object[]{Arrays.toString(array)});
	}
}
