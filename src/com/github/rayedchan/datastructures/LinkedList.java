package com.github.rayedchan.datastructures;

/**
 * Linked List
 * @see 
 * <a href="https://en.wikipedia.org/wiki/Linked_list">Linked List Wiki</a>
 * <a href="https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java">Example</a>
 * @author rayedchan
 */
public class LinkedList 
{
	// Generic Node Class
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
	
	public static void main(String[] args)
	{
		Node<Integer> head = new Node<Integer>(5, null);
	}
}