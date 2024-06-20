import java.util.*;

class Node{
    Node right, left;
    int idx;

    public Node(int idx){
        this.right = this.left = null;
        this.idx = idx;
    }
}

public class Main {
    public static final int MAX_LINE = 10;
    public static final int MAX_TASK = 10000;
    public static HashMap<Integer, Node> nodeMap = new HashMap<>();

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void divideCircle(Node n1, Node n2){
        Node right_n1 = n1.right;
        Node right_n2 = n2.right;
        connect(n2, right_n1);
        connect(n1, right_n2);
    }

    public static void mergeCircle(Node n1, Node n2){
        Node left_n1 = n1.left;
        Node right_n2 = n2.right;
        connect(n2, n1);
        connect(left_n1, right_n2);
    }

    public static void sayNum(Node n1){
        System.out.print(n1.idx + " ");
        Node curNode = n1.right;
        while(curNode != n1){
            System.out.print(curNode.idx + " ");
            curNode = curNode.right;
        }
    }

    public static Node findminNode(Node n){
        int minIdx = n.idx;
        Node curNode = n.right;
        while(curNode != n){
            minIdx = Math.min(minIdx, curNode.idx);
            curNode = curNode.right;
        }

        return nodeMap.get(minIdx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        for(int i = 0 ; i < M ; i++){
            int size = sc.nextInt();
            int start = -1;
            int pre = -1;
            int post = -1;
            for(int j = 0 ; j < size ; j++){
                int num = sc.nextInt();
                nodeMap.put(num, new Node(num));
                if(start == -1){
                    start = num;
                    pre = num;
                }
                else{
                    post = num;
                    connect(nodeMap.get(post), nodeMap.get(pre));
                    pre = post;
                }
                connect(nodeMap.get(start), nodeMap.get(pre));
            }
        }

        for(int i = 0 ; i < Q ; i++){
            int order = sc.nextInt();
            int A, B;
            switch(order){
                case 1 :
                    A = sc.nextInt();
                    B = sc.nextInt();
                    mergeCircle(nodeMap.get(A), nodeMap.get(B));
                    break;
                case 2 :
                    A = sc.nextInt();
                    B = sc.nextInt();
                    divideCircle(nodeMap.get(A), nodeMap.get(B));
                    break;
                case 3 :
                    A = sc.nextInt();
                    sayNum(findminNode(nodeMap.get(A)));
                    break;
            }
        }
    }
}