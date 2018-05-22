package test.yixia.com.testapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangjian on 2018/5/18.
 */

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);


        // 用于warp_content情况下，来记录父view宽和高
        int width = 0;
        int height = 0;

        //行宽、行高
        int lineWidth = 0;
        int lineHeight = 0;

        int childsCount = getChildCount();
        for (int i = 0; i < childsCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + params.leftMargin + params.rightMargin;
            int childHeight = child.getMeasuredHeight() + params.topMargin + params.bottomMargin;

            if (lineWidth + childWidth > sizeWidth - getPaddingLeft() - getPaddingRight()) {
                width = Math.max(width, lineWidth);
                height += lineHeight;

                lineWidth = childWidth;
                lineHeight = childHeight;
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }

            if (i == childsCount - 1) {
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }
        }

        /**
         * EXACTLY对应match_parent或具体值
         * AT_MOST对应wrap_content
         * 在FlowLayout中
         * android:layout_width="match_parent"
         * android:layout_height="wrap_content"
         */
        if (modeWidth == MeasureSpec.EXACTLY) {
            modeWidth = sizeWidth;

        } else {
            modeWidth = width + getPaddingLeft() + getPaddingRight();
        }

        if (modeHeight == MeasureSpec.EXACTLY) {
            modeHeight = sizeHeight;
        } else {
            modeHeight = height + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(modeWidth,modeHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}
