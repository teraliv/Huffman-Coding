/*
 *  Tester.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/27/15
 */

import java.util.Map;

public class Tester {

    public static void main(String[] args) {

        String message = "eeyjjjj";

        HuffmanFrequencyTable hft = new HuffmanFrequencyTable(message);

        HuffmanTree ht = new HuffmanTree(hft.getLeaves());

        HuffmanTreeNode subTree = ht.getHuffmanTree();

        Encoder encoder = new Encoder(subTree);
        encoder.makeHuffmanBitCodeTable(subTree);

        Map<Character, String> bitCode = encoder.getBitCodeData();
        printTable(hft.getCharFrequency(), bitCode);

        String huffmanCode = makeHuffmanCode(message, bitCode);

        Decoder decoder = new Decoder(huffmanCode, subTree);
        decoder.decodeMessage();
    }


    public static void printTable(Map<Character, Integer> theFrequency, Map<Character, String> theBitCode) {

        System.out.println("=======================================");
        System.out.println("char        frequency       code");
        System.out.println("---------------------------------------");

        for (Character key : theFrequency.keySet()) {
            System.out.printf("%-11c %-15d %-15s\n", key, theFrequency.get(key), theBitCode.get(key));
        }

        System.out.println("=======================================");
    }


    private static String makeHuffmanCode(String theMessage, Map<Character, String> theBitCode) {

        StringBuilder huffmanCode = new StringBuilder();

        int size = 0;

        for (int i = 0; i < theMessage.length(); i++) {
            huffmanCode.append(theBitCode.get(theMessage.charAt(i)));
            size += theBitCode.get(theMessage.charAt(i)).length();
        }

        System.out.println("Encoded bit stream: ");
        System.out.println(huffmanCode);
        System.out.println("Total number of bits without Huffman coding: " + theMessage.length() * 16);
        System.out.println("Total number of bits with Huffman coding: " + size);

        return huffmanCode.toString();
    }

}
