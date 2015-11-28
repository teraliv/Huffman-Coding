/*
 *  Decoder.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/27/15
 */

public class Decoder {

    private String myMessage;
    private HuffmanTreeNode myRoot;

    public Decoder(String theMessage, HuffmanTreeNode theRoot) {
        myMessage = theMessage;
        myRoot = theRoot;
    }

    public void printMessage() {
        System.out.println(myMessage);
    }


    public void decodeMessage() {

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

        System.out.println("\nDecoded message: " + message);
    }
}
