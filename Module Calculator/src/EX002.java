public class EX002 extends Module {
    private double examMark;
    public EX002(String name, double exam) {
        super(name, 1);
        this.examMark = exam;}
    public void calcFinalResult() {
        setFinalResult(examMark);
    }
}
