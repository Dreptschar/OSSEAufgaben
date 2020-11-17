package de.hfu;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        input = input.toUpperCase();
        System.out.println(input);
    }

}
