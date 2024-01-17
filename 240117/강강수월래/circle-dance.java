import java.util.*;

class Node implements Comparable<Node>{
    Node left, right;
    int idx;

    public Node(int idx){
        this.idx = idx;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node n){
        return this.idx - n.idx; // 학생 번호는 서로 다르기 때문에 오름 차순 정렬에 조건은 하나.
    }
}

public class Main {
    public static final int MAX_NUM = 100000000;
    public static final int MAX_line = 10;
    public static final int MAX_TASKS = 10000;

    public static HashMap<Integer, Node> nodeMap = new HashMap<>();
    public static TreeSet<Node>[] lineSet = new TreeSet[MAX_line + MAX_TASKS * 2 + 1];

    public static int M = 0;
    public static int Q = 0;

    public static void connect(Node n1, Node n2){
        if(n1 != null){
            n1.right = n2;
        }

        if(n2 != null){
            n2.left = n1;
        }
    }

    public static void printCircle(int idx){
        for(int i = 1 ; i <= M + Q * 2; i++){
            if(lineSet[i].isEmpty() || !lineSet[i].contains(nodeMap.get(idx))){
                continue;
            }

            int start = lineSet[i].first().idx;
            Node end = lineSet[i].first().right;
            System.out.print(start + " ");
            while(start != end.idx){
                System.out.print(end.idx + " ");
                end = end.right;
            }
            break;
        }
    }

    public static void mergeCircle(Node n1, Node n2){
        int lineN1 = -1;
        int lineN2 = -1;

        for(int i = 1 ; i <= M + Q * 2 ; i++){
            if(lineSet[i].isEmpty()){
                continue;
            }

            if(lineN1 != -1 && lineN2 != -1){
                break;
            }

            if(lineSet[i].contains(n1)){
                lineN1 = i;
            }

            if(lineSet[i].contains(n2)){
                lineN2 = i;
            }
        }

        if(lineN1 == lineN2){
            return;
        }

        lineSet[lineN1].addAll(lineSet[lineN2]);
        lineSet[lineN2].clear();

        connect(n1.left, n2.right);
        connect(n2, n1);
    }

    public static void divideCircle(Node n1, Node n2){
        int emptyIdx = -1;
        int inIdx = -1;

        for(int i = 1 ; i <= M + Q * 2 ; i++){
            if(lineSet[i].isEmpty()){
                if(emptyIdx == -1){
                    emptyIdx = i;
                }
                continue;
            }

            if(lineSet[i].contains(n1)){
                inIdx = i;
            }

            if(emptyIdx != -1 && inIdx != -1){
                break;
            }
        }

        Node n1Right = n1.right;
        Node n2Right = n2.right;

        Node curNode = n1;
        while(curNode != n2){
            lineSet[inIdx].remove(curNode);
            lineSet[emptyIdx].add(curNode);
            curNode = curNode.left;
        }

        connect(n2, n1Right);
        connect(n1, n2Right);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1 ; i <= N ; i++){
            nodeMap.put(i, new Node(i));
        }
        M = sc.nextInt();
        Q = sc.nextInt();
        for(int i = 1 ; i <= M + Q * 2 ; i++){
            lineSet[i] = new TreeSet<Node>();
        }

        for(int i = 1 ; i <= M ; i++){
            int size = sc.nextInt();
            int pre = -1, post = -1, start = -1;
            for(int j = 0 ; j < size ; j++){
                int num = sc.nextInt();
                lineSet[i].add(nodeMap.get(num));
                if(j == 0){
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
                    printCircle(A);
                    break;
            }
        }

        // System.out.println(lineSet[1].size());
        // System.out.println(lineSet[2].size());
        // System.out.println(lineSet[1].first().idx);
        // System.out.println(lineSet[2].last().idx);
        // System.out.println(lineSet[1].contains(nodeMap.get(4)));
        // printCircle(1);
        

    }
}