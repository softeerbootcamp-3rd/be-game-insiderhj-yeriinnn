### 구현하고자 하는 바카라 룰

- 기본 설명

딜러는 Player측과 Banker측에 각각 2장의 카드를 내려놓습니다.

딜러는 Player, Banker순으로 카드를 오픈하고 바카라 룰에 의해 추가로 한 장의 카드를 더 받을 수 있습니다.

Player측 또는 Banker측 카드의 합이 9에 가까운 쪽이 이기게 됩니다.

- 카드 규칙

Ace는 1로 계산.

King, Queen, Jack, 10은 각각 0으로 계산.

그 외의 카드 2에서 9까지는 표면에 표시된 숫자로 계산.

합이 10이상일 경우는 일의 자리만 계산

- 게임 진행 흐름

1) 우선 플레이어와 뱅커 모두 2장의 카드를 받는다.

2) ‘내추럴’조건에 따라 추가 카드 뽑기 여부에 대해 결정된다.

- 내추럴인 경우
두 장의 합 = 8 또는 9 이면 내추럴 ⇒ 양쪽 모두 추가 카드를 받을 수 없음. 즉, 해당 상태에서 라운드 종료
**플레이어와 뱅커 둘 중 하나라도 내추럴에 해당이 되면 해당 라운드 종료**
- 내추럴이 아닌 경우

1) 플레이어의 차례

양쪽 모두 내추럴이 아닐 경우, 플레이어가 받은 2장의 수의 합을 봐서 다음과 같은 조건에 따라 추가 카드를 받거나 안 받거나 한다.

| 플레이어 수의 합 | 결정권 |
| --- | --- |
| 6 또는 7 | 스탠드(Stand) : 카드를 받지 않음 |
| 0~5 | 카드를 추가로 1장 받는다. |

2) 뱅커의 차례

- 플레이어가 스탠드일 경우는 플레이어와 같은 룰로 카드를 받거나 받지 않는다. 
즉, 뱅커가 6 또는 7이면 카드를 받지 않고, 0 ~ 5 이면 추가로 한장을 받는다.
- 만약 플레이어가 추가로 카드를 받아서 3장이 되었다면, 아래와 같은 조건에 따른다. 
표는 뱅커의 카드가 3~6일 때 스탠드 조건이다

<img width="936" alt="스크린샷 2023-12-29 오후 2 15 30" src="https://github.com/softeerbootcamp-3nd/be-game-insiderhj-yeriinnn/assets/102938120/ac7829a4-3a79-4685-89dc-cfac9d529458">

- 해당 내용을 바탕으로 행렬 구성
행은 7행부터 시작하는 것이 아니라 0행부터 오름차순으로 진행하는 것으로 변경
드로우 : 1 / 스탠드 : 0

배팅 내용 포함한 전체 flow

---

1. 플레이어 기본 소지금액 : 100원
    1. 기본배팅 1원으로 시작한다
    2. 플레이어 or 뱅커중에 승리할거같은 사람 선택한다
    3. 기본배팅 말고 추가배팅 하고싶으면 더 추가금액 입력한다
    4. 타이에 배팅할 금액은 별도로 입력한다
    5. 게임 진행시 플레이어 or 뱅커가 승리하는 경우
        1. 맞췄다면 그 금액만큼 획득
        2. 틀렸다면 배팅 했던 금액 몰수
        3. 타이에 걸었던 건 그냥 몰수
    6. 게임 진행시 타이가 발생하는 경우
        1. 배팅했던 금액은 그대로 돌려줌
        2. 타이에 걸었던 금액은 *9 해서 돌려줌
