package display.refrigerator;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import buttons.refrigerator.FreezerCloseButton;
import buttons.refrigerator.FreezerOpenButton;
import buttons.refrigerator.FridgeCloseButton;
import buttons.refrigerator.FridgeOpenButton;
import buttons.refrigerator.GUIButton;
import buttons.refrigerator.SetFreezerButton;
import buttons.refrigerator.SetFridgeButton;
import buttons.refrigerator.SetRoomButton;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;
import settings.refrigerator.Settings;


/**
 * This GUI class implements the RefrigeratorDisplay interface
 */
public class GUIDisplay extends RefrigeratorDisplay implements ActionListener {

    public static SimpleDisplay frame;
    public static Settings fridgeSettings;
    public static Settings freezerSettings;


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
     * Do the usual layout of the frame
     */
    private GUIDisplay() {
        frame = new SimpleDisplay();
        initialize();
    }

    private class SimpleDisplay extends JFrame {

        private GUIButton fridgeDoorOpener = new FridgeOpenButton("Open fridge door");
        private GUIButton fridgeDoorCloser = new FridgeCloseButton("Close fridge door");
        private GUIButton freezerDoorOpener = new FreezerOpenButton("Open freezer door");
        private GUIButton freezerDoorCloser = new FreezerCloseButton("Close freezer door");
        private GUIButton setRoomTemp = new SetRoomButton("Set room temp");
        private GUIButton setFridgeTemp = new SetFridgeButton("Set desired fridge temp");
        private GUIButton setFreezerTemp = new SetFreezerButton("Set desired freezer temp");

        private JTextField inRoomTemp = new JTextField(10);
        private JTextField inFridgeTemp = new JTextField(10);
        private JTextField inFreezerTemp = new JTextField(10);

        private JLabel roomTemp = new JLabel("Room temp");
        private JLabel desiredFridgeTemp = new JLabel("Desired fridge temp");
        private JLabel desiredFreezerTemp = new JLabel("Desired freezer temp");
        private JLabel status = new JLabel("Status");
        private JLabel fridgeLight = new JLabel("Fridge light <on/off>");
        private JLabel freezerLight = new JLabel("Freezer light <on/off>");
        private JLabel fridgeTemp = new JLabel("Fridge temp: ");
        private JLabel freezerTemp = new JLabel("Freezer temp: ");
        private JLabel fridgeState = new JLabel("Fridge <cooling/idle>");
        private JLabel freezerState = new JLabel("Freezer <cooling/idle>");

        private JLabel fridgeDoorStatus = new JLabel("Fridge door: <open/closed>"); //Door Label
        private JLabel freezerDoorStatus = new JLabel("Freezer door: <open/closed>"); //Door Label


        private SimpleDisplay() {
            super("Refrigerator");
            getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

            JPanel temps = new JPanel(new GridLayout(0, 3, 20, 20));
            temps.add(roomTemp);
            temps.add(inRoomTemp);
            temps.add(setRoomTemp);
            temps.add(desiredFridgeTemp);
            temps.add(inFridgeTemp);
            temps.add(setFridgeTemp);
            temps.add(desiredFreezerTemp);
            temps.add(inFreezerTemp);
            temps.add(setFreezerTemp);

            JPanel doors = new JPanel(new GridLayout(0, 2, 20, 20));
            doors.add(fridgeDoorOpener);
            doors.add(fridgeDoorCloser);
            doors.add(freezerDoorOpener);
            doors.add(freezerDoorCloser);

            JPanel states = new JPanel(new GridLayout(0, 2, 20, 20));
            states.add(fridgeDoorStatus); //Door Label
            states.add(freezerDoorStatus); //Door Label

            states.add(fridgeLight);
            states.add(freezerLight);
            states.add(fridgeTemp);
            states.add(freezerTemp);
            states.add(fridgeState);
            states.add(freezerState);

            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(temps);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(doors);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(states);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(states);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));

            setRoomTemp.addActionListener(GUIDisplay.this);
            setFridgeTemp.addActionListener(GUIDisplay.this);
            setFreezerTemp.addActionListener(GUIDisplay.this);
            fridgeDoorOpener.addActionListener(GUIDisplay.this);
            fridgeDoorCloser.addActionListener(GUIDisplay.this);
            freezerDoorOpener.addActionListener(GUIDisplay.this);
            freezerDoorCloser.addActionListener(GUIDisplay.this);

            pack();
            setLocationRelativeTo(null);//centers GUI display
            setVisible(true);
        }
    }

    public Integer getInRoomTemp() {
        int roomTemperature = 0;
        try {
            roomTemperature = Integer.parseInt(frame.inRoomTemp.getText());
            return roomTemperature;
        } catch (NumberFormatException e) {

            //set up warning labels
            //frame.roomTemp.setText("Invalid Format");
            return null;
        }
    }

    
    

	@Override
	public Integer getFreezerTemp() {
		 int freezerTemperature = 0;
	        try {
	            freezerTemperature = Integer.parseInt(frame.inFreezerTemp.getText());
	            return freezerTemperature;
	        } catch (NumberFormatException e) {

	            //set up warning labels
	            //frame.roomTemp.setText("Invalid Format");
	            return null;
	        }
	}
	

	@Override
	public Integer getFridgeTemp() {
		 int fridgeTemperature = 0;
	        try {
	            fridgeTemperature = Integer.parseInt(frame.inFridgeTemp.getText());
	            return fridgeTemperature;
	        } catch (NumberFormatException e) {

	            //set up warning labels
	            //frame.roomTemp.setText("Invalid Format");
	            return null;
	        }
	}

    /**
     * Process the buttons
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        ((GUIButton) event.getSource()).inform(this);
    }

    @Override
    public void turnFridgeLightOn() {
        frame.fridgeLight.setText("Fridge light <ON>");
    }

    @Override
    public void turnFridgeLightOff() {
        frame.fridgeLight.setText("Fridge light <OFF>");
    }

    @Override
    public void turnFreezerLightOn() {
        frame.freezerLight.setText("Freezer light <ON>");
    }

    @Override
    public void turnFreezerLightOff() {
        frame.freezerLight.setText("Freezer light <OFF>");
    }

    @Override
    public void fridgeCooling() {
        frame.fridgeState.setText("Fridge <COOLING>");
    }

    @Override
    public void fridgeIdle() {
        frame.fridgeState.setText("Fridge <IDLE>");
    }

    @Override
    public void freezerCooling() {
        frame.freezerState.setText("Freezer <COOLING>");
    }

    @Override
    public void freezerIdle() {
        frame.freezerState.setText("Freezer <IDLE>");
    }

    @Override
    public void fridgeTemp() {
        frame.fridgeTemp.setText("Fridge temp: " + roomHigh);
    }

    @Override
    public void freezerTemp() {
        frame.freezerTemp.setText("Freezer temp: " + roomHigh);


    }


    @Override
    public void freezerDoorOpen() {
        frame.freezerDoorStatus.setText("Freezer Door <OPEN>");

    }


    @Override
    public void freezerDoorClosed() {

        frame.freezerDoorStatus.setText("Freezer Door <Closed>");
    }


    @Override
    public void fridgeDoorClosed() {
        frame.fridgeDoorStatus.setText("Fridge Door <CLOSED>");
    }

    @Override
    public void fridgeDoorOpen() {
        frame.fridgeDoorStatus.setText("Fridge Door <OPEN>");
        System.out.println("Singleton Main Method Read Test " + FridgeSettings.instance().getCompressorStartDiff());
    }

    /**
     * Function to select a file with JFileChooser
     * <p>
     * <b>Precondition:</b>
     * File is available on drive.
     * <b>PostCondition:</b>
     * a file of configuration values is selected.
     * </p>
     *
     * @return returns the given selected file of values
     * that was choose by the user.
     */
    public static String chooseFile() {

        JFileChooser chooser;
        String fileName;
        FileNameExtensionFilter filter;
        int selection;

        fileName = null;
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Text Files", "dat", "txt");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("."));//sets current directory
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

    public static int ExtractInt(String str) {
        String intValue = str.replaceAll("[^0-9]", "");
        return Integer.parseInt(intValue);
    }




    public static void main(String args[]) {

        int i;
        String iFile;

        iFile = chooseFile();
        if (iFile != null) {
            i = iFile.lastIndexOf('.');
            if (i >= 0) {
                try {
                    ReadConfigurationFromFile(iFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        //Test -----------------------------------------------------------

        fridgeSettings = FridgeSettings.instance();
        fridgeSettings.setInstance(fridgeLow, fridgeHigh,
                roomLow, roomHigh,
                fridgeRateLossDoorClosed, fridgeRateLossDoorOpen,
                fridgeCompressorStartDiff, fridgeCoolRate);


        freezerSettings = FreezerSettings.instance();
        freezerSettings.setInstance(freezerLow, freezerHigh, roomLow, roomHigh,
                freezerRateLossDoorClosed, freezerRateLossDoorOpen, freezerCompressorStartDiff, freezerCoolRate);


        RefrigeratorDisplay display = new GUIDisplay();
    }// end main




}


