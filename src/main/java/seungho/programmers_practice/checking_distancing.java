class Solution {
    boolean[][] check;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = distancing(places[i]);
        }

        return answer;
    }

    public int distancing(String[] place) {
        check = new boolean[5][5];
        char[][] seats = divide(place);

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 'P') {
                    if (!tBLR(seats, i, j)) return 0;
                    if (!manhattan2(seats, i, j)) return 0;
                    if (!diagonal(seats, i, j)) return 0;
                }
                check[i][j] = true;
            }
        }
        return 1;

    }

    public boolean diagonal(char[][] seats, int x, int y) { // 대각선 확인
        int[] dx = {1, -1, -1, 1};
        int[] dy = {1, 1, -1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || check[nx][ny])
                continue;

            if (seats[nx][ny] == 'P') {
                if (seats[nx][y] != 'X' || seats[x][ny] != 'X') return false;
            }
        }


        return true;
    }


    public boolean manhattan2(char[][] seats, int x, int y) { //직선거리 확인
        int[] dx = {-2, 0, 2, 0};
        int[] dy = {0, -2, 0, 2};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || check[nx][ny])
                continue;

            if (seats[nx][ny] == 'P') {
                if (seats[x + dx[i] / 2][y + dy[i] / 2] == 'O') return false;
            }
        }
        return true;
    }


    public boolean tBLR(char[][] seats, int x, int y) { // 상하좌우 확인
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || check[nx][ny])
                continue;

            if (seats[nx][ny] == 'P')
                return false;
        }
        return true;
    }

    public char[][] divide(String[] place) {
        char[][] seats = new char[5][5];
        for (int i = 0; i < place.length; i++) {
            String str = place[i];
            for (int j = 0; j < str.length(); j++) {
                seats[i][j] = str.charAt(j);
            }
        }
        return seats;
    }
}