boolean down = false;
boolean left = false;
boolean right = false;
boolean up = false;
// Down
if (isPossible(board, row + 1, col, word.charAt(i), path)) {
    sb.append(board[row][col]);
    path[row][col] = true;
    down = exist(board, word, i + 1, row + 1, col, sb, path);
    path[row][col] = false;
    sb.deleteCharAt(sb.length() - 1);
}
// Left
if (isPossible(board, row, col - 1, word.charAt(i), path)) {
    sb.append(board[row][col]);
    path[row][col] = true;
    left = exist(board, word, i + 1, row, col - 1, sb, path);
    path[row][col] = false;
    sb.deleteCharAt(sb.length() - 1);
}
// Right
if (isPossible(board, row, col + 1, word.charAt(i), path)) {
    sb.append(board[row][col]);
    path[row][col] = true;
    right = exist(board, word, i + 1, row, col + 1, sb, path);
    path[row][col] = false;
    sb.deleteCharAt(sb.length() - 1);
}
// Up
if (isPossible(board, row - 1, col, word.charAt(i), path)) {
    sb.append(board[row][col]);
    path[row][col] = true;
    right = exist(board, word, i + 1, row - 1, col, sb, path);
    path[row][col] = false;
    sb.deleteCharAt(sb.length() - 1);
}
if (down || left || up || right)
    return true;