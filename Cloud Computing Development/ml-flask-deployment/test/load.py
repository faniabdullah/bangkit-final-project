import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

import tensorflow as tf
from tensorflow import keras
from tensorflow.keras.preprocessing.image import ImageDataGenerator, load_img, img_to_array
import matplotlib.pyplot as plt
import numpy as np


model = keras.models.load_model("../skinskanmodel.h5")

# load the image
from PIL import Image
import io
with open('melanoma.jpg', 'rb') as file:
    image_bytes = file.read()
    pillow_img = Image.open(io.BytesIO(image_bytes)).convert('L')


# transform image, same as for training!
# data = np.asarray(pillow_img)
# data = data / 255.0
# data = data[-1, ..., 3]
# # --> [1, x, y, 1]
# data = tf.image.resize(data, [150, 150])

imgs = []

path = 'benign.jpg'
  
plt.imshow(load_img(path, target_size=(299, 299)))
  
img = load_img(path, target_size=(150, 150))
img = img_to_array(img)
img = img.astype(np.float32) / 255
imgs.append(img)

imgs = np.expand_dims(imgs, axis=0)

# print(imgs)

predictions = model(imgs)
pred = np.argmax(predictions, axis=1)

print(pred)

# predict
# predictions = model(data)
# predictions = tf.nn.softmax(predictions)
# pred0 = predictions[0]
# label0 = np.argmax(pred0)
# print(label0)
