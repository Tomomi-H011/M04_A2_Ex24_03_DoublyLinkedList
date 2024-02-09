/**
* Assignment: SDEV200_M04_Assignment3_Ex24_03
* File: Exercise24_03.java
* Version: 1.0
* Date: 2/8/2024
* Author: Tomomi Hobara
* Description: This program accepts user input for five numeric values. 
               Then, it prints the list in forward and backward order.
  Steps:
    1. Ask for user input.
    2. Create a two-way linked list.
    3. Create Iterator instances.
    4. Print the list in forward order.
    5. Print the list in backward order.       
*/


/* You have to use the following template to submit to Revel.
   Note: To test the code using the CheckExerciseTool, you will submit entire code.
   To submit your code to Revel, you must only submit the code enclosed between
     // BEGIN REVEL SUBMISSION

     // END REVEL SUBMISSION
*/ 
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;

public class Exercise24_03 {
  public static void main(String[] args) {
    new Exercise24_03();
  }
  
  public Exercise24_03() {
    TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
    System.out.print("Enter five numbers: ");
    Scanner input = new Scanner(System.in);
    double[] v = new double[5];
    for (int i = 0; i < 5; i++) 
      v[i] = input.nextDouble();

    list.add(v[1]);
    list.add(v[2]);
    list.add(v[3]);
    list.add(v[4]);
    list.add(0, v[0]);
    list.add(2, 10.55);
    list.remove(3);


    java.util.ListIterator<Double> iterator1 = list.listIterator();
    System.out.print("The list in forward order: ");
    while (iterator1.hasNext())
      System.out.print(iterator1.next() + " ");

    java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
    System.out.print("\nThe list in backward order: ");
    while (iterator2.hasPrevious())
      System.out.print(iterator2.previous() + " ");

  }
} 


/* Define MyList*/

interface MyList<E> extends java.util.Collection<E> {
  /** Add a new element at the specified index in this list */
  public void add(int index, E e);

  /** Return the element from this list at the specified index */
  public E get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(Object e);

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element and returns the new set. */
  public E set(int index, E e);
  
  @Override /** Add a new element at the end of this list */
  public default boolean add(E e) {
    add(size(), e);
    return true;
  }

  @Override /** Return true if this list contains no elements */
  public default boolean isEmpty() {
    return size() == 0;
  }

  @Override /** Remove the first occurrence of the element e 
   *  from this list. Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public default boolean remove(Object e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }
    else
      return false;
  }

  @Override
  public default boolean containsAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean addAll(Collection<? extends E> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean removeAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default boolean retainAll(Collection<?> c) {
    // Left as an exercise
    return true;
  }

  @Override
  public default Object[] toArray() {
    // Left as an exercise
    return null;
  }

  @Override
  public default <T> T[] toArray(T[] array) {
    // Left as an exercise
    return null;
  }
}


class TwoWayLinkedList<E> implements MyList<E> {
  private Node<E> head, tail;
  private int size;

  /** Create a default list */
  public TwoWayLinkedList() {
  }

  /** Create a list from an array of objects */
  public TwoWayLinkedList(E[] objects) {
    for (E e : objects)
      add(e);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    } else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    } else {
      return tail.element;
    }
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      } else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  /** Clear the list */
  public void clear() {
    head = tail = null;
  }

  /** Return true if this list contains the element o */
  public boolean contains(Object e) {
    //System.out.println("Implementation left as an exercise");
    return true;
  }

  /** Return the element from this list at the specified index */
  public E get(int index) {
    //System.out.println("Implementation left as an exercise");
    if (index < 0 || index >= size)
    throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
      + size);
    else{
      Node<E> current = head;
    for (int i = 1; i < index; i++)
    current = current.next;
    return current.element;
    }
  }

  /**
   * Return the index of the head matching element in this list. Return -1 if
   * no match.
   */
  public int indexOf(Object e) {
    //System.out.println("Implementation left as an exercise");
    Node<E> current = head;
    int i = 0;
    for (i = 0; i < size; i++) {
        if ((current != null) && (current.element.equals(e))) {  // Return the current index if the current element matches the given object.
          return i;
        }
        if (current == null) {  // Element is not found at the end of the list
          return -1;
        }
        current = current.next;
      }
    return -1;
  }
  
          
  
  /**
   * Return the index of the last matching element in this list Return -1 if
   * no match.
   */

  public int lastIndexOf(Object e) {
    //System.out.println("Implementation left as an exercise");
    if (tail == null) return -1; // List is empty
    
    Node<E> current = tail;
    // int i = size() - 1;
    for (int i = size() - 1; i >=0; i--) {
      if (current.element.equals(e)) {
        return i;
      }
      else {
        current = current.previous;
      }
    }
    return -1;
  }
 
  /**
   * Replace the element at the specified position in this list with the
   * specified element.
   */
  public E set(int index, E e) {
    System.out.println("Implementation left as an exercise");
    return null;
  }



  private class LinkedListIterator implements java.util.ListIterator<E> {
    
    private Node<E> current = head; // Current index

    public LinkedListIterator() {

    }
    
    public LinkedListIterator(int index) {  
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
          + size);
      
      else{
        current = head;
        int i = 1;
        while ((i <= index) && (current.next != null)) {
          current = current.next;
          i++;
        }
      }
    }
    
    public void setLast() {
  	current = tail;
    }
    
    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;   // Store current value in e
      current = current.next;  // Move the iterator to the next node
      return e;                // Return the stored value
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as an exercise");

    }

    @Override
    public void add(E e) {
      System.out.println("Implementation left as an exercise");
    }

    @Override
    public boolean hasPrevious() {
      return current != null;
    }

    @Override
    public int nextIndex() {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    @Override
    public E previous() {
      E e = current.element;
      current = current.previous;
      return e;
    }

    @Override
    public int previousIndex() {
      System.out.println("Implementation left as an exercise");
      return 0;
    }

    @Override
    public void set(E e) {
      current.element = e; // TODO Auto-generated method stub
    }
  }

  private class Node<E> {  
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(E o) {
      element = o;
    }
  }

  @Override
  public int size() {
    return size;
  }

  public ListIterator<E> listIterator() {
    return new LinkedListIterator(); 
  }
  
  public ListIterator<E> listIterator(int index) {
    return new LinkedListIterator(index); 
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

// BEGIN REVEL SUBMISSION
  /** Add an element to the beginning of the list */
  public void addFirst(E e) {    
    // Write your code here
    Node<E> newNode = new Node<>(e);   // Create a node to add
    if (tail == null) {  // If the list is empty
      head = tail = newNode;  // newNode becomes the head and the tail
      newNode.previous = null;
      newNode.next = null;
      }
    else{  // If the list is not empty
      head.previous = newNode;  // The current head's previous is linked to the new node
      newNode.next = head;  // The current head is linked to newNode's next
      newNode.previous = null;  // Nothing is in front of the new node
      head = newNode;  //newNode becomes the head
    }
    size++;  // The size is increased by one.
  }


  /** Add an element to the end of the list */
  public void addLast(E e) {
    // Write your code here
    Node<E> newNode = new Node<>(e);  // Create a node to add
    if (tail == null){  // If the list is empty
      head = tail = newNode;  // newNode becomes the head and the tail
      newNode.previous = null;
      newNode.next = null;
    }
    else{
      newNode.previous = tail;  // The new node's previous points to the current tail
      tail.next = newNode; // Link the new node with the last node
      tail = newNode;  // The new node becomes the new tail
      tail.next = null;
    }
    size++;  // The size is increased by one.
  }

  /**
   * Add a new element at the specified index in this list The index of the
   * head element is 0
   */
  public void add(int index, E e) {
    // Write your code here
    if (index == 0) addFirst(e);  // Insert a new node in the first position
    else if (index >= size) addLast(e);  // Insert a new node at the end of the list
    else {
      Node<E> current = head;  // Declare and initialize a variable
      for (int i = 1; i < index; i++)
        current = current.next;  // Traverse the list to the position just before the specified index
      Node<E> temp = current.next;  // Assign a variable to the node to be shifted
      current.next = new Node<>(e);  // Creat a new node and connect with the current node
      (current.next).next = temp;  // The new node's next is linked with the shifted node
      (current.next).previous = current;  // The new node's previous is linked with the current node
    }
    size++;  // Update the size
  }

  /**
   * Remove the head node and return the object that is contained in the
   * removed node.
   */
  public E removeFirst() {
    // Write your code here
    if (tail == null) return null;  // Return null if the list is empty
    else {
      Node<E> temp = head;  // Keep the first node temporarily
      head = head.next;  // Reassign the next node as the new head
      size--;  // Reduce the size by one
      if (head == null) tail = null;  // List is empty
      else head.previous = null;  // Nothing is in front of the new head
      return temp.element;  // Return the value of deleted node
    }
  }
  

  /**
   * Remove the last node and return the object that is contained in the
   * removed node.
   */
  public E removeLast() {
    // Write your code here
    if (size == 0 || size == 1) {  // If the list is empty or has only one node
      return removeFirst();  
    }  
    else {
      Node<E> temp = tail;  // Keep the last node temporarily
      tail = temp.previous;  // The tail's previous now becomes the new tail
      tail.next = null;  // The new tail's next becomes null
      size--;
      return temp.element;
    }
  }

  /**
   * Remove the element at the specified position in this list. Return the
   * element that was removed from the list.
   */
  public E remove(int index) {
    // Write your code here
    if (index < 0 || index >= size) return null;  // Out of range
    else if (index == 0) return removeFirst();
    else if (index == size - 1) return removeLast();
    else {
      Node<E> previous = head;  
      for (int i = 1; i < index; i++) {
        previous = previous.next; 
      }

      Node<E> current = previous.next;  // Current = Node to be removed
      previous.next = current.next;  // Disconnect the current and reconnect with the node after the current
      (previous.next).previous = previous;  // Re-route the previous pointer of the succeeding node to the previous node. 
      size--;
      return current.element;
    }
  }
}
// END REVEL SUBMISSION