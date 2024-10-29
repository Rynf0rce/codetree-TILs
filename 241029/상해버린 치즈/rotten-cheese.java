import java.util.*;
import java.io.*;

class Info implements Comparable<Info> {
    int person, cheese, time;

    public Info(int person, int cheese, int time) {
        this.person = person;
        this.cheese = cheese;
        this.time = time;
    }

    @Override
    public int compareTo(Info other) {
        return this.time - other.time;
    }
}

public class Main {
    public static final int MAX_PEOPLE = 50;
    public static final int MAX_CHEESE = 50;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int numPeople = Integer.parseInt(st.nextToken());
        int numCheese = Integer.parseInt(st.nextToken());
        int numRecords = Integer.parseInt(st.nextToken());
        int numPatients = Integer.parseInt(st.nextToken());

        ArrayList<Info> records = new ArrayList<>();
        HashSet<Integer> sickPeople = new HashSet<>();
        HashMap<Integer, Integer> sickTimes = new HashMap<>();

        for (int i = 0; i < numRecords; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int person = Integer.parseInt(st.nextToken());
            int cheese = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            records.add(new Info(person, cheese, time));
        }

        for (int i = 0; i < numPatients; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int person = Integer.parseInt(st.nextToken());
            int sickTime = Integer.parseInt(st.nextToken());
            sickPeople.add(person);
            sickTimes.put(person, sickTime);
        }

        Collections.sort(records);

        int maxAffected = 0;

        for (int cheese = 1; cheese <= numCheese; cheese++) {
            boolean possible = true;
            HashSet<Integer> affectedPeople = new HashSet<>();

            for (int person : sickPeople) {
                boolean ateBeforeSick = false;

                for (Info record : records) {
                    if (record.person == person && record.cheese == cheese && record.time < sickTimes.get(person)) {
                        ateBeforeSick = true;
                        affectedPeople.add(person);
                        break;
                    }
                }

                if (!ateBeforeSick) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (Info record : records) {
                    if (record.cheese == cheese) {
                        affectedPeople.add(record.person);
                    }
                }
                maxAffected = Math.max(maxAffected, affectedPeople.size());
            }
        }

        System.out.println(maxAffected);
    }
}