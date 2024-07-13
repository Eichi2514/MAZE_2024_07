package org.example;

import java.util.Scanner;

public class App {
    static String[][] maze;
    static String cmd;
    static int x = 1;
    static int y = 1;
    static int score = 0;
    static int perfectScore = 102;
    static String Player;
    static boolean game = true;
    static boolean chack = true;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        // 기본 배경(미로) 생성
        maze = Maze.background();

        // 게임 시작 문구 및 간단한 설명 출력
        Service.first();

        // 플레이어 선택
        Player = Service.playerChoice();
        maze[x][y] = Player;

        while (game) {
            if (chack) {
                for (int x = 0; x < 11; x++) {
                    for (int y = 0; y < 11; y++) {
                        System.out.print(maze[x][y] + " ");
                    }
                    System.out.println("");
                }
                chack = true;
            }
            while (true) {
                System.out.print("COMMAND : ");
                cmd = sc.nextLine();
                if (cmd.equals("w")) {
                    maze[x][y] = "□";
                    if (maze[x - 1][y].equals("□")) {
                        maze[x - 1][y] = Player;
                        x--;
                        score++;
                        break;
                    } else if (maze[x - 1][y].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        cmd = "exit";
                    } else if (maze[x - 1][y].equals("-")) {
                        maze[9][9] = Player;
                        x = 9;
                        y = 9;
                        score++;
                        break;
                    } else {
                        System.out.println("길이 막혀있습니다");
                        score++;
                        continue;
                    }
                } else if (cmd.equals("a")) {
                    maze[x][y] = "□";
                    if (maze[x][y - 1].equals("□")) {
                        maze[x][y - 1] = Player;
                        y--;
                        score++;
                        break;
                    } else if (maze[x][y - 1].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        cmd = "exit";
                    } else {
                        System.out.println("길이 막혀있습니다");
                        score++;
                        continue;
                    }
                } else if (cmd.equals("s")) {
                    maze[x][y] = "□";
                    if (maze[x + 1][y].equals("□")) {
                        maze[x + 1][y] = Player;
                        x++;
                        score++;
                        break;
                    } else if (maze[x + 1][y].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        cmd = "exit";
                    } else {
                        System.out.println("길이 막혀있습니다");
                        score++;
                        continue;
                    }
                } else if (cmd.equals("d")) {
                    maze[x][y] = "□";
                    if (maze[x][y + 1].equals("□")) {
                        maze[x][y + 1] = Player;
                        y++;
                        score++;
                        break;
                    } else if (maze[x][y + 1].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        cmd = "exit";
                    } else {
                        System.out.println("길이 막혀있습니다");
                        score++;
                        continue;
                    }
                } else if (cmd.equals("exit")) {
                    System.out.println("== 게임 종료 ==");
                    game = false;
                    break;
                } else {
                    System.out.println("잘못된 COMMAND 입니다.");
                    chack = false;
                }
            }
        }

    }
}
