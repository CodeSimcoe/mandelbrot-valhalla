package com.codesimcoe.mandelbrotfx;

public record Complex(double re, double im) {
  public static final Complex ZERO = new Complex(0, 0);

  public double magnitudeSquared() {
    return re * re + im * im;
  }

  public Complex square() {
    return new Complex(re * re - im * im, 2 * re * im);
  }

  public Complex add(Complex other) {
    return new Complex(re + other.re, im + other.im);
  }
}
