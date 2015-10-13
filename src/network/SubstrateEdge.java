/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author debobroto
 */
public class SubstrateEdge extends Edge {

    private boolean isActive = false;

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public SubstrateEdge( Node from, Node to, double bandWidthCapacity, double delay) {
        super(from, to, bandWidthCapacity, delay);
    }

    @Override
    public String toString() {
        // TO do: write specfic implementation
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
