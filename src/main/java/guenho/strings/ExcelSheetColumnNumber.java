package guenho.strings;

// https://leetcode.com/problems/excel-sheet-column-number/

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String column = "FXSHRXW";
        System.out.println(titleToNumber(column));
    }

    private static int titleToNumber(String columnTitle) {

        int len = columnTitle.length() - 1;
        int sum = 0;
        int digits = 1;

        while (len >= 0) {
            int num = columnTitle.charAt(len--) - 'A' + 1;

            for (int i = 0; i < digits - 1; i++) {
                num *= 26;
            }
            sum += num;
            digits++;
        }
        return sum;
    }
}
