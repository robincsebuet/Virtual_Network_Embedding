/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package path;

/**
 *
 * @author debobroto
 */
public class PathCost {

    private int numberOfActivNodes = Integer.MAX_VALUE;
    private int numberOfInactiveNodes = Integer.MAX_VALUE;
    private int numberOfPartialActiveNodes = Integer.MAX_VALUE;
    private int numberOfActivEdges = Integer.MAX_VALUE;
    private int numberOfInactiveEdges = Integer.MAX_VALUE;
    private int numberOfPartialActiveEdges = Integer.MAX_VALUE;

    public void initCostToZero() {
        this.numberOfActivEdges = 0;
        this.numberOfActivNodes = 0;
        this.numberOfInactiveEdges = 0;
        this.numberOfInactiveNodes = 0;
        this.numberOfPartialActiveEdges = 0;
        this.numberOfPartialActiveNodes = 0;
    }
    public int getNumberOfActivNodes() {
        return numberOfActivNodes;
    }

    public void setNumberOfActivNodes(int numberOfActivNodes) {
        this.numberOfActivNodes = numberOfActivNodes;
    }

    public int getNumberOfInactiveNodes() {
        return numberOfInactiveNodes;
    }

    public void setNumberOfInactiveNodes(int numberOfInactiveNodes) {
        this.numberOfInactiveNodes = numberOfInactiveNodes;
    }

    public int getNumberOfPartialActiveNodes() {
        return numberOfPartialActiveNodes;
    }

    public void setNumberOfPartialActiveNodes(int numberOfPartialActiveNodes) {
        this.numberOfPartialActiveNodes = numberOfPartialActiveNodes;
    }

    public int getNumberOfActivEdges() {
        return numberOfActivEdges;
    }

    public void setNumberOfActivEdges(int numberOfActivEdges) {
        this.numberOfActivEdges = numberOfActivEdges;
    }

    public int getNumberOfInactiveEdges() {
        return numberOfInactiveEdges;
    }

    public void setNumberOfInactiveEdges(int numberOfInactiveEdges) {
        this.numberOfInactiveEdges = numberOfInactiveEdges;
    }

    public int getNumberOfPartialActiveEdges() {
        return numberOfPartialActiveEdges;
    }

    public void setNumberOfPartialActiveEdges(int numberOfPartialActiveEdges) {
        this.numberOfPartialActiveEdges = numberOfPartialActiveEdges;
    }
}
