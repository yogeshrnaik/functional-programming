package coreservlets.timing;

/** Represents an operation that we will want to time. */

@FunctionalInterface
public interface Op {
  void runOp();
}
