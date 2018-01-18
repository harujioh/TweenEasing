package jp.harujioh.easing.out;

import jp.harujioh.easing.BaseEasing;

/**
 * back easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class OutBackEasing extends BaseEasing {

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
	public OutBackEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
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
	public OutBackEasing(double startValue, double valueRange, double duration, double coefficient) {
		super(startValue, valueRange, duration, coefficient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		double coefficient = this.coefficient.orElse(1.70158);
		return valueRange * ((time = time / duration - 1) * time * ((coefficient + 1) * time + coefficient) + 1)
				+ startValue;
	}
}
