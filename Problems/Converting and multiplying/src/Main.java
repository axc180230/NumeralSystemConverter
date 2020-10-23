import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String tempString;
        int tempInt;
        ArrayList<String> finalArray = new ArrayList<>();
        tempString = scanner.next();

        while (!"0".equals(tempString)) {
            try {
                tempInt = convertStringToInt(tempString);
                tempInt *= 10;
                finalArray.add(String.valueOf(tempInt));

            } catch (NumberFormatException e) {
                finalArray.add("Invalid user input: " + tempString);
            } finally {
                tempString = scanner.next();
            }
        }

        for (String value : finalArray) {
            System.out.println(value);
        }
    }

    private static int convertStringToInt(String stringNum) {
        return Integer.parseInt(stringNum);
    }
}