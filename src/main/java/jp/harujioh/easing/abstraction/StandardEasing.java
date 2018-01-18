package jp.harujioh.easing.abstraction;

/**
 * 通常のパラメータをもつイージングの抽象クラスです。
 * 
 * @author harujioh
 */
public abstract class StandardEasing implements Easing {

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
	 * イージングインスタンスを作成します。
	 * 
	 * @param startValue
	 *            返す値の開始値
	 * @param valueRange
	 *            値の変化値
	 * @param duration
	 *            変化の総時間
	 */
	public StandardEasing(double startValue, double valueRange, double duration) {
		this.startValue = startValue;
		this.valueRange = valueRange;
		this.duration = duration;
	}
}
