public class OneByNthPower {
    public static void main(String[] args) {
        int n = 9;
        int m = 1953125;
        System.out.println(NthRoot(n, m));
    }

    public static int NthRoot(int n, int m) {
        // Write your code here.
        if(m == 0 || m == 1)
            return (int)m;
        int start = 2;
        int end = m/n;
        System.out.println("End : "+end);
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            System.out.println("Mid : "+mid);
            int p = (int)Math.pow(mid, n);
            System.out.println("1/nth power of m"+p);
            if(p == m)
                return mid;
            else if(p < m)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
