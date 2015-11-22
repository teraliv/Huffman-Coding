/*
 *  HuffmanTreeNode.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/22/15
 */

import java.util.List;

public class HuffmanTree {

    private List<HuffmanTreeNode> myLeaves;

    public HuffmanTree(List<HuffmanTreeNode> theLeaves) {
        myLeaves = theLeaves;
    }

    public void printList() {

        for (int i = 0; i < myLeaves.size(); i++) {
            System.out.printf("%c - %d\n", myLeaves.get(i).getData(), myLeaves.get(i).getFrequency());
        }
    }

    public void makeHuffmanTree() {

        System.out.println(findMin(0));

//        while (myLeaves.size() > 1) {
//
//        }

    }

    private int findMin(int theStartIndex) {

        int min = myLeaves.get(theStartIndex).getFrequency();

        for (int i = theStartIndex; i < myLeaves.size(); i++) {

        }


        return  min;
    }
}
