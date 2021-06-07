[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/faniabdullah/bangkit-final-project">
    <img src="https://i.imgur.com/ABJzG5P.png" width='400dp' alt="Logo" >
  </a>

  <h3 align="center">SkinSkan App </h3>

  <p align="center">
    Application that helps users to know how to help users examine their own bodies to detect early stage skin cancer.
   This is a project to fulfill the  <a href="https://grow.google/intl/id_id/bangkit/"><strong>Bangkit Academy led by Google, Tokopedia, Gojek, & Traveloka »</strong></a>
   Program.
    <br />
    <a href="https://github.com/faniabdullah/bangkit-final-project"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/faniabdullah/bangkit-final-project">View Demo</a>
    ·
    <a href="https://github.com/faniabdullah/bangkit-final-project/issues">Report Bug</a>
    ·
    <a href="https://github.com/faniabdullah/bangkit-final-project/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#machine-learning-development-documentation">Machine Learning Development Documentation</a></li>
        <li><a href="#mobile-development-documentation">Mobile Development Documentation</a></li>
        <li><a href="#cloud-computing-documentation">Cloud Computing Documentation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Skin cancer has symptoms that are difficult to distinguish from ordinary lumps and spots. In fact, melanoma skin cancer is the third deadliest cancer after cervical and breast cancer in Indonesia.

Solution is needed to find out how to assist users examining their own body to detect early-stage skin cancer.

## Machine Learning Development Documentation

The project is based from Google Colab (due to limited system requirements of our laptop/PC). Using Machine Learning with Tensorflow as framework to Classify the skin disease. 

Link to Colab: <br>
https://colab.research.google.com/drive/1EYhFL717FUyu_vZ7_Mmh0kJ_XZfzgVUe

- ## 1. Load Datasets 
  - Load datasets from modified dataset that we host to Google Drive, here is the link: <br> https://drive.google.com/file/d/1-dOK_6g-Bkf8_SKcZKUwiCIj8TSqC7O5/view?usp=sharing

- ## 2. Pre-processing Datasets
  - Defining target and feature from existing CSV file:
    - `df['cell_type']` as target
    - `df['img']` as feature
  - Spliting datasets into:
    - 80% of train data
    - 5% of validation data
    - 20% of test data
  - Balancing datasets with `imblearn.over_sampling` module
  - Resizing the datasets into 150 x 150 and convert it to numpy array

- ## 3. Training

   - Using transfer learning Xception to make model accuracy better.
   - Using `SparseCategoricalCrossentropy` as loss
   - Using `Adam(learning_rate=1e-5)` as optimizer 
   - Added more layer too to `model.Sequential` to make model accuracy more better:
     -  Added `AveragePooling2D` layer
     -  Added `Flatten` layer
     -  Added `Dense(units=64, activation='relu')` layer 
     -  Added `Dropout(units=0.05)` layer
     -  Added more `Dense(units=16, activation='relu')` layer
     -  Added output layer `Dense(units=2, activation='sigmoid' kernel_regularizer=l2(0.01))`
  - Training with 20 epochs
  - Set the callbacks `EarlyStopping` to stop training when accuracy doesn't improve
  - Set the callbacks `ModelCheckpoint` to saved the model (also the weight) in every epochs with *.h5 format  
  - From the result, got:
    - `loss: 33%`
    - `accuracy: 97%`
    - `val_loss: 60%`
    - `val_accuracy: 89%`

- ## 4. Saved the Model to Google Drive

  - Then, saved the model (*.h5 format) to Google Drive (saved only the best model to Google Drive):<br>
https://drive.google.com/file/d/1-0ODyEWBJcERmvXXM5Ejk_VoxV7gI6SW/view






<!-- Mobile Development Documentation -->
## Mobile Development Documentation


 - ### Feature
      * **Splash screen**, in this application there is a splashscreen before entering the main page

      * **Show case**, there is showcase feature for guides when you first use this application

      * **Support dark mode**, you can change the dark / light theme on your smartphone, so this app can customize the dark / light theme by setting it on your smartphone.

      * **Pick image from gallery**, you can select an image from the gallery in preparation for uploading an image to detect malignant or benign skin cancer.
 
      * **Take an image from camera**, you can take image from camera in preparation for uploading an image to detect malignant or benign skin cancer.

      * **Send image to the cloud to get prediction**, after you prepare the image, you can click the process button to send the image and detect the image is benign or malignant skin cancer

     * **Find nearby hospitals**, You can see the nearest hospital from your location , This is useful for helping you find the nearest hospital in your location so that it is faster to get the first treatment / examination.

     * **Skin cancer and skin care related article**,  in this application you can read articles about skin cancer


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
    

## Cloud Computing Documentation

- ### 1. Write the Flask server app using Python
  - Save the model in '.h5' format in the same directory as `main.py`
  - Load the model and write Flask code in `main.py`
  - Test the Flask server locally by running `main.py`, copy the assigned local URL to `test.py` then run it with test images.
- ### 2. Setup Google Cloud
  - Enable Cloud Run and Cloud Build API
- ### 3. Install and init Google Cloud SDK
  - https://cloud.google.com/sdk/docs/install

- ### 4. Dockerfile, requirements.txt, .dockerignore
  - https://cloud.google.com/run/docs/quickstarts/build-and-deploy#containerizing
- ### 5. Cloud build & deploy
    ```
    gcloud builds submit --tag gcr.io/just-program-311914/cancerprediction
    ```

    ```
    gcloud run deploy --image gcr.io/just-program-311914/cancerprediction --platform managed
    ```

- ### Test

  - Test the code with `test/test.py` with the Cloud Build image URL

<!-- USAGE EXAMPLES -->
## Usage

<p align="center"> 
    <img src="https://media.giphy.com/media/jNCU8W4WuolTGeNHgP/giphy.gif"
        alt="SplashScreen"    
        style="margin-right: 10px;"    
        width="150" />
    <img src="https://media.giphy.com/media/k8Yp7JzdZkjlOEvRxQ/giphy.gif"
        alt="Create Image"    
        style="margin-right: 10px;"    
        width="150" />
    <img src="https://media.giphy.com/media/muOvgYcShlIwuMEdph/giphy.gif"
        alt="Send Image"    
        style="margin-right: 10px;"    
        width="150" />
    <img src="https://media.giphy.com/media/2fOFDiROVCK5eCMMLw/giphy.gif"
        alt="Nearest Hospital"    
        style="margin-right: 10px;"    
        width="150" />
    <img src="https://media.giphy.com/media/n8iBaoVwxexcsLgSXn/giphy.gif"
        alt="Article"    
        style="margin-right: 10px;"    
        width="150" />
</p>


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

[Rheivant Bosco Theoffilus ](https://www.linkedin.com/in/rheivant-bosco-theoffilus-1839991b8/) - rheivant4@gmail.com

[Fani Abdullah ](https://www.linkedin.com/in/fani-abdullah/) - faniabdullah27@gmail.com

[Saharudin](#) -  saharudinsh98@gmail.com 

[Auzan Widhatama](https://www.linkedin.com/in/auzan-widhatama-7986ba16b/) -widhatamaauzan@gmail.com

[Muhammad Naufal  ](https://www.linkedin.com/in/muhammad-naufal-9745b2175/) - mnaufal0999@gmail.com

[Imam Lutfi Rahmatullah  ](https://www.linkedin.com/in/imam-lutfi-r-27980711a/) - lutfi640@gmail.com



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/faniabdullah/bangkit-final-project.svg?style=for-the-badge
[contributors-url]: https://github.com/faniabdullah/bangkit-final-project/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/faniabdullah/bangkit-final-project.svg?style=for-the-badge
[forks-url]: https://github.com/faniabdullah/bangkit-final-project/network/members
[stars-shield]: https://img.shields.io/github/stars/faniabdullah/bangkit-final-project.svg?style=for-the-badge
[stars-url]: https://github.com/faniabdullah/bangkit-final-project/stargazers
[issues-shield]: https://img.shields.io/github/issues/faniabdullah/bangkit-final-project.svg?style=for-the-badge
[issues-url]: https://github.com/faniabdullah/bangkit-final-project/issues
[license-shield]: https://img.shields.io/github/license/faniabdullah/bangkit-final-project.svg?style=for-the-badge
[license-url]: https://github.com/faniabdullah/bangkit-final-project/blob/master/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
