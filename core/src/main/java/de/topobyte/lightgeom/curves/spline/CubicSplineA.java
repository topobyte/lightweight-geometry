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

public class CubicSplineA implements CubicSpline
{

	private Point p1;
	private Point c1;
	private Point c2;
	private Point p2;

	public CubicSplineA(Point p1, Point c1, Point c2, Point p2)
	{
		this.p1 = p1;
		this.c1 = c1;
		this.c2 = c2;
		this.p2 = p2;
	}

	@Override
	public void set(double p1x, double p1y, double c1x, double c1y, double c2x,
			double c2y, double p2x, double p2y)
	{
		p1.set(p1x, p1y);
		p2.set(p2x, p2y);
		c1.set(c1x, c1y);
		c2.set(c2x, c2y);
	}

	@Override
	public Point getP1()
	{
		return p1;
	}

	@Override
	public Point getC1()
	{
		return c1;
	}

	@Override
	public Point getC2()
	{
		return c2;
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
	public double getC1X()
	{
		return c1.x;
	}

	@Override
	public double getC1Y()
	{
		return c1.y;
	}

	@Override
	public double getC2X()
	{
		return c2.x;
	}

	@Override
	public double getC2Y()
	{
		return c2.y;
	}

}
