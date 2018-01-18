package jp.harujioh.easing.inout;

import jp.harujioh.easing.BaseEasing;

/**
 * quintic easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class InOutQuintEasing extends BaseEasing {

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
	public InOutQuintEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * time * time * time * time * time + startValue;
		return valueRange / 2 * ((time -= 2) * time * time * time * time + 2) + startValue;
	}
}
