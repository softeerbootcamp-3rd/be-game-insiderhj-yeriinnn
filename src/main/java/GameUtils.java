public class GameUtils {

    // 뱅커의 카드 뽑기 관련 기준 행렬을 생성
    public static int[][] createMatrix() {
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 1, 0, 0, 1, 1}
        };

        return matrix;
    }

    // 주어진 플레이어와 뱅커의 값에 해당하는 행렬의 값을 반환하는 함수
    public static int findValue(int[][] matrix, Player player, Player banker) {
        int playerValue = player.getTotalSum(); // 플레이어의 값 추출
        int bankerValue = banker.getTotalSum(); // 뱅커의 값 추출
        return matrix[bankerValue][playerValue];
    }
}
