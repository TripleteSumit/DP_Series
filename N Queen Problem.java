class Solution{
  public static void main(String[] args)
  {
    int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
  }
  //solution of N Queen Problem
  public static List<List<String>> queenProblem(int n)
  {
    char board[][] = new char[n][n];
    List<List<String>> = new ArrayList<>();
    for(char [] c:board)
    {
      Arrays.fill(c, '.');
    }
    dfs(board, 0, res);
    return res;
  }
  //This is function of assiging the proper place of a Queen;
  public void dfs(char [][] board, int col, List<List<String>> res)
  {
    if(col == board.length)
    {
      res.add(construct(board));
      return;
    }
    for(int row = 0; row = board.length; row++)
    {
      if(validate(board, row, col))
      {
        board[row][col] = 'Q';
        dfs(board, col+1, res);
        board[row][col] = '.';
      }
    }
    return;
  }
  //This function is tell that whether the particular place is valid or not
  public boolean validate(char board[][], int row, int col)
  {
    int dupRow = row;
    int dupCol = col;
    while(row >= 0 && col >= 0)
    {
      if(board[row][col] == 'Q')return false;
      row--;
      col--;
    }
    row = dupRow;
    col = dupCol;
    while(col >= 0)
    {
      if(board[row][col] == 'Q')return false;
      col--;
    }
    col = dupCol;
    while(row < board.length && col >= 0)
    {
      if(board[row][col] == 'Q')return false;
      row++;
      col--;
    }
  }
  //This is final function for converting form 2d array to list of array;
  public List<String> construct(char board[][])
  {
    List<String> res = new ArrayList<>();
    for(int i = 0; i < board.length; i++)
    {
      String str = new String(board[i]);
      res.add(str);
    }
    return res;
  }
}
