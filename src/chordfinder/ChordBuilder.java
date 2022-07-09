package chordfinder;

public class ChordBuilder {
    
    public static int[] majorTriad(int base) {
        return new int[] { base, base + 4, base + 7, -1 };
    }
    
    public static int[] minorTriad(int base) {
        return new int[] { base, base + 3, base + 7, -1 };
    }
    
    public static int[] augment(int[] chord) {
        chord[2]++;
        return chord;
    }
    
    public static int[] diminish(int[] chord) {
        chord[2]--;
        return chord;
    }
    
    public static int[] sus4(int[] chord) {
        chord[1]++;
        return chord;
    }
    
    public static int[] sus2(int[] chord) {
        chord[1]--;
        return chord;
    }
    
    public static int[] extend(int[] chord) {
        chord[3] = chord[0] + 12;
        return chord;
    }
}
