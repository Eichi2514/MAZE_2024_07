package org.example;

import java.util.Scanner;

public class App {
    static String[][] maze;
    static String cmd;
    static int x = 1;
    static int y = 1;
    static int score = 0;
    static int perfectScore = 101;
    static String Player;
    static boolean game = true;
    static boolean chack = true;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        maze = Maze.background();

        System.out.println("== 게임 시작 ==");
        System.out.println(" ◇ : 시작 지점 │ ◆ : 골인 지점");
        System.out.println(" w : 상 │ s : 하 │ a : 좌 │ d : 우");
        System.out.println("");
        System.out.println("1) ♠ │ 2) ♥ │ 3) ♣ │ 4) ◆ ");
        System.out.print("캐릭터 번호를 선택해주세요 : ");
        cmd = sc.nextLine();
        while (true) {
            if (cmd.equals("1")) {
                Player = "♠";
                break;
            } else if (cmd.equals("2")) {
                Player = "♥";
                break;
            } else if (cmd.equals("3")) {
                Player = "♣";
                break;
            } else if (cmd.equals("4")) {
                Player = "◆";
                break;
            } else if (cmd.equals("5")) {
                Player = "★";
                break;
            } else {
                System.out.println("없는 캐릭터 입니다.");
                System.out.print("캐릭터 번호를 선택해주세요 : ");
                cmd = sc.nextLine();
            }
        }
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
            System.out.print("COMMAND : ");
            cmd = sc.nextLine();
            while (true) {
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
                        System.out.print("COMMAND : ");
                        cmd = sc.nextLine();
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
                        System.out.print("COMMAND : ");
                        cmd = sc.nextLine();
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
                        System.out.print("COMMAND : ");
                        cmd = sc.nextLine();
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
                        System.out.print("COMMAND : ");
                        cmd = sc.nextLine();
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
