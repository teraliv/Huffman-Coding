/*
 *  HuffmanTreeNode.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/22/15
 */

public class HuffmanTreeNode {

    // Node's data
    private Character myData;

    // The frequency of the character in Huffman Tree
    private int myFrequency;

    // Left side of a node
    private HuffmanTreeNode myLeft;

    // Right size of a node
    private HuffmanTreeNode myRight;

    /**
     * Constructs a new Huffman Tree Node.
     *
     * @param theData - the character data.
     * @param theFrequency - the frequency of a character.
     */
    public HuffmanTreeNode(Character theData, int theFrequency) {
        myData = theData;
        myFrequency = theFrequency;
        myLeft = null;
        myRight = null;
    }

    /**
     * A method that returns Node's data
     *
     * @return - returns Node's data
     */
    public Character getData() {
        return myData;
    }

    /**
     * A method that gets Node's character frequency.
     *
     * @return - returns Node's character frequency.
     */
    public int getFrequency() {
        return myFrequency;
    }

    /**
     * A method to get left side of a node.
     *
     * @return - returns left side of a node.
     */
    public HuffmanTreeNode getLeft() {
        return myLeft;
    }

    /**
     * A method to get right side of a node.
     *
     * @return - returns right side of a node.
     */
    public HuffmanTreeNode getRight() {
        return myRight;
    }

    /**
     * A mehod to set the character data of the node.
     *
     * @param theData - the data to set to a node.
     */
    public void setData(Character theData) {
        myData = theData;
    }

    /**
     * A method to set the frequency of the character of the node.
     *
     * @param theFrequency - the frequency of the character.
     */
    public void setMyFrequency(int theFrequency) {
        myFrequency = theFrequency;
    }

    /**
     * A method to set left side of a node.
     *
     * @param theLeft - left side of a node.
     */
    public void setLeft(HuffmanTreeNode theLeft) {
        myLeft = theLeft;
    }

    /**
     * A method to set right side of a node.
     *
     * @param theRight - right side of a node.
     */
    public void setRight(HuffmanTreeNode theRight) {
        myRight = theRight;
    }

    @Override
    public String toString() {
        return "Node: [data=" + myData + ", frequency=" + myFrequency + ", left=" + myLeft + ", right=" + myRight + "]";
    }
}
