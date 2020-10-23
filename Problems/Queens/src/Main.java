import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean hitEachOther = false;

        int queen1X = scanner.nextInt();
        int queen1Y = scanner.nextInt();
        int queen2X = scanner.nextInt();
        int queen2Y = scanner.nextInt();

        // horizontal or vertical collision
        if (queen1X == queen2X || queen1Y == queen2Y) {
            hitEachOther = true;
        } else if (Math.abs(queen1X - queen2X) ==
                Math.abs(queen1Y - queen2Y)) {  // diagonal collision
            hitEachOther  = true;
        }

        if (hitEachOther) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}