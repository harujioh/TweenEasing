package jp.harujioh.easing.out;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * bounce easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class OutBounceEasing extends StandardEasing {

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
	public OutBounceEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		if ((time /= duration) < (1 / 2.75)) {
			return valueRange * (7.5625 * time * time) + startValue;
		} else if (time < (2 / 2.75)) {
			return valueRange * (7.5625 * (time -= (1.5 / 2.75)) * time + .75) + startValue;
		} else if (time < (2.5 / 2.75)) {
			return valueRange * (7.5625 * (time -= (2.25 / 2.75)) * time + .9375) + startValue;
		} else {
			return valueRange * (7.5625 * (time -= (2.625 / 2.75)) * time + .984375) + startValue;
		}
	}
}
