import java.util.Scanner;

public class GCD
{
    public static void main(String[] args)
    {
        //initilization
        Scanner in = new Scanner(System.in);
        boolean running = true;
        int num1;
        int num2;

        //main loop 
        while(running)
        {
            //asks for the first number
            System.out.println("Enter the First Number or ZERO to exit:\n");
            num1 = in.nextInt();

            //ends if 0 is entered
            if(num1 == 0)
            {
                running = false;
                continue;
            }
            System.out.println("Enter the Second Number:\n");
            
            //asks for the second number
            num2 = in.nextInt();
            System.out.println("\nThe GCD is " + gcd(num1, num2) );
        }   

    }

    //find the gcd using the euclid method
    public static int gcd(int num1, int num2)
    {
        if (num2 == 0)
        {
            return num1;
        }
        while (num1 != 0)
        {
            if (num2 > num1)
            {
                num2 = num2 - num1;
            }
            else
            {
                num1 = num1 - num2;
            }
        }
        return num2;
    }

}