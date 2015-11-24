/*
 *  HuffmanTree.java
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

    public HuffmanTreeNode makeHuffmanTree() {

        int minA, minB, newFrequency;
        HuffmanTreeNode newNode;

        while (myLeaves.size() > 1) {
            minA = findMin();
            HuffmanTreeNode nodeA = myLeaves.get(minA);
            myLeaves.remove(minA);

            minB = findMin();
            HuffmanTreeNode nodeB = myLeaves.get(minB);
            myLeaves.remove(minB);

            newNode = new HuffmanTreeNode(null, nodeA.getFrequency() + nodeB.getFrequency());
            newNode.setLeft(nodeA);
            newNode.setRight(nodeB);

            myLeaves.add(newNode);

        }

//        System.out.println(myLeaves.get(0).toString());

        return myLeaves.get(0);
    }

    private int findMin() {

        int next;
        int min = myLeaves.get(0).getFrequency();
        int indexOfMin = 0;

        for (int i = 0; i < myLeaves.size() - 1; i++) {
            next = myLeaves.get(i + 1).getFrequency();

            if (min >= next) {
                min = next;
                indexOfMin = i + 1;
            }
        }


        return indexOfMin;
    }
}
