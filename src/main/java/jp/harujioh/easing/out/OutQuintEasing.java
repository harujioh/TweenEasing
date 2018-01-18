package jp.harujioh.easing.out;

import jp.harujioh.easing.BaseEasing;

/**
 * quintic easing out - decelerating to zero velocity
 * 
 * @author harujioh
 */
public class OutQuintEasing extends BaseEasing {

	/**
	 * Constructor
	 * 
	 * @param startValue
	 *            返す値の開始値
	 * @param valueRange
	 *            値の変化値
	 * @param duration
	 *            変化の総時間
	 */
	public OutQuintEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		return valueRange * ((time = time / duration - 1) * time * time * time * time + 1) + startValue;
	}
}
