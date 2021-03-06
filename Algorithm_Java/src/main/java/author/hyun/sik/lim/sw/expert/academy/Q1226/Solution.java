package author.hyun.sik.lim.sw.expert.academy.Q1226;

import java.util.Scanner;

// 미로 찾기 문제!
// BFS 문제로 해결!
// map에서 수치 정보
// 0 : 길 / 1 : 벽 / 2 : 출발점 / 3 : 도착점
// 미로 찾기 가능 여부
// 1 : 가능 , 0 : 불가능

public class Solution {
    static class NodeXY {
        int level;
        int x;
        int y;
        NodeXY link;
    }
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    //static int[][] map;
    static final int SIZE = 16;
    static boolean[][] visited;
    static NodeXY start;
    static NodeXY end;
    static NodeXY front;
    static NodeXY rear;
    
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int testNumber = 0;
        while(testNumber < 10) {
            // 초기화
            //map = new int[SIZE][SIZE];
            visited = new boolean[SIZE][SIZE];
            front = null;
            rear = null;
            
            testNumber = sc.nextInt();
            sc.nextLine();
            // 출발점, 도착점 설정
            start = new NodeXY();
            end = new NodeXY();
            
            // setting
            for (int y = 0; y < SIZE; y++) {
                String str = sc.nextLine();
                
                for (int x = 0; x < SIZE; x++) {
                    int[][] map = new int[SIZE][SIZE];
                    map[y][x] = str.charAt(x);
                    //System.out.print(map[y][x] + " ");
                    
                    if (map[y][x] == '2') {
                        start.x = x;
                        start.y = y;
                        // 시작점 지정
                        enQueue(0,x,y);
                    } else if (map[y][x] == '3') {
                        end.x = x;
                        end.y = y;
                    } else if (map[y][x] == '1') {
                        visited[y][x] = true;
                    } else {
                        visited[y][x] = false;
                    }
                }
            }
            
            int answer = bfs(start.x,start.y,end.x,end.y);
            
            System.out.println("#" + testNumber + " " + answer);
        }
        
    }
    
    public static int bfs(int startX, int startY, int endX, int endY) {
        int level = 1;
        int x = startX;
        int y = startY;
        
        // 도착점 찾을때까지 찾기!
        while(!isEmpty()) {
            // 정점 도착시!
            if (x == endX && y == endY)
                return 1;
            
            // 상하좌우 노드 검사 후 노드 생성
            for(int i = 0; i < 4; i++) {
                enQueue(level,x + dx[i], y + dy[i]);
            }
            
            NodeXY node = deQueue();
            
            if(node == null)
                return 0;
            
            x = node.x;
            y = node.y;
            level++;
        }
        
        return 0;
        
    }
    
    public static void enQueue(int level, int x, int y) {
        // 방문 완료나 벽인 경우 실행 금지!
        if (visited[y][x]) return;
        
        // 큐 생성 시 방문 완료
        visited[y][x] = true;
        
        NodeXY node = new NodeXY();
        
        node.level = level;
        node.x = x;
        node.y = y;
        node.link = null;
        
        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.link = node;
            rear = node;
        }
    }
    
    public static NodeXY deQueue() {
        if (isEmpty()) return null;
        else {
            front = front.link;
            return front;
        }
    }
    
    public static boolean isEmpty() {
        return (front == null && rear == null);
    }
    
//    public static NodeXY qPeek() {
//        if (isEmpty()) return null;
//        else {
//            
//            return front;
//        }
//    }
    
}
