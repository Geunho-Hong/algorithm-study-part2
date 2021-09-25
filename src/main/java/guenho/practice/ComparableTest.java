package guenho.practice;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Comparator {


    public static void main(String[] args) {
        Student[] student = new Student[5];

        student[0] = new Student("Dave", 20120001, 4.2);
        student[1] = new Student("Amie", 20150001, 4.5);
        student[2] = new Student("Emma", 20110001, 3.5);
        student[3] = new Student("Brad", 20130001, 2.8);
        student[4] = new Student("Cara", 20140001, 4.2);

        Arrays.sort(student);

        for(Student s : student) {
            System.out.println("s = " + s.toString());
        }
    }
    
    private static class Student implements Comparable<Student>{
        String name;
        int studentId;
        double score;

        public Student(String name, int studentId, double score) {
            this.name = name;
            this.studentId = studentId;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", studentId=" + studentId +
                    ", score=" + score +
                    '}';
        }

        /**
         * 자기 자신과 객체를 비교한다
         * @param o
         * @return
         */
        @Override
        public int compareTo(@NotNull Student o) {
            return Integer.compare(this.studentId,o.studentId);
        }
    }

}
