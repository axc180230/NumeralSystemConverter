import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        StringBuilder temp = new StringBuilder(num + " ");

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 2 == 1) {
                num = (num * 3) + 1;
            }

            temp.append(num + " ");
        }

        System.out.println(temp.toString());
    }
}