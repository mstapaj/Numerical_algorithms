data <- read.csv("D:/Projekty/Projekty Java/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test.csv")
View(data)
class(data)

par(mfrow=c(1,1))
hist(data$Taylor_od_lewej,prob=T)

# sprawdzenie
plot(data$Kat,data$Taylor_od_lewej,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_od_prawej,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_od_lewej_prev,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_od_prawej_prev,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_z_func_wbudowanych,type="l",xlab="k¹t",ylab="wartoœæ")

# funkcja na indeks log
function(x){
  res<-c()
  for (i in seq(1:length((x)))){
    if (sqrt(i)%%1==0) {
      c<-append(res,i)
    }
  }
  return (res);
}


# ³¹czenie wykresów
plot(data$Kat,data$Taylor_od_lewej,type="l",xlab="k¹t",ylab="wartoœæ")
lines(data$Kat,data$Taylor_od_prawej,col="RED")


# Oddzielne wykresy 
par(mfrow=c(1,1))
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",type="l",col="RED",main = "Ró¿nica miêdzy sumowaniem elementów szeregu Taylora od pocz¹tku, a wbudowan¹ funkcj¹ biblioteczn¹ ")
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",col="RED",type = "l",main = "Ró¿nica miêdzy sumowaniem elementów szeregu Taylora od koñca, a wbudowan¹ funkcj¹ biblioteczn¹ ")
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",col="RED",type = "l",main = "Ró¿nica miêdzy sumowaniem elementów szeregu Taylora od pocz¹tku, wyliczaj¹c na podstawie poprzedniego wyrazu, a wbudowan¹ funkcj¹ biblioteczn¹ ")
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",col="RED",type = "l",main = "Ró¿nica miêdzy sumowaniem elementów szeregu Taylora od koñca, wyliczaj¹c na podstawie poprzedniego wyrazu, a wbudowan¹ funkcj¹ biblioteczn¹ ")


# Jeden duzy wykres, polaczany
par(mfrow=c(2,2))
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",type="l",col="RED",main = "Sumowanie elementów szeregu Taylora od pocz¹tku")
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",col="RED",type = "l",main = "Sumowanie elementów szeregu Taylora od koñca")
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",col="RED",type = "l",main = "Sumowanie elementów szeregu Taylora od pocz¹tku, wyliczaj¹c na podstawie poprzedniego wyrazu")
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",col="RED",type = "l",main = "Sumowanie elementów szeregu Taylora od koñca, wyliczaj¹c na podstawie poprzedniego wyrazu")


# H1
plot(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych),xlab = "Wartoœci argumentów", ylab="Wartoœci b³edu wzglêdnego",type="l",main = "Ró¿nica miêdzy sumowaniem elementów szeregu Taylora od pocz¹tku, a sumowaniem od koñca ",col="BLUE")
lines(data$Kat,abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych),col="RED",type = "l")
legend(x="topleft", legend=c("Sumowanie od pocz¹tku", "Sumowanie od koñca"),
       col=c("blue", "red"), lty=c(1,1),lwd = 2)
