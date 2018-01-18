package jp.harujioh.easing.in;

import jp.harujioh.easing.BaseEasing;

/**
 * quartic easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class InQuartEasing extends BaseEasing {

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
	public InQuartEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		return valueRange * (time /= duration) * time * time * time + startValue;
	}
}
