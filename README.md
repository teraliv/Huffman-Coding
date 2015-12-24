# TCSS342 Huffman Coding
#### Compressing string data using Huffman Coding

Sample output:<br/>
<b>% java Tester "My Test works totally fine" </b>

char | frequency | code
---- | --------- | ----
M    | 1         | 01111 
y    | 2         | 1000
     | 4         | 000
T 	| 1 		  | 01110
e 	| 2 		  | 0011
s 	| 2 		  | 0010
t 	| 3 		  | 101
w 	| 1 		  | 01101 
o 	| 2		  | 0101 
r 	| 1 		  | 01100 
k 	| 1 		  | 1111 
a 	| 1 		  | 1110 
l 	| 2 		  | 0100 
f 	| 1 		  | 1101 
i 	| 1 		  | 1100 
n 	| 1 		  | 1001


Encoded bit stream:<br>
0111110000000111000110010101000011010101011001111001000010101011011 1100100010010000001101110010010011<br>
Total number of bits without Huffman coding: 416<br>
Total number of bits with Huffman coding: 101<br>
Decoded String: My Test works totally fine<br>
