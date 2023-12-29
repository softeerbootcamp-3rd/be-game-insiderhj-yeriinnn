import java.util.Random;
import java.util.Scanner;

public class Game {

    // 플레이어 승: 0, 뱅커 승: 1
    static int playGame() {
        Player player = new Player();
        Player banker = new Player();

        System.out.println("플레이어가 드로우 중입니다...");
        player.receiveCard(drawCard());
        player.receiveCard(drawCard());

        System.out.println("뱅커가 드로우 중입니다...");
        banker.receiveCard(drawCard());
        banker.receiveCard(drawCard());

        // 내추럴
        if (player.getTotalSum() >= 8 || banker.getTotalSum() >= 8) {
            System.out.println("카드의 합이 8 이상이므로 내추럴입니다.");
            return gameResult(player, banker);
        }

        System.out.println("내추럴이 아니기 때문에 진행합니다.");
        System.out.println("플레이어의 차례...");

        // 플레이어가 스탠드면 뱅커도 그냥 6,7일때만 스탠드
        if (player.getTotalSum() == 6 || player.getTotalSum() == 7) {
            System.out.println("스탠드, 카드를 받지 않습니다.");
            System.out.println("뱅커의 차례...");

            if (banker.getTotalSum() == 6 || banker.getTotalSum() == 7) {
                System.out.println("스탠드, 카드를 받지 않습니다.");
            } else {
                System.out.println("뱅커가 드로우 중입니다...");
                banker.receiveCard(drawCard());
            }
        // 플레이어가 드로우면 뱅커는 드로우 규칙 표에서 참고해서 드로우
        } else {

            System.out.println("플레이어가 드로우 중입니다...");
            player.receiveCard(drawCard());

            System.out.println("뱅커의 차례...");
            if (GameUtils.findValue(player, banker) == 0) {
                System.out.println("스탠드, 카드를 받지 않습니다.");
            } else {
                System.out.println("뱅커가 드로우 중입니다...");
                banker.receiveCard(drawCard());
            }
        }

        return gameResult(player, banker);
    }

    static int drawCard() {
        System.out.print("결과: ");
        int result = getInt();
        switch (result) {
            case 11:
                System.out.println("J");
                return 0;
            case 12:
                System.out.println("Q");
                return 0;
            case 13:
                System.out.println("K");
                return 0;
            default:
                System.out.println(result);
        }
        return result;
    }

    static int getInt() {
        Random random = new Random();
        return random.nextInt(13) + 1;
    }

    static int gameResult(Player player, Player banker) {
        System.out.println("----------------");
        System.out.println("플레이어의 숫자 합: " + player.getTotalSum());
        System.out.println("뱅커의 숫자 합: " + banker.getTotalSum());

        if (player.getTotalSum() > banker.getTotalSum()) {
            return 1;
        } else if (player.getTotalSum() < banker.getTotalSum()) {
            return 2;
        }
        return 3;
    }
}
