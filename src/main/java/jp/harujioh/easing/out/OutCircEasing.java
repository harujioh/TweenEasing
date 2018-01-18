package jp.harujioh.easing.out;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * circular easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class OutCircEasing extends StandardEasing {

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
	public OutCircEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return valueRange * Math.sqrt(1 - (time = time / duration - 1) * time) + startValue;
	}
}
