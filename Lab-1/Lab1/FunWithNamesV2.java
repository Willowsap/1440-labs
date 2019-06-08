/**
 * Post Lab for Lab 1 of CS 1440
 *
 * @author Willow Sapphire
 * @version 6/6/2019
 */
public class FunWithNamesV2
{
    public static void main(String[] args)
    {
        String firstName, middleName,lastName;
        
        System.out.println("Enter your first name: ");
        firstName = Given.getString();
        System.out.println("Enter your middle name: ");
        middleName = Given.getString();
        System.out.println("Enter your last name: ");
        lastName = Given.getString();
        
        String fullName = firstName + " "
            + middleName + " "
            + lastName;
        int characterCount = firstName.length()
            + middleName.length() 
            + lastName.length();
        String login = lastName.toLowerCase()
            + firstName.toLowerCase().charAt(0)
            + middleName.toLowerCase().charAt(0);
            
        System.out.println("Name: " + fullName);
        System.out.println("Number of characters in full name: " 
            + characterCount);
        System.out.println("Login id: " + login);
    }
}
