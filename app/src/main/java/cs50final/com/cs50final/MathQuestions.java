package cs50final.com.cs50final;

/* Questions, answers, and length are all hardcoded */

public class MathQuestions {

    public String[] mQuestions = {

            "1) 2 + 3", "2) 16 - 9", "3) 2 x 2", "4) 9 / 3", "5) 3 * 3",
            "6) 25 / 5", "7) 33 - 22", "8) 72 / 8", "9) 2 x 7", "10) 24 / 8",
            "11) 5 + 9", "12) 6 x 9", "13) 54 - 38", "14) 2 + 16", "15) 8 x 5",
            "16) 20 + 28", "17) 8 x 7", "18) 33 x 3", "19) 86 - 65", "20) 34 + 38"
    };


    private String mChoices[][] = {

            {"0", "5", "1", "9"}, {"3", "6", "7", "8"}, {"4", "5", "1", "7"}, {"1", "0", "3", "7"}, {"9", "7", "2", "3"},
            {"4", "9", "5", "12"}, {"11", "3", "5", "8"}, {"1", "6", "14", "9"}, {"14", "0", "7", "4"}, {"0", "5", "18", "3"},
            {"20", "8", "14", "31"}, {"22", "32", "54", "9"}, {"7", "16", "35", "41"}, {"6", "20", "18", "41"}, {"20", "30", "40", "50"},
            {"15", "25", "37", "48"}, {"56", "64", "37", "81"}, {"99", "57", "31", "29"}, {"45", "23", "21", "67"}, {"84", "27", "72", "35"}

    };

    private String mCorrectAnswers[] = {"5", "7", "4", "3", "9",
                                        "5", "11", "9", "14", "3",
                                        "14", "54", "16", "18", "40",
                                        "48", "56", "99", "21", "72"};

    public int length() {
        return 20;
    }


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
