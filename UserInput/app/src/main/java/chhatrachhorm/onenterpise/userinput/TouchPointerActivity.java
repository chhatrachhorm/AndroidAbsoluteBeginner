package chhatrachhorm.onenterpise.userinput;

import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class TouchPointerActivity extends AppCompatActivity {

    private TextView mLog, mLogTitle;
    private static final String TPA_DEBUG = "TPA_DEBUG";

    private VelocityTracker mVelocityTracker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_pointer);
        RelativeLayout mView;
        mView = findViewById(R.id.atp_log);
        mLog = mView.findViewById(R.id.log_model_cta_log);
        mLogTitle = mView.findViewById(R.id.log_model_cta_name);
        mLogTitle.setText(R.string.tpa_log);

        Toolbar mToolbar = findViewById(R.id.atp_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Touch Pointer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        // int action = MotionEventCompat.getActionMasked(event);
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);

        switch (action){
            case MotionEvent.ACTION_DOWN:
                if(mVelocityTracker == null){
                    // retrieve new Velocity Obj to watch velocity of a motion
                    mVelocityTracker = VelocityTracker.obtain();
                }else {
                    // reset the velocity tracker back to initial state
                    mVelocityTracker.clear();
                }
                // add a user's movement to tracker
                mVelocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                // to determine velocity
                mVelocityTracker.computeCurrentVelocity(1000);
                makeLog("X velocity: " +
                        VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId)
                );
                makeLog("Y velocity: " +
                        VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId)
                );
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // return a velocity tracker obj back to be reused
                mVelocityTracker.recycle();
                break;
        }

        return true;
//        return super.onTouchEvent(event);
    }

    public void makeLog(String message){
        String old_message = mLog.getText().toString();
        Long tsLong = System.currentTimeMillis()/1000;
        String datetime = tsLong.toString();
        message = datetime + ": " + message;
        mLog.setText(getString(R.string.cta_log, message, old_message));
        Log.d(TPA_DEBUG, message);
    }
}
