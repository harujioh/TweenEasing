package com.harujioh.easing;

/**
 * exponential easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInExpoEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInExpoEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * Math.pow(2, 10 * (time / duration - 1)) + startValue;
	}
}
