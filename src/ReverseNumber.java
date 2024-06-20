public class ReverseNumber {
    public static void main(String[] args) {
        int n = 1234321;
        int reversed = reverse(n);
        System.out.println(reversed);
        System.out.println(checkPalindrome(n));
    }
    public static void normalreverseNumber(int n, int sum){

        if(n%10 == n) {
            System.out.println(sum * 10 + n);
            return;
        }
        sum = (sum*10) + (n%10);
        normalreverseNumber(n/10, sum);
    }
    public static int reverse(int n){
        int digits = (int) (Math.log10(n) + 1);
        int result = helper(n, digits);
        return result;
    }
    private static int helper(int n, int digits){
        if(n%10 == n)
            return n;
        int rem = n%10;
        return rem*(int)(Math.pow(10, digits - 1)) + helper(n/10, digits - 1);
    }
    public static boolean checkPalindrome(int n){
        return n == reverse(n);
    }
}
