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

package de.topobyte.lightgeom.lina;

public class Point
{

	public double x;
	public double y;

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Point set(double x, double y)
	{
		this.x = x;
		this.y = y;
		return this;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public Point setX(double x)
	{
		this.x = x;
		return this;
	}

	public Point setY(double y)
	{
		this.y = y;
		return this;
	}

}
