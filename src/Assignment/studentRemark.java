import java.util.*;
class Student {
    private int id, age;
    private String name, gender;
    private float java, html, css, php, js, total, average;
    private char grade;

    public Student(int id, String name, String gender, int age, float java, float html, float css, float js, float php) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.java = java;
        this.html = html;
        this.css = css;
        this.js = js;
        this.php = php;
        this.total = java + html + css + js + php;
        this.average = total / 5;
        this.grade = calculateGrade(average);
    }

    private char calculateGrade(float avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else if (avg >= 50) return 'E';
        else return 'F';
    }

    public void updateStudent(String name, String gender, int age, float java, float html, float css, float js, float php) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.java = java;
        this.html = html;
        this.css = css;
        this.js = js;
        this.php = php;
        this.total = java + html + css + js + php;
        this.average = total / 5;
        this.grade = calculateGrade(average);
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public float getJava() { return java; }
    public float getHtml() { return html; }
    public float getCss() { return css; }
    public float getJs() { return js; }
    public float getPhp() { return php; }
    public float getTotal() { return total; }
    public float getAverage() { return average; }
    public char getGrade() { return grade; }
}

class studentRemark {
    static List<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter Number of Students: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Score Java: ");
            float java = sc.nextFloat();
            System.out.print("Enter Score HTML: ");
            float html = sc.nextFloat();
            System.out.print("Enter Score CSS: ");
            float css = sc.nextFloat();
            System.out.print("Enter Score JS: ");
            float js = sc.nextFloat();
            System.out.print("Enter Score PHP: ");
            float php = sc.nextFloat();

            students.add(new Student(id, name, gender, age, java, html, css, js, php));
            System.out.println("Student added successfully!\n");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Student record deleted successfully.\n");
        } else {
            System.out.println("Student ID not found!\n");
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                found = true;
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Gender: ");
                String gender = sc.nextLine();
                System.out.print("Enter New Age: ");
                int age = sc.nextInt();
                System.out.print("Enter New Score Java: ");
                float java = sc.nextFloat();
                System.out.print("Enter New Score HTML: ");
                float html = sc.nextFloat();
                System.out.print("Enter New Score CSS: ");
                float css = sc.nextFloat();
                System.out.print("Enter New Score JS: ");
                float js = sc.nextFloat();
                System.out.print("Enter New Score PHP: ");
                float php = sc.nextFloat();

                s.updateStudent(name, gender, age, java, html, css, js, php);
                System.out.println("Student updated successfully.\n");
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found!\n");
        }
    }

static void displayStudents() {
    if (students.isEmpty()) {
        System.out.println("No student records found!\n");
        return;
    }

    System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("%-5s %-15s %-10s %-5s %-6s %-6s %-6s %-6s %-6s %-7s %-7s %-7s\n", 
                      "ID", "Name", "Gender", "Age", "Java", "HTML", "CSS", "JS", "PHP", "Total", "Avg", "Grade");
    System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

    for (Student s : students) {
        if (s == null) continue;
        System.out.printf("%-5d %-15s %-10s %-5d %-6.2f %-6.2f %-6.2f %-6.2f %-6.2f %-7.2f %-7.2f %-7c\n", 
                          s.getId(), s.getName(), s.getGender(), s.getAge(), 
                          s.getJava(), s.getHtml(), s.getCss(), s.getJs(), s.getPhp(),s.getTotal(),
                          s.getAverage(), s.getGrade());
    }
    System.out.println("---------------------------------------------------------------------------------------------------------------------------------\n");
}


    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
}

