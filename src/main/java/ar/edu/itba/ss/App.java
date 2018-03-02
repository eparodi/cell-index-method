package ar.edu.itba.ss;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static ar.edu.itba.ss.CliParser.matrixSize;
import static ar.edu.itba.ss.Parser.areaLength;
import static ar.edu.itba.ss.Parser.particles;

public class App {

    public static void main(String[] args) {

        CliParser.parseOptions(args);

        try {
            Parser.parseParticles();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }

        long startTime = System.currentTimeMillis();

        List<List<Particle>> cells = new ArrayList<List<Particle>>();

        for (int i = 0; i < matrixSize*matrixSize ; i++){
            cells.add(new ArrayList<Particle>());
        }

        for (Particle p : particles){
            double cellX = Math.floor(p.getX() / (areaLength/matrixSize));
            double cellY = Math.floor(p.getY() / (areaLength/matrixSize));
            int cellNumber = (int) (cellY * matrixSize + cellX + 1);
            List <Particle> cellParticles = cells.get(cellNumber - 1);
            cellParticles.add(p);
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("Execution time: " + elapsedTime);
    }

}
