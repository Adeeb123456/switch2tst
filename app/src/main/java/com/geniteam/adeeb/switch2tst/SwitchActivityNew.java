package com.geniteam.adeeb.switch2tst;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geniteam.adeeb.switch2tst.R;


public class SwitchActivityNew extends AppCompatActivity implements View.OnTouchListener{
ImageView imageViewSwitch;

  //  int[] images=new int[]{R.drawable.switch5,R.drawable.switch4,R.drawable.switch3,R.drawable.switch2,R.drawable.switch1};
    int[] imageWithShades=new int[]{R.drawable.sw5,R.drawable.sw4,R.drawable.sw3,
            R.drawable.sw2,R.drawable.sw1};
    int[] imageWithOutShades=new int[]{R.drawable.sw5,R.drawable.sw4,R.drawable.sw3,
            R.drawable.sw2,R.drawable.sw1};

    int lastState=1;
    int currentState=1;
    int stateCount=1;
    int currentRule;
    TextView textViewState;
    TextView descripSwitchTv;
    TextView titleSwitchTv;
    RelativeLayout progressBar;
    boolean swipeUpToDown;

    boolean swipeDownToUp;
    String accesstokenTest="Bearer 2875ddf0a944aee706516a495dd08727cefc6812";
    private GestureDetector mGestureDetector;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;
  //  Call<ResponseBody> setAccountApiCall; //reson for making global is , so we can cancel previous request when switch moves

    Animation animation ;
    float xc;
    float yc;
    int currentRoundAngle;
    int currentImageNumber=4;
    double stateAngle=0;
    int stateAngleImage=0;
    double currentAngleActionUp;
    ImageView dialer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
try{



         imageViewSwitch=(ImageView)findViewById(R.id.imageViewSwitch);
         textViewState=(TextView)findViewById(R.id.textViewState);
         descripSwitchTv=(TextView)findViewById(R.id.descripSwitchTv);
         titleSwitchTv=(TextView)findViewById(R.id.titleSwitchTv);
         progressBar=(RelativeLayout)findViewById(R.id.progressBarContainer) ;
        // imageViewSwitch.setOnTouchListener(this);
       // imageViewSwitch.setRotation(180);

//nbew code


    // load the image only once
    if (imageOriginal == null) {
        imageOriginal = BitmapFactory.decodeResource(getResources(), R.drawable.sw1);
    }

    // initialize the matrix only once
    if (matrix == null) {
        matrix = new Matrix();
    } else {
        // not needed, you can also post the matrix immediately to restore the old state
        matrix.reset();
    }
    detector = new GestureDetector(this, new MyGestureDetector());
    // there is no 0th quadrant, to keep it simple the first value gets ignored
    quadrantTouched = new boolean[]{false, false, false, false, false};
    allowRotating = true;
    dialer = (ImageView) findViewById(R.id.imageViewSwitch);
    dialer.setRotation(180);
    dialer.setOnTouchListener(new MyOnTouchListener());
   // dialer.setOnTouchListener(this);
    dialer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

        @Override
        public void onGlobalLayout() {
            // method called more than once, but the values only need to be initialized one time
            // method called more than once, but the values only need to be initialized one time
            if (dialerHeight == 0 || dialerWidth == 0) {
                dialerHeight = dialer.getHeight();
                dialerWidth = dialer.getWidth();

                // resize
                Matrix resize = new Matrix();
                resize.postScale((float) Math.min(dialerWidth, dialerHeight) / (float) imageOriginal.getWidth(), (float) Math.min(dialerWidth, dialerHeight) / (float) imageOriginal.getHeight());
                imageScaled = Bitmap.createBitmap(imageOriginal, 0, 0, imageOriginal.getWidth(), imageOriginal.getHeight(), resize, false);

                // translate to the image view's center
                float translateX = dialerWidth / 2 - imageScaled.getWidth() / 2;
                float translateY = dialerHeight / 2 - imageScaled.getHeight() / 2;
                matrix.postTranslate(translateX, translateY);

                Drawable d = dialer.getDrawable();
                // TODO: check that d isn't null

                RectF imageRectF = new RectF(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                RectF viewRectF = new RectF(0, 0, dialer.getWidth(), dialer.getHeight());
                matrix.setRectToRect(imageRectF, viewRectF, Matrix.ScaleToFit.CENTER);
                dialer.setImageMatrix(matrix);

                dialer.setImageBitmap(imageScaled);
                dialer.setImageMatrix(matrix);
            }
        }
    });










    //bitmap













         /* Utils.setFont(getApplicationContext(),titleSwitchTv);
          Utils.setFont(getApplicationContext(),descripSwitchTv);*/


    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
try {
          /*     showProgressBar();
            if(AppPref.getQR_AccessTokenPref()!=null){
                String accessToken= ApiConstants.BEARER+" "+AppPref.getQR_AccessTokenPref().getAccessToken();
                GetCurrentAccountRule(accesstokenWithBreaer());
            }else {
               hideProgressBar();
               show_QR_Auth_ErrorDialogue();
            }*/

            //testing
   // GetCurrentAccountRule(accesstokenTest);


}catch (Exception e){
    e.printStackTrace();
}

        }
    },20);

}catch (Exception e){
    e.printStackTrace();
}
    }




public void setCurrentSwitchAngle(int state){
    if(state==1){
        stateAngle=0;
        stateAngleImage=4;
        animate(0,0,500);
        setSwitchBgWithOutShade(4);
    }else if(state==2){
        stateAngle=72;
        stateAngleImage=3;
        animate(0,54,500);
        setSwitchBgWithOutShade(3);
    }else if(state==3){
        stateAngle=108;
        stateAngleImage=2;
        animate(0,90,500);
        setSwitchBgWithOutShade(2);
    }else if(state==4){
        stateAngle=144;
        stateAngleImage=1;
        animate(0,136,500);
        setSwitchBgWithOutShade(1);
    }else if(state==5){
        stateAngle=180;
        stateAngleImage=0;
        animate(0,180,500);
        setSwitchBgWithOutShade(0);
    }
}




  /*  public String accesstokenWithBreaer(){
        String accessToken= ApiConstants.BEARER+" "+AppPref.getQR_AccessTokenPref().getAccessToken();
        return accessToken;
    }

public void inflateUI(final GetCurrentAccount getCurrentAccountModel){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getCurrentAccountModel==null){
                    titleSwitchTv.setText("");
                    descripSwitchTv.setText("");

                    return;
                }

             //   fadeIn(titleSwitchTv);
               // fadeIn(descripSwitchTv);
                titleSwitchTv.setText(getCurrentAccountModel.getTitle());
                descripSwitchTv.setText(getCurrentAccountModel.getDescription());
                setCurrentSwitchAngle(currentState);

            }
        },0);

}
    public void inflateUIAfterSwitchApi(final GetCurrentAccount getCurrentAccountModel){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(getCurrentAccountModel==null){
                    fadeOut(titleSwitchTv);
                    fadeOut(descripSwitchTv);

                    titleSwitchTv.setText("");
                    descripSwitchTv.setText("");

                    return;
                }


                fadeIn(titleSwitchTv);
                fadeIn(descripSwitchTv);
                titleSwitchTv.setText(getCurrentAccountModel.getTitle());
                descripSwitchTv.setText(getCurrentAccountModel.getDescription());


            }
        },10);

    }*/

/*
    class CustomGestureDetector implements GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
       //    Log.i("debug","onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            //Log.i("debug","onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
           // Log.i("debug","onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
          //  Log.i("debug","onSingleTapConfirmed");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
          //  Log.i("debug","onSingleTapConfirmed");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
          //  Log.i("debug","onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
           // Log.i("debug","onSingleTapConfirmed");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            //Log.i("debug","onSingleTapConfirmed");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
          //  Log.i("debug","onSingleTapConfirmed");

            if (e1.getX() < e2.getX()) {
                Log.d("debug", "Left to Right swipe performed");
                swipeLeftToRight=true;
               swipeRightToLeft=false;
            }

            if (e1.getX() > e2.getX()) {
                Log.d("debug", "Right to Left swipe performed");
                swipeRightToLeft=true;
                swipeLeftToRight=false;
            }

            if (e1.getY() < e2.getY()) {
                swipeUpToDown=true;
                Log.d("debug", "Up to Down swipe performed");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //uptodwn
                        if(currentState==5&&swipeRightToLeft)
                        //upToDownSwipe();
                        else if(currentState<5&&swipeLeftToRight||swipeRightToLeft)
                            upToDownSwipe();

                    }
                },5);

            }

            if (e1.getY() > e2.getY()) {
                Log.d("debug", "Down to Up swipe performed");
                swipeDownToUp=true;
                swipeUpToDown=false;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//down to up
                      if(currentState==1&&swipeRightToLeft)
                        downToUpSwipe();
                        else if(currentState>1&&swipeLeftToRight||swipeRightToLeft)
                            downToUpSwipe();
                    }
                },5);
            }
            return true;
        }
    }*/

/*

    public void downToUpSwipe(){
        lastState=stateCount;

        stateCount++;
        if(stateCount<=5){
         //   imageViewSwitch.setImageResource(images[stateCount-1]);
            currentState=stateCount;
           // cancelPreviousGetAccountApiCall();
            showProgressBar();
           settAccountRuleRawApiRequest(accesstokenWithBreaer(),currentState);
        }else {
            stateCount=5;
            currentState=5;
        }

        textViewState.setText(getString(R.string.current_state)+" :: "+currentState);
         //Log.d("debug1","current state "+currentState);
    }

    public void upToDownSwipe(){
        lastState=stateCount;

        stateCount--;

        if(stateCount>=1){
           // imageViewSwitch.setImageResource(images[stateCount-1]);
            currentState=stateCount;
           // cancelPreviousGetAccountApiCall();
            showProgressBar();
           settAccountRuleRawApiRequest(accesstokenWithBreaer(),currentState);
        }else {
            stateCount=1;
            currentState=1;
        }
      //  textViewState.setText(getString(R.string.current_state)+" :: "+currentState);
       // Log.d("debug1","current state "+currentState);
    }

    public void GetCurrentAccountRule(String qrAccessTokenString){

        if(!Utils.isNetworkAvailable(getApplicationContext())){
           // Log.d("debug","is network availble  "+Utils.isNetworkAvailable(getApplicationContext()));
            hideProgressBar();
            showInternetErrorDialogue();
            return;
        }


        Call<GetCurrentAccount> call= AppBase.service.getAccountRule(qrAccessTokenString);

        call.enqueue(new Callback<GetCurrentAccount>() {
            @Override
            public void onResponse(Call<GetCurrentAccount> call, Response<GetCurrentAccount> response) {
                GetCurrentAccount getCurrentAccountModel;
                JSONObject jsonObjectGetAccount=null;
                String statusMessage="",errorMessage="";
                JSONObject userJsonOjb = null;
                int rule;
                try {

                    if(response!=null&&response.isSuccessful()){
                        getCurrentAccountModel= response.body();
                        Gson gson=new Gson();
                        String json=gson.toJson(getCurrentAccountModel);
                        Log.d("debug"," response str "+json.toString());
                         currentRule=getCurrentAccountModel.getRule();
                       // Log.d("debug","rule "+currentRule);

                        currentState=currentRule;
                        stateCount=currentRule;
                        lastState=currentRule;

                        inflateUI(getCurrentAccountModel);

                    hideProgressBar();

                    }else {
                        hideProgressBar();
                        errorMessage=response.errorBody().string();
                        show_QR_Auth_ErrorDialogue();
                        inflateUI(null);

                      //  Log.d("debug","msg "+errorMessage);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    hideProgressBar();
                }


            }

            @Override
            public void onFailure(Call<GetCurrentAccount> call, Throwable t) {
                //Log.d("debug",call.toString());
                //Log.d("debug","error "+t.getMessage());
                hideProgressBar();
                showInternetErrorDialogue();
            }
        });
    }
    public void GetCurrentAccountRuleThroughSwitch(String qrAccessTokenString){

        if(!Utils.isNetworkAvailable(getApplicationContext())){
          //  Log.d("debug","is network availble  "+Utils.isNetworkAvailable(getApplicationContext()));
            hideProgressBar();
            showInternetErrorDialogue();
            return;
        }



        Call<GetCurrentAccount> call= AppBase.service.getAccountRule(qrAccessTokenString);

        call.enqueue(new Callback<GetCurrentAccount>() {
            @Override
            public void onResponse(Call<GetCurrentAccount> call, Response<GetCurrentAccount> response) {
                GetCurrentAccount getCurrentAccountModel;
                JSONObject jsonObjectGetAccount=null;
                String statusMessage="",errorMessage="";
                JSONObject userJsonOjb = null;
                int rule;
                try {

                    if(response!=null&&response.isSuccessful()){
                        getCurrentAccountModel= response.body();
                        Gson gson=new Gson();
                        String json=gson.toJson(getCurrentAccountModel);
                       Log.d("debug3"," response str "+json.toString());
                        currentRule=getCurrentAccountModel.getRule();
                       Log.d("debug","rule "+currentRule);



                        inflateUIAfterSwitchApi(getCurrentAccountModel);

                        hideProgressBar();

                    }else {
                        hideProgressBar();
                        errorMessage=response.errorBody().string();
                        show_QR_Auth_ErrorDialogue();
                        inflateUIAfterSwitchApi(null);


                      //  Log.d("debug","msg "+errorMessage);
                    }







                } catch (Exception e) {
                    e.printStackTrace();
                    hideProgressBar();
                }


            }

            @Override
            public void onFailure(Call<GetCurrentAccount> call, Throwable t) {
              //  Log.d("debug",call.toString());
              //  Log.d("debug","error "+t.getMessage());
                hideProgressBar();
                showInternetErrorDialogue();
            }
        });
    }

    public void settAccountRuleRawApiRequest(String qrAccessTokenString,int apiEndPoint){


      //  showProgressBar();
        fadeOut(titleSwitchTv);
        fadeOut(descripSwitchTv);
       // ApiConstants.SET_ACCOUNT_RULE_END_POINT=apiEndPoint+"".trim();

        setAccountApiCall= AppBase.service.setAccountRule(apiEndPoint+"".trim()
                ,
                         qrAccessTokenString);

        setAccountApiCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String getAccountString="";
                JSONObject jsonObjectGetAccount=null;
                String statusMessage="",errorMessage="";
                String currentRule="";
                try {

                    if(response!=null&&response.isSuccessful()){
                        getAccountString= response.body().string()+"";
                        Log.d("debug8"," response str "+getAccountString);
                        jsonObjectGetAccount=new JSONObject(getAccountString);
                      //  currentRule=jsonObjectGetAccount.getInt("rule")+"".trim();


                        GetCurrentAccountRuleThroughSwitch(accesstokenWithBreaer());



                    }else {
                        hideProgressBar();
                        errorMessage=response.errorBody().string();
                        Log.d("debug","msg "+errorMessage);
                        show_QR_Auth_ErrorDialogue();

                    }







                } catch (Exception e) {
                    e.printStackTrace();
                    hideProgressBar();
                    Log.d("debug","exception "+e);
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("debug",call.toString());
                Log.d("debug","error "+t.getMessage());
            hideProgressBar();

                if(setAccountApiCall.isCanceled()){
                    Log.d("debug"," req cancel state "+ApiConstants.SET_ACCOUNT_RULE_END_POINT);
                }else {
                    showInternetErrorDialogue();
                }
            }
        });
    }

    public void showInternetErrorDialogue() {
        final AlertDialog.Builder builder;

        View view= LayoutInflater.from(this).inflate(R.layout.error_internet_switch,null);
        TextView scanResult=(TextView)view.findViewById(R.id.textViewInternetError);
        TextView title=(TextView)view.findViewById(R.id.textViewInterneterror1) ;
        Utils.setTextViewGradient(getApplicationContext(),title);

        Button retryBtn=(Button)view.findViewById(R.id.buttonRetry);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, R.style.DialogThemeFullscreen);
        } else {
            builder = new AlertDialog.Builder(this,R.style.DialogThemeFullscreen);
        }

        Utils.setFontBtn(getApplicationContext(),retryBtn);
        Utils.setFont(getApplicationContext(),scanResult);
        Utils.setFont(getApplicationContext(),title);


        builder.setView(view);
        builder.setCancelable(false);


        final Dialog dialog=builder.create();
        dialog.show();

        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //tries to load idle switch
               loadIdleSwitch();

dialog.dismiss();

            }
        });
    }

    public void show_QR_Auth_ErrorDialogue() {
        final AlertDialog.Builder builder;

        View view= LayoutInflater.from(this).inflate(R.layout.error_qr_auth_switch,null);

        Button startQrBtn=(Button)view.findViewById(R.id.buttonStartQR);
        TextView tv=(TextView)view.findViewById(R.id.textView3Auth1);
        TextView title=(TextView)view.findViewById(R.id.textView2Auth1);
        Utils.setTextViewGradient(getApplicationContext(),title);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, R.style.DialogThemeFullscreen);
        } else {
            builder = new AlertDialog.Builder(this,R.style.DialogThemeFullscreen);
        }

        Utils.setFontBtn(getApplicationContext(),startQrBtn);
        Utils.setFont(getApplicationContext(),tv);
        Utils.setFont(getApplicationContext(),title);


        builder.setView(view);
        builder.setCancelable(false);


        final Dialog dialog=builder.create();
        dialog.show();
        startQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchIntent=new Intent(getApplicationContext(),QrCallbackActivity.class);
                switchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                switchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(switchIntent);
                dialog.dismiss();
                finish();
            }
        });

    }

    public void loadIdleSwitch(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {

                    if(!Utils.isNetworkAvailable(getApplicationContext())){
                      showInternetErrorDialogue();
                      return;
                    }
                   showProgressBar();
                    if(AppPref.getQR_AccessTokenPref()!=null){
                        String accessToken= ApiConstants.BEARER+" "+AppPref.getQR_AccessTokenPref().getAccessToken();
                       // Log.d("debug","beaere+accesstoken "+accessToken);
                        GetCurrentAccountRule(accessToken);
                    }

                    //test
                  //  GetCurrentAccountRule("Bearer a4c85caa6db2077afc018593c7bdff818bab12f21");


                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        },20);
    }


    public void showProgressBar(){
    progressBar.setVisibility(View.VISIBLE);
}

    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
*/

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
    private double mPreAngle=-1;
int countMove=0;

double checkedAngleTop=-1;
    double  previousCheckedAngleTop=-1;
int xSwipe;
int ySwipe;

float firstTimeX=-0;
float firstTimeTimeY=-0;

double firstTimeAngle=-0;

boolean outOfBond=false;


    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        xc = v.getWidth() / 2;
        yc = v.getHeight() / 2;

     if(x>v.getWidth()||y>v.getHeight()){
         outOfBond=true;
     }else {
         outOfBond=false;
     }

      //  Log.i("debug6", "img  x" + xc);
      //  Log.i("debug6", "img center y" + yc);

       // Log.i("debug89", "on touch x " + x);
      //  Log.i("debug89", "touch y " + y);




      checkedAngleTop=  Math.toDegrees(Math.atan2(x - xc, yc - y));

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                //  wheel.clearAnimation();
                //
                  countMove=0;
               mPrevAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));

              // mPreAngle = mCurrAngle;
               lastAngle=mCurrAngle;

                lastTouchX = event.getX();
                // }
                //if(lastTouchY == 0) {
                lastTouchY = event.getY();

                if(firstTimeX==-0){
                    firstTimeX=x;
                }

                if(firstTimeTimeY==-0){
                    firstTimeTimeY=y;
                }

               // if(firstTimeAngle==-0){
                    firstTimeAngle=Math.toDegrees(Math.atan2((lastTouchX-x) - xc, yc - (lastTouchY-y)));
              //  }

             //   Log.d("debug122","frstAnglee "+firstTimeAngle);
               // Log.d("debug122","frstX "+firstTimeX);
              //  Log.d("debug122","frstY "+firstTimeTimeY);
                break;
            }
            case MotionEvent.ACTION_MOVE:

               countMove++;
               if(countMove>10){
                 //  setSwitchBgWithShade(currentImageNumber);
if(!outOfBond){



    x = event.getX();
    y = event.getY();

    //  Log.d("debug","y "+y);
    //  Log.d("debug","x "+x);

    // mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));


    mCurrAngle = Math.toDegrees(Math.atan2(y - yc, xc - x));
    //  Log.i("debug5","action move previous angle "+mPrevAngle);
    //  Log.i("debug5","action move current angle "+mCurrAngle);
    // Log.d("debug16","curr angle "+mCurrAngle);

    if(y>=lastTouchY){
        rot++;
    }else {
      rot--;
    }

    if(x>lastTouchX){

    }else {

    }

    if(mCurrAngle<0){
        mCurrAngle+=180;
        //rot--;
    }else {
      //  rot--;
        runLogic1=false;
    }

    if(mCurrAngle>0){
        runLogic2=false;
        numberAngle++;

rotateDialer((float) (mPrevAngle-mCurrAngle));
        // Log.i("debug16","rotate img "+mCurrAngle);
        //  Log.i("debug3","current angle "+mCurrAngle);
        if(mCurrAngle>0&&mCurrAngle<=36){
            //  Log.d("debug12","36");
            currentRoundAngle=36;
            setSwitchBgWithShade(4);
            currentImageNumber=4;
            animate(mPreAngle, mCurrAngle, 0);
        }else if(mCurrAngle>36&&mCurrAngle<=72){
            //  Log.d("debug3","72");
            currentRoundAngle=72;
            setSwitchBgWithShade(3);
            currentImageNumber=3;
            animate(mPreAngle, mCurrAngle, 0);
        }else if(mCurrAngle>72&&mCurrAngle<=108){
            // Log.d("debug3","108");
            currentRoundAngle=108;
            setSwitchBgWithShade(2);
            currentImageNumber=2;
            animate(mPreAngle, mCurrAngle, 0);
        }else if(mCurrAngle>108&&mCurrAngle<=144){
            // Log.d("debug3","144");
            currentRoundAngle=144;
            setSwitchBgWithShade(1);
            currentImageNumber=1;
            animate(mPreAngle, mCurrAngle, 0);
        }else if(mCurrAngle>144&&mCurrAngle<=180){
            //   Log.d("debug12","180");
            currentRoundAngle=180;
            setSwitchBgWithShade(0);
            currentImageNumber=0;
            animate(mPreAngle, mCurrAngle, 0);
        }else {
            currentRoundAngle= (int) mCurrAngle;
        }
    }else {
        newAngle=mCurrAngle;
        runLogic1=false;
        //   Log.d("debug16"," logic 2 ");
        if (mCurrAngle < 0) {
            newAngle=mCurrAngle;
            newAngle = 180 + newAngle;
        }
        //  Log.d("debug16"," new angle  "+newAngle);
        if(y>=lastTouchY) {
            //  runLogic1=true;

            if (newAngle > mPreAngle) {
                mPreAngle = newAngle;
                if (newAngle > topThreShold) {
                    mPreAngle = 180;
                }
            }
            if (mPreAngle < 180) {
                numberAngle++;
                animate(mPreAngle, mCurrAngle, 0);

                if(newAngle>0&&newAngle<=36){
                    //  Log.d("debug3","36");
                    currentRoundAngle=36;
                    setSwitchBgWithShade(4);
                    currentImageNumber=4;

                }else if(newAngle>36&&newAngle<=72){
                    // Log.d("debug3","72");
                    currentRoundAngle=72;
                    setSwitchBgWithShade(3);
                    currentImageNumber=3;

                }else if(newAngle>72&&newAngle<=108){
                    //Log.d("debug3","108");
                    currentRoundAngle=108;
                    setSwitchBgWithShade(2);
                    currentImageNumber=2;

                }else if(newAngle>108&&newAngle<=144){
                    //  Log.d("debug3","144");
                    currentRoundAngle=144;
                    setSwitchBgWithShade(1);
                    currentImageNumber=1;

                }else if(newAngle>144&&newAngle<=180){
                    // Log.d("debug12","180");
                    currentRoundAngle=180;
                    setSwitchBgWithShade(0);
                    currentImageNumber=0;

                }
            }else {
                // currentRoundAngle=(int) mCurrAngle;
            }
        }else {
            if (newAngle <= mPreAngle) {
                mPreAngle = newAngle;
                if (newAngle < 10) {
                    newAngle = 0;
                }
            }
            if (newAngle > 0) {
                animate(mPreAngle, mCurrAngle, 0);
                // Log.d("debug17","angle "+newAngle);
                if(mCurrAngle>0&&mCurrAngle<=36){
                    //  Log.d("debug17","36");
                    currentRoundAngle=36;
                    setSwitchBgWithShade(4);
                    currentImageNumber=4;

                }else if(mCurrAngle>36&&mCurrAngle<=72){
                    // Log.d("debug17","72");
                    currentRoundAngle=72;
                    setSwitchBgWithShade(3);
                    currentImageNumber=3;

                }else if(mCurrAngle>72&&mCurrAngle<=108){
                    // Log.d("debug17","108");
                    currentRoundAngle=108;
                    setSwitchBgWithShade(2);
                    currentImageNumber=2;

                }else if(mCurrAngle>108&&mCurrAngle<=144){
                    //   Log.d("debug17","144");
                    currentRoundAngle=144;
                    setSwitchBgWithShade(1);
                    currentImageNumber=1;

                }else if(mCurrAngle>144&&mCurrAngle<=180){
                    //  Log.d("debug17","180");
                    currentRoundAngle=180;
                    setSwitchBgWithShade(0);
                    currentImageNumber=0;

                }
            }else {
                //  currentRoundAngle= (int) mCurrAngle;
            }

        }
    }
    lastTouchY=y;
    lastTouchX=x;
    mPrevAngle = mCurrAngle;
}
               }



             break;
            case MotionEvent.ACTION_UP : {
                // mPrevAngle =mCurrAngle ;

                if(countMove>10){
                    countMove=0;
                    double curAngle;
                curAngle=    currentAngleActionUp = Math.toDegrees(Math.atan2(x - xc, yc - y));
                    if (currentAngleActionUp < 0) {
                       // Log.d("debug9", "less than angle up" + currentAngleActionUp);
                        if (currentAngleActionUp < 0) {
                            currentAngleActionUp = currentAngleActionUp + 180;
                         //   Log.d("debug9", "less than angle +180 up" + currentAngleActionUp);
                        } else {
                            mCurrAngle = 180;
                        }
                    }
                  //  Log.d("debug4", " action up");
                  //  Log.i("debug5", "action up previous angle " + mPrevAngle);
                   // Log.i("debug5", "action up current angle " + mCurrAngle);
                    if (currentAngleActionUp >= 0 && currentAngleActionUp <= 180) {
                        if (currentRoundAngle == 36) {
                            callApiWithEndpoint(1);
                            animate(currentAngleActionUp, 0, 500);
                            setSwitchBgWithOutShade(4);
                            currentImageNumber = 4;
                        } else if (currentRoundAngle == 72) {
                            //   animate(72,72,400);
                            animate(currentAngleActionUp, 54, 500);
                            callApiWithEndpoint(2);
                            setSwitchBgWithOutShade(3);
                            currentImageNumber = 3;
                        } else if (currentRoundAngle == 108) {
                            // animate(108,108,400);
                            animate(currentAngleActionUp, 90, 500);
                            callApiWithEndpoint(3);
                            setSwitchBgWithOutShade(2);
                            currentImageNumber = 2;
                        } else if (currentRoundAngle == 144) {
                            //animate(144,144,400);
                            animate(currentAngleActionUp, 136, 500);
                            callApiWithEndpoint(4);
                            currentImageNumber = 1;
                            setSwitchBgWithOutShade(1);
                        } else if (currentRoundAngle == 180) {
                            animate(currentAngleActionUp, 180, 500);
                            callApiWithEndpoint(5);
                            currentImageNumber = 0;
                            setSwitchBgWithOutShade(0);
                        } else {
                                  if(currentRoundAngle!=-1){
                                      animate(135, 180, 500);

                                      callApiWithEndpoint(5);
                                      currentImageNumber = 0;
                                      setSwitchBgWithOutShade(0);
                                 }




                        }

                    } else {
                        // imageViewSwitch.setRotation((float) mCurrAngle);
                       // animate(mPrevAngle, mCurrAngle, 0);
                    }
                }


                //newAngle=-1;
               // lastTouchY = 0f;
               // lastTouchX = 0f;
               // mPreAngle =-1;

              //  mCurrAngle=-1;
                firstTimeAngle=-0;
                firstTimeTimeY=-0;
                firstTimeX=-0;
            }
        }
        return true;
    }


    public void setSwitchBgWithOutShade(final int i){
      new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        imageViewSwitch.setImageResource(imageWithOutShades[i]);
    }
},600);

    }


    public void setSwitchBgWithShade(final int i){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialer.setImageResource(imageWithShades[i]);
            }
        },20);

    }

    public void callApiWithEndpoint(final int endPoint){
               Log.d("debug4","call api");
              //  settAccountRuleRawApiRequest(accesstokenWithBreaer(),endPoint);

    }


    int rot=0;
    int lastrot=0;
         private void animate(double fromDegrees, double toDegrees, long durationMillis) {

           //  if(rot>=lastrot){
                 imageViewSwitch.setRotation((float) ((float) fromDegrees-toDegrees));
            // }else {
               //  imageViewSwitch.setRotation((float) ((float) -rot));
            // }

                        rot++;


           /*  if(toDegrees > 165){
                 toDegrees = 180;
             }
                final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotate.setDuration(durationMillis);
                rotate.setFillEnabled(true);
                rotate.setFillAfter(true);
                imageViewSwitch.startAnimation(rotate);


                System.out.println(mCurrAngle);*/
}


    private void animateWhenFirstTimeApiCall(double fromDegrees, double toDegrees, long durationMillis) {

        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        imageViewSwitch.startAnimation(rotate);


        System.out.println(mCurrAngle);
    }


     public void fadeIn(TextView textView){
       // animation= AnimationUtils.loadAnimation(SwitchActivity.this,R.anim.fade_in);
      //  textView.setAnimation(animation);
    }

          public void fadeOut(TextView textView){
       // animation= AnimationUtils.loadAnimation(SwitchActivity.this,R.anim.fade_out);
       // textView.setAnimation(animation);
    }

/*

          public void GetCurrentAccountRuleRaw(String qrAccessTokenString){


        Call<ResponseBody> call= AppBase.service.getAccountRuleRaw(qrAccessTokenString);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String getAccountString="";
                JSONObject jsonObjectGetAccount=null;
                String statusMessage="",errorMessage="";
                JSONObject userJsonOjb = null;
                try {

                    if(response.isSuccessful()){
                        getAccountString= response.body().string()+"";
                        Log.d("debug"," response str "+getAccountString);
                        jsonObjectGetAccount=new JSONObject(getAccountString);
                        Log.d("debug"," response json convert "+jsonObjectGetAccount);



                    }else {
                        errorMessage=response.errorBody().string();
                        Log.d("debug","msg "+errorMessage);
                    }







                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("debug",call.toString());
                Log.d("debug","error "+t.getMessage());
            }
        });
    }

          public void cancelPreviousGetAccountApiCall(){
        if(setAccountApiCall!=null){
            setAccountApiCall.cancel();
        }
    }
*/



    public void calculateCurrentMidAngle(double mCurrAngle){
        double mid=mCurrAngle/2;
        if(mid>=18&&mid<36){
animate(0,0,0);
        }

        if(mid<18&&mid<36){
            animate(mCurrAngle,36,0);
        }

    }


    public void actionMoveLogic1(MotionEvent event){

    }
    float lastY;
    double lastAngle;
    public void actionMoveLogic2TopBottomChecks(MotionEvent event){



    x = event.getX();
    y = event.getY();
    mPrevAngle = mCurrAngle;
    mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                if (mCurrAngle < 0) {
        mCurrAngle = 180 + mCurrAngle;
    }

        if(y>=lastY) {
        if (mCurrAngle > lastAngle) {
            lastAngle = mCurrAngle;
            if (mCurrAngle > 170) {
                lastAngle = 180;
            }
        }
        if (lastAngle < 180) {
            animate(mPrevAngle, mCurrAngle, 0);
        }
    }else {
        if (mCurrAngle <= lastAngle) {
            lastAngle = mCurrAngle;
            if (mCurrAngle < 10) {
                lastAngle = 0;
            }
        }
        if (lastAngle > 0) {
            animate(mPrevAngle, mCurrAngle, 0);
        }

    }
    }


    int numberAngle=0;
    public void actionMoveLogic360Rotation(double startAngle,double mCurrAngle){
        ;

//if(mCurrAngle)
  // startAngle-=70;

   //  mCurrAngle-=70;


//if(mCurrAngle>=0&&mCurrAngle<360){
    rotateDialer((float) (startAngle - mCurrAngle));


    Log.d("debug99", "cur " + mCurrAngle);

    // animate(mCurrAngle, mCurrAngle, 0);
    //if(mCurrAngle>=0&&mCurrAngle<=180){


    //animate(mCurrAngle, mCurrAngle, 0);


    Log.i("debug16", "rotate img " + mCurrAngle);
    Log.i("debug3", "current angle " + mCurrAngle);
    if (mCurrAngle > 0 && mCurrAngle <= 36) {
        Log.d("debug12", "36");
        currentRoundAngle = 36;
        setSwitchBgWithShade(0);
        currentImageNumber = 4;

    } else if (mCurrAngle > 36 && mCurrAngle <= 72) {
        Log.d("debug3", "72");
        currentRoundAngle = 72;
        setSwitchBgWithShade(1);
        currentImageNumber = 3;

    } else if (mCurrAngle > 72 && mCurrAngle <= 108) {
        Log.d("debug3", "108");
        currentRoundAngle = 108;
        setSwitchBgWithShade(2);
        currentImageNumber = 2;

    } else if (mCurrAngle > 108 && mCurrAngle <= 144) {
        Log.d("debug3", "144");
        currentRoundAngle = 144;
        setSwitchBgWithShade(3);
        currentImageNumber = 1;

    } else if (mCurrAngle > 144 && mCurrAngle <= 180) {
        Log.d("debug12", "180");
        currentRoundAngle = 180;
        setSwitchBgWithShade(4);
        currentImageNumber = 0;

    }
/*}else {

}*/



    }



    private static Bitmap imageOriginal, imageScaled;
    private static Matrix matrix;
  //  private ImageView dialer;
    private int dialerHeight, dialerWidth;

    private GestureDetector detector;
    // needed for detecting the inversed rotations
    private boolean[] quadrantTouched;
    private boolean allowRotating;


    private class MyOnTouchListener implements View.OnTouchListener {

        private double startAngle;

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:

                    // reset the touched quadrants
                    for (int i = 0; i < quadrantTouched.length; i++) {
                        quadrantTouched[i] = false;
                    }


                    allowRotating = false;

                    startAngle = getAngle(event.getX(), event.getY());
                    break;

                case MotionEvent.ACTION_MOVE:
                    double currentAngle = getAngle(event.getX(), event.getY());

                    if(currentAngle<0){
                       currentAngle+=180;
                    }

                    actionMoveLogic360Rotation(startAngle,currentAngle);


                    Log.d("debug100","angle "+currentAngle);

                    //   if(currentAngle>=90&&currentAngle<270){

                    // if(currentAngle>=0&&currentAngle<90){
                    //rotateDialer((float) (startAngle - currentAngle));
                    //  }
                    //  if(currentAngle>270&&currentAngle<360){
                  //  rotateDialer((float) (startAngle - currentAngle));
                    // }

                    //   }

                    startAngle = currentAngle;
                    break;

                case MotionEvent.ACTION_UP:
                    allowRotating = true;
                    break;
            }

            // set the touched quadrant to true
            quadrantTouched[getQuadrant(event.getX() - (dialerWidth / 2), dialerHeight - event.getY() - (dialerHeight / 2))] = true;

            detector.onTouchEvent(event);

            return true;
        }


    }


    private class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            // get the quadrant of the start and the end of the fling
            int q1 = getQuadrant(e1.getX() - (dialerWidth / 2), dialerHeight - e1.getY() - (dialerHeight / 2));
            int q2 = getQuadrant(e2.getX() - (dialerWidth / 2), dialerHeight - e2.getY() - (dialerHeight / 2));

            // the inversed rotations
            if ((q1 == 2 && q2 == 2 && Math.abs(velocityX) < Math.abs(velocityY))
                    || (q1 == 3 && q2 == 3)
                    || (q1 == 1 && q2 == 3)
                    || (q1 == 4 && q2 == 4 && Math.abs(velocityX) > Math.abs(velocityY))
                    || ((q1 == 2 && q2 == 3) || (q1 == 3 && q2 == 2))
                    || ((q1 == 3 && q2 == 4) || (q1 == 4 && q2 == 3))
                    || (q1 == 2 && q2 == 4 && quadrantTouched[3])
                    || (q1 == 4 && q2 == 2 && quadrantTouched[3])) {

                dialer.post(new FlingRunnable(-1 * (velocityX + velocityY)));
            } else {
                // the normal rotation
                dialer.post(new FlingRunnable(velocityX + velocityY));
            }

            return true;

        }
    }
    private class FlingRunnable implements Runnable {

        private float velocity;

        public FlingRunnable(float velocity) {
            this.velocity = velocity;
        }

        @Override
        public void run() {
            if (Math.abs(velocity) > 5 && allowRotating) {
                rotateDialer(velocity / 75);
                velocity /= 1.0666F;

                // post this instance again
                //dialer.post(this);
            }
        }
    }


    private double getAngle(double xTouch, double yTouch) {
        double x = xTouch - (dialerWidth / 2d);
        double y =  dialerHeight-yTouch - (dialerHeight / 2d);

     return   Math.toDegrees(Math.atan2( y, x));


         /*   switch (getQuadrant(x, y)) {
                case 1:
                    return Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;
                case 2:
                    return 180 - Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;
                case 3:
                    return 180 + (-1 * Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI);
                case 4:
                    return 360 + Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;
                default:
                    return 0;
            }*/


    }

    /**
     * @return The selected quadrant.
     */
    private static int getQuadrant(double x, double y) {
        if (x >= 0) {
            return y >= 0 ? 1 : 4;
        } else {
            return y >= 0 ? 2 : 3;
        }
    }

    private void rotateDialer(float degrees) {



        matrix.postRotate(degrees, dialerWidth / 2, dialerHeight / 2);

        dialer.setImageMatrix(matrix);


    }


}