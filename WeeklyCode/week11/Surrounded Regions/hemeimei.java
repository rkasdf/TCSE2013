public class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    boolean[][] visit;
    int row,col;
    char[][] board;
    private class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        row = board.length;
        if(row == 0) return;
        col = board[0].length;
        if(col == 0) return;
        visit = new boolean[row][col];
        this.board = board;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == 'O' && !visit[i][j]){
                    bfs(i,j);
                }        
            }
        }
    }
    private void bfs(int x,int y){
        List<Node> linkNodes = new ArrayList<>();
        linkNodes.add(new Node(x,y));
        boolean isOuter = false;
        for(int i=0;i<linkNodes.size();i++){
            Node node = linkNodes.get(i);
            for(int j=0;j<4;j++){
                int u = node.x+dx[j];
                int v = node.y+dy[j];
                if(u<0 || u>=row || v<0 || v>=col){
                    isOuter = true;
                    continue;
                }
                if(board[u][v] == 'X' || visit[u][v]){
                    continue;
                }
                linkNodes.add(new Node(u,v));
                visit[u][v] = true;
            }
        }
        if(!isOuter){
            for(Node node:linkNodes){
                board[node.x][node.y] = 'X';
            }
        }
    }
}