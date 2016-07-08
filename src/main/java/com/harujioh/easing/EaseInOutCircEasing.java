package com.harujioh.easing;

/**
 * circular easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class EaseInOutCircEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutCircEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		if ((time /= duration / 2) < 1)
			return -valueRange / 2 * (Math.sqrt(1 - time * time) - 1) + startValue;
		return valueRange / 2 * (Math.sqrt(1 - (time -= 2) * time) + 1) + startValue;
	}
}