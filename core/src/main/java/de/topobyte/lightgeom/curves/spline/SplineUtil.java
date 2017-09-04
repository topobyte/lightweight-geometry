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

import de.topobyte.lightgeom.lina.Point;
import de.topobyte.lightgeom.lina.Vector2;

public class SplineUtil
{

	/**
	 * Create a cubic spline that connects {@code p1} and {@code p2}
	 * 
	 * @param p1
	 *            the start point of the spline
	 * @param p2
	 *            the end point of the spline
	 * @param d1
	 *            the tangent vector from the start point pointing in the
	 *            direction that the curve should have at its start (towards the
	 *            end point)
	 * @param d2
	 *            the tangent vector from the end point pointing in the
	 *            direction that the curve should have at its end (towards the
	 *            start point)
	 * @param f
	 *            the fraction in [0..1] of the length of the straight line
	 *            connecting start and end point that the control points should
	 *            be positioned along the tangents
	 * 
	 * @param normalized
	 *            whether the tangent vectors are already normalized
	 * @return
	 */
	public static CubicSpline spline(Point p1, Point p2, Vector2 d1,
			Vector2 d2, double f, boolean normalized)
	{
		Vector2 d = new Vector2(p1, p2);
		double l = d.length() * f;

		Point cp1;
		if (d1 == null) {
			cp1 = p1;
		} else {
			if (!normalized) {
				d1.normalize();
			}
			Vector2 c1 = new Vector2(p1);
			d1.mult(l);
			c1.add(d1);
			cp1 = new Point(c1.getX(), c1.getY());
		}

		Point cp2;
		if (d2 == null) {
			cp2 = p2;
		} else {
			if (!normalized) {
				d2.normalize();
			}
			Vector2 c2 = new Vector2(p2);
			d2.mult(l);
			c2.add(d2);
			cp2 = new Point(c2.getX(), c2.getY());
		}

		return new CubicSplineB(p1, cp1, cp2, p2);
	}

	public static CubicSpline spline(double p1x, double p1y, double p2x,
			double p2y, Vector2 d1, Vector2 d2, double f, boolean normalized)
	{
		CubicSplineB spline = new CubicSplineB(0, 0, 0, 0, 0, 0, 0, 0);
		spline(spline, p1x, p1y, p2x, p2y, d1, d2, f, normalized);
		return spline;
	}

	public static void spline(CubicSpline spline, double p1x, double p1y,
			double p2x, double p2y, Vector2 d1, Vector2 d2, double f,
			boolean normalized)
	{
		// compute the length of the vector from p1 to p2
		double dx = p2x - p1x;
		double dy = p2y - p1y;
		double dl = Math.sqrt(dx * dx + dy * dy);
		// compute the distance of the control point
		double l = dl * f;

		double cp1x, cp1y;
		if (d1 == null) {
			cp1x = p1x;
			cp1y = p1y;
		} else {
			if (!normalized) {
				d1.normalize();
			}
			d1.mult(l);
			cp1x = p1x + d1.getX();
			cp1y = p1y + d1.getY();
		}

		double cp2x, cp2y;
		if (d2 == null) {
			cp2x = p2x;
			cp2y = p2y;
		} else {
			if (!normalized) {
				d2.normalize();
			}
			d2.mult(l);
			cp2x = p2x + d2.getX();
			cp2y = p2y + d2.getY();
		}

		spline.set(p1x, p1y, cp1x, cp1y, cp2x, cp2y, p2x, p2y);
	}

}
