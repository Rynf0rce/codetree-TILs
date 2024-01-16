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
    public static final int MAX_BEHAVIOR = 100000;
    public static Node[] nodeArr = new Node[MAX_BEHAVIOR];

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void makeLine(int start, int length){
        for(int i = start ; i < start + length ; i++){
            nodeArr[i] = new Node(i);
        }
        for(int i = start + 1 ; i < start + length ; i++){
            connect(nodeArr[i - 1], nodeArr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int curIdx = 1;
        int Q = sc.nextInt();
        nodeArr[curIdx] = new Node(curIdx);

        for(int i = 0 ; i < Q ; i ++){
            int order = sc.nextInt();

            int a = 0;
            int b = 0;
            int madeTop = 0;
            int madeTail = 0;

            switch(order){
                case 1 :
                    a = sc.nextInt();
                    b = sc.nextInt();

                    madeTop = curIdx + 1;
                    madeTail = madeTop + b - 1;

                    makeLine(madeTop, b);

                    connect(nodeArr[madeTail], nodeArr[a].right);
                    connect(nodeArr[a], nodeArr[madeTop]);

                    curIdx = madeTail;
                    break;
                case 2 :
                    a = sc.nextInt();
                    b = sc.nextInt();

                    madeTop = curIdx + 1;
                    madeTail = madeTop + b - 1;

                    makeLine(madeTop, b);

                    connect(nodeArr[a].left, nodeArr[madeTop]);
                    connect(nodeArr[madeTail], nodeArr[a]);
                    curIdx = madeTail;
                    break;
                case 3 :
                    a = sc.nextInt();
                    if(nodeArr[a].left == null || nodeArr[a].right == null){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(nodeArr[a].left.idx + " " + nodeArr[a].right.idx);
                    }
                    break;
            }
        }

    }
}