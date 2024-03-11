public class Main {
    public static void main(String[] args) {
        double mileRatio = 160934.40;
        double ftRatio = 30.48;
        double inMi = 2.8;
        double inFt = 128.40;
        System.out.printf("%.2f mi = %.2f\n", inMi, mileRatio * inMi);
        System.out.printf("%.2f ft = %.2f\n", inFt, ftRatio * inFt);
    }
}