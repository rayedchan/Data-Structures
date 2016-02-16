package com.github.rayedchan.datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * ArrayList implementation
 * Invariants:
 *    size = # of elements in the list
 *    0 <= size <= capacity
 *    data array: first SIZE slots filled, followed by nulls 
 * @author rayedchan
 * @see http://www.docjar.com/html/api/java/util/ArrayList.java.html
 * @see http://web.eecs.umich.edu/~aprakash/eecs282/lectures/10-arraylists.pdf
 * @see https://en.wikipedia.org/wiki/Dynamic_array
 */
public class ArrayList
{
	// Fields
	Object[] data; // array of Objects
	int capacity; // maximum capacity of list
	int size; // current size of list
	static final int DEFAULT_CAPACITY = 10;
		
	/**
	 * Constructs an array using the default capacity.
	 */
	public ArrayList()
	{
		this(DEFAULT_CAPACITY); // calls the ArrayList(capacity) constructor
	}
	
	/**
	 * Constructs an array using the capacity provided.
	 * @param capacity	Maximum capacity of list
	 */
	public ArrayList(int capacity)
	{
		this.capacity = capacity; // set field with the provided capacity
		this.data = new Object[this.capacity]; // null elements  
		this.size = 0; // zero elements
	}
	
	/**
	 * Adds an element to the list.
	 * O(1) - Adds to the end of the list; direct access since size is known
	 * @param element	Item to add
	 */
	public void add(Object element)
	{
		this.appendElement(element); // Adds to end of the list
	}
	
	/**
	 * Adds an element in an arbitrary location.
	 * O(n) - Shifting n - 1 items happens when item is added to the beginning of the list
	 * @param element	New element to add the list
	 * @param index	Index to add the element to; Must refer to an existing position in the list
	 * 
	 * Initial List
	 * index   0 1 2 3
	 * content a b c d
	 * size = 4
	 *  
	 * After insertion of x at index 2
	 * index 	0 1 2 3 4
	 * content	a b x c d
	 * size = 5
	 * 
	 * 1st iteration
	 * i = 4
	 * a[4] = a[3]
	 * 0 1 2 3 4
	 * a b c d d
	 * 
	 * 2nd iteration
	 * i = 3
	 * a[3] = a[2]
	 * 0 1 2 3 4
	 * a b c c d
	 * 
	 * Replace new content at given index
	 * a[2] = x
	 * 0 1 2 3 4
	 * a b x c d
	 */
	public void insertAt(Object element, int index)
	{
		// Boundary check
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException("Index out of bound exception");
		}
		
		// Check capacity and current size are the same => Need to expand array
		if(this.capacity == this.size)
		{
			this.expand(); // Create a new array with a larger capacity and copy the content from the old array
		}
		
		// Shift elements rightward by one
		// Start at the last position (the index with no content)
		for(int i = this.size; i > index ; i--)
		{
			this.data[i] = this.data[i - 1];
		}
		
		this.data[index] = element; // insert element at the given index
		this.size++; // increment element count in list
	}
	
	/**
	 * Removes an element from end of the list.
	 * O(1)
	 */
	public void remove()
	{
		this.deleteLastElement();
	}
	
	/**
	 * Removes first occurrence of element from the list.
	 * @param element Element to remove
	 */
	public void remove(Object element)
	{
		// Get the index of the given element
		int index = this.indexOf(element);
		
		// Element not found
		if(index == -1 )
		{
			throw new NoSuchElementException("Element not found: " + element);
		}
		
		// Remove element at index
		this.removeAt(index);
	}
	
	/**
	 * Removes an element from list at a given index.
	 * O(n) due to shift operation
	 * @param index	Index to remove element from
	 * 
	 * Initial
	 * size = 4
	 * index 	0 1 2 3
	 * content  a b c d
	 * 
	 * After removal of b at index 1
	 * index	0 1 2 3
	 * content	a c d null
	 * 
	 * 1st iteration of shift
	 * i = 1
	 * a[1] = a[2]
	 * index 	0 1 2 3
	 * content	a c c d
	 * 
	 * 2nd iteration of shift
	 * i = 2
	 * a[2] = a[3]
	 * index	0 1 2 3
	 * content	a c d d
	 * 
	 * Null out last element
	 * index	0 1 2 3
	 * content	a c d null
	 * 
	 */
	public void removeAt(int index)
	{
		// Check boundary
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException("Index out of bound exception");
		}
		
		// shift elements leftward
		for(int i = index; i < this.size - 1; i++)
		{
			this.data[i] = this.data[i + 1];
		}
		
		this.data[this.size - 1] = null; // Null out last element
		this.size--; // decrement size
	}
	
	/**
	 * Clears out the entire array with null and set size to zero
	 * O(n) 
	 */
	public void clear()
	{
		// Null out array elements
		for(int i = 0; i < this.size; i++)
		{
			this.data[i] = null;
		}
		
		// reset size to zero
		this.size = 0;
	}
	
	/**
	 * Sets the element at the specified index.
	 * O(1) overwrites the element at the given index
	 * @param index Array index
	 */
	public void setAt(Object element, int index)
	{
		// Boundary check
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException("Index out of bound exception");
		}
		
		this.data[index] = element;
	}
	
	
	/**
	 * Gets the element at the specified index.
	 * O(1)
	 * @param index Array index
	 */
	public Object getAt(int index)
	{
		// Boundary check
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException("Index out of bound exception");
		}
		
		return this.data[index];
	}
	
	/**
	 * Get of index of the specified element
	 * @param element
	 * @return Index of given element
	 */
	public int indexOf(Object element)
	{
		int index = -1; // assume -1 for element not found
		
		// iterate array
		for(int i = 0; i < this.size(); i++)
		{
			// found element
			if(data[i] != null && data[i].equals(element))
			{
				return i;
			}
		}
		
		// element not found
		return index;
	}
	
	/**
	 * Fetch number of elements in the list currently
	 * O(1)
	 * @return number of elements in list
	 */
	public int size()
	{
		return this.size;
	}
	
	/**
	 * Determines if the list is empty
	 * @return true if empty list; false otherwise
	 */
	public boolean isEmpty()
	{
		return this.size == 0;
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
	
	/**
	 * Deletes the last element in the list.
	 * O(1)
	 */
	private void deleteLastElement()
	{
		// No elements to remove
		if(this.size == 0)
		{
			throw new RuntimeException("List is empty: No elements to remove.");
		}
		
		this.size--; // decrement elements in list
		this.data[size] = null; // remove element
	}
	
	/**
	 * Removes the first element from list.
	 * O(n) due to shifting elements
	 */
	public void deleteFirstElement()
	{
		// shift elements leftward by one spot
		for(int index = 0; index < this.size - 1; index++)
		{
			this.data[index] = this.data[index + 1]; // Replace current with the next element 
		}
		
		this.data[size - 1] = null; // clear the last element
		size--; // decrement number of elements in list
	}
	
	/**
	 * Adds the provided element to the end of the list.
	 * O(1) - location is known due to the number counter
	 * O(1) amortized - happens when the array needs to expand due to the capacity being exceeded
	 * @param element Element to add to the list
	 */
	private void appendElement(Object element)
	{
		// Expand array if capacity has been exceeded
		if(this.size == this.capacity)
		{
			this.expand(); 	// Allocate more space to the new array and copy content from old array
		}
		
		this.data[this.size] = element; // add element to end of the list
		this.size++; // increment number of elements in list
	}
	
	/**
	 * Expands the capacity of the list.
	 * A new array is created with 
	 * new capacity =  current capacity + (binary right shift current capacity)
	 * and the content are copy from the old array
	 */
	private void expand()
	{
		int newCapacity = this.capacity + (this.capacity >> 1);
		Object[] newArray = new Object[newCapacity]; // create new array with a higher capacity
		
		// Copy content from the old array to the new array
		for(int i = 0; i < this.size; i++)
		{
			newArray[i] = this.data[i];
		}
		
		this.data = newArray; // reference field to the new array
		this.capacity = newCapacity; // set to the new capacity
	}
}
