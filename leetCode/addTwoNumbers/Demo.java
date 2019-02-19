class Demo{
    // 向链表的最后插入节点
    public void addNode(Node node){
        Node head = new Node(0);
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }    

    public void traverse(Node node){
        Node tmp = head.next;
    }

    public static void main(String args[]){

    }






}
