import java.util.ArrayList;
import java.util.Dictionary;

public class Node {
    public static Dictionary<Integer, Boolean> allNodeIds;
    private int nodeId;
    private FingerTable fingerTable;

    public Node(FingerTable fingerTable) {
        this.fingerTable = fingerTable;
        //TODO nodeID = createRandomId();
    }

    public int getNodeID() {
        return nodeId;
    }

    public FingerTable getFingerTable() {
        return fingerTable;
    }
}
