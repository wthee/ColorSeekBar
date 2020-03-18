package cn.wthee.colorseekbar

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mColorSeekBar1= findViewById<ColorSeekBar>(R.id.color_seek_bar_1)
        val mColorSeekBar2= findViewById<ColorSeekBar>(R.id.color_seek_bar_2)
        val mTextView = findViewById<TextView>(R.id.text_color)
        //设置渐变颜色
        mColorSeekBar1.setBackgroundGradientColors(ColorSeekBar.DEFAULT_COLORS)
        //设置滑动监听
        mColorSeekBar1.setOnChangeListener(object : ColorSeekBar.OnChangeListener() {
            override fun onProgressChanged(seekBar: ColorSeekBar) {
                mColorSeekBar2.setBackgroundGradientColors(arrayListOf(
                    Color.BLACK,
                    seekBar.getThumbColor(),
                    Color.WHITE
                ))
                //更新第二个进度条
                mColorSeekBar2.postInvalidate()
                mTextView.setTextColor(mColorSeekBar2.getThumbColor())
            }
        })
        mColorSeekBar2.setOnChangeListener(object : ColorSeekBar.OnChangeListener() {
            override fun onProgressChanged(seekBar: ColorSeekBar) {
                mTextView.setTextColor(seekBar.getThumbColor())
            }
        })
    }
}
