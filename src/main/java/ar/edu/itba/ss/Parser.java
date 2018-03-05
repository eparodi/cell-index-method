package ar.edu.itba.ss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Parser {

    private static int numberOfParticles;
    static Queue<Particle> particles = new LinkedList<Particle>();
    static double areaLength;

    public static void parseParticles() throws FileNotFoundException {
        staticSystemParse();
        dynamicSystemParse();
    }

    private static void staticSystemParse() throws FileNotFoundException {
        File staticFile = new File(CliParser.staticFile);
        Scanner sc = new Scanner(staticFile);
        numberOfParticles = sc.nextInt();
        areaLength = sc.nextDouble();
        for (int i = 0; i < numberOfParticles; i++){
            double radius   = sc.nextDouble();
            double property = sc.nextDouble();
            particles.add(new Particle(i, radius, property));
        }
    }

    private static void dynamicSystemParse() throws FileNotFoundException {
        File dynamicFile = new File(CliParser.dynamicFile);
        Scanner sc = new Scanner(dynamicFile);
        sc.nextInt();   /* Discard first time value */
        for (int i = 0; i < numberOfParticles; i++){
            double x = sc.nextDouble();
            double y = sc.nextDouble();
//            sc.nextDouble(); sc.nextDouble(); /* Remove particles speed, it is not important now */
            Particle particle = particles.poll();
            particle.setX(x);
            particle.setY(y);
            particles.add(particle);
        }
    }

}
