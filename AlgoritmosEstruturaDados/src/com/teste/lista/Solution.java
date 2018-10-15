package com.teste.lista;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // <summary>
    //     Given the head of a singly linked list,
    //     swap the order of each pair of elements.
    // </summary>
    // <param name="head">
    //     The head of the list.
    // </param>
    // <remarks>
    //     class Node {
    //        int data;
    //        Node next;
    //     }
    //
    //     Example:
    //         Input:  null
    //         Output: null
    //
    //         Input:  (1)
    //         Output: (1) -> null
    //
    //         Input:  (1) -> (2) -> (3) -> (4) -> (5)
    //         Output: (2) -> (1) -> (4) -> (3) -> (5) -> null
    //
    //         Input:  (1) -> (2) -> (3) -> (4) -> (5) -> (6)
    //         Output: (2) -> (1) -> (4) -> (3) -> (6) -> (5) -> null
    // </remarks>

    public Node swapPairs(Node head) {
	//Creates the temporary node to be worked
        Node nodeTemp = head; 
        //Check if the node is point to some other node and if is not null
        while (nodeTemp != null && nodeTemp.next != null) {
            //swap the data
            int k = nodeTemp.data; 
            nodeTemp.data = nodeTemp.next.data; 
            nodeTemp.next.data = k; 
            //set the next Node not handled
            nodeTemp = nodeTemp.next.next; 
         } 
      return head;
    }


//    /* Recursive function to pairwise swap elements of a linked list */
//    void pairWiseSwap(int a, struct node 
//        *head){ 
//  /* There must be at-least two nodes in the list */
//  if (head != NULL && head -> next != NULL) {
//            /* Swap the node's data with data of next node */
//            swap( & head -> data,  & head -> next -> data);
//
//            /* Call pairWiseSwap() for rest of the list */
//            pairWiseSwap(head -> next -> next);
//        }
//    }
    
    
    public class Node {

        private Node next;

        private int data;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return this.data;
        }

        public String toString() {
            if (next != null) {
                return String.format("(%s) -> %s", data, next);
            } else {
                return String.format("(%s) -> null", data);
            }
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();

        System.out.println("\nTesting odd input...");
        solution.testOddInput();

        System.out.println("\nTesting even input...");
        solution.testEvenInput();

        System.out.println("\nTesting small input...");
        solution.testSmallInput();

        System.out.println("\nTesting null input...");
        solution.testNullInput();
    }

    public void testOddInput() {
        Node head = createList(5);
        System.out.println(String.format("Input:  %s", head.toString()));

        head = swapPairs(head);
        System.out.println(String.format("Output: %s", head.toString()));
    }

    public void testEvenInput() {
        Node head = createList(6);
        System.out.println(String.format("Input:  %s", head.toString()));
   
        head = swapPairs(head);
        System.out.println(String.format("Output: %s", head.toString()));
    }

    public void testSmallInput() {
        Node head = new Node(1);
        System.out.println(String.format("Input:  %s", head.toString()));

       head = swapPairs(head);
       System.out.println(String.format("Output: %s", head.toString()));
    }

    public void testNullInput() {
        System.out.println("Input:  null");

        Node head = swapPairs(null);
        System.out.println(
            String.format("Output: %s", head == null ? "null" : head.toString())
        );
    }

    public Node createList(int count) {
        List<Node> nodes = new ArrayList<Node>();

        for (int i = 1; i <= count; i++){
            nodes.add(new Node(i));
        }

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).setNext(nodes.get(i + 1));
        }

        return nodes.get(0);
    }
}