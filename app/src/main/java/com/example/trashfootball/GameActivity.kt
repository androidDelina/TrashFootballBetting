package com.example.trashfootball

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class GameActivity : AppCompatActivity() {

    var score = 0
    var item = 0
    var str = ""
    var view: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val scoreTxt: TextView = findViewById(R.id.scoreText)
        scoreTxt.text = score.toString()

        val trash: CustomTrashRelativeLayout = findViewById(R.id.trash)
        val footballGoal: CustomFootballGoalRelativeLayout = findViewById(R.id.footballGoal)

        val item1: CustomTrashItemRelativeLayout = findViewById(R.id.item1)
        val item2: CustomTrashItemRelativeLayout = findViewById(R.id.item2)
        val item3: CustomTrashItemRelativeLayout = findViewById(R.id.item3)
        val item4: CustomTrashItemRelativeLayout = findViewById(R.id.item4)
        val item5: CustomTrashItemRelativeLayout = findViewById(R.id.item5)
        val item6: CustomTrashItemRelativeLayout = findViewById(R.id.item6)

        val item7: CustomBallRelativeLayout = findViewById(R.id.item7)
        val item8: CustomBallRelativeLayout = findViewById(R.id.item8)
        val item9: CustomBallRelativeLayout = findViewById(R.id.item9)
        val item10: CustomBallRelativeLayout = findViewById(R.id.item10)
        val item11: CustomBallRelativeLayout = findViewById(R.id.item11)
        val item12: CustomBallRelativeLayout = findViewById(R.id.item12)
        val item13: CustomBallRelativeLayout = findViewById(R.id.item13)
        val item14: CustomBallRelativeLayout = findViewById(R.id.item14)
        val item15: CustomBallRelativeLayout = findViewById(R.id.item15)

        val item17: CustomTrashItemRelativeLayout = findViewById(R.id.item17)
        val item18: CustomTrashItemRelativeLayout = findViewById(R.id.item18)
        val item19: CustomTrashItemRelativeLayout = findViewById(R.id.item19)
        val item20: CustomTrashItemRelativeLayout = findViewById(R.id.item20)

        trash.init()
        footballGoal.init()

        item1.init()
        item2.init()
        item3.init()
        item4.init()
        item5.init()
        item6.init()
        item7.init()
        item8.init()
        item9.init()
        item10.init()
        item11.init()
        item12.init()
        item13.init()
        item14.init()
        item15.init()
        item17.init()
        item18.init()
        item19.init()
        item20.init()



        listOf(
            item7,
            item8,
            item9,
            item10,
            item11,
            item12,
            item13,
            item14,
            item15
        ).forEach {
            it.setOnTouchListener(object: View.OnTouchListener {
                @RequiresApi(Build.VERSION_CODES.N)
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    when (event?.action) {
                        MotionEvent.ACTION_DOWN -> {
                            val shadowBuilder = View.DragShadowBuilder(v)
                            v?.startDragAndDrop(null, shadowBuilder, v, 0)
                            str = (v as CustomBallRelativeLayout).getPass()
                            view = v
                            return true;
                        }
                    }

                    return v?.onTouchEvent(event) ?: true
                }
            })
        }

    listOf(
        item1,
        item2,
        item3,
        item4,
        item5,
        item6,
        item17,
        item18,
        item19,
        item20
    ).forEach {
        it.setOnTouchListener(object: View.OnTouchListener {
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        val shadowBuilder = View.DragShadowBuilder(v)
                        v?.startDragAndDrop(null, shadowBuilder, v, 0)
                        str = (v as CustomTrashItemRelativeLayout).getPass()
                        view = v
                        return true;
                    }
                }

                return v?.onTouchEvent(event) ?: true
            }
        })
    }
        footballGoal.setOnDragListener { v, event ->
            if (event.action == DragEvent.ACTION_DROP) {

                if ((v as CustomFootballGoalRelativeLayout).isCorrect(str)) {
                    Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
                    score += 5
                    item++
                    view?.visibility = View.INVISIBLE
                    if (item == 19) {
                        val intent = Intent(this, EndActivity::class.java)
                        intent.putExtra("score", score)
                        startActivity(intent)
                    }
                    scoreTxt.text = score.toString()
                } else {
                    Toast.makeText(this, "FAIL!", Toast.LENGTH_SHORT).show()
                    score -= 5
                    scoreTxt.text = score.toString()
                }

            //    view?.visibility = View.VISIBLE
                view = null
            }
            true

        }

        trash.setOnDragListener { v, event ->
            if (event.action == DragEvent.ACTION_DROP) {

                if ((v as CustomTrashRelativeLayout).isCorrect(str)) {
                    Toast.makeText(this, "CORRECT!", Toast.LENGTH_SHORT).show()
                    score += 5
                    item++
                    view?.visibility = View.INVISIBLE
                    if (item == 19) {
                        val intent = Intent(this, EndActivity::class.java)
                        intent.putExtra("score", score)
                        startActivity(intent)
                    }
                    scoreTxt.text = score.toString()
                } else {
                    Toast.makeText(this, "FAIL!", Toast.LENGTH_SHORT).show()
                    score -= 5
                    scoreTxt.text = score.toString()
                }

          //      view?.visibility = View.VISIBLE
                view = null
            }
            true
        }

    }
}