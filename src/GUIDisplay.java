

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This GUI class implements the RefrigeratorDisplay interface
 */
public class GUIDisplay extends RefrigeratorDisplay implements ActionListener {

    public static SimpleDisplay frame;

    /**
     * Do the usual layout of the frame in
     * the center of the screen
     */
    private GUIDisplay() {
        frame = new SimpleDisplay();
        initialize();
    }

    // inner class for display setup
    private class SimpleDisplay extends JFrame {

       // create buttons for display
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

        // Label
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

        private JLabel fridgeDoorStatus = new JLabel("Fridge door: <open/closed>"); // Door
        private JLabel freezerDoorStatus = new JLabel("Freezer door: <open/closed>"); // Door


        private JLabel warningLabel = new JLabel("");

        // Constructor for innerClass SimpleDisplay()
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

            //error label
            JPanel warning = new JPanel(new GridLayout(0, 1, 20, 20));
            warning.add(warningLabel);

            JPanel doors = new JPanel(new GridLayout(0, 2, 20, 20));
            doors.add(fridgeDoorOpener);
            doors.add(fridgeDoorCloser);
            doors.add(freezerDoorOpener);
            doors.add(freezerDoorCloser);

            JPanel states = new JPanel(new GridLayout(0, 2, 20, 20));
            states.add(fridgeDoorStatus); // Door Label
            states.add(freezerDoorStatus); // Door Label

            states.add(fridgeLight);
            states.add(freezerLight);
            states.add(fridgeTemp);
            states.add(freezerTemp);
            states.add(fridgeState);
            states.add(freezerState);

            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(temps);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(warning);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(doors);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(states);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));
            getContentPane().add(states);
            getContentPane().add(Box.createRigidArea(new Dimension(20, 20)));



            /**
             *
             * Action Listeners for when the action event occurs,
             * that object's actionPerformed method is invoked.
             */
            setRoomTemp.addActionListener(GUIDisplay.this);
            setFridgeTemp.addActionListener(GUIDisplay.this);
            setFreezerTemp.addActionListener(GUIDisplay.this);
            fridgeDoorOpener.addActionListener(GUIDisplay.this);
            fridgeDoorCloser.addActionListener(GUIDisplay.this);
            freezerDoorOpener.addActionListener(GUIDisplay.this);
            freezerDoorCloser.addActionListener(GUIDisplay.this);

            pack();
            setLocationRelativeTo(null);// centers GUI display
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }

    /**
     *
     * @return getter that returns the
     * parsed roomTemp int.
     *
     */
    public Integer getInRoomTemp() {
        int roomTemperature = 0;
        try {
            roomTemperature = Integer.parseInt(frame.inRoomTemp.getText());
            return roomTemperature;
        } catch (NumberFormatException e) {

            // set up warning labels
            // frame.roomTemp.setText("Invalid Format");
            return null;
        }
    }

    /**
     *
     * @return getter that returns the
     * parsed freezerTemp int.
     *
     */
    @Override
    public Integer getFreezerTemp() {
        int freezerTemperature = 0;
        try {
            freezerTemperature = Integer.parseInt(frame.inFreezerTemp.getText());
            return freezerTemperature;
        } catch (NumberFormatException e) {

            // set up warning labels
            // frame.roomTemp.setText("Invalid Format");
            return null;
        }
    }

    /**
     *
     * @return return the parsed fridge temp
     */
    @Override
    public Integer getFridgeTemp() {
        int fridgeTemperature = 0;
        try {
            fridgeTemperature = Integer.parseInt(frame.inFridgeTemp.getText());
            return fridgeTemperature;
        } catch (NumberFormatException e) {

            // set up warning labels
            // frame.roomTemp.setText("Invalid Format");
            return null;
        }
    }

    /**
     * Process all of the buttons
     *   "A semantic event which indicates that a component-defined action occurred.
     *   This high-level event is generated by a component" JavaDoc
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
    public void fridgeTemp(int fridgeTemp) {
        //frame.fridgeTemp.setText("Fridge temp: " + FridgeSettings.instance().getCurrentTemp());
        frame.fridgeTemp.setText("Fridge temp: " + fridgeTemp);
    }

    @Override
    public void freezerTemp(int freezerTemp) {
        //frame.freezerTemp.setText("Freezer temp: " + FreezerSettings.instance().getCurrentTemp());
        frame.freezerTemp.setText("Freezer temp: " + freezerTemp);
    }

    @Override
    public void freezerDoorOpen() {
        frame.freezerDoorStatus.setText("Freezer Door <OPEN>");
    }

    @Override
    public void freezerDoorClosed() {
        frame.freezerDoorStatus.setText("Freezer Door <CLOSED>");
    }

    @Override
    public void fridgeDoorClosed() {
        frame.fridgeDoorStatus.setText("Fridge Door <CLOSED>");
    }

    @Override
    public void fridgeDoorOpen() {
        frame.fridgeDoorStatus.setText("Fridge Door <OPEN>");
    }

    @Override
    public void clearWarning() {
        frame.warningLabel.setText("");
    }

    @Override
    public void setWarning(String warningMessage) {
        frame.warningLabel.setForeground(Color.RED);
        frame.warningLabel.setText("* " + warningMessage);
    }

    /**
     *
     * @param args ars
     *   Initiates program and lets user
     *   choose file for initial values of the
     *   fridge and freezer.
     */
    public static void main(String args[]) {

        FileChooser fileChooser = new FileChooser();
        int i;
        String iFile;

        iFile = fileChooser.chooseFile();
        if (iFile != null) {
            i = iFile.lastIndexOf('.');
            if (i >= 0) {
                try {
                    FileChooser.ReadConfigurationFromFile(iFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.exit(0);
        }

        // initials all values from chosen file
        fileChooser.initialFridgeSettings();
        fileChooser.initialFreezerSettings();


        RefrigeratorDisplay display = new GUIDisplay();

    }// end main

}
