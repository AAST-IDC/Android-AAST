/*
 * 
 */

package idc.aast.Other;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
// TODO: Auto-generated Javadoc

/**
 * The Class VerticalTextView.
 */
public class VerticalTextView extends TextView {

    /** The _height. */
    private int _width, _height;
    
    /** The _bounds. */
    private final Rect _bounds = new Rect();

    /**
     * Instantiates a new vertical text view.
     *
     * @param context the context
     * @param attrs the attrs
     * @param defStyle the def style
     */
    public VerticalTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Instantiates a new vertical text view.
     *
     * @param context the context
     * @param attrs the attrs
     */
    public VerticalTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Instantiates a new vertical text view.
     *
     * @param context the context
     */
    public VerticalTextView(Context context) {
        super(context);
    }

    /* (non-Javadoc)
     * @see android.widget.TextView#onMeasure(int, int)
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // vise versa
        _height = getMeasuredWidth();
        _width = getMeasuredHeight();
        setMeasuredDimension(_width, _height);
    }

    /* (non-Javadoc)
     * @see android.widget.TextView#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();

        canvas.translate(_width, _height);
        canvas.rotate(-90);

        TextPaint paint = getPaint();
        paint.setColor(getTextColors().getDefaultColor());

        String text = text();

        paint.getTextBounds(text, 0, text.length(), _bounds);
        canvas.drawText(text, getCompoundPaddingLeft(), (_bounds.height() - _width) / 2, paint);

        canvas.restore();
    }

    /**
     * Text.
     *
     * @return the string
     */
    private String text() {
        return super.getText().toString();
    }
}