package com.harujioh.easing;

import java.util.Optional;

/**
 * イージングの抽象クラス
 * 
 * @author harujioh
 */
public abstract class BaseEasing {

	/**
	 * 返す値の開始値
	 */
	protected final double startValue;

	/**
	 * 値の変化値
	 */
	protected final double valueRange;

	/**
	 * 変化の総時間
	 */
	protected final double duration;

	/**
	 * 係数
	 */
	protected final Optional<Double> coefficient;

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
	public BaseEasing(double startValue, double valueRange, double duration) {
		this.startValue = startValue;
		this.valueRange = valueRange;
		this.duration = duration;
		this.coefficient = Optional.empty();
	}

	/**
	 * Constructor
	 * 
	 * @param startValue
	 *            返す値の開始値
	 * @param valueRange
	 *            値の変化値
	 * @param duration
	 *            変化の総時間
	 * @param coefficient
	 *            係数
	 */
	public BaseEasing(double startValue, double valueRange, double duration, double coefficient) {
		this.startValue = startValue;
		this.valueRange = valueRange;
		this.duration = duration;
		this.coefficient = Optional.of(Double.valueOf(coefficient));
	}

	/**
	 * イージングした値を取得します。
	 * 
	 * @param time
	 *            時間
	 * @return イージングした値
	 */
	public abstract double easing(double time);

	/**
	 * イージングした値を整数値で取得します。
	 * 
	 * @param time
	 *            時間
	 * @return イージングした値
	 */
	public int easingInt(double time) {
		return (int) this.easing(time);
	}
}
