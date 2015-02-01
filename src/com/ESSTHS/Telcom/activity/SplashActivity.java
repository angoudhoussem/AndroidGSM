package com.ESSTHS.Telcom.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ttttt.R;

public class SplashActivity extends Activity implements AnimationListener {

	private static final int STOPSPLASH = 0;
	Animation animzoomout,animBlink;

	/**
	 * Durée de Splash Screen en millisecond
	 */
	private static final long SPLASHTIME = 6000;

	/**
	 * Handler pour fermer cette activité et commencer automatiquement
	 * automatically {MainActivity]
	 */
	private final transient Handler splashHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == STOPSPLASH) {
				/** le intent qui lance le MainAcitviy aprés 6 seconde */
				final Intent intent = new Intent(SplashActivity.this,
						Authentification.class);
				startActivity(intent);
				finish();
			}

			super.handleMessage(msg);
		}
	};

	/** Appel de l'activite lorsque elle est créer */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * // Pour cacher la barre de statut et donc mettre votre application en
		 * plein écran
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.acceuil);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/** Commencer l'animation de translate */
		StartAnimations();
	}

	private void StartAnimations() {
		super.onStart();
		/**
		 * commencer a lire le ficher audio intitulé sonsplash qui se trouve
		 * dans le dossier drawable de projet
		 */
		MediaPlayer mp = MediaPlayer.create(getApplicationContext(),
				R.drawable.sonsplash);
		mp.start();
		
		animzoomout = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
		animzoomout.reset();
		//imageView//
		ImageView iv = (ImageView) findViewById(R.id.imageView2);
		iv.setVisibility(View.VISIBLE);
		iv.clearAnimation();
		iv.startAnimation(animzoomout);
		
		//TextView/////////////
		animBlink = AnimationUtils.loadAnimation(this, R.anim.blink);
		animBlink.reset();
		TextView text = (TextView) findViewById(R.id.textView1);
		text.setVisibility(View.VISIBLE);
		text.clearAnimation();
		text.startAnimation(animBlink);
		
		
		final Message msg = new Message();
		msg.what = STOPSPLASH;
		splashHandler.sendMessageDelayed(msg, SPLASHTIME);
		animBlink.setAnimationListener(this);
		animzoomout.setAnimationListener(this);
	}

	/** Quiiter l'application on clickant sur la touche e retour */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			super.finish();
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onAnimationEnd(Animation animation) {
		// Take any action after completing the animation

		// check for blink animation
		if (animation == animBlink) {
		}

	}

	public void onAnimationRepeat(Animation animation) {

	}

	public void onAnimationStart(Animation animation) {

	}

}
/** Tous Droits réservés AndroidMag.ma © 2013 */
