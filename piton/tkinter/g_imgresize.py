# -*- coding: utf-8 -*-

from Tkinter import *
from Image import *
import tkFileDialog
from tkMessageBox import *
import os
import sys


#şimdilik dizin seçerken Türkçe karakter bulunan dizinleri seçmeyiniz...
def dizin_sec():
	dizin_ent.delete(0, END)

	dizin_adi = tkFileDialog.askdirectory(parent=pencere, initialdir="/", title='Resimlerinizin olduğu dizini seçiniz')
	if dizin_adi:
		dizin_ent.insert(0, dizin_adi)
		print '%s dizini seçildi' % dizin_adi


def g_img_resize():
	if dizin_ent.get() == '':
		return showerror('Uyarı!', 'Dizin seçimini boş bırakmayınız!')
	dizin_yolu = dizin_ent.get()
	tur = tur_onay()
	pixel = pixel_onay()
	if bool(tur) == False:
		return showerror('Uyarı!', 'Bir resim formatı seçiniz!')
	if not pixel:
		return showerror('Uyarı!', 'Bir çözünürlük seçiniz!')
	print 'TÜR :', tur
	print 'ÇÖZÜNÜRLÜK :', pixel
	pixel = pixel.split('x')
	depo = os.system('mkdir g_depo')
	for yol, dizin, dosyalar in os.walk(dizin_yolu):
		for dosya in dosyalar:
			if yol[-1] != '/':
				yol += '/'
			try:
				img = open(yol + dosya)
				print yol, '------->', dosya
				new_img = img.resize((int(pixel[0]), int(pixel[1])))
				new_img.save(os.getcwd() + '/' + 'g_depo/new_' + os.path.splitext(dosya)[0] + tur)
			except:
				return showerror('Hata!', 'Hata Oluştu!')
	print '- ' * 10 , 'BİTTİ', ' -' * 10


def tur_onay():
	if png_onay.get() == 1:
		return png.get()
	elif jpg_onay.get() == 1:
		return jpg.get()
	elif jpeg_onay.get() == 1:
		return jpeg.get()


def pixel_onay():
	if p_640_onay.get() == 1:
		return p_640.get()
	if p_800_onay.get() == 1:
		return p_800.get()
	if p_1024_onay.get() == 1:
		return p_1024.get()

pencere = Tk()
pencere.title('G-İmgResize')
pencere.geometry('500x400+200+200')
pencere.resizable(width=FALSE, height=FALSE)

dizin_label = Label(text="Dizin seçiniz:")
dizin_label.place(relx=0.10, rely=0.03, relheight=0.05)

dizin_ent = Entry()
dizin_ent.place(relx=0.10, rely=0.10, relwidth=0.65, relheight=0.07)

dizin = Button(text="Dizin Seç", command=dizin_sec)
dizin.place(relx=0.75, rely=0.1, relheight=0.07, relwidth=0.15)

buton1 = Button(text='Çevir', command=g_img_resize)
buton1.place(relx=0.60, rely=0.80, relheight=0.07, relwidth=0.15)

buton2 = Button(text='Çıkış', command=sys.exit)
buton2.place(relx=0.75, rely=0.80, relheight=0.07, relwidth=0.15)

tur_label = Label(text="Resim formatını seçiniz: ")
tur_label.place(relx=0.50, rely=0.23, relheight=0.05)

coz_label = Label(text="Çözünürlük seçiniz: ")
coz_label.place(relx=0.10, rely=0.23, relheight=0.05)

#Tür seçimi:
#png
png_onay = IntVar()
png_onay.set(0)

png = StringVar()
png.set(".png")

tur_png = Checkbutton(text=png.get(), variable=png_onay, command=tur_onay)
tur_png.place(relx=0.50, rely=0.30)

#jpg
jpg_onay = IntVar()
jpg_onay.set(0)

jpg = StringVar()
jpg.set(".jpg")

tur_jpg = Checkbutton(text=jpg.get(), variable=jpg_onay, command=tur_onay)
tur_jpg.place(relx=0.50, rely=0.35)

#jpeg
jpeg_onay = IntVar()
jpeg_onay.set(0)

jpeg = StringVar()
jpeg.set(".jpeg")

tur_jpeg = Checkbutton(text=jpeg.get(), variable=jpeg_onay, command=tur_onay)
tur_jpeg.place(relx=0.50, rely=0.40)

#Çözünürlükler
#640x480
p_640_onay = IntVar()
p_640_onay.set(0)

p_640 = StringVar()
p_640.set("640x480")

p_640_sec = Checkbutton(text=p_640.get(), variable=p_640_onay, command=pixel_onay)
p_640_sec.place(relx=0.10, rely=0.30)

#800x600
p_800_onay = IntVar()
p_800_onay.set(0)

p_800 = StringVar()
p_800.set("800x600")

p_800_sec = Checkbutton(text=p_800.get(), variable=p_800_onay, command=pixel_onay)
p_800_sec.place(relx=0.10, rely=0.35)

#1024x768
p_1024_onay = IntVar()
p_1024_onay.set(0)

p_1024 = StringVar()
p_1024.set("1024x768")

p_1024_sec = Checkbutton(text=p_1024.get(), variable=p_1024_onay, command=pixel_onay)
p_1024_sec.place(relx=0.10, rely=0.40)

mainloop()
