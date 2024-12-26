import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        long price; // 선물 가격
        long shipping; // 배송비

        public Student(long price, long shipping) {
            this.price = price;
            this.shipping = shipping;
        }

        public long totalCost() {
            return price + shipping;
        }

        public long discountedCost() {
            return price / 2 + shipping;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long budget = Long.parseLong(st.nextToken());

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long price = Long.parseLong(st.nextToken());
            long shipping = Long.parseLong(st.nextToken());
            students[i] = new Student(price, shipping);
        }

        System.out.println(maxStudents(students, budget));
    }

    public static int maxStudents(Student[] students, long budget) {
        Arrays.sort(students, Comparator.comparingLong(Student::totalCost));

        int left = 0, right = students.length;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canGift(students, budget, mid)) {
                answer = mid; // 가능한 경우
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static boolean canGift(Student[] students, long budget, int count) {
        if (count == 0) return true;

        long[] costs = new long[count];
        for (int i = 0; i < count; i++) {
            costs[i] = students[i].totalCost();
        }

        Arrays.sort(costs);
        long totalCost = 0;
        for (int i = 0; i < count - 1; i++) {
            totalCost += costs[i];
        }

        long minCostWithDiscount = students[count - 1].discountedCost();
        totalCost += minCostWithDiscount;

        return totalCost <= budget;
    }
}
