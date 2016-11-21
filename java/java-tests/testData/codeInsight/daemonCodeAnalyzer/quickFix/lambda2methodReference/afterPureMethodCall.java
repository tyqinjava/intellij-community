// "Replace lambda with method reference" "true"
import java.util.*;
import java.util.function.Predicate;

class Main {
  public static void main(String[] args) {
    final Test test = new Test();
    final List<Sub> subs = Arrays.asList(new Sub(), new Sub());

    subs.forEach(test.getSubs()::add);
  }

  private static class Test {
    private final List<Sub> subs = new ArrayList<>();

    private List<Sub> getSubs() {
      return subs;
    }
  }

  private static class Sub {
  }
}
