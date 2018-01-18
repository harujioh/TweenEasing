package jp.harujioh.easing;

/**
 * circular easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInCircEasing extends BaseEasing {

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
	public EaseInCircEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		return -valueRange * (Math.sqrt(1 - (time /= duration) * time) - 1) + startValue;
	}
}
