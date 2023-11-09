import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MotusFrame extends JPanel {

    private JLabel countdownLabel;
    private JTextField guessField;
    private JButton submitButton;
    private JButton restartButton;
    private JButton quitButton;
    private JPanel gamePanel;
    private Dictionnary dictionnary;
    //private Scan scanner;

    public MotusFrame(Matrice matrice) {
        // Configuration de la fenêtre principale
        JFrame frame = new JFrame("Motus Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Configuration du panneau principal
        this.setLayout(new BorderLayout());

        // Initialisation des composants graphiques

        countdownLabel = new JLabel("Countdown: 60 seconds");
        guessField = new JTextField(10);
        submitButton = new JButton("Envoyer");
        restartButton = new JButton("Recommencer");
        quitButton = new JButton("Quitter");
        gamePanel = new JPanel();
        dictionnary = new Dictionnary("./Doc.txt",7);
        //scanner = new Scan();


        // Ajout des composants au panneau principal
        this.add(countdownLabel, BorderLayout.NORTH);

        // Création d'un panneau pour les boutons de commande
        JPanel controlPanel = new JPanel();
        controlPanel.add(guessField);
        controlPanel.add(submitButton);
        controlPanel.add(restartButton);
        controlPanel.add(quitButton);
        this.add(controlPanel, BorderLayout.SOUTH);

        // Configuration des gestionnaires d'événements pour les boutons
        submitButton.addActionListener(e -> handleSubmitButtonClick());
        restartButton.addActionListener(e -> handleRestartButtonClick());
        quitButton.addActionListener(e -> handleQuitButtonClick());

        updateUI(matrice);

        // Affichage de la fenêtre principale
        frame.add(this);
        frame.setVisible(true);
    }

    // Méthodes pour gérer les événements des boutons (handleSubmitButtonClick, handleRestartButtonClick, handleQuitButtonClick)

    private void handleSubmitButtonClick() {
        System.out.println("Submit button clicked.");
    }

    private void handleRestartButtonClick() {
        System.out.println("Restart button clicked.");
    }

    private void handleQuitButtonClick() {
        System.out.println("Quit button clicked.");
    }

    public void updateUI(Matrice matrice) {
        Random random = new Random();
        int index= random.nextInt(7)+1;
        String word = dictionnary.getRandomWord();
        System.out.println(" update.");
        if (matrice != null) {
            System.out.println(" matrice.");
            matrice.afficher();
            char[][] grille = matrice.getMatrice();

            // Créez un nouveau panneau pour afficher la grille
            if (grille != null) { // Assurez-vous que grille n'est pas null
                System.out.print(grille[0][0] + " ");
                System.out.println();
                JPanel grillePanel = new JPanel(new GridLayout(grille.length, grille[0].length));
                grille[0][0] = word.charAt(0);
                grille[0][6] = word.charAt(index);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 7; j++) {
                        JLabel caseLabel = new JLabel(String.valueOf(grille[i][j])); // Créez un JLabel vide (case vide)
                        grillePanel.add(caseLabel);
                        caseLabel.setPreferredSize(new Dimension(30, 30));
                        caseLabel.setHorizontalAlignment(JLabel.CENTER); // Centrer le texte dans la cellule
                        caseLabel.setVerticalAlignment(JLabel.CENTER);

                        // Ajouter des marges pour les cellules (par exemple, 5 pixels)
                        caseLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                        // Ajuster la taille de la police
                        caseLabel.setFont(new Font("Arial", Font.PLAIN, 50));
                        // Ajoutez le nouveau panneau de la grille
                        gamePanel = grillePanel;
                        this.add(gamePanel, BorderLayout.CENTER);
                    }
                }


                // Repaint pour mettre à jour l'interface utilisateur
                revalidate();
                repaint();
                //for (int k=0;k<5;k++){
                  //for (int a=0;a<7;a++){
                    //grille[k][a] = scanner.scan().charAt(a);
                  //}
                  for (int i = 0; i < grille.length; i++) {
                      for (int j = 0; j < grille[0].length; j++) {
                          JLabel caseLabel = new JLabel(String.valueOf(grille[i][j])); // Créez un JLabel vide (case vide)
                          grillePanel.add(caseLabel);
                      }
                  }
                  gamePanel = grillePanel;
                  this.add(gamePanel, BorderLayout.CENTER);
                  revalidate();
                  repaint();
                //}
            } else {
                System.out.println("La grille est nulle. Assurez-vous qu'elle est correctement initialisée.");
            }
        } else {
            System.out.println("La classe Matrice n'a pas été initialisée correctement.");
        }
    }

    public static void main(String[] args) {
        Matrice matrice; // Déclarez matrice en tant que variable de classe
        matrice = new Matrice(5, 7); // Initialisez matrice ici
        System.out.println("Instance de Matrice créée dans MotusFrame.");
        SwingUtilities.invokeLater(() -> {
            MotusFrame motusFrame = new MotusFrame(matrice);
        });
    }
}
