package com.harujioh.easing;

/**
 * cubic easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutCubicEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutCubicEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * (((time = time / duration - 1)) * time * time + 1) + startValue;
	}
}
