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
        String day1 = "";
        String day2 = "";
        String day3 = "";
        String day4 = "";
        String day5 = "";
        String day6 = "";
        String day7 = "";
        //trys to find the file with all the data in it,
        //prints error if it can't be found
        try
        {
            File file = new File("C:\\Users\\chris\\Desktop\\java\\DOW\\data.txt");
            Scanner input = new Scanner(file);

            System.out.println("DOW Temperature Started. Please wait....");
            while(input.hasNextLine())
            {
                String line = input.nextLine();
                int day;
                day = Integer.parseInt(split(0, line));
                if (day == 1)
                {
                    day1 = add(day1, split(1, line));
                }else if (day == 2)
                {
                    day2 = add(day2, split(1, line));
                }else if (day == 3)
                {
                    day3 = add(day3, split(1, line));
                }else if (day == 4)
                {
                    day4 = add(day4, split(1, line));
                }else if (day == 5)
                {
                    day5 = add(day5, split(1, line));
                }else if (day == 6)
                {
                    day6 = add(day6, split(1, line));
                }else if (day == 7)
                {
                    day7 = add(day7, split(1, line));
                }else
                {
                    System.out.println("ERROR");
                }
            }
            input.close();
            write(day1, day2, day3, day4, day5, day6, day7);
        } catch (Exception ex)
        {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }       
    }

    public static String add(String list, String additive)
    {
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

    public static String split(int place, String list)
    {
        String num;
        num = list.split(" ")[place];
        return num;
    }

    public static void write(String day1, String day2, String day3, String day4, String day5, String day6, String day7)
    {
        try
        {
            FileWriter writer = new FileWriter("C:\\Users\\chris\\Desktop\\java\\DOW\\output.txt");
            writer.write("1 " + average_high_low(day1) + "\n"
            .concat("2 " + average_high_low(day2) + "\n")
            .concat("3 " + average_high_low(day3) + "\n")
            .concat("4 " + average_high_low(day4) + "\n")
            .concat("5 " + average_high_low(day5) + "\n")
            .concat("6 " + average_high_low(day6) + "\n")
            .concat("7 " + average_high_low(day7)));
            writer.close();
            System.out.println("DOW Temperature Completed Successfully.");
        } catch (Exception ex)
        {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }

    public static String average_high_low(String day)
    {
        int average = 0;
        int high = -9000;
        int low = 9000;
        int chcount = 0;
        if (day == "")
        {
            day = "0";
            high = 0;
            low = 0;
        } 
        for(int i=0; i<day.length(); i++)
        {  
            if (day.charAt(i) == ' ')
            {
                chcount ++;
            }
        }
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
        String stringaverage_high_low = high + " " + low + " " + average;
        return stringaverage_high_low;
    }
}