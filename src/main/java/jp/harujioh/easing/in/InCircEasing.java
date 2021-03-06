package jp.harujioh.easing.in;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * circular easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class InCircEasing extends StandardEasing {

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
	public InCircEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return -valueRange * (Math.sqrt(1 - (time /= duration) * time) - 1) + startValue;
	}
}
