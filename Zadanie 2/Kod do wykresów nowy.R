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


floatResGfirstErr<-c(1.033186E-9,4.816684E-9,2.4563633E-8,3.4051482E-8,1.793669E-7,2.6659109E-7,4.528556E-7,4.8475645E-7,5.646128E-7)
doubleResGfirstErr<-c(9.134403303190375E-18,7.182839392716467E-18,1.2105117255800657E-17,1.52059354691092E-17,1.723881454251952E-17,1.3118846287074604E-17,2.183583175385806E-16,1.3097162243624894E-16,1.3964523981613297E-16)
fractionResGfirstErr<-c(0,0,0,0,0,0,0,0,0)
libraryResfirstErr<-c(4.29E-20,9.22E-20,7E-20,6.036E-19,4.141E-19,5.732E-19,2.50049E-18,1.196934E-18,7.356110E-18)
floatResGsecondErr<-c(4.293397068975E-7,.000006267800927162,0.000680563971400261,0.000012875534594058,0.000477977305650712,0.000639319419860840,0.00283592194318771,0.000111784785985945,0.00804700702428818)
doubleResGsecondErr<-c(2.331E-15,4.5647E-14,2.8606E-14,3.5311E-14,4.801907E-12,2.15657E-13,1.473476E-12,9.1338E-14,1.4042E-13)
libraryRessecondErr<-c(1.2241374E-17,9.5981584E-17,6.518815E-17,2.665095E-17,1.10458972E-15,7.7633383E-16,1.3686439E-16,1.8518289E-16,5.7932797870E-14)

floatResPGfirstErr<-c(7.2759576E-10,4.0745363E-10,6.9849193E-10,3.4924597E-10,6.344635E-9,3.4924597E-9,2.6077032E-8, 4.656613E-8,4.3748726E-8)
doubleResPGfirstErr<-c(4.3368086899420177E-19,7.318364664277155E-19,1.6263032587282567E-18,3.2526065174565133E-18,5.2583805365546965E-18,7.589415207398531E-18,1.8648277366750676E-17,9.974659986866641E-17,2.949029909160572E-17)
fractionResPGfirstErr<-c(0,0,0,0,0,0,0,0,0)
floatResPGsecondErr<-c(33,118,284,640,1194,1884,2842,3818,5516)
doubleResPGsecondErr<-c(34,120,292,674,1238,1898,2903,3865,5777)

floatResFGfirstErr<-c(2.910383E-11,1.7462298E-10,2.0372681E-10,2.910383E-10,1.36788E-9,1.895302E-9,9.313226E-9,3.4365803E-8, 2.7939677E-8)
doubleResFGfirstErr<-c(1.3552527156068805E-19,5.963111948670274E-19,9.75781955236954E-19,2.1684043449710089E-18,2.3310346708438345E-18,8.673617379884035E-18,8.168404344971009E-18,6.054184931159057E-17,1.3010426069826053E-17)
fractionResFGfirstErr<-c(0,0,0,0,0,0,0,0,0)
floatResFGsecondErr<-c(34,119,325,725,1398,2101,3179,4172,6179)
doubleResFGsecondErr<-c(35,128,340,777,1452,2179,3274,4281,6711)

library(scales)
library(ggplot2)

df<-data.frame(floatResGfirstErr,doubleResGfirstErr,fractionResGfirstErr,libraryResfirstErr,floatResPGfirstErr,doubleResPGfirstErr,fractionResPGfirstErr,floatResFGfirstErr,doubleResFGfirstErr,fractionResFGfirstErr)
ggplot(data=df, aes(info2)) +
  geom_line(aes(y=floatResGfirstErr),colour=2)+
  geom_line(aes(y=doubleResGfirstErr),colour=4)+
  geom_line(aes(y=fractionResGfirstErr),colour=3)+
  geom_line(aes(y=floatResPGfirstErr),colour=2,linetype = "dashed")+
  geom_line(aes(y=doubleResPGfirstErr),colour=4,linetype = "dashed")+
  geom_line(aes(y=fractionResPGfirstErr),colour=3,linetype = "dashed")+
  geom_line(aes(y=floatResFGfirstErr),colour=2,linetype = "dotted")+
  geom_line(aes(y=doubleResFGfirstErr),colour=4,linetype = "dotted")+
  geom_line(aes(y=fractionResFGfirstErr),colour=3,linetype = "dotted")+
  geom_line(aes(y=libraryResfirstErr),colour=1)+
  scale_y_log10(breaks = trans_breaks("log10", function(x) 10^x),
                labels = trans_format("log10", math_format(10^.x)))+ 
  labs(y = "Różnica norm wektorów", x = "Wielkość macierzy")

legend("topleft", legend=c("Float G", "Double G", "Ułamki G","Float PG", "Double PG", "Ułamki PG","Float FG", "Double FG", "Ułamki FG", "Biblioteka"),
       col=c(2,4,3,2,4,3,2,4,3,1), lty = c(1,1,1,2,2,2,3,3,3,1), cex=1)
plot(c(1,2))


