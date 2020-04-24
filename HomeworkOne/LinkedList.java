import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Stack<E> {
   private Node<E> first, last;
   private int size = 0;
   
   // Construct a new empty list.
   public LinkedList() {
      first = last = new Node<>(null, null);
   }
   
   // Adds element e to the end of the list.
   public void add(E e) {
      last.next = new Node<>(e, null);
      last = last.next;
      ++size;
   }
   
   // Returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   public E get(int index) {
      if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException();
      Node<E> t = first.next;
      for (int i = 0; i < index; ++i)
         t = t.next;
      return t.data;
   }
   


  // Returns a string representation of the linked list.
   public String toString() {
      
     
      String n ="";
      Node<E> curr = first.next; 
      while(curr != null){
        n+=curr.data + " "; 
        curr = curr.next;
      }
     return "[ " + n + "]"; 
   
   }
   
      
   
   // Removes all elements.
   public void clear() {
      // Fill in.
      size = 0;
      first = last = new Node<>(null,null);
      
    }
 // Removes the first occurrence of the specified element, if it is present.
// Returns true if the list has been modified.  
   public boolean remove(E e) {
      // Fill in.
      Node<E> node = first;
      
    
      while(!(node.next.data.equals(e))){
        if(last == node.next) {
          last = node;
        }
        node = node.next;
        node.next = node.next.next;
        size--;
        return true;
      }
      return false;
   
   }
  // Returns the number of elements.
   public int size() {
      return size;
   }
   
   // Adds element e to the top of the stack.
   public void push(E e) {
      // Fill in.
      Node<E> n = new Node<>(e, null);
      n.next = first.next;
      first.next = n; 
      ++size;
   }

   // Removes and returns the top element of the stack,
   // or throws a NoSuchElementException if the stack is empty.
   public E pop() {
      // Fill in.
      if(size == 0)
        throw new NoSuchElementException();
      first = first.next;
         size--;  
      return first.data;
   }

   // Returns but does not remove the top element of the stack,
   // or throws a NoSuchElementException if the stack is empty.
   public E top() {
      // Fill in.
      if(size == 0)
          throw new NoSuchElementException();
      return first.next.data; 
   }
   
   private static class Node<E> {
      E data;
      Node<E> next;
      Node(E data, Node<E> next) {
         this.data = data;
         this.next = next;
      }
   }
}