import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Hangman extends JFrame {
    private final String[] words = {"java", "swing", "hangman", "programming", "developer"};
    private String selectedWord;
    private Set<Character> correctGuesses = new HashSet<>();
    private Set<Character> wrongCharacters = new HashSet<>();

    private JLabel wordLabel;
    private JLabel wrongLabel;
    private JLabel messageLabel;
    private JTextField inputField;
    private JButton guessButton;

    public Hangman() {
        setTitle("Hangman Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        selectedWord = getRandomWord();

        wordLabel = new JLabel(getDisplayWord(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(wordLabel, BorderLayout.NORTH);

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        add(inputField, BorderLayout.CENTER);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(e -> handleGuess());
        add(guessButton, BorderLayout.SOUTH);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        wrongLabel = new JLabel("Wrong guesses: ", SwingConstants.CENTER);
        messageLabel = new JLabel("", SwingConstants.CENTER);
        infoPanel.add(wrongLabel);
        infoPanel.add(messageLabel);
        add(infoPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private String getRandomWord() {
        return words[new Random().nextInt(words.length)];
    }

    private String getDisplayWord() {
        StringBuilder display = new StringBuilder();
        for (char c : selectedWord.toCharArray()) {
            if (correctGuesses.contains(c)) {
                display.append(c).append(" ");
            } else {
                display.append("_ ");
            }
        }
        return display.toString();
    }

    private void handleGuess() {
        String guess = inputField.getText().toLowerCase();
        inputField.setText("");

        if (guess.length() == 1 && Character.isLetter(guess.charAt(0))) {
            char letter = guess.charAt(0);

            if (correctGuesses.contains(letter) || wrongCharacters.contains(letter)) {
                messageLabel.setText("You already guessed that letter.");
                return;
            }

            if (selectedWord.contains(String.valueOf(letter))) {
                correctGuesses.add(letter);
                wordLabel.setText(getDisplayWord());
                messageLabel.setText("");

                if (getDisplayWord().replace(" ", "").equals(selectedWord)) {
                    messageLabel.setText("🎉 You won!");
                    inputField.setEnabled(false);
                    guessButton.setEnabled(false);
                }
            } else {
                wrongCharacters.add(letter);
                wrongLabel.setText("Wrong guesses: " + wrongCharacters);
                messageLabel.setText("❌ Wrong guess! Try again.");
            }
        } else {
            messageLabel.setText("Please enter one letter.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Hangman::new);
    }
}
