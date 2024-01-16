import java.util.*;

class Node{
    Node left;
    String city;
    Node right;

    public Node(String city){
        this.left = null;
        this.city = city;
        this.right = null;
    }
}

public class Main {
    public static final int MAX_CITIES = 100000;
    public static String[] strArr = new String[MAX_CITIES];

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }
    public static void delNode(Node n1){
        if(n1.left != null){
            n1.left.right = n1.right;
        }

        if(n1.right != null){
            n1.right.left = n1.left;
        }

        n1.left = n1.right = null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Node> nodeMap = new HashMap<>();
        int N = sc.nextInt();
        int Q = sc.nextInt();
        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            nodeMap.put(str, new Node(str));
            strArr[i] = str;
        }

        connect(nodeMap.get(strArr[N - 1]), nodeMap.get(strArr[0]));
        for(int i = 1 ; i < N; i++){
            connect(nodeMap.get(strArr[i - 1]), nodeMap.get(strArr[i]));
        }

        Node pinset = nodeMap.get(strArr[0]);
        for(int i = 0 ; i < Q ; i++){
            int order = sc.nextInt();
            switch(order){
                case 1 :
                    pinset = pinset.right;
                    break;
                case 2 :
                    pinset = pinset.left;
                    break;
                case 3 :
                    delNode(pinset.right);
                    break;
                case 4 :
                    String str = sc.next();
                    Node inNode = new Node(str);
                    connect(inNode, pinset.right);
                    connect(pinset, inNode);
                    nodeMap.put(str, inNode);
                    break;
            }
            if(pinset.left == null || pinset.right == null || pinset.left == pinset.right){
                System.out.println(-1);
            }
            else{
                System.out.println(pinset.left.city + " " + pinset.right.city);
            }   
        }
    }
}