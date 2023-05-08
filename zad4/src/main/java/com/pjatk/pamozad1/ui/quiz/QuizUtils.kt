package com.pjatk.pamozad1.ui.quiz

import com.pjatk.pamozad1.ui.quiz.model.QuizAnswer
import com.pjatk.pamozad1.ui.quiz.model.QuizQuestion

object QuizUtils {
    val questions: List<QuizQuestion>
        get() {
            val questions = mutableListOf<QuizQuestion>()
            questions.add(
                QuizQuestion(
                    listOf(
                        QuizAnswer("odpowiedz 1", 1),
                        QuizAnswer("Odpowiedz 2", 2),
                        QuizAnswer("Odpowiedz 3", 3),
                        QuizAnswer("Odpowiedz 4", 4)
                    ), 3, "Pytanie 1"
                )
            )
            questions.add(
                QuizQuestion(
                    listOf(
                        QuizAnswer("inna odpowiedz 1", 1),
                        QuizAnswer("inna Odpowiedz 2", 2),
                        QuizAnswer("inna Odpowiedz 3", 3)
                    ), 2, "Inne Pytanie 2"
                )
            )
            questions.add(
                QuizQuestion(
                    listOf(
                        QuizAnswer("nowa odpowiedz 1", 1),
                        QuizAnswer("nowa Odpowiedz 2", 2),
                        QuizAnswer("nowa  Odpowiedz 3", 3),
                        QuizAnswer("nowa Odpowiedz 4", 4),
                        QuizAnswer("nowa Odpowiedz 5", 5)
                    ), 4, "Nowe Pytanie 3"
                )
            )
            questions.add(
                QuizQuestion(
                    mutableListOf(
                        QuizAnswer("kolejna odpowiedz 1", 1),
                        QuizAnswer("kolejna Odpowiedz 2", 2)
                    ), 1, "Kolejne Pytanie 4"
                )
            )

            questions.add(
                QuizQuestion(
                    listOf(
                        QuizAnswer("Zupelnie inna odpowiedz 1", 1),
                        QuizAnswer("Zupelnie inna inna Odpowiedz 2", 2),
                        QuizAnswer("Zupelnie inna inna Odpowiedz 3", 3)
                    ), 3, "Zupelnie inne Pytanie 5"
                )
            )

            questions.add(
                QuizQuestion(
                    listOf(
                        QuizAnswer("Totalnie nowa odpowiedz 1", 1),
                        QuizAnswer("Totalnie nowa  Odpowiedz 2", 2),
                        QuizAnswer("Totalnie nowa  Odpowiedz 3", 3)
                    ), 1, "Totalnie nowe Pytanie 6"
                )
            )

            questions.add(
                QuizQuestion(
                    listOf(
                        QuizAnswer("Lepsza niz inne odpowiedz 1", 1),
                        QuizAnswer("Lepsza niz inne Odpowiedz 2", 2),
                        QuizAnswer("Lepsza niz inne Odpowiedz 3", 3),
                        QuizAnswer("Lepsza niz inne Odpowiedz 4", 4),
                        QuizAnswer("Lepsza niz inne Odpowiedz 5", 5),
                        QuizAnswer("Lepsza niz inne Odpowiedz 6", 6)
                    ), 6, "Lepsze niz inne Pytanie 7"
                )
            )
            questions.add(
                QuizQuestion(
                    listOf(
                        QuizAnswer("calkiem nowiutenka odpowiedz 1", 1),
                        QuizAnswer("calkiem nowiutenka Odpowiedz 2", 2),
                        QuizAnswer("calkiem nowiutenka Odpowiedz 3", 3),
                        QuizAnswer("calkiem nowiutenka Odpowiedz 4", 4)
                    ), 2, "calkiem nowiutenkie Pytanie 8"
                )
            )
            return questions
        }
}