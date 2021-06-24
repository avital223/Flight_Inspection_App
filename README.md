## Remote_Control_Joystick_App

Remot Control Joystick App is an adroid app that stimulates an airplane joystick to "fly" a plane in FlightGear.

This app is written in Kotlin language.

You can find in this app a joystick that controlls the `aileron` and `elevator`, and two seekbars (one horizontal and one vertical) that control the `rudder` and `throttle` respectively.

#### How to use:
1. Download and install FlightGear (from https://www.flightgear.org/download)
2. Open FlightGear and go to settings, in additional **Settings** write the next line:
```
--telnet=socket,in,10,127.0.0.1,6400,tcp
```
3. Download or Clone the app (using Git, or a zip archive to unzip)
4. Open your project in Android Studio
5. Select an android phone or AVD and press run 
6. Press **Fly!** and in the app connect to the FlightGear's server (**ip**: _IPv4 Adress on your computer_ **port** : 6400)


# The Model

The responsebility of the model is to connect to the server of the FlightGear app.
To implement this we implemented an Active Object.
#### API of the FlightGear
Type       | Endpoint                                    | query      | Explanation
----       | --------                                    | :---:      | --------------------
**SET**    | _/controls/flight/aileron_                  | (-1...1)   | set the alieron value to be the query
**SET**    | _/controls/flight/elevator_                 | (-1...1)   | set the elevator value to be the query
**SET**    | _/controls/flight/rudder_                   | (-1...1)   | set the rudder value to be the query
**SET**    | _/controls/engines/current-engine/throttle_ | (-1...1)   | set the throttle value to be the query 
