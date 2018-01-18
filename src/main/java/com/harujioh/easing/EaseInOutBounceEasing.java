package com.harujioh.easing;

/**
 * bounce easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class EaseInOutBounceEasing extends BaseEasing {

	/**
	 * for calculation
	 */
	private final EaseInBounceEasing easeIn;

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
	public EaseInOutBounceEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
		this.easeIn = new EaseInBounceEasing(0, valueRange, duration);
		this.easeOut = new EaseOutBounceEasing(0, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		if (time < duration / 2)
			return this.easeIn.easing(time * 2) * .5 + startValue;
		return this.easeOut.easing(time * 2 - duration) * .5 + valueRange * .5 + startValue;
	}
}
