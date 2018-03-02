package ar.edu.itba.ss;

import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) {

        CliParser.parseOptions(args);

        try {
            Parser.parseParticles();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }

        long startTime = System.currentTimeMillis();

        // TODO: Insert the hard part.

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("Execution time: " + elapsedTime);
    }

}
