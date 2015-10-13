/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author debobroto
 */
public class Node  {

    private long id;
    private double coordinateX;
    private double coordinateY;
    private double cpuResource;
    private Hashtable<Long, Edge> toEdgeList;


    public Node(long id, double coordinateX, double coordinateY, double cpuResource) {
        this.id = id;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.cpuResource = cpuResource;
    }

    public double getCpuResource() {
        return cpuResource;
    }

    public void setCpuResource(double cpuResource) {
        this.cpuResource = cpuResource;
    }

    public void addEdgeFrom(Edge e) {
        this.toEdgeList.put(e.getFrom().getId(), e);

    }

    public void addEdgeTo(Edge e) {
        this.toEdgeList.put(e.getTo().getId(), e);

    }

    public double distance(Node pt) {
        double px = pt.getCoordinateX() - this.getCoordinateX();
        double py = pt.getCoordinateY() - this.getCoordinateY();
        return Math.sqrt(px * px + py * py);
    }

    public Edge isEdgeToNodeExists(long destNodeId) {
        return toEdgeList.get(destNodeId);
    }
    public Hashtable<Long, Edge> getEdgeList() {
        return toEdgeList;
    }

    public ArrayList<Edge> getEdgeListAsArrayList() {
        return new ArrayList<Edge>(this.getEdgeList().values());
    }

    public void setEdgeList(Hashtable<Long, Edge> EdgeList) {
        this.toEdgeList = EdgeList;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
