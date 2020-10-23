import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        int[] nums = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            nums[i] = scanner.nextInt();
        }

        int triplesCounter = 0;

        if (arrayLength >= 3) {
            for (int i = 0; i < arrayLength - 2; i++) {
                if (nums[i] + 1 == nums[i + 1] &&
                        nums[i] + 2 == nums[i + 2]) {
                    triplesCounter++;
                }
            }
        }

        System.out.println(triplesCounter);
    }
}