data <- read.csv("D:/Projekty/Projekty Java/Algorytmy numeryczne/Algorytmy_numeryczne/Zad01/test.csv")
View(data)
class(data)

par(mfrow=c(1,1))
hist(data$Taylor_od_lewej,prob=T)


plot(data$Kat,data$Taylor_od_lewej,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_od_prawej,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_od_lewej_prev,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_od_prawej_prev,type="l",xlab="k¹t",ylab="wartoœæ")
plot(data$Kat,data$Taylor_z_func_wbudowanych,type="l",xlab="k¹t",ylab="wartoœæ")

plot(data$Kat,data$Taylor_od_lewej,type="l",xlab="k¹t",ylab="wartoœæ")
lines(data$Kat,data$Taylor_od_prawej,col="RED")

plot(data$Kat,data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej,type = "l",xlab = "Argument", ylab="B³¹d")
lines(data$Kat,data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej,col="RED")
lines(data$Kat,data$Taylor_z_func_wbudowanych-data$Taylor_od_lewej_prev,col="GREEN")
lines(data$Kat,data$Taylor_z_func_wbudowanych-data$Taylor_od_prawej_prev,col="BLUE")

