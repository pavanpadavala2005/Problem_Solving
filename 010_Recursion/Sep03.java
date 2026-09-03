import java.util.ArrayList;

public class Sep03 {

    // ! ============== GFG. Rat in a Maze =============
    // *https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        ratInMaze(maze, 0, 0, new StringBuilder(), res);
        return res;
    }

    public static void ratInMaze(int[][] maze, int row, int col, StringBuilder sb, ArrayList<String> res) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            res.add(sb.toString());
            return;
        }
        // ! Right
        if (canMove(maze, row, col + 1) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('R');
            ratInMaze(maze, row, col + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
        // ! Down
        if (canMove(maze, row + 1, col) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('D');
            ratInMaze(maze, row + 1, col, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
        // ! Left
        if (canMove(maze, row, col - 1) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('L');
            ratInMaze(maze, row, col - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
        // ! Top
        if (canMove(maze, row - 1, col) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('U');
            ratInMaze(maze, row - 1, col, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
    }

    public static boolean canMove(int[][] maze, int row, int col) {
        if (row < 0 || col < 0 || row > maze.length - 1 || col > maze[0].length - 1)
            return false;
        if (maze[row][col] == 0)
            return false;
        return true;
    }
}
// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. GFG. Rat in a Maze ✅