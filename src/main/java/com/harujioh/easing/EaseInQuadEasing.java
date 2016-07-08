package com.harujioh.easing;

/**
 * quadratic easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInQuadEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInQuadEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * (time /= duration) * time + startValue;
	}
}
