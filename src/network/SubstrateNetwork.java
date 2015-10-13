/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import vnemodified.EDGE_MAPPING_METHOD;
import vnemodified.NODE_MAPPING_METHOD;

/**
 *
 * @author debobroto
 */
public class SubstrateNetwork extends Network {

    private String fileName;
    private long id;

    public SubstrateNetwork(String fileName, long id) {
        this.fileName = fileName;
        this.id = id;
    }

    public boolean embedVNRequest(VirtualNetwork vn, NODE_MAPPING_METHOD nmMethod, EDGE_MAPPING_METHOD emMethod) {
        //TO DO:
        ArrayList<VirtualNode> sortedVNodeList = vn.sortNodeListAccordingToRank();
        
        //Step1: Map nodes
        for(int i=0; i< sortedVNodeList.size();i++){
            
        }

        return false;
    }

    public ArrayList<SubstrateNode> rankAndSortNodes() {
        ArrayList<SubstrateNode> nodeList = new ArrayList<SubstrateNode>();
        //To do:
        return nodeList;
    }
    public ArrayList<Long> findCandidateSubstratenodes(VirtualNode vNode, int maxDistance) {

        ArrayList<Long> candidateSubStratenodes = new ArrayList<>();
        for (Node sNode : this.getNodeListAsArrayList()) {
            if ((sNode.distance(vNode) <= maxDistance)
                    && (((SubstrateNode) sNode).getRestCpuResource() >= vNode.getCpuResource())
                    && (!((SubstrateNode) sNode).isIsUsed())) {
                candidateSubStratenodes.add((sNode.getId()));
            }
        }
        return candidateSubStratenodes;
    }
    private void initialize() {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            this.setNumberOfNodes(Integer.parseInt(stringTokenizer.nextToken()));
            this.setNumberOfEdges(Integer.parseInt(stringTokenizer.nextToken()));
            for (int i = 0; i < this.getNumberOfNodes(); i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                double cpuCapacity = Double.parseDouble(stringTokenizer.nextToken());
                SubstrateNode substrateNode = new SubstrateNode(i, x, y, cpuCapacity);
                if (!this.addNode(substrateNode)) {
                    System.out.println("Failed to add this substrate node" + substrateNode.toString());
                }
            }
            for (int i = 0; i < this.getNumberOfEdges(); i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int from = Integer.parseInt(stringTokenizer.nextToken());
                int to = Integer.parseInt(stringTokenizer.nextToken());
                double bandWidth = Double.parseDouble(stringTokenizer.nextToken());
                double delay = Double.parseDouble(stringTokenizer.nextToken());
                SubstrateEdge substrateEdge = new SubstrateEdge(this.getNodeList().get(from), this.getNodeList().get(to), bandWidth, delay);
                if (!this.addEdge(substrateEdge)) {
                    System.out.println("Failed to add this substrate Edge" + substrateEdge.toString());
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception ex) {
            System.out.println("Unable to initialize Substrate Graph due to :");
            ex.printStackTrace();
        }
    }
}
