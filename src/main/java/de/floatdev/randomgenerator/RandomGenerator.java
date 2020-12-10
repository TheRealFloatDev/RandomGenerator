package de.floatdev.randomgenerator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    /**
     * The List containing all possible values of the random generator.
     */
    private static final List<String> VALUES = new LinkedList<>();

    /**
     * Runs the Random Generator.
     * @param args Not NEEDED!
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Value(s) to add or type 'quit' to generate the result");
        while (scanner.hasNext()) {
            String scan = scanner.nextLine();
            if (scan.equalsIgnoreCase("quit") || scan.equalsIgnoreCase("q")) {
                System.out.println("Generating result...");
                for (int i = 0; i < 50; i++) {
                    System.out.print("\rHow about " + VALUES.get(ThreadLocalRandom.current().nextInt(VALUES.size())));
                    try {
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("src/main/resources/Ding-Sound-Effect.wav").toURL());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.start();
                        Thread.sleep(125);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.exit(0);
            } else {
                VALUES.add(scan);
                System.out.println("Added " + scan + " to selection! (Type 'quit' to generate the result)");
            }
        }
    }

}
