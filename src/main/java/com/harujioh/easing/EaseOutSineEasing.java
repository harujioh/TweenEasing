package com.harujioh.easing;

/**
 * sinusoidal easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutSineEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutSineEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * Math.sin(time / duration * (Math.PI / 2)) + startValue;
	}
}
