# DisneyCharactersApp
This is an application to understand Clean Architecture and Kotlin technologies.

## Project Screens
HOME SCREEN | DETAİL SCREEN | DETAİL SCREEN | 
--- | --- | --- | 
![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/225892455-29183c28-ed0b-4398-a58c-a710e9454a54.png) |![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/225892463-1ca2faef-f3c2-4037-8e44-bc0b971d149c.png) |![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/225892468-6ace2dd4-9c69-4eb7-b458-e76b747721bc.png) |

## Project Tech stack 

- [Kotlin](https://developer.android.com/kotlin)
 
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

- [Kotlin Flow](https://developer.android.com/kotlin/flow)

- [Kotlin Coroutine](https://developer.android.com/kotlin/coroutines)
 
- [Dependency Injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

- [Navigation Componenet](https://developer.android.com/guide/navigation)

- [Retrofit](https://square.github.io/retrofit/)

- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)

- [UseCase](https://developer.android.com/topic/architecture/domain-layer)

- [Repository](https://developer.android.com/topic/architecture/data-layer)

- [Glide ](https://github.com/bumptech/glide)




### MVVM

MVVM and the interface work and background studies are separated and the complexity of the code is minimized. Each class only defines and performs its tasks.
MVVM has a more common use than other design patterns, and offers more modularity, easy tested and layered structure is a good functioning task among display and model layers.

### Clean Architecture

Clean Architecture is a form of code development approach and is a structure that adopts SOLID principles.
The purpose of Clean Architecture is to minimize the complexity of code, the complexity of the application. Although it does not matter in small projects, it has a vital value in large projects.
Thanks to Clean Architecture, we can write clean, tested and maintained, rearranged codes. With the MVVM, the most used architecture used by Android developers, we can easily apply Clean Architecture rules. But Clean Architecture is only. It can be used not with MVVM, but also with all other design patterns.



![1__-3tHh_mgOo9tpc58alMjA](https://user-images.githubusercontent.com/85341568/225907932-91779a5a-417f-424c-a118-33ce969efe3a.jpeg)

- Use Casses: Clean Architecture approach is thought to be considered independent of business logic and business processes, system components and technical details. Therefore, Use Case is used. Each usage situation performs a function in the system and is for a particular purpose. Use Case conducts a task for business logic and business processes and plays an important role in system design.

- Repository : The Repository pattern helps to make the application code more modular, tested and easy to maintain by abstracting access to the data source from other layers of the application (user interface, business logic, etc.). For example, when the application needs to change its access to a data source (for example, when it decides to use a web service instead of a database), it can only make this change in the repository class in the data access layer and do not need to change other layers of the application


 ## Project Graph
 
 - This app uses [MVVM (Model View View-Model)](https://developer.android.com/topic/architecture#recommended-app-arch) architecture
 
##### Main packages of this project

 <img width="344" alt="Ekran Resmi 2023-03-18 11 13 55" src="https://user-images.githubusercontent.com/85341568/226093937-7f5ea02c-18ed-4790-86ed-56188ec2b698.png">
 
 ### [Data Layer](https://developer.android.com/topic/architecture/data-layer)
 
 -  This layer performs operations to retrieve data from data sources and to write data to data sources. When retrieving data from data sources, it may process, filter, sort, and organize the data as necessary. The data layer typically includes data access objects (DAOs) and data source processing classes. This layer is completely independent from the other layers of the application and acts based on requests from other layers.
 
![Data Layer (1)](https://user-images.githubusercontent.com/85341568/226093831-e64ae864-a2de-419a-97cc-479bbccfd41d.jpg)
 
 ### [Domain Layer](https://developer.android.com/topic/architecture/domain-layer)
 
 - This layer contains the core business logic and entity models on which the application functionality is focused. In this layer, application features and functionalities are identified, and their requirements and use cases are analyzed. Usually, the business processes and rules are defined in the classes and methods of this layer. The domain layer does not include interaction with the external world (user interface, database operations, etc.) and is completely independent, so it can be integrated or replaced with another application.
 
![Data Layer (3)](https://user-images.githubusercontent.com/85341568/226094960-64c15987-1851-4ced-b877-b149bb37b959.jpg)

 ### [Ui Layer](https://developer.android.com/topic/architecture/ui-layer)
 
 - This layer provides the design and functionality of the user interface. The user interface typically collects input from the user to process and displays results to the user. The user interface can communicate with other layers of the application and pass user actions to the application layers. This layer includes user interface components (activity, fragment, view, adapter, etc.) and classes that handle user events. 

![Data Layer (4)](https://user-images.githubusercontent.com/85341568/226097545-022eb787-b7a7-47d6-ae2c-9a70c83ef231.jpg)

### API

[Disney Character Api](https://disneyapi.dev)

### License
```license
MIT License

Copyright (c) 2023 Sahin Karadeniz 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

 
