package diff;

class Cell {

    private int value;
    private String symbol;

    public Cell(int value, String symbol) {
        super();
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getSymbol() {
        return this.symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}

public class Diff {

    public static void main(String[] args) {

        String a = "";
        String b = "";

        System.out.println( "LCS(" + a + ", " + b +") = " + LCS(a, b) );


    }

    public static String LCS(String a, String b) {
        int aLength = a.length() + 1;
        int bLength = b.length() + 1;

        Cell[][] adjacentes = new Cell[aLength][bLength];

        for (int i = 0; i < aLength; i++) {
            adjacentes[i][0] = new Cell(0, "");
        }

        for (int i = 0; i < bLength; i++) {
            adjacentes[0][i] = new Cell(0, "");
        }
        
        // Monta a matriz
        for (int i = 1; i < aLength; i++) {
            for (int j = 1; j < bLength; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    adjacentes[i][j] = new Cell(adjacentes[i - 1][j - 1].getValue() + 1, "\\");
                } else {
                    if (adjacentes[i - 1][j].getValue() >= adjacentes[i][j - 1].getValue()) // linha de cima, mesma coluna >= mesma linha, coluna anterior
                        adjacentes[i][j] = new Cell(adjacentes[i - 1][j].getValue(), "|"); // copia maior numero
                    else // linha de cima, mesma coluna > mesma linha, coluna anterior
                        adjacentes[i][j] = new Cell(adjacentes[i][j - 1].getValue(), "-"); // copia maior numero
                }
            }
        }

        // Imprime a matriz
        System.out.print("\t");
        for (int i = 0; i < bLength - 1; i++) {
            System.out.print(b.charAt(i) + " \t");
        }
        System.out.print("\n");
        for (int i = 1; i < aLength; i++) {
            System.out.print(a.charAt(i - 1) + "\t");
            for (int j = 1; j < bLength; j++) {
                System.out.print(adjacentes[i][j].getSymbol() + " " + adjacentes[i][j].getValue() + "\t");
            }
            System.out.print("\n");
        }

        // Verifica qual eh a lcs
        StringBuilder lcsReversa = new StringBuilder();
        int i = aLength - 1;
        int j = bLength - 1;

        whileLoop: while(i > 0 && j > 0) {
            switch(adjacentes[i][j].getSymbol()) {
                case "\\":
                    lcsReversa.append(a.charAt(i - 1));
                    i--;
                    j--;
                    break;
                case "|":
                    i--;
                    break;
                case "-":
                    j--;
                    break;
                default:
                    break whileLoop;
            }
        }

        return lcsReversa.reverse().toString();
    }

}