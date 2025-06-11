 import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class QuestionManager {
    private List<Question> questions;
    private Scanner scanner;

    public QuestionManager() {
        questions = new ArrayList<>();
        loadQuestionsFromFile();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Interview Question Manager!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a question");
            System.out.println("2. Show all questions");
            System.out.println("3. Filter by topic");
            System.out.println("4. Practice mode (random questions)");
            System.out.println("5.Search by keyword");
            System.out.println("6. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addQuestion();
                    break;
                case "2":
                    showAllQuestions();
                    break;
                case "3":
                    filterByTopic();
                    break;
                case "4":
                    practiceMode();
                    break;
                case "5":
                    searchByKeyword();
                    break;
                    case "6":
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addQuestion() {
        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();

        System.out.print("Enter answer: ");
        String answer = scanner.nextLine();

        System.out.print("Enter topic (e.g., Java, SQL, React): ");
        String topic = scanner.nextLine();

        questions.add(new Question(questionText, answer, topic));
        saveQuestionsToFile();
        System.out.println("Question added successfully!");
    }

    private void showAllQuestions() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        for (Question q : questions) {
            System.out.println(q);
            System.out.println("---------------");
        }
    }

    private void filterByTopic() {
        System.out.print("Enter topic to filter by: ");
        String topic = scanner.nextLine();

        boolean found = false;
        for (Question q : questions) {
            if (q.getTopic().equalsIgnoreCase(topic)) {
                System.out.println(q);
                System.out.println("---------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No questions found for topic: " + topic);
        }
    }

    private void loadQuestionsFromFile() {
        File file = new File("questions.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String questionText = parts[0];
                    String answer = parts[1];
                    String topic = parts[2];
                    questions.add(new Question(questionText, answer, topic));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveQuestionsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("questions.txt"))) {
            for (Question q : questions) {
                writer.write(q.getQuestionText() + "|" + q.getAnswer() + "|" + q.getTopic());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void practiceMode() {
        if (questions.isEmpty()) {
            System.out.println("No questions available for practice.");
            return;
        }

        System.out.println("Practice mode started! Type 'exit' anytime to stop.\n");

        while (true) {
            Random random = new Random();
            Question randomQuestion = questions.get(random.nextInt(questions.size()));

            System.out.println("Question: " + randomQuestion.getQuestionText());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase("exit")) {
                break;
            }

            if (userAnswer.equalsIgnoreCase(randomQuestion.getAnswer())) {
                System.out.println("✅ Correct!");
            } else {
                System.out.println("❌ Incorrect. The correct answer is: " + randomQuestion.getAnswer());
            }

            System.out.println("---------------\n");
        }
    }

    private void searchByKeyword() {
        System.out.println("Enter a keyword to search for questions:");
        String keyword = scanner.nextLine();
        boolean found = false;

        for (Question q : questions) {
            if (q.getQuestionText().contains(keyword) || q.getAnswer().contains(keyword) || q.getTopic().contains(keyword)) {
                System.out.println("Question: " + q.getQuestionText());
                System.out.println("Answer: " + q.getAnswer());
                System.out.println("Topic: " + q.getTopic());
                System.out.println("---------------\n");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No questions found with the keyword: " + keyword);
        }
    }
}
