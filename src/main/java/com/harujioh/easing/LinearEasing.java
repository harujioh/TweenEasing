package com.harujioh.easing;

/**
 * simple linear - no easing, no acceleration
 * 
 * @author harujioh
 */
public class LinearEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public LinearEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * time / duration + startValue;
	}
}
