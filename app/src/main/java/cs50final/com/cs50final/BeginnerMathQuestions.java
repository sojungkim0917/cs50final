package cs50final.com.cs50final;

/* Questions, answers, and length are all hardcoded */

public class BeginnerMathQuestions {

    public String[] mQuestions = {

            "1) 3 + 5", "2) 6 + 7", "3) 5 + 7", "4) 8 + 3", "5) 5 + 8 + 3",
            "6) 50 + 24", "7) 63 + 13", "8) 27 + 49", "9) 64 + 37", "10) 34 + 127",
            "11) 9 - 4", "12) 15 - 7", "13) 12 - 8", "14) 7 - 3 - 2", "15) 14 - 5",
            "16) 49 - 27", "17) 92 - 82", "18) 67 - 24", "19) 86 - 65", "20) 999 - 842"
    };


    private String mChoices[][] = {

            {"7", "8", "9", "10"}, {"11", "12", "13", "14"}, {"11", "12", "13", "14"}, {"11", "12", "13", "14"}, {"13", "14", "15", "16"},
            {"36", "54", "74", "84"}, {"50", "66", "73", "76"}, {"66", "68", "76", "78"}, {"87", "91", "93", "101"}, {"151", "161", "163", "171"},
            {"5", "6", "8", "13"}, {"6", "7", "8", "9"}, {"2", "3", "4", "5"}, {"0", "1", "2", "3"}, {"8", "9", "10", "11"},
            {"18", "22", "28", "32"}, {"8", "10", "12", "14"}, {"41", "43", "53", "91"}, {"45", "23", "21", "67"}, {"157", "164", "172", "183"}

    };

    private String mCorrectAnswers[] = {"8", "13", "12", "11", "16",
                                        "74", "76", "76", "101", "161",
                                        "5", "8", "4", "2", "9",
                                        "22", "10", "43", "21", "157"};

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
