package com.harujioh.easing;

/**
 * exponential easing in/out - accelerating until halfway, then decelerating
 * 
 * @author harujioh
 */
public class EaseInOutExpoEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutExpoEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * Math.pow(2, 10 * (time - 1)) + startValue;
		return valueRange / 2 * (-Math.pow(2, -10 * --time) + 2) + startValue;
	}
}
