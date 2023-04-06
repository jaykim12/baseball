package week02;

import java.util.Random;
import java.util.Scanner;

public class baseball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numArr[] = new int[3];
        int inputArr[] = new int[3];
        int strike = 0;
        int ball = 0;
        int count = 1;

        // 과정1 : 난수
        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = (int)(Math.random() * 10); // 랜덤숫자를 배열에 넣기
            for(int j = 0; j < i; j++) {
                if(numArr[j] == numArr[i]) {//중복제거
                    i--;
                    break;
                }
            }
        }


        // 과정2 : 입력
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        while(true) {
            System.out.print(count + "번째 시도 : ");
            String str = sc.next();//입력받은 문자열

            for(int i  = 0; i < inputArr.length; i++) {
                inputArr[i] = str.charAt(i)-'0';
                //charAt()은 string타입의 문자열을 문자형태(char)로 바꿔줌
            }//charAt(int index)로 추출한 숫자형 문자는 char형이므로 int형으로 변환 시 아스키코드로 변환된다.
            //따라서 '0'(48)을 빼주어야 의도한 리턴값을 얻을 수 있다.


            // 과정3 : 스/볼
            for(int i = 0; i < numArr.length; i++) {
                for(int j = 0; j < inputArr.length; j++) {
                    if(numArr[i] == inputArr[j] && i == j) {
                        strike++;
                    }else if(numArr[i] == inputArr[j] && i != j) {
                        ball++;
                    }
                }
            }

            if (strike == 3) {
                System.out.println(count + "번만에 맞히셨습니다");
                System.out.println("게임을 종료합니다");
                break;


            }
            else{
                count++;
                System.out.println(ball + "B" + strike + "S");
                ball = 0;
                strike = 0;

            }
        }
    }
}
