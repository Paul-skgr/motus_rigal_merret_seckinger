class Matrice {
    private int n;
    private int m;
    private char[][] data;

    public Matrice(int lignes, int colonnes) {
        this.n = lignes;
        this.m = colonnes;
        this.data = new char[n][m];
    }

    public void setElement(int ligne, int colonne, char lettre) {
        if (ligne >= 0 && ligne < n && colonne >= 0 && colonne < m) {
            data[ligne][colonne] = lettre;
        } else {
            System.out.println("Indice de ligne ou de colonne non valide");
        }
    }

    public void afficher() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrice matrice = new Matrice(3, 3); // Crée une matrice 3x3
        matrice.setElement(0, 0, 'A');
        matrice.setElement(1, 1, 'B');
        matrice.setElement(2, 2, 'C');
        matrice.afficher();
    }
}

