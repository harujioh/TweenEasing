package jp.harujioh.easing;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

import jp.harujioh.easing.abstraction.CoefficientEasing;
import jp.harujioh.easing.abstraction.Easing;
import jp.harujioh.easing.abstraction.StandardEasing;
import jp.harujioh.easing.in.InBackEasing;
import jp.harujioh.easing.in.InBounceEasing;
import jp.harujioh.easing.in.InCircEasing;
import jp.harujioh.easing.in.InCubicEasing;
import jp.harujioh.easing.in.InElasticEasing;
import jp.harujioh.easing.in.InExpoEasing;
import jp.harujioh.easing.in.InQuadEasing;
import jp.harujioh.easing.in.InQuartEasing;
import jp.harujioh.easing.in.InQuintEasing;
import jp.harujioh.easing.in.InSineEasing;
import jp.harujioh.easing.inout.InOutBackEasing;
import jp.harujioh.easing.inout.InOutBounceEasing;
import jp.harujioh.easing.inout.InOutCircEasing;
import jp.harujioh.easing.inout.InOutCubicEasing;
import jp.harujioh.easing.inout.InOutElasticEasing;
import jp.harujioh.easing.inout.InOutExpoEasing;
import jp.harujioh.easing.inout.InOutQuadEasing;
import jp.harujioh.easing.inout.InOutQuartEasing;
import jp.harujioh.easing.inout.InOutQuintEasing;
import jp.harujioh.easing.inout.InOutSineEasing;
import jp.harujioh.easing.out.OutBackEasing;
import jp.harujioh.easing.out.OutBounceEasing;
import jp.harujioh.easing.out.OutCircEasing;
import jp.harujioh.easing.out.OutCubicEasing;
import jp.harujioh.easing.out.OutElasticEasing;
import jp.harujioh.easing.out.OutExpoEasing;
import jp.harujioh.easing.out.OutQuadEasing;
import jp.harujioh.easing.out.OutQuartEasing;
import jp.harujioh.easing.out.OutQuintEasing;
import jp.harujioh.easing.out.OutSineEasing;

/**
 * イージングの抽象クラス
 * 
 * @author harujioh
 */
public enum EasingType {

	/**
	 * @see LinearEasing
	 */
	LINEAR(LinearEasing.class),

	/**
	 * @see InQuadEasing
	 */
	IN_QUAD(InQuadEasing.class),

	/**
	 * @see OutQuadEasing
	 */
	OUT_QUAD(OutQuadEasing.class),

	/**
	 * @see InOutQuadEasing
	 */
	IN_OUT_QUAD(InOutQuadEasing.class),

	/**
	 * @see InCubicEasing
	 */
	IN_CUBIC(InCubicEasing.class),

	/**
	 * @see OutCubicEasing
	 */
	OUT_CUBIC(OutCubicEasing.class),

	/**
	 * @see InOutCubicEasing
	 */
	IN_OUT_CUBIC(InOutCubicEasing.class),

	/**
	 * @see InQuartEasing
	 */
	IN_QUART(InQuartEasing.class),

	/**
	 * @see OutQuartEasing
	 */
	OUT_QUART(OutQuartEasing.class),

	/**
	 * @see InOutQuartEasing
	 */
	IN_OUT_QUART(InOutQuartEasing.class),

	/**
	 * @see InQuintEasing
	 */
	IN_QUINT(InQuintEasing.class),

	/**
	 * @see OutQuintEasing
	 */
	OUT_QUINT(OutQuintEasing.class),

	/**
	 * @see InOutQuintEasing
	 */
	IN_OUT_QUINT(InOutQuintEasing.class),

	/**
	 * @see InSineEasing
	 */
	IN_SINE(InSineEasing.class),

	/**
	 * @see OutSineEasing
	 */
	OUT_SINE(OutSineEasing.class),

	/**
	 * @see InOutSineEasing
	 */
	IN_OUT_SINE(InOutSineEasing.class),

	/**
	 * @see InExpoEasing
	 */
	IN_EXPO(InExpoEasing.class),

	/**
	 * @see OutExpoEasing
	 */
	OUT_EXPO(OutExpoEasing.class),

	/**
	 * @see InOutExpoEasing
	 */
	IN_OUT_EXPO(InOutExpoEasing.class),

	/**
	 * @see InCircEasing
	 */
	IN_CIRC(InCircEasing.class),

	/**
	 * @see OutCircEasing
	 */
	OUT_CIRC(OutCircEasing.class),

	/**
	 * @see InOutCircEasing
	 */
	IN_OUT_CIRC(InOutCircEasing.class),

	/**
	 * @see InElasticEasing
	 */
	IN_ELASTIC(InElasticEasing.class),

	/**
	 * @see OutElasticEasing
	 */
	OUT_ELASTIC(OutElasticEasing.class),

	/**
	 * @see InOutElasticEasing
	 */
	IN_OUT_ELASTIC(InOutElasticEasing.class),

	/**
	 * @see InBackEasing
	 */
	IN_BACK(InBackEasing.class),

	/**
	 * @see OutBackEasing
	 */
	OUT_BACK(OutBackEasing.class),

	/**
	 * @see InOutBackEasing
	 */
	IN_OUT_BACK(InOutBackEasing.class),

	/**
	 * @see InBounceEasing
	 */
	IN_BOUNCE(InBounceEasing.class),

	/**
	 * @see OutBounceEasing
	 */
	OUT_BOUNCE(OutBounceEasing.class),

	/**
	 * @see InOutBounceEasing
	 */
	IN_OUT_BOUNCE(InOutBounceEasing.class),

	;

	/**
	 * イージングクラス
	 */
	private final Class<? extends Easing> easingClass;

	/**
	 * イージングクラスをもったコマンドを作成します。
	 * 
	 * @param easingClass
	 *            イージングクラス
	 */
	private EasingType(Class<? extends Easing> easingClass) {
		this.easingClass = easingClass;
	}

	/**
	 * 名前からイージングクラスを取得します。
	 * 
	 * @param name
	 *            名前
	 * @return イージングクラス
	 */
	public static Optional<Class<? extends Easing>> getEasingClass(String name) {
		return Arrays.stream(EasingType.values()) //
				.filter(e -> e.name().equals(name)) //
				.findAny() //
				.map(EasingType::getEasingClass);
	}

	/**
	 * イージングクラスを取得します。
	 * 
	 * @return イージングクラス
	 */
	public Class<? extends Easing> getEasingClass() {
		return this.easingClass;
	}

	/**
	 * イージングインスタンスを作成します。
	 * 
	 * @param startValue
	 *            返す値の開始値
	 * @param valueRange
	 *            値の変化値
	 * @param duration
	 *            変化の総時間
	 * @return イージングインスタンス
	 */
	public Easing standard(double startValue, double valueRange, double duration) {
		try {
			if (StandardEasing.class.isAssignableFrom(this.easingClass)) {
				return this.easingClass.getConstructor(double.class, double.class, double.class) //
						.newInstance(startValue, valueRange, duration);
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException("Undefined EasingStandardConstructor");
	}

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
	 * @return イージングインスタンス
	 */
	public Easing coefficient(double startValue, double valueRange, double duration, double coefficient) {
		try {
			if (CoefficientEasing.class.isAssignableFrom(this.easingClass)) {
				return this.easingClass.getConstructor(double.class, double.class, double.class, double.class) //
						.newInstance(startValue, valueRange, duration, coefficient);
			} else if (StandardEasing.class.isAssignableFrom(this.easingClass)) {
				return this.easingClass.getConstructor(double.class, double.class, double.class) //
						.newInstance(startValue, valueRange, duration);
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
		throw new RuntimeException("Undefined EasingStandardConstructor");
	}
}
