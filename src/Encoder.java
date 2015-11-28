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

    private HuffmanTreeNode myRoot;
    private boolean myFound;
    private StringBuilder bitCode;
    private Map<Character, String> bitCodeTable;


    public Encoder(HuffmanTreeNode theRoot) {
        myRoot = theRoot;
        bitCode = new StringBuilder();
        myFound = false;
        bitCodeTable = new HashMap<>();
    }


    public void makeHuffmanBitCodeTable(HuffmanTreeNode theRoot) {

        if (theRoot.getLeft() != null) {
            bitCode.append(0);
            makeHuffmanBitCodeTable(theRoot.getLeft());
            bitCode.deleteCharAt(bitCode.length() - 1);
        }

        if (theRoot.getData() != null) {
            String st = String.valueOf(bitCode);
            bitCodeTable.put(theRoot.getData(), st);
        }

        if (theRoot.getRight() != null && !myFound) {
            bitCode.append(1);
            makeHuffmanBitCodeTable(theRoot.getRight());
            bitCode.deleteCharAt(bitCode.length() - 1);
        }

    }


    public void printBitCodeTable() {

        for (Character key : bitCodeTable.keySet()) {
            System.out.println(key + ": " + bitCodeTable.get(key));
        }
    }


    public Map<Character, String> getBitCodeData() {
        return bitCodeTable;
    }

}
