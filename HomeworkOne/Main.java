public class Main { //HW1

   public static void main(String[] args) {
      List<Integer> list = new LinkedList<>();
      list.add(3);                 // [3]
      list.add(5);                 // [3, 5]
      list.add(7);                 // [3, 5, 7]
      System.out.println(list);
      list.remove(new Integer(7)); // [3, 5]
      list.add(9);                 // [3, 5, 9]
      //  for (int i = 0; i < list.size(); ++i)
      //     System.out.print(list.get(i) + " ");
      // System.out.println();
      // list.clear();
      //list.remove(3);
      System.out.println(list);
      // System.out.println();
      // System.out.println();
      
      // Stack<Integer> stack = new LinkedList<>();
      //  stack.push(3);             // [3]
      //  stack.push(5);             // [5, 3]
      //  stack.push(7);             // [7, 5, 3]
      //  System.out.println(stack);
      //  System.out.println(stack.top());
      //  stack.pop();               // [5, 3]
      //  System.out.println(stack);
   }
}