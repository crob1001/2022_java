//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter; 

//main class
public class dow
{
    //main function
    public static void main(String[] args)
    {
        //initilization
        String[] week;
        week = new String [7];
        //trys to find the file with all the data in it,
        //prints error if it can't be found
        try
        {
            File file = new File("C:\\Users\\chris\\Desktop\\java\\JavaApplication1\\src\\javaapplication1\\data.txt");
            Scanner input = new Scanner(file);

            System.out.println("DOW Temperature Started. Please wait....");

            //places the temps in the correct strings
            while(input.hasNextLine())
            {
                String line = input.nextLine();
                int day;
                day = Integer.parseInt(split(0, line));
                if (day == 1)
                {
                    week[0] = add(week[0], split(1, line));
                }else if (day == 2)
                {
                    week[1] = add(week[1], split(1, line));
                }else if (day == 3)
                {
                    week[2] = add(week[2], split(1, line));
                }else if (day == 4)
                {
                    week[3] = add(week[3], split(1, line));
                }else if (day == 5)
                {
                    week[4] = add(week[4], split(1, line));
                }else if (day == 6)
                {
                    week[5] = add(week[5], split(1, line));
                }else if (day == 7)
                {
                    week[6] = add(week[6], split(1, line));
                }else
                {
                    System.out.println("ERROR");
                }
            }
            input.close();
            write(week);
        } catch (Exception ex)
        {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }       
    }

    //adds items to the end of a string
    public static String add(String list, String additive)
    {
        //if null set to empty string
        if (list == null)
        {
            list = "";
        }

        String newlist;
        if (list == "")
        {
            newlist = additive;
        } else
        {
            newlist = list + " " + additive;
        }
        return newlist;
    }

    //splits a string at the specifyed character
    public static String split(int place, String list)
    {
        String num;
        num = list.split(" ")[place];
        return num;
    }

    //writes data to a file, if there is no data uses a zero
    public static void write(String[] week)
    {
        //trys to write to file
        //prints error if it can't be found
        try
        {
            FileWriter writer = new FileWriter("C:\\Users\\chris\\Desktop\\java\\JavaApplication1\\src\\javaapplication1\\output.txt");
            writer.write("1 " + average_high_low(week[0]) + "\n"
            .concat("2 " + average_high_low(week[1]) + "\n")
            .concat("3 " + average_high_low(week[2]) + "\n")
            .concat("4 " + average_high_low(week[3]) + "\n")
            .concat("5 " + average_high_low(week[4]) + "\n")
            .concat("6 " + average_high_low(week[5]) + "\n")
            .concat("7 " + average_high_low(week[6])));
            writer.close();
            System.out.println("DOW Temperature Completed Successfully.");
        } catch (Exception ex)
        {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }

    //determine the average, high, and low temps
    public static String average_high_low(String day)
    {
        //initilization
        int average = 0;
        int high = -9000;
        int low = 9000;
        int chcount = 0;

        //if null set to empty string
        if (day == null)
        {
            day = "";
        }
        
        //if empty returns zero
        if (day == "")
        {
            day = "0";
            high = 0;
            low = 0;
        } 

        //determines how many temps are in that day
        for(int i=0; i<day.length(); i++)
        {  
            if (day.charAt(i) == ' ')
            {
                chcount ++;
            }
        }

        //determins the high, low and average for the day
        for (int i = 0; i < chcount; i++)
        {
            int current = Integer.parseInt(split(i, day));
            average = average + current;
            if (current > high)
            {
                high = current;
            } if (current < low)
            {
                low = current;
            }
            average = average / chcount;
        }

        //concats and returns
        String stringaverage_high_low = high + " " + low + " " + average;
        return stringaverage_high_low;
    }
}