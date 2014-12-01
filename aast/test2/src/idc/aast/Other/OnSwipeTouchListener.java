/*
 * 
 */
package idc.aast.Other;

import android.annotation.TargetApi;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
// TODO: Auto-generated Javadoc

/**
 * The listener interface for receiving onSwipeTouch events.
 * The class that is interested in processing a onSwipeTouch
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addOnSwipeTouchListener<code> method. When
 * the onSwipeTouch event occurs, that object's appropriate
 * method is invoked.
 *
 * @see OnSwipeTouchEvent
 */
@TargetApi(10)

public class OnSwipeTouchListener implements OnTouchListener {

    /** The gesture detector. */
    @SuppressWarnings("deprecation")
	private final GestureDetector gestureDetector = new GestureDetector(new GestureListener());

    /* (non-Javadoc)
     * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
     */
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    /**
     * The listener interface for receiving gesture events.
     * The class that is interested in processing a gesture
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addGestureListener<code> method. When
     * the gesture event occurs, that object's appropriate
     * method is invoked.
     *
     * @see GestureEvent
     */
    private final class GestureListener extends SimpleOnGestureListener {

        /** The Constant SWIPE_THRESHOLD. */
        private static final int SWIPE_THRESHOLD = 300;
        
        /** The Constant SWIPE_VELOCITY_THRESHOLD. */
        private static final int SWIPE_VELOCITY_THRESHOLD = 50;

        /* (non-Javadoc)
         * @see android.view.GestureDetector.SimpleOnGestureListener#onDown(android.view.MotionEvent)
         */
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        /* (non-Javadoc)
         * @see android.view.GestureDetector.SimpleOnGestureListener#onFling(android.view.MotionEvent, android.view.MotionEvent, float, float)
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeBottom();
                        } else {
                            onSwipeTop();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    /**
     * On swipe right.
     */
    public void onSwipeRight() {
    }

    /**
     * On swipe left.
     */
    public void onSwipeLeft() {
    }

    /**
     * On swipe top.
     */
    public void onSwipeTop() {
    }

    /**
     * On swipe bottom.
     */
    public void onSwipeBottom() {
    }
}