import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

import io
import tensorflow as tf
from tensorflow import keras
from tensorflow.keras.preprocessing.image import ImageDataGenerator, load_img, img_to_array
import matplotlib.pyplot as plt
import numpy as np
from PIL import Image

from flask import Flask, request, jsonify

model = keras.models.load_model("skinskanmodel.h5")


def transform_image(img):
    # data = np.asarray(pillow_image)
    # data = data / 255.0
    # data = data[np.newaxis, ..., np.newaxis]
    # # --> [1, x, y, 1]
    # data = tf.image.resize(data, [28, 28])
    # return data
    
    
    imgs = []
    img = img.resize((150,150))
    img = img_to_array(img)
    img = img.astype(np.float32) / 255
    imgs.append(img)
    imgs = tf.image.resize(img, [150,150])
    imgs = np.expand_dims(imgs, axis=0)
    
    return imgs


def predict(x):
    # predictions = model(x)
    # predictions = tf.nn.softmax(predictions)
    # pred0 = predictions[0]
    # label0 = np.argmax(pred0)
    # return label0

    predictions = model(x)
    pred = np.argmax(predictions, axis=1)
    return pred

app = Flask(__name__)

@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        file = request.files.get('file')
        if file is None or file.filename == "":
            return jsonify({"error": "no file"})

        try:
            image_bytes = file.read()
            pillow_img = Image.open(io.BytesIO(image_bytes))
            prediction = predict(transform_image(pillow_img))
            data = {"prediction": int(prediction)}
            return jsonify(data)
        except Exception as e:
            return jsonify({"error": str(e)})

    return "OK"


if __name__ == "__main__":
    app.run(debug=True)