/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.Hashtable;

/**
 *
 * @author debobroto
 */
public class NetworkStack {

    private static NetworkStack networkStack = null;

    private SubstrateNetwork substrateNetwork;
    private Hashtable<Integer, VirtualNetwork> virtualNetworkRequestList = new Hashtable<>();

    private NetworkStack() {
    }

    public boolean addVirtualNetwork(VirtualNetwork vn) {
        if (virtualNetworkRequestList.containsKey(vn.getId())) {
            return false;
        }
        virtualNetworkRequestList.put(vn.getId(), vn);
        return true;
    }

    public NetworkStack getInstance() {
        if (networkStack == null) {
            networkStack = new NetworkStack();
        }
        return networkStack;
    }
}
