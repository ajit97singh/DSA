package src.src.leetCode.easy;


import lombok.Data;

@Data
public class ValIndex {
    public int value;
    public int index;

    public ValIndex(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
