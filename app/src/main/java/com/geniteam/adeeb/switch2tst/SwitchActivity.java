package com.geniteam.adeeb.switch2tst;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SwitchActivity extends AppCompatActivity implements View.OnTouchListener{
    ImageView imageViewSwitch;

    //  int[] images=new int[]{R.drawable.switch5,R.drawable.switch4,R.drawable.switch3,R.drawable.switch2,R.drawable.switch1};
    //  int[] imageWithShades=new int[]{R.drawable.switch5with_shd,R.drawable.switch4with_shd,R.drawable.switch3with_shd, R.drawable.switch2with_shd,R.drawable.switch1with_shd};
    // int[] imageWithOutShades=new int[]{R.drawable.switch5with_out_shd,R.drawable.switch4with_out_shd,R.drawable.switch3with_out_shd, R.drawable.switch2with_out_shd,R.drawable.switch1with_out_shd};


    int[] imageWithShadesR = new int[]{R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r};
    int[] imageWithOutShadesR = new int[]{R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r};


    int[] imageWithShades = new int[]{R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd};
    int[] imageWithOutShades = new int[]{R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd};

    int lastState = 1;
    int currentState = 1;
    int stateCount = 1;
    int currentRule;
    TextView textViewState;
    TextView descripSwitchTv;
    TextView titleSwitchTv;
    RelativeLayout progressBar;

    String accesstokenTest = "Bearer 2875ddf0a944aee706516a495dd08727cefc6812";
    private GestureDetector mGestureDetector;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;

    Animation animation;
    float xc;
    float yc;
    int currentRoundAngle;
    int currentImageNumber = 4;
    double stateAngle = 0;
    int stateAngleImage = 0;
    double currentAngleActionUp;
    private double mPreAngle;
    int anglec=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        try {


            imageViewSwitch = (ImageView) findViewById(R.id.imageViewSwitch);
            textViewState = (TextView) findViewById(R.id.textViewState);
            descripSwitchTv = (TextView) findViewById(R.id.descripSwitchTv);
            titleSwitchTv = (TextView) findViewById(R.id.titleSwitchTv);
            progressBar = (RelativeLayout) findViewById(R.id.progressBarContainer);
            imageViewSwitch.setOnTouchListener(this);

            imageViewSwitch.setRotation(180);


            //     Utils.setFont(getApplicationContext(),titleSwitchTv);
            //Utils.setFont(getApplicationContext(),descripSwitchTv);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
    /*
               showProgressBar();
            if(AppPref.getQR_AccessTokenPref()!=null){
                String accessToken= ApiConstants.BEARER+" "+AppPref.getQR_AccessTokenPref().getAccessToken();
                GetCurrentAccountRule(accesstokenWithBreaer());
            }else {
               hideProgressBar();
               show_QR_Auth_ErrorDialogue();
            }
*/
                        //testing
                        // GetCurrentAccountRule(accesstokenTest);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, 20);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setCurrentSwitchAngle(int state) {
        if (state == 1) {
            stateAngle = 0;
            stateAngleImage = 4;
            animate(0, 0, 500);
            setSwitchBgWithOutShade(4);
        } else if (state == 2) {
            stateAngle = 72;
            stateAngleImage = 3;
            animate(0, 54, 500);
            setSwitchBgWithOutShade(3);
        } else if (state == 3) {
            stateAngle = 108;
            stateAngleImage = 2;
            animate(0, 90, 500);
            setSwitchBgWithOutShade(2);
        } else if (state == 4) {
            stateAngle = 144;
            stateAngleImage = 1;
            animate(0, 126, 500);
            setSwitchBgWithOutShade(1);
        } else if (state == 5) {
            stateAngle = 180;
            stateAngleImage = 0;
            animate(0, 180, 500);
            setSwitchBgWithOutShade(0);
        }
    }


    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }


    float lastTouchX;
    float lastTouchY;
    float x;
    float y;

    boolean swipeBotToTop;
    boolean swipeTopToBot;
    boolean swipeLeftToRight;
    boolean swipeRightToLeft;
    boolean isReachTop180 = false;
    boolean isReachBot0 = false;
    double newAngleReverse;
    boolean runLogic1 = true;
    boolean runLogic2 = true;
    double newAngle=0;
    int topThreShold=170;


    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        xc = v.getWidth() / 2;
        yc = v.getHeight() / 2;
        Log.d("debug66","ontouch");

      //  lastTouchX = x;
        // }
        // if(lastTouchY == 0) {
      //  lastTouchY = y;

       // if(lastTouchX == 0) {

        //}




       // setSwitchBgWithShade(currentImageNumber);


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                //  wheel.clearAnimation();
                //

lastTouchX=event.getX();
lastTouchY=event.getY();
                double tx = event.getX() - xc, ty = event.getY() - yc;
                double t_length = Math.sqrt(tx*tx + ty*ty);
                double a = Math.acos(ty / t_length);
              //  mPreAngle = mCurrAngle;
               // mPreAngle = getAngle(event.getX(),event.getY(),xc,yc);
                mPreAngle=  Math.toDegrees(Math.atan2(x - xc, yc - y));

                break;
            }
            case MotionEvent.ACTION_MOVE:
                Log.d("debug66","onmove");
//lastTouchY=y;
//lastTouchX=x;
                  x = event.getX();
                y = event.getY();

float dXL=lastTouchX-x;
                float dYL=lastTouchY-y;

            if(lastTouchX>x){
                dXL=lastTouchX-x;
            }else {
                dXL=x-lastTouchX;

            }

                if(lastTouchY>y){
                    dYL=lastTouchY-y;
                }else {
                    dYL=y-lastTouchY;

                }



              mCurrAngle = Math.toDegrees(Math.atan2(lastTouchY-y,lastTouchX-x));
//mCurrAngle+=45;

if(mCurrAngle<0){
    mCurrAngle+=360;
}


                double tx = event.getX() - xc, ty =  yc-event.getY();
                double t_length = Math.sqrt(tx*tx + ty*ty);
                double a = Math.acos(ty / t_length);
                //  mPreAngle = mCurrAngle;
              //  mCurrAngle = Math.toDegrees(a);
//mCurrAngle=getAngle(event.getX(),event.getY(),xc,yc);

             //  Log.d("debug66", "y " + y);
             //   Log.d("debug66", "lasty " + lastTouchY);
              //  Log.d("debug66", "x " + x);
               // Log.d("debug66", "lastX " + lastTouchX);
                Log.d("debug66", "currAngle " + mCurrAngle);
                Log.d("debug66", "lastAngle " + mPreAngle);
                int swipeUp=0;
                int swipeRight=0;
                int swipeLeft=0;
                int swipeDown=0;
                if(mCurrAngle<0){
                    //mCurrAngle+=180;
                    //Log.d("debug66", "after +180 " + mCurrAngle);
                }
                if(x>lastTouchX){

                    swipeRight++;
                }

                if(y>lastTouchY){

                    swipeUp++;
                }

                if(x<lastTouchX){

                    swipeLeft++;
                }

                if(y<lastTouchY){

                    swipeDown++;
                }

//if(mCurrAngle>mPreAngle)
                animate(mCurrAngle,mCurrAngle,0);




mPreAngle=mCurrAngle;



               //




                break;

            case MotionEvent.ACTION_UP:

                break;
        }
            return true;
        }
    private Double getAngle(float touchX, float touchY,float centerX, float centerY) {
        double angle;
        double x2 = touchX - centerX;
        double y2 = touchY - centerY;
        double d1 = Math.sqrt((centerY * centerY));
        double d2 = Math.sqrt((x2 * x2 + y2 * y2));
        if (touchX >= centerX) {
            angle = Math.toDegrees(Math.acos((-centerY * y2) / (d1 * d2)));
        } else
            angle = 360 - Math.toDegrees(Math.acos((-centerY * y2) / (d1 * d2)));
        return angle;
    }

        public void rot(MotionEvent event){
         ImageView   iv = (ImageView) findViewById(R.id.imageViewSwitch); // img view to rotate
            int touch_x = (int) event.getX(); // touch point x
            int touch_y = (int) event.getY(); // touch point y
            int[] location = new int[2];
            iv.getLocationInWindow(location);   // get img location on screen

            float angle = (float) Math.toDegrees(Math.atan2( touch_x - lastTouchX,    touch_y -   lastTouchY));

            if(angle < 0){
                angle += 360;
            }


            iv.setRotation(-angle);
        }

    public void setSwitchBgWithOutShade(final int i) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageViewSwitch.setImageResource(imageWithOutShades[i]);
            }
        }, 600);

    }


    public void setSwitchBgWithShade(final int i) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageViewSwitch.setImageResource(imageWithShades[i]);
            }
        }, 20);

    }

    public void callApiWithEndpoint(final int endPoint) {
        Log.d("debug4", "call api");

    }


    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        if(toDegrees > 165){
            toDegrees = 180;
        }
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        imageViewSwitch.startAnimation(rotate);


        System.out.println(mCurrAngle);
    }


    public void fadeIn(TextView textView) {
    }


    public void calculateCurrentMidAngle(double mCurrAngle) {
        double mid = mCurrAngle / 2;
        if (mid >= 18 && mid < 36) {
            animate(0, 0, 0);
        }

        if (mid < 18 && mid < 36) {
            animate(mCurrAngle, 36, 0);
        }

    }
}