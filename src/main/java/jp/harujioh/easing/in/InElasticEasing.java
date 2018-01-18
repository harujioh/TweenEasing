package jp.harujioh.easing.in;

import jp.harujioh.easing.BaseEasing;

/**
 * elastically easing in - accelerating from zero velocity
 * 
 * @author harujioh
 */
public class InElasticEasing extends BaseEasing {

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
	public InElasticEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		double s = 1.70158, p = duration * .3, a = valueRange;
		if (time == 0)
			return startValue;
		if ((time /= duration) == 1)
			return startValue + valueRange;
		if (a < Math.abs(valueRange)) {
			a = valueRange;
			s = p / 4;
		} else
			s = p / (2 * Math.PI) * Math.asin(valueRange / a);
		return -(a * Math.pow(2, 10 * (time -= 1)) * Math.sin((time * duration - s) * (2 * Math.PI) / p)) + startValue;
	}
}
