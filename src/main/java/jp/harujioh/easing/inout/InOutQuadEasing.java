package jp.harujioh.easing.inout;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * quadratic easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class InOutQuadEasing extends StandardEasing {

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
	public InOutQuadEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * time * time + startValue;
		return -valueRange / 2 * (--time * (time - 2) - 1) + startValue;
	}
}
