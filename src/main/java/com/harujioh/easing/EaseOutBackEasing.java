package com.harujioh.easing;

/**
 * back easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutBackEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutBackEasing(double startValue, double valueRange, double duration) {
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
	public EaseOutBackEasing(double startValue, double valueRange, double duration, double coefficient) {
		super(startValue, valueRange, duration, coefficient);
	}

	@Override
	public double easing(double time) {
		double coefficient = this.coefficient.orElse(1.70158);
		return valueRange * ((time = time / duration - 1) * time * ((coefficient + 1) * time + coefficient) + 1)
				+ startValue;
	}
}
