# Remote_Control_Joystick_App

Remote Control Joystick App is an android app that stimulates an airplane joystick to "fly" a plane in FlightGear.

This app is written in the Kotlin language.

You can find in this app a joystick that controls the `aileron` and `elevator`, and two seek bars (one horizontal and one vertical) that control the `rudder` and `throttle` respectively.

#### How to use:
1. Download and install FlightGear (from https://www.flightgear.org/download)
2. Open FlightGear and go to settings, in additional **Settings** write the next line:
```
--telnet=socket,in,10,127.0.0.1,6400,tcp
```
3. Download or Clone the app (using Git, or a zip archive to unzip)
4. Open your project in Android Studio
5. Select an android phone or AVD and press run 
6. Press **Fly!** and in the app connect to the FlightGear's server (**IP**: _IPv4 Adress on your computer_ **port** : 6400)

#### The structure of the project

This app is built-in MVVM Architecture:

* **View**
  * MainActivity - is responsible for the _avtivity_main.xml_ file to upload. It also connects the Joystick the ViewModel
  * Joystick - is responsible for the joystick to move and send in the end to the `Service.onChange` the changes that happened. (if the joystick moved)
* **Model** 
  * ModelFlight - is responsible to connect to the FlightGear and send requests.
* **ViewModel**
  * ViewModelFligt - is responsible to connect between the view (MainActivity) and the model (ModelFlight)
--------

## The Model

The responsibility of the model is to connect to the server of the FlightGear app.

To create the connection we implemented an Active Object.

#### API of the FlightGear
Type       | Endpoint                                    | query      | Explanation
----       | --------                                    | :---:      | --------------------
**SET**    | _/controls/flight/aileron_                  | (-1...1)   | set the alieron value to be the query
**SET**    | _/controls/flight/elevator_                 | (-1...1)   | set the elevator value to be the query
**SET**    | _/controls/flight/rudder_                   | (-1...1)   | set the rudder value to be the query
**SET**    | _/controls/engines/current-engine/throttle_ | (-1...1)   | set the throttle value to be the query 

-----

## The View

The way that the view works is that the `MainActivity` is responsible for the display of the app, he's the one that is connected to the ViewModel. 

`MainActivity` also injects to the `Joystick` the  `Service.onChange` function. that way the joystick itself doesn't know the ViewModel and can be "taken out" and used in other projects.

To create a `Joystick` all you need is to implement the `Service` interface.

------

#####authors
* Avital Livshitz
* Michelle Rabkin
