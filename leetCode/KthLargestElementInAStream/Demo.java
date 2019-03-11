import java.util.*;
class Demo{
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kth = new KthLargest(k, arr);
        int num = kth.add(3);
        System.out.println(num);
        num = kth.add(5);
        System.out.println(num);
        num = kth.add(10);
        System.out.println(num);
        num = kth.add(9);
        System.out.println(num);
        num = kth.add(4);
        System.out.println(num);
    }
}