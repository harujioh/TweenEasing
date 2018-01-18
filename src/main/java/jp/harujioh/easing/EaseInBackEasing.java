package jp.harujioh.easing;

/**
 * back easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInBackEasing extends BaseEasing {

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
	public EaseInBackEasing(double startValue, double valueRange, double duration) {
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
	public EaseInBackEasing(double startValue, double valueRange, double duration, double coefficient) {
		super(startValue, valueRange, duration, coefficient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		double coefficient = this.coefficient.orElse(1.70158);
		return valueRange * (time /= duration) * time * ((coefficient + 1) * time - coefficient) + startValue;
	}
}
