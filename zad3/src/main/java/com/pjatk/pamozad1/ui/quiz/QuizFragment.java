package com.pjatk.pamozad1.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;

import com.pjatk.pamozad1.R;
import com.pjatk.pamozad1.ui.quiz.model.QuizAnswer;
import com.pjatk.pamozad1.ui.quiz.model.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

public class QuizFragment extends Fragment {

    @Nullable
    View view;

    int currentQuestionIndex = 0, playerPoints = 0;

    ArrayList<QuizQuestion> questions = new ArrayList<>();

    @Nullable
    Group gQuizViews;

    @Nullable
    TextView tvQuestion, tvQuizProgress;

    @Nullable
    RadioGroup rgAnswers;

    @Nullable
    Button bStartRestartQuiz;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_quizz, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadMockQuestions();
        setViews();
    }

    private void loadMockQuestions() {
        questions.addAll(QuizUtils.getQuestions());
    }

    private void restartQuiz() {
        gQuizViews.setVisibility(View.VISIBLE);
        bStartRestartQuiz.setVisibility(View.GONE);
        currentQuestionIndex = 0;
        playerPoints = 0;

        loadQuestion();
    }

    private void loadQuestion() {
        StringBuffer currentQuestionLabel = new StringBuffer();
        currentQuestionLabel.append(currentQuestionIndex + 1);
        currentQuestionLabel.append("/");
        currentQuestionLabel.append(questions.size());
        tvQuizProgress.setText(currentQuestionLabel.toString());
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);

        tvQuestion.setText(currentQuestion.getText());
        rgAnswers.removeAllViews();
        for (QuizAnswer answer : currentQuestion.getAnswers()) {
            RadioButton answerButton = new RadioButton(getContext());

            answerButton.setId(answer.getId());
            answerButton.setText(answer.getText());

            rgAnswers.addView(answerButton);
        }

        rgAnswers.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == currentQuestion.getCorrectAnswerId()) {
                playerPoints++;
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                loadQuestion();
            } else {
                rgAnswers.setVisibility(View.GONE);
                String scoreAndRestartPrompt = getString(R.string.your_score_is) +
                        playerPoints +
                        "/" +
                        questions.size() +
                        "\n" +
                        getString(R.string.restart_prompt);
                tvQuestion.setText(scoreAndRestartPrompt);
                bStartRestartQuiz.setVisibility(View.VISIBLE);
            }
        });

    }

    private void setViews() {
        gQuizViews = view.findViewById(R.id.gQuestion);
        tvQuestion = view.findViewById(R.id.tvQuestion);
        tvQuizProgress = view.findViewById(R.id.tvQuizProgress);
        rgAnswers = view.findViewById(R.id.rgAnswers);
        bStartRestartQuiz = view.findViewById(R.id.bStartRestartQuizButton);

        gQuizViews.setVisibility(View.GONE);
        bStartRestartQuiz.setVisibility(View.VISIBLE);
        bStartRestartQuiz.setOnClickListener((view) -> {
            restartQuiz();
        });
    }
}
