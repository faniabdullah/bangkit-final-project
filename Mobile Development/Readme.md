

<!-- ABOUT THE PROJECT -->
## Android Development Documentation


 - ### Feature
      * **Splash Screen**, in this application there is a splashscreen before entering the main page

      * **Show Case**, there is a showcase feature for tutorials when you first use this application

      * **Support Dark Mode**, You can change the dark / light theme on your smartphone, so this app can customize the dark / light theme by setting it on your smartphone.

      * **Pick Image From Gallery**, You can select an image from the gallery in preparation for uploading an image to detect malignant or benign skin cancer.
 
      * **Take Image From Camera**, You can take image from camera in preparation for uploading an image to detect malignant or benign skin cancer.

      * **Send image to server to detect malignant or benign skin cancer kanker**, After you prepare the image, you can click the process button to send the image and detect the image is benign or malignant skin cancer

     * **Find the nearest hospital**, You can see the nearest hospital from your location , This is useful for helping you find the nearest hospital in your location so that it is faster to get the first treatment / examination.

     * **Aticle About Skin Cancer**,  in this application you can read articles about skin cancer


* #### Dependencies :
  - [Lifecycle & Livedata](https://developer.android.com/jetpack/androidx/releases/lifecycle)
  - [Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation)
  - [kotlinx-coroutines](https://developer.android.com/kotlin/coroutines)    
  - [Retrofit 2](https://square.github.io/retrofit/)    
  - [Glide](https://github.com/bumptech/glide)    
  - [Material Show Case](https://github.com/deano2390/MaterialShowcaseView)  
  - [Ok Http 3](https://square.github.io/okhttp/) 
  - [Air Bnb Lottie](https://airbnb.io/lottie/#/) 
  - [Google Play services Maps](https://developers.google.com/maps/documentation/android-sdk/get-api-key) 

  ### Getting Started Application

  - ### Prerequisites
       - ##### Tools Sofware
        1. Android Studio at least version 4.1. [Android Studio](https://developer.android.com/studio)
        2. JRE (Java Runtime Environment) or JDK (Java Development Kit).
  
  - ### Installation
      1. Get a free API Key at [Google Maps Platform](https://developers.google.com/maps/documentation/android-sdk/get-api-key)
      2. Clone this repository and import into Android Studio    
          ```
             https://github.com/faniabdullah/bangkit-final-project.git
          ``` 
      4. Enter your API in buildConfigField `build.graddle`
         ``` defaultConfig {
            buildConfigField("String", "MAPS_TOKEN", '"Your Api Key"')}
         ```
  ## Acknowledgements
  * [Clean Architecture Guide](https://developer.android.com/jetpack/guide)
  * [Android Application Fundamental](https://developer.android.com/guide/components/fundamentals)
  * [Android Jetpack Pro](https://developer.android.com/jetpack)
  * [Dependency injection](https://developer.android.com/training/dependency-injection)
  * [Lottie Animation AirBnb ](https://choosealicense.com)
