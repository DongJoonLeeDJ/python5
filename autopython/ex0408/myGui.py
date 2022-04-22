import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("./ex0408/myGui.ui")[0]

class WindowClass(QMainWindow, form_class) :
    row = 0
    def __init__(self) :
        super().__init__()
        self.setupUi(self)
        self.myevent()

        self.tableWidget.setRowCount(1)
        self.tableWidget.setColumnCount(4)
        self.tableWidget.setEditTriggers(QAbstractItemView.NoEditTriggers)
        self.tableWidget.horizontalHeader().setSectionResizeMode(QHeaderView.Stretch)
        self.tableWidget.setHorizontalHeaderLabels(["번호", "국어","영어","수학"])

    def myevent(self):
        self.pushButton.clicked.connect(self.pushfuc)

    def pushfuc(self):
        self.tableWidget.setItem(self.row, 0, QTableWidgetItem( str(self.row+1) ))
        self.tableWidget.setItem(self.row, 1, QTableWidgetItem(self.editkor.text()))
        self.tableWidget.setItem(self.row, 2, QTableWidgetItem(self.editeng.text()))
        self.tableWidget.setItem(self.row, 3, QTableWidgetItem(self.editmath.text()))
        self.row = self.row + 1
        self.tableWidget.setRowCount(self.row+1)

if __name__ == "__main__" :
    app = QApplication(sys.argv) 
    myWindow = WindowClass() 
    myWindow.show()
    app.exec_()