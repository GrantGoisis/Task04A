package com.example.task04a

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class ViewOne: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
super(context, attrs, defStyleAttr)

    // Instantiate the GestureDetector with the application context
    // and an implementation of the GestureDetector.OnGestureListener interface
    private val myGestureDetector = GestureDetector(context, myGestureListener())

    init {
        // 'this' references the current class
        this.setBackgroundColor(Color.argb(128,32,64,255))
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return myGestureDetector.onTouchEvent(ev) || super.onTouchEvent(ev)

        /*val DEBUG_TAG = "MyTask"

        val action: Int = event.actionMasked

        val eventString = event.toString()
        Log.d(DEBUG_TAG, eventString)

        when (action) {
            MotionEvent.ACTION_DOWN ->{
                Log.d(DEBUG_TAG, "Action was Down")
                return true
            }
            MotionEvent.ACTION_MOVE ->{
                Log.d(DEBUG_TAG, "Action was Move")
                return true
            }
            MotionEvent.ACTION_UP ->{
                Log.d(DEBUG_TAG, "Action was Up")
                return true
            }
            MotionEvent.ACTION_CANCEL ->{
                Log.d(DEBUG_TAG, "Action was Cancel")
                return true
            }
            MotionEvent.ACTION_OUTSIDE ->{
                Log.d(DEBUG_TAG, "Action was Outside")
                return true
            }
            else -> return super.onTouchEvent(event)
        }*/

    }

    inner class myGestureListener: GestureDetector.SimpleOnGestureListener() {
        // Always include onDown() and it should always return, or
        // GestureListener will ignore following gestures
        override fun onDown(ev: MotionEvent): Boolean {
            return true
        }

        override fun onSingleTapUp(ev: MotionEvent): Boolean {
            // Access the event properties
            val xCoord = ev.x
            val yCoord = ev.y
            Log.d(LOGTAG, "SingleTapUp x = $xCoord y = $yCoord")
            Toast.makeText(context, "SingleTapUp x = $xCoord y = $yCoord", Toast.LENGTH_SHORT).show()
            return true
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            Log.d(LOGTAG, "DoubleTap")
            return true
        }

        override fun onFling( event1: MotionEvent, event2: MotionEvent,
                              velocityX: Float, velocityY: Float ): Boolean {
            Log.d(LOGTAG, "Fling")
            return true
        }
    }

    companion object {  // declare a constant - must be in the companion
       const val LOGTAG = "MyTask"
    }

}