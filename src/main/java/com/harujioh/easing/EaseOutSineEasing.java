package com.harujioh.easing;

/**
 * sinusoidal easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutSineEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 *            返す値の開始値
	 * @param valueRange
	 *            値の変化値
	 * @param duration
	 *            変化の総時間
	 */
	public EaseOutSineEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		return valueRange * Math.sin(time / duration * (Math.PI / 2)) + startValue;
	}
}
