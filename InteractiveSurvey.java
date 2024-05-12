import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class InteractiveSurvey {

    private final Scanner scanner = new Scanner(System.in);
    private final LinkedHashMap<String, List<String>> categories = new LinkedHashMap<>();
    private final LinkedHashMap<String, String[]> options = new LinkedHashMap<>();
    private final LinkedHashMap<Integer, String> questionMap = new LinkedHashMap<>();

    public InteractiveSurvey() {

        // Questions and options setup, you add categories and set of questions here
        categories.put("Computer Usage and Access", new ArrayList<>());
        categories.get("Computer Usage and Access").add("1. How often can you use computers in class activities?");
        categories.get("Computer Usage and Access").add("2. During hands-on activities, is there usually enough equipment for everyone?");
        categories.get("Computer Usage and Access").add("3. Have you ever had trouble getting computer hardware for interactive learning activities?");
        categories.get("Computer Usage and Access").add("4. How crucial do you think having access to computers is to your performance in school?");
        categories.get("Computer Usage and Access").add("5. How would you rank our school's availability of computer equipment for hands-on learning activities, on a scale of 1 to 5?");
        categories.get("Computer Usage and Access").add("6. Are you satisfied with the computers' availability at San Francisco High School?");

        categories.put("Effectiveness", new ArrayList<>());
        categories.get("Effectiveness").add("7. On a scale of 1 (terrible) to 5 (excellent), how would you rate the condition of the computers you use in school?");
        categories.get("Effectiveness").add("8. When your class has computer-based activities, do the computers allow you to complete the tasks effectively?");
        categories.get("Effectiveness").add("9. Rate how effective do you find computers for studying? (On a scale of 1-5)");

        categories.put("Computer Activities", new ArrayList<>());
        categories.get("Computer Activities").add("10. How often do your classes involve activities where you use a computer to learn by doing?");
        categories.get("Computer Activities").add("11. Compared to traditional methods like lectures and textbooks, do you feel computer activities help you remember information better?");
        categories.get("Computer Activities").add("12. Would you like to see more hands-on computer activities incorporated into your classes?");

        categories.put("Satisfaction with Computer Equipment", new ArrayList<>());
        categories.get("Computer Activities").add("13. To what extent do you find the current state of computer equipment available at our school for hands-on learning activities satisfactory?");
        categories.get("Computer Activities").add("14. To what extent of satisfaction do you perceive that the availability of computer equipment enhances your hands-on learning experiences?");
        categories.get("Computer Activities").add("15. How satisfied are you that access to computer equipment positively influences your engagement in hands-on learning activities at San Francisco High?");
        categories.get("Computer Activities").add("16. What is the level of your satisfaction regarding the impact of computer equipment availability on your technical skill development at San Francisco High School?");
        categories.get("Computer Activities").add("17. How frequent does the equipment in the computer laboratory help you learn how to code?");

        // Options for each question by number, Make sure its correspond the question above.
        // Format options.put("# of question. The question", new String[]{"Never", "Rarely", "Sometimes", "Often", "Always"}); <--- is the choices you can delete or add.
        // Start of Effectiveness Option
        options.put("1. How often can you use computers in class activities?", new String[]{"Never", "Rarely", "Sometimes", "Often", "Always"});
        options.put("2. During hands-on activities, is there usually enough equipment for everyone?", new String[]{"No", "Unsure", "Yes"});
        options.put("3. Have you ever had trouble getting computer hardware for interactive learning activities?", new String[]{"No", "Yes"});
        options.put("4. How crucial do you think having access to computers is to your performance in school?", new String[]{"Not important at all", "Not very important", "Neutral", "Important", "Very important"});
        options.put("5. How would you rank our school's availability of computer equipment for hands-on learning activities, on a scale of 1 to 5?", new String[]{"Very dissatisfied", "Dissatisfied", "Satisfied", "Very satisfied"});
        options.put("6. Are you satisfied with the computers' availability at San Francisco High School?", new String[]{"Very dissatisfied", "Dissatisfied", "Satisfied", "Very satisfied"});
        // End of Computer Usage Option

        // Start of Effectiveness Option
        options.put("7. On a scale of 1 (terrible) to 5 (excellent), how would you rate the condition of the computers you use in school?", new String[]{"1", "2", "3", "4", "5"});
        options.put("8. When your class has computer-based activities, do the computers allow you to complete the tasks effectively?", new String[]{"Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree"});
        options.put("9. Rate how effective do you find computers for studying? (On a scale of 1-5)", new String[]{"1", "2", "3", "4", "5"});
        // End of Effectiveness Option

        // Start Of Computer Activities Option
        options.put("10. How often do your classes involve activities where you use a computer to learn by doing?", new String[]{"Never", "Rarely", "Sometimes", "Often", "Always"});
        options.put("11. Compared to traditional methods like lectures and textbooks, do you feel computer activities help you remember information better?", new String[]{"No", "Unsure", "Yes"});
        options.put("12. Would you like to see more hands-on computer activities incorporated into your classes?", new String[]{"No", "Unsure", "Yes"});
        // End of Computer Activities Option

        // Start of Satisfaction with Computer Equipment Option
        options.put("13. To what extent do you find the current state of computer equipment available at our school for hands-on learning activities satisfactory?", new String[]{"Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree"});
        options.put("14. To what extent of satisfaction do you perceive that the availability of computer equipment enhances your hands-on learning experiences?", new String[]{"Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree"});
        options.put("15. How satisfied are you that access to computer equipment positively influences your engagement in hands-on learning activities at San Francisco High?", new String[]{"Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree"});
        options.put("16. What is the level of your satisfaction regarding the impact of computer equipment availability on your technical skill development at San Francisco High School?", new String[]{"Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree"});
        options.put("17. How frequent does the equipment in the computer laboratory help you learn how to code?", new String[]{"Never", "Rarely", "Neutral", "Sometimes", "Often", "Always"});


        // Populate questionMap for easy access during edit operations
        int questionNumber = 1;
        for (String category : categories.keySet()) {
            for (String question : categories.get(category)) {
                questionMap.put(questionNumber++, question);
            }
        }
    }
    // For typing Effect, you can change the delay if you want
    private void printWithTypingEffect(String message, long delay) {
        for (char character : message.toCharArray()) {
            System.out.print(character);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    // here is the welcome message also the ascii art and the delay of effect
    public void startSurvey() {
        printWithTypingEffect("███████╗██╗   ██╗██████╗ ██╗   ██╗███████╗██╗   ██╗    ███████╗ ██████╗ ██████╗ ███╗   ███╗\n" +
                "██╔════╝██║   ██║██╔══██╗██║   ██║██╔════╝╚██╗ ██╔╝    ██╔════╝██╔═══██╗██╔══██╗████╗ ████║\n" +
                "███████╗██║   ██║██████╔╝██║   ██║█████╗   ╚████╔╝     █████╗  ██║   ██║██████╔╝██╔████╔██║\n" +
                "╚════██║██║   ██║██╔══██╗╚██╗ ██╔╝██╔══╝    ╚██╔╝      ██╔══╝  ██║   ██║██╔══██╗██║╚██╔╝██║\n" +
                "███████║╚██████╔╝██║  ██║ ╚████╔╝ ███████╗   ██║       ██║     ╚██████╔╝██║  ██║██║ ╚═╝ ██║\n" +
                "╚══════╝ ╚═════╝ ╚═╝  ╚═╝  ╚═══╝  ╚══════╝   ╚═╝       ╚═╝      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝\n\n", 5);

        printWithTypingEffect("Welcome to our Interactive Survey Made by group 4!\n\n", 30);
        printWithTypingEffect("This survey aims to collect detailed feedback on computer usage, access, effectiveness, and satisfaction levels across a broad demographic. By exploring these areas, we intend to identify patterns, preferences, and areas for improvement, ultimately guiding better, more user-centric technology development and policies.\n\n", 30);
        printWithTypingEffect("Read each question carefully before answering, each one has been crafted to gather specific insights.\n\n", 30);
        printWithTypingEffect("There are no right or wrong answers. We value your honest and candid feedback.\n\n", 30);


        LinkedHashMap<Integer, Integer> answers = new LinkedHashMap<>();
        // Here is the logic where it checks whether the user input appropriate answer or not. it will return again to the question if its beyond the choices.

        int questionNumber = 1;
        for (String category : categories.keySet()) {
            System.out.println("\n" + category + ":");

            for (String question : categories.get(category)) {
                boolean validAnswer = false;
                while (!validAnswer) {
                    System.out.println(question);
                    String[] questionOptions = options.get(question);
                    for (int i = 0; i < questionOptions.length; i++) {
                        System.out.println("   [" + (i + 1) + "] " + questionOptions[i]);
                    }
                    System.out.print("Your answer (1-" + questionOptions.length + "): ");

                    if (scanner.hasNextInt()) {
                        int answer = scanner.nextInt();
                        if (answer >= 1 && answer <= questionOptions.length) {
                            answers.put(questionNumber, answer);
                            validAnswer = true;
                        } else {
                            System.out.println("Invalid input. Please enter a number between 1 and " + questionOptions.length);
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                    }
                }
                questionNumber++;
            }
        }
        scanner.nextLine();

        // Summary before submission
        printSummary(answers);

        // Handle editing of answers
        editAnswers(answers);

        // Final submission and thank you message
        System.out.println("\nThanks for taking your time to answer the survey!!!\n");


        // Final calculation of average rating
        double averageRating = calculateAverageRating(answers);
        String ratingVerdict = getRatingVerdict(averageRating);
        String customRemark = getRemarkBasedOnRating(ratingVerdict);

        // Final submission and thank you message, The final verdict which is the rating will print on this part.
        System.out.println("You gave us an overall rating of: " + ratingVerdict);
        System.out.println("\n" + customRemark);
        System.out.println("\nHave a great day!!!");
    }

    // calculate the average to get the rating
    private double calculateAverageRating(LinkedHashMap<Integer, Integer> answers) {
        int sumOfRatings = 0;
        for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
            int questionNumber = entry.getKey();
            int answerNumber = entry.getValue();
            String question = questionMap.get(questionNumber);
            String[] questionOptions = options.get(question);

            if (questionOptions.length == 3) { // Assumes Yes/Unsure/No options have three possible answers only
                // Adjust rating based on Yes/Unsure/No
                if ("Yes".equals(questionOptions[answerNumber - 1])) {
                    sumOfRatings += 5;
                } else if ("Unsure".equals(questionOptions[answerNumber - 1])) {
                    sumOfRatings += 3;
                } else if ("No".equals(questionOptions[answerNumber - 1])) {
                    sumOfRatings += 1;
                }
            } else {
                // For other questions, the rating is the selected option number
                sumOfRatings += answerNumber;
            }
        }
        return sumOfRatings / (double) answers.size();
    }

    private String getRatingVerdict(double averageRating) {
        if (averageRating >= 4.5) {
            return "Very Satisfied";
        } else if (averageRating >= 3.5) {
            return "Satisfied";
        } else if (averageRating >= 2.5) {
            return "Neutral";
        } else if (averageRating >= 1.5) {
            return "Unsatisfied";
        } else {
            return "Very Unsatisfied";
        }
    }

    private String getRemarkBasedOnRating(String ratingVerdict) {
        switch (ratingVerdict) {
            case "Very Satisfied":
                return "We are thrilled to hear you had a great experience!";
            case "Satisfied":
                return "We're happy to see you're quite content with the service!";
            case "Neutral":
                return "We appreciate your honesty and will work to improve your experience.";
            case "Unsatisfied":
                return "We are sorry to hear that your experience didn't meet your expectations.";
            case "Very Unsatisfied":
                return "We apologize for any inconvenience caused and hope to serve you better in the future.";
            default:
                return "Thank you for your feedback!";
        }
    }
    private void printSummary(LinkedHashMap<Integer, Integer> answers) {
        System.out.println("\nHere is a summary of your answers: \n");
        answers.forEach((qNum, ans) -> {
            String question = questionMap.get(qNum);
            String[] questionOptions = options.get(question);
            System.out.println(question);
            System.out.println("Your Input: " + questionOptions[ans - 1] + "\n");
        });
    }

    private void editAnswers(LinkedHashMap<Integer, Integer> answers) {
        String editDecision;
        do {
            System.out.println("\nWould you like to edit any answers? (yes/no)");
            editDecision = scanner.nextLine();
            if (editDecision.equalsIgnoreCase("yes")) {
                System.out.print("Enter the question number you would like to edit: ");
                int questionNumToEdit = scanner.nextInt();
                if (answers.containsKey(questionNumToEdit)) {
                    String question = questionMap.get(questionNumToEdit);

                    // Display question
                    System.out.println(question);

                    // Display options for the question
                    String[] questionOptions = options.get(question);
                    for (int i = 0; i < questionOptions.length; i++) {
                        System.out.println("   [" + (i + 1) + "] " + questionOptions[i]);
                    }
                    System.out.print("Your new answer (1-" + questionOptions.length + "): ");
                    int newAnswer = scanner.nextInt();

                    // Validate and update the answer
                    if (newAnswer >= 1 && newAnswer <= questionOptions.length) {
                        answers.put(questionNumToEdit, newAnswer);
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and " + questionOptions.length);
                    }
                } else {
                    System.out.println("Invalid question number. Please try again.");
                }
                scanner.nextLine(); // Consume the remaining newline
                printSummary(answers); // Print updated summary
            }
        } while (editDecision.equalsIgnoreCase("yes"));
    }

    public static void main(String[] args) {
        new InteractiveSurvey().startSurvey();
    }
}