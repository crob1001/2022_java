//imports
import java.util.Scanner;

import java.util.Arrays;

public class minimum_coins
{

    public static void main(String[] args)
    {
        //initilization
        Scanner in = new Scanner(System.in);
        int list_place = 1;
        int[] coin_ammount = {0, 25, 0, 10, 0, 5, 0};
        boolean running = true;

        //main loop
        while(running)
        {
            //resets values
            list_place = 1;
            for (int index = 0; index < 7; index += 2)
            {
                coin_ammount[index] = 0;
            }

            //asks for input
            System.out.println("Please Enter Amount of Change (1-99) or ZERO to EXIT:");
            coin_ammount[0] = in.nextInt();

            //checks it the input is zero
            if (coin_ammount[0] != 0)
            {
                while(coin_ammount[0] >= 5)
                {
                    while(coin_ammount[0] >= coin_ammount[list_place])
                    {
                        coin_ammount[0] = coin_ammount[0] - coin_ammount[list_place];
                        coin_ammount[list_place + 1]++;
                    }
                    list_place = list_place + 2;
                }

                //displays how many coins make up the cent total
                System.out.println("\nQuarters " + coin_ammount[2] + "\n"
                .concat("Dimes " + coin_ammount[4] + "\n")
                .concat("Nickles " + coin_ammount[6] + "\n")
                .concat("Pennies " + coin_ammount[0] + "\n"));
            }
            
            //if input is zero ends the loop
            else
            {
                running = false;
            }
        }
    }
}