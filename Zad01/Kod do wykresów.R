# dla windowsa
data <- read.csv("D:/Projekty/Projekty Java/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test.csv")
# dla linuxa
data <- read.csv("/home/mtx22/Pulpit/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test.csv")

View(data)
class(data)


# funkcja dzieląca dane na zbiory po 10000 elementów i wyliczajaca z nich srednia
prepareAvg<-function(x){
  res<-c()
  for (i in 2:102){
    a<-10000*(i-1)+1
    b<-10000*i
    res<-append(res,mean(x[a:b]))
  }
  return(res)
}

plot(prepareAvg(test_data), type = "l")
plot(prepareAvg(data$Kat))
plot(prepareAvg(data$Taylor_od_lewej), type='l')
plot(data$Taylor_od_lewej)


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
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",type="l",col="RED",main = "Sumowanie elementów od początku")
abline(h=0)
aboveZero(prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev)/data$Taylor_z_func_wbudowanych)))
plot(prepareAvg(data$Kat),prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych)),xlab = "Wartości argumentów", ylab="Wartości błedu względnego",col="RED",type = "l",main = "Sumowanie elementów od końca")
abline(h=0)
aboveZero(prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych)))

prepareAvg(abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej)/data$Taylor_z_func_wbudowanych)-abs((data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev)/data$Taylor_z_func_wbudowanych))

aboveZero<-function(x){
  pos<-0
  neg<-0
  for (i in x){
    if (i > 0){
      pos<-pos+1
    } else {
      neg<-neg+1
    }
  }
  return(c(neg,pos))
}


