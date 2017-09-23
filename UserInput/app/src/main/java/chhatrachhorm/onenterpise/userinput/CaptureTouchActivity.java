package chhatrachhorm.onenterpise.userinput;


import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


/**
 * Capturing Touch Event for the activity and the single view
 * https://developer.android.com/training/gestures/detector.html
 * */
public class CaptureTouchActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
{

    private static final String CTA_DEBUG = "CTA_DEBUG";
    private TextView mLog;


    private GestureDetectorCompat mDectetor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_touch);
        Toolbar mToolbar = findViewById(R.id.cta_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Capture Touch Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        instantiate gesture detector, set it as double tap listener
        mDectetor = new GestureDetectorCompat(this, this);
        mDectetor.setOnDoubleTapListener(this);


        mLog = findViewById(R.id.log_model_cta_log);
        mLog.setMovementMethod(new ScrollingMovementMethod());
        mLog.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                makeToast("You have touched me");
                return true;
            }
        });
    }


    // onTouchEvent callback is to intercept touch events in an activity

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDectetor.onTouchEvent(event);
        // getActionMasked() is to extract action performing
        // by user from event parameter
        int action = MotionEventCompat.getActionMasked(event);
        switch (action){
            case (MotionEvent.ACTION_DOWN):
                makeToast("Action was Down");
                // make sure not to return false in action down,
                // because it's the starting point of all action
                return true;
            case (MotionEvent.ACTION_MOVE):
                makeToast("Action was Moved");
                return true;
            case (MotionEvent.ACTION_UP):
                makeToast("Action was up");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                makeToast("Action was canceled");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                makeToast("Action was outside, out of current screen");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
    public void makeToast(String message){
        String old_message = mLog.getText().toString();
        if(old_message.length() > 100) old_message = old_message.substring(50);
        Long tsLong = System.currentTimeMillis()/1000;
        String datetime = tsLong.toString();
        message = datetime + ": " + message;
        mLog.setText(getString(R.string.cta_log, message, old_message));
        Log.d(CTA_DEBUG, message);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        makeToast("onDown: " + motionEvent.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float x, float y) {
        makeToast("onFling: " + motionEvent.toString() + motionEvent1.toString());
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        makeToast("onLongPress" + motionEvent.toString());
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float distanceX, float distanceY ) {
        makeToast("onScroll: " +distanceX+" "+distanceY+ motionEvent.toString() + motionEvent1.toString());
        if(Float.compare(distanceX, 0)>0)makeToast("Scroll left");
        else makeToast("Scroll right");
        if(Float.compare(distanceY, 0)<0)makeToast("Scroll down");
        else makeToast("Scroll up");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        makeToast("onShowPress: " + motionEvent.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        makeToast("OnSingleTapUp: "+ motionEvent.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        makeToast("onDoubleTap: "+ motionEvent.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        makeToast("OnSingleTapConfirmed: " + motionEvent.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        makeToast("OnDoubleTapEvent: " + motionEvent.toString());
        return true;
    }
}
