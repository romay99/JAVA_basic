package dataStructure;

import java.util.ArrayList;

public class MaxHeapDemo {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.insert(10);
        heap.insert(1);
        heap.insert(4);
        heap.insert(20);
        heap.insert(22);
        heap.insert(2);
        heap.insert(5);
        heap.printTree();
        System.out.println("삭제된 값 = " + heap.delete());
        heap.printTree();
        System.out.println("삭제된 값 = " + heap.delete());
        System.out.println("삭제된 값 = " + heap.delete());
        System.out.println("삭제된 값 = " + heap.delete());
        heap.printTree();
    }
}

class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 0 번 인덱스 안쓰기 위함
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1; // 지금 넣은 데이터의 인덱스
        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) {
            int parentVal = heap.get(cur / 2); // 부모의 인덱스는 현재위치의 나누기 2한 값
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2; // 다음 체크
        }
    }

    public Integer delete() { // root 노드를 지우고 가장 말단 노드를 루트로 옮겨와서 밑으로 내려줌
        if (heap.size() == 1) {
            System.out.println("Heap 이 비어있습니다.");
            return null;
        }
        int target = heap.get(1);

        heap.set(1, heap.size() - 1);
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftChild = cur * 2;
            int rightChild = cur * 2 + 1;
            int targetIdx = -1;

            if (rightChild < heap.size()) { // 양쪽 노드가 전부 있을때
                targetIdx = heap.get(leftChild) > heap.get(rightChild) ? leftChild : rightChild;
            } else if (leftChild < heap.size()) { // 오른쪽 노드는 없을때
                targetIdx = cur * 2;
            } else { // 자식 노드가 없을때
                break;
            }
            if (heap.get(cur) > heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target;
    }
    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}