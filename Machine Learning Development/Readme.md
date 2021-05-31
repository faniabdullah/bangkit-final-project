## SkinSkan Model 

Our project is based from Google Colab (due to limited system requirements of our laptop/PC).

Here some properties that we made for our model:

   - Here we using Machine Learning with Tensorflow as framework to Classify the skin disease (skin cancer).  
   - Using transfer learning Xception to make model accuracy better. Then, we got circa 97% accuracy on training data and circa 90% on validation data
   - Since this is only 2 classes, we supposed to be using BinaryClassification as loss, but here, we using SparseCategorical to make the result easy to understand and also readable (because with SparseCategorial we don't need to set the threshold, and can see percentage of Benign and Malignant because this loss turning the classification as array of each class) <br> 
   - We use Adam optimizer with Custom Learning Rate (0.0001)
   - We use transfer learning but we add more layer too to model Sequential:
     -  added AveragePooling2D layer
     -  added Flatten layer
     -  added Dense layer with units=64 and ReLU activation function
     -  added Dropout layer with units=0.05
     -  added more Dense layer with units=16 and ReLU activation function
     -  added output layer Dense with units=2 (since we use SparseCategorical as loss) and Sigmoid as activation function with kernel regularizer L2 with value=0.01
  - We train with 20 epochs
  - We set callbacks EarlyStopping to stop training when accuracy doesn't improve
  - We set callbacks ModelCheckpoint to saved the model (also the weight) in every epochs with *.h5 format
  
From the result, we got:
- loss: 33%
- accuracy: 97%
- val_loss: 60%
- val_accuracy: 89%

Then, we saved the model (*.h5 format) to Google Drive (We saved only the best model to Google Drive):<br>
https://drive.google.com/file/d/1-0ODyEWBJcERmvXXM5Ejk_VoxV7gI6SW/view

Link to Colab: <br>
https://colab.research.google.com/drive/1EYhFL717FUyu_vZ7_Mmh0kJ_XZfzgVUe