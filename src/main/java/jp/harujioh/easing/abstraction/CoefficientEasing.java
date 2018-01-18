package jp.harujioh.easing.abstraction;

/**
 * 係数をもつイージングの抽象クラスです。
 * 
 * @author harujioh
 */
public abstract class CoefficientEasing extends StandardEasing {

	/**
	 * 係数
	 */
	protected final double coefficient;

	/**
	 * イージングインスタンスを作成します。
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
	public CoefficientEasing(double startValue, double valueRange, double duration, double coefficient) {
		super(startValue, valueRange, duration);
		this.coefficient = coefficient;

	}
}
