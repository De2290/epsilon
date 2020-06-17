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


## Examples
This section will show some examples of how to use Epsilon.

### GET
A simple GET request. This uses the GitHub API.

```
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws IOException {
        Epsilon epsilonRequester = EpsilonBuilder.createNewRequest("https://api.github.com/orgs/octokit/repos");
        epsilonRequester.get(response -> System.out.println(response.getResp()));
    }
}

```

Result:

```
[{"id":417862,"node_id":"MDEwOlJlcG9zaXRvcnk0MTc4NjI=","name":"octokit.rb","full_name":"octokit/octokit.rb","private":false,"owner":{"login":"octokit"...
```

### POST
A simple POST request. This is using a arbritary link, but you can use it on any RESTful web service that implements POST.

```
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws IOException {
        Epsilon epsilonRequester = EpsilonBuilder.createNewRequest("https://your-url-here.com/api/addUser");
        epsilonRequester.post("{}", response -> System.out.println(response.getResp()));
    }
}

```

This should respond with whatever you are expecting from the API. Note that you can use a JSON library such as GSON or Jackson to easily serialize the Java object into a string.
## Purpose
I had made this after seeing the horrendous implementation of Java HTTP requests using the URL class. I wanted an easier method to use.
Ironically, the source code for these libraries incidentally uses that same method. This is for compatibility purposes.

