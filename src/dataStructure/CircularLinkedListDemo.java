package dataStructure;

public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList(new NodeBi(1, null, null));
        list.addData(2, null);
        list.addData(3, null);

        list.showAllData();

    }
}

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    public CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.head;
    }

    public boolean isEmpty(){
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            NodeBi newNode = new NodeBi(data, null, null);
            this.head = newNode;
            this.tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else if (beforeData == null){
            NodeBi newNode = new NodeBi(data,this.head,this.tail);
            this.tail.next = newNode;
            this.head.prev = newNode;
            this.tail = newNode;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;
            do {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        NodeBi newNode = new NodeBi(data,this.head,this.tail);
                        this.tail.next = newNode;
                        this.head.prev = newNode;
                        this.head = newNode;
                    } else {
                        NodeBi newNode = new NodeBi(data, cur, pre);
                        pre.next = newNode;
                        cur.prev = newNode;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while(cur != this.head);
        }
    }

    public void removeData(int data){
        if(this.isEmpty()) {
            System.out.println("리스트가 비어있습니다.");
            return ;
        }
        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                } else if (cur == this.tail) {
                    pre.next = this.tail.next;
                    this.tail = pre;
                    this.head.prev = this.tail;
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
    public void showAllData(){
        if (this.isEmpty()) {
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        NodeBi cur = this.head;
        while (cur.next != this.head) {
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
}
