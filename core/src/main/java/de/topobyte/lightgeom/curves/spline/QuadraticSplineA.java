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

public class QuadraticSplineA implements QuadraticSpline
{

	private Point p1;
	private Point c;
	private Point p2;

	public QuadraticSplineA(Point p1, Point c, Point p2)
	{
		this.p1 = p1;
		this.c = c;
		this.p2 = p2;
	}

	@Override
	public void set(double p1x, double p1y, double cx, double cy, double p2x,
			double p2y)
	{
		p1.set(p1x, p1y);
		p2.set(p2x, p2y);
		c.set(cx, cy);
	}

	@Override
	public Point getP1()
	{
		return p1;
	}

	@Override
	public Point getC()
	{
		return c;
	}

	@Override
	public Point getP2()
	{
		return p2;
	}

	@Override
	public double getP1X()
	{
		return p1.x;
	}

	@Override
	public double getP1Y()
	{
		return p1.y;
	}

	@Override
	public double getP2X()
	{
		return p2.x;
	}

	@Override
	public double getP2Y()
	{
		return p2.y;
	}

	@Override
	public double getCX()
	{
		return c.x;
	}

	@Override
	public double getCY()
	{
		return c.y;
	}

}
