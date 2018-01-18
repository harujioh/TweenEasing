package jp.harujioh.easing.inout;

import jp.harujioh.easing.abstraction.StandardEasing;

/**
 * quartic easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class InOutQuartEasing extends StandardEasing {

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
	public InOutQuartEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * time * time * time * time + startValue;
		return -valueRange / 2 * ((time -= 2) * time * time * time - 2) + startValue;
	}
}
