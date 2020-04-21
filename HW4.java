import java.util.*;

public class Main { // HW4

   // Returns true if it is possible to reach the goal configuration from the initial configuration.
   static boolean isSolvable(Configuration initialConfiguration) {
      // Fill in.
      Queue<Configuration> queue = new LinkedList<>();

      queue.add(initialConfiguration);
      
      Set<Configuration> set = new HashSet<>();
      set.add(initialConfiguration);
      
      while(!queue.isEmpty()){
        Configuration temp = queue.poll();
      
      for(Configuration c:temp.getAdjacentConfigurations()){
           if(c.isGoalConfiguration())
           return true;
         else if(!set.contains(c)){
              set.add(c);
              queue.add(c);
             }
             
          }
          
        }

    
      return false;
     
   }

   public static void main(String[] args) {
      Configuration puzzle1 = new Configuration(Arrays.asList(null, 1, 3, 4, 2, 5, 7, 8, 6));
      System.out.println(isSolvable(puzzle1)); // true
      
      Configuration puzzle2 = new Configuration(Arrays.asList(3, null, 7, 2, 8, 1, 6, 4, 5));
      System.out.println(isSolvable(puzzle2)); // true
      
      Configuration puzzle3 = new Configuration(Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, null));
      System.out.println(isSolvable(puzzle3)); // false
   }

   static class Configuration {
      
      List<Integer> config;
      Configuration(List<Integer> list) {
         config = list;
      }
      
      // Returns a List of configurations adjacent to this configuration 
          List<Configuration> getAdjacentConfigurations() {
         List<Configuration> newConfigurations = new ArrayList<>();
         for (int i = 0; i < 9; ++i) {
            if (config.get(i) == null) {
               if (i > 2) { // Swap empty square with square above
                  List<Integer> newConfig = new ArrayList<>(config);
                  Collections.swap(newConfig, i, i-3);
                  newConfigurations.add(new Configuration(newConfig));
               }
               if (i < 6) { // Swap empty square with square below
                  List<Integer> newConfig = new ArrayList<>(config);
                  Collections.swap(newConfig, i, i+3);
                  newConfigurations.add(new Configuration(newConfig));
               }
               if (i % 3 != 0) { // Swap empty square with square to left
                  List<Integer> newConfig = new ArrayList<>(config);
                  Collections.swap(newConfig, i, i-1);
                  newConfigurations.add(new Configuration(newConfig));
               }
               if (i % 3 != 2) { // Swap empty square with square to right
                  List<Integer> newConfig = new ArrayList<>(config);
                  Collections.swap(newConfig, i, i+1);
                  newConfigurations.add(new Configuration(newConfig));
               }
            }
         }
         return newConfigurations;
      }

      static final List<Integer> goalConfig = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, null);
      // Returns true if this configuration is the goal configuration
      boolean isGoalConfiguration() {
         return config.equals(goalConfig);
      }
      
      // Note: The equals and hashCode methods below make it possible to use Configurations as keys in a hash table.
      public boolean equals(Object o) {
         return config.equals(((Configuration)o).config);
      }
      public int hashCode() {
         return config.hashCode();
      }
      
      // Returns a string representation of this configuration's 3x3 grid.
      public String toString() {
         String grid = "";
         for (int i = 0; i < 9; ++i)
            grid += (config.get(i) == null ? "_" : config.get(i)) + (i % 3 == 2 ? "\n" : "");
         return grid;
      }
   }
}
  
