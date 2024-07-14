// Java code to implement the above approach 

import java.util.*; 

class GFG{ 

// Function to generate the encrypted String 
static String compress(String str) 
{ 
	// Stack to store encrypted String 
	Stack<String> st = new Stack<String>(); 

	// Variable to store length of String 
	int N = str.length(); 

	// Variable to point 1st and middle index 
	int i = 0, j = N / 2; 

	// Repeat the loop until 
	// the entire String is checked 
	while (j > 0) { 
		int mid = j; 

		// Compare the subString 
		// from index 0 to mid-1 
		// with the rest of the subString 
		// after mid. 
		for (i = 0; i < mid && str.charAt(i) == str.charAt(j); i++, j++) 
			; 

		// If both subStrings are equal 
		// then repeat the same process 
		// on this subString and store 
		// the remaining String into stack 
		if (i == mid) { 
			st.add(str.substring(j, N)); 

			// Update the value of 
			// String 'str' with the 
			// longest repeating subString 
			str = str.substring(0, i); 

			// Set the new String length to n 
			N = mid; 

			// Initialize the 2nd pointer 
			// from the mid of new String 
			j = N / 2; 
		} 

		// If both subStrings are not equal 
		// then decrement the 2nd pointer by 1 
		else { 
			j = mid - 1; 
		} 
	} 

	// Pop all the elements from the stack 
	// append a symbol '*' and store 
	// in a output String 
	while (!st.isEmpty()) { 
		str = str + "*" + st.peek(); 
		st.pop(); 
	} 

	return str; 
} 

// Driver code 
public static void main(String[] args) 
{ 
	// Declare and initialize the String 
	String str = "zzzzzzz"; 

	System.out.print(compress(str)+ "\n"); 
} 
} 

