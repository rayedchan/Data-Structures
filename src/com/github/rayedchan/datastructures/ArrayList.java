package com.github.rayedchan.datastructures;

/**
 * ArrayList implementation
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
	int num; // current size of list
	static final int DEFAULT_CAPACITY = 10;
	
	// Invariants:
	// num = # of elements in the list
	// 0 <= num <= capacity
	// data array: first num slots filled, followed by nulls 
	
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
		this.data = new Object[this.capacity]; // null zero  
		this.num = 0; // zero elements
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
	 * @param element	New element to add tp list
	 * @param index	Index to add the element to
	 */
	public void insertAt(Object element, int index)
	{
		// TODO:
	}
	
	/**
	 * Removes an element from the list.
	 * @param element	Item to add
	 */
	public void remove()
	{
		this.deleteLastElement();
	}
	
	/**
	 * Gets the element at the specified index.
	 * O(1)
	 * @param index Array index
	 */
	public Object getAt(int index)
	{
		// Boundary check
		if(index < 0 || index >= this.num)
		{
			throw new IndexOutOfBoundsException("Index out of bound exception");
		}
		
		return this.data[index];
	}
	
	/**
	 * Sets the element at the specified index.
	 * O(1) overwrites the element at the given index
	 * @param index Array index
	 */
	public void setAt(Object element, int index)
	{
		// Boundary check
		if(index < 0 || index >= this.num)
		{
			throw new IndexOutOfBoundsException("Index out of bound exception");
		}
		
		this.data[index] = element;
	}
	
	/**
	 * Fetch number of elements in the list currently
	 * @return number of elements in list
	 */
	public int size()
	{
		return this.num;
	}
	
	/**
	 * Deletes the last element in the list.
	 * O(1)
	 */
	private void deleteLastElement()
	{
		// No elements to remove
		if(this.num == 0)
		{
			throw new RuntimeException("List is empty: No elements to remove.");
		}
		
		this.num--; // decrement elements in list
		this.data[num] = null; // remove element
	}
	
	/**
	 * Removes the first element from list.
	 * O(n) due to shifting elements
	 */
	private void deleteFirstElement()
	{
		// shift elements leftward by one spot
		for(int index = 0; index < this.num - 1; index++)
		{
			this.data[index] = this.data[index + 1]; // Replace current with the next element 
		}
		
		this.data[num - 1] = null; // clear the last element
		num--; // decrement number of elements in list
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
		if(this.num == this.capacity)
		{
			this.expand(); 	// Allocate more space to the new array and copy content from old array
		}
		
		this.data[this.num] = element; // add element to end of the list
		this.num++; // increment number of elements in list
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
		for(int i = 0; i < this.num; i++)
		{
			newArray[i] = this.data[i];
		}
		
		this.data = newArray; // reference field to the new array
		this.capacity = newCapacity; // set to the new capacity
	}
	
}
