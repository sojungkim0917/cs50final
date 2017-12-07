package cs50final.com.cs50final;

/* Questions, answers, and length are all hardcoded */

public class IntermediateMathQuestions {

    public String[] mQuestions = {

            "1) 2 x 8", "2) 5 x 4", "3) 2 x 2", "4) 6 x 6", "5) 4 x 3",
            "6) 10 x 4", "7) 30 x 3", "8) 34 x 2", "9) 3 x 23", "10) 2 x 341",
            "11) 35 / 5", "12) 12 / 4", "13) 63 / 7", "14) 72 / 12", "15) 50 / 5",
            "16) 20 / 4", "17) 42 / 7", "18) 24 / 2", "19) 45 / 5", "20) 144 / 12"
    };


    private String mChoices[][] = {

            {"6", "10", "16", "18"}, {"14", "20", "24", "30"}, {"4", "5", "1", "7"}, {"12", "24", "30", "36"}, {"9", "10", "11", "12"},
            {"20", "30", "40", "50"}, {"9", "33", "90", "180"}, {"58", "68", "72", "98"}, {"46", "66", "69", "96"}, {"682", "784", "862", "982"},
            {"4", "5", "6", "7"}, {"2", "3", "4", "5"}, {"7", "8", "9", "10"}, {"5", "6", "8", "9"}, {"10", "20", "30", "40"},
            {"4", "5", "6", "7"}, {"4", "5", "6", "7"}, {"8", "9", "12", "40"}, {"7", "8", "9", "10"}, {"12", "14", "16", "18"}

    };

    private String mCorrectAnswers[] = {
            "16", "20", "4", "36", "12",
            "40", "90", "68", "69", "682",
            "7", "3", "9", "6", "10",
            "5", "6", "12", "9", "12"};

    public int length() {
        return 20;
    }

    // Getter for questions, choices, and answers
    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
