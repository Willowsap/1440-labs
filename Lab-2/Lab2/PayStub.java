import java.util.Scanner;
/**
 * PayStub class is part of Lab 2 and
 * creates a simple pay stub.
 *
 * @author Willow Sapphire
 * @version 06/13/2019
 */
public class PayStub
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
     * Simple constructor for the paystub.
     * @param keyboard input object to get info from the user.
     */
    public PayStub(Scanner keyboard)
    {
        this.getInput(keyboard);
        keyboard.nextLine();
        this.calculate();
    }
    
    /**
     * Prompts the user to enter employee data.
     * @param keyboard input method
     */
    private void getInput(Scanner keyboard)
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
    private void calculate()
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
        System.out.printf("\n"); 
    }
    
    /**
     * Accessor method for employee's name.
     * @return employee's name.
     */
    public String getEmployeeName()
    {
        return this.eName;
    }
    
    /**
     * Accessor method for employee's ssn.
     * @return employee's ssn.
     */
    public String getEmployeeSsn()
    {
        return this.eSsn;
    }
    
    /**
     * Accessor method for regular hours worked.
     * @return number of regular hours worked.
     */
    public int getRegularHoursWorked()
    {
        return this.regHours;
    }
    
    /**
     * Accessor method for overtime hours worked.
     * @return number of overtime hours worked.
     */
    public int getOvertimeHoursWorked()
    {
        return this.otHours;
    }
    
    /**
     * Accessor method for employee's pay rate.
     * @return employee's pay rate.
     */
    public double getPayRate()
    {
        return this.payRate;
    }
    
    /**
     * Mutator method for employee's name.
     * @param eName new employee name.
     */
    public void setEmployeeName(String eName)
    {
        this.eName = eName;
    }
    
    /**
     * Mutator method for employee's ssn.
     * @param eSsn new employee ssn.
     */
    public void setEmployeeSsn(String eSsn)
    {
        this.eSsn = eSsn;
    }
    
    /**
     * Mutator method for regular hours worked.
     * @param regHours new number of regular hours worked.
     */
    public void getRegularHoursWorked(int regHours)
    {
        if (regHours >= 0 && regHours != this.regHours)
        {
            this.regHours = regHours;
            this.calculate();
        }
    }
    
    /**
     * Mutator method for overtime hours worked.
     * @param otHours new number of overtime hours worked.
     */
    public void setOvertimeHoursWorked(int otHours)
    {
        if (otHours >= 0 && otHours != this.otHours)
        {
            this.otHours = otHours;
            this.calculate();
        }
    }
    
    /**
     * Mutator method for employee's pay rate.
     * @param payRate new payrate for the mployee.
     */
    public void setPayRate(double payRate)
    {
        if (payRate >= 0.0 && payRate != this.payRate)
        {
            this.payRate = payRate;
            this.calculate();
        }
    }
    
    /**
     * Accessor method for the employee's regular pay.
     * @return employee's regular pay.
     */
    public double getRegPay()
    {
        return this.regPay;
    }
    
    /**
     * Accessor method for the employee's overtime pay.
     * @return employee's overtime pay.
     */
    public double getOtPay()
    {
        return this.otPay;
    }
    
    /**
     * Accessor method for the employee's net pay.
     * @return employee's net pay.
     */
    public double getNetPay()
    {
        return this.netPay;
    }
    
    /**
     * Accessor method for the employee's gross pay.
     * @return employee's gross pay.
     */
    public double getGrossPay()
    {
        return this.grossPay;
    }
    
    /**
     * Accessor method for the employee's overtime pay rate.
     * @return employee's overtime pay rate.
     */
    public double getOtRate()
    {
        return this.otRate;
    }
    
    /**
     * Accessor method for the employee's ss withholdings.
     * @return employee's ss withholdings.
     */
    public double getSsWithholdings()
    {
        return this.ssWithholdings;
    }
    
    /**
     * Accessor method for the employee's federal income tax.
     * @return employee's federal income tax.
     */
    public double getFedTax()
    {
        return this.fedTax;
    }
    
    
    /**
     * It all starts with the main method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        PayStub homer = new PayStub(keyboard);
        PayStub marge = new PayStub(keyboard);
        PayStub lisa = new PayStub(keyboard);
        marge.printPayStub();
        marge.setPayRate(20.00);
        System.out.printf("New gross pay: $%-8.2f\n", marge.getGrossPay());
    }
}
