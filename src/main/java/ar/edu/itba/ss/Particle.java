package ar.edu.itba.ss;

import java.util.Set;
import java.util.TreeSet;

public class Particle implements Comparable<Particle>{

    private int id;
    private double x;
    private double y;
    private double radius;
    private double property;
    private Set<Particle> neighbours;

    private double cellX;
    private double cellY;

    public Particle(int id, double x, double y, double radius, double property){
        this.id = id;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.neighbours = new TreeSet<>();
        this.property = property;
    }

    Particle(int id, double radius, double property){
        this.id = id;
        this.radius = radius;
        this.property = property;
        this.neighbours = new TreeSet<>();
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

    public double getPeriodicDistanceTo(Particle particle){

        double dx = Math.abs(this.x - particle.x);
        if (dx > Parser.areaLength / 2)
            dx = Parser.areaLength - dx;

        double dy = Math.abs(this.y - particle.y);
        if (dy > Parser.areaLength / 2)
            dy = Parser.areaLength - dy;

        return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
    }

    public int compareTo(Particle particle){
        return id - particle.getId();
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

    public double getCellX() {
        return cellX;
    }

    public double getCellY() {
        return cellY;
    }

    public void setCellX(double cellX) {
        this.cellX = cellX;
    }

    public void setCellY(double cellY) {
        this.cellY = cellY;
    }
}