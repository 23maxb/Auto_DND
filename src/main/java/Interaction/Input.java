package Interaction;

import java.util.Arrays;
import java.util.Scanner;

public class Input
{
    /**
     * Simply prompts the user for input and gets that input as a string.
     *
     * @param prompt The prompt to display to the user.
     * @return whatever the user typed
     */
    public static String prompt(String prompt)
    {
        System.out.println(prompt);
        return new Scanner(System.in).nextLine();
    }

    /**
     * Asks the user for which options they wish to choose from.
     *
     * @param options the options the user can choose from
     * @return an array of the options chosen (sorted alphabetically)
     */
    public static String promptOptions(String... options)
    {
        return promptOptions(1, options)[0];
    }

    /**
     * Asks the user for which options they wish to choose from.
     *
     * @param select  the number of options the user can choose of all the options
     * @param options the options the user can choose from
     * @return an array of the options chosen (sorted alphabetically)
     */
    public static String[] promptOptions(int select, String... options)
    {
        String[] toReturn = new String[select];
        int counter = 0;
        System.out.println("Select " + select + " of the following:");
        for (int i = 0, promptsLength = options.length; i < promptsLength; i++)
        {
            System.out.println((i + 1) + ". " + (options[i]));
        }
        while (counter != toReturn.length)
        {
            String s = prompt("Enter your selection (" + (counter + 1) + "/" + select + "): ");
            try
            {
                int selection = Integer.parseInt(s) - 1;
                for (String value : toReturn)
                {
                    if (value != null && value.equals(options[selection]))
                    {
                        throw new IllegalArgumentException("You have already selected that option" +
                                ".");
                    }
                }
                toReturn[counter] = options[selection];
                counter++;
            }
            catch (NumberFormatException e)
            {
                for (String value : toReturn)
                {
                    if (value != null && value.equals(s))
                    {
                        throw new IllegalArgumentException("You have already selected that option" +
                                ".");
                    }
                }
                int c = counter;
                for (String prompt : options)
                    if (prompt.equals(s))
                    {
                        toReturn[counter] = prompt;
                        counter++;
                    }
                if (c == counter)
                    throw new IllegalArgumentException("Invalid input");
            }
        }
        return Arrays.stream(toReturn).sorted().toArray(String[]::new);
    }


}