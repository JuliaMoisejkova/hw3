import java.util.LinkedList;

public class Player {
     private LinkedList <Card> set;

    public Player(LinkedList<Card> set) {
        this.set = set;
    }

    public LinkedList<Card> getSet() {
        return set;
    }

    public void setSet(LinkedList<Card> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Player{" +
                "set=" + set +
                '}';
    }
}
