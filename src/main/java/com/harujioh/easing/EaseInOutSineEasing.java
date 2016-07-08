package com.harujioh.easing;

/**
 * sinusoidal easing in/out - accelerating until halfway, then decelerating
 * 
 * @author harujioh
 */
public class EaseInOutSineEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutSineEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return -valueRange / 2 * (Math.cos(Math.PI * time / duration) - 1) + startValue;
	}
}
