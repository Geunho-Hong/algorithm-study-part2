package guenho.hash;

// https://programmers.co.kr/learn/courses/30/lessons/42577

public class PhoneNumberList {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    /**
     *
     * @param phone_book
     * @return
     * 시간 초과 발생
     */

    private static boolean solution(String[] phone_book) {

        for (int i = 0; i < phone_book.length - 1; i++) {
            String curPhoneNumber = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                String nextPhoneNumber = phone_book[j];

                if (nextPhoneNumber.startsWith(curPhoneNumber)) {
                    return false;
                } else if (curPhoneNumber.startsWith(nextPhoneNumber)) {
                    return false;
                }
            }
        }
        return true;
    }
}
