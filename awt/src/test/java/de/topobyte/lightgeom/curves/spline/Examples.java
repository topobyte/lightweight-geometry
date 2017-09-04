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

public class Examples
{

	public static List<Point> EXAMPLE1 = new ArrayList<>();

	static {
		EXAMPLE1.add(new Point(100, 100));
		EXAMPLE1.add(new Point(100, 200));
		EXAMPLE1.add(new Point(200, 240));
		EXAMPLE1.add(new Point(300, 180));
		EXAMPLE1.add(new Point(400, 160));
		EXAMPLE1.add(new Point(500, 180));
		EXAMPLE1.add(new Point(480, 270));
		EXAMPLE1.add(new Point(380, 330));
	}

}
