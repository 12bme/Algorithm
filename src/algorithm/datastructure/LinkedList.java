/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.datastructure;

/**
 *
 * @author jiseonoh
 */
public class LinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        
        // 노드의 내용을 쉽게 출력해서 확인해 볼수 있는 기능
        public String toString() {
            return String.valueOf(this.data);
        }
    }
    
    public void addFirst(Object input) {
        // 노드를 생성합니다.
        Node newNode = new Node(input);
        // 새로운 노드의 다음 노드로 헤드를 지정합니다.
        newNode.next = head;
        // 헤드의 새로운 노드를 지정합니다.
        head = newNode;
        size++;
        if(head.next == null)
            tail = head;
    }
    
    public void addLast(Object input) {
        // 노드를 생성합니다.
        Node newNode = new Node(input);
        // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
        if(size == 0) {
            addFirst(input);
        } else {
            // 마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
            tail.next = newNode;
            // 마지막 노드를 갱신합니다.
            tail = newNode;
            // 엘리먼트의 개수를 1 증가시킵니다.
            size++;
        }
    }
    
    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) x = x.next;
        return x;
    }
    
    public void add(int k, Object input) {
        // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용한다.
        if(k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k-1);
            // k번째 노드를 temp2로 지정합니다.
            Node temp2 = temp1.next;
            // 새로운 노드를 생성합니다.
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드를 지정합니다.
            temp1.next = newNode;
            
            // 새로운 노드의 다음 노드로 temp2를 지정합니다.
            newNode.next = temp2;
            size++;
            
            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기때문
            if(newNode.next == null) {
                tail = newNode;
            }
        }
    }
    
    public Object removeFirst() {
        // 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
        Node temp = head;
        head = temp.next;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }
    
    public Object remove(int k) {
        if(k == 0) return removeFirst();
        
        // k-1번째 노드를 temp의 값으로 지정합니다.
        Node temp = node(k-1);
        // 삭제 노드를 todoDeleted에 기록해 둡니다.
        // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.
        Node todoDeleted = temp.next;
        // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
        temp.next = temp.next.next;
        // 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
        Object returnData = todoDeleted.data;
        if(todoDeleted == tail) tail = temp;
        
        // cur.next를 삭제합니다.
        todoDeleted = null;
        size--;
        return returnData;
    }
    public Object removeLast() {
        return remove(size-1);
    }
    public int size() {
        return this.size;
    }
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }
    public int indexOf(Object data) {
        // 탐색 대상이 되는 노드를 temp로 지정합니다.
        Node temp = head;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교합니다.
        while(temp.data != data) {
            temp = temp.next;
            index++;
            // temp의 값이 null이라는 것은 더이상 탐색대상이 없다는 것을 의미
            if(temp == null) return -1;
        }
        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴.
        return index;
    }
}
