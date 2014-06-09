/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.viewsforandroid.blinklayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Thank you Android team for giving birth to this layout!
 *
 * See <a href="http://bit.ly/1tMjeVK">http://bit.ly/1tMjeVK</a>
 *
 * Original implementation in <a href="http://bit.ly/1kCUtKT">http://bit.ly/1kCUtKT</a>
 */
public class BlinkLayout extends FrameLayout {

    private static final int MESSAGE_BLINK = 0x42;

    private static final int DEFAULT_BLINK_RATE = 500; // ms
    private static final boolean DEFAULT_START_BLINKING = true;

    private int mBlinkRate = DEFAULT_BLINK_RATE;

    private boolean mIsBlinking;
    private boolean mBlinkState;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == MESSAGE_BLINK) {
                if (mIsBlinking) {
                    mBlinkState = !mBlinkState;
                    makeBlink();
                }
                invalidate();
                return true;
            }
            return false;
        }
    });

    public BlinkLayout(Context context) {
        this(context, null);
    }

    public BlinkLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlinkLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BlinkLayout, 0, defStyle);
            mBlinkRate = a.getInt(R.styleable.BlinkLayout_blinkRate, DEFAULT_BLINK_RATE);
            a.recycle();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mIsBlinking = true;
        mBlinkState = true;
        makeBlink();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mIsBlinking = false;
        mBlinkState = false;
        mHandler.removeMessages(MESSAGE_BLINK);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mBlinkState) {
            super.dispatchDraw(canvas);
        }
    }

    private void makeBlink() {
        Message message = mHandler.obtainMessage(MESSAGE_BLINK);
        mHandler.sendMessageDelayed(message, mBlinkRate);
    }

}
