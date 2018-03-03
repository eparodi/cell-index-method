package ar.edu.itba.ss;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static ar.edu.itba.ss.CliParser.interactionRadius;
import static ar.edu.itba.ss.CliParser.matrixSize;
import static ar.edu.itba.ss.CliParser.periodicContour;
import static ar.edu.itba.ss.Parser.areaLength;
import static ar.edu.itba.ss.Parser.particles;

public class App {

    private static List<List<Particle>> cells;

    public static void main(String[] args) {

        CliParser.parseOptions(args);

        try {
            Parser.parseParticles();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }

        long startTime = System.currentTimeMillis();

        /* Initialize cells */
        cells = new ArrayList<List<Particle>>();

        for (int i = 0; i < matrixSize*matrixSize ; i++){
            cells.add(new ArrayList<Particle>());
        }

        /* Add particles to cells */

        for (Particle p : particles){
            double cellX = Math.floor(p.getX() / (areaLength/matrixSize));
            double cellY = Math.floor(p.getY() / (areaLength/matrixSize));
            int cellNumber = (int) (cellY * matrixSize + cellX);
            List <Particle> cellParticles = cells.get(cellNumber);
            cellParticles.add(p);
        }

        for (List<Particle> cellParticles : cells){
            for (Particle p : cellParticles){
                /*TODO: save to avoid recalculation? */
                double cellX = Math.floor(p.getX() / (areaLength/matrixSize));
                double cellY = Math.floor(p.getY() / (areaLength/matrixSize));

                checkAdjacent(p, cellX, cellY);
                checkAdjacent(p, cellX, cellY + 1);
                checkAdjacent(p, cellX + 1, cellY + 1);
                checkAdjacent(p, cellX + 1, cellY);
                checkAdjacent(p, cellX + 1, cellY - 1);
            }
        }

        for (List<Particle> particleList : cells){
            for (Particle p : particleList){
                System.out.print(p.getId());
                for (Particle neighbour : p.getNeighbours()){
                    System.out.print(" " + neighbour.getId());
                }
                System.out.print("\n");
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("Execution time: " + elapsedTime);
    }

    private static void checkAdjacent(Particle particle, double cellX, double cellY) {

        if (periodicContour) {

            if (cellX >= matrixSize){
                cellX = 0;
            }

            if (cellY >= matrixSize){
                cellY = 0;
            }

            if (cellX == -1){
                cellX = matrixSize - 1;
            }

            if (cellY == -1){
                cellY = matrixSize - 1;
            }

        }else {
            if (cellX >= matrixSize || cellX < 0 || cellY >= matrixSize || cellY < 0) {
                return;
            }
        }

        int adjCellNumber = (int) (cellY * matrixSize + cellX);

        List<Particle> cellParticles = cells.get(adjCellNumber);

        for (Particle adjacentParticle : cellParticles){

            if (adjacentParticle.getId() != particle.getId()){ // Avoid checking the same particle

                double distance = Math.sqrt(Math.pow(particle.getX() - adjacentParticle.getX(), 2) +
                        Math.pow(particle.getY() - adjacentParticle.getY(), 2))
                        - particle.getRadius() - adjacentParticle.getRadius();

                if (distance < interactionRadius){
                    particle.addNeighbour(adjacentParticle);
                    adjacentParticle.addNeighbour(particle);
                }

            }
        }
    }

}
