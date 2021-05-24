# Trial Model of Skin Cancer Detection:

There is 4 Method for Classification with using same datasets but with different processing of the datasets, here is the source of the datasets <br>

- Source Datasets: <br>
  https://www.kaggle.com/kmader/skin-cancer-mnist-ham10000
  <br>
 
 This datasets contains of 10000 picture of Skin disease with 7 Classes with Melanoma is Malignant (Deadliest Cancer) and else is Benign (Not Deadliest Cancer), but we divided it into 7,5,3 and 2 Classes. Here we using Machine Learning with Tensorflow as framework to Classify the skin disease by using transfer learning Xception, here is the Labels, Modified Datasets and also Saved Model (*.h5 format): 


- Label of Classification
    <br>
    - 7 Classes <br> <br>

    | Label Name | Label Alias | Label Number |
    |------------|-------------|--------------|
    | Actinic keratoses | AKIEC | 0 |
    | Basal cell carcinoma | BCC | 1 |
    | Benign keratosis-like lesions | BKL | 2 |
    | Dermatofibroma | DF | 3 |
    | Melanocytic nevi | NV | 4 |
    | Melanoma | MEL | 5 | 
    | Vascular lesion | VASC | 6 |

    <br>

   - 5 Classes <br> <br>

    | Label Name | Label Alias | Label Number |
    |------------|-------------|--------------|
    | Actinic keratoses | AKIEC | 0 |
    | Basal cell carcinoma | BCC | 1 |
    | Benign keratosis-like lesions | BKL | 2 |
    | Melanocytic nevi | NV | 3 |
    | Melanoma | MEL | 4 | 

    <br>

   - 3 Classes <br> <br>

    | Label Name | Label Alias | Label Number |
    |------------|-------------|--------------|
    | Benign keratosis-like lesions | BKL | 0 |
    | Melanocytic nevi | NV | 1 |
    | Melanoma | MEL | 2 | 

    <br>
    
    - 2 Classes <br> <br>

    | Label Name | Label Alias | Label Number |
    |------------|-------------|--------------|
    | Melanocytic nevi | NV | 0 |
    | Melanoma | MEL | 1 | 

    <br>
    
    - Another 2 Classes <br> <br>

    | Label Name | Label Alias | Label Number |
    |------------|-------------|--------------|
    | Benign | Benign | 0 |
    | Malignant | Malignant | 1 | 

    <br>


- Modified Dataset: 
  - For 7 Classes: <br> https://drive.google.com/file/d/1056M1Q1qKlrXjepEmZ7AdeJiVjuhpGHQ/view?usp=sharing
  - For 5 Classes: <br> https://drive.google.com/file/d/1f2JVeoGCb8LwP8gGfnvXms83bFUtLtKB/view?usp=sharing
  - For 3 Classes: <br> https://drive.google.com/file/d/127GzJ-ymLp6GJ-SBGRIQ6O0UMFU0hciU/view
  - For 2 Classes: <br> https://drive.google.com/file/d/1-0M6UNePLF9i3jUjHEv_-5b8qAKP1vZt/view?usp=sharing
  - For Another 2 Classes: <br> https://drive.google.com/file/d/1-dOK_6g-Bkf8_SKcZKUwiCIj8TSqC7O5/view?usp=sharing

- Saved Model from Training (with Keras *.h5 Format): 
  - For 7 Classes (97.12% Accuracy Score with using Xception transfer learning, Adam optimizer, and softmax activation function): <br> https://drive.google.com/file/d/1-4HGDErWwQbvMERzcOWU8RSvN9Y7xxqu/view?usp=sharing 
  - For 5 Classes (97.42% Accuracy Score with using Xception transfer learning, Adam optimizer, and softmax activation function): <br> https://drive.google.com/file/d/13uKS9-9caD2DkXVbphIeGKbOpwuIzE8p/view?usp=sharing
  - For 3 Classes (98.39% Accuracy Score with using Xception transfer learning, Adam optimizer, and sigmoid activation function): <br> https://drive.google.com/file/d/1jCNrjU7lvV2oAplerSM3mxEvLQxsweER/view?usp=sharing
  - For 2 Classes (96.77% Accuracy Score with using Xception transfer learning, Adam optimizer, and sigmoid activation function): <br> https://drive.google.com/file/d/1-AcxUa8EREHXKB8njEpU7DrMUhVcNFXq/view?usp=sharing
  - For Another 2 Classes (98.02% Accuracy Score and 91.2% Val_Accuracy Score with using Xception transfer learning, Adam optimizer, and sigmoid activation function): <br> https://drive.google.com/file/d/1-0ODyEWBJcERmvXXM5Ejk_VoxV7gI6SW/view?usp=sharing
  - For Another 2 Classes with different (299x299) input_size  (97% Accuracy Score but unfortunately only get 85% to Val_Accuracy Score with using Xception transfer learning, Adam optimizer, and sigmoid activation function): <br> https://drive.google.com/file/d/1UY4Et1v6M1c6oqBoOkwAkAnq4aESSnkI/view?usp=sharing

- Link to Colab: 
  - For 7 Classes: <br> https://colab.research.google.com/drive/1uZok6x_hqwiDW6L72qwRA6Z-9k4Yyj3f?authuser=3#scrollTo=X5pRod37ZpTM
  - For 5 Classes: <br> https://colab.research.google.com/drive/1Q2euYsu8JeRCeBug8Rq5Fpf3htG4A7f-#scrollTo=188HRGXvnAGD
  - For 3 Classes: <br> https://colab.research.google.com/drive/1zqd7YBTCgPJt9keE0s_E7rg0toZX09ks?authuser=3#scrollTo=h-uQ6q7ZWVGr
  - For 2 Classes: <br> https://colab.research.google.com/drive/1cOl4ck-uhdHogjwtDxkvJQjDWEqB09nk?authuser=3#scrollTo=h-uQ6q7ZWVGr
  - For another 2 Classes: <br> https://colab.research.google.com/drive/1jYAhXByVsM00mKK3Bzm8IO7nRR0na_wy?authuser=3#scrollTo=o52Wz27RSBk
  - For another 2 Classes with different (299x299) input_size: <br> https://colab.research.google.com/drive/1IxN386vN8CzD_Ya2QpN2fZmSv5FdSfAB?authuser=3#scrollTo=L_YNqWlHtg1U

