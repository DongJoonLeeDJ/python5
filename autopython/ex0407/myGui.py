import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

from MyExl import MMy

form_class = uic.loadUiType("./ex0407/ex0407.ui")[0]

class WindowClass(QMainWindow, form_class) :
    def __init__(self) :
        super().__init__()
        self.setupUi(self)

        self.setEvent()

    def setEvent(self):
        self.inputbtn.clicked.connect(self.inputfunc)
        self.outputbtn.clicked.connect(self.outputfunc)
    
    def inputfunc(self):
        my = MMy()
        my.save(self.cell_edit.text(), self.value_edit.text())

    def outputfunc(self):
        print('cell_edit',self.out_cell_edit.text())
        print('value_edit',self.out_value_edit.text())
        self.out_value_edit.setText('설정')
        my = MMy()
        my.load(self.out_cell_edit.text(),self.out_value_edit)
        

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()