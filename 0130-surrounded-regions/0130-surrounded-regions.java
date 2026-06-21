class Solution {
    private static int[] x= {1, -1, 0, 0};
    private static int[] y= {0, 0, -1, 1};
    public void solve(char[][] board) {
        int n=board.length;
        int m= board[0].length;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && board[i][j]=='O' ){
                    q.offer(new int[]{i, j});
                    board[i][j]='S';
                }
            }
        }
        bfs(q, board, n, m);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='S'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }

    private void bfs(Queue<int[]> q, char[][] board, int n, int m){
        while(!q.isEmpty()){
            int[] node= q.poll();
            for(int i=0;i<4; i++){
                int nx=node[0]+x[i];
                int ny=node[1]+y[i];
                if(isValid(nx, ny, n, m) && board[nx][ny]=='O'){
                    q.offer(new int[]{nx, ny});
                    board[nx][ny]='S';
                }
            }
        }
    }


    private boolean isValid(int x, int y, int n, int m){
        return !(x<0 || y<0 || x==n || y==m);
    }
}