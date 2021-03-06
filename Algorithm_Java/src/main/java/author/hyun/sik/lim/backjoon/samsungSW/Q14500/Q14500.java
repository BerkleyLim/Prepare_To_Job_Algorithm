package author.hyun.sik.lim.backjoon.samsungSW.Q14500;

import java.util.Scanner;

// https://www.acmicpc.net/problem/14500
// 테트로미노
// 이문제는 그냥 푼다 (DFS는 아님)

public class Q14500 {
    // 세로 : N, 가로 : M, 종이 : map 
    static int N;
    static int M;
    static int map[][];
    // block을 지정한다
    final static char[][][] block = {
            {
                {'1','1','1','1'},
                {'0','0','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'}
            },
            {
                {'1','0','0','0'},
                {'1','0','0','0'},
                {'1','0','0','0'},
                {'1','0','0','0'}
            },
            {
                {'1','1','0','0'},
                {'1','1','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'}
            },
            {
                {'1','0','0','0'},
                {'1','0','0','0'},
                {'1','1','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','1','1','0'},
                {'1','0','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','1','0','0'},
                {'0','1','0','0'},
                {'0','1','0','0'},
                {'0','0','0','0'},
            },
            {
                {'0','0','1','0'},
                {'1','1','1','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'0','1','0','0'},
                {'0','1','0','0'},
                {'1','1','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','0','0','0'},
                {'1','1','1','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','1','0','0'},
                {'1','0','0','0'},
                {'1','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','1','1','0'},
                {'0','0','1','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','0','0','0'},
                {'1','1','0','0'},
                {'0','1','0','0'},
                {'0','0','0','0'},
            },
            {
                {'0','1','1','0'},
                {'1','1','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'0','1','0','0'},
                {'1','1','0','0'},
                {'1','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','1','0','0'},
                {'0','1','1','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','1','1','0'},
                {'0','1','0','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'0','1','0','0'},
                {'1','1','0','0'},
                {'0','1','0','0'},
                {'0','0','0','0'},
            },
            {
                {'0','1','0','0'},
                {'1','1','1','0'},
                {'0','0','0','0'},
                {'0','0','0','0'},
            },
            {
                {'1','0','0','0'},
                {'1','1','0','0'},
                {'1','0','0','0'},
                {'0','0','0','0'},
            }
        };
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        // 여기서는 맵 크기를 +3으로 지정 (블록 형태로 할 때 5 * 5일 때 8*8로 지정)
        // 이유? 블록 크기를 가장 왼쪽, 윗쪽 기준으로 잡은 형태로 구성
        //     블록 검사하기 위해 한다
        map = new int[N + 3][M + 3];
        
        // 정수 입력!
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                map[y][x] = sc.nextInt();
            }
        }
        
        // 기준을 종이 크기 바깥으로 값 넣기 
        for (int y = N; y < N + 3; y++) {
            for (int x = 0; x < M; x++) {
                map[y][x] = -99999;
            }
        }
        
        // 기준을 종이 크기 바깥으로 값 넣기 
        for (int y = 0; y < N; y++) {
            for (int x = M; x < M + 3; x++) {
                map[y][x] = -99999;
            }
        }
        
        // 여기는 최댓값 구하기!
        int max = 0;
        // 테트리미노 검사!
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                // 블록!
                for (int k = 0; k < 19; k++) {
                    int candi = getCount(y, x, k);
                    if (max < candi) {
                        max = candi;
                    }
                }
            }
        }
        
        System.out.println(max);
    }
    
    // 최대 블록 갯수 검사
    public static int getCount(int sy, int sx, int k) {
        int max = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                max += (block[k][y][x] - '0') * map[sy + y][sx + x];
            }
        }
        return max;
    }
}

// 출처 : https://na982.tistory.com/87
