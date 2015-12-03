/*
 *  Encoder.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/24/15
 */


import java.util.HashMap;
import java.util.Map;

public class Encoder {

    // The root of Huffman Tree
    private HuffmanTreeNode myRoot;

    // Trigger to point that dat been find.
    private boolean myFound;

    // The bit code of a huffman tree.
    private StringBuilder bitCode;

    // Map with a char data and its bit code
    private Map<Character, String> bitCodeTable;


    /**
     * Constructs an encoder for Huffman Tree.
     *
     * @param theRoot - the root of Huffman Tree.
     */
    public Encoder(HuffmanTreeNode theRoot) {
        myRoot = theRoot;
        bitCode = new StringBuilder();
        myFound = false;
        bitCodeTable = new HashMap<>();

        makeHuffmanBitCodeTable(myRoot);
    }


    /**
     * A helper method to make huffman bit code table.
     *
     * @param myRoot - the root of a huffman tree.
     */
    private void makeHuffmanBitCodeTable(HuffmanTreeNode myRoot) {

        if (myRoot.getLeft() != null) {
            bitCode.append(0);
            makeHuffmanBitCodeTable(myRoot.getLeft());
            bitCode.deleteCharAt(bitCode.length() - 1);
        }

        if (myRoot.getData() != null) {
            String st = String.valueOf(bitCode);
            bitCodeTable.put(myRoot.getData(), st);
        }

        if (myRoot.getRight() != null && !myFound) {
            bitCode.append(1);
            makeHuffmanBitCodeTable(myRoot.getRight());
            bitCode.deleteCharAt(bitCode.length() - 1);
        }

    }

    /**
     * A method to print bit code table.
     */
    public void printBitCodeTable() {

        for (Character key : bitCodeTable.keySet()) {
            System.out.println(key + ": " + bitCodeTable.get(key));
        }
    }

    /**
     * A method that returns a mep with bit code data.
     *
     * @return - returns a map with bit code data.
     */
    public Map<Character, String> getBitCodeData() {
        return bitCodeTable;
    }

}
