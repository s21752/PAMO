package com.pjatk.pamozad1.ui.quiz;

import com.pjatk.pamozad1.ui.quiz.model.QuizAnswer;
import com.pjatk.pamozad1.ui.quiz.model.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

public class QuizUtils {

    public static List<QuizQuestion> getQuestions() {
        ArrayList<QuizQuestion> questions = new ArrayList<>();
        QuizAnswer firstAnswer1 = new QuizAnswer("odpowiedz 1", 1);
        QuizAnswer secondAnswer1 = new QuizAnswer("Odpowiedz 2", 2);
        QuizAnswer thirdAnswer1 = new QuizAnswer("Odpowiedz 3", 3);
        QuizAnswer fourthAnswer1 = new QuizAnswer("Odpowiedz 4", 4);

        ArrayList<QuizAnswer> answers = new ArrayList<>();
        answers.add(firstAnswer1);
        answers.add(secondAnswer1);
        answers.add(thirdAnswer1);
        answers.add(fourthAnswer1);

        questions.add(new QuizQuestion(answers, 3, "Pytanie 1"));

        ArrayList<QuizAnswer> answers2 = new ArrayList<>();
        QuizAnswer firstAnswer2 = new QuizAnswer("inna odpowiedz 1", 1);
        QuizAnswer secondAnswer2 = new QuizAnswer("inna Odpowiedz 2", 2);
        QuizAnswer thirdAnswer2 = new QuizAnswer("inna Odpowiedz 3", 3);

        answers2.add(firstAnswer2);
        answers2.add(secondAnswer2);
        answers2.add(thirdAnswer2);

        questions.add(new QuizQuestion(answers2, 2, "Inne Pytanie 2"));

        QuizAnswer firstAnswer3 = new QuizAnswer("nowa odpowiedz 1", 1);
        QuizAnswer secondAnswer3 = new QuizAnswer("nowa Odpowiedz 2", 2);
        QuizAnswer thirdAnswer3 = new QuizAnswer("nowa  Odpowiedz 3", 3);
        QuizAnswer fourthAnswer3 = new QuizAnswer("nowa Odpowiedz 4", 4);
        QuizAnswer fifthAnswer3 = new QuizAnswer("nowa Odpowiedz 5", 5);

        ArrayList<QuizAnswer> answers3 = new ArrayList<>();

        answers3.add(firstAnswer3);
        answers3.add(secondAnswer3);
        answers3.add(thirdAnswer3);
        answers3.add(fourthAnswer3);
        answers3.add(fifthAnswer3);

        questions.add(new QuizQuestion(answers3, 4, "Nowe Pytanie 3"));

        ArrayList<QuizAnswer> answers4 = new ArrayList<>();

        QuizAnswer firstAnswer4 = new QuizAnswer("kolejna odpowiedz 1", 1);
        QuizAnswer secondAnswer4 = new QuizAnswer("kolejna Odpowiedz 2", 2);

        answers4.add(firstAnswer4);
        answers4.add(secondAnswer4);

        questions.add(new QuizQuestion(answers4, 1, "Kolejne Pytanie 4"));

        ArrayList<QuizAnswer> answers5 = new ArrayList<>();

        QuizAnswer firstAnswer5 = new QuizAnswer("Zupelnie inna odpowiedz 1", 1);
        QuizAnswer secondAnswer5 = new QuizAnswer("Zupelnie inna inna Odpowiedz 2", 2);
        QuizAnswer thirdAnswer5 = new QuizAnswer("Zupelnie inna inna Odpowiedz 3", 3);

        answers5.add(firstAnswer5);
        answers5.add(secondAnswer5);
        answers5.add(thirdAnswer5);

        questions.add(new QuizQuestion(answers5, 3, "Zupelnie inne Pytanie 5"));

        ArrayList<QuizAnswer> answers6 = new ArrayList<>();

        QuizAnswer firstAnswer6 = new QuizAnswer("Totalnie nowa odpowiedz 1", 1);
        QuizAnswer secondAnswer6 = new QuizAnswer("Totalnie nowa  Odpowiedz 2", 2);
        QuizAnswer thirdAnswer6 = new QuizAnswer("Totalnie nowa  Odpowiedz 3", 3);

        answers6.add(firstAnswer6);
        answers6.add(secondAnswer6);
        answers6.add(thirdAnswer6);

        questions.add(new QuizQuestion(answers6, 1, "Totalnie nowe Pytanie 6"));

        ArrayList<QuizAnswer> answers7 = new ArrayList<>();

        QuizAnswer firstAnswer7 = new QuizAnswer("Lepsza niz inne odpowiedz 1", 1);
        QuizAnswer secondAnswer7 = new QuizAnswer("Lepsza niz inne Odpowiedz 2", 2);
        QuizAnswer thirdAnswer7 = new QuizAnswer("Lepsza niz inne Odpowiedz 3", 3);
        QuizAnswer fourthAnswer7 = new QuizAnswer("Lepsza niz inne Odpowiedz 4", 4);
        QuizAnswer fifthAnswer7 = new QuizAnswer("Lepsza niz inne Odpowiedz 5", 5);
        QuizAnswer sixthAnswer7 = new QuizAnswer("Lepsza niz inne Odpowiedz 6", 6);


        answers7.add(firstAnswer7);
        answers7.add(secondAnswer7);
        answers7.add(thirdAnswer7);
        answers7.add(fourthAnswer7);
        answers7.add(fifthAnswer7);
        answers7.add(sixthAnswer7);

        questions.add(new QuizQuestion(answers7, 6, "Lepsze niz inne Pytanie 7"));

        ArrayList<QuizAnswer> answers8 = new ArrayList<>();

        QuizAnswer firstAnswer8 = new QuizAnswer("calkiem nowiutenka odpowiedz 1", 1);
        QuizAnswer secondAnswer8 = new QuizAnswer("calkiem nowiutenka Odpowiedz 2", 2);
        QuizAnswer thirdAnswer8 = new QuizAnswer("calkiem nowiutenka Odpowiedz 3", 3);
        QuizAnswer fourthAnswer8 = new QuizAnswer("calkiem nowiutenka Odpowiedz 4", 4);


        answers8.add(firstAnswer8);
        answers8.add(secondAnswer8);
        answers8.add(thirdAnswer8);
        answers8.add(fourthAnswer8);

        questions.add(new QuizQuestion(answers8, 2, "calkiem nowiutenkie Pytanie 8"));

        return questions;
    }
}
