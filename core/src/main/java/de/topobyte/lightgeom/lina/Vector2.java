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

public class Vector2
{

	public double x;
	public double y;

	public Vector2(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vector2(Point c)
	{
		this(c.x, c.y);
	}

	public Vector2(Vector2 v)
	{
		this(v.x, v.y);
	}

	public Vector2(double fromX, double fromY, double toX, double toY)
	{
		this(toX - fromX, toY - fromY);
	}

	public Vector2(Point from, Point to)
	{
		this(to.x - from.x, to.y - from.y);
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public Vector2 setX(double x)
	{
		this.x = x;
		return this;
	}

	public Vector2 setY(double y)
	{
		this.y = y;
		return this;
	}

	public Vector2 set(double x, double y)
	{
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector2 set(Point c)
	{
		return set(c.x, c.y);
	}

	public Vector2 set(Vector2 v)
	{
		return set(v.x, v.y);
	}

	public Vector2 set(double fromX, double fromY, double toX, double toY)
	{
		return set(toX - fromX, toY - fromY);
	}

	public Vector2 set(Point from, Point to)
	{
		return set(to.x - from.x, to.y - from.y);
	}

	@Override
	public String toString()
	{
		return String.format("%f,%f", x, y);
	}

	public Vector2 copy()
	{
		return new Vector2(x, y);
	}

	public Vector2 add(Vector2 other)
	{
		x += other.x;
		y += other.y;
		return this;
	}

	public Vector2 add(double ox, double oy)
	{
		x += ox;
		y += oy;
		return this;
	}

	public Vector2 sub(Vector2 other)
	{
		x -= other.x;
		y -= other.y;
		return this;
	}

	public Vector2 sub(double ox, double oy)
	{
		x -= ox;
		y -= oy;
		return this;
	}

	public Vector2 mult(double lambda)
	{
		x *= lambda;
		y *= lambda;
		return this;
	}

	public Vector2 divide(double lambda)
	{
		x /= lambda;
		y /= lambda;
		return this;
	}

	public double dotProduct(Vector2 other)
	{
		return x * other.x + y * other.y;
	}

	public double norm()
	{
		return Math.sqrt(x * x + y * y);
	}

	public double length()
	{
		return Math.sqrt(x * x + y * y);
	}

	public double length2()
	{
		return x * x + y * y;
	}

	public Vector2 normalize()
	{
		double norm = norm();
		divide(norm);
		return this;
	}

	public double fastInverseNorm()
	{
		return fastInverseSquareRoot((float) (x * x + y * y));
	}

	public static float fastInverseSquareRoot(float x)
	{
		float xHalf = 0.5F * x;
		int temp = Float.floatToRawIntBits(x);
		temp = 0x5F3759DF - (temp >> 1);
		float newX = Float.intBitsToFloat(temp);
		newX = newX * (1.5F - xHalf * newX * newX);
		return newX;
	}

	public Vector2 normalizeFast()
	{
		double inverseNorm = fastInverseNorm();
		mult(inverseNorm);
		return this;
	}

	public Vector2 perpendicularLeft()
	{
		double ox = x;
		x = -y;
		y = ox;
		return this;
	}

	public Vector2 perpendicularRight()
	{
		double ox = x;
		x = y;
		y = -ox;
		return this;
	}

}
