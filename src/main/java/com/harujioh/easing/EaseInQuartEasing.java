package com.harujioh.easing;

/**
 * quartic easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInQuartEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInQuartEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * (time /= duration) * time * time * time + startValue;
	}
}
