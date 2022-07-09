package chordfinder;

public class Notes {
    
    public static String[] NOTES = {
        "A",
        "Bb",
        "B",
        "C",
        "C#",
        "D",
        "Eb",
        "E",
        "F",
        "F#",
        "G",
        "G#",
    };
    
    public static String indexToNote(int note) {
        note -= 20;
        note += 8;
        String postFix = String.valueOf((note - note % 12) / 12);
        note -= 9;
        return Notes.NOTES[note - (note - note % 12)] + postFix;
    }
    
    public static String chordToNotes(int[] chord) {
        String str = "";
        for (int note : chord) {
            str += Notes.indexToNote(note) + " ";
        }
        return str;
    }
    
}
