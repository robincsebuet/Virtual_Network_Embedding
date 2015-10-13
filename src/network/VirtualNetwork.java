/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import vnemodified.Constants;

/**
 *
 * @author debobroto
 */
public class VirtualNetwork extends Network {

    private String fileName;
    private int id;
    private int split, time, duration, topology, maxD;
    private double revenue;
    private int reqID;
    private double maxDistance;
    private double totalCPURequirement = 0.0;
    private double totalBWRequirement = 0.0;

    private void rankNodes() {
        ArrayList<Node> nodeList = null;
        for (int i = 0; i < this.getNodeListAsArrayList().size(); i++) {
            VirtualNode vNode = ((VirtualNode) (this.getNodeListAsArrayList().get(i)));
            vNode.setCpuRequirementRatio(vNode.getCpuResource() / this.totalCPURequirement);
            for (int k = 0; k < vNode.getEdgeListAsArrayList().size(); k++) {
                VirtualEdge vEdge = (VirtualEdge) vNode.getEdgeListAsArrayList().get(k);
                vNode.setBwRequirementRatio(vNode.getBwRequirementRatio() + (vEdge.getBandWidthCapacity() / this.totalBWRequirement));
            }
            vNode.setTotalOfBWandCpuRatio(Constants.NODE_WEIGHT_FACTOR * vNode.getCpuRequirementRatio()
                    + Constants.EDGE_WEIGHT_FACTOR * vNode.getBwRequirementRatio());
        }
    }

    public ArrayList<VirtualNode> sortNodeListAccordingToRank() {

        rankNodes();
        VirtualNode[] vnodeListAsArray = new VirtualNode[this.getNodeListAsArrayList().size()];
        for (int i = 0; i < this.getNodeListAsArrayList().size(); i++) {
            vnodeListAsArray[i] = (VirtualNode) this.getNodeListAsArrayList().get(i);
        }
        //TO DO:  sort this array and make a arraylist and assign it to the nodelist of the Network and return

        for (int i = 1; i < vnodeListAsArray.length; i++) {
            VirtualNode tempVNode = vnodeListAsArray[i];
            int j = 0;
            for (j = i - 1; j >= 0 && tempVNode.getTotalOfBWandCpuRatio() < vnodeListAsArray[j].getTotalOfBWandCpuRatio(); j--) {
                vnodeListAsArray[j + 1] = vnodeListAsArray[j];
            }
            vnodeListAsArray[j + 1] = tempVNode;
        }
        ArrayList<VirtualNode> returnList = new ArrayList<>(vnodeListAsArray.length);
        for (int i = 0; i < vnodeListAsArray.length; i++) {
            returnList.add(vnodeListAsArray[i]);
        }
        return returnList;
    }
    private void initialize() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            this.setNumberOfNodes(Integer.parseInt(stringTokenizer.nextToken()));
            this.setNumberOfEdges(Integer.parseInt(stringTokenizer.nextToken()));
            this.setSplit(Integer.parseInt(stringTokenizer.nextToken()));
            this.setTime(Integer.parseInt(stringTokenizer.nextToken()));
            this.setDuration(Integer.parseInt(stringTokenizer.nextToken()));
            this.setTopology(Integer.parseInt(stringTokenizer.nextToken()));
            this.setMaxD(Integer.parseInt(stringTokenizer.nextToken()));


            for (int i = 0; i < this.getNumberOfNodes(); i++) {

                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                double cpuCapacity = Double.parseDouble(stringTokenizer.nextToken());
                VirtualNode virtualNode = new VirtualNode(i, x, y, cpuCapacity);
                if (!this.addNode(virtualNode)) {
                    System.out.println("Failed to add this substrate node" + virtualNode.toString());
                }
                this.totalCPURequirement += cpuCapacity;
            }
            for (int i = 0; i < this.getNumberOfEdges(); i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int from = Integer.parseInt(stringTokenizer.nextToken());
                int to = Integer.parseInt(stringTokenizer.nextToken());
                double bandWidth = Double.parseDouble(stringTokenizer.nextToken());
                double delay = Double.parseDouble(stringTokenizer.nextToken());
                VirtualEdge virtualEdge = new VirtualEdge(this.getNodeList().get(from), this.getNodeList().get(from), bandWidth, delay);
                if (!this.addEdge(virtualEdge)) {
                    System.out.println("Failed to add this substrate Edge" + virtualEdge.toString());
                }
                this.totalBWRequirement += bandWidth;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception ex) {
            System.out.println("Unable to initialize Virtual Graph due to :");
            ex.printStackTrace();
        } finally {
        }
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSplit() {
        return split;
    }

    public void setSplit(int split) {
        this.split = split;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTopology() {
        return topology;
    }

    public void setTopology(int topology) {
        this.topology = topology;
    }

    public int getMaxD() {
        return maxD;
    }

    public void setMaxD(int maxD) {
        this.maxD = maxD;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public VirtualNetwork(String fileName, int id) {
        this.fileName = fileName;
        this.id = id;
    }

}
