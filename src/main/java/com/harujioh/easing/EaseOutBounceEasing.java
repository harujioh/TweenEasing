package com.harujioh.easing;

/**
 * bounce easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class EaseOutBounceEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseOutBounceEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		if ((time /= duration) < (1 / 2.75)) {
			return valueRange * (7.5625 * time * time) + startValue;
		} else if (time < (2 / 2.75)) {
			return valueRange * (7.5625 * (time -= (1.5 / 2.75)) * time + .75) + startValue;
		} else if (time < (2.5 / 2.75)) {
			return valueRange * (7.5625 * (time -= (2.25 / 2.75)) * time + .9375) + startValue;
		} else {
			return valueRange * (7.5625 * (time -= (2.625 / 2.75)) * time + .984375) + startValue;
		}
	}
}
