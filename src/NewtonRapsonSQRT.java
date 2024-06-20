import java.util.Scanner;

public class NewtonRapsonSQRT {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = s.nextInt();
        double x = n;
        double root;
        while(true){
            root = 0.5*(x + n/x);

            if(Math.abs(root - x) < 0.5) break;

            x = root;
        }
        System.out.println(root);

    }
}
