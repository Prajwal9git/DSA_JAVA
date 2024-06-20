import java.util.Scanner;

public class PrimeOrNot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = s.nextInt();
        sieve(n);
    }

    private static void sieve(int n) {
        boolean prime[] = new boolean[n+1];
        for(int i = 2; i*i<=n; i++){
            if(!prime[i]){
                for(int j = i*2; j<=n; j+=i) //here i*2 because for a number its next multiple is its 2nd multiple since the current number is prime its next multiple wont be
                    prime[j] = true;
            }
        }
        for(int i = 2; i<=n; i++){
            System.out.println(i+" "+prime[i]);
        }
    }
}
