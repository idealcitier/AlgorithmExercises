class Queue{
    private int MaxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    // ----------------------------------------------
    public Queue(int s){
        MaxSize = s;
        queArray = new long[MaxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    // -------------insert
    public void insert(long j){
        if(rear == MaxSize - 1){
            rear = -1;
        queArray[++rear] = j;
        }
    }
}