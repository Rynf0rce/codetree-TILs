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
        // Lists for early and late scheduling
        List<Person> early = new ArrayList<>();
        List<Person> late = new ArrayList<>();

        // Partition the persons into early and late groups
        for (Person person : people) {
            if (person.toB <= person.toA) {
                early.add(person);
            } else {
                late.add(person);
            }
        }

        // Sort early group by ascending A -> B time
        early.sort(Comparator.comparingInt(p -> p.toB));

        // Sort late group by descending B -> A time
        late.sort((p1, p2) -> p2.toA - p1.toA);

        // Combine the two groups
        List<Person> schedule = new ArrayList<>();
        schedule.addAll(early);
        schedule.addAll(late);

        int timeAtoB = 0; // Time tracker for A -> B
        int timeBtoA = 0; // Time tracker for B -> A
        int totalTime = 0; // Total time required

        // Simulate the movements based on the schedule
        for (Person person : schedule) {
            timeAtoB += person.toB; // Accumulate A -> B time
            timeBtoA = Math.max(timeBtoA, timeAtoB) + person.toA; // Ensure B -> A starts after A -> B
            totalTime = Math.max(totalTime, timeBtoA); // Update total time
        }

        return totalTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First line input: number of people N
        int n = scanner.nextInt();
        Person[] people = new Person[n];

        // Next N lines: travel times for each person
        for (int i = 0; i < n; i++) {
            int toB = scanner.nextInt(); // A -> B time
            int toA = scanner.nextInt(); // B -> A time
            people[i] = new Person(toB, toA);
        }

        // Output the result
        System.out.println(findMinTravelTime(people));
    }
}
