package com.example.trashfootball

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

class CustomFootballGoalRelativeLayout: RelativeLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes)

    private lateinit var pass: String

    fun init() {
        pass = "ball"
    }

    fun isCorrect(password: String): Boolean {
        if (password.equals(pass))
            return true
        else
            return false
    }
}