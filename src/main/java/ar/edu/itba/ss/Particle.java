package ar.edu.itba.ss;

import java.util.ArrayList;
import java.util.List;

public class Particle {

    private int id;
    private double x;
    private double y;
    private double radius;
    private double property;
    private List<Particle> neighbours;

    public Particle(int id, double x, double y, double radius, double property){
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.neighbours = new ArrayList<Particle>();
        this.property = property;
    }

    Particle(int id, double radius, double property){
        this.id = id;
        this.radius = radius;
        this.property = property;
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

    public double getProperty() {
        return property;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
}