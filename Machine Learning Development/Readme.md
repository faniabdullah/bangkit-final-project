# SkinSkan Model 

Our project is based from Google Colab (due to limited system requirements of our laptop/PC). Here we using Machine Learning with Tensorflow as framework to Classify the skin disease. 

Link to Colab: <br>
https://colab.research.google.com/drive/1EYhFL717FUyu_vZ7_Mmh0kJ_XZfzgVUe

## 1. Load Datasets 
  - Load Datasets from Modified dataset that we host to Google Drive, here is the link: <br> https://drive.google.com/file/d/1-dOK_6g-Bkf8_SKcZKUwiCIj8TSqC7O5/view?usp=sharing

## 2. Pre-processing Datasets
  - Defining target and feature from existing CSV file:
    - `df['cell_type']` as target
    - `df['img']` as feature
  - Spliting datasets into:
    - 80% of train data
    - 5% of validation data
    - 20% of test data
  - Balancing datasets with `imblearn.over_sampling` module
  - Resizing the datasets into 150x150 and convert it to numpy array

## 3. Training

   - Using transfer learning Xception to make model accuracy better.
   - Use `SparseCategoricalCrossentropy` as loss
   - We use `Adam(learning_rate=1e-5)` as optimizer 
   - We have used transfer learning but we add more layer too to model Sequential to make model accuracy more better:
     -  added `AveragePooling2D` layer
     -  added `Flatten` layer
     -  added `Dense(units=64, activation='relu')` layer 
     -  added `Dropout(units=0.05)` layer
     -  added more `Dense(units=16, activation='relu')` layer
     -  added output layer `Dense(units=2, activation='sigmoid' kernel_regularizer=l2(0.01))`
  - We train with 20 epochs
  - We set callbacks `EarlyStopping` to stop training when accuracy doesn't improve
  - We set callbacks `ModelCheckpoint` to saved the model (also the weight) in every epochs with *.h5 format  
  - From the result, we got:
    - loss: 33%
    - accuracy: 97%
    - val_loss: 60%
    - val_accuracy: 89%

## 4. Saved the Model to Google Drive

  - Then, we saved the model (*.h5 format) to Google Drive (We saved only the best model to Google Drive):<br>
https://drive.google.com/file/d/1-0ODyEWBJcERmvXXM5Ejk_VoxV7gI6SW/view
