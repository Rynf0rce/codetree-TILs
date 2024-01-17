import java.util.*;

class Node{
    Node left,right;
    String name;

    public Node(String name){
        this.left = this.right = null;
        this.name = name;
    }
}

public class Main {
    public static final int MAX_LINE = 10;
    public static HashMap<String, Node> nodeMap = new HashMap<>();
    public static Node[] topArr = new Node[MAX_LINE];
    public static Node[] tailArr = new Node[MAX_LINE];
    
    public static int M;

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void pop(Node n){
        connect(n.left, n.right);

        if(n.left == null){
            for(int i = 0 ; i < M ; i++){
                if(topArr[i] == n && n.right != null){
                    topArr[i] = n.right;
                }
                else if(topArr[i] == n && n.right == null){
                    topArr[i] = null;
                    tailArr[i] = null;
                }
            }
        }

        if(n.right == null){
            for(int i = 0 ; i < M ; i++){
                if(tailArr[i] == n && n.left != null){
                    tailArr[i] = n.left;
                }
                else if(tailArr[i] == n && n.left == null){
                    topArr[i] = null;
                    tailArr[i] = null;
                }
            }
        }

        n.left = n.right = null;
    }

    public static void curInLine(Node n1, Node n2){
        pop(n1);
        if(n2.left == null){
            for(int i = 0 ; i < M ; i++){
                if(topArr[i] == n2){
                    topArr[i] = n1;
                    break;
                }
            }
        }
        connect(n2.left, n1);
        connect(n1, n2);
    }

    public static void cutInLineBygroup(Node n1, Node n2, Node n3){
        if(n1.left == null){
            for(int i = 0 ; i < M ; i++){
                if(topArr[i] == n1 && n2.right != null){
                    topArr[i] = n2.right;
                }
                else if(topArr[i] == n1 && n2.right == null){
                    topArr[i] = null;
                    tailArr[i] = null;
                }
            }
        }

        if(n2.right == null){
            for(int i = 0 ; i < M ; i++){
                if(tailArr[i] == n2 && n1.left != null){
                    tailArr[i] = n1.left;
                }
                else if(tailArr[i] == n2 && n1.left == null){
                    topArr[i] = null;
                    tailArr[i] = null;
                }
            }
        }

        if(n3.left == null){
            for(int i = 0 ; i < M ; i++){
                if(topArr[i] == n3){
                    topArr[i] = n1;
                    break;
                }
            }
        }

        connect(n1.left, n2.right);
        n1.left = n2.right = null;

        connect(n3.left, n1);
        connect(n2, n3);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        int Q = sc.nextInt();
        int X = N / M;

        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            nodeMap.put(str, new Node(str));
            if(i % X == 0){
                topArr[i / X] = nodeMap.get(str);
                tailArr[i / X] = nodeMap.get(str);
            }
            else{
                Node nextTail = nodeMap.get(str);
                connect(tailArr[i / X], nextTail);
                tailArr[i / X] = nextTail;
            }
        }

        for(int i = 0 ; i < Q ; i++){
            int order = sc.nextInt();
            String A, B, C;
            switch(order){
                case 1 :
                    A = sc.next();
                    B = sc.next();
                    curInLine(nodeMap.get(A), nodeMap.get(B));
                    break;
                case 2 :
                    A = sc.next();
                    pop(nodeMap.get(A));
                    break;
                case 3 :
                    A = sc.next();
                    B = sc.next();
                    C = sc.next();
                    cutInLineBygroup(nodeMap.get(A), nodeMap.get(B), nodeMap.get(C));
                    break;
            }
        }
        for(int i = 0 ; i < M ; i++){
            Node curNode = topArr[i];
            if(curNode == null){
                System.out.println(-1);
            }
            else{
                while(curNode != null){
                    System.out.print(curNode.name + " ");
                    curNode = curNode.right;
                }
            }   
            System.out.println();
        }

    }
}