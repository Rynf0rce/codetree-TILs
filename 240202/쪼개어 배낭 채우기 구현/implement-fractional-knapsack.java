import java.util.*;

class jewel implements Comparable<jewel>{
    double weight;
    double price;
    int idx;

    public jewel(double weight, double price, int idx){
        this.weight = weight;
        this.price = price;
        this.idx = idx;
    }

    @Override
    public int compareTo(jewel j){
        double thisPrice = (double)(this.price / this.weight);
        double inPrice = (double)(j.price / j.weight);
        if(thisPrice == inPrice){
            if(this.weight == j.weight){
                return this.idx - j.idx;
            }
            if(this.weight > j.weight){
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(thisPrice > inPrice){
            return 1;
        }
        else{
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        TreeSet<jewel> jewelSet = new TreeSet<>();

        for(int i = 0 ; i < N ; i++){
            int weight = sc.nextInt();
            int price = sc.nextInt();

            jewelSet.add(new jewel(weight, price, i));
        }

        double ans = 0;
        while(M >= 0){
            if(!jewelSet.isEmpty()){
                jewel curJewel = jewelSet.last();
            }
            else{
                break;
            }
            
            // System.out.println(curJewel.price);
            
            if(M - curJewel.weight >= 0){
                ans += curJewel.price;
                M -= curJewel.weight;
            }
            else{
                ans += (curJewel.price / curJewel.weight) * M;
                break;
            }

            jewelSet.remove(curJewel);
        }

        System.out.printf("%.3f", ans);
    }
}