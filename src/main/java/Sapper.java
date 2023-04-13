public class Sapper {
    static final char BOMB = 'X';
    static final char FREE = '-';

    public static void main(String[] args) {
        int[][] coordsBomb = {
                {1, 2},
                {3, 4},
                {4, 3}
        };

        int size = 5;

        printMatrix(coordsBomb, size);
    }

    static void printMatrix(int[][] coordsBombs, int size) {
        int intermediateSize = size + 2;
        int[][] intField = new int[size + 2][size + 2];
        int intBomb = Integer.MIN_VALUE;


        int coordsSize = coordsBombs.length;
        for (int i = 0; i < coordsSize; i++) {
            int coordX = coordsBombs[i][0];
            int coordY = coordsBombs[i][1];
            intField[coordX][coordY] = intBomb;
        }

        for (int i = 0; i < intermediateSize; i++) {
            for (int j = 0; j < intermediateSize; j++) {
                if (intField[i][j] < 0) {
                    intField[i - 1][j - 1] += 1;
                    intField[i - 1][j] += 1;
                    intField[i - 1][j + 1] += 1;
                    intField[i][j - 1] += 1;
                    intField[i][j + 1] += 1;
                    intField[i + 1][j - 1] += 1;
                    intField[i + 1][j] += 1;
                    intField[i + 1][j + 1] += 1;
                }
            }
        }

        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (intField[i + 1][j + 1] < 0) {
                    field[i][j] = BOMB;
                } else if ((intField[i + 1][j + 1] == 0)) {
                    field[i][j] = FREE;
                } else {
                    field[i][j] = Character.forDigit(intField[i + 1][j + 1], 10);
                }
            }
        }

        for (char[] row : field) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
