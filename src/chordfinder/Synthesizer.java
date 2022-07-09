package chordfinder;

import javax.sound.midi.*;

public class Synthesizer {
    
    private Sequencer sequencer;
    private Track track;
    private Sequence sequence;
    private int tickCounter;
    
    public void synthesizer() {
    }
    
    public void setup() {
        try {
            this.sequencer = MidiSystem.getSequencer();
            this.sequencer.open();
            this.sequence = new Sequence(Sequence.PPQ, 4);
            this.track = this.sequence.createTrack();
            
            tickCounter = 1;
            
            this.addEvent(192, 1, 1, 0, 0);
        } catch (Exception ex) {
 
            ex.printStackTrace();
        }
    }
    
    public void play() {
        try {
            this.sequencer.setSequence(this.sequence);
            this.sequencer.setTempoInBPM(100);
            this.sequencer.start();
 
            while (true) {
 
                if (!this.sequencer.isRunning()) {
                    this.sequencer.close();
                    System.exit(1);
                }
            }
        } catch (Exception ex) {
 
            ex.printStackTrace();
        }   
    }
    
    public void addNote(int note, int length) {
        try {
            this.addEvent(144, 1, note, 100, this.tickCounter);
            this.addEvent(128, 1, note, 100, this.tickCounter + length);
            this.tickCounter += length;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void addNoteNoGap(int note, int length) {
        try {
            this.addEvent(144, 1, note, 100, this.tickCounter);
            this.addEvent(128, 1, note, 100, this.tickCounter + length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void addChord(int[] chord, int length) {
        for (int note : chord) {
            if (note != -1) {
                this.addNoteNoGap(note, length);
            }
        }
        this.tickCounter += length;
    }
    
    public void addNotes(int[] notes, int length) {
        for (int note : notes) {
            this.addNote(note, length);
        }
    }
    
    public void addEvent(int command, int channel, int note, int velocity, int tick) {
        MidiEvent e = this.createEvent(command, channel, note, velocity, tick);
        this.track.add(e);
    }
    
    private MidiEvent createEvent(int command, int channel, int note, int velocity, int tick) {
        MidiEvent event = null;
 
        try {
 
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, note, velocity);
 
            event = new MidiEvent(a, tick);
        }
        catch (Exception ex) {
 
            ex.printStackTrace();
        }
        return event;
    }
       
}
