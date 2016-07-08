package com.harujioh.easing;

/**
 * back easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInBackEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInBackEasing(int startValue, int valueRange, int duration) {
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
	public EaseInBackEasing(int startValue, int valueRange, int duration, double coefficient) {
		super(startValue, valueRange, duration, coefficient);
	}

	@Override
	public double easing(double time) {
		double coefficient = this.coefficient.orElse(1.70158);
		return valueRange * (time /= duration) * time * ((coefficient + 1) * time - coefficient) + startValue;
	}
}
