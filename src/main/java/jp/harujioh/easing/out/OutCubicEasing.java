package jp.harujioh.easing.out;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * cubic easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class OutCubicEasing extends StandardEasing {

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
	public OutCubicEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return valueRange * (((time = time / duration - 1)) * time * time + 1) + startValue;
	}
}
