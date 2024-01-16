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
    public static final int MAX_LINE = 10;
    public static final int EMPTY = -1;
    public static HashMap<Integer, Node> nodeMap = new HashMap<>();
    public static int[] topArr = new int[MAX_LINE + 1];
    public static int M;

    public static void connect(Node a, Node b){
        if(a != null){
            a.right = b;
        }

        if(b != null){
            b.left = a;
        }
    }

    public static void pop(Node a){
        connect(a.left, a.right);
        a.left = a.right = null;
    }

    public static void chackTopIdx(int idx){
        for(int i = 1 ; i <= M ; i++){
            if(topArr[i] == idx){
                if(nodeMap.get(idx).right != null){
                    topArr[i] = nodeMap.get(idx).right.idx;
                }
                else{
                    topArr[i] = -1;
                }
                return;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            nodeMap.put(i, new Node(i));
        }

        M = sc.nextInt();

        for(int i = 1 ; i <= MAX_LINE ; i++){
            topArr[i] = EMPTY;
        }
        
        int Q = sc.nextInt();

        for(int i = 1 ; i <= M ; i++){
            int length = sc.nextInt();
            int preVal = -1;
            int postVal = -1;
            for(int j = 0 ; j < length ; j++){
                if(j == 0){
                    preVal = sc.nextInt();
                    topArr[i] = preVal;
                    continue;
                }

                if(preVal != -1){
                    postVal = sc.nextInt();
                    connect(nodeMap.get(preVal), nodeMap.get(postVal));
                    preVal = postVal;
                }
                
            }
        }

        for(int i = 0 ; i < Q ; i++){
            int order = sc.nextInt();
            int a, b, c;
            switch(order){
                case 1 :
                    a = sc.nextInt();
                    b = sc.nextInt();
                    chackTopIdx(a);
                    pop(nodeMap.get(a));
                    for(int j = 1 ; j <= M ; j++){
                        if(topArr[j] == b){
                            topArr[j] = a;
                            break;
                        }
                    }
                    connect(nodeMap.get(b).left, nodeMap.get(a));
                    connect(nodeMap.get(a), nodeMap.get(b));
                
                    break;
                case 2 :
                    a = sc.nextInt();
                    chackTopIdx(a);
                    pop(nodeMap.get(a));
                    break;
                case 3 :
                    a = sc.nextInt();
                    b = sc.nextInt();
                    c = sc.nextInt();
                    chackTopIdx(a);
                    connect(nodeMap.get(a).left, nodeMap.get(b).right);
                    connect(nodeMap.get(c).left, nodeMap.get(a));
                    connect(nodeMap.get(b), nodeMap.get(c));
                    for(int j = 1 ; j <= M ; j++){
                        if(topArr[j] == c){
                            topArr[j] = a;
                            break;
                        }
                    }
                    break;
            
            }
        }

        for(int i = 1 ; i <= M ; i++){
            if(topArr[i] == -1){
                System.out.println(-1);
                continue;
            }
            Node curNode = nodeMap.get(topArr[i]);
            while(curNode != null){
                System.out.print(curNode.idx + " ");
                curNode = curNode.right;
            }
            System.out.println();
        }        
    }
}