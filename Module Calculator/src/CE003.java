public class CE003 extends Module {
    private double homework1Mark;
    private double homework2Mark;
    private double homework3Mark;
    private double homework4Mark;
    private double examMark;
    public CE003(String name, double homework1, double homework2, double homework3, double homework4, double exam) {
        super(name, 2);
        this.homework1Mark = homework1;
        this.homework2Mark = homework2;
        this.homework3Mark = homework3;
        this.homework4Mark = homework4;
        this.examMark = exam;
    }
    public void calcFinalResult() {
        double homeworkAverage = (homework1Mark + homework2Mark + homework3Mark + homework4Mark) / 4;
        setFinalResult(homeworkAverage * 0.4 + examMark * 0.6);
    }
}