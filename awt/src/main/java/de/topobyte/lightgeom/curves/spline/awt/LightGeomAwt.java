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

package de.topobyte.lightgeom.curves.spline.awt;

import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import de.topobyte.lightgeom.curves.spline.CubicSpline;
import de.topobyte.lightgeom.curves.spline.Line;
import de.topobyte.lightgeom.curves.spline.QuadraticSpline;
import de.topobyte.lightgeom.lina.Point;

public class LightGeomAwt
{

	public static Line2D connect(Point c1, Point c2)
	{
		return new Line2D.Double(c1.x, c1.y, c2.x, c2.y);
	}

	public static Line2D convert(Line line)
	{
		Point p1 = line.getP1();
		Point p2 = line.getP2();
		return new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
	}

	public static QuadCurve2D convert(QuadraticSpline spline)
	{
		Point p1 = spline.getP1();
		Point p2 = spline.getP2();
		Point c = spline.getC();
		return new QuadCurve2D.Double(p1.x, p1.y, c.x, c.y, p2.x, p2.y);
	}

	public static CubicCurve2D convert(CubicSpline spline)
	{
		Point p1 = spline.getP1();
		Point p2 = spline.getP2();
		Point c1 = spline.getC1();
		Point c2 = spline.getC2();
		return new CubicCurve2D.Double(p1.x, p1.y, c1.x, c1.y, c2.x, c2.y,
				p2.x, p2.y);
	}

}
