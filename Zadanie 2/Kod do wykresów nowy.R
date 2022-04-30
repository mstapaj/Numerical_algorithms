# Operacje czasy

info2<-c(10,15,20,25,30,35,40,45,50)
info3<-c(100,150,200,250,300,350,400,450,500)
floatResGfirst<-c(0,0,0,0,0,1,1,2,3)
doubleResGfirst<-c(0,0,0,0,0,1,2,2,3)
fractionResGfirst<-c(13,112,615,2593,7895,20248,48383,104390,204547)
libraryResfirst<-c(0,0,0,0,0,0,0,0,0)
floatResGsecond<-c(33,114,278,644,1211,1864,2818,3800,5506)
doubleResGsecond<-c(33,115,302,677,1260,1898,2889,3858,5810)
libraryRessecond<-c(0,0,1,3,6,10,15,21,30)

floatResPGfirst<-c(0,0,0,0,0,1,1,2,3)
doubleResPGfirst<-c(0,0,0,0,1,1,2,2,3)
fractionResPGfirst<-c(13,112,615,2703,7989,20428,48572,108032,208126)
floatResPGsecond<-c(33,118,284,640,1194,1884,2842,3818,5516)
doubleResPGsecond<-c(34,120,292,674,1238,1898,2903,3865,5777)

floatResFGfirst<-c(0,0,0,0,0,1,2,2,4)
doubleResFGfirst<-c(0,0,0,0,1,1,2,3,4)
fractionResFGfirst<-c(17,115,628,2973,8097,20590,49022,113263,216361)
floatResFGsecond<-c(34,119,325,725,1398,2101,3179,4172,6179)
doubleResFGsecond<-c(35,128,340,777,1452,2179,3274,4281,6711)



plot(info2,floatResGfirst,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss bez wyboru",col="RED", pch = 19,ylim = c(0,20))
lines(info2,doubleResGfirst,type="b",col="BLUE")
lines(info2,fractionResGfirst,type="b",col="GREEN")
lines(info2,libraryResfirst,type="b")

plot(info3,floatResGsecond,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss bez wyboru",col="RED", pch = 19,ylim = c(0,5900))
lines(info3,doubleResGsecond,type="b",col="BLUE")
lines(info3,libraryRessecond,type="b")

plot(info2,floatResPGfirst,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór częściowy",col="RED", pch = 19,ylim = c(0,14))
lines(info2,doubleResPGfirst,type="b",col="BLUE")
lines(info2,fractionResPGfirst,type="b",col="GREEN")
lines(info2,libraryResfirst,type="b")

plot(info3,floatResPGsecond,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór częściowy",col="RED", pch = 19,ylim = c(0,6500))
lines(info3,doubleResPGsecond,type="b",col="BLUE")
lines(info3,libraryRessecond,type="b")

plot(info2,floatResFGfirst,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór pełny",col="RED", pch = 19,ylim = c(0,15))
lines(info2,doubleResFGfirst,type="b",col="BLUE")
lines(info2,fractionResFGfirst,type="b",col="GREEN")
lines(info2,libraryResfirst,type="b")

plot(info3,floatResFGsecond,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór pełny",col="RED", pch = 19,ylim = c(0,7700))
lines(info3,doubleResFGsecond,type="b",col="BLUE")
lines(info3,libraryRessecond,type="b")


floatResGfirstErr<-c(1.455191523E-10,2.27009877564E-9,4.684552550316E-8,1.6298145056E-7,8.88248905539E-7,4.5867636800E-7,9.597279131413E-7,3.345776349306E-7,4.656612873E-6)
doubleResGfirstErr<-c(8.73114914E-11,9.0221874414E-10,6.9849193096E-9,8.4983184934E-9,1.37370079756E-8,5.5879354476E-8,1.281732693314E-7,5.41331246496E-7,1.25728547573E-7)
fractionResGfirstErr<-c(0E-37,0E-37,0E-37,0E-37,0E-37,0E-37,0E-37,0E-37,0E-37)
libraryResfirstErr<-c(9.6E-20,2.5515E-18,2.548482E-18,2.963E-18,6.1817E-18,6.04083E-18,6.265533E-17,2.0989E-18,2.60426E-18)
floatResGsecondErr<-c(33,114,278,644,1211,1864,2818,3800,5506)
doubleResGsecondErr<-c(33,115,302,677,1260,1898,2889,3858,5810)
libraryRessecondErr<-c(0,0,1,3,6,10,15,21,30)

floatResPGfirstErr<-c(0,0,0,0,0,1,1,2,3)
doubleResPGfirstErr<-c(0,0,0,0,1,1,2,2,3)
fractionResPGfirstErr<-c(13,112,615,2703,7989,20428,48572,108032,208126)
floatResPGsecondErr<-c(33,118,284,640,1194,1884,2842,3818,5516)
doubleResPGsecondErr<-c(34,120,292,674,1238,1898,2903,3865,5777)

floatResFGfirstErr<-c(0,0,0,0,0,1,2,2,4)
doubleResFGfirstErr<-c(0,0,0,0,1,1,2,3,4)
fractionResFGfirstErr<-c(17,115,628,2973,8097,20590,49022,113263,216361)
floatResFGsecondErr<-c(34,119,325,725,1398,2101,3179,4172,6179)
doubleResFGsecondErr<-c(35,128,340,777,1452,2179,3274,4281,6711)

plot(info2,floatResGfirstErr,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss bez wyboru",col="RED", pch = 19)
lines(info2,doubleResGfirstErr,type="b",col="BLUE")
lines(info2,fractionResGfirstErr,type="b",col="GREEN")
lines(info2,libraryResfirstErr,type="b")

plot(info3,floatResGsecondErr,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss bez wyboru",col="RED", pch = 19,ylim = c(0,5900))
lines(info3,doubleResGsecondErr,type="b",col="BLUE")
lines(info3,libraryRessecondErr,type="b")

plot(info2,floatResPGfirstErr,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór częściowy",col="RED", pch = 19,ylim = c(0,14))
lines(info2,doubleResPGfirstErr,type="b",col="BLUE")
lines(info2,fractionResPGfirstErr,type="b",col="GREEN")
lines(info2,libraryResfirstErr,type="b")

plot(info3,floatResPGsecondErr,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór częściowy",col="RED", pch = 19,ylim = c(0,6500))
lines(info3,doubleResPGsecondErr,type="b",col="BLUE")
lines(info3,libraryRessecondErr,type="b")

plot(info2,floatResFGfirstErr,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór pełny",col="RED", pch = 19,ylim = c(0,15))
lines(info2,doubleResFGfirstErr,type="b",col="BLUE")
lines(info2,fractionResFGfirstErr,type="b",col="GREEN")
lines(info2,libraryResfirstErr,type="b")

plot(info3,floatResFGsecondErr,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "Gauss wybór pełny",col="RED", pch = 19,ylim = c(0,7700))
lines(info3,doubleResFGsecondErr,type="b",col="BLUE")
lines(info3,libraryRessecondErr,type="b")
