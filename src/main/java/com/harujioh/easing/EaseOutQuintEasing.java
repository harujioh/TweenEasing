package com.harujioh.easing;

/**
 * quintic easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutQuintEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutQuintEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange * ((time = time / duration - 1) * time * time * time * time + 1) + startValue;
	}
}
