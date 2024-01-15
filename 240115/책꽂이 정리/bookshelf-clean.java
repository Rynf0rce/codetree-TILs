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
    public static final int MAX_BOOK = 250000;
    public static final int MAX_SHELF = 100;
    public static HashMap<Integer, Node>[] shelfMap = new HashMap[MAX_SHELF];
    public static int[] topArr = new int[MAX_SHELF + 1];
    public static int[] tailArr = new int[MAX_SHELF + 1];

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void disconnect(Node n){
        if(n.right != null){
            n.right.left = n.left;
        }

        if(n.left != null){
            n.left.right = n.right;
        }
        n.left = n.right = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i = 1 ; i <= K ; i++){
            shelfMap[i] = new HashMap<Integer, Node>();
        }

        for(int i = 1 ; i <= N ; i++){
            shelfMap[1].put(i, new Node(i));
            if(i > 1){
                connect(shelfMap[1].get(i - 1), shelfMap[1].get(i));
            }    
        }

        topArr[1] = 1;
        tailArr[1] = N;

        int Q = sc.nextInt();

        for(int f = 0 ; f < Q ; f++){
            int order = sc.nextInt();
            int shelf_A = sc.nextInt();
            int shelf_B = sc.nextInt();

            Node selectedNode;

            if(shelfMap[shelf_A].isEmpty()){
                continue;
            }

            switch(order){
                case 1 :
                    selectedNode = shelfMap[shelf_A].get(topArr[shelf_A]);
                    shelfMap[shelf_A].remove(topArr[shelf_A]);
                    shelfMap[shelf_B].put(selectedNode.idx, selectedNode);
                    if(shelfMap[shelf_A].isEmpty()){
                        topArr[shelf_A] = 0;
                        tailArr[shelf_A] = 0;
                    }
                    else{
                        topArr[shelf_A] = selectedNode.right.idx;
                    }

                    disconnect(selectedNode);

                    if(shelfMap[shelf_B].size() == 1){
                        topArr[shelf_B] = selectedNode.idx;
                        tailArr[shelf_B] = selectedNode.idx;
                    }
                    else{
                        connect(shelfMap[shelf_B].get(tailArr[shelf_B]), selectedNode);
                        tailArr[shelf_B] = selectedNode.idx;
                    }               
                    break;
                case 2 :
                    selectedNode = shelfMap[shelf_A].get(tailArr[shelf_A]);
                    shelfMap[shelf_A].remove(tailArr[shelf_A]);
                    shelfMap[shelf_B].put(selectedNode.idx, selectedNode);
                    if(shelfMap[shelf_A].isEmpty()){
                        topArr[shelf_A] = 0;
                        tailArr[shelf_A] = 0;
                    }
                    else{
                        tailArr[shelf_A] = selectedNode.left.idx;
                    }

                    disconnect(selectedNode);

                    if(shelfMap[shelf_B].size() == 1){
                        topArr[shelf_B] = selectedNode.idx;
                        tailArr[shelf_B] = selectedNode.idx;
                    }
                    else{
                        connect(selectedNode, shelfMap[shelf_B].get(topArr[shelf_B]) );
                        topArr[shelf_B] = selectedNode.idx;
                    } 
                    break;
                case 3 :
                    if(shelf_A == shelf_B){
                        break;
                    }
                    selectedNode = shelfMap[shelf_A].get(tailArr[shelf_A]);
                    connect(selectedNode, shelfMap[shelf_B].get(topArr[shelf_B]));
                    selectedNode = shelfMap[shelf_A].get(topArr[shelf_A]);
                    while(selectedNode != shelfMap[shelf_B].get(topArr[shelf_B])){
                        shelfMap[shelf_B].put(selectedNode.idx, selectedNode);
                        selectedNode = selectedNode.right;
                    }
                    shelfMap[shelf_A].clear();
                    topArr[shelf_B] = topArr[shelf_A];
                    if(tailArr[shelf_B] == 0){
                        tailArr[shelf_B] = tailArr[shelf_A];
                    }
                    topArr[shelf_A] = 0;
                    tailArr[shelf_A] = 0;
                    break;
                case 4 :
                    if(shelf_A == shelf_B){
                        break;
                    }
                    selectedNode = shelfMap[shelf_A].get(topArr[shelf_A]);
                    connect(shelfMap[shelf_B].get(tailArr[shelf_B]), selectedNode);
                    while(selectedNode != null){
                        shelfMap[shelf_B].put(selectedNode.idx, selectedNode);
                        selectedNode = selectedNode.right;
                    }
                    shelfMap[shelf_A].clear();
                    tailArr[shelf_B] = tailArr[shelf_A];
                    if(topArr[shelf_B] == 0){
                        topArr[shelf_B] = topArr[shelf_A];
                    }
                    topArr[shelf_A] = 0;
                    tailArr[shelf_A] = 0;
                    break;
            }
        }

        for(int i = 1 ; i <= K ; i++){
            // System.out.print(shelfMap[i].size() + " " + topArr[i] + " " + tailArr[i] + " / ");
            System.out.print(shelfMap[i].size() + " " );
            Node curNode = shelfMap[i].get(topArr[i]);
            while(curNode != null){
                System.out.print(curNode.idx + " ");
                curNode = curNode.right;
            }
            System.out.println();
        }



        // System.out.println(shelfMap[2].size());
        // for(Integer i : shelfMap[2].keySet()){
        //     System.out.println(shelfMap[2].get(i).idx);
        // }

        // Node curNode = shelfMap[1].get(topArr[1]);

        // while(curNode != null){
        //     System.out.println(curNode.idx);
        //     curNode = curNode.right;
        // }
    }
}