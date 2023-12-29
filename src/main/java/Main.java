import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int betting = 0;

    public static void main(String[] args) {

        System.out.println("승리할 쪽에 배팅해주세요 - 1: 플레이어, 2: 뱅커");
        String userInput = getInput();
        if (userInput.equals("1")) betting = 1;
        else if (userInput.equals("2")) betting = 2;
        else throwError("올바른 입력 바랍니다~~");

        int gameResult = playGame();
        switch (gameResult) {
            case 0:
                System.out.println("플레이어 승!");
                break;
            case 1:
                System.out.println("뱅커 승!");
                break;
        }
    }

    // 플레이어 승: 0, 뱅커 승: 1
    static int playGame() {
        Player player = new Player();
        Player banker = new Player();

        System.out.println("플레이어가 드로우 중입니다...");
        player_value += getInt();
        player_value += getInt();

        System.out.println("뱅커가 드로우 중입니다...");
        banker_value += getInt();
        banker_value += getInt();

        // 내추럴
        if (score(player_value) >= 8 || score(banker_value) >= 9) {
            return player_value > banker_value ? 0 : 1;
        }

        return 0;
    }

    static int score(int n) {
        return n % 10;
    }

    static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }

    static int drawCard() {
        System.out.printf("결과: ");
        int result = getInt();
        switch (result) {
            case 11:

                break;
            case 12:

                break;
            case 13:

                break;
            default:
                System.out.println();
        }
        return result;
    }

    static int getInt() {
        Random random = new Random();
        return random.nextInt(14, 1);
    }

    static void throwError(String s) {
        throw new IllegalArgumentException(s);
    }
}
