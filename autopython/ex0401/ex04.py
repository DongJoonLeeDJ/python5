from openpyxl import Workbook

wb = Workbook()

ws = wb.active
ws.title = 'nado'

wb.save("my.xlsx")
wb.close()