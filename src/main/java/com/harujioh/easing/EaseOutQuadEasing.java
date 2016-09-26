package com.harujioh.easing;

/**
 * quadratic easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutQuadEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutQuadEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return -valueRange * (time /= duration) * (time - 2) + startValue;
	}
}
