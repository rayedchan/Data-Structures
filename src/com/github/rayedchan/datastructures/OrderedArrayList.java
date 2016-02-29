package com.github.rayedchan.datastructures;

import java.util.Arrays;

/**
 * Ordered Array List: Fixed Size
 * @author rayedchan
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
	
	// 1 3 4 5
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
						
		// Shift elements to right of the array starting at the new space
		for(int j = this.num; j > index; j--)
		{
			this.data[j] = this.data[j - 1];
		}
		
		this.data[index] = item; // insert item at the proper location
		this.num++; // increment number of elements in array
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
