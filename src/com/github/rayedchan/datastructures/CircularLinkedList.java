package com.github.rayedchan.datastructures;

import java.util.NoSuchElementException;

/**
 * A linked list is a linear structure consisting of nodes.
 * Each node has a data part that holds the client-supplied information, 
 * and a link that refers to the next node in the linked list. A circular linked list
 * is a linked list in which the last node refers back to the first.
 */
public class CircularLinkedList<T>
{
	Node<T> tail; // Refers to the last node in list
	int count; // Size of the linked list
	
	/**
	 * Constructor: Creates an empty linked list
	 */
	public CircularLinkedList()
	{
		this.tail = null;
		this.count = 0;
	}
	
	/**
	 * Adds specified item to the end of this linked list.
	 * O(1)
	 * @param item
	 */
	public void add(T item)
	{
		// Create new node object with item set as the data
		Node<T> newNode = new Node<T>(item);
		
		// Empty linked list 
		if(this.count == 0)
		{
			// Point new node's next field to itself
			newNode.next = newNode;
		}
		
		// Linked list with at least one node
		else
		{
			// Point the new node's next field to the first node in the linked list
			newNode.next = this.tail.next;
			
			// Point the last node's next field to the new node
			this.tail.next = newNode;
		}
		
		// Set the new node as the tail of the linked list
		this.tail = newNode;
		
		// Increment linked list's size counter 
		this.count++;
	}
	
	/**
	 * Adds specified item to this linked list at specified index. Index must
	 * refer to an existing position in the list; the existing entry will be moved over.
	 * Does not add to the end of the list or on an empty list.
	 * O(n)
	 * @param item		Data of Node
	 * @param index		Position to add node in linked list; 0 being the front of the list
	 * @throws IndexOutOfBoundsException if the index is < 0 or >= number of entries
	 */
	public void insertAt(T item, int index)
	{
		// Validate supplied index is valid
		if(index < 0 || index >= this.count)
		{
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + this.count);
		}
		
		// Find predecessor
		Node<T> pred = this.tail;
		for(int i = 0; i < index; i++)
		{
			pred = pred.next;
		}
		
		// Insert after predecessor
		Node<T> newNode = new Node<T>(item);
		newNode.next = pred.next;
		pred.next = newNode;
		count++;
	}
	
	/**
	 * Deletes first occurrence of specified item from this linked list.
	 * O(n)
	 * @param item
	 * @throws NoSuchElementException if the item is not in this linked list.
	 */
	public void remove(T item)
	{
		// Get the index of node with target item
		int i = this.indexOf(item);
		
		if(i == -1)
		{
			throw new NoSuchElementException();
		}
		
		// Remove node at given index
		this.removeAt(i);
	}
	
	/**
	 * Deletes from the linked list the entry at the specified index,
	 * and returns the data of the deleted entry.
	 * O(n)
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException if the index is < 0 or >= number of entries
	 */
	public T removeAt(int index)
	{
		// Validate supplied index is valid
		if(index < 0 || index >= this.count)
		{
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + this.count);
		}
		
		T ret = null; // for return
		if(index == 0)
		{
			ret = this.tail.next.data;
			if(this.count == 1) // single element, special case
			{
				this.tail = null;
			}
			
			else // at least two entries
			{
				this.tail.next = tail.next.next;
			}
			
			count--;
		}
		
		else // at least two entries, and index > 0
		{
			// find the entry just prior to index
			Node<T> prev = this.tail.next;
			for(int i = 0; i < index-1; i++)
			{
				prev = prev.next;
			}
			
			// remove after prev
			Node<T> curr = prev.next;
			ret = curr.data; // save for return
			prev.next = curr.next;
			curr.next = null;
			this.count--;
			
			// if tail node is deleted, set the tail to new last node in the list
			if(curr == this.tail)
			{
				this.tail = prev;
			}
		}

		return ret;
	}
	
	/**
	 * Deletes all occurrences of specified item from this linked list.
	 * O(n)
	 * @param item 		Data to be removed from list
	 * @throws NoSuchElementException if the item is not in this linked list
	 */
	public void removeAll(T item)
	{
		// Empty linked list
		if(this.count == 0)
		{
			throw new NoSuchElementException();
		}
		
		// Step through all entries
		Node<T> prev = this.tail; // Set previous pointer to start at the last node
		Node<T> curr = this.tail.next; // Set current pointer to first node in list
		int oldcount = this.count; // Number of nodes in current list 
		for(int i = 0; i < oldcount; i++)
		{
			// Delete matching item
			if(item.equals(curr.data))
			{
				prev.next = curr.next;
				curr.data = null;
				curr.next = null;
				count--;
			}
			
			else
			{
				prev = curr; // move previous pointer forward
			}
		    
			curr = prev.next; // move current pointer forward
		}
		
		// No change in linked list
		if(this.count == oldcount)
		{
			// no match
			throw new NoSuchElementException();
		}
		
		// Handles emptying list if all entries are deleted
		if(count == 0)
		{
			this.tail = null;
		}
		
		// Set tail to point to last item of new list
		else
		{
			this.tail = prev;
		}	
	}
	
	/**
	 * Deletes all entries from the linked list.
	 * O(1)
	 */
	public void clear()
	{
		// Reset the fields 
		this.tail = null;
		this.count = 0;
	}
	
	/**
	 * Sets the entry at the specified index to the specified item.
	 * Updates a node at a given index.
	 * O(n)
	 * @param item
	 * @param index
	 * @throws IndexOutOfBoundsException if the index is < 0 or >= number of entries
	 */
	public void setAt(T item, int index)
	{
		if(index < 0 || index >= this.count)
		{
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + this.count);
		}
		
		Node<T> curr = this.tail.next;
		for(int i = 0; i < index; i++)
		{
			curr = curr.next;
		}
		
		curr.data = item; // update
	}
	
	/**
	 * Returns the entry at the specified index of this linked list.
	 * O(n)
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException if the index is < 0 or >= number of entries
	 */
	public T getAt(int index)
	{
		if(index < 0 || index >= this.count)
		{
			throw new IndexOutOfBoundsException(index + " < 0 or >= " + this.count);
		}
		// skip over preceding nodes
		Node<T> curr = this.tail.next;
		for(int i = 0; i < index; i++)
		{
			curr = curr.next;
		}
		
		return curr.data;
	}
	
	/**
	 * Returns the index in this linked list of the specified item,
	 * -1 if not found.
	 * O(n)
	 * @param item	Target data to search for
	 * @return	index of first occurrence node with target data; -1 if item does not exist in list
	 */
	public int indexOf(T item)
	{
		// Empty list
		if(this.count == 0)
		{
			return -1;
		}
		
		// Step through list nodes
		Node<T> curr = tail.next; // Start at first item in list
		for(int i = 0; i < this.count; i++)
		{
			// Found node
			if(item.equals(curr.data))
			{
				return i;
			}
			
			// Move current pointer to next node in list
			curr = curr.next;
		}
		
		// Item not found in list
		return -1;
	}
	
	/**
	 * Returns the number of entries in this linked list.
	 * O(1)
	 * @return
	 */
	public int size()
	{
		return this.count;
	}
	
	/**
	 * Returns true if this linked list is empty; false otherwise.
	 * O(1)
	 * @return
	 */
	public boolean isEmpty()
	{
		return this.count == 0;
	}	
}

/**
 * Generic Node
 * Self-referential structure
 */
class Node<T>
{
	T data; // Hold generic type T data
	Node<T> next; // Reference to another Node object
	
	// Node Constructor
	Node(T data)
	{
		this.data = data;
		this.next = null;
	}
}