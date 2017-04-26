Using GraphQL with Sangria, Akka HTTP and Reactive Mongo
====

       http://graphql.org/
       http://facebook.github.io/graphql/
       http://sangria-graphql.org/learn/

 - run MongoDB in Docker

       docker run -p 27017:27017 -d mongo:3.4.3

 - query all users

        curl -vi -X POST http://localhost:48080/users -H "Content-Type: application/json" -d " \
            query { \
              users { \
                id \
                email \
              } \
            }"

 - query user by identifier

        curl -vi -X POST http://localhost:48080/users -H "Content-Type: application/json" -d " \
            query { \
              user(id: 1) { \
                email \
                firstName \
                lastName \
                address { \
                  country \
                } \
              } \
            }"

 - activate user by identifier

        curl -vi -X POST http://localhost:48080/users -H "Content-Type: application/json" -d " \
           mutation { \
             activate(id: 1) { \
               active \
             } \
           }"

 - add user

        curl -vi -X POST http://localhost:48080/users -H "Content-Type: application/json" -d " \
           mutation { \
             add(email: \"a@b.com\", firstName: \"John\", lastName: \"Smith\", roles: [ADMIN]) { \
               id \
               active \
               email \
               firstName \
               lastName \
               address { \
                 street \
                 country \
               } \
             } \
           }"
