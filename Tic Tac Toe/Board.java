public class Board{
    private final int SIZE = 3;
    private final Cell[][] cells;

    public Board() {
        cells = new Cell[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean markCell(int row, int col, char symbol){
        if(cells[row][col].getValue() == ' '){
            cells[row][col].setValue(symbol);
            return true;
        }
        return false;
    }

    public boolean isFull(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(cells[i][j].getValue() == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(char symbol){
        for(int i = 0; i < SIZE; i++){
            // check rows
            if(cells[i][0].getValue() == symbol && cells[i][1].getValue() == symbol && cells[i][2].getValue() == symbol){
                return true;
            }

            // check diagonals
            if(cells[0][i].getValue() == symbol && cells[1][i].getValue() == symbol && cells[2][i].getValue() == symbol){
                return true;
            }
        }

        // check diagonals
        if(cells[0][0].getValue() == symbol && cells[1][1].getValue() == symbol && cells[2][2].getValue() == symbol){
            return true;
        }
        // check diagonals
        return cells[0][2].getValue() == symbol && cells[1][1].getValue() == symbol && cells[2][0].getValue() == symbol;
    }

    public void display(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.print(cells[i][j].getValue());
                if(j < SIZE - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < SIZE - 1){
                System.out.println("-----");
            }
        }
    }
}