/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import path.PathCost;

/**
 *
 * @author debobroto
 */
public class SubstrateNode extends Node implements Comparable<SubstrateNode> {

    private boolean isUsed = false; // This variable is used to indicate whether this substrate node
    //is used in to embed a specific VN request
    private double restCpuResource;
    private boolean isActive = false;
    private PathCost cost = new PathCost();
    private SubstrateNode predecessor;

    @Override
    public int compareTo(SubstrateNode o) {
        //TO dO: add active non active count based cost comparison here
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PathCost getCost() {
        return cost;
    }

    public void setCost(PathCost cost) {
        this.cost = cost;
    }

    public SubstrateNode getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(SubstrateNode predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public double getRestCpuResource() {
        return restCpuResource;
    }

    public void setRestCpuResource(double restCpuResource) {
        this.restCpuResource = restCpuResource;
    }

    public SubstrateNode(long id, double coordinateX, double coordinateY, double cpuResource) {
        super(id, coordinateX, coordinateY, cpuResource);
        this.restCpuResource = cpuResource;
    }
}
