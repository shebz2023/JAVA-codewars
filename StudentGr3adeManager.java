import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class StudentGradeManager {
    List<String> studentNames;
    Set<String> gradeCategories;
    Map<String, String> studentGrades;
    Map<String, String> sortedStudents;

    StudentGradeManager() {
        this.studentNames = new ArrayList<>();
        this.gradeCategories = new HashSet<>();
        this.studentGrades = new HashMap<>();
        this.sortedStudents = new TreeMap<>();
    }

    public void addStudent(String name, String grade) {
        // Check if student already exists
        if (!studentNames.contains(name)) {
            studentNames.add(name);
        }
        studentGrades.put(name, grade);
        sortedStudents.put(name, grade);
        gradeCategories.add(grade);
    }

    public void removeStudent(String name) {
        // Get the grade before removing to update gradeCategories if needed
        String grade = studentGrades.get(name);
        
        studentNames.remove(name);
        studentGrades.remove(name);
        sortedStudents.remove(name);
        
        // Check if this was the last student with this grade
        if (!studentGrades.containsValue(grade)) {
            gradeCategories.remove(grade);
        }
    }

    public void displayAllStudents() {
        System.out.println("All Students (Registration Order):");
        for (int i = 0; i < studentNames.size(); i++) {
            String name = studentNames.get(i);
            String grade = studentGrades.get(name);
            System.out.println((i + 1) + ". " + name + " - " + grade);
        }
        System.out.println();
    }

    public void displayStudentsSorted() {
        System.out.println("Students Sorted by Name:");
        for (Map.Entry<String, String> entry : sortedStudents.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();
    }

    public void displayGradeStatistics() {
        System.out.println("Grade Statistics:");
        System.out.println("Unique Grades: " + gradeCategories);
        System.out.println("Total Grade Categories: " + gradeCategories.size());
        
        // Bonus: Count students per grade
        Map<String, Integer> gradeCount = new HashMap<>();
        for (String grade : studentGrades.values()) {
            gradeCount.put(grade, gradeCount.getOrDefault(grade, 0) + 1);
        }
        System.out.println("Students per Grade: " + gradeCount);
        System.out.println();
    }
}

 class GradeManager {
    public static void main(String args[]) {
        StudentGradeManager manager = new StudentGradeManager();
                manager.addStudent("Alice", "A");
        manager.addStudent("Bob", "B");
        manager.addStudent("Charlie", "A");
        manager.addStudent("David", "C");
        manager.addStudent("Alice", "B"); 
        
        manager.displayAllStudents();
        manager.displayStudentsSorted();
        manager.displayGradeStatistics();
        
        // Test removal
        System.out.println("=== After removing Bob ===");
        manager.removeStudent("Bob");
        manager.displayAllStudents();
        manager.displayGradeStatistics();
    }
}