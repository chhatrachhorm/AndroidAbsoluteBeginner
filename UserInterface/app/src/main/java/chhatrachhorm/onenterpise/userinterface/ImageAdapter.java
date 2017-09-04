package chhatrachhorm.onenterpise.userinterface;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by chhormchhatra on 8/31/17.
 * To Make ImageAdapter works:
 *  1. Implement all the methods
 *  2. Make a constructor
 *  3. Override getView function
 */

public class ImageAdapter extends BaseAdapter{

    private Context mContext;

    // items
    private Integer[] images = {
            R.drawable.draw1, R.drawable.draw2,
            R.drawable.draw3, R.drawable.draw4,
            R.drawable.draw5, R.drawable.draw6,
            R.drawable.draw7, R.drawable.draw8,
    };


    // set up constructor
    ImageAdapter(Context ctx) {
        mContext = ctx;
    }

    // return number of items
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    // create a new image view for each grid
    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        ImageView imageView;
        // Initial if it's not recycle
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        }else{
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(images[position]);
        return imageView;
    }

}
