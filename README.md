# DisneyCharactersApp
This is a app for the understanding about Clean Architecture and Kotlin 

## Project Screens
HOME SCREEN | DETAİL SCREEN | DETAİL SCREEN | 
--- | --- | --- | 
![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/225892455-29183c28-ed0b-4398-a58c-a710e9454a54.png) |![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/225892463-1ca2faef-f3c2-4037-8e44-bc0b971d149c.png) |![Uygulama Ekran Görüntüsü](https://user-images.githubusercontent.com/85341568/225892468-6ace2dd4-9c69-4eb7-b458-e76b747721bc.png) |

## Project Tech stack & Open-source libraries

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

- Domain: Laytities, Value Object, Exceptions, and Logic Operations Are In this layer.

- Repository : The Repository pattern helps to make the application code more modular, tested and easy to maintain by abstracting access to the data source from other layers of the application (user interface, business logic, etc.). For example, when the application needs to change its access to a data source (for example, when it decides to use a web service instead of a database), it can only make this change in the repository class in the data access layer and do not need to change other layers of the applicatio
