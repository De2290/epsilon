# Epsilon
Epsilon is a improved HTTP framework for Java, without many of the complications brought by traditional methods.
It is inspired by the Axios library for Javascript, and it aims to be simple and easy to use for beginners.

## Status
Right now, this project is in beta, but it supports GET and POST requests, and checking the body of them.


## Installation
These steps will show how to get a local copy of the library compiled and running on your system.

### Cloning the Repository
Make sure you have `git` installed. Then, run the following:

```
git clone https://github.com/De2290/epsilon
```

### Building the Library
To build the library, make sure to have Maven 3 installed, then run the following:

```
mvn clean package
```

Congratulations! In your target folder there should be a file titled `epsilon-jar-with-dependencies.jar`. This has all the libraries needed.
All you need to do is include the `.jar` file in your classpath and you should be good to go!



## Purpose
I had made this after seeing the horrendous implementation of Java HTTP requests using the URL class. I wanted an easier method to use.
Ironically, the source code for these libraries incidentally uses that same method. This is for compatibility purposes.

