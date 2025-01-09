public class Student {
    private final String name;
    private final String university;

    private int age;

    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.university = builder.university;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Details:\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("University: ").append(university).append("\n");
        if (age != 0) {
            sb.append("Age: ").append(age).append("\n");
        }
        return sb.toString();
    }

    public static class StudentBuilder {
        private final String name;
        private final String university;

        private int age;

        public StudentBuilder(String name, String university) {
            this.name = name;
            this.university = university;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
