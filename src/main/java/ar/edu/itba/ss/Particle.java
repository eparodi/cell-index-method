package ar.edu.itba.ss;

import java.util.ArrayList;
import java.util.List;

public class Particle {

    private int id;
    private double x;
    private double y;
    private double radius;
    private List<Particle> neighbours;

    public Particle(int id, double x, double y, double radius){
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.neighbours = new ArrayList<Particle>();
    }

    public int getId(){
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public List<Particle> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Particle neighbour){
        this.neighbours.add(neighbour);
    }
}