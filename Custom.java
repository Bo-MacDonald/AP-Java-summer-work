import java.util.Scanner;

public class Custom {
    static Scanner ear = new Scanner(System.in);

    public static double nextDouble() {
        double num = ear.nextDouble();
        ear.nextLine();
        return num;
    }

    public static double nextDouble(String prompt) {
        System.out.print(prompt);
        return nextDouble();
    }


    public static int nextInt() {
        int num = ear.nextInt();
        ear.nextLine();
        return num;
    }

    public static int nextInt(String prompt) {
        System.out.print(prompt);
        return nextInt();
    }

    public static String nextLine() {
        String line = ear.nextLine();
        return line;
    }

    public static String nextLine(String prompt) {
        System.out.print(prompt);
        String line = ear.nextLine();
        return line;
    }

    public static String nextString() {
        String line = nextLine();
        return line;
    }

    public static String nextString(String prompt) {
        System.out.print(prompt);
        return nextLine();
    }
}
