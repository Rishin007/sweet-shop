WELCOME TO SWEET MANAGEMENT SYSTEM !!!!

As an aspiring backend developer, this project highlights the local API endpoints that were asked to be designed to perform full scale CRUD Operaions.
This includes creating, fetching, updating and even deleting the respective sweets from the inventory. I am fully aware that I haven't been able to implement the dedicated inventory part which keeps a track of the total sweets in the inventory but will surely work on it. 
Although I was asked to design a full scale web opeartion implementing both the front-end as well as the back-end to provide a seamless client-server architecture, my knowledge so far has allowed me to deisgn the back-end (although not completely) but upto the mark to which I have been able to implement my learnings till now. I won't say I have done this entire project alone, but as we all know that with the rapid advancements of AI in every field, I have also leveraged it's usage in my project , like to automate generation of unit test cases, to debug an error or point out the critical parts that I can modify to upscale the sanity of the code. Well it's almost 75:25 ratio, if I have to rate my individual contribution vs AI's blessing. 


WORKING OF THE PROJECT :-

1. Have taken an entity class named Sweet with it's respective instances as mentioned in the doc.
2. Have implemented Data Transfer Object(DTO) to hide the database details from user while sending and receiving of data.
3. Created the Repository for Sweets along with 3 custom methods with 1 implementing internal query that will be provided by Hibernate with the other 2 utilizing the JPQL query methods to leverage SQL knowledge.
4. Next have taken the Service layer that contains the list of possible transactions : Create,Update, Delete, Fetch all as well as by name/price/category.
5. Next comes the ServiceImplementation class that implements the interface to override the respective method's transaction logic.
6. For each and every wrong entry , I have ensured a proper message is being displayed to the client without being actually accepting the wrong entry to the database, I have used Validation constraints as well as handled every exception casuing part with Global Exception Handler managing the Custom Exception seamlessly.
7. Now comes the controller layer, from which I am supposed to control the definite endpoints of the respective transactions by assigning different ,unique URLs.
8. To top it off, I have then tried to implement Spring Security by exploring it's various types : starting with the basic username an pass to assigning user Roles to different users and encoding their passwords along with restricting transactions to specific users(ON DEMAND) for enhanced security. For this I have taken help from materials that was offered to me by senior along with a lil modification from Gemini.
9. Last but not the least I have implemented JUnit test cases to validate each and every transactional method and check whether the logic is valid to complete an entire client-server request.



My AI Usage :-

Before starting ,I would like to mention that wherever I have used AI to figure out what was not going r8, after selecting the rectified and augmented form of the code, I tried to understand and then implement it in the project rather than blindly copying. Moreover the parts where AI has been used, has been committed with a commit msg for better understanding of the interviewer.
Also, I have used Gemini Pro to help me with my assignment.

<img width="1434" height="370" alt="Error Faced While Creating Sweets" src="https://github.com/user-attachments/assets/55161df4-40b8-4b89-9c0a-bb9db9d12b09" />


1. I faced the first error while trying to create/add a sweet to the inventory :I fixed this with the help of Gemini to understand where was I going wrong.
2. I have used Gemini to generate meaningful documentation with the help of comments.
3. I was facing problem in implementing Security User Roles to different transactions when I tried to understand how can I implement security at user level and admin level differently or togetherly such as Delete only by ADMINS or GET can be achieved by all irrespective of the user types
4. At some points, there were warnings with the lines of code which I have tried to eliminate my incorporating Java 8 features such as lambda expression or Java Stream API for clean and optimised lines of code.
5. I have used Gemini to leverage generation of my unit test cases validation which really helped me to save time along with delivering a better understanding of BDD style test cases. 


Conclusion :- Although there aren't much takeaways till the part that I have done since I have already got my hands dirty on creating endpoints earlier, one of the key aspects of this project is AI aiding our everyday work to automate certain tasks really saves time to overview the critical points which aren't to be missed for an effective and overall code sanctity. I also got to face the so called "DEADLINE PRESSURE" for the very first time while trying to articulate a product for an organization for the very first time and realy enjoyed the underlying challenges faced while trying to touch the finish line.
That was all about this project, waiting to learn more from you guys to have an industry level experience on how actual projects work, to the depth that me as a developer need to explore to excel in my journey.

Eagerly anticipating for an opportunity to sharpen my skills on development at your estemeed organization , to learn and grow more, grow my connections as well as how it feels to work as a team to which I don't have any prior experience for!!

API ENDPOINTS OVERVIEW ---->

User Sign in :-

<img width="1907" height="1079" alt="User Sign in" src="https://github.com/user-attachments/assets/d2a1791e-5f8b-4de4-83cc-2788d6dbb052" />




Getting All Demo Sweets :-

<img width="1442" height="947" alt="Getting All Demo Sweets" src="https://github.com/user-attachments/assets/617d3caf-e329-4429-818b-84fe66ece774" />



Getting a sweet by it's price :-

<img width="1434" height="941" alt="Getting a sweet by it's price" src="https://github.com/user-attachments/assets/ba2b6c82-adeb-4d7a-af28-b3bd77ef60bc" />



Fetching a sweet while Inventory is empty :-

<img width="1428" height="945" alt="Fetching a sweet while Inventory is empty" src="https://github.com/user-attachments/assets/fa99eeb3-5605-42cd-8f33-fd6bdaa86456" />



Creating a Sweet in the Inventory :-

<img width="1447" height="959" alt="Creating a Sweet in the Inventory" src="https://github.com/user-attachments/assets/92d3084f-a972-464a-b489-9ae4a88e96cd" />



Updating an existing sweet by it's ID :-

<img width="1406" height="913" alt="Updating an existing sweet by it's ID" src="https://github.com/user-attachments/assets/27a6d9cc-ab27-409e-83bb-cae314ae51f5" />



Deleting a sweet with id :-

<img width="1382" height="852" alt="Deleting a sweet with id" src="https://github.com/user-attachments/assets/30f72f76-36ec-4e67-aebf-65e549ba2a77" />



Logging out Basic Security :-

<img width="1918" height="906" alt="Logging out Basic Security" src="https://github.com/user-attachments/assets/d89de588-d2d1-4549-b46b-c55868c0f54e" />



Interface After Signing out :-

<img width="1905" height="964" alt="Interface After Signing out" src="https://github.com/user-attachments/assets/b7851668-66b6-41d6-9723-dbd62b47173a" />



Interface after putting User and Admin roles class :-

<img width="1919" height="1001" alt="Interface after putting User and Admin roles class" src="https://github.com/user-attachments/assets/ad32b52c-7ce5-46b5-bd24-5f804751bbc9" />



After Signing in :-

<img width="964" height="681" alt="After Signing in" src="https://github.com/user-attachments/assets/1a86025f-55b1-4ea3-8b65-cfcf6f719b58" />



Not allowed to create without user and pass :-

<img width="1411" height="984" alt="Not allowed to create with without user and pass" src="https://github.com/user-attachments/assets/e50edf1d-63d6-42e6-a311-44913d720128" />



Not allowed to fetch with Basic Authentication without username and pass :-

<img width="1422" height="922" alt="Not allowed to fetch with Basic Authentication without username and pass" src="https://github.com/user-attachments/assets/6a8af4d2-c639-4d10-87d2-d67a2b7f10fe" />



Allowed to fetch empty inventory after giving correct username and password :-

<img width="1447" height="977" alt="Allowed to fetch empty inventory after giving correct username and password" src="https://github.com/user-attachments/assets/fbbeb63c-69d2-4861-9ef5-799f48069604" />


Not Authorized to delete a sweet without username and pass :-

<img width="1446" height="973" alt="Not Authorized to delete a sweet without username and pass" src="https://github.com/user-attachments/assets/e65f4675-66f0-41e9-b157-d97724c1cd97" />



Not Authorized to delete a sweet without username and pass :-

<img width="1455" height="947" alt="User allowed to update sweets after assigning ROLES before mapping class" src="https://github.com/user-attachments/assets/37565539-4d3b-4daa-94ae-13c002ddd62e" />



Restricting Delete access only to ADMIN :-

<img width="1445" height="932" alt="Restricting Delete access only to ADMIN" src="https://github.com/user-attachments/assets/e39338a6-0981-427b-87be-92f67674e55d" />



Allowed to fetch empty inventory after giving correct username and password :-

<img width="1447" height="977" alt="Allowed to fetch empty inventory after giving correct username and password" src="https://github.com/user-attachments/assets/f0b6a4ca-869c-4e42-8eed-07872eb24fd7" />



User allowed to update sweets after assigning ROLES before mapping class :-

<img width="1455" height="947" alt="User allowed to update sweets after assigning ROLES before mapping class" src="https://github.com/user-attachments/assets/014ab17f-ccdd-409b-95c5-4ac32a002f0a" />



USER not allowed to remove a sweet with 403 Forbidden error code :-

<img width="1452" height="949" alt="USER not allowed to remove a sweet with 403 Forbidden error code" src="https://github.com/user-attachments/assets/be4aec87-7138-41af-89d6-526196e9fd48" />



ADMIN not allowed to add sweet in inventory :-

<img width="1449" height="955" alt="ADMIN not allowed to add sweet in inventory" src="https://github.com/user-attachments/assets/77496e70-3478-4096-ab1a-4871705b44fc" />



Admin allowed to fetch sweets from shop :-

<img width="1443" height="936" alt="Admin allowed to fetch sweets from shop" src="https://github.com/user-attachments/assets/4a985763-ca56-4ec0-87e9-ccfd6e4742be" />



ADMIN allowed to add sweet in the inventory :-

<img width="1441" height="942" alt="ADMIN allowed to add sweet in the inventory" src="https://github.com/user-attachments/assets/dba70341-3fa5-49b0-a7fa-f1b74a33c661" />



ADMIN allowed to remove a sweet from inventory :-

<img width="1450" height="894" alt="ADMIN allowed to remove a sweet from inventory" src="https://github.com/user-attachments/assets/05d364d3-1bff-461a-956a-7e2e61059ba0" />




--> Next comes the test cases, here I have used JUnit Unit Test cases by BDD style to authenticate each functionalities of the project.       
--> The positive test cases that have passed display a message 'Passed' along with an error colour green and the failed ones signify negative test cases.
--> All the test cases have their respective labels along with it to help the interviewer have an idea regarding what should be the outcome of each of the test cases. 
--> Some positive test cases have been altered to bring the negative result.

Positive Test Case 1 :-

<img width="1805" height="571" alt="Positive Test Case 1" src="https://github.com/user-attachments/assets/13fa6385-aec2-4327-8695-00750df98c91" />



Positive Test Case 2 :-

<img width="1840" height="586" alt="Positive Test Case 2" src="https://github.com/user-attachments/assets/2ff72896-a67e-4494-b2a4-2838710fdbec" />

 
 
 Positive Test Case 3 :-

<img width="1860" height="689" alt="Positive Test Case 3" src="https://github.com/user-attachments/assets/5ef18416-6eb8-4441-9769-8e7178481ba0" />



Negative Test Case 1 :-

<img width="1788" height="795" alt="Negative Test Case 1" src="https://github.com/user-attachments/assets/7191fdad-0602-4cf9-8186-c178a19f0ea3" />



Positive Test Case 4 :-

<img width="1868" height="785" alt="Positive Test Case 4" src="https://github.com/user-attachments/assets/87009df2-c681-45d5-af04-c11693b8661d" />



Negative Test Case 2 :-

<img width="1861" height="579" alt="Negative Test Case 2" src="https://github.com/user-attachments/assets/0cafb8b8-5e09-4050-8cc7-8d58dd723639" />



Positive Test Case 5 :-

<img width="1872" height="742" alt="Positive Test Case 5" src="https://github.com/user-attachments/assets/e5b018ad-fe35-4a0d-aae8-ea079d851baa" />



Positive Test Case 6 :-

<img width="1867" height="662" alt="Positive Test Case 6" src="https://github.com/user-attachments/assets/bde4b14c-41d3-40fd-874a-ae89b82a49e1" />



Negative Test Case 3 :-

<img width="1876" height="606" alt="Negative Test Case 3" src="https://github.com/user-attachments/assets/9e4465fd-5241-40e9-8326-a61b69941dae" />



Positive Test Case 7 :-

<img width="1856" height="498" alt="Positive Test Case 7" src="https://github.com/user-attachments/assets/1744586e-8869-402f-bad9-c02550142367" />



Negative Test Case 4 :-

<img width="1870" height="635" alt="Negative Test Case 4" src="https://github.com/user-attachments/assets/c01af535-1f86-4cab-b200-f62950c7ab80" />
