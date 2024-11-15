import java.util.*;

public class Main {
    static class Person {
        int toB; // Time to go from A to B
        int toA; // Time to return from B to A

        Person(int toB, int toA) {
            this.toB = toB;
            this.toA = toA;
        }
    }

    public static int findMinTravelTime(Person[] people) {
        // Sort people by A -> B travel time
        Arrays.sort(people, Comparator.comparingInt(p -> p.toB));

        int currentTime = 0; // Tracks the current time for movements
        int totalTime = 0;   // Tracks the total time required

        // Simulate the travel process
        for (Person person : people) {
            currentTime += person.toB; // Person travels from A to B
            totalTime = Math.max(totalTime, currentTime + person.toA); // Include return time
        }

        return totalTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First line input: number of people N
        int n = scanner.nextInt();
        Person[] people = new Person[n];

        // Second line onward: travel times for each person
        for (int i = 0; i < n; i++) {
            int toB = scanner.nextInt(); // A -> B time
            int toA = scanner.nextInt(); // B -> A time
            people[i] = new Person(toB, toA);
        }

        // Output the result
        System.out.println(findMinTravelTime(people));
    }
}