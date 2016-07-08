package com.harujioh.easing;

/**
 * quadratic easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class EaseInOutQuadEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutQuadEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * time * time + startValue;
		return -valueRange / 2 * (--time * (time - 2) - 1) + startValue;
	}
}
