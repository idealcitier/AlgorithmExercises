class Stack{
    // 设置栈的深度为10
    int MAX_DEPTH = 10;
    // 栈当前的深度
    int depth = 0;
    // 栈的数据结构使用数组进行表示
    int[] stack = new int[MAX_DEPTH];

    // push操作
    void push(int n){
        if(depth == MAX_DEPTH - 1){
            throw new RuntimeException("栈已满，无法再添加元素。");
        }
        stack[depth++] = n;
    }
    // pop操作
    int pop(){
        if(depth == 0){
            throw new RuntimeException("栈为空");
        }
        return stack[--depth];
    }
    // 查看栈顶的元素
    int peek(){
        if(depth == 0){
            throw new RuntimeException("栈为空");
        }
        return stack[depth-1];
    }

    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        int num = s.peek();
        System.out.println(num);
        
    }
}