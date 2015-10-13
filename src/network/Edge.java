/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author debobroto
 */
public class Edge {

    private Node from, to;
    private double bandWidthCapacity = Double.NEGATIVE_INFINITY;
    private double delay = Double.POSITIVE_INFINITY;

    public Edge(Node from, Node to, double bandWidthCapacity, double delay) {

        this.from = from;
        this.to = to;
        this.bandWidthCapacity = bandWidthCapacity;
        this.delay = delay;
    }

    

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public double getBandWidthCapacity() {
        return bandWidthCapacity;
    }

    public void setBandWidthCapacity(double bandWidthCapacity) {
        this.bandWidthCapacity = bandWidthCapacity;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }
}
