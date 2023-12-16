package Tuan6;

import java.util.*;

class Student implements Comparable<Student> {
    private int id;
    private String fname;
    private double CGPA;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.CGPA = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCGPA() {
        return CGPA;
    }

    @Override
    public int compareTo(Student that) {
        if (this.getCGPA() == that.getCGPA()) {
            if (this.getFname().equals(that.getFname())) {
                return this.getId() - that.getId();
            }
            return this.getFname().compareTo(that.getFname());
        }
        return Double.compare(that.getCGPA(), this.getCGPA());
    }
}

// Complete the code
public class JavaSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        for (int i = 0; i < n; i++) {
            int id = input.nextInt();
            String fname = input.next();
            double cgpa = input.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
        }
        Collections.sort(studentList);
        input.close();
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
