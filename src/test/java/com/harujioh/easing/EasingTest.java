package com.harujioh.easing;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.reflections.Reflections;

import javafx.geometry.Point2D;

/**
 * 各イージングのグラフ描画テスト
 * 
 * @author harujioh
 */
public class EasingTest {

	/**
	 * 実行
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new EasingTest().start();
	}

	/**
	 * プロットする点の数
	 */
	private final int PLOT_LENGTH = 1000;

	/**
	 * マージン
	 */
	private final float MARGIN = 0.1f;

	/**
	 * 現在のイージング
	 */
	private Optional<BaseEasing> easing = Optional.empty();

	/**
	 * 実行
	 */
	private void start() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		shell.setMinimumSize(500, 500);

		// add selectbox
		Combo selectbox;
		Map<String, Class<? extends BaseEasing>> selectboxItems;
		{
			Composite group = new Composite(shell, SWT.NONE);
			GridLayout layout = new GridLayout(1, false);
			layout.marginWidth = 100;
			group.setLayout(layout);
			group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			selectbox = new Combo(group, SWT.READ_ONLY);
			selectbox.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			Reflections reflections = new Reflections(this.getClass().getPackage().getName());
			selectboxItems = reflections.getSubTypesOf(BaseEasing.class).stream()
					.collect(Collectors.toMap(c -> c.getSimpleName(), c -> c));

			selectbox.setItems(selectboxItems.keySet().toArray(new String[selectboxItems.size()]));
		}

		// add draw area
		Canvas canvas;
		{
			Composite group = new Composite(shell, SWT.NONE);
			group.setLayout(new GridLayout(1, false));
			group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));

			canvas = new Canvas(group, SWT.NONE);
			canvas.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
			canvas.addListener(SWT.Paint, event -> {
				Rectangle bounds = event.getBounds();
				GC gc = event.gc;

				gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
				gc.fillRectangle(bounds);

				this.easing.ifPresent(e -> {
					List<Point2D> points = IntStream.rangeClosed(0, PLOT_LENGTH) //
							.mapToDouble(i -> (double) i / PLOT_LENGTH) //
							.mapToObj(d -> new Point2D(d, e.easing(d))) //
							.collect(Collectors.toList());
					double minY = points.stream().mapToDouble(p -> p.getY()).min().orElse(0);
					double maxY = points.stream().mapToDouble(p -> p.getY()).max().orElse(1);

					int x1 = (int) this.map(1, -MARGIN, 1 + MARGIN, bounds.x, bounds.x + bounds.width);
					int y1 = (int) this.map(1, minY - MARGIN, maxY + MARGIN, bounds.y + bounds.height, bounds.y);
					gc.setLineWidth(1);
					gc.setForeground(display.getSystemColor(SWT.COLOR_GRAY));
					gc.drawLine(x1, bounds.y, x1, bounds.y + bounds.height);
					gc.drawLine(bounds.x, y1, bounds.x + bounds.width, y1);

					int x0 = (int) this.map(0, -MARGIN, 1 + MARGIN, bounds.x, bounds.x + bounds.width);
					int y0 = (int) this.map(0, minY - MARGIN, maxY + MARGIN, bounds.y + bounds.height, bounds.y);
					gc.setLineWidth(2);
					gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
					gc.drawLine(x0, bounds.y, x0, bounds.y + bounds.height);
					gc.drawLine(bounds.x, y0, bounds.x + bounds.width, y0);

					gc.setLineWidth(3);
					gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
					Point2D initPoint = points.remove(0);
					points.stream().reduce(initPoint, (p1, p2) -> {
						int p1x = (int) this.map(p1.getX(), -MARGIN, 1 + MARGIN, bounds.x, bounds.x + bounds.width);
						int p1y = (int) this.map(p1.getY(), minY - MARGIN, maxY + MARGIN, bounds.y + bounds.height,
								bounds.y);
						int p2x = (int) this.map(p2.getX(), -MARGIN, 1 + MARGIN, bounds.x, bounds.x + bounds.width);
						int p2y = (int) this.map(p2.getY(), minY - MARGIN, maxY + MARGIN, bounds.y + bounds.height,
								bounds.y);
						gc.drawLine(p1x, p1y, p2x, p2y);
						return p2;
					});
					// ;. .forEach(p -> {
					// });
				});
			});
		}

		// event
		selectbox.addModifyListener(event -> {
			Class<? extends BaseEasing> easingClass = selectboxItems.get(selectbox.getText());
			try {
				Constructor<? extends BaseEasing> constructor = easingClass.getConstructor(double.class, double.class,
						double.class);
				easing = Optional.of(constructor.newInstance(0, 1, 1));

				canvas.redraw();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// select default
		if (selectbox.getItemCount() > 0) {
			selectbox.select(0);
		}

		// show
		shell.pack();
		shell.open();

		// join
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	/**
	 * 範囲変換
	 * 
	 * @param value
	 * @param inputMin
	 * @param inputMax
	 * @param outputMin
	 * @param outputMax
	 * @return
	 */
	private double map(double value, double inputMin, double inputMax, double outputMin, double outputMax) {
		return ((value - inputMin) / (inputMax - inputMin) * (outputMax - outputMin) + outputMin);
	}
}
