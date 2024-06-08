public class Student {
  // Attributes
  private String studentName;
  private int chineseScore;
  private int englishScore;
  private int mathsScore;

  // Constructors
  public Student() {

  }

  public Student(String studentName, int chineseScore, int englishScore, int mathsScore) {
    this.studentName = studentName;
    this.chineseScore = chineseScore;
    this.englishScore = englishScore;
    this.mathsScore = mathsScore;
  }

  // Setter
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public void setChineseScore(int chineseScore) {
    this.chineseScore = chineseScore;
  }

  public void setEnglishScore(int englishScore) {
    this.englishScore = englishScore;
  }

  public void setMathsScore(int mathsScore) {
    this.mathsScore = mathsScore;
  }

  // Getter
  public String getStudentName() {
    return this.studentName;
  }

  public int getChineseScore() {
    return this.chineseScore;
  }

  public int getEnglishScore() {
    return this.englishScore;
  }

  public int getMathsScore() {
    return this.mathsScore;
  }

  // Instance Method
  public double getTotalScore() {
    return this.chineseScore + this.englishScore + this.mathsScore;
  }

  // toString()
  public String toString() {
    return "Name: " + this.studentName +
    ", Chinese: " + this.chineseScore +
    ", English: " + this.englishScore +
    ", Maths: " + this.mathsScore +
    ", Total: " + this.getTotalScore();
  }

  // Static Method
  public static int getStudentRank(Student[] students, Student targetStudent) {
    int rank = 1;
    for (Student student : students) {
      if (student.getTotalScore() > targetStudent.getTotalScore()) {
        rank++;
      }
    }
    return rank;
  }

  public static void main(String[] args) {
    Student studentA = new Student("Alan", 80, 90, 100);
    System.out.println(studentA.toString());

    Student studentB = new Student("Ben", 50, 50, 50);
    System.out.println(studentB.toString());

    Student studentC = new Student("Chris", 100, 100, 60);
    System.out.println(studentC.toString());

    Student[] students = {studentA, studentB, studentC};
    Student targetStudent = studentC;
    int rank = Student.getStudentRank(students, targetStudent);
    System.out.println("The rank of this student (" + targetStudent.getStudentName() + ") is " + rank + "/" + students.length);
  }
}
