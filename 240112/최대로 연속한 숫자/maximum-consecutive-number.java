import java.util.*;

class range implements Comparable<range>{
    int start;
    int end;

    public range(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(range r){
        return this.start - r.start;
    }
}

class length implements Comparable<length>{
    int start;
    int end;
    int length;

    public length(int start, int end){
        this.start = start;
        this.end = end;
        this.length = end - start + 1;
    }

    @Override
    public int compareTo(length r){
        if(this.length == r.length){
            return this.start - r.start;
        }
        else{
            return this.length - r.length;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<range> rangeSet = new TreeSet<>();
        TreeSet<length> lengthSet = new TreeSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        rangeSet.add(new range(0, n));
        lengthSet.add(new length(0, n));
        
        for(int i = 0 ; i < m ; i++){
            int num = sc.nextInt();
            if(rangeSet.floor(new range(num, 0)) != null){
                range temp = rangeSet.floor(new range(num, 0));
                rangeSet.remove(temp);
                lengthSet.remove(new length(temp.start, temp.end));
                if(num - 1 >= temp.start){
                    rangeSet.add(new range(temp.start, num - 1));
                    lengthSet.add(new length(temp.start, num - 1));
                }

                if(num + 1 <= temp.end){
                    rangeSet.add(new range(num + 1, temp.end));
                    lengthSet.add(new length(num + 1, temp.end));
                }
            }
            System.out.println(lengthSet.last().length);
        }     
    }
}