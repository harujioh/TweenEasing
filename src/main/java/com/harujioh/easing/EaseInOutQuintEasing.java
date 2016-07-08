package com.harujioh.easing;

/**
 * quintic easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class EaseInOutQuintEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutQuintEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		if ((time /= duration / 2) < 1)
			return valueRange / 2 * time * time * time * time * time + startValue;
		return valueRange / 2 * ((time -= 2) * time * time * time * time + 2) + startValue;
	}
}
