package hello_world;

import java.util.Scanner;

public class hello_world
{    
    public static void main(String[] args) 
    {//start

        //initization
        String name = "";
        int age = 0;
        int count = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Hello World");//output

        //get user name
        System.out.println("Enter Your Name");
        name = in.next();

        //get user age
        System.out.println("Enter Your Age");
        age = in.nextInt();

        System.out.println("Hello " + name + " Age: " + age);

        //party check
        if(age >= 21)
        {
            System.out.println("You can Party");
        }

        //vote check
        if(age >= 18)
        {   
            //true
            System.out.println("You Can Vote");
        }
        else
        {   
            //false
            System.out.println("Sorry no Vote for you! :-(");
        }

        while(count<10)
        {//true
            System.out.println("The count is: " + count);
            count++;
        }
        
    }//stop

} //class
