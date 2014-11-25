/*
 * 
 */
package idc.aast.test2;


import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class MyPagerAdapter.
 */
class MyPagerAdapter extends PagerAdapter {
    
    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    public int getCount() {
        return 5;
    }
    
    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#instantiateItem(android.view.View, int)
     */
    public Object instantiateItem(View collection, int position) {
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int resId = 0;
        switch (position) {
        case 0:
            resId = R.layout.activity_list_detail;
            break;
        case 1:
            resId = R.layout.activity_main;
            break;
    
        }
        View view = inflater.inflate(resId, null);
        ((ViewPager) collection).addView(view, 0);
        return view;
    }
    
    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#destroyItem(android.view.View, int, java.lang.Object)
     */
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }
    
    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#isViewFromObject(android.view.View, java.lang.Object)
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }
    
    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#saveState()
     */
    @Override
    public Parcelable saveState() {
        return null;
    }

}