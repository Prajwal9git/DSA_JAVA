public class RemoveOuterMostParentheses {
    public static void main(String[] args) {
        String rawString = "a good   example";
        System.out.println(reverseWords(rawString));
    }
    public static String reverseWords(String s) {
        int start = 0;
        int end = s.length() - 1;

        // Move start and end pointers to the first and last non-space characters
        while (start <= end && (s.charAt(start) == ' ' || s.charAt(end) == ' ')) {
            if (s.charAt(start) == ' ') start++;
            if (s.charAt(end) == ' ') end--;
        }

        // If the entire string is empty or contains only spaces, return an empty string
        if (start > end) return "";

        StringBuilder newString = new StringBuilder();
        int pointer = end;

        // Reverse each word while traversing from end to start
        while (pointer >= start) {
            // Move pointer to the end of the current word
            while (pointer >= start && s.charAt(pointer) != ' ') pointer--;
            // Append the word to the newString (inclusive of the space character)
            newString.append(s, pointer + 1, end + 1).append(" ");
            // Move end pointer to the character before the current word
            end = pointer - 1;
            // Move pointer to the next non-space character
            while (pointer >= start && s.charAt(pointer) == ' '){
                pointer--;
                //end--;
            }
        }

        // Convert StringBuilder to String and trim trailing spaces
        return newString.toString().trim();
    }
}
