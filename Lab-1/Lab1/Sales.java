/**
 * Activity 3 for Lab 1 of CS 1440
 *
 * @author Willow Sapphire
 * @version 6/6/2019
 */
public class Sales
{
    public static void main(String[] args)
    {
        System.out.println("Enter a purchase amount: ");
        double purchaseAmount = Given.getDouble();
        double stateTax, countyTax, totalTax, totalPrice;
        stateTax = 0.05 * purchaseAmount;
        countyTax = 0.03 * purchaseAmount;
        totalTax = stateTax + countyTax;
        totalPrice = purchaseAmount + totalTax;
        System.out.println("Amount of Purchase:"
            + '\t' + "$" + purchaseAmount);
        System.out.println("State Sales Tax Paid:"
            + '\t' + "$" + stateTax);
        System.out.println("County Sales Tax Paid:"
            + '\t' + "$" + countyTax);
        System.out.println("Total Sales Tax Paid:"
            + '\t' + "$" + totalTax);
        System.out.println("Total Sales Price:"
            + '\t' + "$" + totalPrice);
    }
}
