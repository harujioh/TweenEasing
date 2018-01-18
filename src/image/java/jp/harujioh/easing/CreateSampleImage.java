package jp.harujioh.easing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import jp.harujioh.easing.abstraction.Easing;

/**
 * サンプル画像を作成するメインクラス
 * 
 * @author harujioh
 */
public class CreateSampleImage {

	/**
	 * 実行クラス
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File path = Optional.of(args) //
				.filter(a -> a.length > 0) //
				.map(a -> new File(a[0])) //
				.filter(f -> f.isDirectory()) //
				.orElseThrow(() -> new RuntimeException("Invalid arguments: " + args[0]));
		int size = Optional.of(args) //
				.filter(a -> a.length > 1) //
				.map(a -> Integer.parseInt(a[1])) //
				.orElse(500);
		int length = Optional.of(args) //
				.filter(a -> a.length > 2) //
				.map(a -> Integer.parseInt(a[2])) //
				.orElse(100);

		new CreateSampleImage().create(path, size, length);
	}

	/**
	 * 画像を作成します。
	 * 
	 * @param parentDir
	 *            親ディレクトリ
	 * @param size
	 *            画像サイズ
	 * @param length
	 *            データ数
	 */
	private void create(File parentDir, int size, int length) {
		Arrays.stream(EasingType.values()) //
				.parallel() //
				.forEach(t -> {
					try {
						Easing easing = t.standard(0, 1, length);
						XYSeries series = IntStream.range(0, length) //
								.mapToObj(i -> i) //
								.collect(() -> new XYSeries("data"), (s, i) -> {
									s.add((double) i / length, easing.ease(i));
								}, (s1, s2) -> IntStream.range(0, s2.getItemCount()) //
										.forEach(i -> s1.add(s2.getX(i), s2.getY(i))));

						this.createGraph(new File(parentDir, String.format("%d_%s.png", t.ordinal(), t.name())), size,
								series);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
	}

	/**
	 * グラフを作成して出力する
	 * 
	 * @param file
	 *            出力ファイル
	 * @param size
	 *            グラフ幅
	 * @param series
	 *            グラフデータ
	 * @throws IOException
	 *             ファイルがない場合
	 */
	private void createGraph(File file, int size, XYSeries series) throws IOException {
		XYSeriesCollection trace = new XYSeriesCollection();
		trace.addSeries(series);

		JFreeChart chart = ChartFactory.createXYLineChart("", "", "", trace, PlotOrientation.VERTICAL, false, false,
				false);
		chart.setBackgroundPaint(ChartColor.WHITE);

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(ChartColor.WHITE);

		ValueAxis xAxis = plot.getDomainAxis();
		xAxis.setVisible(false);
		xAxis.setRange(0, series.getMaxX());

		ValueAxis yAxis = plot.getRangeAxis();
		yAxis.setVisible(false);
		yAxis.setRange(series.getMinY(), series.getMaxY());

		ChartUtilities.saveChartAsPNG(file, chart, size, size);
	}
}
