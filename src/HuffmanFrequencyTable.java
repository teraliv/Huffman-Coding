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

    private String myMessage;

    private List<HuffmanTreeNode> myLeaves;

    private Map<Character, Integer> myCharFrequency;

    public HuffmanFrequencyTable(String theMessage) {
        myMessage = theMessage;
        myLeaves = new ArrayList<>();
        myCharFrequency = new LinkedHashMap<>();

        makeLeavesNodes();
        makeFrequencyTable();
    }



    private void makeLeavesNodes() {

        int[] frequency = new int[myMessage.length()];
        char[] characters = new char[myMessage.length()];

        int index = 0;
        int tableSize = 0;
        char currentChar;

        for (int i = 0; i < myMessage.length(); i++) {

            currentChar = myMessage.charAt(i);

            // TODO: 11/22/15 reimplement if char is exists with ArrayList
            if (!charIsInTable(characters, currentChar)) {
                characters[index] = currentChar;
                frequency[index] = findCharOccurences(myMessage, currentChar, i);
                myLeaves.add(new HuffmanTreeNode(currentChar, findCharOccurences(myMessage, currentChar, i)));
                index++;
                tableSize++;
            }
        }

    }


    private void makeFrequencyTable() {

        for (int i = 0; i < myLeaves.size(); i++) {
            myCharFrequency.put(myLeaves.get(i).getData(), myLeaves.get(i).getFrequency());
        }
    }


    private int findCharOccurences(String theText, char theChar, int theIndex) {

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


    public List<HuffmanTreeNode> getLeaves() {
        return myLeaves;
    }


    public Map<Character, Integer> getCharFrequency() {
        return myCharFrequency;
    }

}
