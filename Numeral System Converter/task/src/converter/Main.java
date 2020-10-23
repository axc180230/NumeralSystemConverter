package converter;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int sourceRadix = scanner.nextInt();
            String originalNum = scanner.next();
            int targetRadix = scanner.nextInt();

            if (sourceRadix <= 0 || targetRadix  <= 0 ||
                    sourceRadix > 36 || targetRadix > 36) {
                throw new IllegalArgumentException();
            }

            int originalNumPeriodLocation = originalNum.indexOf('.');
            String integerPart, fractionPart, convertedIntergerPart, convertedFractionPart;

            if (originalNumPeriodLocation > 0) {
                integerPart = originalNum.substring(0, originalNum.indexOf('.'));
                fractionPart = originalNum.substring(originalNum.indexOf('.') + 1);
                convertedIntergerPart = convertBase(sourceRadix, integerPart, targetRadix);
                convertedFractionPart = convertFractionBase(sourceRadix, fractionPart, targetRadix);
                System.out.printf("%s.%s%n", convertedIntergerPart, convertedFractionPart);
            } else {
                integerPart = originalNum;
                convertedIntergerPart = convertBase(sourceRadix, integerPart, targetRadix);
                System.out.println(convertedIntergerPart);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
//        convertedNumber = formatNumberBasedOnBase(convertedNumber, targetRadix);
    }

    public static String formatNumberBasedOnBase(String number, int base) {
        switch (base) {
            case 2:
                return "0b" + number;
            case 8:
                return "0" + number;
            case 16:
                return "0x" + number;
            default:
                throw new IllegalArgumentException("Invalid choice: " + base);
        }
    }

    public static String convertBase(int sourceBase, String originalNumber, int targetBase) {
        String newDecimal;
        String newBaseNumber;

        if (sourceBase == 1) {
            originalNumber = String.valueOf(originalNumber.length());
            sourceBase = 10;
        }

        if (sourceBase != 10) {
            newDecimal = String.valueOf(Integer.parseInt(originalNumber, sourceBase));
        } else {
            newDecimal = originalNumber;
        }

        if (targetBase == 1) {
            newBaseNumber = "1".repeat(Math.max(0, Integer.parseInt(newDecimal)));
        } else {
            newBaseNumber = Integer.toString(Integer.parseInt(newDecimal), targetBase);
        }

        return newBaseNumber;
    }

    public static String convertFractionBase(int sourceBase, String originalFraction, int targetBase) {

        int fractionLength = originalFraction.length();

        double newDecimalFraction = 0;
        double temp;

        // Convert fraction from source base to base 10
        for (int i = 0; i < fractionLength; i++) {
            char currentChar = originalFraction.charAt(i);

            if (currentChar >= 97 && currentChar <= 122) {
                temp = currentChar - 87;
            } else if (currentChar >= 48 && currentChar <=57) {
                temp = currentChar - 48;
            } else {
                temp = 0;
            }

            newDecimalFraction += temp / Math.pow(sourceBase, i + 1);
        }

        // Convert fraction from base 10 to target base
        StringBuilder newTargetFraction = new StringBuilder();
        temp = newDecimalFraction;
        int fractionTemp;
        char letterTemp;


        for (int i = 0; i < 5; i++) {
            if (targetBase == 10) {
                newTargetFraction.append(String.valueOf(newDecimalFraction).substring(0, 4));
            } else {
                temp *= targetBase;
                fractionTemp = (int) temp;
                if (fractionTemp > 9) {
                    letterTemp = (char) (fractionTemp + 87);
                    newTargetFraction.append(letterTemp);
                } else if (fractionTemp < 9) {
                    newTargetFraction.append(fractionTemp);
                } else {
                    newTargetFraction.append(0);
                }

                temp = temp - (int) temp;
            }
        }

        return newTargetFraction.toString();
    }
}
