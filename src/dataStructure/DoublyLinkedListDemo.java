package dataStructure;

public class DoublyLinkedListDemo{
    public static void main(String[] args) {
        DoulbyLinkedList list = new DoulbyLinkedList(new NodeBi(1,null,null));
        list.addData(22222,null);
        list.addData(224,null);
        list.addData(24,null);

        list.removeData(224);


        list.showAllData();
        list.showAllDataFromTail();


    }
}

class NodeBi{
    int data;
    NodeBi next ;
    NodeBi prev;

    public NodeBi(int data, NodeBi next, NodeBi perv) {
        this.data = data;
        this.next = next;
        this.prev = perv;
    }
}

class DoulbyLinkedList extends LinkedList{
    NodeBi head;
    NodeBi tail;

    public DoulbyLinkedList(NodeBi head) {
        this.head = head;
        this.tail = head;
    }

    public boolean isEmpty(){
        if(this.head == null) return true;
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if(this.head == null){
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        } else if(beforeData == null){
            this.tail.next = new NodeBi(data,null,this.tail);
            this.tail = this.tail.next;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;
            while (cur.next != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new NodeBi(data,cur,null);
                        this.head.next.prev = this.head;
                    } else {
                        pre.next = new NodeBi(data,cur,pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        NodeBi cur = this.head;
        NodeBi pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if(cur == this.head && cur == this.tail){
                     this.head = null;
                     this.tail = null;
                } else if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.tail){
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    pre.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void showAllData() {
        if (this.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        NodeBi cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public void showAllDataFromTail() {
        if (this.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        NodeBi cur = this.tail;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.prev;
        }
    }
}
