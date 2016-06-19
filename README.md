# realworld-dagger-2

Skeleton of an app that requires log in. Once logged in the user id is shown on a log out page. The logged in user is persisted in the app's SharedPreferences, so that next time the app is launched the log in screen will be skipped if a user is logged in.

At application start up time a SharedPreferences and UserSession are created. The initial activity (LaunchActivity) immediately shows a log in or log out screen. 

The log in screen obtains the same application-level UserSession instance via injection, plus a LoginBehaviour instance. Clicking the log in button creates a random username, updates the UserSession and launches the log out screen.

The log out screen obtains the same application-level UserSession instance via injection and uses it to log the user out when the button is clicked.
