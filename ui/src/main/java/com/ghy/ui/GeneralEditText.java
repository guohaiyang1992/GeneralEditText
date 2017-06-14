package com.ghy.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * 通用型EditText主要解决：特殊Rom下更改光标无效的情况
 * <p>
 * 使用方法：1.使用该控件
 * 2.使用自定义的属性 textCursorDrawable
 * <p>
 * 思路：通过反射的方法获取真正需要设置的对象，将用户设置的内容设置进去
 * <p>
 * Author:Simon date:2017.06.09
 */
public class GeneralEditText extends EditText {
    public GeneralEditText(Context context) {
        super(context);
    }

    public GeneralEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        modifyCursorDrawable(context, attrs);
    }

    public GeneralEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        modifyCursorDrawable(context, attrs);
    }


    private void modifyCursorDrawable(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GeneralEditText);
        int drawable = a.getResourceId(R.styleable.GeneralEditText_textCursorDrawable, 0);
        if (drawable != 0) {
            try {
                Field setCursor = TextView.class.getDeclaredField("mCursorDrawableRes");
                setCursor.setAccessible(true);
                setCursor.set(this, drawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        a.recycle();
    }
}
