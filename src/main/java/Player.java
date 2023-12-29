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

    public int getThirdCardValue() {
        if (cards.size() >= 3) {
            return cards.get(2); // 0번째부터 시작하므로 세 번째 카드는 인덱스 2에 위치
        } else {
            return -1; // 카드가 세 장 미만일 때는 예외 처리 가능하도록 -1 반환
        }
    }
}
