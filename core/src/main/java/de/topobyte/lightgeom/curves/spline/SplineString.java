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

import java.util.ArrayList;
import java.util.List;

import de.topobyte.lightgeom.lina.Point;
import de.topobyte.lightgeom.lina.Vector2;

public class SplineString
{

	private List<CubicSpline> splines = new ArrayList<>();

	/**
	 * Create a SplineString, a list of splines that fits the given Point
	 * sequence.
	 * 
	 * @param Points
	 *            the sequence of Points that the curve should go through
	 * @param f
	 *            the fraction in [0..1] to use as a parameter for the
	 *            construction of the control points
	 */
	public SplineString(List<Point> Points, double f)
	{
		// connect p1 to p2
		// p0 is the point before p1
		// p3 is the point after p3

		// first segment
		{
			Point p1 = Points.get(0);
			Point p2 = Points.get(1);
			Point p3 = Points.get(2);

			// c2 = p2 + (p1 - p3)
			Vector2 d31 = new Vector2(p1);
			d31.sub(new Vector2(p3));
			d31.normalize();

			CubicSpline spline = SplineUtil.spline(p1, p2, null, d31, f, true);
			splines.add(spline);
		}

		// segments in between
		for (int i = 1; i < Points.size() - 2; i++) {
			Point p0 = Points.get(i - 1);
			Point p1 = Points.get(i);
			Point p2 = Points.get(i + 1);
			Point p3 = Points.get(i + 2);

			// c1 = p1 + (p2 - p0)
			Vector2 d02 = new Vector2(p2);
			d02.sub(new Vector2(p0));
			d02.normalize();

			// c2 = p2 + (p1 - p3)
			Vector2 d31 = new Vector2(p1);
			d31.sub(new Vector2(p3));
			d31.normalize();

			CubicSpline spline = SplineUtil.spline(p1, p2, d02, d31, f, true);
			splines.add(spline);
		}

		// last segment
		{
			Point p0 = Points.get(Points.size() - 3);
			Point p1 = Points.get(Points.size() - 2);
			Point p2 = Points.get(Points.size() - 1);

			// c1 = p1 + (p2 - p0)
			Vector2 d02 = new Vector2(p2);
			d02.sub(new Vector2(p0));
			d02.normalize();

			CubicSpline spline = SplineUtil.spline(p1, p2, d02, null, f, true);
			splines.add(spline);
		}
	}

	public List<CubicSpline> getSplines()
	{
		return splines;
	}

}
