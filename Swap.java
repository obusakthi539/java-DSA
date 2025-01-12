import java.util.*;
public class Swap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
         a=a+b; //5 6=>a=11
         b=a-b; //11-6=>5
         a=a-b;//11-5=>6
         System.out.println(a+" "+b);
    }
}
