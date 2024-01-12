import java.util.*;

class info implements Comparable<info>{
    int pos;
    int speed;

    public info(int pos, int speed){
        this.pos = pos;
        this.speed = speed;
    }

    public boolean isSame(info i){
        return this.pos == i.pos && this.speed == i.speed;
    }

    @Override
    public int compareTo(info i){
        if(this.pos == i.pos){
            return this.speed - i.speed;
        }
        return this.pos - i.pos;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<info> preSet = new TreeSet<>();
        TreeSet<info> postSet = new TreeSet<>();

        int N = sc.nextInt();
        int T = sc.nextInt();

        for(int i = 0 ; i < N ; i++){
            int pos = sc.nextInt();
            int speed = sc.nextInt();
            preSet.add(new info(pos, speed));
        }

        while(T-- > 0){
            for(info i : preSet){
                info addInfo = new info(i.pos + i.speed, i.speed);
                postSet.add(addInfo);
                while(!postSet.last().isSame(addInfo)){
                    postSet.remove(postSet.last());
                }
            }

            preSet = (TreeSet<info>)postSet.clone();
            postSet.clear();

            // for(info i : preSet){
            //     System.out.println(i.pos + " " + i.speed);
            // }
            // System.out.println();
        }

        System.out.println(preSet.size());
    }
}