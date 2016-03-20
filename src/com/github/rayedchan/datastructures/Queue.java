package com.github.rayedchan.datastructures;

import java.util.NoSuchElementException;

/**
 * Queue Implementation
 * First-In-First-Out (FIFO) Data Structure
 * @author rayedchan
 * @see https://en.wikipedia.org/wiki/Queue_(abstract_data_type)
 */
public class Queue<T>
{
	// Inner Node class
	private static class Node<T>
	{
		private T data;
		private Node<T> next;
		
		public Node(T data, Node<T> next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<T> tail; // Reference to the last item in the list
	private int size; // Number of items in list
	
	/**
	 * Constructor for an empty Queue 
	 */
	public Queue()
	{
		this.tail = null;
		this.size = 0;
	}
	
	/**
	 * Adds an item to the end of the queue
	 * O(1)
	 * @param item
	 */
	public void enqueue(T item)
	{
		// Construct the new node with the given item
		Node<T> newNode = new Node<T>(item, null); 
		
		// Empty list Case
		if(this.tail == null)
		{
			this.tail = newNode; // set the new node as the tail
			newNode.next = newNode; // set "next" pointer to the node itself
		}
		
		// At least one other item in the list
		else
		{
			newNode.next = this.tail.next; // set new node to point first item
			this.tail.next = newNode; // set current tail node to point to new node
			this.tail = newNode; // set the new node as the tail node
		}
		
		// Increment size
		this.size++;
	}
	
	/**
	 * Removes item from the front of the list
	 * O(1)
	 * @param item
	 * @return Item at the front of the list
	 */
	public T dequeue()
	{
		// Empty list case
		if(this.tail == null)
		{
			throw new NoSuchElementException("Nothing to remove");
		}
		
		// Single item case
		else if(this.tail == this.tail.next)
		{
			T retVal = this.tail.data;
			this.tail = null; // null out list
			return retVal;
		}
		
		// At least two items in list
		else
		{
			T retVal = this.tail.next.data;
			this.tail.next = this.tail.next.next;
			return retVal;
		}
	}
	
	/**
	 * String representation
	 */
	@Override
	public String toString()
	{
		Node<T> tmp = this.tail; // start at tail
		int count = 0;
		StringBuffer result = new StringBuffer();
		result.append("[");
		
		// traverse list
		while(tmp != null)
		{
			tmp = tmp.next; // move to next node
			
			if(count == 0)
			{
				result.append(tmp.data);
			}
			
			else
			{
				result.append(", ");
				result.append(tmp.data);
			}
			
			count++;
			
			// Reached the tail node; end loop
			if(tmp == this.tail)
			{
				tmp = null;
			}
		}
		
		result.append("]");
		return result.toString();
	}
}

