package jp.harujioh.easing.in;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * sinusoidal easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class InSineEasing extends StandardEasing {

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
	public InSineEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return -valueRange * Math.cos(time / duration * (Math.PI / 2)) + valueRange + startValue;
	}
}
