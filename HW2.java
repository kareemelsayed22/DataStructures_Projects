import java.io.*;
import java.util.*;

public class Main {    //HW2

   // Prints all movies that occur in both lists.
   public static void intersection(List<String> list1, List<String> list2) {
      // Fill in.
      
      // iterate through list2, add element to set1
      // iterate through list1, if set1 contains the same key, add element to set2.
      Set<String> set1 = new HashSet<String>();
      Set<String> set2 = new HashSet<String>();

       for(String i: list2) {
           set1.add(i);
       }
      
       for(String i: list1) {
         if(set1.contains(i)) {
           set2.add(i);
         }
       }
     
   System.out.println(set2);
   
   }

   // Prints all movies in the list that occur at least k times
   // (print the movie followed by the number of occurrences in parentheses).
   public static void frequent(List<String> list, int k) {
      // Fill in.
      // Create a HashMap 
      // for each element, check if its okay in the map.
      // if not create a new pair. 
      // else update the value, print all pairs with value >= k.
      Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < list.size(); i++) {
         if(map.containsKey(list.get(i))) {
          map.put(list.get(i), map.get(list.get(i))+1);
         }
         else {
           map.put(list.get(i), 1);
         }
        

       }
 
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
         
       if(entry.getValue() >= k) { 
       
       System.out.println(entry.getKey() + "(" + entry.getValue() + ")");
       
        }

      
     
      }
   }
   // Prints all movies in the list, grouped by number of characters.
   // All movies with the same number of characters are printed on the same line.
   // Movies with fewer characters are listed first.
   public static void groupByNumChars(List<String> list) {
      // Fill in.
      // Create a treemap
      // String array of movies
      // add every movie in the list to the movies array
      // Create a key based off num chars of movies[i]
      // if the key doesnt exist, insert movie and key- num of chars 
      // otherwise if it already exists add new movie to the value that contains all previous movies

      TreeMap<Integer,String> tmap = new TreeMap<>(); 
      String[] movies = new String[list.size()];
      
      for (int i = 0; i < list.size();i++){
        movies[i] = list.get(i);
      }
      for(int i = 0; i< movies.length; i++) {
        int key = movies[i].length(); // total # of chars

        if(!(tmap.containsKey(key))){
          tmap.put(key, movies[i]); 
        }
        else{
          String m = tmap.get(key) + " ";
          tmap.put(key, m + movies[i]);
        }

      }
         
    
      for (Map.Entry<Integer, String> m:tmap.entrySet()) {
          System.out.println(m.getKey() + " = " + m.getValue()); 
      }    
		   
		  
	
}
  

           

   

   // Returns a List of all movies in the specified file (assume there is one movie per line).
   public static List<String> getList(String filename) {
      List<String> list = new ArrayList<>();
      try (Scanner in = new Scanner(new FileReader(filename))) {
         while (in.hasNextLine()) {
            String line = in.nextLine();
            list.add(line);
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      return list;
   }

   public static void main(String[] args) {
      List<String> list1 = getList("imdb.txt");
      List<String> list2 = getList("sight_and_sound.txt");
      List<String> list3 = getList("3_lists.txt");

      System.out.println("***intersection***");
      intersection(list1, list2);

      System.out.println("***frequent***");
      frequent(list3, 3);

      System.out.println("***groupByNumChars***");
      groupByNumChars(list1);
   }
}