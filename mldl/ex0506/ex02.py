from flask import Flask, request, render_template, send_file
import json
import numpy as np
import matplotlib.pyplot as plt
from io import BytesIO, StringIO
from flask import make_response

from functools import wraps, update_wrapper
from datetime import datetime

# print(__name__)

app = Flask(__name__)

fish_length = [25.4, 26.3, 26.5, 29.0, 29.0, 29.7, 29.7, 30.0, 30.0, 30.7, 31.0, 31.0, 
                31.5, 32.0, 32.0, 32.0, 33.0, 33.0, 33.5, 33.5, 34.0, 34.0, 34.5, 35.0, 
                35.0, 35.0, 35.0, 36.0, 36.0, 37.0, 38.5, 38.5, 39.5, 41.0, 41.0, 9.8, 
                10.5, 10.6, 11.0, 11.2, 11.3, 11.8, 11.8, 12.0, 12.2, 12.4, 13.0, 14.3, 15.0]
fish_weight = [242.0, 290.0, 340.0, 363.0, 430.0, 450.0, 500.0, 390.0, 450.0, 500.0, 475.0, 500.0, 
                500.0, 340.0, 600.0, 600.0, 700.0, 700.0, 610.0, 650.0, 575.0, 685.0, 620.0, 680.0, 
                700.0, 725.0, 720.0, 714.0, 850.0, 1000.0, 920.0, 955.0, 925.0, 975.0, 950.0, 6.7, 
                7.5, 7.0, 9.7, 9.8, 8.7, 10.0, 9.9, 9.8, 12.2, 13.4, 12.2, 19.7, 19.9]

fish_lengh = np.array(fish_length)
fish_weight = np.array(fish_weight)

fish_data = np.column_stack((fish_lengh,fish_weight))
fish_target = np.concatenate((np.ones(35), np.zeros(14)))

length=np.array([])
weight=np.array([])

def nocache(view):
  @wraps(view)
  def no_cache(*args, **kwargs):
    response = make_response(view(*args, **kwargs))
    response.headers['Last-Modified'] = datetime.now()
    response.headers['Cache-Control'] = 'no-store, no-cache, must-revalidate, post-check=0, pre-check=0, max-age=0'
    response.headers['Pragma'] = 'no-cache'
    response.headers['Expires'] = '-1'
    return response      
  return update_wrapper(no_cache, view)


@app.route('/fig/<int:l>_<int:w>')
@nocache ### 요기가 바뀌었죠
def fig(l, w):
    print(l)
    print(w)
    global length
    global weight
    try:
        length =np.append(length,l)
        weight =np.append(weight,w)
        plt.scatter(fish_length[:35],fish_weight[:35])
        plt.scatter(fish_length[35:],fish_weight[35:])
        plt.scatter(length,weight,c="#ff0000")
        plt.xlabel("length")
        plt.ylabel("weight")
    except Exception as e:
        print(e)
    img = BytesIO()
    plt.savefig(img, format='png', dpi=200)
    plt.close()
    ## object를 읽었기 때문에 처음으로 돌아가줌
    img.seek(0)
    return send_file(img, mimetype='image/png')


@app.route("/board")
def board():
    return f"question 변수의 값은 {request.args.get('question')}"

@app.route("/boards",methods=["POST"])
def board_list2():
    post_result = json.loads(request.get_data())
    
    return f"question 변수의 값은 {post_result}"

@app.route("/<l_w>")
def index(l_w):
    l,w = l_w.split("_")
    l,w = int(l),int(w)
    return render_template('index.html',l=l,w=w,width=800,height=600)

app.run(host="localhost",port=5001)