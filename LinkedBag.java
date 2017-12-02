package com.company;

/**
 A class of bags whose entries are stored in a chain of linked nodes.
 The bag is never full.
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.1
 */
public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;       // Reference to first node
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty

    public int getCurrentSize()
    {
        return numberOfEntries;
    } // end getCurrentSize

    public boolean add(T newEntry)  	      // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode;      // New node is at beginning of chain
        numberOfEntries++;

        return true;
    } // end add

    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        } // end while

        return result;
    } // end toArray

    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;

        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
            {
                frequency++;
            } // end if

            counter++;
            currentNode = currentNode.getNextNode();
        } // end while

        return frequency;
    } // end getFrequencyOf

    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while

        return found;
    } // end contains

    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while

        return currentNode;
    } // end getReferenceTo

    public void clear()
    {
        while (!isEmpty())
            remove();
    } // end clear

    public T remove()
    {
        T result = null;
        if (firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode(); // Remove first node from chain
            numberOfEntries--;
        } // end if

        return result;
    } // end remove

    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null)
        {
            nodeN.setData(firstNode.getData());  // Replace located entry with entry in first node

            firstNode = firstNode.getNextNode(); // Remove first node
            numberOfEntries--;

            result = true;
        } // end if

        return result;
    } // end remove

    private class Node
    {
        private T    data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node
} // end LinkedBag
