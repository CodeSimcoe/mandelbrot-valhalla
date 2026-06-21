record Data(Boolean bool1, Boolean bool2, Integer i) {}
//  record Data(Boolean! bool1, Boolean! bool2, Integer! i) {}

// -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlineLayout
void main() {
  Data data = new Data(true, false, 42);
  IO.println(data);
}
