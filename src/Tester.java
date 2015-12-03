/*
 *  Tester.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/27/15
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;

public class Tester {

    private static PrintWriter writer = null;

    public static void main(String[] args) {

        try {
            writer = new PrintWriter(new FileOutputStream("output.txt"));


            String message = args[0];

            HuffmanFrequencyTable hft = new HuffmanFrequencyTable(message);

            HuffmanTree ht = new HuffmanTree(hft.getLeaves());

            HuffmanTreeNode subTree = ht.getHuffmanTree();

            Encoder encoder = new Encoder(subTree);

            Map<Character, String> bitCode = encoder.getBitCodeData();
            printTable(hft.getCharFrequency(), bitCode);

            String huffmanCode = makeHuffmanCode(message, bitCode);

            Decoder decoder = new Decoder(huffmanCode, subTree);

            String decodedMessage = "Decoded string: " + decoder.decodeMessage();
            System.out.println(decodedMessage);
            writer.println(decodedMessage);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (writer != null)
                writer.close();
        }


    }


    /**
     * A method to print huffman tree data.
     */
    private static void printTable(Map<Character, Integer> theFrequency, Map<Character, String> theBitCode) {

        System.out.println("=======================================");
        System.out.println("char        frequency       code");
        System.out.println("---------------------------------------");

        writer.println("=======================================");
        writer.println("char        frequency       code");
        writer.println("---------------------------------------");

        for (Character key : theFrequency.keySet()) {
            System.out.printf("%-11c %-15d %-15s\n", key, theFrequency.get(key), theBitCode.get(key));
            writer.printf("%-11c %-15d %-15s\n", key, theFrequency.get(key), theBitCode.get(key));
        }

        System.out.println("=======================================");
        writer.println("=======================================");
    }

    /**
     * A method to make huffman code.
     */
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

        writer.println("Encoded bit stream: ");
        writer.println(huffmanCode);
        writer.println("Total number of bits without Huffman coding: " + theMessage.length() * 16);
        writer.println("Total number of bits with Huffman coding: " + size);

        return huffmanCode.toString();
    }

}
