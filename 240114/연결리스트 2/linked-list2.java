import java.util.*;

class Node{
    Node left;
    int num;
    Node right;

    public Node(int num){
        this.left = null;
        this.num = num;
        this.right = null;
    }
}

public class Main {
    public static void setLeft(Node setNode, Node rightNode){
        setNode.right = rightNode;
        setNode.left = rightNode.left;

        if(setNode.right != null){
            setNode.right.left = setNode;
        }
        
        if(setNode.left != null){
            setNode.left.right = setNode;
        }
    }

    public static void setRight(Node setNode, Node leftNode){
        setNode.left = leftNode;
        setNode.right = leftNode.right;

        if(setNode.left != null){
            setNode.left.right = setNode;
        }

        if(setNode.right != null){
            setNode.right.left = setNode;
        }
    }

    public static void popNode(Node delNode){
        if(delNode.right != null){
            delNode.right.left = delNode.left;
        }

        if(delNode.left != null){
            delNode.left.right = delNode.right;
        }
        
        delNode.left = null;
        delNode.right = null;  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Node> nodeMap = new HashMap<>();

        int N = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            nodeMap.put(i, new Node(i));
        }

        int Q = sc.nextInt();
        for(int i = 0 ; i < Q ; i++){
            int key = sc.nextInt();
            int idx, setIdx;
            switch(key){
                case 1 :
                    idx = sc.nextInt();
                    popNode(nodeMap.get(idx));
                    break;
                case 2 :
                    idx = sc.nextInt();
                    setIdx = sc.nextInt();
                    setLeft(nodeMap.get(setIdx), nodeMap.get(idx));
                    break;
                case 3 :
                    idx = sc.nextInt();
                    setIdx = sc.nextInt();
                    setRight(nodeMap.get(setIdx), nodeMap.get(idx));
                    break;
                case 4 :
                    idx = sc.nextInt();
                    Node curNode = nodeMap.get(idx);
                    System.out.print(curNode.left == null ? 0 + " " : curNode.left.num + " ");
                    System.out.print(curNode.right == null ? 0 + " " : curNode.right.num + " ");
                    System.out.println();       
            }        
        }

        for(Map.Entry<Integer, Node> entry : nodeMap.entrySet()){
            System.out.print(entry.getValue().right == null ? 0 + " " : entry.getValue().right.num + " ");
        }
    }
}