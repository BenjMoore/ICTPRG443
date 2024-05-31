package com.company.Scripts;

import java.io.*;

/**
 * This class represents a simple singly linked list implementation in Java.
 */
public class LinkedList {

    Node head; // head of list

    /**
     * This static nested class represents a node in the linked list.
     */
    static class Node {
        int data;
        Node next;

        /**
         * Constructor to create a new node with the given data.
         *
         * @param d the data to be stored in the node
         */
        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * Method to insert a new node with the given data into the linked list.
     *
     * @param list the linked list to insert the new node into
     * @param data the data to be stored in the new node
     * @return the linked list with the new node inserted
     */
    public static LinkedList insert(LinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    /**
     * Method to print the linked list.
     *
     * @param list the linked list to be printed
     */
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    /**
     * The main method to demonstrate the insertion and printing of the linked list.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        // Insert elements into the list
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);
    }
}
