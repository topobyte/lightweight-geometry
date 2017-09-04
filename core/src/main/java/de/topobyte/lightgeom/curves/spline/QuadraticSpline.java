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

public interface QuadraticSpline
{

	public Point getP1();

	public Point getC();

	public Point getP2();

	public double getP1X();

	public double getP1Y();

	public double getP2X();

	public double getP2Y();

	public double getCX();

	public double getCY();

	public void set(double p1x, double p1y, double cx, double cy, double p2x,
			double p2y);

}
