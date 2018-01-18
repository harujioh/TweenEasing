package jp.harujioh.easing.inout;

import jp.harujioh.easing.abstraction.CoefficientEasing;

/**
 * back easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class InOutBackEasing extends CoefficientEasing {

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
	public InOutBackEasing(double startValue, double valueRange, double duration, double coefficient) {
		super(startValue, valueRange, duration, coefficient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double ease(double time) {
		double coefficient = this.coefficient;
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * (time * time * (((coefficient *= (1.525)) + 1) * time - coefficient)) + startValue;
		return valueRange / 2 * ((time -= 2) * time * (((coefficient *= (1.525)) + 1) * time + coefficient) + 2)
				+ startValue;
	}
}
