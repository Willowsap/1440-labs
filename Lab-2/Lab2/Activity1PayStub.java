import java.util.Scanner;
/**
 * Activity1PayStub class is part of Lab 2 and
 * creates a simple pay stub.
 *
 * @author Willow Sapphire
 * @version 06/13/2019
 */
public class Activity1PayStub
{
    public static final double OVERTIME_FACTOR = 1.5;
    public static final double SS_WITHHOLD = 0.1;
    public static final double FED_TAX_RATE = 0.2;
    /**
     * It all starts with the main method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String eName;
        String eSsn;
        int regHours;
        int overHours;
        double payRate;
        
        System.out.print("Enter employee name: ");
        eName = s.nextLine();
        System.out.print("Enter employee SSN (incl. hyphens): ");
        eSsn =  s.nextLine();
        System.out.print("Enter number of regular hours worked: ");
        regHours = s.nextInt();
        System.out.print("Enter number of overtime hours worked: ");
        overHours = s.nextInt();
        System.out.print("Enter hourly pay rate: ");
        payRate = s.nextDouble();
        
        printPayStub(eName, eSsn, regHours, overHours, payRate);
    }
    
    /**
     * Prints out a pay stub based on employee info.
     * @param name employee's name.
     * @param ssn employee's ssn.
     * @param regHours number of regular hours worked
     * @param otHours number of overtime hours worked
     * @param payRate dollar amount employee earns per hour
     */
    public static void printPayStub(String name, String ssn, 
        int regHours, int otHours, double payRate)
    {
        String border = "______________________________"
            + "_________________________________\n";
        double otRate = OVERTIME_FACTOR * payRate;
        double regPay = payRate * regHours;
        double otPay = otRate * otHours;
        double grossPay = regPay + otPay;
        double ssWithholdings = SS_WITHHOLD * grossPay;
        double fedTax = FED_TAX_RATE * (grossPay - ssWithholdings);
        double netPay = grossPay - ssWithholdings - fedTax;
        System.out.printf(border);
        System.out.printf("Name: %-37s SSN: %-11s\n", name, ssn);
        System.out.printf("Regular Hours: %-8d Reg Rate: $%-8.2f"
            + " Reg Pay: $%-8.2f\n", regHours, payRate, regPay);
        System.out.printf("Overtime Hours: %-8d"
            + "OT Rate: $%-8.2f"
            + "  OT Pay: $%-8.2f\n", otHours, otRate, otPay);
        System.out.printf("Gross Pay: $%-8.2f\n", grossPay);
        System.out.printf("SS Withholding: $%-8.2f\n", ssWithholdings);
        System.out.printf("Federal Tax: $%-8.2f\n", fedTax);
        System.out.printf("Net Pay: $%-8.2f\n", netPay);
        System.out.printf(border);
    }
}
