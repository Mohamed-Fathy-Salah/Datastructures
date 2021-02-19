package assignments;

public class A5 {
    /*
     * (Print the characters in a string reversely) Write a recursive method that
     * displays a string reversely on the console using the following header: Public
     * static void reverseDisplay(String value) For example, reverseDisplay("abcd")
     * displays dcba. Write a test program that prompts the user to enter a string
     * and displays its reversal.
     */
    public void reverseDisplay(String s) {
        reverseDisplay(s, 0);
    }

    private void reverseDisplay(String s, int i) {
        if (i == s.length()) {
            System.out.println();
            return;
        }
        reverseDisplay(s, i + 1);
        System.out.print(s.charAt(i));
    }

    /*
     * (Decimal to binary) Write a recursive method that converts a decimal number
     * into a binary number as a string. The method header is: public static String
     * dec2Bin(int value) Write a test program that prompts the user to enter a
     * decimal number and displays its binary equivalent.
     */
    public String dec2bin(int v){
        if(v == 0)return "";
        return dec2bin(v>>1)+Integer.toString(v&1);
    }
}
