public class StudentBuilderDemo {
    public static void main(String[] args) {
        Student student1 = new Student.StudentBuilder("Noppakorn",
                "King Mongkut's University of Technology Ladkrabang").build();
        System.out.println(student1);

        Student student2 = new Student.StudentBuilder("Noppakorn",
                "King Mongkut's University of Technology Ladkrabang").age(22).build();
        System.out.println(student2);
    }
}
