public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private double[] cw001Marks = new double[4];
    private double ex002Mark;
    private double[] ce003Marks = new double[4];

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;}
    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}
    public void setCw001Marks(double[] marks) {cw001Marks = marks;}
    public void setEx002Mark(double mark) {ex002Mark = mark;}
    public void setCe003Marks(double[] marks) {ce003Marks = marks;}
    public double[] getCw001Marks() {return cw001Marks;}
    public double getCw001FinalMark() { double sum = 0; for (double mark : cw001Marks)
    { sum += mark; }
        return sum / cw001Marks.length;}
    public double getEx002FinalMark() {return ex002Mark;}
    public double getCe003FinalMark() { double sum = 0; for (double mark : ce003Marks)
    {sum += mark;}
        return sum / ce003Marks.length;}
}


