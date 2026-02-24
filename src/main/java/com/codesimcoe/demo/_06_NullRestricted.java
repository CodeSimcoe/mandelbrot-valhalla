package com.codesimcoe.demo;

// -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlineLayout
public class _06_NullRestricted {

  record Data(Boolean bool1, Boolean bool2, Integer i) {}
//  record Data(Boolean! bool1, Boolean! bool2, Integer! i) {}

  void main() {
    Data data = new Data(true, false, 42);
    IO.println(data);
  }
}
