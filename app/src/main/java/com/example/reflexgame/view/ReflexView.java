package com.example.reflexgame.view;

import android.animation.Animator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Handler;

public class ReflexView extends View {
    //static instance variable
    private static final String HIGH_SCORE = "HIGH_SCORE";
    private SharedPreferences preferences;

    //variable that manage the game
    private int spotsTouched;
    private int score;
    private int level;
    private int viewWidth;
    private int viewHeight;
    private long animationTime;   //how long each circle on the screen
    private boolean gameOver;
    private boolean gamePaused;
    private boolean dialogDisplayed;
    private int highScore;

    private final Queue<ImageView> spots = new ConcurrentLinkedDeque<>();   //execute safely
    private final Queue<Animator> animators = new ConcurrentLinkedDeque<>();

    private TextView tvHighScore;
    private TextView tvCurrentScore;
    private TextView tvLevel;
    private LinearLayout livesLinearLayout;
    private RelativeLayout relativeLayout;
    private Resources resources;
    private LayoutInflater layoutInflater;

    public static final int INITIAL_ANIMATION_DURATION = 6000;
    public static final Random random = new Random();
    public static final int SPOT_DIAMETER = 100;
    public static final float SCALE_X = 0.25f;
    public static final float SCALE_Y = 0.25f;
    public static final int INITIAL_SPOTS = 5;
    public static final int SPOT_DELAY = 500;
    public static final int LIVES = 3;
    public static final int MAX_LIVES = 7;
    public static final int NEW_LEVEL = 10;
    private Handler spotHandler;

    public static final int HIT_SOUND_ID = 1;
    public static final int MISS_SOUND_ID = 2;
    public static final int DISSAPEAR_SOUND_ID = 3;
    public static final int SOUND_PRIORITY = 1;
    public static final int SOUND_QUALITY = 100;
    public static final int MAX_STREAMS = 4;

    private SoundPool soundPool;
    private int volume;
    private Map<Integer, Integer> soundMap;

    public ReflexView(Context context, SharedPreferences sharedPreferences, RelativeLayout parentLayout) {
        super(context);
    }
}
