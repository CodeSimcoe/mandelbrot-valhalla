package com.codesimcoe.mandelbrotfx;

public record Complex(double re, double im) {
  public static final Complex ZERO = new Complex(0, 0);

  public double magnitudeSquared() {
    return this.re * this.re + this.im * this.im;
  }

  public Complex square() {
    return new Complex(this.re * this.re - this.im * this.im, 2 * this.re * this.im);
  }

  public Complex add(Complex other) {
    return new Complex(this.re + other.re, this.im + other.im);
  }
}
