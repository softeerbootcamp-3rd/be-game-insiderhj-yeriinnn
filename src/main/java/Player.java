import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> cards;
    private int totalSum;

    public Player() {
        this.cards = new ArrayList<>();
        this.totalSum = 0;
    }

    public void receiveCard(int cardValue) {
        cards.add(cardValue);
        totalSum += cardValue;
        totalSum %= 10;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void showCards() {
        System.out.println("플레이어의 카드 합: " + cards);
    }
}

