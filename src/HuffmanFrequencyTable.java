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

    // A string to be encoded.
    private String myMessage;

    // List of HuffmanTree Nodes with data: characters and frequency
    private List<HuffmanTreeNode> myLeaves;

    // The frequency of character data.
    private Map<Character, Integer> myCharFrequency;


    /**
     * Constructs a new huffman frequency table.
     *
     * @param theMessage - the message to be encoded.
     */
    public HuffmanFrequencyTable(String theMessage) {
        myMessage = theMessage;
        myLeaves = new ArrayList<>();
        myCharFrequency = new LinkedHashMap<>();

        makeLeavesNodes();
        makeFrequencyTable();
    }

    /**
     * A helper method to make huffman tree nodes with data: char and frequency.
     */
    private void makeLeavesNodes() {

        int[] frequency = new int[myMessage.length()];
        char[] characters = new char[myMessage.length()];

        int index = 0;
        char currentChar;

        for (int i = 0; i < myMessage.length(); i++) {

            currentChar = myMessage.charAt(i);

            if (!charIsInTable(characters, currentChar)) {
                characters[index] = currentChar;
                frequency[index] = findCharOccurences(myMessage, currentChar, i);
                myLeaves.add(new HuffmanTreeNode(currentChar, findCharOccurences(myMessage, currentChar, i)));
                index++;
            }
        }

    }

    /**
     * A helper method to make frequency table.
     */
    private void makeFrequencyTable() {

        for (int i = 0; i < myLeaves.size(); i++) {
            myCharFrequency.put(myLeaves.get(i).getData(), myLeaves.get(i).getFrequency());
        }
    }

    /**
     * A helper method to find the number of character occurrences in a string.
     *
     * @param theText - the string to find char occurrences.
     * @param theChar - the character to find occurrences.
     * @param theIndex - the starting index in a string.
     * @return - returns the number of occurrences.
     */
    private int findCharOccurences(String theText, char theChar, int theIndex) {

        int count = 0;

        for (int i = theIndex; i < theText.length(); i++) {
            if (theChar == theText.charAt(i))
                count++;
        }

        return count;
    }

    /**
     * A helper method to check if a char is in table.
     *
     * @param theCharacters - array of characters.
     * @param theChar - a char to check.
     * @return - returns true if char is in table, otherwise false.
     */
    private static boolean charIsInTable(char[] theCharacters, char theChar) {

        boolean result = false;

        for (int i = 0; i < theCharacters.length; i++) {

            if (theChar == theCharacters[i])
                result = true;
        }

        return result;
    }

    /**
     * A method that returns the list of huffman tree nodes.
     *
     * @return - returns a list of huffman tree nodes.
     */
    public List<HuffmanTreeNode> getLeaves() {
        return myLeaves;
    }

    /**
     * A method that returns a map with character and its frequency.
     *
     * @return - returns a map with character and its frequency.
     */
    public Map<Character, Integer> getCharFrequency() {
        return myCharFrequency;
    }

}
