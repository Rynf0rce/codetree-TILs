import java.util.*;

class Node{
    Node prev;
    String text;
    Node next;

    public Node(String text){
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

public class Main {
    public static void setLeft(Node setNode, Node rightNode){
        setNode.next = rightNode;
        setNode.prev = rightNode.prev;

        if(setNode.next != null){
            setNode.next.prev = setNode;
        }
        
        if(setNode.prev != null){
            setNode.prev.next = setNode;
        }
    }

    public static void setRight(Node setNode, Node leftNode){
        setNode.prev = leftNode;
        setNode.next = leftNode.next;

        if(setNode.prev != null){
            setNode.prev.next = setNode;
        }

        if(setNode.next != null){
            setNode.next.prev = setNode;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Node cur = new Node(str);

        int N = sc.nextInt();

        for(int i = 0 ; i < N; i++){
            int key = sc.nextInt();
            Node addNode;
            switch(key){
                case 1 :
                    str = sc.next();
                    addNode = new Node(str);
                    setLeft(addNode, cur);
                    break;
                case 2 :
                    str = sc.next();
                    addNode = new Node(str);
                    setRight(addNode, cur);
                    break;
                case 3 :
                    if(cur.prev != null){
                        cur = cur.prev;
                    }
                    break;
                case 4 :
                    if(cur.next != null){
                        cur = cur.next;
                    }
                    break;
            }
            System.out.print(cur.prev == null ? "(Null) " : cur.prev.text + " ");
            System.out.print(cur.text + " ");
            System.out.print(cur.next == null ? "(Null) " : cur.next.text + " ");
            System.out.println();
        }
    }
}