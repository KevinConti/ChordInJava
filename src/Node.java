import java.util.ArrayList;
import java.util.Dictionary;

public class Node {
    public static Dictionary<Integer, Boolean> allNodeIds;
    private int nodeId;
    private FingerTable fingerTable;

    public Node(FingerTable fingerTable) {
        this.fingerTable = fingerTable;
        this.nodeId = createRandomId();
        allNodeIds.put(nodeId, true);
    }

    private int createRandomId(){
        // TODO This method will create a random node id, check to see if that random number is
        // already taken by another node (by comparing to the allNodeIds dictionary, and then
        // return it
        return -1;
    }

    public int getNodeID() {
        return nodeId;
    }

    public FingerTable getFingerTable() {
        return fingerTable;
    }
}
