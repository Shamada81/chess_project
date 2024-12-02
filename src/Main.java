import java.util.Scanner;

public class Main {
    public static ChessBoard buildBoard() {
        ChessBoard board = new ChessBoard("White");

        board.board[0][0] = new Rook("White");
        board.board[0][1] = new Horse("White");
        board.board[0][2] = new Bishop("White");
        board.board[0][3] = new Queen("White");
        board.board[0][4] = new King("White");
        board.board[0][5] = new Bishop("White");
        board.board[0][6] = new Horse("White");
        board.board[0][7] = new Rook("White");
        board.board[1][0] = new Pawn("White");
        board.board[1][1] = new Pawn("White");
        board.board[1][2] = new Pawn("White");
        board.board[1][3] = new Pawn("White");
        board.board[1][4] = new Pawn("White");
        board.board[1][5] = new Pawn("White");
        board.board[1][6] = new Pawn("White");
        board.board[1][7] = new Pawn("White");

        board.board[7][0] = new Rook("Black");
        board.board[7][1] = new Horse("Black");
        board.board[7][2] = new Bishop("Black");
        board.board[7][3] = new Queen("Black");
        board.board[7][4] = new King("Black");
        board.board[7][5] = new Bishop("Black");
        board.board[7][6] = new Horse("Black");
        board.board[7][7] = new Rook("Black");
        board.board[6][0] = new Pawn("Black");
        board.board[6][1] = new Pawn("Black");
        board.board[6][2] = new Pawn("Black");
        board.board[6][3] = new Pawn("Black");
        board.board[6][4] = new Pawn("Black");
        board.board[6][5] = new Pawn("Black");
        board.board[6][6] = new Pawn("Black");
        board.board[6][7] = new Pawn("Black");
        return board;
    }

    public static void main(String[] args) {
        ChessBoard board = buildBoard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в шахматы!");
        System.out.println("""
               Чтобы проверить игру надо вводить команды:
               'exit' - для выхода
               'replay' - для перезапуска игры
               'castling0' или 'castling7' - для рокировки по соответствующей линии
               'move 1 1 2 3' - для передвижения фигуры с позиции 1 1 на 2 3(поле это двумерный массив от 0 до 7)
               Проверьте могут ли фигуры ходить друг сквозь друга, корректно ли съедают друг друга, можно ли поставить шах и сделать рокировку?""");
        System.out.println();
        label:
        while (true) {
            System.out.println("\nТекущий игрок: " + board.nowPlayer);
            board.printBoard();
            System.out.println();

            System.out.println("Введите команду:");
            System.out.println("1. move [startRow] [startCol] [endRow] [endCol] - для перемещения фигуры");
            System.out.println("2. castling0 - для рокировки через ферзевый фланг");
            System.out.println("3. castling7 - для рокировки через королевский фланг");
            System.out.println("4. exit - для выхода из игры");
            System.out.print("> ");

            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "move":
                    if (parts.length != 5) {
                        System.out.println("Неверный формат команды. Попробуйте еще раз.");
                        continue;
                    }
                    try {
                        int startRow = Integer.parseInt(parts[1]);
                        int startCol = Integer.parseInt(parts[2]);
                        int endRow = Integer.parseInt(parts[3]);
                        int endCol = Integer.parseInt(parts[4]);

                        if (board.moveToPosition(startRow, startCol, endRow, endCol)) {
                            System.out.println("Ход выполнен успешно!");
                        } else {
                            System.out.println("Неверный ход. Попробуйте еще раз.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Введите числовые значения для координат. Попробуйте еще раз.");
                    }
                    break;
                case "castling0":
                    if (board.castling0()) {
                        System.out.println("Рокировка через ферзевый фланг выполнена!");
                    } else {
                        System.out.println("Рокировка через ферзевый фланг невозможна.");
                    }
                    break;
                case "castling7":
                    if (board.castling7()) {
                        System.out.println("Рокировка через королевский фланг выполнена!");
                    } else {
                        System.out.println("Рокировка через королевский фланг невозможна.");
                    }
                    break;
                case "exit":
                    System.out.println("Игра завершена. Спасибо за игру!");
                    break label;
                default:
                    System.out.println("Неизвестная команда. Попробуйте еще раз.");
                    break;
            }
        }

        scanner.close();
    }
}
