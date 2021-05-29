package sujung.hash;

import java.util.Arrays;

public class ListOfTelephoneNumbers {

    public boolean solution(String[] phone) {
        Arrays.sort(phone);
        for (int i = 1; i < phone.length; i++) {
            if (phone[i].startsWith(phone[i - 1]))
                return false;
        }
        return true;
    }
}
