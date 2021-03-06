package author.hyun.sik.lim.sw.expert.academy.Q1228;

import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    static LinkedList<Integer> crypto;
    // 리스트 생성
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            // 초기화
            crypto = new LinkedList<>();
            
            // 알고리즘 시작
            int N = sc.nextInt();
            
            // 입력
            for (int index = 0; index < N; index++) {
                crypto.add(sc.nextInt());
            }
            
            // 명령어 개수 입력
            int length = sc.nextInt();
            
            // 명령어 시작
            for (int i = 0; i < length; i++) {
                char command = sc.next().charAt(0);
                
                switch (command) {
                case 'I': 
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    
                    int index = 0;
                    while (index < end) {
                        crypto.add(start + index, sc.nextInt());
                        index++;
                    }
                    break;
                }
            }
            
            System.out.print("#" + test_case + " ");
            
            for (int i = 0; i < 10; i++) {
                System.out.print(crypto.get(i) + " ");
            }
            
            System.out.println();
            
        }
        sc.close();
    }
    
}