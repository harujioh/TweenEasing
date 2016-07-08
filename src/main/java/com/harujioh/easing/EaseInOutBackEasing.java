package com.harujioh.easing;

/**
 * back easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class EaseInOutBackEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutBackEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 * @param coefficient
	 */
	public EaseInOutBackEasing(double startValue, double valueRange, double duration, double coefficient) {
		super(startValue, valueRange, duration, coefficient);
	}

	@Override
	public double easing(double time) {
		double coefficient = this.coefficient.orElse(1.70158);
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * (time * time * (((coefficient *= (1.525)) + 1) * time - coefficient)) + startValue;
		return valueRange / 2 * ((time -= 2) * time * (((coefficient *= (1.525)) + 1) * time + coefficient) + 2)
				+ startValue;
	}
}
