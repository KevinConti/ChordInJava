import java.util.HashMap;
import com.conti.UserInput;


public class Node {
    public static HashMap<Integer, Boolean> allExistingNodeIds = new HashMap<>();
    private UserInput userInput;
    private int nodeId;
    private FingerTable fingerTable;

    public Node(FingerTable fingerTable, UserInput userInput) {
        this.fingerTable = fingerTable;
        this.userInput = userInput;
        this.nodeId = createRandomId();
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
        int max = (int) Math.pow(2, this.userInput.getB());

        int range = max + 1;
        return (int)(Math.random() * range + 1);
    }

    private boolean checkForUniqueId(int id){
        boolean isUnique;
            if (allExistingNodeIds.get(id) == null){
                isUnique = true;
            }
            else isUnique = false;
            return isUnique;
    }

    public int getNodeID() {
        return nodeId;
    }

    public FingerTable getFingerTable() {
        return fingerTable;
    }
}
