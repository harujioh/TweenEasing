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
	 * @param valueRange
	 * @param duration
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
	 * @param valueRange
	 * @param duration
	 * @param coefficient
	 */
	public BaseEasing(double startValue, double valueRange, double duration, double coefficient) {
		this.startValue = startValue;
		this.valueRange = valueRange;
		this.duration = duration;
		this.coefficient = Optional.of(Double.valueOf(coefficient));
	}

	/**
	 * イージング値を取得
	 * 
	 * @param time
	 * @return
	 */
	public abstract double easing(double time);

	/**
	 * イージング値を取得
	 * 
	 * @param time
	 * @return
	 */
	public int easingInt(double time) {
		return (int) this.easing(time);
	}
}
