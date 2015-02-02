package idc.aast.edu.activities;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;


public class Animations {
    public Animation fromAtoB(float fromX, float fromY, float toX, float toY, AnimationListener l, int speed){


        Animation fromAtoB = new TranslateAnimation(

                fromX, 

                toX, 

                fromY, 

                toY
                );

        fromAtoB.setDuration(speed);
        //fromAtoB.setInterpolator(new );


        if(l != null)
            fromAtoB.setAnimationListener(l);               
        return fromAtoB;
    }
}


