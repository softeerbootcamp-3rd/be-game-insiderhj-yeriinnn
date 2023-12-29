import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int betting;
    private static int seedMoney = 100;
    private static int betMoney;
    private static int tieBet;

    public static void main(String[] args) {

        System.out.println("바카라 게임에 어서오세용~");

        while (seedMoney > 0) {
            System.out.println("-----------게임시작-----------");
            seedMoney -= 1;
            betMoney = 1;
            System.out.println("기본배팅 1코인이 차감되었습니다.");
            showSeed();

            betting = getUserInput("승리할 쪽에 배팅해주세요 - 1: 플레이어, 2: 뱅커", 1, 2);
            betMoney += getUserInput("추가배팅할 금액을 입력해주세요 (원치 않을 시 0 입력)", 0, seedMoney);
            seedMoney -= betMoney - 1;
            tieBet = getUserInput("타이에 배팅할 금액을 입력해주세요 (원치 않을 시 0 입력)", 0, seedMoney);
            seedMoney -= tieBet;

            int gameResult = Game.playGame();
            switch (gameResult) {
                case 1:
                    System.out.println("플레이어 승!");
                    break;
                case 2:
                    System.out.println("뱅커 승!");
                    break;
                case 3:
                    System.out.println("타이!");
                    break;
            }

            System.out.println("-----------정산타임-----------");
            if (gameResult == 3) {
                System.out.println("타이이기 때문에 플레이어와 뱅커에게 건 코인은 돌려드릴게요~");
                seedMoney += betMoney;
                if (tieBet > 0) {
                    System.out.println("타이에 배팅하신 금액은 9배로 돌려드립니다!");
                    seedMoney += tieBet * 9;
                }
            }
            else {
                if (betting == gameResult) {
                    System.out.println("게임에 승리해 " + betMoney + "코인을 획득하셨습니다. 굿");
                    seedMoney += betMoney * 2;
                } else {
                    System.out.println("게임에 패배해 배팅하신 코인은 몰수됩니다~~");
                }
            }

            showSeed();
            if (seedMoney == 0) {
                System.out.println("아이고 파산하셨군요~ 저런... 더이상 게임을 진행할 수 없습니다");
                break;
            }
            int moreGame = getUserInput("더 하실건가요? - 1: 네, 2: 아니오", 1, 2);
            if (moreGame == 2) break;
        }

        System.out.println("안녕히 가세요~");
    }

    private static int getUserInput(String msg, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        while (true) {
            System.out.println(msg);
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput >= min && userInput <= max)
                    break;
            }
            System.out.println("올바른 숫자를 입력하세요!!!");
            scanner.nextLine();
        }

        return userInput;
    }

    static void showSeed() {
        System.out.println("현재 시드: " + seedMoney + "코인");
    }
}
