public class Pawn extends ChessPiece {

    public Pawn(String color) {
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

        int direction = this.color.equals("White") ? 1 : -1; // White moves up, Black moves down
        int startRow = this.color.equals("White") ? 1 : 6; // Starting rows

        ChessPiece target = chessBoard.board[toLine][toColumn];

        if (column == toColumn) {
            if (line + direction == toLine && target == null) {
                return true;
            }
            if (line == startRow && line + 2 * direction == toLine && target == null &&
                    chessBoard.board[line + direction][toColumn] == null) {
                return true;
            }
        }

        return Math.abs(column - toColumn) == 1 && line + direction == toLine && target != null &&
                !target.getColor().equals(this.color);
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
