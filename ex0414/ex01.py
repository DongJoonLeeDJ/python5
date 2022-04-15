import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic
from myclick import MYC

form_class = uic.loadUiType("./ex0414/myGui.ui")[0]

class WindowClass(QMainWindow, form_class) :
    myc = MYC()
    def __init__(self) :
        super().__init__()
        self.setupUi(self)
        self.myevent()
    
    def myevent(self):
        self.movetobtn.clicked.connect(self.movetofn)
        self.movebtn.clicked.connect(self.movefn)
        self.clickbtn.clicked.connect(self.clickfn)

    def movetofn(self):
        x = self.xEdit.text()
        y = self.yEdit.text()
        dura = self.duraEdit.text()
        self.myc.moveTo(x,y,dura)

    def movefn(self):
        x = self.xEdit.text()
        y = self.yEdit.text()
        dura = self.duraEdit.text()
        self.myc.move(x,y,dura)

    def clickfn(self):
        x = self.xEdit.text()
        y = self.yEdit.text()
        dura = self.duraEdit.text()
        self.myc.click(x,y,dura)

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()