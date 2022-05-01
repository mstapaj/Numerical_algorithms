# Gauss czasy

info2<-c(10,15,20,25,30,35,40,45,50)
info3<-c(100,150,200,250,300,350,400,450,500)
floatResGfirst<-c(0,0,0,0,0,1,1,2,3)
doubleResGfirst<-c(0,0,0,0,0,1,2,2,3)
fractionResGfirst<-c(13,112,615,2593,7895,20248,48383,104390,204547)
libraryResfirst<-c(0,0,0,0,0,0,0,0,0)
floatResGsecond<-c(33,114,278,644,1211,1864,2818,3800,5506)
doubleResGsecond<-c(33,115,302,677,1260,1898,2889,3858,5777)
libraryRessecond<-c(0,0,1,3,6,10,15,21,30)

floatResPGfirst<-c(0,0,0,0,0,1,1,2,3)
doubleResPGfirst<-c(0,0,0,0,1,1,2,2,3)
fractionResPGfirst<-c(13,112,615,2703,7989,20428,48572,108032,208126)
floatResPGsecond<-c(33,118,284,640,1194,1884,2842,3818,5516)
doubleResPGsecond<-c(34,120,292,674,1238,1898,2903,3865,5910)

floatResFGfirst<-c(0,0,0,0,0,1,2,2,4)
doubleResFGfirst<-c(0,0,0,0,1,1,2,3,4)
fractionResFGfirst<-c(17,115,628,2973,8097,20590,49022,113263,216361)
floatResFGsecond<-c(34,119,325,725,1398,2101,3179,4172,6179)
doubleResFGsecond<-c(35,128,340,777,1452,2179,3274,4281,6711)

df<-data.frame(floatResGfirst,doubleResGfirst,fractionResGfirst,libraryResfirst,floatResPGfirst,doubleResPGfirst,fractionResPGfirst,floatResFGfirst,doubleResFGfirst,fractionResFGfirst)
ggplot(data=df, aes(info2)) +
  geom_line(aes(y=floatResGfirst),colour=2)+
  geom_line(aes(y=doubleResGfirst),colour=4)+
  geom_line(aes(y=floatResPGfirst),colour=2,linetype = "dashed")+
  geom_line(aes(y=doubleResPGfirst),colour=4,linetype = "dashed")+
  geom_line(aes(y=floatResFGfirst),colour=2,linetype = "dotted")+
  geom_line(aes(y=doubleResFGfirst),colour=4,linetype = "dotted")+
  geom_line(aes(y=libraryResfirst),colour=1)+
  labs(y = "Czas obliczeń", x = "Wielkość macierzy")

df<-data.frame(floatResGsecond,doubleResGsecond,fractionResGsecond,libraryRessecond,floatResPGsecond,doubleResPGsecond,fractionResPGsecond,floatResFGsecond,doubleResFGsecond,fractionResFGsecond)
ggplot(data=df, aes(info3)) +
  geom_line(aes(y=floatResGsecond),colour=2)+
  geom_line(aes(y=doubleResGsecond),colour=4)+
  geom_line(aes(y=floatResPGsecond),colour=2,linetype = "dashed")+
  geom_line(aes(y=doubleResPGsecond),colour=4,linetype = "dashed")+
  geom_line(aes(y=floatResFGsecond),colour=2,linetype = "dotted")+
  geom_line(aes(y=doubleResFGsecond),colour=4,linetype = "dotted")+
  geom_line(aes(y=libraryRessecond),colour=1)+
  labs(y = "Czas obliczeń", x = "Wielkość macierzy")

df<-data.frame(fractionResGfirst,fractionResPGfirst,fractionResFGfirst)
ggplot(data=df, aes(info2)) +
  geom_line(aes(y=fractionResGfirst),colour=1)+
  geom_line(aes(y=fractionResPGfirst),colour=2,linetype = "dashed")+
  geom_line(aes(y=fractionResFGfirst),colour=3,linetype = "dotted")+
  labs(y = "Czas obliczeń", x = "Wielkość macierzy")

df<-data.frame(floatResGsecond,doubleResGsecond,fractionResGsecond,libraryRessecond,floatResPGsecond,doubleResPGsecond,fractionResPGsecond,floatResFGsecond,doubleResFGsecond,fractionResFGsecond)
ggplot(data=df, aes(info3)) +
  geom_line(aes(y=floatResGsecond),colour=2)+
  geom_line(aes(y=floatResPGsecond),colour=4,linetype="dotted")+
  geom_line(aes(y=floatResFGsecond),colour=3,linetype = "dashed")+
  labs(y = "Czas obliczeń", x = "Wielkość macierzy")+
  scale_y_log10(breaks = trans_breaks("log10", function(x) 10^x),
                labels = trans_format("log10", math_format(10^.x))) 

df<-data.frame(floatResGsecond,doubleResGsecond,fractionResGsecond,libraryRessecond,floatResPGsecond,doubleResPGsecond,fractionResPGsecond,floatResFGsecond,doubleResFGsecond,fractionResFGsecond)
ggplot(data=df, aes(info3)) +
  geom_line(aes(y=doubleResGsecond),colour=2)+
  geom_line(aes(y=doubleResPGsecond),colour=4,linetype="dotted")+
  geom_line(aes(y=doubleResFGsecond),colour=3,linetype = "dashed")+
  labs(y = "Czas obliczeń", x = "Wielkość macierzy")+
  scale_y_log10(breaks = trans_breaks("log10", function(x) 10^x),
                labels = trans_format("log10", math_format(10^.x))) 


# Gauss normy

floatResGfirstErr<-c(1.033186E-9,4.816684E-9,2.4563633E-8,3.4051482E-8,1.793669E-7,2.6659109E-7,4.528556E-7,4.8475645E-7,5.646128E-7)
doubleResGfirstErr<-c(9.134403303190375E-18,7.182839392716467E-18,1.2105117255800657E-17,1.52059354691092E-17,1.723881454251952E-17,1.3118846287074604E-17,2.183583175385806E-16,1.3097162243624894E-16,1.3964523981613297E-16)
fractionResGfirstErr<-c(0,0,0,0,0,0,0,0,0)
libraryResfirstErr<-c(4.29E-20,9.22E-20,7E-20,6.036E-19,4.141E-19,5.732E-19,2.50049E-18,1.196934E-18,7.356110E-18)

floatResPGfirstErr<-c(7.2759576E-10,4.0745363E-10,6.9849193E-10,3.4924597E-10,6.344635E-9,3.4924597E-9,2.6077032E-8, 4.656613E-8,4.3748726E-8)
doubleResPGfirstErr<-c(4.3368086899420177E-19,7.318364664277155E-19,1.6263032587282567E-18,3.2526065174565133E-18,5.2583805365546965E-18,7.589415207398531E-18,1.8648277366750676E-17,9.974659986866641E-17,2.949029909160572E-17)
fractionResPGfirstErr<-c(0,0,0,0,0,0,0,0,0)


floatResFGfirstErr<-c(2.910383E-11,1.7462298E-10,2.0372681E-10,2.910383E-10,1.36788E-9,1.895302E-9,9.313226E-9,3.4365803E-8, 2.7939677E-8)
doubleResFGfirstErr<-c(1.3552527156068805E-19,5.963111948670274E-19,9.75781955236954E-19,2.1684043449710089E-18,2.3310346708438345E-18,8.673617379884035E-18,8.168404344971009E-18,6.054184931159057E-17,1.3010426069826053E-17)
fractionResFGfirstErr<-c(0,0,0,0,0,0,0,0,0)


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


par(mfrow=c(1,1))
op <- par(cex = 0.8)
plot(c(1,2))
legend("topleft", legend=c("Float G", "Double G", "Ułamki G","Float PG", "Double PG", "Ułamki PG","Float FG", "Double FG", "Ułamki FG", "Biblioteka"),
       col=c(2,4,3,2,4,3,2,4,3,1), lty = c(1,1,1,2,2,2,3,3,3,1), cex=1,ncol=4)

plot(c(1,2))
legend("topleft", legend=c("Float G", "Double G","Float PG", "Double PG", "Float FG", "Double FG",  "Biblioteka"),
       col=c(2,4,2,4,2,4,1), lty = c(1,1,2,2,3,3,1), cex=1,ncol=4)

legend("topleft", legend=c("Ułamki G","Ułamki PG","Ułamki FG"),
       col=c(1,2,3), lty = c(1,2,3), cex=1,ncol=3)

legend("topleft", legend=c("Bez wyboru","Wybór częściowy","Wybór pełny"),
       col=c(2,4,3), lty = c(1,3,2), cex=1,ncol=3)


floatResGsecondErr<-c(1.128763E-6,1.729466E-6,3.9543957E-6,5.2478922E-6,7.888302E-6,0.0006621925,0.0020171981,0.0020371208,0.0035066344)
doubleResGsecondErr<-c(3.825932626266848E-15,3.8915051736587714E-14,4.0462117283616124E-14,1.075113956194862E-12,1.6101703304016723E-12,5.413756248850987E-12,9.036348058710786E-12,1.7515155992242626E-11,2.315808655950491E-10)
libraryRessecondErr<-c(1.5967482E-17,1.8250626E-17,1.24870158E-17,1.116372346E-17,1.4158816E-17,3.40953040E-17,1.05594328E-16,1.08683566E-16,6.07899954E-16)

floatResPGsecondErr<-c(2.188608E-8,2.7939677E-9,2.2165477E-7,2.2583641E-6,7.7020377E-7,5.52088E-6,4.1164458E-7,2.7064234E-5,1.642853E-6)
doubleResPGsecondErr<-c(2.6020852139652106E-15,1.7867651802561113E-16,1.457167719820518E-16,1.7317744460676465E-14,9.194034422677078E-16,9.825473767932635E-15,1.7416623698807143E-15,1.1664280652468051E-14,3.049643870767227E-15)

floatResFGsecondErr<-c(1.8906153E-8,1.5390258E-9,2.3283064E-7,3.1478703E-7,1.1175871E-7,6.1169267E-6,2.2910535E-7,3.9115548E-8,1.0561198E-6)
doubleResFGsecondErr<-c(1.1162945567910754E-16,1.97758476261356E-16,1.465841337200402E-16,1.5959455978986625E-16,2.3071822230491534E-16,6.886852199627924E-15,1.5681900222830336E-15,9.055256544598933E-16,4.139050213680662E-15)

df<-data.frame(floatResGsecondErr,doubleResGsecondErr,floatResPGsecondErr,doubleResPGsecondErr,floatResFGsecondErr,doubleResFGsecondErr)
ggplot(data=df, aes(info3)) +
  geom_line(aes(y=floatResGsecondErr),colour=2)+
  geom_line(aes(y=doubleResGsecondErr),colour=4)+
  geom_line(aes(y=floatResPGsecondErr),colour=2,linetype = "dashed")+
  geom_line(aes(y=doubleResPGsecondErr),colour=4,linetype = "dashed")+
  geom_line(aes(y=floatResFGsecondErr),colour=2,linetype = "dotted")+
  geom_line(aes(y=doubleResFGsecondErr),colour=4,linetype = "dotted")+
  geom_line(aes(y=libraryRessecondErr),colour=1)+
  scale_y_log10(breaks = trans_breaks("log10", function(x) 10^x),
                labels = trans_format("log10", math_format(10^.x)))+ 
  labs(y = "Różnica norm wektorów", x = "Wielkość macierzy")

plot(c(1,2))
legend("topleft", legend=c("Float G", "Double G","Float PG", "Double PG","Float FG", "Double FG", "Biblioteka"),
       col=c(2,4,2,4,2,4,1), lty = c(1,1,2,2,3,3,1), cex=1)
plot(c(1,2))


# Operacje czasy

info2<-c(10,15,20,25,30,35,40,45,50)
info3<-c(100,150,200,250,300,350,400,450,500)
floatRes1first<-c(0,0,0,0,0,0,0,0,0)
doubleRes1first<-c(0,0,0,0,0,0,0,0,0)
fractionRes1first<-c(0,0,0,0,1,1,2,3,4)
libraryRes1first<-c(0,0,0,0,0,0,0,0,0)
floatRes1second<-c(0,1,2,3,4,6,7,35,48)
doubleRes1second<-c(0,1,2,3,4,6,8,56,69)
libraryRes1second<-c(0,0,0,0,0,0,0,0,0)

floatRes2first<-c(0,0,0,1,1,2,4,7,12)
doubleRes2first<-c(0,0,0,1,2,2,4,7,12)
fractionRes2first<-c(0,1,2,3,5,7,11,16,22)
libraryRes2first<-c(0,0,0,0,0,0,0,0,0)
floatRes2second<-c(198,947,2956,7053,14559,25739,44729,63438,98928)
doubleRes2second<-c(201,968,3056,7203,14573,26412,45132,64434,116135)
libraryRes2second<-c(0,0,0,0,0,0,1,1,1)

floatRes3first<-c(0,2,2,2,3,5,7,12,19)
doubleRes3first<-c(0,2,2,2,3,5,8,14,19)
fractionRes3first<-c(12,37,112,291,710,1509,2790,5056,8255)
libraryRes3first<-c(0,0,0,0,0,0,0,0,0)
floatRes3second<-c(262,1210,3835,8798,17000,30893,55944,72325,100565)
doubleRes3second<-c(304,1218,3967,8903,17559,33063,57848,73930,117173)
libraryRes3second<-c(0,2,4,6,6,8,12,16,21)


par(mfrow=c(1,2))

plot(info2,floatRes1first,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "A * X",col="RED", pch = 19,ylim = c(0,6))
lines(info2,doubleRes1first,type="b",col="BLUE")
lines(info2,fractionRes1first,type="b",col="GREEN")
lines(info2,libraryRes1first,type="b")

plot(info3,floatRes1second,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "A * X",col="RED", pch = 19,ylim = c(0,70))
lines(info3,doubleRes1second,type="b",col="BLUE")
lines(info3,libraryRes1second,type="b")

plot(info2,floatRes2first,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "(A + B + C) * X",col="RED", pch = 19,ylim = c(0,25))
lines(info2,doubleRes2first,type="b",col="BLUE")
lines(info2,fractionRes2first,type="b",col="GREEN")
lines(info2,libraryRes2first,type="b")

plot(info3,floatRes2second,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "(A + B + C) * X",col="RED", pch = 19,ylim = c(0,117000))
lines(info3,doubleRes2second,type="b",col="BLUE")
lines(info3,libraryRes2second,type="b")

plot(info2,floatRes3first,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "A * (B * C)",col="RED", pch = 19,ylim = c(0,40))
lines(info2,doubleRes3first,type="b",col="BLUE")
lines(info2,fractionRes3first,type="b",col="GREEN")
lines(info2,libraryRes3first,type="b")

plot(info3,floatRes3second,xlab="Rozmiar macierzy", ylab="Czas w milisekundach",type="b",main = "A * (B * C)",col="RED", pch = 19,ylim = c(0,120000))
lines(info3,doubleRes3second,type="b",col="BLUE")
lines(info3,libraryRes3second,type="b")

# Operacje normy

calculateNormForVector<-function(vector){
  return(sum(abs(vector)))
}

calculateNormForMatrix<-function(matrix){
  lengthOfColumn<-sqrt(length(matrix))
  res<-c()
  for (i in 1:lengthOfColumn){
    a<-lengthOfColumn*(i-1)+1
    b<-lengthOfColumn*i
    res<-append(res,sum(abs(matrix[a:b])))
  }
  return(max(res))
}


floatRes1Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1float10.txt", header = FALSE, sep = "\t", dec = ".")
floatRes1Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1float20.txt", header = FALSE, sep = "\t", dec = ".")
floatRes1Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1float30.txt", header = FALSE, sep = "\t", dec = ".")
floatRes1Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1float40.txt", header = FALSE, sep = "\t", dec = ".")
floatRes1Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1float50.txt", header = FALSE, sep = "\t", dec = ".")

doubleRes1Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1double10.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes1Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1double20.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes1Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1double30.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes1Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1double40.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes1Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1double50.txt", header = FALSE, sep = "\t", dec = ".")

fractionRes1Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1fraction10.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes1Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1fraction20.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes1Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1fraction30.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes1Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1fraction40.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes1Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1fraction50.txt", header = FALSE, sep = "\t", dec = ".")

libraryRes1Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1library10.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes1Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1library20.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes1Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1library30.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes1Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1library40.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes1Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes1library50.txt", header = FALSE, sep = "\t", dec = ".")

floatRes2Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2float10.txt", header = FALSE, sep = "\t", dec = ".")
floatRes2Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2float20.txt", header = FALSE, sep = "\t", dec = ".")
floatRes2Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2float30.txt", header = FALSE, sep = "\t", dec = ".")
floatRes2Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2float40.txt", header = FALSE, sep = "\t", dec = ".")
floatRes2Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2float50.txt", header = FALSE, sep = "\t", dec = ".")

doubleRes2Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2double10.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes2Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2double20.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes2Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2double30.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes2Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2double40.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes2Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2double50.txt", header = FALSE, sep = "\t", dec = ".")

fractionRes2Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2fraction10.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes2Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2fraction20.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes2Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2fraction30.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes2Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2fraction40.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes2Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2fraction50.txt", header = FALSE, sep = "\t", dec = ".")

libraryRes2Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2library10.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes2Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2library20.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes2Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2library30.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes2Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2library40.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes2Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes2library50.txt", header = FALSE, sep = "\t", dec = ".")

floatRes3Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3float10.txt", header = FALSE, sep = "\t", dec = ".")
floatRes3Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3float20.txt", header = FALSE, sep = "\t", dec = ".")
floatRes3Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3float30.txt", header = FALSE, sep = "\t", dec = ".")
floatRes3Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3float40.txt", header = FALSE, sep = "\t", dec = ".")
floatRes3Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3float50.txt", header = FALSE, sep = "\t", dec = ".")

doubleRes3Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3double10.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes3Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3double20.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes3Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3double30.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes3Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3double40.txt", header = FALSE, sep = "\t", dec = ".")
doubleRes3Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3double50.txt", header = FALSE, sep = "\t", dec = ".")

fractionRes3Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3fraction10.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes3Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3fraction20.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes3Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3fraction30.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes3Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3fraction40.txt", header = FALSE, sep = "\t", dec = ".")
fractionRes3Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3fraction50.txt", header = FALSE, sep = "\t", dec = ".")

libraryRes3Values10<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3library10.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes3Values20<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3library20.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes3Values30<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3library30.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes3Values40<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3library40.txt", header = FALSE, sep = "\t", dec = ".")
libraryRes3Values50<-read.delim("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zadanie 2/results/matRes3library50.txt", header = FALSE, sep = "\t", dec = ".")



# A * X
abs(calculateNormForVector(fractionRes1Values10)-calculateNormForVector(floatRes1Values10))
abs(calculateNormForVector(fractionRes1Values10)-calculateNormForVector(doubleRes1Values10))
abs(calculateNormForVector(fractionRes1Values10)-calculateNormForVector(libraryRes1Values10))

abs(calculateNormForVector(fractionRes1Values20)-calculateNormForVector(floatRes1Values20))
abs(calculateNormForVector(fractionRes1Values20)-calculateNormForVector(doubleRes1Values20))
abs(calculateNormForVector(fractionRes1Values20)-calculateNormForVector(libraryRes1Values20))

abs(calculateNormForVector(fractionRes1Values30)-calculateNormForVector(floatRes1Values30))
abs(calculateNormForVector(fractionRes1Values30)-calculateNormForVector(doubleRes1Values30))
abs(calculateNormForVector(fractionRes1Values30)-calculateNormForVector(libraryRes1Values30))

abs(calculateNormForVector(fractionRes1Values40)-calculateNormForVector(floatRes1Values40))
abs(calculateNormForVector(fractionRes1Values40)-calculateNormForVector(doubleRes1Values40))
abs(calculateNormForVector(fractionRes1Values40)-calculateNormForVector(libraryRes1Values40))

abs(calculateNormForVector(fractionRes1Values50)-calculateNormForVector(floatRes1Values50))
abs(calculateNormForVector(fractionRes1Values50)-calculateNormForVector(doubleRes1Values50))
abs(calculateNormForVector(fractionRes1Values50)-calculateNormForVector(libraryRes1Values50))


# (A + B + C) * X
abs(calculateNormForVector(fractionRes2Values10)-calculateNormForVector(floatRes2Values10))
abs(calculateNormForVector(fractionRes2Values10)-calculateNormForVector(doubleRes2Values10))
abs(calculateNormForVector(fractionRes2Values10)-calculateNormForVector(libraryRes2Values10))

abs(calculateNormForVector(fractionRes2Values20)-calculateNormForVector(floatRes2Values20))
abs(calculateNormForVector(fractionRes2Values20)-calculateNormForVector(doubleRes2Values20))
abs(calculateNormForVector(fractionRes2Values20)-calculateNormForVector(libraryRes2Values20))

abs(calculateNormForVector(fractionRes2Values30)-calculateNormForVector(floatRes2Values30))
abs(calculateNormForVector(fractionRes2Values30)-calculateNormForVector(doubleRes2Values30))
abs(calculateNormForVector(fractionRes2Values30)-calculateNormForVector(libraryRes2Values30))

abs(calculateNormForVector(fractionRes2Values40)-calculateNormForVector(floatRes2Values40))
abs(calculateNormForVector(fractionRes2Values40)-calculateNormForVector(doubleRes2Values40))
abs(calculateNormForVector(fractionRes2Values40)-calculateNormForVector(libraryRes2Values40))

abs(calculateNormForVector(fractionRes2Values50)-calculateNormForVector(floatRes2Values50))
abs(calculateNormForVector(fractionRes2Values50)-calculateNormForVector(doubleRes2Values50))
abs(calculateNormForVector(fractionRes2Values50)-calculateNormForVector(libraryRes2Values50))


# A * (B * C)
abs(calculateNormForMatrix(fractionRes3Values10)-calculateNormForMatrix(floatRes3Values10))
abs(calculateNormForMatrix(fractionRes3Values10)-calculateNormForMatrix(doubleRes3Values10))
abs(calculateNormForMatrix(fractionRes3Values10)-calculateNormForMatrix(libraryRes3Values10))

abs(calculateNormForMatrix(fractionRes3Values20)-calculateNormForMatrix(floatRes3Values20))
abs(calculateNormForMatrix(fractionRes3Values20)-calculateNormForMatrix(doubleRes3Values20))
abs(calculateNormForMatrix(fractionRes3Values20)-calculateNormForMatrix(libraryRes3Values20))

abs(calculateNormForMatrix(fractionRes3Values30)-calculateNormForMatrix(floatRes3Values30))
abs(calculateNormForMatrix(fractionRes3Values30)-calculateNormForMatrix(doubleRes3Values30))
abs(calculateNormForMatrix(fractionRes3Values30)-calculateNormForMatrix(libraryRes3Values30))

abs(calculateNormForMatrix(fractionRes3Values40)-calculateNormForMatrix(floatRes3Values40))
abs(calculateNormForMatrix(fractionRes3Values40)-calculateNormForMatrix(doubleRes3Values40))
abs(calculateNormForMatrix(fractionRes3Values40)-calculateNormForMatrix(libraryRes3Values40))

abs(calculateNormForMatrix(fractionRes3Values50)-calculateNormForMatrix(floatRes3Values50))
abs(calculateNormForMatrix(fractionRes3Values50)-calculateNormForMatrix(doubleRes3Values50))
abs(calculateNormForMatrix(fractionRes3Values50)-calculateNormForMatrix(libraryRes3Values50))



