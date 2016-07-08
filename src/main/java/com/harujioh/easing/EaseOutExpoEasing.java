package com.harujioh.easing;

/**
 * exponential easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutExpoEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutExpoEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * (-Math.pow(2, -10 * time / duration) + 1) + startValue;
	}
}
