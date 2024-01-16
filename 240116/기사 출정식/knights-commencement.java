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
    public static final int MAX_KNIGHT = 100000;
    public static int[] arr = new int[MAX_KNIGHT];

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void stand(Node n1){
        connect(n1.left, n1.right);

        n1.left = n1.right = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Node> knightSet = new HashMap<>();

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
            knightSet.put(arr[i], new Node(arr[i]));
        }

        connect(knightSet.get(arr[0]), knightSet.get(arr[N - 1]));
        for(int i = 1 ; i < N ; i++){
            connect(knightSet.get(arr[i]), knightSet.get(arr[i - 1]));
        }

        for(int i = 0 ; i < M ; i++){
            int idx = sc.nextInt();
            System.out.println(knightSet.get(idx).left.idx + " " + knightSet.get(idx).right.idx);
            stand(knightSet.get(idx));
        }    
    }
}