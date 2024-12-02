public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        int dLine = Math.abs(line - toLine);
        int dColumn = Math.abs(column - toColumn);

        if (dLine == dColumn) { // Move along diagonal
            int stepLine = (toLine - line) / dLine; // Step direction
            int stepColumn = (toColumn - column) / dColumn;

            for (int i = 1; i < dLine; i++) {
                if (chessBoard.board[line + i * stepLine][column + i * stepColumn] != null) {
                    return false;
                }
            }

            ChessPiece target = chessBoard.board[toLine][toColumn];
            return target == null || !target.getColor().equals(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
