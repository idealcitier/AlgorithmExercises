import java.util.*;
import java.io.*;

// 1,3,6,10,15,21,...

class Triangle{
    public static int triangle1(int n){
        int curr = 1;
        if(n == 1)
            return curr;
        for(int i=2;i<=n;i++){
            curr = curr + i;
        }
        return curr;
    }
    public static int triangle2(int n){
        int total = 0;
        while (n>0) {
            total = total + n;
            n--;
        }
        return total;

    }
    // demo  use recursive
    public static int triangle3(int n){
        if (n == 1) {
            return 1;
        } else {
            return(n + triangle3(n-1));    
        }
        
    }
    public static void main(String[] args) {
        // int max = 3;
        // for (int i = 1; i < max; i++) {
        //     System.out.println(triangle3(i));    
        // }
        System.out.print("Enter a num: ");
        int num = getNum();
        System.out.println(triangle3(num));
        
    }

    // public static int getNum() throws IOException{
    public static int getNum(){
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        return Integer.parseInt(content);

    }
}