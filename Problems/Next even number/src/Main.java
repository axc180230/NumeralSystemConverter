import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int result = num % 2 == 0 ? num + 2 : num + 1;

        System.out.println(result);
    }
}