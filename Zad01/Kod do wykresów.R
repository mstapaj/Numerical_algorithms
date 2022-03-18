# dla windowsa
data <- read.csv("D:/Projekty/Projekty Java/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test.csv")
# dla linuxa
data <- read.csv("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test.csv")
data2 <- read.csv("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test2.csv")
data3 <- read.csv("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test3.csv")

View(data)
View(data2)
View(data3)

# funkcja dzieląca dane na zbiory po 10000 elementów i wyliczajaca z nich srednia
prepareAvg<-function(x){
  res<-c()
  for (i in 1:101){
    a<-10000*(i-1)+1
    b<-10000*i
    res<-append(res,mean(x[a:b]))
  }
  return(res)
}

# Oddzielne wykresy 
par(mfrow=c(1,1))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)),xlab = "Warto?ci argument?w", ylab="Warto?ci b?edu wzgl?dnego",type="l",col="RED",main = "R??nica mi?dzy sumowaniem element?w szeregu Taylora od pocz?tku, a wbudowan? funkcj? biblioteczn? ")
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)),xlab = "Warto?ci argument?w", ylab="Warto?ci b?edu wzgl?dnego",col="RED",type = "l",main = "R??nica mi?dzy sumowaniem element?w szeregu Taylora od ko?ca, a wbudowan? funkcj? biblioteczn? ")
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Warto?ci argument?w", ylab="Warto?ci b?edu wzgl?dnego",col="RED",type = "l",main = "R??nica mi?dzy sumowaniem element?w szeregu Taylora od pocz?tku, wyliczaj?c na podstawie poprzedniego wyrazu, a wbudowan? funkcj? biblioteczn? ")
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Warto?ci argument?w", ylab="Warto?ci b?edu wzgl?dnego",col="RED",type = "l",main = "R??nica mi?dzy sumowaniem element?w szeregu Taylora od ko?ca, wyliczaj?c na podstawie poprzedniego wyrazu, a wbudowan? funkcj? biblioteczn? ")

# Jeden duzy wykres, polaczany, taka sama os Y
par(mfrow=c(2,2))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",type="l",col="RED",main = "Sumowanie elementów od początku",ylim = c(0,0.00000015) )
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od końca",ylim = c(0,0.00000015))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od początku, wyliczając na podstawie poprzedniego wyrazu",ylim = c(0,0.00000015))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od końca, wyliczając na podstawie poprzedniego wyrazu",ylim = c(0,0.00000015))

# Jeden duzy wykres, polaczany, rożne wartości na osi Y
par(mfrow=c(2,2))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",type="l",col="RED",main = "Sumowanie elementów od początku")
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od końca")
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od początku, wyliczając na podstawie poprzedniego wyrazu")
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od końca, wyliczając na podstawie poprzedniego wyrazu")

# H1
par(mfrow=c(1,1))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",type="l",main = "Różnica między sumowaniem elementów szeregu Taylora od początku, a sumowaniem od końca ",col="BLUE")
lines(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)),col="RED",type = "l")
legend(x="topleft", legend=c("Sumowanie od początku", "Sumowanie od końca"),
       col=c("blue", "red"), lty=c(1,1),lwd = 2)

# H3
par(mfrow=c(1,2))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości róznicy błędów",type="l",col="RED",main = "Sumowanie elementów od początku")
abline(h=0)
mtext("Wyliczanie z wzoru",side=3)
mtext("Wyliczanie na podstawie poprzedniego", side=1)
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości róznicy błędów",col="RED",type = "l",main = "Sumowanie elementów od końca")
abline(h=0)
mtext("Wyliczanie z wzoru",side=3)
mtext("Wyliczanie na podstawie poprzedniego", side=1)

aboveZero<-function(x){
  pos<-0
  neg<-0
  for (i in x){
    if (!is.nan(i)){
      if (i > 0){
        pos<-pos+1
      } else if ( i < 0 ){
        neg<-neg+1
      }
    } 
  }
  return(c(neg,pos))
}

aboveZero(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych))
aboveZero(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych))


# Q1
par(mfrow=c(2,2))
plot(data2$Precyzja,abs((data2$Taylor_z_func_wbudowanych-data2$Taylor_od_lewej)/data2$Taylor_z_func_wbudowanych),xlab = "Ilość sumowanych składników", ylab="Wartości błedu względnego",type="l",col="RED",main = "Sumowanie elementów od początku")
plot(data2$Precyzja,abs((data2$Taylor_z_func_wbudowanych-data2$Taylor_od_prawej)/data2$Taylor_z_func_wbudowanych),xlab = "Ilość sumowanych składników", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od końca")
plot(data2$Precyzja,abs((data2$Taylor_z_func_wbudowanych-data2$Taylor_od_lewej_prev)/data2$Taylor_z_func_wbudowanych),xlab = "Ilość sumowanych składników", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od początku, wyliczając na podstawie poprzedniego wyrazu")
plot(data2$Precyzja,abs((data2$Taylor_z_func_wbudowanych-data2$Taylor_od_prawej_prev)/data2$Taylor_z_func_wbudowanych),xlab = "Ilość sumowanych składników", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od końca, wyliczając na podstawie poprzedniego wyrazu")

# Q2
par(mfrow=c(2,2))
plot(prepareAvg(data3$Kat),prepareAvg(data3$Taylor_od_lewej),xlab = "Wartości argumentów", ylab="Ilość zsumowanych elementów",type="l",col="RED",main = "Sumowanie elementów od początku")
plot(prepareAvg(data3$Kat),prepareAvg(data3$Taylor_od_prawej),xlab = "Wartości argumentów", ylab="Ilość zsumowanych elementów",col="RED",type = "l",main = "Sumowanie elementów od końca")
plot(prepareAvg(data3$Kat),prepareAvg(data3$Taylor_od_lewej_prev),xlab = "Wartości argumentów", ylab="Ilość zsumowanych elementów",col="RED",type = "l",main = "Sumowanie elementów od początku, wyliczając na podstawie poprzedniego wyrazu")
plot(prepareAvg(data3$Kat),prepareAvg(data3$Taylor_od_prawej_prev),xlab = "Wartości argumentów", ylab="Ilość zsumowanych elementów",col="RED",type = "l",main = "Sumowanie elementów od końca, wyliczając na podstawie poprzedniego wyrazu")
