import java.util.Scanner;

public class parouimpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        num = scanner.nextInt();
        while (num != 0) {
            if (num % 2 == 0) {
                System.out.println("P");
            } else {
                System.out.println("I");
            }
            num = scanner.nextInt();
        }
        scanner.close();
    }
}
