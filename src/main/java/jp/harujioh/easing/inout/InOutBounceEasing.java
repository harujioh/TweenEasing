package jp.harujioh.easing.inout;

import jp.harujioh.easing.BaseEasing;
import jp.harujioh.easing.in.InBounceEasing;
import jp.harujioh.easing.out.OutBounceEasing;

/**
 * bounce easing in/out - acceleration until halfway, then deceleration
 * 
 * @author harujioh
 */
public class InOutBounceEasing extends BaseEasing {

	/**
	 * for calculation
	 */
	private final InBounceEasing easeIn;

	/**
	 * for calculation
	 */
	private final OutBounceEasing easeOut;

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
	public InOutBounceEasing(double startValue, double valueRange, double duration) {
		super(startValue, valueRange, duration);
		this.easeIn = new InBounceEasing(0, valueRange, duration);
		this.easeOut = new OutBounceEasing(0, valueRange, duration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double easing(double time) {
		if (time < duration / 2)
			return this.easeIn.easing(time * 2) * .5 + startValue;
		return this.easeOut.easing(time * 2 - duration) * .5 + valueRange * .5 + startValue;
	}
}
