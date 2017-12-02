package cs50final.com.cs50final;


public class MathQuestions {

    public String[] mQuestions = {

            "0+1", "2-0", "12/4", "8/2", "1*5"
    };


    private String mChoices[][] = {

            {"0", "5", "1", "4"}, {"1", "2", "7", "8"}, {"3", "5", "2", "9"}, {"1", "0", "7", "4"}, {"0", "5", "8", "3"}

    };

    private String mCorrectAnswers[] = {"1", "2", "3", "4", "5"};

    public int length() {
        return 5;
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
