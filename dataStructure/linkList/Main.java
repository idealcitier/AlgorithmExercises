class Main{
    public static void main(String args[]){
    LinkList l = new LinkList();
    l.addHead("A");
    l.addHead("B");
    l.addHead("C");
    l.addHead("D");
    //打印当前链表信息
    l.display();
    //删除C
    l.delete("C");
    l.display();
    //查找B
    System.out.println(l.find("B"));

    }
}