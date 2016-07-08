package com.harujioh.easing;

/**
 * circular easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutCircEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutCircEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * Math.sqrt(1 - (time = time / duration - 1) * time) + startValue;
	}
}
