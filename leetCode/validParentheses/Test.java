class Test{
    public static void main(String args[]){
        int num1 = Integer.valueOf('(');
        int num2 = Integer.valueOf(')');

        int num3 = Integer.valueOf('[');
        int num4 = Integer.valueOf(']');

        int num5 = Integer.valueOf('{');
        int num6 = Integer.valueOf('}');

        System.out.println(num1);
        System.out.println(num2);

        System.out.println(num3);
        System.out.println(num4);

        System.out.println(num5);
        System.out.println(num6);
    }
}