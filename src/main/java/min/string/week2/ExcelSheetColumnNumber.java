package min.string.week2;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;

        // A B C
        // 1
        // 26 + 2
        // 28 * 26 + 3
        for (int i = 0; i < s.length(); i++)
            // A-Z 는 26진수이기 때문에 반복문 한 번 돌때마다 26 좌측 쉬프트한다고 생각하면 편함
            result = result * 26 + getCharValue(s.charAt(i));

        return result;
    }

    int getCharValue(char c) {
        return c - 64;
    }

}
