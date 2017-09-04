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

public class CubicSplineB implements CubicSpline
{

	private double p1x;
	private double p1y;
	private double c1x;
	private double c1y;
	private double c2x;
	private double c2y;
	private double p2x;
	private double p2y;

	public CubicSplineB(Point p1, Point c1, Point c2, Point p2)
	{
		this.p1x = p1.x;
		this.p1y = p1.y;
		this.c1x = c1.x;
		this.c1y = c1.y;
		this.c2x = c2.x;
		this.c2y = c2.y;
		this.p2x = p2.x;
		this.p2y = p2.y;
	}

	public CubicSplineB(double p1x, double p1y, double c1x, double c1y,
			double c2x, double c2y, double p2x, double p2y)
	{
		this.p1x = p1x;
		this.p1y = p1y;
		this.c1x = c1x;
		this.c1y = c1y;
		this.c2x = c2x;
		this.c2y = c2y;
		this.p2x = p2x;
		this.p2y = p2y;
	}

	@Override
	public void set(double p1x, double p1y, double c1x, double c1y, double c2x,
			double c2y, double p2x, double p2y)
	{
		this.p1x = p1x;
		this.p1y = p1y;
		this.c1x = c1x;
		this.c1y = c1y;
		this.c2x = c2x;
		this.c2y = c2y;
		this.p2x = p2x;
		this.p2y = p2y;
	}

	@Override
	public Point getP1()
	{
		return new Point(p1x, p1y);
	}

	@Override
	public Point getC1()
	{
		return new Point(c1x, c1y);
	}

	@Override
	public Point getC2()
	{
		return new Point(c2x, c2y);
	}

	@Override
	public Point getP2()
	{
		return new Point(p2x, p2y);
	}

	@Override
	public double getP1X()
	{
		return p1x;
	}

	@Override
	public double getP1Y()
	{
		return p1y;
	}

	@Override
	public double getP2X()
	{
		return p2x;
	}

	@Override
	public double getP2Y()
	{
		return p2y;
	}

	@Override
	public double getC1X()
	{
		return c1x;
	}

	@Override
	public double getC1Y()
	{
		return c1y;
	}

	@Override
	public double getC2X()
	{
		return c2x;
	}

	@Override
	public double getC2Y()
	{
		return c2y;
	}

}
