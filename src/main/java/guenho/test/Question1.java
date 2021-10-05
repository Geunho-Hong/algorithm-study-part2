package guenho.test;


public class Question1 {

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int cnt = 0,N,M;
    private static int[] alpha;
    private static char[][] nationMap;
    private static boolean[][] visited;
    private static boolean[][] alphaVisit;

    public static void main(String[] args) {
        String[] maps = {"AABCA.QA","AABC..QX","BBBC.Y..",".A...T.A","....EE..",".M.XXEXQ","KL.TBBBQ"};
        System.out.println(solution(maps));
    }

    private static int solution(String[] maps) {

        int answer = 0;
        N = maps.length;
        M = maps[0].length();

        nationMap = new char[N][M];
        visited = new boolean[N][M];
        alphaVisit = new boolean[N][M];
        alpha = new int[26];

        for (int i = 0; i < N; i++) {
            String[] line = maps[i].split("");
            for (int j = 0; j < line.length; j++) {
                nationMap[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && nationMap[i][j] != '.') {
                    dfs(i,j);
                    diff();
                    alpha = new int[26];    // dfs 이후 alpha 초기화
                    cnt = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(nationMap[i][j] != '.') {
                    alpha[nationMap[i][j] - 'A'] ++;
                }
            }
        }

        int maxNumber = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] >= maxNumber) {
                maxNumber = alpha[i];

            }
        }
        return maxNumber ;
    }

    private static int dfs(int x , int y) {

        // visited 현재 정점 유무에 대한 방문 처리 기준

        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;
            if(nX >= 0 && nY >=0 && nX < N && nY < M) {
                if(!visited[nX][nY] && nationMap[nX][nY] != '.') {
                    visited[nX][nY] = true;
                    alpha[nationMap[nX][nY] - 'A'] ++;
                    dfs(nX,nY);
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    private static void diff() {
        // 최댓 값과 그 수
        // char maxAlpah = '';

        int maxNumber = 0;
        int winnerCnt = 0;
        char winnerCh = '?';

        for (int i = 0; i < alpha.length; i++) {
            if(alpha[i] >= maxNumber) {
                maxNumber = alpha[i];
                winnerCh = (char)(65+i);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] && !alphaVisit[i][j]){
                    // 해당 alphaCnt
                    alphaVisit[i][j] = true;
                    int alphaCnt = alpha[nationMap[i][j] - 'A'];
                    if(maxNumber > alphaCnt ) {
                        nationMap[i][j] = winnerCh;
                    }
                }
            }
        }
    }

}
