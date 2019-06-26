import java.util.Scanner;
/**
 * Activity2PayStub class is part of Lab 2 and
 * creates a simple pay stub.
 *
 * @author Willow Sapphire
 * @version 06/13/2019
 */
public class Activity2PayStub
{
    public static final double OVERTIME_FACTOR = 1.5;
    public static final double SS_WITHHOLD = 0.1;
    public static final double FED_TAX_RATE = 0.2;
    
    // data from user
    private String eName;
    private String eSsn;
    private int regHours = 0;
    private int otHours = 0;
    private double payRate = 0.0;
    
    // calculated data
    private double otRate = 0.0;
    private double regPay = 0.0;
    private double otPay = 0.0;
    private double grossPay = 0.0;
    private double ssWithholdings = 0.0;
    private double fedTax = 0.0;
    private double netPay = 0.0;
    
    /**
     * Prompts the user to enter employee data.
     * @param keyboard input method
     */
    public void getInput(Scanner keyboard)
    {
        System.out.print("Enter employee name: ");
        this.eName = keyboard.nextLine();
        System.out.print("Enter employee SSN (incl. hyphens): ");
        this.eSsn =  keyboard.nextLine();
        System.out.print("Enter number of regular hours worked: ");
        this.regHours = keyboard.nextInt();
        System.out.print("Enter number of overtime hours worked: ");
        this.otHours = keyboard.nextInt();
        System.out.print("Enter hourly pay rate: ");
        this.payRate = keyboard.nextDouble();
    }
    
    /**
     * Calculates additional data based on the user input.
     */
    public void calculate()
    {
        this.otRate = OVERTIME_FACTOR * this.payRate;
        this.regPay = this.payRate * this.regHours;
        this.otPay = this.otRate * this.otHours;
        this.grossPay = this.regPay + this.otPay;
        this.ssWithholdings = this.grossPay * SS_WITHHOLD;
        this.fedTax = (this.grossPay - this.ssWithholdings) * FED_TAX_RATE;
        this.netPay = this.grossPay - this.ssWithholdings - this.fedTax;
    }

    
    /**
     * Prints out a pay stub based on employee info.
     */
    public void printPayStub()
    {
        String border = "______________________________"
            + "_________________________________\n";
        System.out.printf(border);
        System.out.printf("Name: %-37s SSN: %-11s\n", this.eName, this.eSsn);
        System.out.printf("Regular Hours: %-8d Reg Rate: $%-8.2f"
            + " Reg Pay: $%-8.2f\n", this.regHours, this.payRate, this.regPay);
        System.out.printf("Overtime Hours: %-8d"
            + "OT Rate: $%-8.2f"
            + "  OT Pay: $%-8.2f\n", this.otHours, this.otRate, this.otPay);
        System.out.printf("Gross Pay: $%-8.2f\n", grossPay);
        System.out.printf("SS Withholding: $%-8.2f\n", this.ssWithholdings);
        System.out.printf("Federal Tax: $%-8.2f\n", this.fedTax);
        System.out.printf("Net Pay: $%-8.2f\n", this.netPay);
        System.out.printf(border);
    }
    
    /**
     * It all starts with the main method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Activity2PayStub a2ps = new Activity2PayStub();
        a2ps.getInput(keyboard);
        a2ps.calculate();
        a2ps.printPayStub();
    }
}
