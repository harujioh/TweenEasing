package com.harujioh.easing;

/**
 * exponential easing in/out - accelerating until halfway, then decelerating
 * 
 * @author harujioh
 */
public class EaseInOutExpoEasing extends BaseEasing {

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
	public EaseInOutExpoEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * Math.pow(2, 10 * (time - 1)) + startValue;
		return valueRange / 2 * (-Math.pow(2, -10 * --time) + 2) + startValue;
	}
}
