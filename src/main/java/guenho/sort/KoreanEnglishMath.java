package guenho.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class KoreanEnglishMath {

    private static int N;
    private static Student[] students;

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            students = new Student[N];

            for (int i = 0; i < N; i++) {
                String[] commands = br.readLine().split(" ");

                String name = commands[0];
                int korean = Integer.parseInt(commands[1]);
                int english = Integer.parseInt(commands[2]);
                int math = Integer.parseInt(commands[3]);

                students[i] = new Student(name,korean,english,math);
            }

        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.korean == s2.korean) {
                    if(s1.english == s2.english) {
                        if(s1.math == s2.math) {
                            return s1.name.compareTo(s2.name);
                        }
                        return s2.math - s1.math;
                    }
                    return s1.english - s2.english;
                }
                return s2.korean - s1.korean;
            }
        });

        for(Student s : students) {
            System.out.println(s.name);
        }
    }

    private static class Student {

        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

}
