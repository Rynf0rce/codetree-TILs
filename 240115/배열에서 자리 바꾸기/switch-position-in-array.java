import java.util.*;

class Node{
    Node left;
    int idx;
    Node right;

    public Node(int idx){
        this.left = null;
        this.idx = idx;
        this.right = null;
    }
}

public class Main {
    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }
    
        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void popAndInterchange(Node n1, Node n2, Node n3, Node n4){
        boolean chack = false;
        Node n1Left = n1.left;
        Node n2Right = n2.right;
        Node n3Left = n3.left;
        Node n4Right = n4.right;

        if(n2.right == n3){
            chack = true;
        }

        connect(n1.left, n2.right);
        n1.left = n2.right = null;
        connect(n3.left, n4.right);
        n3.left = n4.right = null;

        if(chack){
            connect(n1Left, n3);
            connect(n2, n4Right);
            connect(n4, n1);
        }
        else{
            connect(n4, n2Right);
            connect(n1Left, n3);
            connect(n3Left, n1);
            connect(n2, n4Right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        
        int N = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            nodeMap.put(i, new Node(i));
            if(nodeMap.containsKey(i-1)){
                connect(nodeMap.get(i-1), nodeMap.get(i));
            }
        }

        int Q = sc.nextInt();
        Node head = nodeMap.get(1);
        for(int i = 0 ; i < Q ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            popAndInterchange(nodeMap.get(a), nodeMap.get(b), nodeMap.get(c), nodeMap.get(d));
            if(nodeMap.get(c).left == null){
                head = nodeMap.get(c);
            }
            else if(nodeMap.get(a).left == null){
                head= nodeMap.get(a);
            }
        }

        // 출력부
        while(head.right != null){
            System.out.print(head.idx + " ");
            head = head.right;
        }
        System.out.print(head.idx);
    }
}