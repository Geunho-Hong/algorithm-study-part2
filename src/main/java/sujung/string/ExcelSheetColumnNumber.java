package sujung.string;

public class ExcelSheetColumnNumber {

    /**
     *
     * Compute 26 radix notation
     * @param columnTitle
     * @return
     */
    public int titleNumber(String columnTitle) {
        int result = 0;

        for(int i=columnTitle.length() - 1, base = 1; i>=0; i--, base *= 26) {
            int num = base * (columnTitle.charAt(i) - 'A' + 1);
            result += num;
        }
        return result;
    }
}
