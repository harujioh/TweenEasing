package com.harujioh.easing;

/**
 * bounce easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class EaseInBounceEasing extends BaseEasing {

	/**
	 * for calculation
	 */
	private final EaseOutBounceEasing easeOut;

	/**
	 * Constructor
	 * 
	 * @param startValue
	 * @param valueRange
	 * @param duration
	 */
	public EaseInBounceEasing(int startValue, int valueRange, int duration) {
		super(startValue, valueRange, duration);
		this.easeOut = new EaseOutBounceEasing(0, valueRange, duration);
	}

	@Override
	public double easing(double time) {
		return valueRange - this.easeOut.easing(duration - time) + startValue;
	}
}
