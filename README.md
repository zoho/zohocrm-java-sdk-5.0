# ZOHO CRM JAVA SDK 5.0 for API version 5

The Java SDK for Zoho CRM allows developers to easily create Java applications that can be integrated with Zoho CRM. This SDK serves as a wrapper for the REST APIs, making it easier to access and utilize the services of Zoho CRM. 
Authentication to access the CRM APIs is done through OAuth2.0, and the authentication process is streamlined through the use of the Java SDK. The grant and access/refresh tokens are generated and managed within the SDK code, eliminating the need for manual handling during data synchronization between Zoho CRM and the client application.

This repository includes the JAVA SDK for API v5 of Zoho CRM. Check [Versions](https://github.com/zoho/zohocrm-java-sdk-5.0/releases) for more details on the versions of SDK released for this API version.

License
=======

    Copyright (c) 2021, ZOHO CORPORATION PRIVATE LIMITED 
    All rights reserved. 

    Licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 
    You may obtain a copy of the License at 
    
        http://www.apache.org/licenses/LICENSE-2.0 
    
    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

## Latest Version

- [3.0.0](/versions/3.0.0/README.md)
    
    - **Email-related records API:** API pagination fix to handle ***next_index*** and ***prev_index*** field datatype.
    - **User-specific fields:** Resolved conflicts in the metaclass names of user-specific fields.

- [2.0.0](/versions/2.0.0/README.md)

    - Records APIs Issue fixed. 
        - Supported delete operation in multi-select lookup, multi-user lookup, image upload, and subform fields.

- [1.0.0](/versions/1.0.0/README.md)

    - JAVA SDK upgraded to support v5 APIs.

    - JAVA SDK improved to support the following new APIs

        - [User Groups API](https://www.zoho.com/crm/developer/docs/api/v5/associated-user-count-user-group.html)
        - [Fiscal Years](https://www.zoho.com/crm/developer/docs/api/v5/get-fiscal-year.html)
        - [Timeline API](https://www.zoho.com/crm/developer/docs/api/v5/timeline-of-a-record.html)
        - [Transfer and Delete Users](https://www.zoho.com/crm/developer/docs/api/v5/transfer_records-delete_user.html)
        - [Territories](https://www.zoho.com/crm/developer/docs/api/v5/add-territories.html)
        - [Territories Users](https://www.zoho.com/crm/developer/docs/api/v5/associate-users-territory.html)     


For older versions, please [refer](https://github.com/zoho/zohocrm-java-sdk-5.0/releases).


## Including the SDK in your project
You can include the SDK to your project using:
- Maven
- [Gradle](/versions/3.0.0/README.md#including-the-sdk-in-your-project)
- [Download SDK jar](https://maven.zohodl.com/com/zoho/crm/zohocrmsdk-5-0/3.0.0/zohocrmsdk-5-0-3.0.0.jar)

For including the latest [version](https://github.com/zoho/zohocrm-java-sdk-5.0/releases/tag/3.0.0) using Maven, include the following in your **pom.xml** file, which will get created once your **Java** project is created using Maven.

    ```xml
    <repositories>
        <repository>
            <id>zohocrmsdk-5-0</id>
            <url>https://maven.zohodl.com</url>
        </repository>
    </repositories>
    <dependencies>
        <dependency>
            <groupId>com.zoho.crm</groupId>
            <artifactId>zohocrmsdk-5-0</artifactId>
            <version>3.0.0</version>
        </dependency>
    </dependencies>
    ```

For more details, kindly refer [here](/versions/3.0.0/README.md).
