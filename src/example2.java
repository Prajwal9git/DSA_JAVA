import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//hello there

public class example2 {

    public static void main(String[] args) {
        pad("", 4);
    }

    private static void pad(String p, int up) {
        if(up==0){
            System.out.println(p);
            return;
        }
        for(int i=1; i<=6 && i<=up; i++){
            pad(p+i,up-i);
        }
    }
}
