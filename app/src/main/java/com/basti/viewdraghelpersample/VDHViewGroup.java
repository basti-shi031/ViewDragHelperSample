package com.basti.viewdraghelpersample;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by SHIBW-PC on 2016/2/5.
 */
public class VDHViewGroup extends LinearLayout {

    private ViewDragHelper viewDragHelper;

    public VDHViewGroup(Context context) {
        this(context, null);
    }

    public VDHViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VDHViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        viewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return false;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        viewDragHelper.processTouchEvent(event);

        return true;
    }
}
