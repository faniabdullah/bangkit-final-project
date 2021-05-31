## SkinSkan Datasets

  Source Datasets: <br>
  https://www.kaggle.com/kmader/skin-cancer-mnist-ham10000
  <br>
 
  This datasets contains of 10000 picture of Skin disease with 7 Classes and random size:

  | Name | Kind of Cancer | Amount |
  |------------|------| ----- |
  | Actinic keratoses | Benign | 327 |
  | Basal cell carcinoma | Benign | 514 |
  | Benign keratosis-like lesions| Benign | 1099 |
  | Dermatofibroma | Benign | 115 | 
  | Melanocytic nevi | Benign | 6705 |
  | Melanoma | Malignant | 1113 | 
  | Vascular lesion | Benign | 142 |

  <br>
 
  Since the datasets is big enough to train, and has random size. And if you see to the table above, you can see, the data is super imbalanced, so we modify the datasets to fit to our model.

  Here some change that we apply to that datasets:
  
  - We resize all of the datasets from random size to 150x150px
  - We classify with Melanoma as Malignant (Deadliest Cancer) and else as Benign (Not Deadliest Cancer): 

    | Name | Kind of Cancer | Label | Amount |
    |------------|------|------|-|
    | Actinic keratoses | Benign | 0 | 327 |
    | Basal cell carcinoma | Benign | 0 | 514 |
    | Benign keratosis-like lesions| Benign | 0 | 1099 |
    | Dermatofibroma | Benign | 0 | 115 |
    | Melanocytic nevi | Benign | 0 | 6705 |
    | Melanoma | Malignant | 1 | 1113 |
    | Vascular lesion | Benign | 0| 142 |

    <br>then, the dataset will be: 

    | Kind of Cancer | Label | Amount
    |------------|------|------|
    | Benign | 0 | 8902 |
    | Malignant | 1 | 1113 |
    <br>

  - Since the datasets is super imbalanced, so we decide to balancing the dataset with shuffling into near 1113 (Malignant) so the datasets is changed to:
  
    | Kind of Cancer | Label | Amount
    |------------|------|------|
    | Benign | 0 | 1257 |
    | Malignant | 1 | 1113 |
    <br>

  then, after modified datasets, we hosted the datasets to Google Drive via Google Colab.

  - Here is the modified datasets: <br> https://drive.google.com/file/d/1-dOK_6g-Bkf8_SKcZKUwiCIj8TSqC7O5/view?usp=sharing <br>
  - Here is colab notebook: https://colab.research.google.com/drive/1LsXVGeixr3VzgMzpBS0bUAGg7uFoqBHA <br>
