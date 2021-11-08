//By Erfan Samimi
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MyLinkedList<String> helicopters = new MyLinkedList<>();
        Scanner sc = new Scanner(System.in);


        String[] temp = sc.nextLine().split(" ");
        int n = Integer.parseInt( temp[0]);
        int s = Integer.parseInt(temp[1]);

        if (n>0) {
            String[] helicopterInputs = sc.nextLine().split(" ");

            for (String str : helicopterInputs)
                helicopters.push(str);
        }


        for (int i=0 ; i<s ; i++){
            String[] command = sc.nextLine().split(" ");

            if (command[0].equals("insert"))
                helicopters.insert(command[1] , Integer.parseInt(command[2]) );

            else if (command[0].equals("relocate"))
                helicopters.relocation(command[1], Integer.parseInt(command[2]));


            else if (command[0].equals("depart"))
                helicopters.remove(command[1]);

            else if (command[0].equals("reverse"))
                helicopters.reverse(Integer.parseInt(command[1]) ,  Integer.parseInt(command[2]));


//            helicopters.print();
//            helicopters.p();
        }

        helicopters.print();
    }
}

 class MyLinkedList<T extends Comparable<T>> {

    Node<T> first;
    Node<T> last ;
    int size = 0;

    public MyLinkedList(){
        this.last = new Node<>(null,first,null);
        this.first = new Node<>(null, null , last);
    }

    public void push(T data){
        Node<T> newNode = new Node<>(data, this.first, first.after);
        Node<T> y = first.after;
        y.before = newNode;
        first.after = newNode;
        size ++;
    }

    public void insert(T data , int index){

        if (this.size == 0)
            this.push(data);

        else {
            Node<T> node = last;
            for (int i = 0; i <= index; i++) {
                node = node.before;
            }

            Node<T> y = node.after;

            Node<T> newNode = new Node<>(data, node, y);
            y.before = newNode;
            node.after = newNode;
            this.size++;
        }
    }

    public Node<T> remove(T data){
        Node<T> node = first.after;

        while (node != this.last){

            if (node.data.equals(data)){
                Node<T> y = node.before;
                Node<T> x = node.after;

                y.after = x;
                x.before = y;
                this.size --;
                return node;
            }

            node = node.after;
        }

        return new Node<T>(null, null , null);
    }


    public void relocation(T element, int displacement){
        if (displacement < 0){

            Node<T> node = remove(element);
            Node<T> n = node.after;

            for (int i=0 ; i>displacement ; i--){
                n = n.after;
            }

            Node<T> y = n.before;

            node.before = y;
            node.after = n;
            y.after = node;
            n.before = node;
            this.size ++;
        }

        else if (displacement > 0){

            Node<T> node = remove(element);
            Node<T> n = node.before;

            for (int i=0 ; i<displacement ; i++){
                n = n.before;
            }

            Node<T> x = n.after;

            node.before = n;
            node.after = x;
            n.after = node;
            x.before = node;
            this.size ++;
        }
    }

    public void reverse(int start , int end){

        int n = (end - start)/2 +1;
//        System.out.println("--- " + size);
        Node<T> startNode = this.last ;
        Node<T> stopNode = this.last;

        for (int i=0 ; i<start ; i++) {
            startNode = startNode.before;

        }


        for(int i=0 ; i<end ; i++) {
            stopNode = stopNode.before;
        }

//        System.out.println("Start : " + startNode.data);
//        System.out.println("End : " + stopNode.data);

        for (int i = 0 ; i<n ; i++){
            T y = startNode.data;
            T x = stopNode.data;
            startNode.data = x;
            stopNode.data = y;
            startNode = startNode.before;
            stopNode = stopNode.after;
        }






    }


    public void print(){

        if (this.size == 0)
            System.out.println("The airport is empty");

        else {

            String str = "";
            Node<T> node = last.before;

            while (node != this.first) {
                str += node.data + " ";
                node = node.before;
            }

            System.out.println(str);
        }
    }


}

class Node<T>{
    T data;
    Node<T> after;
    Node<T> before;

    public Node(T data, Node<T> before, Node<T> after ){
        this.data = data;
        this.after = after;
        this.before = before;
    }
}

