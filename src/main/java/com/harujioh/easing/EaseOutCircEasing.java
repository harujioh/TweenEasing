package com.harujioh.easing;

/**
 * circular easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutCircEasing extends BaseEasing {

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
	public EaseOutCircEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		return valueRange * Math.sqrt(1 - (time = time / duration - 1) * time) + startValue;
	}
}
