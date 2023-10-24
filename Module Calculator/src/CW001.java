public class CW001 extends Module {
    private double hmrkAverage;
    private double projectscore;

    public CW001(String name, double hw1, double hw2, double hw3, double project) {
        super(name, 0);
        this.hmrkAverage = (hw1 + hw2 + hw3) / 3;
        this.projectscore = project;}
    public void calcFinalResult() {setFinalResult(projectscore * 0.5 + hmrkAverage * 0.5);
    }
}
