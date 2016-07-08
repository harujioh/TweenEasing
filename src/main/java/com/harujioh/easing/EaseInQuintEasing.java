package com.harujioh.easing;

/**
 * quintic easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInQuintEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInQuintEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * (time /= duration) * time * time * time * time + startValue;
	}
}
