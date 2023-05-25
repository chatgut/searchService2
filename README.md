﻿# SearchService2:
 
 The SearchService enables a searchfunctionality to search for messages. It gives the user the ability to search for a specific message from a chat or 
 all messages.
 
 # Getting started:
 To run the program, type the following command:

 docker-compose up --build
 
 
 # Endpoints:
 
 GET /search/findAll
 
 Finds all created messages in the chatindex.
 
 GET /search/text/{text}
 
 Finds the specific message in the chatindex.
 
 GET /search/textId/{id}
 
 Finds the id for the message.
 
 
