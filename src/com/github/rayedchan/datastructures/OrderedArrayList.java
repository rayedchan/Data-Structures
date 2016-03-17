package com.github.rayedchan.datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Ordered Array List: Fixed Size
 * @author rayedchan
 * @see https://en.wikipedia.org/wiki/Binary_search_algorithm
 * @see www.cse.unr.edu/~bebis/CS302/Lectures/SortedLists.ppt
 * @see http://www.vogella.com/tutorials/JavaDatastructureList/article.html
 */
public class OrderedArrayList<T extends Comparable<T>>
{
	Comparable<T>[] data; // list containing data
	int num; // Number of entries in list
	
	/**
	 * Constructor: Creates an array with a specified length
	 * @param capacity	Amount of entries the array can store
	 */
	@SuppressWarnings("unchecked")
	public OrderedArrayList(int capacity)
	{
		this.data = (Comparable<T>[]) new Comparable[capacity];
		this.num = 0;
	}
	
	/**
	 * Adds an item to the list maintaining the order of the list.
	 * O(n): due to number of swaps
	 * @param item New item to add to list 
	 */
	public void add(T item)
	{
		int index = 0;
		boolean found = false;
		
		// Find the location to insert item in array
		// Iterate until index does not reach the end of the list and location has not been found yet
		while(index < this.num && found != true)
		{
			@SuppressWarnings("unchecked")
			T curr = (T) this.data[index];
			
			// Found the location of the first object that is greater than the provided item
			if(curr.compareTo(item) > 0)
			{
				found = true;
			}
			
			else
			{
				index++;
			}
		}
						
		// Shift elements to right of the array starting at the new space (located next to the last item in array)
		for(int j = this.num; j > index; j--)
		{
			this.data[j] = this.data[j - 1];
		}
		
		this.data[index] = item; // insert item at the proper location
		this.num++; // increment number of elements in array
	}
	
	/**
	 * Removes the specified item from the list
	 * O(n)
	 * @param item	Item to remove from list
	 */
	public void remove(T item)
	{
		// Call method to find the location of the item in list
		int targetIndex = binarySearch(item);
		
		// Target item not in the list
		if(targetIndex < 0)
		{
			throw new NoSuchElementException("Could not find target item.");
		}
		
		// Perform swaps by shifting items leftward
		// target item is overwritten here leaving the item in the end of the list to be cleared out
		for(int i = targetIndex; i < this.num - 1; i++)
		{
			this.data[i] = this.data[i+1];
		}
		
		this.num--; // decrement size
		this.data[this.num] = null; // clear out last item in list
	}
	
	/**
	 * Performs a sequential search to find the target item.
	 * @param item	Item to search for in list
	 * @return	The index of the target item if it exists. A negative value if item is not in the list.
	 */
	public int sequentialSearch(T item)
	{
		// Iterate through the array to found target item
		for(int i = 0; i < this.num; i++)
		{
			@SuppressWarnings("unchecked")
			T currItem = (T) this.data[i];
			
			// Found target item
			if(currItem.compareTo(item) == 0)
			{
				return i;
			}
		}
		
		// Target item not found
		return -1;
	}
	
	/**
	 * Binary Search: Given an ordered list, compare the target key with the element at midpoint.
	 * If target key is equal to key at midpoint, return index.
	 * If target key is greater, inspect the upper sub-array (items after the middle point).
	 * If target key is less, inspect the lower sub-array (items before the middle point).
	 * O(log n)
	 * @param item
	 * @return
	 */
	public int binarySearch(T item)
	{
		int low = 0; // index at the beginning of the list
		int high = this.data.length - 1; // index at the end of the list
		
		// iterate until low pointer is at or exceeds high pointer
		while(low <= high)
		{
			int midPoint = (low + high) / 2; // calculate middle point
			
			// inspect value at middle point
			if(this.data[midPoint].compareTo(item) == 0)
			{
				return midPoint;
			}
			
			// value at middle point is greater than provided item => inspect left subarray
			else if(this.data[midPoint].compareTo(item) > 0)
			{
				high = midPoint - 1;
			}
			
			// target item is greater than item at midpoint => inspect right subarray 
			else
			{
				low = midPoint + 1;
			}
		}
		
		// item not found
		return -1;
	}
	
	/**
	 * Checks if the list is empty
	 * @return true if list is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return this.num == 0;
	}
	
	/**
	 * String representation of list
	 * @return String representation of array
	 */
	@Override
	public String toString()
	{
		return Arrays.toString(this.data);
	}
}
