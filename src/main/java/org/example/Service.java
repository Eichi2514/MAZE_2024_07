package org.example;

import java.util.Scanner;

public class Service {
    static Scanner sc = new Scanner(System.in);
    static String cmd;

    public static void first() {
        System.out.println("== 게임 시작 ==");
        System.out.println(" ◇ : 시작 지점 │ ◆ : 골인 지점");
        System.out.println(" w : 상 │ s : 하 │ a : 좌 │ d : 우");
        System.out.println("");
    }

    public static String playerChoice() {
        System.out.println("1) ♠ │ 2) ♥ │ 3) ♣ │ 4) ◆ ");
        while (true) {
            System.out.print("캐릭터 번호를 선택해주세요 : ");
            cmd = sc.nextLine();
            System.out.println("");
            if (cmd.equals("1")) {
                return "♠";
            } else if (cmd.equals("2")) {
                return "♥";
            } else if (cmd.equals("3")) {
                return "♣";
            } else if (cmd.equals("4")) {
                return "◆";
            } else if (cmd.equals("7")) {
                return "★";
            } else if (cmd.equals("make")) {
                Maze.make();
            } else {
                System.out.println("없는 캐릭터 입니다.");
            }
        }
    }
}
