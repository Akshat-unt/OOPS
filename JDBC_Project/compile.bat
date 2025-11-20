@echo off
echo Compiling JDBC Project...
echo.
echo Make sure mysql-connector-java.jar is in the current directory or update the classpath.
echo.

REM Update the JAR filename according to your MySQL connector version
javac -cp ".;mysql-connector-java-8.0.33.jar" *.java

if %errorlevel% == 0 (
    echo.
    echo Compilation successful!
    echo.
    echo To run the program, use: run.bat
) else (
    echo.
    echo Compilation failed! Please check:
    echo 1. MySQL JDBC driver JAR file exists
    echo 2. Update the JAR filename in this script if needed
    echo 3. All Java files are present
)

pause

