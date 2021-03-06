package jp.harujioh.easing.inout;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * sinusoidal easing in/out - accelerating until halfway, then decelerating
 * 
 * @author harujioh
 */
public class InOutSineEasing extends StandardEasing {

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
	public InOutSineEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return -valueRange / 2 * (Math.cos(Math.PI * time / duration) - 1) + startValue;
	}
}
