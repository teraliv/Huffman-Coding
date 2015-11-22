/*
 *  HuffmanFrequencyTable.java
 *  TCSS 342 - Autumn 2015
 *
 *  Assignment 2 - Implementing Huffman Tree Coding.
 *  Alex Terikov (teraliv@uw.edu)
 *  11/22/15
 */


public class HuffmanFrequencyTable {

    public static void main(String[] args) {

        String text = "My Test works totally fine";


        int[] frequency;
        char[] characters;
        int tableSize;


        makeFrequencyTable(text);

        Object[] tableData = makeFrequencyTable(text);

        frequency =  (int[]) tableData[0];
        characters = (char[]) tableData[1];
        tableSize = (int) tableData[2];

        for (int i = 0; i < tableSize; i++) {
            System.out.printf("%c - %d\n", characters[i], frequency[i]);
        }

//        sortFrequencyTable(frequency, characters, tableSize);


    }

    private static Object[] makeFrequencyTable(String text) {

        int[] frequency = new int[text.length()];
        char[] characters = new char[text.length()];

        int index = 0;
        int tableSize = 0;
        char currentChar;

        for (int i = 0; i < text.length(); i++) {

            currentChar = text.charAt(i);

            if (!charIsInTable(characters, currentChar)) {
                characters[index] = currentChar;
                frequency[index] = findCharOccurences(text, currentChar, i);
                index++;
                tableSize++;
            }
        }

        return new Object[] {frequency, characters, tableSize};
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

}
