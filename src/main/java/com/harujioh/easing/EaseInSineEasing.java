package com.harujioh.easing;

/**
 * sinusoidal easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInSineEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInSineEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return -valueRange * Math.cos(time / duration * (Math.PI / 2)) + valueRange + startValue;
	}
}
