public class GameUtils {

    // 주어진 플레이어와 뱅커의 값에 해당하는 행렬의 값을 반환하는 함수
    public static int findValue(Player player, Player banker) {
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int playerValue = player.getThirdCardValue(); // 플레이어의 값 추출
        int bankerValue = banker.getTotalSum(); // 뱅커의 값 추출
        return matrix[bankerValue][playerValue];
    }
}
