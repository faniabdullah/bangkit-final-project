# Skin Cancer Detection:

  Source Datasets: <br>
  https://www.kaggle.com/kmader/skin-cancer-mnist-ham10000
  <br>
 
  This datasets contains of 10000 picture of Skin disease with 7 Classes:

  | Name | Kind of Cancer |
  |------------|------|
  | Actinic keratoses | Benign |
  | Basal cell carcinoma | Benign |
  | Benign keratosis-like lesions| Benign |
  | Dermatofibroma | Benign |
  | Melanocytic nevi | Benign |
  | Melanoma | Malignant | 
  | Vascular lesion | Benign |

  <br>
 
  with Melanoma is Malignant (Deadliest Cancer) and else is Benign (Not Deadliest Cancer)

  but we divided it into only 2 Classes, Melanoma classify as Malignant and Actinic Keratoses, Basal Cell Carcinoma, Benign keratosis-like lesion, Dermatofibroma, Melanocytic Nevi and Vascular lession as Benign. here is the modified datasets: <br> https://drive.google.com/file/d/1-dOK_6g-Bkf8_SKcZKUwiCIj8TSqC7O5/view?usp=sharing <br>

  so the label will be:<br>

  | Name | Kind of Cancer | Label |
  |------------|------|------|
  | Actinic keratoses | Benign | 0 |
  | Basal cell carcinoma | Benign | 0 |
  | Benign keratosis-like lesions| Benign | 0 |
  | Dermatofibroma | Benign | 0 |
  | Melanocytic nevi | Benign | 0 |
  | Melanoma | Malignant | 1 |
  | Vascular lesion | Benign | 0|

  <br>
  
  Here we using Machine Learning with Tensorflow as framework to Classify the skin disease, here is the Saved Model (*.h5 format) with 98.02% Accuracy Score and 91.2% Val_Accuracy Score with using Xception transfer learning, Adam optimizer, and sigmoid activation function): <br> https://drive.google.com/file/d/1-0ODyEWBJcERmvXXM5Ejk_VoxV7gI6SW/view <br> but if you want the TensorFlow SavedModel here is the links: <br> https://drive.google.com/file/d/1-4cHcx5t7IUbJSJWOyMgK8WO-selZwB0/view?usp=sharing

<br>

  If you curious with this model, you can visit the colab: <br>
  Load_Models (Here is the tested notebook, we tested the model with ~7-8 different datasets that listed on the notebook): <br> https://colab.research.google.com/drive/1pkckJod5uwbcDkVAgC16spk0MBV75usw <br>
  Skin_Cancer_Detection: <br> https://colab.research.google.com/drive/1EYhFL717FUyu_vZ7_Mmh0kJ_XZfzgVUe <br>
  Converting_Datasets: <br> https://colab.research.google.com/drive/1LsXVGeixr3VzgMzpBS0bUAGg7uFoqBHA 
