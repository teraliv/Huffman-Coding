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



//    public void inOrderTraversal(HuffmanTreeNode theRoot, Character theChar) {
//
//        if (theRoot.getLeft() != null) {
//            bitCode.append(0);
//            inOrderTraversal(theRoot.getLeft(), theChar);
//            if (!myFound)
//                bitCode.deleteCharAt(bitCode.length() - 1);
//        }
//
//        if (theRoot.getData() == theChar) {
//            System.out.println(theChar);
//            myFound = true;
//            return;
//        }
//
//        if (theRoot.getRight() != null && !myFound) {
//            bitCode.append(1);
//            inOrderTraversal(theRoot.getRight(),theChar);
//            if (!myFound)
//                bitCode.deleteCharAt(bitCode.length() - 1);
//        }
//
//    }

    public void inOrderTraversal(HuffmanTreeNode theRoot) {

        if (theRoot.getLeft() != null) {
            bitCode.append(0);
            inOrderTraversal(theRoot.getLeft());
            bitCode.deleteCharAt(bitCode.length() - 1);
        }

        if (theRoot.getData() != null) {
            //System.out.println(theRoot.getData());
            //System.out.println(bitCode);
            String st = String.valueOf(bitCode);
            bitCodeTable.put(theRoot.getData(), st);
        }

        if (theRoot.getRight() != null && !myFound) {
            bitCode.append(1);
            inOrderTraversal(theRoot.getRight());
            bitCode.deleteCharAt(bitCode.length() - 1);
        }

    }

    public void printBitCode() {
        System.out.println(bitCode);
    }

    public void printBitCodeTable() {

        for (Character key : bitCodeTable.keySet()) {
            System.out.println(key + ": " + bitCodeTable.get(key));
        }
    }

    public Map<Character, String> getBitCodeTable() {
        return bitCodeTable;
    }

}
