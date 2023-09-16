package memb.costser.app

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import memb.costser.app.databinding.ActivityPlugBinding
import java.io.File

class PlugActivity : AppCompatActivity() {
    private val FILE_NAME = "file_score"
    private lateinit var backImage: ImageView
    private lateinit var binding: ActivityPlugBinding

    // for anim
    lateinit var flip_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet
    private var isFront = true

    // for images
    private var rowNumber = 1
    private lateinit var answerImage: ImageView
    private val firstRow = arrayListOf<ImageView>()
    private val secondRow = arrayListOf<ImageView>()
    private val thirdRow = arrayListOf<ImageView>()
    private val fourthRow = arrayListOf<ImageView>()
    private val fifthRow = arrayListOf<ImageView>()


    // for score
    private var score = 0
    private val arrayAnswers = arrayListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlugBinding.inflate(layoutInflater)

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(binding.root)

        firstRow.add(binding.imageFront11)
        firstRow.add(binding.imageFront12)
        firstRow.add(binding.imageFront13)
        firstRow.add(binding.imageFront14)
        firstRow.add(binding.imageFront15)

        secondRow.add(binding.imageFront21)
        secondRow.add(binding.imageFront22)
        secondRow.add(binding.imageFront23)
        secondRow.add(binding.imageFront24)
        secondRow.add(binding.imageFront25)

        thirdRow.add(binding.imageFront31)
        thirdRow.add(binding.imageFront32)
        thirdRow.add(binding.imageFront33)
        thirdRow.add(binding.imageFront34)
        thirdRow.add(binding.imageFront35)

        fourthRow.add(binding.imageFront41)
        fourthRow.add(binding.imageFront42)
        fourthRow.add(binding.imageFront43)
        fourthRow.add(binding.imageFront44)
        fourthRow.add(binding.imageFront45)

        fifthRow.add(binding.imageFront51)
        fifthRow.add(binding.imageFront52)
        fifthRow.add(binding.imageFront53)
        fifthRow.add(binding.imageFront54)
        fifthRow.add(binding.imageFront55)

        if (haveLink())
            score = textLink().toInt()

        binding.score.text = "$score points"

        binding.listener.setOnClickListener {

        }

        makeRowClickable()
    }

    private fun makeRowClickable() {
        when (rowNumber) {
            1 -> {
                createAnswer()
                for (i in 0..4) {
                    firstRow[i].setOnClickListener { v ->
                        showFlipAnim(v as ImageView)
                    }
                    secondRow[i].setOnClickListener {  }
                    thirdRow[i].setOnClickListener {  }
                    fourthRow[i].setOnClickListener {  }
                    fifthRow[i].setOnClickListener {  }
                }
            }
            2 -> {
                createAnswer()
                for (i in 0..4) {
                    firstRow[i].setOnClickListener {  }
                    secondRow[i].setOnClickListener { v ->
                        showFlipAnim(v as ImageView)
                    }
                    thirdRow[i].setOnClickListener {  }
                    fourthRow[i].setOnClickListener {  }
                    fifthRow[i].setOnClickListener {  }
                }
            }
            3 -> {
                createAnswer()
                for (i in 0..4) {
                    firstRow[i].setOnClickListener {  }
                    secondRow[i].setOnClickListener {  }
                    thirdRow[i].setOnClickListener { v ->
                        showFlipAnim(v as ImageView)
                    }
                    fourthRow[i].setOnClickListener {  }
                    fifthRow[i].setOnClickListener {  }
                }
            }
            4 -> {
                createAnswer()
                for (i in 0..4) {
                    firstRow[i].setOnClickListener {  }
                    secondRow[i].setOnClickListener {  }
                    thirdRow[i].setOnClickListener {  }
                    fourthRow[i].setOnClickListener { v ->
                        showFlipAnim(v as ImageView)
                    }
                    fifthRow[i].setOnClickListener {  }
                }
            }
            5 -> {
                createAnswer()
                for (i in 0..4) {
                    firstRow[i].setOnClickListener {  }
                    secondRow[i].setOnClickListener {  }
                    thirdRow[i].setOnClickListener {  }
                    fourthRow[i].setOnClickListener {  }
                    fifthRow[i].setOnClickListener { v ->
                        showFlipAnim(v as ImageView)
                    }
                }
            }
        }
    }

    private fun createAnswer() {
        when (rowNumber) {
            1 -> {
                val random = (0..4).random()
                val firstRow = arrayListOf<ImageView>(
                    binding.imageBack11, binding.imageBack12,
                    binding.imageBack13, binding.imageBack14,
                    binding.imageBack15
                )
                goBackImage(firstRow[random], R.drawable.ball, 0)

                answerImage = firstRow[random]
            }
            2 -> {
                val secondRow = arrayListOf<ImageView>(
                    binding.imageBack21, binding.imageBack22,
                    binding.imageBack23, binding.imageBack24,
                    binding.imageBack25
                )
                val random = (0..4).random()
                goBackImage(secondRow[random], R.drawable.ball, 0)
                answerImage = secondRow[random]
            }
            3 -> {
                val thirdRow = arrayListOf<ImageView>(
                    binding.imageBack31, binding.imageBack32,
                    binding.imageBack33, binding.imageBack34,
                    binding.imageBack35
                )
                val random = (0..4).random()
                goBackImage(thirdRow[random], R.drawable.ball, 0)
                answerImage = thirdRow[random]
            }
            4 -> {
                val fourthRow = arrayListOf<ImageView>(
                    binding.imageBack41, binding.imageBack42,
                    binding.imageBack43, binding.imageBack44,
                    binding.imageBack45
                )
                val random = (0..4).random()
                goBackImage(fourthRow[random], R.drawable.ball, 0)
                answerImage = fourthRow[random]
            }
            5 -> {
                val fifthRow = arrayListOf<ImageView>(
                    binding.imageBack51, binding.imageBack52,
                    binding.imageBack53, binding.imageBack54,
                    binding.imageBack55
                )
                val random = (0..4).random()
                goBackImage(fifthRow[random], R.drawable.ball, 0)
                answerImage = fifthRow[random]
            }
        }
    }

    private fun showFlipAnim(frontImageView: ImageView) {
        val scale = applicationContext?.resources?.displayMetrics?.density
        frontImageView.cameraDistance = scale!! * 8000
        val backImageView = binding.root.getViewById(frontImageView.id - 25)
        backImageView.cameraDistance = scale * 8000

        backImage = backImageView as ImageView

        flip_anim = AnimatorInflater.loadAnimator(
            applicationContext,
            R.animator.rotation
        ) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(
            applicationContext,
            R.animator.back_flip
        ) as AnimatorSet

        isFront = if (isFront) {
            flip_anim.setTarget(frontImageView)
            back_anim.setTarget(backImageView)
            flip_anim.start()
            back_anim.start()
            false
        } else {
            flip_anim.setTarget(frontImageView)
            back_anim.setTarget(backImageView)
            back_anim.start()
            flip_anim.start()
            true
        }

        checkAnswer(backImage)
    }

    private fun checkAnswer(backImageView: ImageView) {
        arrayAnswers.add( backImageView)
        Log.d("checkAnswer", "backImageView == answerImage -${backImageView == answerImage}")

        if (backImageView == answerImage) {
            score += 50
            Log.d("checkAnswer", "$rowNumber")
            rowNumber++
            makeRowClickable()
            Log.d("checkAnswer", "${arrayAnswers.size == 5}")
            if (arrayAnswers.size == 5) {
                for (i in arrayAnswers.indices) {
                    if (i != arrayAnswers.lastIndex) {
                        showBackAnim(arrayAnswers[i])
                    }
                }
                goBack(backImageView)
                rowNumber = 1
                makeRowClickable()
                arrayAnswers.clear()
            }
        } else {
            if (arrayAnswers.size == 1) {
                goBack(backImageView)
            } else {
                for (i in arrayAnswers.indices) {
                    if (i != arrayAnswers.lastIndex) {
                        showBackAnim(arrayAnswers[i])
                    }
                }
                goBack(backImageView)
                rowNumber = 1
                makeRowClickable()
            }
            if (score != 0) {
                score -= 50
            }
            arrayAnswers.clear()
        }
        Log.d("SCORE", "SCORE = $score")
        binding.score.text = "$score points"
    }

    private fun goBackImage(backImageView: ImageView, id: Int, time: Long) {
        Handler().apply {
            val runnable = Runnable {
                backImageView.setImageResource(id)
            }
            postDelayed(runnable, time)
        }
    }

    private fun goBack(backImageView: ImageView) {
        Handler().apply {
            val runnable = Runnable {
                showBackAnim(backImageView)
            }
            postDelayed(runnable, 1000)
        }
    }


    private fun showBackAnim(backImageView: ImageView) {
        val scale = applicationContext?.resources?.displayMetrics?.density
        backImageView.cameraDistance = scale!! * 8000
        val frontImageView = binding.root.getViewById(backImageView.id + 25)
        frontImageView.cameraDistance = scale * 8000
        flip_anim = AnimatorInflater.loadAnimator(applicationContext , R.animator.rotation) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.back_flip) as AnimatorSet

        isFront = if (isFront) {
            flip_anim.setTarget(backImageView)
            back_anim.setTarget(frontImageView)
            flip_anim.start()
            back_anim.start()
            false
        } else{
            flip_anim.setTarget(backImageView)
            back_anim.setTarget(frontImageView)
            back_anim.start()
            flip_anim.start()
            true
        }

        flip_anim.addListener(object : AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
            }

            override fun onAnimationEnd(p0: Animator) {
                backImageView.setImageResource(R.drawable.cell_back)
                for (i in 0..4) {
                    if (secondRow[i].drawable == resources.getDrawable(R.drawable.ball)) {
                        secondRow[i].setImageResource(R.drawable.cell_back)
                    }
                    if (thirdRow[i].drawable == resources.getDrawable(R.drawable.ball)) {
                        thirdRow[i].setImageResource(R.drawable.cell_back)
                    }
                    if (fourthRow[i].drawable == resources.getDrawable(R.drawable.ball)) {
                        fourthRow[i].setImageResource(R.drawable.cell_back)
                    }
                    if (fifthRow[i].drawable == resources.getDrawable(R.drawable.ball)) {
                        fifthRow[i].setImageResource(R.drawable.cell_back)
                    }
                }
            }

            override fun onAnimationCancel(p0: Animator) {
            }

            override fun onAnimationRepeat(p0: Animator) {
            }
        })
    }

    private fun haveLink(): Boolean =
        File(applicationContext.filesDir, FILE_NAME)
            .exists()

    private fun textLink(): String =
        File(applicationContext.filesDir, FILE_NAME)
            .bufferedReader()
            .use { it.readText(); }

    private fun saveLink(url: String) {
        applicationContext.openFileOutput(
            FILE_NAME, Context.MODE_PRIVATE
        ).use {
            it.write(url.toByteArray())
        }
    }
    override fun onPause() {
        super.onPause()
        saveLink(score.toString())
    }
}