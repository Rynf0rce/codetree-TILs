import java.util.*;
import java.io.*;

class node{
    int idx;
    char left, right;
    public node(int idx, char left, char right){
        this.idx = idx;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static final int MAX_NODE = 26;
    public static node[] nodeArr  = new node[MAX_NODE * (MAX_NODE - 1) + 2];
    public static TreeMap<Character, Integer> nodeMap = new TreeMap<>();

    public static void preOrder(char spell){
        if(spell == '.'){
            return;
        }
        System.out.print(spell);
        node curNode = nodeArr[nodeMap.get(spell)];
        preOrder(curNode.left);
        preOrder(curNode.right);
    }

    public static void inOrder(char spell){
        if(spell == '.'){
            return;
        }
        node curNode = nodeArr[nodeMap.get(spell)];
        inOrder(curNode.left);
        System.out.print(spell);
        inOrder(curNode.right);
    }

    public static void postOrder(char spell){
        if(spell == '.'){
            return;
        }
        node curNode = nodeArr[nodeMap.get(spell)];
        postOrder(curNode.left);
        postOrder(curNode.right);
        System.out.print(spell);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            nodeMap.put(parent, i);
            nodeArr[i] = new node(parent, left, right);
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
    }
}