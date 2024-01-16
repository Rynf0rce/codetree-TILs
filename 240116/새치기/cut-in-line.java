import java.util.*;

class Node{
    Node right;
    int idx;
    int line;
    Node left;

    public Node(int idx, int line){
        this.right = null;
        this.idx = idx;
        this.line = line;
        this.left = null;
    }
}

public class Main {
    public static final int MAX_PEOPLE = 100000;
    public static final int MAX_LINE = 10;

    public static Node[] nodeArr = new Node[MAX_PEOPLE + 1];
    public static ArrayList<Integer>[] peopleList = new ArrayList[MAX_LINE + 1];
    public static int[] headArr = new int[MAX_LINE + 1];

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void pop(Node n1){
        connect(n1.left, n1.right);

        n1.left = n1.right = null;
    }

    public static void task1(Node a, Node b){
        pop(a);
        connect(b.left, a);
        connect(a, b);
    }

    public static void task2(Node a){
        pop(a);
    }

    public static void task3(Node a, Node b, Node c){
        connect(a.left, b.right);
        a.left = b.right = null;
        connect(c.left, a);
        connect(b, c);

        Node curNode = a;
        while(curNode != null){
            curNode.line = c.line;
            curNode = curNode.right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();

        for(int i = 1 ; i <= M ; i++){
            peopleList[i] = new ArrayList<Integer>();
            int curLength = sc.nextInt();
            for(int j = 0 ; j < curLength ; j++){
                int idx = sc.nextInt();
                peopleList[i].add(idx);
                nodeArr[idx] = new Node(idx, i);
                if(peopleList[i].size() > 1){
                    connect(nodeArr[peopleList[i].get(j - 1)], nodeArr[peopleList[i].get(j)]);
                }
                else{
                    headArr[i] = idx;
                }
            }
        }

        for(int i = 0 ; i < Q ; i++){
            int order = sc.nextInt();
            int a = 0;
            int b = 0;
            int c = 0;
            switch(order){
                case 1 :
                    a = sc.nextInt();
                    b = sc.nextInt();

                    if(nodeArr[a].left == null && nodeArr[a].right == null){
                        headArr[nodeArr[a].line] = -1;
                    }

                    task1(nodeArr[a], nodeArr[b]);

                    if(nodeArr[a].left == null){
                        headArr[nodeArr[b].line] = nodeArr[a].idx;
                    }
                    nodeArr[a].line = nodeArr[b].line;
                    break;
                case 2 :
                    a = sc.nextInt();
                    if(nodeArr[a].left == null){
                        if(nodeArr[a].right == null){
                            headArr[nodeArr[a].line] = -1;
                        }
                        else{
                            headArr[nodeArr[a].line] = nodeArr[a].right.idx;
                        }
                    }
                    task2(nodeArr[a]);
                    nodeArr[a].line = 0;
                    break;
                case 3 :
                    a = sc.nextInt();
                    b = sc.nextInt();
                    c = sc.nextInt();
                    task3(nodeArr[a], nodeArr[b], nodeArr[c]);
                    if(nodeArr[a].left == null){
                        headArr[nodeArr[c].line] = nodeArr[a].idx;
                    }
                    break;
            }
        }



        for(int i = 1 ; i <= M ; i++){
            if(headArr[i] == -1){
                System.out.println(-1);
                continue;
            }
            Node curNode = nodeArr[headArr[i]];
            while(curNode != null){
                System.out.print(curNode.idx + " ");
                curNode = curNode.right;
            }
            System.out.println();
        }

        
    }
}