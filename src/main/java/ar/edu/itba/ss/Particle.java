package ar.edu.itba.ss;

import java.util.HashSet;
import java.util.Set;

public class Particle {

    private int id;
    private double x;
    private double y;
    private double radius;
    private double property;
    private Set<Particle> neighbours;

    public Particle(int id, double x, double y, double radius, double property){
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.neighbours = new HashSet<Particle>();
        this.property = property;
    }

    Particle(int id, double radius, double property){
        this.id = id;
        this.radius = radius;
        this.property = property;
        this.neighbours = new HashSet<Particle>();
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

    public Set<Particle> getNeighbours() {
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

    public double getDistanceTo(Particle particle){
        return Math.sqrt(Math.pow(x - particle.getX(), 2) +
                Math.pow(y - particle.getY(), 2))
                - radius - particle.getRadius();
    }

    @Override
    public String toString() {
        return "Particle{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", property=" + property +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Particle particle = (Particle) o;

        return id == particle.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}