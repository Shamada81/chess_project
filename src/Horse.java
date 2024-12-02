public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column) ||
                !chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) return false;

        int dLine = Math.abs(toLine - line);
        int dColumn = Math.abs(toColumn - column);

        return (dLine == 2 && dColumn == 1) || (dLine == 1 && dColumn == 2);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
