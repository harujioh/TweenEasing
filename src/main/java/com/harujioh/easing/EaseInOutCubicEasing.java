package com.harujioh.easing;

/**
 * cubic easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class EaseInOutCubicEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutCubicEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * time * time * time + startValue;
		return valueRange / 2 * ((time -= 2) * time * time + 2) + startValue;
	}
}
