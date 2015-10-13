/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author debobroto
 */
public class VirtualEdge extends Edge {

    private boolean isEmbedded = false;

    public boolean isIsEmbedded() {
        return isEmbedded;
    }

    public void setIsEmbedded(boolean isEmbedded) {
        this.isEmbedded = isEmbedded;
    }

    public VirtualEdge(Node from, Node to, double bandWidthCapacity, double delay) {
        super(from, to, bandWidthCapacity, delay);
    }
}
