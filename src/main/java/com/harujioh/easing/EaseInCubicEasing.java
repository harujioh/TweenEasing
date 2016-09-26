package com.harujioh.easing;

/**
 * cubic easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInCubicEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInCubicEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * (time /= duration) * time * time + startValue;
	}
}
