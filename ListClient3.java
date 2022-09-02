//Student ID: R00221283
public class ListClient3
{
    public static void main(String[] args)
    {  System.out.println("Create an empty list.");
       ListInterface<String> mylist = new EnhancedLinkedList<String>();
   
       System.out.println("List should be empty; isEmpty returns " + 
                          mylist.isEmpty() + ".");

       System.out.println("\nTesting add to end:");
       mylist.add("15");
       mylist.add("25");
       mylist.add("35");
       mylist.add("45");
       mylist.add(2,"55");
       mylist.remove(3);
       mylist.replace(1,"69");
       mylist.contains("25");
       mylist.isEmpty();
       System.out.println("List should contain 15, 25, 35, 45.");
       displayList(mylist);
       System.out.println("List should be empty; isEmpty returns " + 
                          mylist.isEmpty() + ".");     
       
       System.out.println("\nTesting clear():");
       mylist.clear();

       System.out.println("List should be empty; isEmpty returns " + 
                          mylist.isEmpty() + ".");    
    }

    private static void displayList(ListInterface<String> list)
    {   int numOfEntries = list.getLength();
        
        System.out.println("The list contains " + numOfEntries + " entries, as follows:");

        for (int pos = 1; pos <= numOfEntries; pos++)
          System.out.println(list.getEntry(pos) + " is entry " + pos);
        System.out.println();
    }
}