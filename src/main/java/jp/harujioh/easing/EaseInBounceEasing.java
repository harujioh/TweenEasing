package jp.harujioh.easing;

/**
 * bounce easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInBounceEasing extends BaseEasing {

	/**
	 * for calculation
	 */
	private final EaseOutBounceEasing easeOut;

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
	public EaseInBounceEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
		this.easeOut = new EaseOutBounceEasing(0, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		return valueRange - this.easeOut.easing(duration - time) + startValue;
	}
}
