/*
 *  HuffmanFrequencyTable.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/22/15
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HuffmanFrequencyTable {

    public static void main(String[] args) {

        String text = "My Test works totally fine";

        List<HuffmanTreeNode> leaves = new ArrayList<HuffmanTreeNode>();

        leaves = makeFrequencyTable(text, leaves);


        // LinkedHashMap is used to keep original ordering of chars
        Map<Character, Integer> charFreqTable = new LinkedHashMap<>();

        for (int i = 0; i < leaves.size(); i++) {
            charFreqTable.put(leaves.get(i).getData(), leaves.get(i).getFrequency());
        }

        HuffmanTree tree = new HuffmanTree(leaves);

        HuffmanTreeNode root = tree.getHuffmanTree();

        Encoder enc = new Encoder(root);
        enc.inOrderTraversal(root);

        Map<Character, String> bitCode = enc.getBitCodeTable();

        printTable(charFreqTable, bitCode);
        makeHuffmanCode(text, bitCode);

    }



    private static List<HuffmanTreeNode> makeFrequencyTable(String text, List<HuffmanTreeNode> leaves) {

        int[] frequency = new int[text.length()];
        char[] characters = new char[text.length()];

        int index = 0;
        int tableSize = 0;
        char currentChar;

        for (int i = 0; i < text.length(); i++) {

            currentChar = text.charAt(i);

            // TODO: 11/22/15 reimplement if char is exists with ArrayList
            if (!charIsInTable(characters, currentChar)) {
                characters[index] = currentChar;
                frequency[index] = findCharOccurences(text, currentChar, i);
                leaves.add(new HuffmanTreeNode(currentChar, findCharOccurences(text, currentChar, i)));
                index++;
                tableSize++;
            }
        }

        return leaves;
    }

    private static int findCharOccurences(String theText, char theChar, int theIndex) {

        int count = 0;

        for (int i = theIndex; i < theText.length(); i++) {
            if (theChar == theText.charAt(i))
                count++;
        }

        return count;
    }

    private static boolean charIsInTable(char[] theCharacters, char theChar) {

        boolean result = false;

        for (int i = 0; i < theCharacters.length; i++) {

            if (theChar == theCharacters[i])
                result = true;
        }

        return result;
    }


    private static void sortFrequencyTable(int theFrequency[], char theCharacters[], int size) {

        int freqTemp;
        char charTemp;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {

                // swap elements
                if (theFrequency[i] > theFrequency[j]) {

                    // swap occurrences
                    freqTemp = theFrequency[i];
                    theFrequency[i] = theFrequency[j];
                    theFrequency[j] = freqTemp;

                    // swap characters according to occurrences swap
                    charTemp = theCharacters[i];
                    theCharacters[i] = theCharacters[j];
                    theCharacters[j] = charTemp;
                }
            }
        }

        /*for (int k = 0; k < size; k++) {
            System.out.printf("%d - %c\n", theFrequency[k], theCharacters[k]);
        }*/
    }

    private static void printTable(Map<Character, Integer> theFrequency, Map<Character, String> theBitCode) {

        System.out.println("=======================================");
        System.out.println("char        frequency       code");
        System.out.println("---------------------------------------");

        for (Character key : theFrequency.keySet()) {
            System.out.printf("%-11c %-15d %-15s\n", key, theFrequency.get(key), theBitCode.get(key));
        }

        System.out.println("=======================================");
    }

    private static void makeHuffmanCode(String theMessage, Map<Character, String> theBitCode) {

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

    }

//    private static void printTable(List<HuffmanTreeNode> theLeaves) {
//
//        System.out.println("=======================================");
//        System.out.println("char        frequency       code");
//        System.out.println("---------------------------------------");
//
//        for (int i = 0; i < theLeaves.size(); i++) {
//            System.out.printf("%-11c %-15d\n", theLeaves.get(i).getData(), theLeaves.get(i).getFrequency());
//        }
//
//        System.out.println("=======================================");
//    }
}
