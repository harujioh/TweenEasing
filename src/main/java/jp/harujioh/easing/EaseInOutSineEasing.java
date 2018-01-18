package jp.harujioh.easing;

/**
 * sinusoidal easing in/out - accelerating until halfway, then decelerating
 * 
 * @author harujioh
 */
public class EaseInOutSineEasing extends BaseEasing {

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
	public EaseInOutSineEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		return -valueRange / 2 * (Math.cos(Math.PI * time / duration) - 1) + startValue;
	}
}
