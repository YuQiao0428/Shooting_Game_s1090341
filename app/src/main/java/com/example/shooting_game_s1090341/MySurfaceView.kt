package com.example.shooting_game_s1090341

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class MySurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs),
    SurfaceHolder.Callback{

    var surfaceHolder: SurfaceHolder
    var BG: Bitmap
    var BGmoveX:Int = 0


    init {
        surfaceHolder = getHolder()
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.background)
        surfaceHolder.addCallback(this)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        var canvas: Canvas = surfaceHolder.lockCanvas()
        drawSomething(canvas)
        surfaceHolder.unlockCanvasAndPost(canvas)
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }

    fun drawSomething(canvas:Canvas) {
        var SrcRect: Rect = Rect(0, 0, BG.width, BG.height) //裁切
        var w:Int = width
        var h:Int = height
        var DestRect: Rect = Rect(0, 0, w, h)
        canvas.drawBitmap (BG, SrcRect, DestRect, null)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLUE
        paint.textSize = 50f
        canvas.drawText("射擊遊戲(作者:黃郁喬)",50f,50f,paint)


        //      BGmoveX --
        // var BGnewX:Int = w + BGmoveX

        // 如果已捲動整張圖，則重新開始
        /*if (BGnewX <= 0) {
            BGmoveX = 0
            // only need one draw
            canvas.drawBitmap(BG, BGmoveX.toFloat(), 0f, null)
        } else {
            // need to draw original and wrap
            var DestRect:Rect = Rect(BGmoveX, 0, BGmoveX+w, h)
            canvas.drawBitmap(BG, SrcRect, DestRect, null)
            DestRect = Rect(BGnewX, 0, BGnewX+w, h)
            canvas.drawBitmap(BG, SrcRect, DestRect, null)
        }*/


    }

}