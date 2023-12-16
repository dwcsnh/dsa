package Tuan8;

import java.util.*;

class Student {
    private int id;
    private String name;
    private double CGPA;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.CGPA = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return CGPA;
    }
}

static List<Student> getStudents(List<String> events) {
    PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(
            Comparator.comparing(Student::getCGPA).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getId));

    for (String event : events) {
        String[] parts = event.split(" ");
        if (parts[0].equals("ENTER")) {
            priorityQueue.add(new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2])));
        } else {
            priorityQueue.poll();
        }
    }

    List<Student> remainingStudents = new ArrayList<>();
    while (!priorityQueue.isEmpty()) {
        remainingStudents.add(priorityQueue.poll());
    }
    return remainingStudents;
}


public class JavaPriorityQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<String> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            events.add(line);
        }

        List<Student> students = getStudents(events);
        input.close();

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
