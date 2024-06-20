//primitive datatypes are stored in stack memory whereas objects are stored in heap memory in java
//in python everything is stored in heap memory because everything is object in python

/* Strings are objects in java
* when we create two strings objects storing same value then each string doesn't store a new value
* instead they are pointing to the same memory
* if we "new" keyword to store new string
* there is something called as "String Pool" which will be present in "Heap Memory"
* if we dont use new keyword then all the string objects storing same value will point to the same value in the pool
* Else it will be created outside the pool*/


import java.util.Arrays;

public class AllAboutStrings {
    public static void main(String[] args){
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);

        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println(str3 == str2);
        System.out.println(str3 == str4);


        //BUT

        System.out.println(str1.equals(str3)); //will give true value
        //because it just compares the value present in the variable

        /*in java if we use ".toString" method for an object then it will print a value which we won't be able to understand*/
        System.out.println(new int[]{1, 2, 3});
        /*the output we will get is "[I@6acbcfc0"
        * this behaviour is encountered because we didn't explicitly mention what class we are passing
        * so the compiler will get confused
        * instead we can do this*/

        System.out.println(Arrays.toString(new int[]{1, 2, 3})); // from this we are mentioning to the to string method
        //that we are passing Arrays as object
        Integer num = 50;
        System.out.println(num.toString());
        // here we won't encounter any problem because num belongs to wrapper class of integer whih we need
        //we don't need to mention it explicitly because we declared num as Integer



    }
}
