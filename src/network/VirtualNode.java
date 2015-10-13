/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author debobroto
 */
public class VirtualNode extends Node  {

    private double cpuRequirementRatio = 0.0;
    private double bwRequirementRatio = 0.0;
    private double totalOfBWandCpuRatio = 0.0;
    private boolean isEmbedded = false;

    public boolean isIsEmbedded() {
        return isEmbedded;
    }

    public void setIsEmbedded(boolean isEmbedded) {
        this.isEmbedded = isEmbedded;
    }


    public double getTotalOfBWandCpuRatio() {
        return totalOfBWandCpuRatio;
    }

    public void setTotalOfBWandCpuRatio(double totalOfBWandCpuRatio) {
        this.totalOfBWandCpuRatio = totalOfBWandCpuRatio;
    }

    public VirtualNode(long id, double coordinateX, double coordinateY, double cpuResource) {
        super(id, coordinateX, coordinateY, cpuResource);
    }

    public double getCpuRequirementRatio() {
        return cpuRequirementRatio;
    }

    public void setCpuRequirementRatio(double cpuRequirementRatio) {
        this.cpuRequirementRatio = cpuRequirementRatio;
    }

    public double getBwRequirementRatio() {
        return bwRequirementRatio;
    }

    public void setBwRequirementRatio(double bwRequirementRatio) {
        this.bwRequirementRatio = bwRequirementRatio;
    }
}
