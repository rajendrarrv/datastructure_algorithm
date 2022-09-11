package com.rajendra.model;

import java.util.Objects;

/**
 * Created by Rajendra Verma on 08/09/22.
 */
public class Pair {
   public int a;
   public int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return a == pair.a && b == pair.b ||  a == pair.b && b == pair.a || (a ==b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

  public   int min() {
        return Math.min(a, b);
    }
}
