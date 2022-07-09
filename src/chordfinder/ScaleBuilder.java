package chordfinder;

public class ScaleBuilder {
    
    public static int[] major(int base) {
        return new int[] {
            base,
            base + 2,
            base + 4,
            base + 5,
            base + 7,
            base + 9,
            base + 11,
            base + 12
        };
    }
    
    public static int[] majorReversed(int base) {
        return new int[] {
            base + 12,
            base + 11,
            base + 9,
            base + 7,
            base + 5,
            base + 4,
            base + 2,
            base
        };
    }
}
