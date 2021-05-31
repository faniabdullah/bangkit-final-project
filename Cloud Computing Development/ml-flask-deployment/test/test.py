import requests

resp = requests.post("https://cancerpred-k36kqqstzq-et.a.run.app", files={'file': open('benign.jpg', 'rb')})

print(resp.json())