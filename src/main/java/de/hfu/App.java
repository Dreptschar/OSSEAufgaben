package de.hfu;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        /**
         * Das hier ist ein javadoc kommentar
         */
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        input = input.toUpperCase();
        /**
         * Hier wird das ergebnis ausgegeben
         */
        System.out.println(input);
    }

}
