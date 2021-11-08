//Maryam Sadat Safavi
import java.util.Scanner;

public class LinkrdLst {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        LinkedList list = new LinkedList();
        while (true) {
            String input = sc.nextLine();
            if (input.split(" ")[0].equals("push")) {
                list.push(Integer.parseInt(input.split(" ")[1]));
            } else if (input.split(" ")[0].equals("pop")) {
                list.pop();
            } else if (input.split(" ")[0].equals("sort")) {
                list.sort();
            } else if (input.split(" ")[0].equals("print")) {
                list.print();
            } else if (input.split(" ")[0].equals("finish")) {
                System.exit(0);
            }
        }
    }
}

class LinkedList<Integer> {
    private Node head = null;
    private int size = 0;

    private class Node<Integer> {
        private int data;
        private Node<Integer> next;

        public Node(int d) {
            data = d;
            next = null;
        }

        public int getElement() {
            return this.data;
        }

        public Node<Integer> getNext() {
            return this.next;
        }

    }

    public void push(int x) {
        Node temp = new Node<>(0);
        temp.data = x;
        temp.next = head;
        head = temp;
        size++;
    }

    public void pop() {
        if (size != 0) {
            int elmnt = head.getElement();
            head = head.getNext();
            size--;
        } else {
            return;
        }
    }

    public void sort() {
        //bubble sort
        Node frst = head, scnd = null;
        int temp;
        if (head == null) {
            return;
        } else {
            while (frst != null) {
                scnd = frst.next;
                while (scnd != null) {
                    if (frst.data > scnd.data) {
                        temp = frst.data;
                        frst.data = scnd.data;
                        scnd.data = temp;
                    }
                    scnd = scnd.next;
                }
                frst = frst.next;
            }
        }
    }

    public void print() {
        Node currNode = this.head;
        int i = 0;
        if (size == 0) {
            System.out.println("list is empty");
        } else {
            while (i < size) {
                if (i == size - 1) {
                    System.out.print(currNode.data);
                } else {
                    System.out.print(currNode.data + " ");
                }
                currNode = currNode.next;
                i += 1;
            }
            System.out.println();
        }
    }
}