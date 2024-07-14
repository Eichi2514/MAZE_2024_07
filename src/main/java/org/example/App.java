package org.example;

import java.util.Scanner;

public class App {
    static String[][] maze;
    static String cmd;
    static int x = 1;
    static int y = 1;
    static int score = 0;
    static int perfectScore;
    static String player;
    static boolean game = true;
    static boolean chack = true;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        // 게임 시작 문구 및 간단한 설명 출력
        Service.first();

        // 플레이어 선택
        player = Service.playerChoice();

        // 단계별 배경(미로) 생성
        maze = Maze.background();
        if (maze.length == 7) perfectScore = 110;
        else if (maze.length == 11) perfectScore = 123;
        else if (maze.length == 39) perfectScore = 255;
        maze[x][y] = player;

        while (game) {
            if (chack) {
                for (int x = 0; x < maze.length; x++) {
                    for (int y = 0; y < maze.length; y++) {
                        System.out.print(maze[x][y] + " ");
                    }
                    System.out.println("");
                }
            }
            while (true) {
                System.out.print("COMMAND : ");
                cmd = sc.nextLine();
                if (cmd.equals("w")) {
                    chack = true;
                    maze[x][y] = "□";
                    if (maze[x - 1][y].equals("□")) {
                        maze[x - 1][y] = player;
                        x--;
                        score++;
                        break;
                    } else if (maze[x - 1][y].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        game = false;
                        break;
                    } else if (player.equals("★") && maze[x - 1][y].equals("-")) {
                        if (maze.length == 10) {
                            maze[9][9] = player;
                            x = 9;
                            y = 9;
                            score += 22;
                            break;
                        } else if (maze.length == 39){
                            maze[5][1] = player;
                            x = 5;
                            y = 1;
                            score += 147;
                            break;
                        }
                    } else {
                        System.out.println("길이 막혀있습니다");
                        score++;
                        continue;
                    }
                } else if (cmd.equals("a")) {
                    chack = true;
                    maze[x][y] = "□";
                    if (maze[x][y - 1].equals("□")) {
                        maze[x][y - 1] = player;
                        y--;
                        score++;
                        break;
                    } else if (maze[x][y - 1].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        game = false;
                        break;
                    } else {
                        System.out.println("길이 막혀있습니다");
                        score++;
                        continue;
                    }
                } else if (cmd.equals("s")) {
                    chack = true;
                    maze[x][y] = "□";
                    if (maze[x + 1][y].equals("□")) {
                        maze[x + 1][y] = player;
                        x++;
                        score++;
                        break;
                    } else if (maze[x + 1][y].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        game = false;
                        break;
                    } else {
                        System.out.println("길이 막혀있습니다");
                        score++;
                        continue;
                    }
                } else if (cmd.equals("d")) {
                    chack = true;
                    maze[x][y] = "□";
                    if (maze[x][y + 1].equals("□")) {
                        maze[x][y + 1] = player;
                        y++;
                        score++;
                        break;
                    } else if (maze[x][y + 1].equals("◆")) {
                        System.out.println("== Goal ==");
                        System.out.println("Score : " + (perfectScore - score));
                        game = false;
                        break;
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
