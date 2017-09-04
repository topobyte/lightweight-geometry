// Copyright 2017 Sebastian Kuerten
//
// This file is part of lightweight-geometry.
//
// lightweight-geometry is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// lightweight-geometry is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with lightweight-geometry. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.lightgeom.curves.spline;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.topobyte.lightgeom.curves.spline.awt.LightGeomAwt;
import de.topobyte.lightgeom.lina.Point;
import de.topobyte.lightgeom.lina.Vector2;

public class TestSpline2 extends JPanel
{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("More splines");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TestSpline2 test = new TestSpline2(Examples.EXAMPLE1);
		frame.setContentPane(test);

		frame.setSize(600, 400);
		frame.setVisible(true);
	}

	private List<Point> coordinates;

	public TestSpline2(List<Point> coordinates)
	{
		this.coordinates = coordinates;
	}

	@Override
	protected void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D) graphics;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		double f = 0.3;

		g.setStroke(new BasicStroke(1));
		g.setColor(Color.RED);

		for (int i = 0; i < coordinates.size() - 1; i++) {
			Point p1 = coordinates.get(i);
			Point p2 = coordinates.get(i + 1);
			Line line = new LineB(p1, p2);
			Line2D l = LightGeomAwt.convert(line);
			g.draw(l);
		}

		g.setStroke(new BasicStroke(2));
		g.setColor(Color.BLUE);

		for (int i = 0; i < coordinates.size() - 1; i++) {
			Point p1 = coordinates.get(i);
			Point p2 = coordinates.get(i + 1);
			CubicSpline spline;
			if (i == 0) {
				Point p3 = coordinates.get(i + 2);
				Vector2 d31 = new Vector2(p1);
				d31.sub(new Vector2(p3));
				spline = SplineUtil.spline(p1, p2, null, d31, f, false);
			} else if (i == coordinates.size() - 2) {
				Point p0 = coordinates.get(i - 1);
				Vector2 d02 = new Vector2(p2);
				d02.sub(new Vector2(p0));
				spline = SplineUtil.spline(p1, p2, d02, null, f, false);
			} else {
				Point p0 = coordinates.get(i - 1);
				Point p3 = coordinates.get(i + 2);

				Vector2 d02 = new Vector2(p2);
				d02.sub(new Vector2(p0));
				Vector2 d31 = new Vector2(p1);
				d31.sub(new Vector2(p3));

				spline = SplineUtil.spline(p1, p2, d02, d31, f, false);
			}
			CubicCurve2D curve = LightGeomAwt.convert(spline);
			g.draw(curve);
		}
	}

}
