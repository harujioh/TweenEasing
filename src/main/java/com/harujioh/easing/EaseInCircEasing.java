package com.harujioh.easing;

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
	 * @param valueRange
	 * @param duration
	 */
	public EaseInCircEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return -valueRange * (Math.sqrt(1 - (time /= duration) * time) - 1) + startValue;
	}
}
