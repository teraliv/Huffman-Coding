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

    // List of HuffmanTree Nodes with data: characters and frequency
    private List<HuffmanTreeNode> myLeaves;


    /**
     * Constructs Huffman Tree.
     *
     * @param theLeaves - list of Huffman Tree Nodes.
     */
    public HuffmanTree(List<HuffmanTreeNode> theLeaves) {

        myLeaves = theLeaves;
        makeHuffmanTree();
    }

    /**
     * A method to print Huffman Tree Nodes character data and frequency.
     */
    public void printList() {

        for (int i = 0; i < myLeaves.size(); i++) {
            System.out.printf("%c - %d\n", myLeaves.get(i).getData(), myLeaves.get(i).getFrequency());
        }
    }


    /**
     * A method to make a Huffman Tree
     */
    private void makeHuffmanTree() {

        int minA, minB;
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
    }

    /**
     * A method got get a root of a Huffman Tree.
     *
     * @return - returns the root of a Huffman Tree.
     */
    public HuffmanTreeNode getHuffmanTree() {
        return myLeaves.get(0);
    }

    /**
     * A helper method to find the minimum frequency value.
     *
     * @return - returns the list index with the minimum frequency value.
     */
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
