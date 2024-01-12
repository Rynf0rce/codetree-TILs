import java.util.*;

class info implements Comparable<info>{
    long pos;
    long speed;

    public info(long pos, long speed){
        this.pos = pos;
        this.speed = speed;
    }

    public boolean isSame(info i){
        return this.pos == i.pos && this.speed == i.speed;
    }

    @Override
    public int compareTo(info i){
        if(this.pos == i.pos){
            return (int)(this.speed - i.speed);
        }
        return (int)(this.pos - i.pos);
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
            long pos = sc.nextInt();
            long speed = sc.nextInt();
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
        }
        System.out.println(preSet.size());
    }
}