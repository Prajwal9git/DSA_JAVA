import java.util.ArrayList;

public class PrettyPrinting{
    public static void main(String[] args) {
        float a = 1.2323f;
        //now we are going to use formatted string
        System.out.printf("Formatted String : %.2f using %%.2f\n", a); //this we print 2 numbers after the decimal
        //it also does the round off
        System.out.printf("PIE : %.3f using %%.3f it rounds of to 3 decimals\n", Math.PI);
        System.out.println('a'+'b');
        System.out.println("a"+"b");
        System.out.println('a'+3);
        System.out.println((char)('a'+3));

        // BUT

        System.out.println("a" + 1);
        /* here we get the output as "a1" because "1" is converted to its wrapper class
        *  i.e., Integer which will call the .toString method,
        * therefore, this is the same as "a" + "1"*/


        System.out.println("Prajwal" + new ArrayList<>());
        // here .toString() method for ArrayList gives output as []

        ArrayList<Integer> al = new ArrayList();
        al.add(1);
        al.add(2);
        System.out.println("Prajwal" + al);

        //System.out.println(new Integer(56) + new ArrayList<>());
        /*this gives an error because
        * in java we can only add primitive data types or
        * while adding complex datatypes atleast one of them should be string*/
        // therefore we can do this

        System.out.println(new Integer(56) + " " + new ArrayList<>());
    }
}
