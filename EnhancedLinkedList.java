/**
 * A class that implements a list of objects using a linked list. 
 * Duplicated entries are allowed.
 * 
 * @author Jing Hua Ye
 * @date Oct/30/2021
 * @version 1.0
 */
 public class EnhancedLinkedList<T> implements ListInterface<T>
 {
/* =============================================================================
                        HELPER CLASSES
   =============================================================================
 */
    /**
     * A class represents a node, which contains two parts - data and pointer 
     * to the next node
     */
     private class Node
     {    //the data of a node
          private T data;
          //pointer to the next node
          private Node next;
   
          /**
           * To create a new node instance with a specific data
           * @param data the data of a specific node
           */
           public Node(T data)
           {
               this.data=data;
           }
      
          /**
           * To create a new node instance with a specific data and pointer of 
           * the next node
           * @param data the data of a specific node
           * @param next the pointer of a specific next node
           */
           public Node(T data, Node next)
           {
               this.data=data;
               this.next=next;
           }

          /**
           * To get the data of this node 
           * @return the data of this Node
           */
           public T getData()
           {
               return data;
           }

          /**
           * To get the pointer of the next node 
           * @return the pointer of the next Node
           */
           public Node getNextNode()
           {
               return next;
           }

          /**
           * To set the data of this node 
           * @param data the data of this node 
           */
           public void setData(T data)
           {
               this.data=data;
           }   
          
          /**
           * To set the pointer of next node 
           * @param nextNode the pointer of the next node 
           */
           public void setNextNode(Node nextNode)
           {
               this.next=next;
           }
     }
/* ============================================================================
                        INSTANCE VARIABLES
   ============================================================================
 */
     //the header node and the tail node
     private Node head, tail;

     //the number of entries in the list
     private int numEntries;

/* ============================================================================
                        CONSTRUCTORS
   ============================================================================
 */
     /**
      * A default constructor 
      */
      public EnhancedLinkedList()
      {
         Node head;
         Node tail;
         numEntries=0;          //creating the head and tail and initialising the number of entries to zero
      }
/* =============================================================================
                       INSTANCE METHODS
   =============================================================================
 */
/* ---------------------- Getters --------------------------------------------*/
    /**
     * Gets the length of this list.
     * @return the integer number of entries currently in the list
     */
     public int getLength()
     {
         return numEntries;
     }
/* ---------------------- Other Methods --------------------------------------*/
    /**
     * Add a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry the object to be added as a new entry
     */
     public void add(T newEntry)
     {
        Node newNode = new Node(newEntry);

         if(head==null){
            head=newNode;
         }
         else {
             tail.next=newNode;
         }
         tail=newNode;
         numEntries++;
     }
    
    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position are 
     * at the next higher position within the list.
     * The list's size is increased by 1.
     * 
     * @param newPosition an integer that specifies the desired position 
     * of the new entry
     * @param newEntry the object to be added as a new entry
     * @throws IndexOutOfBoundsException if either newPosition < 1 or 
     * mewPosition > getLength() - 1
     */
     public void add(int newPosition, T newEntry)
     {  if (newPosition >= 1 && newPosition <= numEntries + 1) {
         Node newNode = new Node(newEntry);
         if (head == null) {         //if the list is empty
             head = newNode;
             tail = newNode;
         } else if (newPosition == 1) {
             newNode.next = head;      //setting newnodes next equal to head
             head = newNode;
         } else if (newPosition == numEntries + 1) {
             tail.next = newNode;
             tail = newNode;
         } else {
             Node temp;
             temp = head;
             for (int i = 1; i < newPosition - 1; i++) {
                 if (temp != null) {
                     temp = temp.next;
                 }
             }

             //5. If the previous node is not null, make
             //   newNode next as temp next and temp next
             //   as newNode.
             if (temp != null) {
                 newNode.next = temp.next;
                 temp.next = newNode;
             }
         }

         numEntries++;

     }
        else
           throw new IndexOutOfBoundsException("Illegal position given to add operation");
     }
    
    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given position
     * are at the next lower position within the list.
     * 
     * @param givenPosition an integer that indicates the position of the 
     * entry to be removed
     * @return A pointer to the removed entry
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or 
     * givenPosition > getLength()
     */
     public T remove(int givenPosition)    
     {

         if (givenPosition >= 1 && givenPosition <= numEntries)
       {
           Node old = null;

           if(numEntries==1){
               tail=old;
           }
           else{
               Node current = head;


               for(int i=0;i<givenPosition-1;i++){
                   //travelling through the list to reach the position
                   current=current.next;
               }

               old = current.next;
               current.next=old.next;
               //now to decrement the number of entries


           }
           if(givenPosition == numEntries){ //meaning we want to remove the tail
               tail=old;
       }

            numEntries--;
           return null;

          }
          else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation");

     }


    /**
     * Replaces the entry at a given position in this list.
     * 
     * @param givenPosition an integer that indicates the position of the entry 
     * to be replaced
     * @param newEntry the object that will replace the entry at the position  
     * givenPosition
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or 
     * givenPosition > getLength()
     */
     public T replace(int givenPosition, T newEntry)
     { if (givenPosition >= 1 && givenPosition <= numEntries)
       {
//First Delete
           Node old = null;

           if(numEntries==1){
               tail=old;
           }
           else{
               Node current = head;


               for(int i=0;i<givenPosition-1;i++){
                   //travelling through the list to reach the position
                   current=current.next;
               }

               old = current.next;
               current.next=old.next;
               //now to decrement the number of entries


           }
           if(givenPosition == numEntries){ //meaning we want to remove the tail
               tail=old;
           }

           numEntries--;



//then add
           Node newNode = new Node(newEntry);
           if (head == null) {         //if the list is empty
               head = newNode;
               tail = newNode;
           } else if (givenPosition == 1) {
               newNode.next = head;      //setting newnodes next equal to head
               head = newNode;
           } else if (givenPosition == numEntries + 1) {
               tail.next = newNode;
               tail = newNode;
           } else {
               Node temp;
               temp = head;
               for (int i = 1; i < givenPosition - 1; i++) {
                   if (temp != null) {
                       temp = temp.next;
                   }
               }

               //5. If the previous node is not null, make
               //   newNode next as temp next and temp next
               //   as newNode.
               if (temp != null) {
                   newNode.next = temp.next;
                   temp.next = newNode;
               }
           }

           numEntries++;

       }
       else
         throw new IndexOutOfBoundsException("Illegal position given to replace operation");
         return (T) head;
     }
    
    /**
     * Retrieves the entry at a given position in this list.
     * 
     * @param givenPosition an integer that indicates the position of the 
     * desired entry
     * @return A pointer to the indicated entry
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or 
     * givenPosition > getLength()   
     */
     public T getEntry(int givenPosition)
     {
         T data;
         if (givenPosition >= 1 && givenPosition <= numEntries) {

             data= head.getData();
             head=head.next;

         } else
             throw new IndexOutOfBoundsException("Illegal position given to getEntry operation");

         return data;

     }

    /**
     * Sees whether this list contains a given entry.
     * 
     * @param anEntry the object that is the desired entry
     * @return true if the list contains anEntry, otherwise false
     */
     public boolean contains(T anEntry)
     {
         Node current = head;
         for(int i=0;i<numEntries-1;i++){
             current=current.next;
             if (current.getData()==anEntry){
                 System.out.println("Found it: " + current.getData());
                 return true;
             }
         }
         System.out.println("Its not contained");
         return false;
     }

    /**
     * Sees whether this list is empty.
     * @return true if the list is empty, otherwise false
     */
     public boolean isEmpty()
     {
         if (numEntries==0 && head==null)
         {
             return true;

         }


         return false;

     }

    /**
     * Retrieves all entries that are in this list in the order in which they
     * occur in the list.
     * 
     * @return a newly allocation array of all the entries in the list. If the 
     * list is empty, the returned array is empty.
     */
     public T[] toArray()
     {   T[] result = (T[])new Object[numEntries];
         int index = 0;
         Node currentNode = head;
         while (index < numEntries && currentNode != null)
         {   result[index] = currentNode.getData();
             currentNode = currentNode.getNextNode();
             index++;
         }
         return result;
     }
    
    /**
     * To remove all nodes in the list
     */
     public void clear()
     {  //to-complete
     }
/* =============================================================================
                       HELPER METHODS
   =============================================================================
 */
   /**
    * It traverse the whole list until we locate the node at the desired 
    * position within the list
    * @param givenPosition an integer that indicates the position of the 
    * desired entry
    */
    private Node getNodeAt(int givenPosition)
    { if (head != null && givenPosition >= 1 && givenPosition <= numEntries)
      {  Node currentNode = head;
         for (int counter = 1; counter < givenPosition; counter++)
            if (currentNode != null)
               currentNode = currentNode.getNextNode();
         return currentNode;
      }   
      return null;
    }
 }
