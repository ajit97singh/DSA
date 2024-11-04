package src.src.leetCodeUtils;

import lombok.Data;

@Data
public final class Pair<A, B> {
    private final A a;
    private final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }
}
