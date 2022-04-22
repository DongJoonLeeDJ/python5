import sys
from PyQt5.QtWidgets import QApplication, QWidget, QPushButton, QVBoxLayout
from myex import Ex

class MyApp(QWidget):

    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        btn1 = QPushButton('버튼')
        btn1.clicked.connect(self.doa)

        btn2 = QPushButton("불러오기")
        btn2.clicked.connect(self.dob)

        vbox = QVBoxLayout()
        vbox.addWidget( btn1 )
        vbox.addWidget( btn2 )

        self.setLayout(vbox)
        self.setWindowTitle('My First Application')
        self.move(300, 300)
        self.resize(400, 200)
        self.show()
        
    def doa(self):
        ex = Ex()
        ex.doA1()

    def dob(self):
        ex = Ex()
        ex.doB1()


if __name__ == '__main__':
   app = QApplication(sys.argv)
   ex = MyApp()
   sys.exit(app.exec_())