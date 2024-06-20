public class DividionUsingBit {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 10;
        int result = divide(dividend, divisor);
        System.out.println(result);
    }
    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long xdividend = Math.abs((long) dividend);
        long xdivisor = Math.abs((long) divisor);
        long quotient = 0;

        int x = 0;
        while(xdividend >= xdivisor){
            x = 0;
            while(xdividend >= xdividend*(1<<(x+1))){
                x+=1;
            }
            xdividend -= xdivisor*(1<<x);
            quotient += 1<<x;
        }
        quotient *= sign;
        if(quotient > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(quotient < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)quotient;
    }


}
