public class Day14 {
    static class Student {
        String name;
        String regNo;
        int age;

        Student(Builder builder) {
            this.name = builder.name;
            this.regNo = builder.regNo;
            this.age = builder.age;
        }

        static class Builder {
            private String name;
            private String regNo;
            private int age;

            public Builder name(String nameValue) {
                this.name = nameValue;
                return this;
            }

            public Builder regNo(String regNoValue) {
                this.regNo = regNoValue;
                return this;
            }

            public Builder age(int ageValue) {
                this.age = ageValue;
                return this;
            }

            public Student build() {
                return new Student(this);
            }
        }
    }
        static void main() {
            Student student = new Student.Builder()
                    .name("Srinithi")
                    .age(18)
                    .regNo("25AID60")
                    .build();
            System.out.println(student.name);
            System.out.println(student.age);
            System.out.println(student.regNo);
        }
}