package jp.harujioh.easing.in;

import jp.harujioh.easing.abstraction.CoefficientEasing;

/**
 * back easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class InBackEasing extends CoefficientEasing {

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
	public InBackEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration, 1.70158);
	}

	/**
	 * Constructor
	 * 
	 * @param startValue
	 *            返す値の開始値
	 * @param valueRange
	 *            値の変化値
	 * @param duration
	 *            変化の総時間
	 * @param coefficient
	 *            係数
	 */
	public InBackEasing(double startValue, double valueRange, double duration, double coefficient) {
		super(startValue, valueRange, duration, coefficient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		return valueRange * (time /= duration) * time * ((coefficient + 1) * time - coefficient) + startValue;
	}
}
