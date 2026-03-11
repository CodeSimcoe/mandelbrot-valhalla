record Orbit(float re, float im) {}
value record ValueOrbit(float re, float im) {}
value record NonNullValueOrbit(float re, float im) {}

// jcmd _07_Flattening GC.class_histogram | head

//  $ jcmd _07_Flattening GC.class_histogram | grep Orbit
//  219:            11            352  _07_Flattening$ValueOrbit
//  255:            10            240  _07_Flattening$Orbit
//  364:             1             96  [L_07_Flattening$NonNullValueOrbit;
//  480:             1             56  [L_07_Flattening$Orbit;
//  481:             1             56  [L_07_Flattening$ValueOrbit;
//  607:             1             32  _07_Flattening$NonNullValueOrbit

void main() throws InterruptedException {

  int size = 10;

  // Orbit[]
  var data1 = new Orbit[size];

  // ValueOrbit[]
  var data2 = new ValueOrbit[size];

  // Orbit![]
  var data3 = new NonNullValueOrbit![] {new NonNullValueOrbit(0, 0), new NonNullValueOrbit(1, 1), new NonNullValueOrbit(2, 2), new NonNullValueOrbit(3, 3), new NonNullValueOrbit(4, 4), new NonNullValueOrbit(5, 5), new NonNullValueOrbit(6, 6), new NonNullValueOrbit(7, 7), new NonNullValueOrbit(8, 8), new NonNullValueOrbit(9, 9)};

  for (int i = 0; i < size; i++) {
    data1[i] = new Orbit(i, i);
    data2[i] = new ValueOrbit(i, i);
  }

  IO.println("Sleeping...");
  Thread.sleep(100_000);

  IO.println(data1);
  IO.println(data2);
  IO.println(data3);
}