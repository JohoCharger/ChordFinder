package chordfinder;
import javax.sound.midi.*;

public class ChordFinder {

    public static void main(String[] args) {
        Synthesizer player = new Synthesizer();
        player.setup();
        
        player.addChord(ChordBuilder.extend(ChordBuilder.majorTriad(60)), 4);

        player.play();
    }
}
