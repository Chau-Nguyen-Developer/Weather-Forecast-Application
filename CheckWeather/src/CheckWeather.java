//PROGRAMMER: NGOC CHAU NGUYEN

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


/**
 * Users can obtain weather forecast info for next week.
 * For example, highest and lowest temperature, precipitation, and wind-speed.
 *
 * @author Ngoc Chau Nguyen
 * @version Wed, 05/29/2024
 */
public class CheckWeather
{
    // instance variables
    private StringBuilder bottomMessage;
    private String defaultMessage;

//    private double lowestTemperature;
//    private double highestTemperature;
//    private double lowestPercipitation;
//    private double highestPercipitation;
//    private double lowestWindSpeed;
//    private double highestWindSpeed;
    JSONObject jsonObject;
    private double lowest;
    private double highest;

    private String returnTime;
    private double returnPrecipitation;
    private double returnWindSpeed;
    private double returnTemperature;

    JSONArray timeArray;
    JSONArray precipitationArray;
    JSONArray windSpeedArray;
    JSONArray temperatureArray;

    HighLowPair myPair;

    char code;
    char level;
    int index;
    int lowIndex;
    int highIndex;
    int finalIndex;
    double mainInfo;
    /**
     * Constructor for objects of class CheckWeather
     */
    public CheckWeather()
    {
        //INITIALIZE DUMMY VALUES
//        lowestTemperature = 0;
//        highestTemperature = 0;
//        lowestPercipitation = 0;
//        highestPercipitation = 0;
//        lowestWindSpeed = 0;
//        highestWindSpeed = 0;

        //CREATE THE FRAME
        JFrame myFrame = new JFrame("Nguyen's Weather App");
        myFrame.setLayout(new BorderLayout());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREATE CATEGORIES
        JPanel myCategoryPanel = new JPanel(new GridLayout(4, 1));
        JLabel myCategoryLabel = new JLabel("What are you looking for?");
        myCategoryPanel.add(myCategoryLabel);
        //Default: temperature button will be selected
        ButtonGroup myButtonGroup = new ButtonGroup();

        JRadioButton tempButton = new JRadioButton("Temperature", true);
        myButtonGroup.add(tempButton);
        myCategoryPanel.add(tempButton);

        JRadioButton rainButton = new JRadioButton("Precipitation");
        myButtonGroup.add(rainButton);
        myCategoryPanel.add(rainButton);

        JRadioButton windButton = new JRadioButton("Wind Speed");
        myButtonGroup.add(windButton);
        myCategoryPanel.add(windButton);

        myFrame.add(myCategoryPanel, BorderLayout.WEST);

        //CREATE HIGH AND LOW RADIO BUTTONS
        JPanel myValuePanel = new JPanel(new GridLayout(3, 1));
        JLabel valueLabel = new JLabel("What kind of value?");
        myValuePanel.add(valueLabel);
        ButtonGroup myValueButtonGroup = new ButtonGroup();

        JRadioButton lowestValueButton = new JRadioButton("Lowest", true);
        myValueButtonGroup.add(lowestValueButton);
        myValuePanel.add(lowestValueButton);

        JRadioButton highestValueButton = new JRadioButton("Highest");
        myValueButtonGroup.add(highestValueButton);
        myValuePanel.add(highestValueButton);

        myFrame.add(myValuePanel, BorderLayout.EAST);

        //CREATE RESET/RUN BUTTONS
        JPanel controlPanel = new JPanel(new GridLayout(2,1));
        JButton runButton = new JButton("Run");
        JButton resetButton = new JButton("Reset");

        controlPanel.add(runButton);
        controlPanel.add(resetButton);

        myFrame.add(controlPanel, BorderLayout.CENTER);

        //CREATE THE BOTTOM MESSAGE
        defaultMessage = "Rain or shine--ready to assist you!";
        bottomMessage = new StringBuilder(defaultMessage);
        JLabel messageLabel = new JLabel(bottomMessage.toString(), JLabel.CENTER);
        myFrame.add(messageLabel, BorderLayout.SOUTH);

        //CONNECT MY JAVA FILE TO JSON FILE AND READ
        JSONParser myParser = new JSONParser();
        try
        {
            Object myObj = myParser.parse(new FileReader("forecasts.json"));
            JSONObject jsonObject = (JSONObject)myObj;

            JSONObject hourly = (JSONObject)jsonObject.get("hourly");

            //OBTAIN TIME ARRAY
            timeArray = (JSONArray)hourly.get("time");
            //OBTAIN PRECIPITATION ARRAY
            precipitationArray = (JSONArray)hourly.get("precipitation");
            //OBTAIN WIND_SPEED ARRAY
            windSpeedArray = (JSONArray)hourly.get("wind_speed");
            //OBTAIN TEMPERATURE ARRAY
            temperatureArray = (JSONArray)hourly.get("temperature");


        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Exception");
        }
        catch (IOException e)
        {
            System.out.println("IOException");
        }
        catch (ParseException e)
        {
            System.out.println("ParseException");
        }


        //HANDLE EVENT FOR RESET BUTTON
        resetButton.addActionListener((ae) ->
        {
            //Reset default options
            tempButton.setSelected(true);
            code = 't';
            lowestValueButton.setSelected(true);
            level = 'l';

            //Delete old bottom message. Reset to default message.
            bottomMessage.delete(0, bottomMessage.length());
            bottomMessage.append(defaultMessage);

            messageLabel.setText(bottomMessage.toString());

            index = 0;
        });

        //HANDLE EVENT FOR RUN BUTTON
        runButton.addActionListener((ae) ->
        {
            bottomMessage.delete(0, bottomMessage.length());

            if(lowestValueButton.isSelected())
            {
                bottomMessage.append("Lowest ");
                level = 'l';
            }
            if(highestValueButton.isSelected())
            {
                bottomMessage.append("Highest ");
                level = 'h';
            }

            if (tempButton.isSelected())
            {
                bottomMessage.append("temperature ");
                code = 't';
            }
            else if(rainButton.isSelected())
            {
                bottomMessage.append("precipitation ");
                code = 'p';
            }
            else
            {
                bottomMessage.append("wind speed ");
                code = 'w';
            }
            //DECIDE WHICH CATEGORY(WHICH ARRAY) TO LOOP THROUGH
            switch(code)
            {
                case 't':
                    myPair = loopThrough(temperatureArray);
                    break;
                case 'p':
                    myPair = loopThrough(precipitationArray);
                    break;
                case 'w':
                    myPair = loopThrough(windSpeedArray);
                    break;
            }
            //System.out.println("Debug: " + this.getTime(1));
            System.out.println("Debug HighIndex: " + highIndex);
            System.out.println("Debug LowIndex: " + lowIndex);
            switch(level)
            {
                case 'h':
                    System.out.println("Debug go to testcase high");
                    mainInfo = myPair.getHigh();
                    System.out.println("Debug main info");
                    returnTime = getTime(highIndex);
                    System.out.println(returnTime);
                    finalIndex = highIndex;
                    break;
                case 'l':
                    mainInfo = myPair.getLow();
                    returnTime = getTime(lowIndex);
                    finalIndex = lowIndex;
                    break;
            }
            System.out.println("Debug finalIndex: " + finalIndex);

            switch (code)
            {
                //GO TO THIS STEP AFTER KNOWING WHICH CATEGORY AND WHAT LEVEL WERE CHOSEN
                case 't':
                    //GIVEN TEMPERATURE, RETURN PRECIPITATION AND WIND-SPEED
                    returnTemperature = mainInfo;
                    returnPrecipitation = getInfo(precipitationArray, finalIndex);
                    returnWindSpeed = getInfo(windSpeedArray, finalIndex);
                    break;
                case 'p':
                    //GIVEN PRECIPITATION, RETURN TEMPERATURE AND WIND-SPEED
                    returnPrecipitation = mainInfo;
                    returnTemperature = getInfo(temperatureArray, finalIndex);
                    returnWindSpeed = getInfo(windSpeedArray, finalIndex);
                    break;
                case 'w':
                    returnWindSpeed = mainInfo;
                    returnTemperature = getInfo(temperatureArray, finalIndex);
                    returnPrecipitation = getInfo(precipitationArray, finalIndex);
                    break;
            }


            bottomMessage.append("will be at ");
            bottomMessage.append(returnTime);

            //IF HAVE MORE TIME, WILL WORK ON UNITS
            bottomMessage.append(". Here are more details: \n");

            bottomMessage.append("- Temperature: "). append(returnTemperature);

            bottomMessage.append("\n");

            bottomMessage.append("- Precipitation: ").append(returnPrecipitation);

            bottomMessage.append("\n");

            bottomMessage.append("- Wind Speed: ").append(returnWindSpeed);

            bottomMessage.append("\n");

            messageLabel.setText(bottomMessage.toString());
            System.out.println(bottomMessage.toString());
        });

        //CENTER THE WEATHER APP ON THE DEFAULT SCREE AT STARTUP
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }

    //INNER CLASS
    private class HighLowPair
    {
        //instance variables
        double myLow;
        double myHigh;
        //constructor
        public HighLowPair(double low, double high)
        {
            myLow = low;
            myHigh = high;
        }
        //instance methods
        //getters
        public double getHigh()
        {
            return myHigh;
        }
        public double getLow()
        {
            return myLow;
        }
        //setters
        public void setHigh(double high)
        {
            myHigh = high;
        }
        public void setLow(double low)
        {
            myLow = low;
        }

    }

    //PRIVATE FUNCTION TO LOOP THROUGH ANY JSON ARRAY
    private HighLowPair loopThrough(JSONArray myJSArray)
    {
        index = 0;

        Iterator myIterator = myJSArray.iterator();
        if (myIterator.hasNext()) {
            lowest = highest = (double) myIterator.next();
            ++index;
        }
        while (myIterator.hasNext()) {
            double value = (double) myIterator.next();
            ++index;
            if (value < lowest)
            {
                lowest = value;
                lowIndex = index;
            }
            if (value > highest)
            {
                highest = value;
                highIndex = index;
            }
        }
        return new HighLowPair(lowest, highest);
    }

    //PRIVATE FUNCTIONS TO GO TO A SPECIFIC INDEX
    private String getTime(int givenIndex)
    {
            Iterator timeIterator = timeArray.iterator();
            int secondIndex = 0;
            while(secondIndex <= givenIndex)
            {
                returnTime = (String) timeIterator.next();
                ++secondIndex;
            }
            return returnTime;
    }

    private double getInfo(JSONArray theArray, int givenIndex)
    {
        double result = 0.0;
        Iterator infoIterator = theArray.iterator();
        int secondIndex = 0;
        while(secondIndex <= givenIndex)
        {
            result = (Double)infoIterator.next();
            ++secondIndex;
        }
        return result;
    }


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new CheckWeather());
    }
}
