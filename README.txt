Before you run, please ensure that your JAVA_HOME varible is set to jdk-17.0.2

If it isn't I've included it in the folder, as well as an easy way to set it. Please double click "setJAVAHOME.bat" which will set your JAVA_HOME directory to this folder. (If you don't want me messing with that,
you should definitely make note of where your current JAVA_HOME is by checking your environment variables.)

Once that's done, you should be good to go!

Right click inside this folder (Where the readme exists) and open a Windows PowerShell in this folder, or open windows powershell manually and navigate here

In order to do the manual powershell, hit windows key, and type powershell, then in the terminal, type this "cd .\Downloads\NobelService\" (if this service is in your downloads folder)

Then please input "./mvnw spring-boot:run" to run this locally

If there's no trouble, you can go to "http://localhost:8080/laureate-count" in any web browser in order to access the endpoint

I've also added a second endpoint, because there is a different API hidden at the bottom of the /laureates API, that shows there are over 900 results! So if you want the FULL count of all laureates beyond
the first 25 that is default on their API, use "http://localhost:8080/laureate-count-full" and that will get them all.

You can also see in the command terminal how long each operation takes. By far the longest in my program is actually just connecting and opening the /laureate API. Every other operation is significantly faster.

Thank you for taking the time to read this! I hope it meets your standards!