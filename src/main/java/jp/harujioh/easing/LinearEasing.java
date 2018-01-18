package jp.harujioh.easing;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * simple linear - no easing, no acceleration
 * 
 * @author harujioh
 */
public class LinearEasing extends StandardEasing {

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
	public LinearEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return valueRange * time / duration + startValue;
	}
}
