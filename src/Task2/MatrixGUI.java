import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatrixGUI {
    private JFrame frame;
    private JTextField rowsField, colsField;
    private JPanel matrixPanel, outputPanel;
    private JTextField[][] matrixA;
    private JLabel[][] matrixB;
    private int rows, cols;

    public MatrixGUI() {
        // Créer la fenêtre principale
        frame = new JFrame("Matrice A et B");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel pour entrer les dimensions
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Champs de texte pour les dimensions N et M
        rowsField = new JTextField(5);
        colsField = new JTextField(5);
        inputPanel.add(new JLabel("N (Lignes):"));
        inputPanel.add(rowsField);
        inputPanel.add(new JLabel("M (Colonnes):"));
        inputPanel.add(colsField);

        // Bouton pour générer les champs de la matrice A
        JButton generateButton = new JButton("Générer Matrice A");
        inputPanel.add(generateButton);

        // Panel pour afficher la matrice A
        matrixPanel = new JPanel();

        // Panel pour afficher la matrice B
        outputPanel = new JPanel();

        // Action lorsque le bouton est cliqué
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateMatrixFields();
            }
        });

        // Ajouter les composants au cadre
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(matrixPanel, BorderLayout.CENTER);
        frame.add(outputPanel, BorderLayout.SOUTH);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    // Méthode pour générer les champs de la matrice A
    private void generateMatrixFields() {
        try {
            rows = Integer.parseInt(rowsField.getText());
            cols = Integer.parseInt(colsField.getText());

            matrixPanel.removeAll(); // Effacer les anciens champs
            matrixPanel.setLayout(new GridLayout(rows, cols));

            matrixA = new JTextField[rows][cols];

            // Créer les champs de texte pour la matrice A
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixA[i][j] = new JTextField(5);
                    matrixPanel.add(matrixA[i][j]);
                }
            }

            // Rafraîchir l'affichage de la matrice A
            frame.revalidate();
            frame.repaint();

            // Ajouter un bouton pour afficher la matrice B
            JButton showMatrixBButton = new JButton("Afficher Matrice B");
            matrixPanel.add(showMatrixBButton);

            // Action pour afficher la matrice B
            showMatrixBButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayMatrixB();
                }
            });
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer des dimensions valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode pour afficher la matrice B
    private void displayMatrixB() {
        outputPanel.removeAll();
        outputPanel.setLayout(new GridLayout(rows, cols));

        matrixB = new JLabel[rows][cols];

        // Copier les éléments de la matrice A dans B et les afficher
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String value = matrixA[i][j].getText();
                matrixB[i][j] = new JLabel(value);
                outputPanel.add(matrixB[i][j]);
            }
        }

        // Rafraîchir l'affichage de la matrice B
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        new MatrixGUI();
    }
}
