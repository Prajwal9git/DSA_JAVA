import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] a = {"a"};
        System.out.println(longestCommonPrefix(a));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder pref = new StringBuilder();
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int min = Math.min(s1.length() - 1, s2.length() - 1);
        for(int i = 0; i<=min; i++){
            if(s1.charAt(i) != s2.charAt(i)) return pref.toString();
            pref.append(s1.charAt(i));
        }

        return pref.toString();
    }
}
