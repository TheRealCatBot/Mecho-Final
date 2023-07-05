package com.example.finaluri

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlin.random.Random
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class FlappyBird : AppCompatActivity() {

    private lateinit var ballView: View
    private var translationY = 0f
    private lateinit var textView: TextView
    private var vel = 0
    private lateinit var timerMain: Timer
    private lateinit var pipeRepeater: Timer
    private var isGravityOn=true
    private lateinit var videoView: VideoView
    private lateinit var container:View
    private var pipesOn=false
    private val random = Random.Default
    private var points=0
    private var attributed=false
    private lateinit var flap: MediaPlayer
    private lateinit var point: MediaPlayer
    private lateinit var die: MediaPlayer
    private lateinit var rootView: View
    private var isDead=false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flappy)

        videoView = findViewById(R.id.videoView)
        ballView = findViewById(R.id.ballView)
        container=findViewById<RelativeLayout>(R.id.container)
        textView=findViewById(R.id.textView)

        flap=MediaPlayer.create(this,R.raw.flap)
        point=MediaPlayer.create(this,R.raw.point)
        die=MediaPlayer.create(this,R.raw.die)

        rootView= findViewById(R.id.root)

        setVideoBackground()
        startGravity()

        rootView.setOnClickListener {
//            Log.d("random","$randomNumber")
            if(!isDead){
                timerMain.cancel()
                vel=0
                isGravityOn=false
                onScreenTap()
                if(!pipesOn){
                    startPipes()
                }
            }
        }
    }

    private fun startPipes(){
        pipesOn=true
        pipeRepeater = Timer()

        pipeRepeater .schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    makePipes()
                }
            }
        }, 0, 1100)
    }


    private fun makePipes(){
        Handler(Looper.getMainLooper()).postDelayed({
            val randomNumber = random.nextInt((300 - (-300)) / 100 + 1) * 100-300
//        val randomNumber=0
            container.let { containerView ->
                val pipe = ImageView(this)
                pipe.setImageResource(R.drawable.pipe)
                pipe.scaleX=0.5f
                pipe.scaleY=1f
//            Log.d("windows Height:",pipe.height.toString())
                pipe.translationY= 1350f-randomNumber
                pipe.translationX= 950f
                (containerView as ViewGroup).addView(pipe)

                val rotatedPipe = ImageView(this)
                rotatedPipe.setImageResource(R.drawable.pipe_rotated)
                rotatedPipe.scaleX=0.5f
                rotatedPipe.scaleY=1f
                rotatedPipe.translationX= 950f
                rotatedPipe.translationY= -350f-randomNumber
                containerView.addView(rotatedPipe)

                movePipes(pipe,rotatedPipe,randomNumber)
            }
        }, 1000)
    }

    private fun movePipes(pipe:ImageView,rotatedPipe:ImageView,rand:Int){
        var coordinateX=950f
        attributed=false
        val pipeTimer = Timer()

        pipeTimer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    coordinateX-=7f
                    pipe.translationX=coordinateX
                    rotatedPipe.translationX=coordinateX
                    hitReg(pipe,pipeTimer,rand)
                    if(coordinateX<=-550f){
                        deleteElement(pipe)
                        deleteElement(rotatedPipe)
                        pipeTimer.cancel()
                    }
                    if(isDead){
                       pipeTimer.cancel()
                    }
                }
            }
        }, 0, 7)
    }

    fun hitReg(pipe:ImageView,pipeTimer:Timer,rand:Int){
        if(pipe.translationX<=-25&&!attributed){

            points++
            textView.text=points.toString()
            point.start()

            attributed=true
            Log.d("points:","$points")
//            textView.text=points.toString()
        }

        if(((pipe.translationX>=-50)&&(pipe.translationX<=375))&&((ballView.translationY<=-325-rand)||(ballView.translationY>=300-rand))){
            Log.d("COLLISION","COLLISION DETECTED")
            isDead=true;
            die.start()
            videoView.pause()
            pipesOn = false
            isGravityOn = false
            // Cancel the timers
            timerMain.cancel()
            pipeRepeater.cancel()
            pipeTimer.cancel()
            restartButton()
        }
    }


    fun deleteElement(button: ImageView?) {
        button?.let {
            val parent = it.parent as? ViewGroup
            parent?.removeView(it)
        }
    }


    private fun setVideoBackground() {
        val videoPath = "android.resource://" + packageName + "/" + R.raw.giftest3

        videoView.setOnCompletionListener { mediaPlayer ->
            mediaPlayer.start()
        }

        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()


        val layoutParams = videoView.layoutParams as FrameLayout.LayoutParams
        layoutParams.setMargins(120, 0, 0, 200)
        videoView.layoutParams = layoutParams
    }


    private fun startGravity() {
//        Log.d("MainActivity", "TranslationY: $translationY")
        isGravityOn=true

        timerMain = Timer()
        var step=0
//        var period=7L
        timerMain.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    moveBallUp()
                    step++
                    if (step % 5 == 0) {
                        if(ballView.rotation<45){
                            ballView.rotation+=3.5f
                        }
                        vel += 2
                        if (vel > 16) {
                            vel = 16
                        }
                    }
                }
            }
        }, 0, 7)
    }


    private fun onScreenTap() {
        var step = 0
        val timer = Timer()
        val period=1L
        var tapVel=3f

        flap.start()

        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    translationY-=tapVel
                    ballView.translationY = translationY
                    step += 1
                    if (step % 5 == 0) {
                        tapVel -= 0.05f
                        if(ballView.rotation>0){
                            ballView.rotation-=3.5f
                        }
                        if (tapVel < 1.5) {
                            tapVel = 1.5f
                        }
                    }
                    if (step >= 185) {
                        timer.cancel()
                        if(!isGravityOn){
                            startGravity()
                        }
                    }
                }
            }
        }, 0, period)
    }

    private fun restartButton(){

        val button = ImageButton(this)
        button.setImageResource(R.drawable.restart)
        button.background = null
        button.scaleX=0.5f
        button.scaleY=0.5f
        button.translationY=+350f

        button.setOnClickListener {
            recreate()
        }
        (container as RelativeLayout?)?.addView(button)
    }


    private fun moveBallUp() {
        if(!pipesOn){
            return
        }

        translationY += vel
        ballView.translationY = translationY

//        if (translationY <= -1137 + ballView.height) {
//            vel = -vel
//        }
        if (translationY >= 1000) {
            vel = -vel
        }

    }
}