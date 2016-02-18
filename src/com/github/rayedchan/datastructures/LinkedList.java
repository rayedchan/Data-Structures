package com.github.rayedchan.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Singly Linked List
 * @see 
 * <a href="https://en.wikipedia.org/wiki/Linked_list">Linked List Wiki</a>
 * <a href="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html">CMU Lectures</a>
 * <a href="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java">Example</a>
 * @author rayedchan
 */
public class LinkedList<T>
{
	private Node<T> head; // reference to the first node in list if any
	private int size; // Number of nodes in the list
	
	/**
	 * Constructor
	 */
	public LinkedList()
	{
		this.head = null; // Empty list
		this.size = 0; // zero nodes
	}
	
	/**
	 * Adds to the beginning of the list.
	 * O(1)
	 */
	public void addFirst(T item)
	{
		//Node<T> newNode = new Node<T>(item, null); // Create new node
		//
		// Case 1: Empty list
		//if(this.head == null)
		//{
		//	this.head = newNode; // Use new node as the head
		//}
		//
		// Case 2: At least 1 item in list
		//else
		//{
		//	newNode.next = this.head; // move new node next pointer to refer to head
		//	this.head = newNode; // Set new node as head
		//}
		
		this.head = new Node<T>(item, this.head); // Concise version
	}
	
	/**
	 * Appends item to the end of the list
	 * O(n) - need to traverse to the end of the list
	 * @param item add to list
	 */
	public void addLast(T item)
	{
		// Empty list case
		if(this.head == null)
		{
			this.addFirst(item);
		}
		
		// At least an item in list
		else
		{
			Node<T> tmp = this.head; // temporary pointer starting at head
			
			// Traverse until temporary point is at the last node in list
			while(tmp.next != null)
			{
				tmp = tmp.next;
			}
			
			tmp.next = new Node<T>(item, null); // Set last node's next pointer to the new node
		}
	}
	
	/**
	 * Adds a new node after the target node
	 * O(n) inserting the new node at the end of the list
	 * @param key	Target node data
	 * @param toInsert	New node data
	 */
	public void insertAfter(T key, T toInsert)
	{
		Node<T> tmp = this.head;
		
		// Move temporary pointer on target node
		while(tmp != null && !tmp.data.equals(key))
		{
			tmp = tmp.next;
		}
		
		// If match found, set new node's next to temporary next node. Then set temporary's next to the new node.
		if(tmp != null)
		{
			tmp.next = new Node<T>(toInsert,tmp.next);
		}
	}
	
	/**
	 * Insert before the target node
	 * O(n)
	 * @param key	Data of the target node
	 * @param toInsert	New node data
	 */
	public void insertBefore(T key, T toInsert)
	{
		boolean found = false;
		Node<T> prev = null; // Previous pointer
		Node<T> curr = this.head; // Current pointer
		
		// iterate list to find the target node
		while(curr != null)
		{
			// Found the target node
			if(curr.data.equals(key))
			{
				found = true;
				break;
			}
			
			else
			{
				// Move both pointers forward
				prev = curr;
				curr = curr.next;
			}
		}
		
		// Target found case
		if(found)
		{
			Node<T> newNode = new Node<T>(toInsert, curr); // Create new node pointing to the current node
			
			// New head case
			if(prev == null)
			{
				this.head = newNode; // Set new node as the head of the list
			}
			
			// Insert in between previous and current pointers
			else
			{
				prev.next = newNode; // Set previous node to point to the new node
			}
		}
	}
	
	/**
	 * Removes the first occurrence of target node 
	 * @param key	Target node data to remove
	 */
	public void remove(T key)
	{
		// Empty List
		if(this.head == null)
		{
			throw new RuntimeException("cannot delete");
		}
		
		// Target node at the beginning of the list
		if(this.head.data.equals(key))
		{
			this.head = head.next;
			return;
		}
		
		Node<T> prev = null;
		Node<T> curr = this.head;
		
		// Found target node
		while(curr != null && !curr.data.equals(key))
		{
			prev = curr;
			curr = curr.next;
		}
		
		// Remove target node
		if(curr != null)
		{
			prev.next = curr.next;
		}
		
		else
		{
			throw new RuntimeException("target node not found");
		}
	}
	
	/**
	 * Gets the item at specified position
	 * @param index	position of the item to return
	 * @return the item at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	public T get(int index)
	{
		// Check index boundary
		if(index < 0 || index >= this.size)
		{
			throw new IndexOutOfBoundsException(index + "< 0 || " + index + " >= " + this.size); 
		}
		
		Node<T> tmp = this.head; // Create a temporary pointer starting at the head
		
		// Traverse list until temporary pointer is on the target node 
		for(int i = 0; i < index; i++)
		{
			tmp = tmp.next; // move to next node
		}
		
		return tmp.data; // return data on current node
	}
	
	/**
	 * String representation of list
	 */
	@Override
	public String toString()
	{
		Node<T> tmp = this.head;
		int count = 0;
		StringBuffer result = new StringBuffer();
		result.append("[");
		
		// traverse list
		while(tmp != null)
		{
			if(count == 0)
			{
				result.append(tmp.data);
			}
			
			else
			{
				result.append(", ");
				result.append(tmp.data);
			}
			
			tmp = tmp.next;
			count++;
		}
		
		result.append("]");
		return result.toString();
	}

	// Inner Class: Node
	private static class Node<T>
	{
		private T data; // Store generic object types
		private Node<T> next; // a pointer to next node if any 
		
		// Node Constructor 
		public Node(T data, Node<T> next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	/**
	 * Creates an iterator for the list
	 * @return  Iterator Object
	 */
	public Iterator<T> iterator()
	{
	   return new LinkedListIterator();
	}
	
	// Inner Class: Iterator
	private class LinkedListIterator implements Iterator<T>
	{
		private Node<T> nextNode; // pointer for iteration 
		
		/**
		 * Constructor
		 */
		public LinkedListIterator()
		{
			this.nextNode = head;
		}
		
		@Override
		public boolean hasNext()
		{
			return this.nextNode != null;
		}

		@Override
		public T next() 
		{
			// Check if current node is null 
			if(this.nextNode == null)
			{
				throw new NoSuchElementException();
			}
			 
	        T currData = this.nextNode.data; // Get current node data
	        this.nextNode = this.nextNode.next; // Move pointer forward
	        return currData;
		}
	}
}