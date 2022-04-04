import sys
from PyQt5.QtWidgets import QApplication, QWidget, QVBoxLayout, QHBoxLayout, QPushButton
from ok import Ok , Cancel

class MyApp(QWidget):

    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):

        okbtn = QPushButton("ok")
        cancelbtn = QPushButton("cancel")

        okbtn.clicked.connect(self.okfunc)
        cancelbtn.clicked.connect(self.cancelfunc)
        
        hbox = QHBoxLayout()
        hbox.addStretch(1)
        hbox.addWidget(okbtn)
        hbox.addWidget(cancelbtn)
        hbox.addStretch(1)

        vbox = QVBoxLayout()
        vbox.addStretch(3)
        vbox.addLayout(hbox)
        vbox.addStretch(1)

        self.setLayout(vbox)

        self.setWindowTitle('ex01')
        self.move(300, 300)
        self.resize(400, 200)
        self.show()

    
    def okfunc(self):
        a = Ok()
        print(a)

    def cancelfunc(self):
        b = Cancel()
        print(b)

if __name__ == '__main__':
   app = QApplication(sys.argv)
   ex = MyApp()
   sys.exit(app.exec_())