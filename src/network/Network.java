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
public abstract class Network {

    private Hashtable<Long, Node> nodeList;
    private long numberOfNodes;
    private long numberOfEdges;

    public long getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(long numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public long getNumberOfEdges() {
        return numberOfEdges;
    }

    public void setNumberOfEdges(long numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    public Hashtable<Long, Node> getNodeList() {
        return nodeList;
    }

    public ArrayList<Node> getNodeListAsArrayList() {
        return new ArrayList<Node>(this.nodeList.values());

    }

    public boolean addNode(Node v) {
        if (nodeList.containsKey(v.getId())) {
            return false;
        }
        nodeList.put(v.getId(), v);
        return true;
    }

    public boolean addEdge(Edge e) {
        if (this.nodeList.get(e.getFrom()).isEdgeToNodeExists(e.getTo().getId()) == null) {
            if (this.nodeList.get(e.getTo()).isEdgeToNodeExists(e.getFrom().getId()) == null) {
                this.nodeList.get(e.getFrom()).addEdgeTo(e);
                this.nodeList.get(e.getTo()).addEdgeFrom(e);
            }
        }


        return true;
    }
}
