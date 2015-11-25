package structures.linear;

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
		count++;
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
	 * Deletes all occurrences of specified item from this linked list.
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
		Node<T> prev = this.tail;
		Node<T> curr = this.tail.next;
		int oldcount = count;
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
			tail = null;
		}
		
		// Set tail to point to last item of new list
		else
		{
			this.tail = prev;
		}	
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