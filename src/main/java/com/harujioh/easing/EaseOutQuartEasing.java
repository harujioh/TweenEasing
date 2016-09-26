package com.harujioh.easing;

/**
 * quartic easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutQuartEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutQuartEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return -valueRange * ((time = time / duration - 1) * time * time * time - 1) + startValue;
	}
}
