public class AbstractChessPiece {
    protected String color;
    protected boolean check = true;

    public AbstractChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }

    public String getSymbol() {
        return null;
    }
}
