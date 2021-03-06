package com.andreaszeiser.jalousie;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.andreaszeiser.jalousie.indicator.IndicatorElement;
import com.andreaszeiser.jalousie.util.Log;

public class IndicatedLinearLayoutJalousie extends LinearLayout {

	private static final String TAG = IndicatedLinearLayoutJalousie.class
			.getSimpleName();

	/**
	 * Content gravity is based on the LinearLayout orientation mode.
	 * <code>LinearLayout.HORIZONTAL</code> leads to
	 * <code>Expandable.GRAVITY_HORIZONTAL</code>, otherwise this variable has a
	 * value of <code>Expandable.GRAVITY_VERTICAL</code>.
	 */
	private int mContentGravity;

	private LinearLayoutJalousie mLinearLayoutJalousie;

	private IndicatorElement mIndicator;

	public IndicatedLinearLayoutJalousie(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	public IndicatedLinearLayoutJalousie(Context context) {
		super(context);

		init();
	}

	private void init() {
		mContentGravity = (getOrientation() == LinearLayout.HORIZONTAL) ? Jalousie.GRAVITY_HORIZONTAL
				: Jalousie.GRAVITY_VERTICAL;

		Log.v(TAG, "[init] gravity="
				+ ((mContentGravity == LinearLayout.HORIZONTAL) ? "horizontal"
						: "vertical"));
	}

	@Override
	protected void onFinishInflate() {
		Log.v(TAG, "[onFinishInflate]");

		super.onFinishInflate();

		final int childCount = getChildCount();
		View view;
		for (int i = 0; i < childCount; i++) {
			view = getChildAt(i);

			if (view instanceof LinearLayoutJalousie) {
				mLinearLayoutJalousie = (LinearLayoutJalousie) view;
				mLinearLayoutJalousie.addJalousieListener(mJalousieListener);
			} else if (view instanceof IndicatorElement) {
				mIndicator = (IndicatorElement) view;
			}
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		Log.v(TAG, "[onSizeChanged] w=" + w + ", h=" + h + ", oldw=" + oldw
				+ ", oldh=" + oldh);

		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_UP:
			if (mLinearLayoutJalousie != null) {
				final Rect outRect = new Rect();
				mLinearLayoutJalousie.getHitRect(outRect);
				if (!outRect.contains((int) ev.getX(), (int) ev.getY())) {
					mLinearLayoutJalousie.toggle(true, true);
				}
			}
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}

	private JalousieListener mJalousieListener = new JalousieListener() {

		@Override
		public boolean onBeforeActionStart(int action, boolean fromTouch) {
			return false;
		}

		@Override
		public void onActionStart(final int action, final int animationDuration) {
		}

		@Override
		public void onActionEnd(int action) {
			switch (action) {
			case JalousieListener.ACTION_COLLAPSE:

				mIndicator.setState(IndicatorElement.STATE_EXPANDED);
				break;

			case JalousieListener.ACTION_EXPAND:

				mIndicator.setState(IndicatorElement.STATE_COLLAPSED);
				break;

			default:
				break;
			}
		}
	};

	public LinearLayoutJalousie getLinearLayoutJalousie() {
		return mLinearLayoutJalousie;
	}

	public IndicatorElement getIndicator() {
		return mIndicator;
	}
}
