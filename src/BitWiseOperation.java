import java.util.Scanner;

public class BitWiseOperation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("MENU: \n1 : Odd or Even\n2 : Find no repeating no. in the array\n3 : Number Without its complement\n4 : Find nth bit\n5 : Set a bit(i.e. change the bit to 1) at Pos\n6 : Reset a bit(i.e. change the bit to 0\n");
        int n = s.nextInt();
        switch(n){
            case 1:
                System.out.println("Enter a number : ");
                int a = s.nextInt();
                if(OddOrEven(a)) System.out.println("ODD");
                else System.out.println("EVEN");
                break;
            case 2:
                System.out.println("Enter the Array size : ");
                int len_1 = s.nextInt();
                int arr_1[] = new int[len_1];
                System.out.print("Enter the array : \n");
                for(int i = 0; i<len_1; i++)
                    arr_1[i] = s.nextInt();
                System.out.println(FindNonRepeating(arr_1));
                break;
            case 3:
                System.out.println("Enter the array size : ");
                int len_2 = s.nextInt();
                int arr_2[] = new int[len_2];
                System.out.print("Enter the array : \n");
                for(int i = 0; i < len_2; i++)
                    arr_2[i] = s.nextInt();
                System.out.println(NumberWithoutComplement(arr_2));
                break;
            case 4:
                System.out.println("Enter the Digit : ");
                int digit_1 = s.nextInt();
                System.out.println("Enter the bit position you want to find : ");
                int bitPos_1 = s.nextInt();
                int bitShift = 1<<(bitPos_1 - 1);
                System.out.println(FindPosBit(digit_1, bitShift));
                break;
            case 5:
                System.out.println("Enter the Digit : ");
                int digit_2 = s.nextInt();
                System.out.println("Enter the Position to Set : ");
                int bitPos_2 = s.nextInt() - 1;
                System.out.println("Old digit : "+digit_2+" New Digit : " + setBitPos(digit_2, bitPos_2));
                break;
            case 6:
                System.out.println("Enter the Digit : ");
                int digit_3 = s.nextInt();
                System.out.println("Enter the Position to Reset : ");
                int bitPos_3 = s.nextInt();
                System.out.println("Old digit : "+digit_3+" New Digit : " + resetBitPos(digit_3, bitPos_3));
                break;

            default:
                System.out.println("Select a valid option");
                break;
        }
    }

    private static int resetBitPos(int digit, int bitPos) {
        int bitShift = 1<<(bitPos-1);
        return digit & ~bitShift;
    }

    private static int setBitPos(int digit, int bitPos) {
        int bitShift = 1<<bitPos;
        return digit | bitShift;
    }

    private static int FindPosBit(int digit, int bitShift) {
        return digit&bitShift;
    }

    private static int NumberWithoutComplement(int[] arr) {
        int sum = 0;
        for(int i : arr)
            sum += i;
        return sum;
    }

    private static int FindNonRepeating(int[] arr) {
        int unique = 0;
        for(int n:arr)
            unique ^= n;
        return unique;
    }

    private static boolean OddOrEven(int a){
        return (a&1)==1;
    }
}
