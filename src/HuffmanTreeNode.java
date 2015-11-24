/*
 *  HuffmanTreeNode.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/22/15
 */

public class HuffmanTreeNode {

    private Character myData;
    private int myFrequency;
    private HuffmanTreeNode myLeft;
    private HuffmanTreeNode myRight;

    public HuffmanTreeNode(Character theData, int theFrequency) {
        myData = theData;
        myFrequency = theFrequency;
        myLeft = null;
        myRight = null;
    }


    public Character getData() {
        return myData;
    }


    public int getFrequency() {
        return myFrequency;
    }


    public HuffmanTreeNode getLeft() {
        return myLeft;
    }


    public HuffmanTreeNode getRight() {
        return myRight;
    }


    public void setData(Character theData) {
        myData = theData;
    }


    public void setMyFrequency(int theFrequency) {
        myFrequency = theFrequency;
    }


    public void setLeft(HuffmanTreeNode theLeft) {
        myLeft = theLeft;
    }


    public void setRight(HuffmanTreeNode theRight) {
        myRight = theRight;
    }

    @Override
    public String toString() {
        return "Node: [data=" + myData + ", frequency=" + myFrequency + ", left=" + myLeft + ", right=" + myRight + "]";
    }
}
