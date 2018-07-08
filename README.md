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
* Rename to parentAL control service - it sounds mind control
* A stub for the MovieService impl has been added to allow for autowiring of the app. This is configured by qualifier which may be changed.
