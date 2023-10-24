import java.util.Scanner;
public abstract class Module {
    private String name;        //Name of module
    private int status;         /*indicates the status of module and provides information about the
                                   variable state. In this case 0 = CW only, 1 = Exam only,
                                   2 = both cw + exam*/
    private double finalMark;
    public Module(String name, int status) {this.name = name; this.status = status; this.finalMark = 0.0;}
                               //intialises the 'name' and status field.
    public String getName() {return name;} //returns names of modules

    public void setName(String name) {this.name = name;}  //method which sets name of module

    public int getStatus() {return status;}
    public void setStatus(int status) {this.status = status;}
    public double getFinalMark() {return finalMark;}     //method which returns final marks
    public void setFinalResult(double finalMark) {this.finalMark = finalMark;}
    public abstract void calcFinalResult(); /*Abstract method which computes final mark for modules and is
                                              implemented differently with each respective subclass*/
    public void printFinalMark() {System.out.println("Final mark for " + name + ": " + finalMark);}
    public void input() {          //takes user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name for module " + name + ": ");
        name = scanner.nextLine();
        System.out.print("Enter status for module " + name + " (0 for coursework only, 1 for exam only, 2 for coursework and exam): ");
        status = scanner.nextInt();}

    public void output() {System.out.println("Module " + name + " has status " + status + " and a final mark of " + finalMark);}
}
