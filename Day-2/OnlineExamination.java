import java.util.Scanner;
class Question {
    String question;
    String[] options;
    String correctanswer;
    public Question(String question, String[] options, String correctanswer) {
        this.question = question;
        this.options = options;
        this.correctanswer = correctanswer;
    }
    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrectAnswer(String answer) {
        return correctanswer.equals(answer);
    }
}


class Quiz {
     Question[] questions;
     int score;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        for (Question question : questions) {
            question.displayQuestion();
            System.out.print("Enter your answer: ");
            String answer = sc.nextLine();

            if (question.isCorrectAnswer(answer)) {
                score++;
                System.out.println("Correct\n");
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.correctanswer + "\n");
            }
        }
        displayFinalScore();
    }


    private void displayFinalScore() {
        System.out.println("Quiz finished");
        System.out.println("Your total score is: " + score + " out of " + questions.length);
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Question[] questions = {
            new Question("What is the capital of AP?", new String[]{"Hyderabad", "Mumbai", "Amaravathi", "Kolkota"}, "Amaravathi"),
            new Question("Who is the CM of AP?", new String[]{"Chandrababunaidu", "Jagan", "Pawankalyan", "KCR"}, "Chandrababunaidu"),
        
        };
        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}