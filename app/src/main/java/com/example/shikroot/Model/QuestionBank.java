package com.example.shikroot.Model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class QuestionBank implements Serializable {
    private List<Quiz> mQuestionList;
    private int mQuestionIndex;


    public QuestionBank(List<Quiz> questionList) {
        mQuestionList = questionList;

        Collections.shuffle(mQuestionList);
    }

    public Quiz getCurrentQuestion() {
        return mQuestionList.get(mQuestionIndex);
    }

    public Quiz getNextQuestion() {
        mQuestionIndex++;
        return getCurrentQuestion();
    }
}