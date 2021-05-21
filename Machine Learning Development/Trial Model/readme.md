# Trial Model of Skin Cancer Detection:

There is 3 Method for Classification with using same datasets but with different processing of the datasets, here is the source of the datasets <br>

- Source Datasets: <br>
  https://www.kaggle.com/kmader/skin-cancer-mnist-ham10000
  <br>
 
 This datasets contains of 10000 picture of Skin disease with 7 Classes. Here we using Machine Learning with Tensorflow as framework to Classify the skin disease by using transfer learning Xception, here is the Labels, Modified Datasets and also Saved Model (*.h5 format): 


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


- Modified Dataset: 
  - For 7 Classes: <br> https://drive.google.com/file/d/1056M1Q1qKlrXjepEmZ7AdeJiVjuhpGHQ/view?usp=sharing
  - For 5 Classes: <br> https://drive.google.com/file/d/1f2JVeoGCb8LwP8gGfnvXms83bFUtLtKB/view?usp=sharing
  - For 3 Classes: <br> https://drive.google.com/file/d/127GzJ-ymLp6GJ-SBGRIQ6O0UMFU0hciU/view

- Saved Model from Training (with Keras *.h5 Format): 
  - For 7 Classes (97.12% Accuracy Score with using Xception transfer learning, Adam optimizer, and softmax activation function): <br> https://drive.google.com/file/d/1-4HGDErWwQbvMERzcOWU8RSvN9Y7xxqu/view?usp=sharing 
  - For 5 Classes (97.42% Accuracy Score with using Xception transfer learning, Adam optimizer, and softmax activation function): <br> https://drive.google.com/file/d/13uKS9-9caD2DkXVbphIeGKbOpwuIzE8p/view?usp=sharing
  - For 3 Classes (98.39% Accuracy Score with using Xception transfer learning, Adam optimizer, and sigmoid activation function): <br> https://drive.google.com/file/d/1jCNrjU7lvV2oAplerSM3mxEvLQxsweER/view?usp=sharing

- Link to Colab: 
  - For 7 Classes: <br> https://colab.research.google.com/drive/1uZok6x_hqwiDW6L72qwRA6Z-9k4Yyj3f?authuser=3#scrollTo=X5pRod37ZpTM
  - For 5 Classes: <br> https://colab.research.google.com/drive/1Q2euYsu8JeRCeBug8Rq5Fpf3htG4A7f-#scrollTo=188HRGXvnAGD
  - For 3 Classes: <br> https://colab.research.google.com/drive/1zqd7YBTCgPJt9keE0s_E7rg0toZX09ks?authuser=3#scrollTo=h-uQ6q7ZWVGr

