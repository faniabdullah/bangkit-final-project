### Cloud-based skin cancer prediction

![skin cancer app](https://user-images.githubusercontent.com/78893010/120418248-5b52fa80-c38a-11eb-98e0-da8bc6f64897.jpg)

TensorFlow model is served with Flask, a simple Python-based web framework, to take the image prediction request as an HTTP with POST method. This app is containerized by Docker to package up the app with libraries and dependencies it needs. Finally, upload the app via Google Cloud SDK to Cloud Run service, a fully managed serverless platform so we can just focus on our app development and deploy it to the cloud in no time.
