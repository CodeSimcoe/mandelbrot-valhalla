import jdk.internal.value.ValueClass;
import jdk.internal.vm.annotation.LooselyConsistentValue;

// jcmd _08_FlatteningNonAtomic GC.class_histogram | grep Orbit
// --add-exports=java.base/jdk.internal.value=ALL-UNNAMED

// $ jcmd _08_FlatteningNonAtomic GC.class_histogram | grep Orbit
// 198:            11            440  _08_FlatteningNonAtomic$1NonNullValueOrbit
// 199:            11            440  _08_FlatteningNonAtomic$1ValueOrbit
// 230:            10            320  _08_FlatteningNonAtomic$1Orbit
// 294:             1            176  [L_08_FlatteningNonAtomic$1NonNullNonAtomicValueOrbit;
// 481:             1             56  [L_08_FlatteningNonAtomic$1NonNullValueOrbit;
// 482:             1             56  [L_08_FlatteningNonAtomic$1Orbit;
// 483:             1             56  [L_08_FlatteningNonAtomic$1ValueOrbit;
// 558:             1             40  _08_FlatteningNonAtomic$1NonNullNonAtomicValueOrbit

void main() throws InterruptedException {

  record Orbit(double re, double im) {}
  value record ValueOrbit(double re, double im) {}
  value record NonNullValueOrbit(double re, double im) {}
  @LooselyConsistentValue value record NonNullNonAtomicValueOrbit(double re, double im) {}

  int size = 10;

  // Orbit[]
  var data1 = new Orbit[size];

  // ValueOrbit[]
  var data2 = new ValueOrbit[size];

  // Orbit![]
  var data3 = new NonNullValueOrbit![] {new NonNullValueOrbit(0, 0), new NonNullValueOrbit(1, 1), new NonNullValueOrbit(2, 2), new NonNullValueOrbit(3, 3), new NonNullValueOrbit(4, 4), new NonNullValueOrbit(5, 5), new NonNullValueOrbit(6, 6), new NonNullValueOrbit(7, 7), new NonNullValueOrbit(8, 8), new NonNullValueOrbit(9, 9)};

  // non-atomic Orbit![]
  var data4 = ValueClass.newNullRestrictedNonAtomicArray(NonNullNonAtomicValueOrbit.class, size, new NonNullNonAtomicValueOrbit(0, 0));

  for (int i = 0; i < size; i++) {
    data1[i] = new Orbit(i, i);
    data2[i] = new ValueOrbit(i, i);
    data4[i] = new NonNullNonAtomicValueOrbit(i, i);
  }

  IO.println("Sleeping...");
  Thread.sleep(100_000);

  IO.println(data1);
  IO.println(data2);
  IO.println(data3);
  IO.println(data4);
}