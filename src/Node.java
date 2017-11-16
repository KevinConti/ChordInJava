import java.util.Dictionary;
import com.conti.UserInput;

public class Node {
    public static Dictionary<Integer, Boolean> allExistingNodeIds;
    private UserInput userInput;
    private int nodeId;
    private FingerTable fingerTable;

    public Node(FingerTable fingerTable, UserInput userInput) {
        this.fingerTable = fingerTable;
        this.nodeId = createRandomId();
        this.userInput = userInput;
        allExistingNodeIds.put(nodeId, true);
    }

    private int createRandomId(){
        boolean isUnique = false;
        int id = -1;
        while (!isUnique) {
            id = generatePossibleId();
            isUnique = checkForUniqueId(id);
        }

        return id;
    }

    private int generatePossibleId(){
        int max = (int) Math.pow(2, userInput.getB());

        int range = max + 1;
        return (int)(Math.random() * range);
    }

    private boolean checkForUniqueId(int id){
        boolean isUnique;
        isUnique = !allExistingNodeIds.get(id);
        return isUnique;
    }

    public int getNodeID() {
        return nodeId;
    }

    public FingerTable getFingerTable() {
        return fingerTable;
    }
}
