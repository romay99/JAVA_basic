package dataStructure;

public class LinkedListDemo {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList(new Node(1,null));
        LinkedList2 list = new LinkedList2();
        list.addData(10);
        list.addData(12);
        list.addData(13);
        list.addData(14);
        list.removeData(12);
        list.removeData(10);
        list.removeData(14);

        list.showAllData();

    }
}

class Node{ // 링크드리스트 사용을 위한 노드
    int data ;
    Node next;
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

class LinkedList { // 직접구현한 링크드리스트
    Node head; // 첫번째 노드를 뜻하는 헤드

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    //맨뒤에 데이터 추가
    public void addData(int data) {
        if (this.isEmpty()) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    // 맨뒤의 데이터 삭제
    public void deleteData() {
        if (this.isEmpty()) {
            System.out.println("링크리스트가 비어있습니다.");
            return;
        }
        Node cur = this.head;
        Node prev = cur;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        if (this.head == cur) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }

    //연결리스트에서 데이터 찾기
    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("데이터를 찾았습니다.");
                return;
            }
            cur = cur.next;
        }
        System.out.println("데이터가 존재하지 않습니다.");
    }

    //연결리스트의 모든 데이터 출력하기
    public void showAllData() {
        if (this.isEmpty()) {
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            System.out.println("cur.data = " + cur.data);
            cur = cur.next;
        }
    }
}
// LinkedList 을 상속받은 LinkedList2
class LinkedList2 extends LinkedList{

    public LinkedList2() {
    }

    public LinkedList2(Node head) {
        super(head);
    }
    // 데이터 추가 메서드 업그레이드
    // 선택한 데이터 위치 앞에 노드 추가
    public void addData(int data, Integer beforeData){
        if(this.head == null) {
            this.head = new Node(data, null);
            return;
        } else if(beforeData == null) {
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data, null);
            return;
        }
        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data == beforeData) {
                if (cur == this.head) {
                    this.head = new Node(data,this.head);
                } else {
                    pre.next = new Node(data,cur);
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }

    public void removeData(int data) {
        if(this.isEmpty()) {
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        Node cur = this.head;
        Node pre = cur;
        while (cur != null) {
            if (cur.data == data) {
                if(cur == this.head){
                    this.head = cur.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}

