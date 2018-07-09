# Parental Control Service

## Resposibilities

This is a single responsiblity service for validating whether a given
movie should be viewable by a consumer with the specified parental
control preference.

# Swagger

## Swagger JSON
/v2/api-docs
## Swagger UI
/swagger-ui.html

# Running

## Docker

* docker build and run the image, exposing 8080
* or docker-compose up and goto localhost:8080

## Gradle
* ./gradlew bootRun

# Short Comings

There are many short-comings and I've had to context switch to and from.

* I would usually validate my business language with others. I went for verbosity to in the absence of others to discus clarity with.
* swagger docs could have been  better as could the API design
* As is Swagger UI is good for trying out the API from within the app
* Categories and Cucumber tags would be needed to curb the feedback time; at this stage it's OK and would typically be a concern as the project evolved to result in slower feedback.
* checkstyle.. I should have added checkstyle at the outset. I dred adding sensible rules at this time for fear of all the pending REDNESS
* Javadoc - I've added some in parts of implementation, but have not been as consistent as I should have
* commits; I would typically rebase and tidy up. I think that I've been relatively good about being trunk-based without breaking commits
* API design.. THE API FEELS MORE LIKE IT SHOULD BE RPC IN STYLE. There are no 'real' resources, but I felt that the test would be around RESTful deisign.
* I had been tempted to try out gRPC
* In my efforts to make this RESTful, I've treated movies as the identity of the primary resource
* I initially felt that preference should be provided as a 'filter' query parameter; this would have either removed or kept the movie classification.

## Business Domain

# Concepts

* Parental Control Levels
 One of the following levels, indicative of which groups certain content is suitable for.
  * U - universal
  * PG - viewable with parental guidance.
  * 12 - viewable by audience over the age of 12
  * 15 - viewable by audience over the age of 15
  * 18 - viewable by audience over the age of 18
* Parental Control Preference
 A chosen  Parental Control Level associated with a given audience member's profile
* Parental Control Level of a Movie
 A fixed parental control level associated with a movie
* Movie - _probably_ viewable content

# TODO
* A stub for the MovieService impl has been added to allow for autowiring of the app. This maybe configured by qualifier
