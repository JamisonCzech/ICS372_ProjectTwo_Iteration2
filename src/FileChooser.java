

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Class for choosing and parsing the file in
 * order to set initial values for fridge and freezer.
 */
public class FileChooser {

    public static FridgeSettings fridgeSettings;
    public static FreezerSettings freezerSettings;

    private static int fridgeLow;
    private static int fridgeHigh;
    private static int freezerLow;
    private static int freezerHigh;
    private static int roomLow;
    private static int roomHigh;
    private static int fridgeRateLossDoorClosed;
    private static int fridgeRateLossDoorOpen;
    private static int freezerRateLossDoorClosed;
    private static int freezerRateLossDoorOpen;
    private static int fridgeCompressorStartDiff;
    private static int freezerCompressorStartDiff;
    private static int fridgeCoolRate;
    private static int freezerCoolRate;

    /**
     * Function to select a file with JFileChooser
     * <p>
     * <b>Precondition:</b> File is available on drive. <b>PostCondition:</b> a
     * file of configuration values is selected.
     * </p>
     *
     * @return returns the given selected file of values that was choose by the
     * user.
     */
    public String chooseFile() {

        JFileChooser chooser;
        String fileName;
        FileNameExtensionFilter filter;
        int selection;

        fileName = null;
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Text Files", "dat", "txt");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("."));// sets current directory
        selection = chooser.showOpenDialog(null);

        if (selection == JFileChooser.APPROVE_OPTION)
            fileName = chooser.getSelectedFile().getAbsolutePath();

        return (fileName);
    }

    /**
     * Parses file from storage, processes the values stored.
     *
     * @param configFile String configFile
     * @throws Exception e
     */
    public static void ReadConfigurationFromFile(String configFile) throws Exception {
        try (BufferedReader buffer = new BufferedReader(new FileReader(configFile))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.contains("FridgeLow")) {
                    fridgeLow = ExtractInt(line);
                } else if (line.contains("FridgeHigh")) {
                    fridgeHigh = ExtractInt(line);
                } else if (line.contains("FreezerLow")) {
                    freezerLow = ExtractInt(line);
                } else if (line.contains("FreezerHigh")) {
                    freezerHigh = ExtractInt(line);
                } else if (line.contains("RoomLow")) {
                    roomLow = ExtractInt(line);
                } else if (line.contains("RoomHigh")) {
                    roomHigh = ExtractInt(line);
                } else if (line.contains("FridgeRateLossDoorClosed")) {
                    fridgeRateLossDoorClosed = ExtractInt(line);
                } else if (line.contains("FridgeRateLossDoorOpen")) {
                    fridgeRateLossDoorOpen = ExtractInt(line);
                } else if (line.contains("FreezerRateLossDoorClosed")) {
                    freezerRateLossDoorClosed = ExtractInt(line);
                } else if (line.contains("FreezerRateLossDoorOpen")) {
                    freezerRateLossDoorOpen = ExtractInt(line);
                } else if (line.contains("FridgeCompressorStartDiff")) {
                    fridgeCompressorStartDiff = ExtractInt(line);
                } else if (line.contains("FreezerCompressorStartDiff")) {
                    freezerCompressorStartDiff = ExtractInt(line);
                } else if (line.contains("FridgeCoolRate")) {
                    fridgeCoolRate = ExtractInt(line);
                } else if (line.contains("FreezerCoolRate")) {
                    freezerCoolRate = ExtractInt(line);
                } else {
                    throw new Exception("Unrecognized parameter: " + line.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param str str
     * @return
     *  returns the parsed value from the string
     */
    public static int ExtractInt(String str) {
        String intValue = str.replaceAll("[^-?0-9]", "");
        return Integer.parseInt(intValue);
    }


    /**
     * Sets the initial fridge settings from file
     */
    public void initialFridgeSettings() {
        int startingFridgeTemp = ((fridgeHigh + fridgeLow) / 2);
        int startingRoomTemp = ((roomHigh + roomLow) / 2);

        fridgeSettings = FridgeSettings.instance();

        fridgeSettings.setInstance(fridgeLow, fridgeHigh, roomLow, roomHigh, fridgeRateLossDoorClosed,
                fridgeRateLossDoorOpen, fridgeCompressorStartDiff, fridgeCoolRate, startingFridgeTemp);
        fridgeSettings.setDesiredRefrigeratorTemp(startingFridgeTemp);
        fridgeSettings.setDesiredRoomTemp(startingRoomTemp);


    }

    /**
     * Sets the initial freezer settings from file
     */
    public void initialFreezerSettings() {
        int startingFreezerTemp = ((freezerHigh + freezerLow) / 2);
        int startingRoomTemp = ((roomHigh + roomLow) / 2);

        freezerSettings = FreezerSettings.instance();

        freezerSettings.setInstance(freezerLow, freezerHigh, roomLow, roomHigh, freezerRateLossDoorClosed,
                freezerRateLossDoorOpen, freezerCompressorStartDiff, freezerCoolRate, startingFreezerTemp);
        freezerSettings.setDesiredRefrigeratorTemp(startingFreezerTemp);
        freezerSettings.setDesiredRoomTemp(startingRoomTemp);
    }


}
