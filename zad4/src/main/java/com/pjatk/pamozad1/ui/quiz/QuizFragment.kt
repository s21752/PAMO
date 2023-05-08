package com.pjatk.pamozad1.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.pjatk.pamozad1.R
import com.pjatk.pamozad1.ui.quiz.model.QuizQuestion

class QuizFragment : Fragment() {
    var currentQuestionIndex = 0
    var playerPoints = 0
    var questions = ArrayList<QuizQuestion>()
    var gQuizViews: Group? = null
    var tvQuestion: TextView? = null
    var tvQuizProgress: TextView? = null
    var rgAnswers: RadioGroup? = null
    var bStartRestartQuiz: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.fragment_quizz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadMockQuestions()
        setViews()
    }

    private fun loadMockQuestions() {
        questions.addAll(QuizUtils.questions)
    }

    private fun restartQuiz() {
        gQuizViews!!.visibility = View.VISIBLE
        bStartRestartQuiz!!.visibility = View.GONE
        currentQuestionIndex = 0
        playerPoints = 0
        loadQuestion()
    }

    private fun loadQuestion() {
        val currentQuestionLabel = StringBuffer()
        currentQuestionLabel.append(currentQuestionIndex + 1)
        currentQuestionLabel.append("/")
        currentQuestionLabel.append(questions.size)
        tvQuizProgress!!.text = currentQuestionLabel.toString()
        val (answers, correctAnswerId, text) = questions[currentQuestionIndex]
        tvQuestion!!.text = text
        rgAnswers!!.removeAllViews()
        for ((text1, id) in answers) {
            val answerButton = RadioButton(context)
            answerButton.id = id
            answerButton.text = text1
            rgAnswers!!.addView(answerButton)
        }
        rgAnswers!!.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->
            if (checkedId == correctAnswerId) {
                playerPoints++
            }
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                rgAnswers!!.visibility = View.GONE
                val scoreAndRestartPrompt = """
                ${getString(R.string.your_score_is)}$playerPoints/${questions.size}
                ${getString(R.string.restart_prompt)}
                """.trimIndent()
                tvQuestion!!.text = scoreAndRestartPrompt
                bStartRestartQuiz!!.visibility = View.VISIBLE
            }
        }
    }

    private fun setViews() = with(requireView()) {
        gQuizViews = findViewById<Group?>(R.id.gQuestion).also {
            it.isGone = true
        }
        tvQuestion = findViewById(R.id.tvQuestion)
        tvQuizProgress = findViewById(R.id.tvQuizProgress)
        rgAnswers = findViewById(R.id.rgAnswers)
        bStartRestartQuiz = findViewById(R.id.bStartRestartQuizButton)
        bStartRestartQuiz?.isVisible = true
        bStartRestartQuiz?.setOnClickListener { view: View? -> restartQuiz() }
    }
}