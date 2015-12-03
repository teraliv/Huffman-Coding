/*
 *  Decoder.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/27/15
 */

public class Decoder {

    // A string to be decoded.
    private String myMessage;

    // A root of a huffman tree.
    private HuffmanTreeNode myRoot;

    /**
     * Constructs decoder for a huffman tree message.
     *
     * @param theMessage - the string to be decoded.
     * @param theRoot - the root of a huffman tree.
     */
    public Decoder(String theMessage, HuffmanTreeNode theRoot) {
        myMessage = theMessage;
        myRoot = theRoot;
    }

    /**
     * A method to print a string to be decoded.
     */
    public void printMessage() {
        System.out.println(myMessage);
    }

    /**
     * A method to decode message using huffman tree.
     */
    public String decodeMessage() {

        HuffmanTreeNode subTree = myRoot;
        StringBuilder message = new StringBuilder();
        boolean found = false;

        for (int i = 0; i < myMessage.length(); i++) {

            if (found)
                subTree = myRoot;
            found = false;

            // go left edge in a subtree
            if (myMessage.charAt(i) == '0') {
                if (subTree.getLeft().getData() == null)
                    subTree = subTree.getLeft();
                else {
                    message.append(subTree.getLeft().getData());
                    found = true;
                }

            // go right edge in a subtree
            } else {
                if (subTree.getRight().getData() == null)
                    subTree = subTree.getRight();
                else {
                    message.append(subTree.getRight().getData());
                    found = true;
                }
            }
        }

        return message.toString();
    }
}
