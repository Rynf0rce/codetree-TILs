# [코드트리 등산 게임 ![Platinum3][p3]](https://www.codetree.ai/training-field/frequent-problems/problems/codetree-mountain-climbing-games)

	
삼성 SW 역량테스트 2024 하반기 오후 2번 문제

코드트리 직원들은 가을을 맞아 단풍을 볼겸 등산을 가려다 이를 대체하기 위한 게임을 하기로 했습니다. 등산 게임은 일차원으로 이루어진 지도 위에서 이루어집니다. 지도에는 산들이 연속으로 나열되어 있으며, 각각의 산은 높이를 가집니다. 또한 아래와 같은 조건들을 가지며 게임이 진행됩니다.

    등산가의 이동 조건

    매 등산 시뮬레이션마다 등산을 통한 산 사이 이동은 현재 위치보다 오른쪽에 위치한 산으로만 이동할 수 있습니다.

    등산을 통한 산과 산 사이 이동에 있어서 항상 현재 산의 높이보다 더 높은 산으로만 이동이 가능합니다.

    케이블 카

    케이블 카는 특정 산에서만 탈 수 있습니다.

    케이블 카를 타면 현재 위치를 포함한 임의의 산으로 이동할 수 있습니다. 이때 산의 높낮이는 상관없습니다.

    케이블 카를 탄 이후에도 등산을 이어가며 이 또한 오른쪽에 위치한 더 높은 산으로만 이동이 가능합니다.

    등산 시뮬레이션

    등산가는 시뮬레이션을 시작할 산을 자유롭게 선택할 수 있습니다.

    등산가가 현재 위치보다 오른쪽에 위치한 산으로 오르막 이동에 성공할때마다 1,000,000점을 얻습니다.

    만약 등산가가 케이블 카를 탈 수 있는 산에 도착한다면 케이블 카를 이용합니다. 이때 케이블 카 이용에 성공하면 1,000,000점을 얻습니다

    3에서 케이블 카 이용에 성공했다면, 이 후 다시 등산을 시작합니다. 이 또한 성공할때마다 1,000,000점을 얻습니다.

    최종적으로 위치한 산의 높이만큼 점수를 얻습니다.

    등산 시뮬레이션 결과 얻을 수 있는 총 점수는 2~5 점수의 총합입니다.

    명령의 종류

    빅뱅
    우공이산
    지진
    등산 시뮬레이션

위와 같은 조건들을 지켜가며 여러 명령어가 주어졌을 때, 게임의 결과를 계산하는 프로그램을 작성하세요.
입력 형식

첫 번째 줄에 명령의 개수 Q가 주어집니다.

두 번째 줄부터 Q개의 줄에 걸쳐 명령의 정보가 주어집니다. 각 명령의 형태는 다음과 같습니다.

    빅뱅

    100 n h_1 h_2 h_3 ... h_n 형태로 공백을 사이에 두고 주어집니다. 이는 일차원 지도가 n개의 산으로 이루어져 있으며, 왼쪽부터 각 산의 높이가 hi​ 임을 의미합니다. 이 명령은 항상 첫 번째 명령으로만 주어지며, 항상 주어집니다.

    우공이산

    200 h 형태로 공백을 사이에 두고 주어집니다. 이 명령에 따라 지도에 존재하는 기존 산들 오른쪽 끝에 높이 h를 갖는 산을 1개 추가합니다.

    지진

    300 형태로 주어집니다. 이 명령에서는 지도에 존재하는 기존 산들 중 가장 오른쪽에 위치한 산을 제거합니다. 지도에 더 이상 산이 존재하지 않게 하는 명령은 주어지지 않음을 가정해도 좋습니다.

    등산 시뮬레이션

    400 m_index 형태로 주어집니다. 이 명령에서는 케이블 카를 이용할 수 있는 산이 왼쪽에서 m_index번째 산이라고 가정했을 때, 등산 시뮬레이션 중 얻을 수 있는 최대 점수를 출력합니다. 지도에 존재하는 산들의 범위를 벗어난 m_index는 주어지지 않음을 가정해도 좋습니다.

    1≤Q≤500,000

    n≤50,000

    1≤hi​<1,000,000

    1≤h<1,000,000

    1≤m_index≤현재지도 위 산의 총 개수

출력 형식

등산 시뮬레이션 명령어에 대해 얻을 수 있는 최대 점수를 한 줄에 하나씩 순서대로 출력합니다.
입출력 예제
예제1

입력:

4
100 4 1 3 2 4
200 3
300
400 2

출력:

4000004

예제2

입력:

4
100 4 1 3 2 4
200 3
300
400 1

출력:

3000004

예제3

입력:

15
100 5 3 2 5 4 3
400 4
400 3
400 5
300
300
200 7
200 8
400 4
200 5
200 3
200 1
200 10
200 8
400 10

출력:

3000005
3000005
3000005
6000008
8000010

제한

시간 제한: 1000ms
메모리 제한: 80MB

|유형|출처|
|---|---|
||[기출문제](https://www.codetree.ai/training-field/frequent-problems)|








[b5]: https://img.shields.io/badge/Bronze_5-%235D3E31.svg
[b4]: https://img.shields.io/badge/Bronze_4-%235D3E31.svg
[b3]: https://img.shields.io/badge/Bronze_3-%235D3E31.svg
[b2]: https://img.shields.io/badge/Bronze_2-%235D3E31.svg
[b1]: https://img.shields.io/badge/Bronze_1-%235D3E31.svg
[s5]: https://img.shields.io/badge/Silver_5-%23394960.svg
[s4]: https://img.shields.io/badge/Silver_4-%23394960.svg
[s3]: https://img.shields.io/badge/Silver_3-%23394960.svg
[s2]: https://img.shields.io/badge/Silver_2-%23394960.svg
[s1]: https://img.shields.io/badge/Silver_1-%23394960.svg
[g5]: https://img.shields.io/badge/Gold_5-%23FFC433.svg
[g4]: https://img.shields.io/badge/Gold_4-%23FFC433.svg
[g3]: https://img.shields.io/badge/Gold_3-%23FFC433.svg
[g2]: https://img.shields.io/badge/Gold_2-%23FFC433.svg
[g1]: https://img.shields.io/badge/Gold_1-%23FFC433.svg
[p5]: https://img.shields.io/badge/Platinum_5-%2376DDD8.svg
[p4]: https://img.shields.io/badge/Platinum_4-%2376DDD8.svg
[p3]: https://img.shields.io/badge/Platinum_3-%2376DDD8.svg
[p2]: https://img.shields.io/badge/Platinum_2-%2376DDD8.svg
[p1]: https://img.shields.io/badge/Platinum_1-%2376DDD8.svg
[passed]: https://img.shields.io/badge/Passed-%23009D27.svg
[failed]: https://img.shields.io/badge/Failed-%23D24D57.svg
[easy]: https://img.shields.io/badge/쉬움-%235cb85c.svg?for-the-badge
[medium]: https://img.shields.io/badge/보통-%23FFC433.svg?for-the-badge
[hard]: https://img.shields.io/badge/어려움-%23D24D57.svg?for-the-badge
