import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int indexI = scanner.nextInt();
        int indexJ = scanner.nextInt();

        int[][] temp = new int[1][rows];

        for (int i = 0; i < rows; i++) {
            temp[0][i] = matrix[i][indexI];
            matrix[i][indexI] = matrix[i][indexJ];
            matrix[i][indexJ] = temp[0][i];
        }

        for (int[] row: matrix) {
            for (int value: row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

    }
}