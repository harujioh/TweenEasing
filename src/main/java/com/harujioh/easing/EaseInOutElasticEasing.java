package com.harujioh.easing;

/**
 * elastically easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class EaseInOutElasticEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInOutElasticEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		double s = 1.70158, p = duration * (.3 * 1.5), a = valueRange;
		if (time == 0)
			return startValue;
		if ((time /= duration / 2) == 2)
			return startValue + valueRange;
		if (a < Math.abs(valueRange)) {
			a = valueRange;
			s = p / 4;
		} else
			s = p / (2 * Math.PI) * Math.asin(valueRange / a);
		if (time < 1)
			return -.5 * (a * Math.pow(2, 10 * (time -= 1)) * Math.sin((time * duration - s) * (2 * Math.PI) / p))
					+ startValue;
		return a * Math.pow(2, -10 * (time -= 1)) * Math.sin((time * duration - s) * (2 * Math.PI) / p) * .5
				+ valueRange + startValue;
	}
}
