
public interface List<E> {
   // Adds the specified element to the end of the list.
   void add(E e);
   
   // Returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   E get(int index);
   
   // Removes all elements and sets size to 0.
   public void clear();
   
   // Removes the first occurrence of the specified element, if it is present.
   // Returns true if the list has been modified.
   boolean remove(E e);
   
   // Returns the number of elements.
   int size();
}