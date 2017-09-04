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

package de.topobyte.lightgeom.curves.spline.android;

import android.graphics.Path;
import de.topobyte.lightgeom.curves.spline.CubicSpline;
import de.topobyte.lightgeom.curves.spline.Line;
import de.topobyte.lightgeom.curves.spline.QuadraticSpline;
import de.topobyte.lightgeom.lina.Point;

public class LightGeomAndroid
{

	public static Path connect(Point c1, Point c2)
	{
		Path path = new Path();
		path.moveTo((float) c1.x, (float) c1.y);
		path.lineTo((float) c2.x, (float) c2.y);
		return path;
	}

	public static Path convert(Line line)
	{
		Path path = new Path();
		path.moveTo((float) line.getP1X(), (float) line.getP1Y());
		path.lineTo((float) line.getP2X(), (float) line.getP2Y());
		return path;
	}

	public static void convert(Path path, Line line)
	{
		path.moveTo((float) line.getP1X(), (float) line.getP1Y());
		path.lineTo((float) line.getP2X(), (float) line.getP2Y());
	}

	public static Path convert(QuadraticSpline spline)
	{
		Path path = new Path();
		path.moveTo((float) spline.getP1X(), (float) spline.getP1Y());
		path.quadTo((float) spline.getCX(), (float) spline.getCY(),
				(float) spline.getP2X(), (float) spline.getP2Y());
		return path;
	}

	public static void convert(Path path, QuadraticSpline spline)
	{
		path.moveTo((float) spline.getP1X(), (float) spline.getP1Y());
		path.quadTo((float) spline.getCX(), (float) spline.getCY(),
				(float) spline.getP2X(), (float) spline.getP2Y());
	}

	public static Path convert(CubicSpline spline)
	{
		Path path = new Path();
		path.moveTo((float) spline.getP1X(), (float) spline.getP1Y());
		path.cubicTo((float) spline.getC1X(), (float) spline.getC1Y(),
				(float) spline.getC2X(), (float) spline.getC2Y(),
				(float) spline.getP2X(), (float) spline.getP2Y());
		return path;
	}

	public static void convert(Path path, CubicSpline spline)
	{
		path.moveTo((float) spline.getP1X(), (float) spline.getP1Y());
		path.cubicTo((float) spline.getC1X(), (float) spline.getC1Y(),
				(float) spline.getC2X(), (float) spline.getC2Y(),
				(float) spline.getP2X(), (float) spline.getP2Y());
	}

}
