package jp.harujioh.easing.abstraction;

/**
 * イージングインターフェース
 * 
 * @author harujioh
 */
public interface Easing {

	/**
	 * イージングした値を取得します。
	 * 
	 * @param time
	 *            時間
	 * @return イージングした値
	 */
	double ease(double time);

	/**
	 * イージングした値を整数値で取得します。
	 * 
	 * @param time
	 *            時間
	 * @return イージングした値
	 */
	default int easeInt(double time) {
		return (int) this.ease(time);
	}
}
