package jp.harujioh.easing.out;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * exponential easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class OutExpoEasing extends StandardEasing {

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
	public OutExpoEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return valueRange * (-Math.pow(2, -10 * time / duration) + 1) + startValue;
	}
}
